--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2
-- Dumped by pg_dump version 12.2

-- Started on 2020-04-12 15:33:46

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2937 (class 1262 OID 24720)
-- Name: sklbx; Type: DATABASE; Schema: -; Owner: postgres
--

--\connect sklbx

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 5 (class 2615 OID 24721)
-- Name:  Type: SCHEMA; Schema: -; Owner: postgres
--

--DROP SCHEMA IF EXISTS CASCADE;

--CREATE SCHEMA 

--ALTER SCHEMA OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

SET search_path TO test;

--
-- TOC entry 207 (class 1259 OID 41545)
-- Name: blog_user; Type: TABLE; Schema:  Owner: postgres
--

--CREATE TABLE blog_user (
--    id serial,
--    code character varying(255),
--    e_mail character varying(255) NOT NULL,
--    is_moderator smallint NOT NULL,
--    name character varying(255) NOT NULL,
--    password character varying(255) NOT NULL,
--    photo character varying(2048),
--    reg_time timestamp without time zone NOT NULL
--);
--
--ALTER TABLE blog_user OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 41543)
-- Name: blog_user_id_seq; Type: SEQUENCE; Schema:  Owner: postgres
--

--
-- TOC entry 209 (class 1259 OID 41556)
-- Name: captcha_code; Type: TABLE; Schema:  Owner: postgres
--

--CREATE TABLE captcha_code (
--    id serial,
--    code character varying(255) NOT NULL,
--    secret_code text NOT NULL,
--    "time" timestamp without time zone NOT NULL
--);

-- Dependencies: 208
-- Name: captcha_code_id_seq; Type: SEQUENCE OWNED BY; Schema:  Owner: postgres
--

--
-- TOC entry 205 (class 1259 OID 41537)
-- Name: databasechangelog; Type: TABLE; Schema:  Owner: postgres
--

-- TOC entry 211 (class 1259 OID 41567)
-- Name: global_setting; Type: TABLE; Schema:  Owner: postgres
--

--CREATE TABLE global_setting (
--    id serial,
--    code character varying(255) NOT NULL,
--    name character varying(255) NOT NULL,
--    value character varying(255) NOT NULL
--);
--
--ALTER TABLE global_setting OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 41565)
-- Name: global_setting_id_seq; Type: SEQUENCE; Schema:  Owner: postgres
--

--
-- TOC entry 213 (class 1259 OID 41578)
-- Name: post; Type: TABLE; Schema:  Owner: postgres
--

--CREATE TABLE post (
--    id serial,
--    is_active smallint DEFAULT 1 NOT NULL,
--    moderation_status character varying(255) NOT NULL,
--    text text NOT NULL,
--    "time" timestamp without time zone NOT NULL,
--    title character varying(255) NOT NULL,
--    view_count integer NOT NULL,
--    moderator_id integer NOT NULL,
--    user_id integer NOT NULL
--);
--
--ALTER TABLE post OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 41607)
-- Name: post2tag; Type: TABLE; Schema:  Owner: postgres
--

--CREATE TABLE post2tag (
--    post_id integer NOT NULL,
--    tag_id integer NOT NULL
--);
--
--ALTER TABLE post2tag OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 41590)
-- Name: post_comment; Type: TABLE; Schema:  Owner: postgres
--

--CREATE TABLE post_comment (
--    id serial,
--    text character varying(2048),
--    "time" timestamp without time zone,
--    parent_id integer,
--    post_id integer NOT NULL,
--    user_id integer
--);
--
--ALTER TABLE post_comment OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 41588)
-- Name: post_comment_id_seq; Type: SEQUENCE; Schema:  Owner: postgres
--

--
-- TOC entry 212 (class 1259 OID 41576)
-- Name: post_id_seq; Type: SEQUENCE; Schema:  Owner: postgres
--

--
-- TOC entry 217 (class 1259 OID 41601)
-- Name: post_vote; Type: TABLE; Schema:  Owner: postgres
--

--CREATE TABLE post_vote (
--    id serial,
--    "time" timestamp without time zone NOT NULL,
--    value smallint NOT NULL,
--    post_id integer NOT NULL,
--    user_id integer NOT NULL
--);
--
--ALTER TABLE post_vote OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 41599)
-- Name: post_vote_id_seq; Type: SEQUENCE; Schema:  Owner: postgres
--

--
-- TOC entry 220 (class 1259 OID 41614)
-- Name: tag; Type: TABLE; Schema:  Owner: postgres
--

--CREATE TABLE tag (
--    id serial,
--    name character varying(255)
--);
--
--
--ALTER TABLE tag OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 41612)
-- Name: tag_id_seq; Type: SEQUENCE; Schema:  Owner: postgres
--

--
-- TOC entry 2743 (class 2604 OID 41548)
-- Name: blog_user id; Type: DEFAULT; Schema:  Owner: postgres
--

-- TOC entry 2918 (class 0 OID 41545)
-- Dependencies: 207
-- Data for Name: blog_user; Type: TABLE DATA; Schema:  Owner: postgres
--

INSERT INTO test.blog_user (code, e_mail, is_moderator, name, password, photo, reg_time) VALUES ('o2juKq', 'admin@skillbox.ru', 1, 'Admin', '$2y$12$ZG7zRx2p7rp.75krYLBh4OtsmnObJD1IUwsVREHScZN5uUQXH6MPy', '/default-1.png', '2019-01-01 12:00:00');
INSERT INTO test.blog_user (code, e_mail, is_moderator, name, password, photo, reg_time) VALUES ('tar2a3e', 'tarakan@mail.ru', 1, '6IX9INE', '$2y$12$Tahyiryn/VaFm/yJr709Mu1OP8qKEqxIUAdtQVPDk76c18Hv7CAoG', '/default-1.png', '2020-01-01 19:00:00');
INSERT INTO test.blog_user (code, e_mail, is_moderator, name, password, photo, reg_time) VALUES ('hl8q93', 'wayne@gmail.com', 0, 'Lil Wayne', '$2y$12$Tahyiryn/VaFm/yJr709Mu1OP8qKEqxIUAdtQVPDk76c18Hv7CAoG', '/default-1.png', '2018-02-09 19:00:00');
INSERT INTO test.blog_user (code, e_mail, is_moderator, name, password, photo, reg_time) VALUES ('nc0kq2', 'peep@gmail.com', 0, 'Lil Peep', '$2y$12$Tahyiryn/VaFm/yJr709Mu1OP8qKEqxIUAdtQVPDk76c18Hv7CAoG', '/default-1.png', '2018-05-07 19:00:00');
INSERT INTO test.blog_user (code, e_mail, is_moderator, name, password, photo, reg_time) VALUES ('b8qn0z', 'pump@gmail.com', 0, 'Lil Pump', '$2y$12$Tahyiryn/VaFm/yJr709Mu1OP8qKEqxIUAdtQVPDk76c18Hv7CAoG', '/default-1.png', '2019-03-08 19:00:00');
INSERT INTO test.blog_user (code, e_mail, is_moderator, name, password, photo, reg_time) VALUES ('n4fjq3', 'blueface@gmail.com', 0, 'Blueface', '$2y$12$Tahyiryn/VaFm/yJr709Mu1OP8qKEqxIUAdtQVPDk76c18Hv7CAoG', '/default-1.png', '2020-01-01 19:00:00');

