DROP TABLE IF EXISTS user;

CREATE TABLE user
(
    `id`    varchar(36) NOT NULL primary key,
    `name`  varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `email` varchar(40) NOT NULL
) CHARSET=utf8;


INSERT INTO user
VALUES (UUID(), 'anônimo um', 'anonimoUm@gmail.com');
INSERT INTO user
VALUES (UUID(), 'anônimo dois', 'anonimoDois@gmail.com');
INSERT INTO user
VALUES (UUID(), 'anônimo três', 'anonimoTres@gmail.com');
INSERT INTO user
VALUES (UUID(),
        'anônimo quatro', 'anonimoQuatro@gmail.com');
