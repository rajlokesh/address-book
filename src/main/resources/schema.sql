CREATE TABLE ORGANIZATION
(
    ORGANIZATION_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    NAME           VARCHAR(64) NOT NULL UNIQUE,
    ADDRESS        VARCHAR(64),
    PHONE          VARCHAR(24)
);

CREATE TABLE USER_ENTITY
(
    USER_ID    BIGINT AUTO_INCREMENT PRIMARY KEY,
    FIRST_NAME VARCHAR(64),
    LAST_NAME  VARCHAR(64),
    EMAIL     VARCHAR(64) NOT NULL UNIQUE,
    ADDRESS   VARCHAR(64),
    PHONE     VARCHAR(24)
);

CREATE TABLE ASSOCIATION
(
    ASSOCIATION_ID  BIGINT AUTO_INCREMENT PRIMARY KEY,
    USER_ID         BIGINT NOT NULL,
    ORGANIZATION_ID BIGINT NOT NULL
);

ALTER TABLE ASSOCIATION
    ADD FOREIGN KEY (USER_ID) REFERENCES USER_ENTITY (USER_ID);
ALTER TABLE ASSOCIATION
    ADD FOREIGN KEY (ORGANIZATION_ID) REFERENCES ORGANIZATION (ORGANIZATION_ID);
ALTER TABLE ASSOCIATION
    ADD CONSTRAINT UNIQUE_ASSOCIATION UNIQUE (USER_ID, ORGANIZATION_ID);