--
-- TOC entry 2920 (class 0 OID 41556)
-- Dependencies: 209
-- Data for Name: captcha_code; Type: TABLE DATA; Schema:  Owner: postgres
--

--
-- TOC entry 2916 (class 0 OID 41537)
-- Dependencies: 205
-- Data for Name: databasechangelog; Type: TABLE DATA; Schema:  Owner: postgres
--

--
-- TOC entry 2915 (class 0 OID 41532)
-- Dependencies: 204
-- Data for Name: databasechangeloglock; Type: TABLE DATA; Schema:  Owner: postgres
--

--
-- TOC entry 2922 (class 0 OID 41567)
-- Dependencies: 211
-- Data for Name: global_setting; Type: TABLE DATA; Schema:  Owner: postgres
--

INSERT INTO test.global_setting (code, name, value) VALUES ('MULTIUSER_MODE', 'Многопользовательский режим', 'NO');
INSERT INTO test.global_setting (code, name, value) VALUES ('POST_PREMODERATION', 'Премодерация постов', 'YES');
INSERT INTO test.global_setting (code, name, value) VALUES ('STATISTICS_IS_PUBLIC', 'Показывать всем статистику блога', 'NO');

--
-- TOC entry 2924 (class 0 OID 41578)
-- Dependencies: 213
-- Data for Name: post; Type: TABLE DATA; Schema:  Owner: postgres
--

INSERT INTO test.tag (name) VALUES ('Spring');
INSERT INTO test.tag (name) VALUES ('Java');
INSERT INTO test.tag (name) VALUES ('Hibernate');
INSERT INTO test.tag (name) VALUES ('SQL');
INSERT INTO test.tag (name) VALUES ('Collections');
INSERT INTO test.tag (name) VALUES ('Core');

