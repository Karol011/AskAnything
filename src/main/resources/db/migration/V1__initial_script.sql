CREATE TABLE  user
(
    user_id  BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name     VARCHAR(30)                       NOT NULL,
    email    VARCHAR(50)                       NOT NULL,
    password VARCHAR(60)
);

CREATE TABLE category
(
    category_id     BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name            VARCHAR(60)                       NOT NULL,
    parent_category VARCHAR(30)
);

CREATE TABLE question
(
    question_id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    text        VARCHAR(500)                      NOT NULL,
    date        DATE,
    user_id     BIGINT,
    FOREIGN KEY (user_id)
        REFERENCES user (user_id)
);

CREATE TABLE response
(
    response_id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    response    VARCHAR(500)                      NOT NULL,
    question_id BIGINT,
    date        DATE,
    rating      INT,
    FOREIGN KEY (question_id)
        REFERENCES question (question_id)
);

CREATE TABLE comment_to_response
(
    comment_to_response_id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    text                   VARCHAR(500)                      NOT NULL,
    commentator_id         BIGINT,
    response_id            BIGINT,
    date                   DATE,
    FOREIGN KEY (commentator_id)
        REFERENCES user (user_id),
    FOREIGN KEY (response_id)
        REFERENCES response (response_id)

);