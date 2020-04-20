package com.skillbox.blog.service;

import com.skillbox.blog.entity.User;
import com.skillbox.blog.entity.enums.Role;
import com.skillbox.blog.repository.UserRepository;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

  UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User user = userRepository
        .findByEmail(email)
        .orElseThrow(() -> new UsernameNotFoundException("No user with such email: " + email));
    List<Role> authorities = new ArrayList<>();
    if (user.getIsModerator() == 1) {
      authorities.add(Role.MODERATOR);
    }
    authorities.add(Role.USER);
    user.setAuthorities(authorities);
    return user;
  }

  public User getCurrentUser() {
    Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    if (user instanceof User) {
      return userRepository.findById(((User) user).getId());
    } else {
      throw new AuthenticationCredentialsNotFoundException("Session does not exist");
    }

  }

  public User getModerator(boolean isMultiUserMode) {
    User cu = getCurrentUser();
    
    if (isMultiUserMode) {
      List<User> moderators = userRepository.findByIsModerator((byte) 1);
      moderators.remove(cu);
      return moderators.get(new Random().nextInt(moderators.size()));
    }
    else {
      return cu;
    }
  }

  public boolean isModerator() {
    return SecurityContextHolder.getContext()
        .getAuthentication().getAuthorities().contains(Role.MODERATOR);
  }
}