INSERT INTO post (is_active, moderation_status, text, "time", title, view_count, moderator_id, user_id) VALUES (1, 'ACCEPTED', 'Я помню ту ночь.  Я — один из ведущих хранителей слов. И это не пустые слова. Мой запас составлял порядка четырехсот тысяч. Согласитесь, неплохо. Пользоваться ими нужно было осторожно. Словно редкие животные: многие любили тишину. И чуть что, сбрасывали с себя остатки смысла, оставляя вас в ничего не значащей мешанине букв. Особенно редчайшие слова. Давно вышедшие из употребления, о которых приходилось  заботиться, были настолько хрупкие, что некоторые я боялся разрушить одним произнесением, самим их звучанием. Но той ночью все было иначе.', '2018-01-03 15:30:00', 'Рассказ №1', 5, 1, 1);
INSERT INTO post (is_active, moderation_status, text, "time", title, view_count, moderator_id, user_id) VALUES (1, 'ACCEPTED', 'Не в состоянии понять, что творится, я старался повторять за ним, возвращая слова на полку своей памяти. Но напрасно. Стоило ему что-то произнести, как оно тут же таяло. Испарялось полностью. Все что он говорил. Это касалось не только редких слов. Вообще всех слов. Серьезность, ситуация, договор, благотворительность. Исчезало все: исчезла дружба, исчезла помощь, исчезли люди. Остались пустые оболочки в портсигаре, с которого я не спускал глаз. Моя черепная коробочка лежала, набитая пустотой, на ладони у незнакомца. Я со всех сил сжал голову руками. Незнакомец не унимался. Смысл слов, их связь с остальными, контекст, вырезался его тонкими острыми губами. ', '2019-01-02 16:30:00', 'Рассказ №6', 7, 1, 1);
INSERT INTO post (is_active, moderation_status, text, "time", title, view_count, moderator_id, user_id) VALUES (1, 'ACCEPTED', 'Он не стал дожидаться приглашения, вошел, и направился в комнату. Словно всегда жил в этой квартире. Не успел я опомниться, как незнакомец сбросил вещи с табурета и сел, — это то, как нас называют, —  вырвал лист из моего блокнота, попробовал писать на нем моей ручкой, не вышло, потряс ее, не вышло, выкинул, достал свою и написал несколько букв. Это слово не было мне знакомо. Или я просто не мог сосредоточиться.', '2018-09-17 16:30:00', 'Рассказ №3', 9, 1, 3);
INSERT INTO post (is_active, moderation_status, text, "time", title, view_count, moderator_id, user_id) VALUES (1, 'ACCEPTED', 'И он снова заговорил. Его речь напоминала бессмысленный набор слов, однако, вскоре я заметил нечто странное. Мне становилось легче. Что-то происходило в голове. Я прислушался. И со страхом осознал, что незнакомец произносил мои собственные слова. Те, что я, словно драгоценность, прятал глубоко внутри себя. По одному складывал в коробочку, для утоления ее жажды. Их этот человек бесцеремонно бросал мне прямо в лицо, хлестал голосовыми связками, крушил, давил своим языком. ', '2018-12-18 16:30:00', 'Рассказ №5', 6, 1, 5);
INSERT INTO post (is_active, moderation_status, text, "time", title, view_count, moderator_id, user_id) VALUES (1, 'ACCEPTED', 'И когда он, наконец, добрался до самого главного, это было уже слишком! Чуть только он произнес «коробочка», как внутри меня что-то вывернулось наизнанку. Я кинулся на своего ночного гостя со всей силой, что мог собрать в теле. Я бросился на него, метя в лицо. Пытаясь заткнуть ему рот своей рукой, головой, хоть чем. Спасти ее. Спасти ее! Но тот лихо увернулся, и я оказался на полу. Тогда я попытался закрыть себе уши. Но он видимо был готов и к этому, скрутил мне руки за спиной.', '2019-09-04 16:30:00', 'Рассказ №7', 8, 1, 2);
INSERT INTO post (is_active, moderation_status, text, "time", title, view_count, moderator_id, user_id) VALUES (1, 'ACCEPTED', 'У меня место в партере. Я знал этот спектакль наизусть. Знал, что скажут актеры, что ответят им из оркестровой ямы. Режиссеру я доверял: за последний год он один не позволял актерам отсебятины, каждая постановка была точной копией предыдущей. Я сидел там же где и всегда: третий ряд, пятое кресло. — Вы видите это? Даже предсказуемый театр полон неожиданностей. Рядом со мной села молодая девушка. К этому сложно привыкнуть. Люди не понимают, что тот же спектакль не будет тем же, если зрители в зале постоянно меняются.', '2019-09-17 16:30:00', 'Рассказ №8', 12, 1, 3);
INSERT INTO post (is_active, moderation_status, text, "time", title, view_count, moderator_id, user_id) VALUES (1, 'ACCEPTED', 'Я вновь растерялся, это начинало бесить. — Скажите прямо, чего вы хотите. — А я сразу поняла, что вы хам. Знаете что, хам, вы будете слушать, а я говорить? Ясно? — Ясно. Не ясно. — Я вижу, вам не ясно. Вы будете слушать, а я говорить. От волнения я хлопнул глазами. — Итак, вон там на сцене, видите?', '2019-12-30 16:30:00', 'Рассказ №11', 8, 1, 1);
INSERT INTO post (is_active, moderation_status, text, "time", title, view_count, moderator_id, user_id) VALUES (1, 'ACCEPTED', 'Но девушка не унималась: — Да не это, вот это. Мое тело задергалось во все стороны по очереди. Начало, как и полагается, с севера. — Что же вы вертитесь. Сядьте ровно. — Не говорите так со мной, мы не в школе. — Нет. Да. Не важно. Не важно, где мы. Посмотрите на это, — и она вытянула свой длинный палец, чтобы ткнуть им в пространство, загородив мне обзор сцены. У нее был красивый розовый лак. — Да не на палец.', '2019-10-23 16:30:00', 'Рассказ №10', 12, 1, 5);
INSERT INTO post (is_active, moderation_status, text, "time", title, view_count, moderator_id, user_id) VALUES (1, 'ACCEPTED', 'На улице — дождь. В кинотеатре было сухо. Там, прикованные к своим креслам, зрители участвовали в тридцатом кино-марафоне. Официанты едва успевали заносить еду и убирать отходы. — Никто не выходил? — Выходят либо в первый день, либо никогда. Я бы на вашем месте шел домой. — А что дома? Раньше, Рая была жива, хоть что-то. — Как хотите, — и охранник отвернулся. Ему самому хотелось в зал. Но посещать марафоны охранникам запрещено. — А со стороны обычная коробка. — Что? — Ничего. Коробка, люди сидят и смотрят то, чего нет. — Шаг назад, за ленточку, ждите своей очереди, — взъерошился охранник. Еще чего, «обычная коробка». Так и шел бы себе домой. Нет, с кем приходится иметь дело. ', '2020-01-01 16:30:00', 'Рассказ №13', 9, 1, 3);
INSERT INTO post (is_active, moderation_status, text, "time", title, view_count, moderator_id, user_id) VALUES (1, 'ACCEPTED', 'Загорелся зеленый огонек, это значило «запускай следующего». И никого не пришлось уговаривать — словно спринтер человек из очереди сорвался с места. Пришел его черед. Годы ожидания, пыток жизнью, придали ему сил. Хотя никто не мешал, он мчался, словно продирался сквозь чащу, к желанной двери. С разбега навалился на ее, но за мгновение до касания, дверь распахнулась сама, и человек провалился в темноту коробочки. — А ведь это мог быть я, — завопила очередь. — Назад! — Ну а сами? Сами то вы! Разве вам не хочется? — Хочется! Очень хочется! – подумал охранник, если бы не хотелось, я бы вас всех давно пропустил. ', '2020-02-05 16:30:00', 'Рассказ №14', 9, 1, 4);
INSERT INTO post (is_active, moderation_status, text, "time", title, view_count, moderator_id, user_id) VALUES (1, 'ACCEPTED', 'Однажды ему повезло. Заболел один из официантов, нужно было подменить. Это значило, ему позволено войти внутрь. Его предупредили, что оставаться внутри запрещено. Он согласился. Подписал документы, что с момента пребывания в коробочке, отказывается от своей собственности. Возможно, ее потом вернут. Таков был регламент. После полугодового тренинга подписал еще бумаги. И, наконец, толкнул дверь, вошел. В кинотеатре было сухо. Сотни людей, прикованные к своим креслам, не мигая смотрели на экран. — Вон тот. — Что? — Вон тот. Можно убирать.', '2020-03-07 16:30:00', 'Рассказ №15', 12, 1, 5);
INSERT INTO post (is_active, moderation_status, text, "time", title, view_count, moderator_id, user_id) VALUES (1, 'ACCEPTED', 'Вместе с другим официантом они обхватили мертвого зрителя под локти и потащили из зала. Миллионы тел смотрели на экран. Нечеловеческие живцы. Чем больше расплывались их тела, тем привлекательнее становился их взгляд.  Нужно было решать. Это был последний шанс. И он бросив тело, исчез в темноте. Прокрался на дальний ряд. Стащил с места какую-то бабу, уселся в кресле. — Эй, мое кресло, мое кресло – сипела она на полу, не в силах подняться. — Заткнись! — лягнул бабу ногой, и та затихла.', '2020-03-08 16:30:00', 'Рассказ №16', 15, 1, 1);
INSERT INTO post (is_active, moderation_status, text, "time", title, view_count, moderator_id, user_id) VALUES (1, 'DECLINED', 'Умереть можно по-разному. Мой дед умер от старости. Я помню его плохо, другое дело сам момент исчезновения. Кресло где он сидел стало вдруг пустым. Словно дедушка куда-то вышел. Со временем пустота меня стала раздражать, я все чаще замечал, что сижу в его кресле: hier liegt der Dust der Abbildlichkeit, doch er stirbt nicht. И действительно. Самостоятельное коронарное шунтирование в пятнадцать, первая пересадка сердца в двадцать три. Я опережал время, словно не начинал свою, а продолжал чью-то другую карьеру с середины. Отец как-то сказал: if you could seen further it is by schmending on the shoulders of giants. И все чаще в семье отмечали мое сходство с дедом. Это льстило и мешало.', '2020-03-22 16:30:00', 'Рассказ №21', 0, 1, 1);
INSERT INTO post (is_active, moderation_status, text, "time", title, view_count, moderator_id, user_id) VALUES (1, 'ACCEPTED', 'Он смотрел кино, ему нравилось. Он мечтал жить и умереть здесь, перед экраном. Все было сладко. Так сладко. Сироп. Сироп вливался в его глаза, сироп втекал через трубку в рот, сироп он высерал в трубку через зад. Сироп тек по его венам. Там, за пределами кинотеатра, была ненастоящая жизнь, с ее серостью, неполноценностью, бесцельностью, настоящее было здесь! Туда он больше не вернется. Вставать по утрам, искать свое отражение в каждом зеркале, бесследно ходить из дома на работу и опять домой. Ну уж нет. Он больше не охранник. Теперь сироп его судьба. Он больше не охранник! Он..', '2020-03-12 16:30:00', 'Рассказ №18', 11, 1, 3);
INSERT INTO post (is_active, moderation_status, text, "time", title, view_count, moderator_id, user_id) VALUES (1, 'ACCEPTED', 'Ежегодно миллиарды участвовали в марафоне. Они заходили в темное жерло коробочки, и больше не появлялись. Все они были счастливцами. Но не он. Отброс общества. Отныне он не мог и мечтать о кинотеатре, очередь угрожала ему, завидев из далека, а если он приближался, то била. Кино для него закончилось, остался шрам: легкий привкус сиропа во рту. Этот привкус бывший охранник старался запивать водкой, хотя та совсем не походила на сироп.', '2020-03-16 16:30:00', 'Рассказ №19', 18, 1, 4);
INSERT INTO post (is_active, moderation_status, text, "time", title, view_count, moderator_id, user_id) VALUES (1, 'ACCEPTED', 'По-настоящему я родился, когда умер мой дед. У него была большая седая борода и скальпель. Он был хирургом. Его, впоследствии мой, скальпель казался мне чем-то магическим. Вокруг же все было обычным. Мой дядя был военным, отец выбрал путь инженера, как позже и мой сын. В нашей семье от тлеющего угля загоралась ветошь.', '2020-03-18 16:30:00', 'Рассказ №20', 4, 1, 5);
INSERT INTO post (is_active, moderation_status, text, "time", title, view_count, moderator_id, user_id) VALUES (1, 'NEW', 'У меня никогда не было выбора. Профессия выбрала меня сама. В 17 лет меня позвал к себе ПА. Павел Александрович, великий российский хирург. Неизвестность сделала его директором больницы. Директором мог стать Иван Петрович Павлов. Но ПА повезло. Главным образом потому, что Павлова занимали собаки. Сообщество врачей ценит талант тем, что старается избавиться от него побыстрей. ИП списали в сумасбродные старики. Директором стал незаметный ПА. Просто повезло. Повезло и мне.', '2020-03-28 16:30:00', 'Рассказ №22', 0, NULL, 2);
INSERT INTO post (is_active, moderation_status, text, "time", title, view_count, moderator_id, user_id) VALUES (1, 'ACCEPTED', 'Уснуть не удавалось. Которую ночь вся мыслительная деятельность сводилась к одному и тому же. Я лежал на тахте и тщательно подбирал слова, в надежде, что они сработают. Нужно было нечто среднее, между теми, что мне было не жалко отдать, и теми, что возымеют эффект. Я подбирал слова и, одно за другим, опускал их в коробочку. Но казалось, ее ничто не могло заткнуть. Она была бездонна. И так каждую ночь.', '2018-04-07 16:30:00', 'Рассказ №2', 7, 1, 2);
INSERT INTO post (is_active, moderation_status, text, "time", title, view_count, moderator_id, user_id) VALUES (1, 'ACCEPTED', 'Я не слушал. Моя голова, мое сердце, не принадлежали мне. Все было в коробочке. Она сводила с ума. Еженощно она тревожила, не давала спать, нападала. Дада, она нападала, а я защищался. Всей силой своего интеллекта, всеми четырьмястами тысячами пытался угомонить эту коробочку. Одно за другим я отправлял свои надежды, инкрустированные словами, в ее всепоглощающий зев. Мне было страшно представить что будет, когда закончатся слова. И тут вдруг она оказалась снаружи, лежала на ладони этого незнакомца, похожая на небольшой портсигар.', '2018-10-30 16:30:00', 'Рассказ №4', 14, 1, 4);
INSERT INTO post (is_active, moderation_status, text, "time", title, view_count, moderator_id, user_id) VALUES (1, 'ACCEPTED', 'Что я должен был видеть. Изо дня в день я старался жить рутинно, тратил на это силы, уставал. Я стремился к тому, от чего обычно бежали. Все те, кто жаловался на однообразие, но ленился быть не собой; жаловался на скуку, но презирал собственное желание; несся в будущее спиной вперед.  — Куда вы смотрите? Да при чем здесь ваша спина? — ее голос вернул меня в театр. — Не знаю. Спина — единственное, где очевидное сложно разглядеть, — попытался я отшутиться. — Да вот же, на сцене. — Ах это? Да, мой любимый спектакль,— до чего ж она глупа, — я вообще люблю этого режиссера.', '2019-09-20 16:30:00', 'Рассказ №9', 6, 1, 4);
INSERT INTO post (is_active, moderation_status, text, "time", title, view_count, moderator_id, user_id) VALUES (1, 'ACCEPTED', 'Я пригляделся. Сцена показалась совершенно обычной. Как вдруг справа, там где кончались декорации, возникло нечто похожее на коробочку. Оно появилось и сразу стало расти. Сперва мелкое, — коробочка увеличивалась, стала крупнее, — размером с чемодан, больше, со шкаф, еще больше, дом, огромный, город, крупный, с трубами, заводами, домами, реками, озерами, морями, страна, океанами, облаками, горами, планета. Меня поглощало нечто колоссальное. Так быстро, что я даже не испугался. Паника и страх схватили меня позже и будто впервые: как два незнакомца, они тянули за руки в разные стороны, и грудная клетка расходилась все шире и шире. Тело хватало воздух ртом.', '2020-07-09 16:30:00', 'Рассказ №12', 2, 1, 2);
INSERT INTO post (is_active, moderation_status, text, "time", title, view_count, moderator_id, user_id) VALUES (1, 'NEW', 'Если вам кажется бессмертие даром, вы должно быть давно не жили. Про себя скажу, что меня никогда не мучили вопросы чужого психического состояния, ими у нас занимался Зиги. Я занимался только телом. Коконом, если хотите. Я поклялся ПА, что в наших стенах этот больной не умрет, даже если мне придется отдать ему часть своих органов (что я, конечно, не собирался делать). И потому был довольно встревожен ночным звонком ПА. Помню, мне ужасно хотелось спать, когда позвонил ПА и попросил спуститься в операционную.', '2020-07-09 16:30:00', 'Рассказ №25', 0, NULL, 5);
INSERT INTO post (is_active, moderation_status, text, "time", title, view_count, moderator_id, user_id) VALUES (1, 'ACCEPTED', 'Так он и сидел. Это была не реальность. Намного лучше. Сперва казалось приторно. Сильные, мощные люди, такие как он сам, брали верх, а мерзкие, подлые неудачники, оставались ни с чем. Но затем, он приспособился, как в калейдоскопе перед глазами замаячили картинки. Черное против красного. Кресты против звезд. Глухие против немых. День шел за днем. Фильм шел за фильмом. Подносили еду, убирали отходы. Его тело обмякло, лицо стало походить на водянистую кашу. — Слышь? А ты разве не из этих? Оборачиваться не было сил. — Ты ж охранник. — Заткнись! — Да ладно, я свой. Тоже не могу без этого. Но и подыхать тут, как в скотобойне, не собираюсь. В чем твоя идея? — Заткнись.', '2020-03-10 16:30:00', 'Рассказ №17', 6, 1, 2);
INSERT INTO post (is_active, moderation_status, text, "time", title, view_count, moderator_id, user_id) VALUES (1, 'NEW', 'Нет смысла описывать весь мой путь. Скажу лишь, что кроме меня, претендентов на наследники ПА было не так уж много. Со временем не должно было остаться совсем. У меня никогда не было выбора. Как любимый ученик ПА, я имел ряд льгот. Одной их них было право выбирать больных самому. Не скрою, я часто делал это ориентируясь на размеры кошелька. Я не был склонен делить людей на рассы, на группы, классы. Голышом, обтянутые лишь кожей, на операционном столе, они все были одинаково. Тело уравнивало всех. Поэтому кого лечить мне было все равно. Кошелек задавал некоторое направление.', '2020-03-28 16:30:00', 'Рассказ №23', 0, NULL, 3);
INSERT INTO post (is_active, moderation_status, text, "time", title, view_count, moderator_id, user_id) VALUES (1, 'NEW', 'И все же был среди больных некто особенный. Отличный от остальных. Не просто богатый и баснословно богатый больной, потомок Ротшильдов. Но действительно другой, не равный остальным. Truebe mensch. Никогда ранее не видел я такого человека. В котором сочеталась бы даже не искусство, но история всей медицины. Чье тело состояло бы из кусков, порой разных столетий. Сшитый словно Голлум раби Баль-Шема, этот Франкенфеллер, был чем-то напоминающим мечту и кошмар. Это был трехсотшестидесятилетний старик. С новым сердцем, молодыми ногами, несколько дряблой кожей, недавно смененной печенью. Старик, рожденный в одной из прошлых эпох, без перспективы умереть в любой из последующих. Триста лет медицина поддерживала ему жизнь, меня орган за органом. Он отличался от остальных.', '2020-07-06 16:30:00', 'Рассказ №24', 0, NULL, 4);
INSERT INTO post (is_active, moderation_status, text, "time", title, view_count, moderator_id, user_id) VALUES (1, 'NEW', 'Если вам кажется бессмертие даром, вы должно быть давно не жили. Про себя скажу, что меня никогда не мучили вопросы чужого психического состояния, ими у нас занимался Зиги. Я занимался только телом. Коконом, если хотите. Я поклялся ПА, что в наших стенах этот больной не умрет, даже если мне придется отдать ему часть своих органов (что я, конечно, не собирался делать). И потому был довольно встревожен ночным звонком ПА. Помню, мне ужасно хотелось спать, когда позвонил ПА и попросил спуститься в операционную.', '2020-01-01 16:30:00', 'Рассказ №25', 0, NULL, 1);
INSERT INTO post (is_active, moderation_status, text, "time", title, view_count, moderator_id, user_id) VALUES (1, 'ACCEPTED', 'Через пару недель я уехал отдыхать и к физике больше не возвращался. Можно сказать, умер для науки. А вот люди на кафедре живут до сих пор. Пишут работы, принимают экзамены, стирают с доски пыль. Амбиции — это, конечно, хорошо', '2020-01-01 16:30:00', 'Рассказ №26',  0, 1, 1);
INSERT INTO post (is_active, moderation_status, text, "time", title, view_count, moderator_id, user_id) VALUES (1, 'ACCEPTED', 'Если можно освоить физику за три года, то каково хрена делают все эти люди на кафедре. Стоит серьезно поработать года три и можно отдохнуть как следует. Через два года я буду умнее 90% тех, кто занимается этой наукой. На этой неделе я занимался: 7,5 часов сегодня, 8,2 часа вчера, прошлую неделю по 7,7 (в среднем). Темп задан, цель ясна.', '2020-01-01 16:30:00', 'Рассказ №27',  0, 1, 1);
INSERT INTO post (is_active, moderation_status, text, "time", title, view_count, moderator_id, user_id) VALUES (1, 'ACCEPTED', 'Я сидел и считал. Если за один день прочесть 10 страниц, то всю книгу — можно за две недели. Чтобы закрепить квантовую электродинамику понадобится книги три-четыре. То есть месяца два. Пусть три. Занимаясь часов по 8 часов в сутки можно освоить программу за год. Пусть два. Три.', '2020-01-01 16:30:00', 'Рассказ №28',  0, 1, 1);
INSERT INTO post (is_active, moderation_status, text, "time", title, view_count, moderator_id, user_id) VALUES (1, 'ACCEPTED', 'Впервые вступая в офис вдохните и выдохните несколько раз. Как перед глубоким погружением. Если у вас вместо башки — батискаф, стенки выдержат и вы достигните дна, чтобы когда-нибудь потом всплыть на поверхность в одном из собственных кабинетов.', '2020-01-01 16:30:00', 'Рассказ №29',  0, 1, 1);
INSERT INTO post (is_active, moderation_status, text, "time", title, view_count, moderator_id, user_id) VALUES (1, 'ACCEPTED', 'Когда-нибудь человек увидит в другом себя. Как говорит один мой друг: увидит и о*уеет. А пока от рабства нас отделяет закорючка в конституции. При таком раскладе, офис — это достижение. Там хоть все и механизмы, как минимум не все бесполезны. А редкие моменты дней рождений возвращают людям на миг черты чего-то человеческого. Надеюсь вам также трудно даются эти моменты как и мне.', '2020-01-01 16:30:00', 'Рассказ №30',  0, 1, 1);
INSERT INTO post (is_active, moderation_status, text, "time", title, view_count, moderator_id, user_id) VALUES (1, 'ACCEPTED', 'Мне трудно понимать людей. А делать так, как они просят — еще сложнее. Другое дело — офис. В нем все меняется. На горизонте маячит общее благо. Офис напоминает социализм в отдельно взятом бизнес-центре. Коллективизация, при которой твой степлер тебе не принадлежит, но это и не нужно. Те, кто воровал степлер, знаю, что дома он теряет всю магию и превращается в ненужный хлам.', '2020-01-01 16:30:00', 'Рассказ №31',  0, 1, 1);
INSERT INTO post (is_active, moderation_status, text, "time", title, view_count, moderator_id, user_id) VALUES (1, 'ACCEPTED', 'Люди разные. Увидеть каждого — нужно усилие. Они притворяются что обладают ценой (зарплатой), притворяются что обладают знанием (квалификацией) и притворяются, что в жизни хотят только одного (результата). За каждым пиджаком бьется сердце, и стук сердец разнес бы мои барабанные перепонки, если бы не офис, где каждый — функция.', '2020-01-01 16:30:00', 'Рассказ №32',  0, 1, 1);
INSERT INTO post (is_active, moderation_status, text, "time", title, view_count, moderator_id, user_id) VALUES (1, 'ACCEPTED', 'Скажите, сколько вам платят и я скажу где вы. Вы на земле. В НАСА сейчас выбирают людей, которые полетят на марс. Так вот они полетят от нас. Эти люди готовы жить нигде, лишь бы не с нами. Лишь бы не открывать глаза в нашем офисе, не просить одних и не отвечать на просьбы других. Они тешут себя мыслью, что там их никто не достанет. Они просто не знакомы с нашим офисом, он весь нацелен на результат. Мы до них и на марсе доберемся.', '2020-01-01 16:30:00', 'Рассказ №33',  0, 1, 1);
INSERT INTO post (is_active, moderation_status, text, "time", title, view_count, moderator_id, user_id) VALUES (1, 'ACCEPTED', 'Надежда парит в воздухе. Стоит обонянию уловить ее запах, как расширяется грудь. Ребра расходятся, легкие разворачиваются, хочется вдохнуть. Хочется дышать. Но дышать нечем. Надежда — не про кислород. И я вижу как задыхается мое поколение, в тщетной надежде еще отстоять мечты своей юности. Задыхается в красивой агонии нескольких проектов. В частности «Фейсбук». Но это уже не про надежду. Надышать такой проект, как «Фейсбук» — не имеет с надеждой ничего общего.', '2020-01-01 16:30:00', 'Рассказ №34',  0, 1, 1);
INSERT INTO post (is_active, moderation_status, text, "time", title, view_count, moderator_id, user_id) VALUES (1, 'ACCEPTED', 'Мне легче, чем многим — с самого детства у меня заложен нос. Я не чувствую ни запахи, ни веяния. Оттого и странный эффект запаздывания моей жизни. Мне до сих пор непривычно слово «гаджет», а его уже никто не использует. Однако вакуум, нечувствительность к запахам, заставляет по особому относиться к тем из них, что я все-таки уловил. Их несколько, каждый дорог мне.', '2020-01-01 16:30:00', 'Рассказ №35',  0, 1, 1);
INSERT INTO post (is_active, moderation_status, text, "time", title, view_count, moderator_id, user_id) VALUES (1, 'ACCEPTED', 'Это запах человека, которого я люблю. Это запах скошенной травы. Запах леса после дождя. Это запах родительского дома. И запах новой книги. Запах хлеба. По неизвестной мне причине, запах жетона метро. Да и все. В этом коротком, почти пошлом списке на самом деле не хватает одного. Нет, не миллионов, не бесконечности, этому списку не хватает только одного. Но я его не помню.', '2020-01-01 16:30:00', 'Рассказ №36',  0, 1, 1);

