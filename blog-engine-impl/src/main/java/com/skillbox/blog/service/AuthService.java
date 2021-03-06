package com.skillbox.blog.service;

import com.skillbox.blog.config.Mail;
import com.skillbox.blog.config.security.SecurityConstants;
import com.skillbox.blog.config.security.jwt.JwtProvider;
import com.skillbox.blog.dto.request.RequestPasswordDto;
import com.skillbox.blog.dto.request.RequestPwdRestoreDto;
import com.skillbox.blog.dto.request.RequestUserDto;
import com.skillbox.blog.dto.response.ResponseCaptchaDto;
import com.skillbox.blog.dto.response.ResponseLoginDto;
import com.skillbox.blog.dto.response.ResponseResults;
import com.skillbox.blog.entity.CaptchaCode;
import com.skillbox.blog.entity.User;
import com.skillbox.blog.exception.InvalidAttributeException;
import com.skillbox.blog.exception.InvalidCaptchaException;
import com.skillbox.blog.mapper.CaptchaToCaptchaDto;
import com.skillbox.blog.mapper.UserDtoToUser;
import com.skillbox.blog.mapper.UserToResponseLoginDto;
import com.skillbox.blog.repository.CaptchaRepository;
import com.skillbox.blog.repository.UserRepository;
import com.skillbox.blog.utils.RandomStringGenerator;
import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Map;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.patchca.color.SingleColorFactory;
import org.patchca.filter.predefined.CurvesRippleFilterFactory;
import org.patchca.font.RandomFontFactory;
import org.patchca.service.ConfigurableCaptchaService;
import org.patchca.utils.encoder.EncoderHelper;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class AuthService {

  private static final String DEFAULT_USERPIC = "/default-1.png";
  private static final String DATA_PREFIX = "data:image/png;base64,";

  private static final String PWD_RESTORE_MAIL = "Hello, %1$s!%n"
      + "Please follow the next link to restore pwd:%n"
      + "%2$s%n%n"
      + "/r Awesome blog team";

  private static final String LINK_EXPIRED_MSG =
      "Ссылка для восстановления пароля устарела.\n" +
          "<a href=/auth/restore>Запросить ссылку снова</a>";

  private UserRepository userRepository;
  private UserService userService;
  private CaptchaRepository captchaRepository;
  private CaptchaToCaptchaDto captchaToCaptchaDto;
  private UserDtoToUser userDtoToUser;
  private UserToResponseLoginDto userToResponseLoginDto;
  private MailService mailServer;
  private PasswordEncoder passwordEncoder;

  public ResponseResults registerNewUser(RequestUserDto dto) {
    String captchaCodeBySecret = captchaRepository.findCaptchaCodeBySecret(dto.getCaptchaSecret());

    if (captchaCodeBySecret == null) {
      throw new InvalidAttributeException(Map.of("captcha", "Wrong captcha code entered"));
    } else {
      validateCaptcha(dto.getCaptcha(), captchaCodeBySecret);
    }
    if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
      throw new InvalidAttributeException(Map.of("email", "Email address already registered"));
    }
    dto.setPassword(passwordEncoder.encode(dto.getPassword()));
    User user = userDtoToUser.map(dto);

    if (dto.getName() != null && !dto.getName().isEmpty()) {
      user.setName(dto.getName());
    } else {
      user.setName(dto.getEmail());
    }

    user.setPhoto(DEFAULT_USERPIC);
    userRepository.save(user);
    return new ResponseResults()
        .setResult(true);
  }

  public ResponseCaptchaDto genAndSaveCaptcha() {
    ConfigurableCaptchaService cs = new ConfigurableCaptchaService();
    cs.setWidth(100);
    cs.setFontFactory(new RandomFontFactory(30, new String[]{"Verdana"}));
    cs.setColorFactory(new SingleColorFactory(new Color(25, 60, 170)));
    cs.setFilterFactory(new CurvesRippleFilterFactory(cs.getColorFactory()));

    CaptchaCode captchaCode;
    try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
      String plainCode = EncoderHelper.getChallangeAndWriteImage(cs, "png", byteArrayOutputStream);
      String encodeCode =
          DATA_PREFIX + Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
      captchaCode =
          new CaptchaCode()
              .setCode(plainCode)
              .setSecretCode(RandomStringGenerator.randomString(10))
              .setTime(LocalDateTime.now());
      captchaRepository.save(captchaCode);
      return captchaToCaptchaDto.map(captchaCode).setImage(encodeCode);
    } catch (IOException e) {
      throw new InvalidCaptchaException("Cannot generate captcha");
    }
  }

  @Transactional(readOnly = true)
  public ResponseLoginDto checkAuth(HttpServletRequest request, Principal principal) {
    if (principal == null) {
      throw new AuthenticationCredentialsNotFoundException(
          "Session does not exist: " + request.getHeader("Cookie"));
    }
    return new ResponseLoginDto()
        .setUser(userToResponseLoginDto.map(userService.getCurrentUser()))
        .setResult(true);
  }

  public ResponseResults restorePassword(RequestPwdRestoreDto dto, String host) {
    User user = userRepository.findByEmail(dto.getEmail())
        .orElseThrow(() -> new AuthenticationCredentialsNotFoundException(
            "There is no such user " + dto.getEmail()));
    user.setCode(JwtProvider.createToken() + SecurityConstants.SUFFIX);
    userRepository.save(user);
    mailServer.sendMail(
        new Mail(
            "noreply",
            dto.getEmail(),
            "Password restoration",
            String.format(
                PWD_RESTORE_MAIL,
                user.getName(),
                "http://" + host + "/login/change-password/" + user.getCode()
            )
        )
    );
    return new ResponseResults().setResult(true);
  }

  public ResponseResults changePassword(RequestPasswordDto dto) {
    if (!JwtProvider.validateToken(dto.getCode())) {
      throw new InvalidAttributeException(Map.of("code", LINK_EXPIRED_MSG));
    }
    User user = userRepository.findByCode(dto.getCode())
        .orElseThrow(EntityNotFoundException::new);
    String captchaCodeBySecret = captchaRepository.findCaptchaCodeBySecret(dto.getCaptchaSecret());
    if (captchaCodeBySecret != null) {
      validateCaptcha(dto.getCaptcha(), captchaCodeBySecret);
      user.setPassword(passwordEncoder.encode(dto.getPassword()));
      userRepository.save(user);
      return new ResponseResults().setResult(true);
    }
    throw new InvalidCaptchaException("captcha argument exception");
  }


  private void validateCaptcha(String entered, String actual) {
    if (!entered.equals(actual)) {
      throw new InvalidCaptchaException("Wrong captcha");
    }
  }
}