--
-- TOC entry 2929 (class 0 OID 41607)
-- Dependencies: 218
-- Data for Name: post2tag; Type: TABLE DATA; Schema:  Owner: postgres
--

INSERT INTO post2tag (post_id, tag_id) VALUES (1, 1);
INSERT INTO post2tag (post_id, tag_id) VALUES (1, 2);
INSERT INTO post2tag (post_id, tag_id) VALUES (2, 2);
INSERT INTO post2tag (post_id, tag_id) VALUES (3, 3);
INSERT INTO post2tag (post_id, tag_id) VALUES (4, 4);
INSERT INTO post2tag (post_id, tag_id) VALUES (5, 5);
INSERT INTO post2tag (post_id, tag_id) VALUES (6, 6);
INSERT INTO post2tag (post_id, tag_id) VALUES (7, 1);
INSERT INTO post2tag (post_id, tag_id) VALUES (8, 2);
INSERT INTO post2tag (post_id, tag_id) VALUES (9, 3);
INSERT INTO post2tag (post_id, tag_id) VALUES (10, 4);
INSERT INTO post2tag (post_id, tag_id) VALUES (11, 5);
INSERT INTO post2tag (post_id, tag_id) VALUES (12, 6);
INSERT INTO post2tag (post_id, tag_id) VALUES (13, 6);
INSERT INTO post2tag (post_id, tag_id) VALUES (14, 1);
INSERT INTO post2tag (post_id, tag_id) VALUES (15, 3);
INSERT INTO post2tag (post_id, tag_id) VALUES (16, 2);
INSERT INTO post2tag (post_id, tag_id) VALUES (17, 4);
INSERT INTO post2tag (post_id, tag_id) VALUES (18, 5);
INSERT INTO post2tag (post_id, tag_id) VALUES (19, 1);
INSERT INTO post2tag (post_id, tag_id) VALUES (20, 2);
INSERT INTO post2tag (post_id, tag_id) VALUES (20, 5);
INSERT INTO post2tag (post_id, tag_id) VALUES (21, 3);
INSERT INTO post2tag (post_id, tag_id) VALUES (22, 4);
INSERT INTO post2tag (post_id, tag_id) VALUES (23, 6);
INSERT INTO post2tag (post_id, tag_id) VALUES (24, 2);
INSERT INTO post2tag (post_id, tag_id) VALUES (25, 5);
INSERT INTO post2tag (post_id, tag_id) VALUES (26, 3);
INSERT INTO post2tag (post_id, tag_id) VALUES (27, 5);
INSERT INTO post2tag (post_id, tag_id) VALUES (28, 1);
INSERT INTO post2tag (post_id, tag_id) VALUES (29, 4);
INSERT INTO post2tag (post_id, tag_id) VALUES (29, 5);
INSERT INTO post2tag (post_id, tag_id) VALUES (30, 5);
INSERT INTO post2tag (post_id, tag_id) VALUES (31, 2);
INSERT INTO post2tag (post_id, tag_id) VALUES (31, 5);
INSERT INTO post2tag (post_id, tag_id) VALUES (32, 5);
INSERT INTO post2tag (post_id, tag_id) VALUES (32, 2);
INSERT INTO post2tag (post_id, tag_id) VALUES (33, 1);
INSERT INTO post2tag (post_id, tag_id) VALUES (34, 5);
INSERT INTO post2tag (post_id, tag_id) VALUES (35, 4);
INSERT INTO post2tag (post_id, tag_id) VALUES (35, 2);
INSERT INTO post2tag (post_id, tag_id) VALUES (36, 2);
INSERT INTO post2tag (post_id, tag_id) VALUES (36, 4);

--
-- TOC entry 2926 (class 0 OID 41590)
-- Dependencies: 215
-- Data for Name: post_comment; Type: TABLE DATA; Schema:  Owner: postgres
--

INSERT INTO test.post_comment (text, "time", parent_id, post_id, user_id) VALUES ('Я принялся гладить кусок.', '2020-02-12 16:00:00', NULL, 1, 1);
INSERT INTO test.post_comment (text, "time", parent_id, post_id, user_id) VALUES ('А когда устал, положил его на пол перед собой. В зале было очень тихо.', '2020-03-03 16:00:00', NULL, 2, 2);
INSERT INTO test.post_comment (text, "time", parent_id, post_id, user_id) VALUES ('Вот как здесь. Готов? Раз, два, поехали. ', '2020-02-02 18:00:00', NULL, 3, 3);
INSERT INTO test.post_comment (text, "time", parent_id, post_id, user_id) VALUES ('А вы сами как думаете?', '2020-01-02 17:00:00', NULL, 4, 4);
INSERT INTO test.post_comment (text, "time", parent_id, post_id, user_id) VALUES ('Ну ты ж блять.', '2020-01-01 18:00:00', NULL, 5, 5);
INSERT INTO test.post_comment (text, "time", parent_id, post_id, user_id) VALUES ('Подай-ка мне кастет. Счас я сделаю нам пенсию. ', '2020-03-02 17:00:00', NULL, 6, 1);
INSERT INTO test.post_comment (text, "time", parent_id, post_id, user_id) VALUES ('Че он творит?', '2020-01-03 18:00:00', NULL, 7, 2);
INSERT INTO test.post_comment (text, "time", parent_id, post_id, user_id) VALUES ('В комнате было тихо.', '2020-03-03 18:00:00', NULL, 8, 3);
INSERT INTO test.post_comment (text, "time", parent_id, post_id, user_id) VALUES ('Она плоская.', '2020-03-03 12:00:00', NULL, 9, 4);
INSERT INTO test.post_comment (text, "time", parent_id, post_id, user_id) VALUES ( 'Хотите сходить с ума — пожалуйста.', '2020-02-02 14:00:00', NULL, 10, 5);
INSERT INTO test.post_comment (text, "time", parent_id, post_id, user_id) VALUES ( 'Эту бумагу Галилео видел ранее.', '2020-01-01 17:00:00', NULL, 11, 1);
INSERT INTO test.post_comment (text, "time", parent_id, post_id, user_id) VALUES ( 'Люди не готовы к вашим словам.', '2020-02-02 18:00:00', NULL, 12, 2);
INSERT INTO test.post_comment (text, "time", parent_id, post_id, user_id) VALUES ( 'Наука мертва. Она не интегрирует даже любовь, она не интегрирует ничего из психики человека.', '2020-03-03 19:00:00', NULL, 13, 3);
INSERT INTO test.post_comment (text, "time", parent_id, post_id, user_id) VALUES ( 'Это верно. Не можете. Вы твердолобый. Идете до конца. Я вас прекрасно понимаю.', '2020-01-02 17:00:00', NULL, 14, 4);
INSERT INTO test.post_comment (text, "time", parent_id, post_id, user_id) VALUES ( 'Я был давно не молод, когда решился войти в тайгу. Мне говорили, что тайга умеет жить. Это было важно. Мне хотелось жить. ', '2020-03-01 17:00:00', NULL, 15, 5);
INSERT INTO test.post_comment (text, "time", parent_id, post_id, user_id) VALUES ( 'Мне казалось, что сон длился долго.', '2020-03-01 17:00:00', NULL, 16, 1);
INSERT INTO test.post_comment (text, "time", parent_id, post_id, user_id) VALUES ( 'Назавтра предстоял тяжелый маршрут. Как и любой инструмент, тело нуждалось в отдыхе.', '2020-02-01 11:00:00', NULL, 17, 2);
INSERT INTO test.post_comment (text, "time", parent_id, post_id, user_id) VALUES ( 'Возможно стоило выйти подышать. Но я не решался. ', '2020-03-01 17:00:00', NULL, 18, 3);
INSERT INTO test.post_comment (text, "time", parent_id, post_id, user_id) VALUES ( 'Все мы пробовали шоколадный зефир.', '2020-08-01 17:00:00', NULL, 19, 4);
INSERT INTO test.post_comment (text, "time", parent_id, post_id, user_id) VALUES ( 'Вам никогда не казалось, что все вокруг нереально?', '2020-07-01 17:00:00', NULL, 20, 5);
INSERT INTO test.post_comment (text, "time", parent_id, post_id, user_id) VALUES ( 'Мир, в котором мы жили до 20 века, проверить было просто. Сам проверяющий был иным. В те бесконечно далекие от нас времена, сто пятьдесят лет назад, человек и его окружение калибровались одной фигурой — королем. Король стоял во главе иерархии. Над ним был только Бог.', '2020-03-01 17:00:00', NULL, 21, 1);
INSERT INTO test.post_comment (text, "time", parent_id, post_id, user_id) VALUES ( 'Сегодня любой гражданин Европы может жить по-королевски. То есть быть хозяином своей судьбы. Любой гражданин — сам себе король.', '2020-01-01 17:00:00', NULL, 22, 2);
INSERT INTO test.post_comment (text, "time", parent_id, post_id, user_id) VALUES ( 'Если двигаться за мыслью Бодрийяра со скоростью глазного яблока, можно не успеть. ', '2020-03-01 18:00:00', NULL, 23, 3);
INSERT INTO test.post_comment (text, "time", parent_id, post_id, user_id) VALUES ( 'Последние годы переполнены терактами.', '2020-08-01 17:00:00', NULL, 24, 4);
INSERT INTO test.post_comment (text, "time", parent_id, post_id, user_id) VALUES ( 'За окном тьма черная, кое-где болтаются огоньки.', '2020-03-01 17:00:00', NULL, 25, 5);
INSERT INTO test.post_comment (text, "time", parent_id, post_id, user_id) VALUES ( 'Вместе с другим официантом они обхватили мертвого зрителя под локти и потащили из зала.', '2020-03-03 16:00:00', NULL, 2, 1);

--
-- TOC entry 2928 (class 0 OID 41601)
-- Dependencies: 217
-- Data for Name: post_vote; Type: TABLE DATA; Schema:  Owner: postgres
--

INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ('2020-02-12 16:00:00', 1, 1, 1);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ('2020-02-12 16:00:00', 1, 2, 2);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ('2020-02-12 16:00:00', 1, 3, 3);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ('2020-02-12 16:00:00', 1, 4, 4);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ('2020-02-12 16:00:00', 1, 5, 5);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ('2020-02-12 16:00:00', 1, 6, 1);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ('2020-02-12 16:00:00', 1, 7, 2);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ('2020-02-12 16:00:00', 1, 8, 3);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ('2020-02-12 16:00:00', 1, 9, 4);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', 1, 10, 5);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', 1, 11, 1);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', 1, 12, 2);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', 1, 13, 3);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', 1, 14, 4);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', 1, 15, 5);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', 1, 16, 1);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', 1, 17, 2);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', 1, 18, 3);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', 1, 19, 4);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', 1, 20, 5);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', 1, 21, 1);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', 1, 22, 2);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', 1, 23, 3);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', 1, 24, 4);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', 1, 25, 5);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', -1, 25, 1);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', -1, 24, 2);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', -1, 23, 3);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', -1, 22, 4);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', -1, 21, 5);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', -1, 20, 1);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', -1, 19, 2);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', -1, 18, 3);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', -1, 17, 4);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', -1, 16, 5);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', -1, 15, 1);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', -1, 14, 2);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', -1, 13, 1);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', -1, 12, 4);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', -1, 11, 5);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', -1, 10, 1);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', -1, 9, 2);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', -1, 8, 3);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', -1, 7, 4);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', -1, 6, 5);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', -1, 5, 1);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', -1, 4, 2);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', -1, 3, 3);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', -1, 2, 4);
INSERT INTO test.post_vote ("time", value, post_id, user_id) VALUES ( '2020-02-12 16:00:00', -1, 1, 5);

--
-- TOC entry 2931 (class 0 OID 41614)
-- Dependencies: 220
-- Data for Name: tag; Type: TABLE DATA; Schema:  Owner: postgres
--


--
-- TOC entry 2945 (class 0 OID 0)
-- Dependencies: 206
-- Name: blog_user_id_seq; Type: SEQUENCE SET; Schema:  Owner: postgres
--
--
-- TOC entry 2777 (class 2606 OID 41675)
-- Name: tag const_name; Type: CONSTRAINT; Schema:  Owner: postgres
--

--ALTER TABLE ONLY tag
--    ADD CONSTRAINT const_name UNIQUE (name);
--
----
---- TOC entry 2754 (class 2606 OID 41553)
---- Name: blog_user pk_blog_user; Type: CONSTRAINT; Schema:  Owner: postgres
----
--
--ALTER TABLE ONLY blog_user
--    ADD CONSTRAINT pk_blog_user PRIMARY KEY (id);
--
----
---- TOC entry 2756 (class 2606 OID 41564)
---- Name: captcha_code pk_captcha_code; Type: CONSTRAINT; Schema:  Owner: postgres
----
--
--ALTER TABLE ONLY captcha_code
--    ADD CONSTRAINT pk_captcha_code PRIMARY KEY (id);
--
----
---- TOC entry 2752 (class 2606 OID 41536)
---- Name: databasechangeloglock pk_databasechangeloglock; Type: CONSTRAINT; Schema:  Owner: postgres
----
--
----
---- TOC entry 2758 (class 2606 OID 41575)
---- Name: global_setting pk_global_setting; Type: CONSTRAINT; Schema:  Owner: postgres
----
--
--ALTER TABLE ONLY global_setting
--    ADD CONSTRAINT pk_global_setting PRIMARY KEY (id);
--
----
---- TOC entry 2762 (class 2606 OID 41587)
---- Name: post pk_post; Type: CONSTRAINT; Schema:  Owner: postgres
----
--
--ALTER TABLE ONLY post
--    ADD CONSTRAINT pk_post PRIMARY KEY (id);
--
----
---- TOC entry 2775 (class 2606 OID 41611)
---- Name: post2tag pk_post2tag; Type: CONSTRAINT; Schema:  Owner: postgres
----
--
--ALTER TABLE ONLY post2tag
--    ADD CONSTRAINT pk_post2tag PRIMARY KEY (post_id, tag_id);
--
----
---- TOC entry 2767 (class 2606 OID 41598)
---- Name: post_comment pk_post_comment; Type: CONSTRAINT; Schema:  Owner: postgres
----
--
--ALTER TABLE ONLY post_comment
--    ADD CONSTRAINT pk_post_comment PRIMARY KEY (id);
--
----
---- TOC entry 2771 (class 2606 OID 41606)
---- Name: post_vote pk_post_vote; Type: CONSTRAINT; Schema:  Owner: postgres
----
--
--ALTER TABLE ONLY post_vote
--    ADD CONSTRAINT pk_post_vote PRIMARY KEY (id);
--
----
---- TOC entry 2779 (class 2606 OID 41619)
---- Name: tag pk_tag; Type: CONSTRAINT; Schema:  Owner: postgres
----
--
--ALTER TABLE ONLY tag
--    ADD CONSTRAINT pk_tag PRIMARY KEY (id);
--
----
---- TOC entry 2772 (class 1259 OID 41662)
---- Name: fk_post2tag_post_id; Type: INDEX; Schema:  Owner: postgres
----
--
--CREATE INDEX fk_post2tag_post_id ON post2tag USING btree (post_id);
--
----
---- TOC entry 2773 (class 1259 OID 41663)
---- Name: fk_post2tag_tag_id; Type: INDEX; Schema:  Owner: postgres
----
--
--CREATE INDEX fk_post2tag_tag_id ON post2tag USING btree (tag_id);
--
----
---- TOC entry 2763 (class 1259 OID 41633)
---- Name: fk_post_comment_parent_id; Type: INDEX; Schema:  Owner: postgres
----
--
--CREATE INDEX fk_post_comment_parent_id ON post_comment USING btree (parent_id);
--
----
---- TOC entry 2764 (class 1259 OID 41632)
---- Name: fk_post_comment_post_id; Type: INDEX; Schema:  Owner: postgres
----
--
--CREATE INDEX fk_post_comment_post_id ON post_comment USING btree (post_id);
--
----
---- TOC entry 2765 (class 1259 OID 41634)
---- Name: fk_post_comment_user_id; Type: INDEX; Schema:  Owner: postgres
----
--
--CREATE INDEX fk_post_comment_user_id ON post_comment USING btree (user_id);
--
----
---- TOC entry 2759 (class 1259 OID 41620)
---- Name: fk_post_moderator_id; Type: INDEX; Schema:  Owner: postgres
----
--
--CREATE INDEX fk_post_moderator_id ON post USING btree (moderator_id);
--
----
---- TOC entry 2760 (class 1259 OID 41621)
---- Name: fk_post_user_id; Type: INDEX; Schema:  Owner: postgres
----
--
--CREATE INDEX fk_post_user_id ON post USING btree (user_id);
--
----
---- TOC entry 2768 (class 1259 OID 41650)
---- Name: fk_post_vote_post_id; Type: INDEX; Schema:  Owner: postgres
----
--
--CREATE INDEX fk_post_vote_post_id ON post_vote USING btree (post_id);
--
----
---- TOC entry 2769 (class 1259 OID 41651)
---- Name: fk_post_vote_user_id; Type: INDEX; Schema:  Owner: postgres
----
--
--CREATE INDEX fk_post_vote_user_id ON post_vote USING btree (user_id);
--
----
---- TOC entry 2788 (class 2606 OID 41669)
---- Name: post2tag fk_post2tag_dst_tag_id; Type: FK CONSTRAINT; Schema:  Owner: postgres
----
--
--ALTER TABLE ONLY post2tag
--    ADD CONSTRAINT fk_post2tag_dst_tag_id FOREIGN KEY (tag_id) REFERENCES tag(id);
--
----
---- TOC entry 2787 (class 2606 OID 41664)
---- Name: post2tag fk_post2tag_post_id; Type: FK CONSTRAINT; Schema:  Owner: postgres
----
--
--ALTER TABLE ONLY post2tag
--    ADD CONSTRAINT fk_post2tag_post_id FOREIGN KEY (post_id) REFERENCES post(id);
--
----
---- TOC entry 2783 (class 2606 OID 41640)
---- Name: post_comment fk_post_comment_parent_id; Type: FK CONSTRAINT; Schema:  Owner: postgres
----
--
--ALTER TABLE ONLY post_comment
--    ADD CONSTRAINT fk_post_comment_parent_id FOREIGN KEY (parent_id) REFERENCES post_comment(id);
--
----
---- TOC entry 2782 (class 2606 OID 41635)
---- Name: post_comment fk_post_comment_post_id; Type: FK CONSTRAINT; Schema:  Owner: postgres
----
--
--ALTER TABLE ONLY post_comment
--    ADD CONSTRAINT fk_post_comment_post_id FOREIGN KEY (post_id) REFERENCES post(id);
--
----
---- TOC entry 2784 (class 2606 OID 41645)
---- Name: post_comment fk_post_comment_user_id; Type: FK CONSTRAINT; Schema:  Owner: postgres
----
--
--ALTER TABLE ONLY post_comment
--    ADD CONSTRAINT fk_post_comment_user_id FOREIGN KEY (user_id) REFERENCES blog_user(id);
--
----
---- TOC entry 2780 (class 2606 OID 41622)
---- Name: post fk_post_moderator_id; Type: FK CONSTRAINT; Schema:  Owner: postgres
----
--
--ALTER TABLE ONLY post
--    ADD CONSTRAINT fk_post_moderator_id FOREIGN KEY (moderator_id) REFERENCES blog_user(id);
--
----
---- TOC entry 2781 (class 2606 OID 41627)
---- Name: post fk_post_user_id; Type: FK CONSTRAINT; Schema:  Owner: postgres
----
--
--ALTER TABLE ONLY post
--    ADD CONSTRAINT fk_post_user_id FOREIGN KEY (user_id) REFERENCES blog_user(id);
--
----
---- TOC entry 2785 (class 2606 OID 41652)
---- Name: post_vote fk_post_vote_post_id; Type: FK CONSTRAINT; Schema:  Owner: postgres
----
--
--ALTER TABLE ONLY post_vote
--    ADD CONSTRAINT fk_post_vote_post_id FOREIGN KEY (post_id) REFERENCES post(id);
--
----
---- TOC entry 2786 (class 2606 OID 41657)
---- Name: post_vote fk_post_vote_user_id; Type: FK CONSTRAINT; Schema:  Owner: postgres
----
--
--ALTER TABLE ONLY post_vote
--    ADD CONSTRAINT fk_post_vote_user_id FOREIGN KEY (user_id) REFERENCES blog_user(id);
--
---- Completed on 2020-04-12 15:33:46
--
----
---- PostgreSQL database dump complete
----
