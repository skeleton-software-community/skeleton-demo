-- create table --
CREATE TABLE COUNTRY
(
id SMALLINT,
CODE VARCHAR(255) NOT NULL,
LABEL VARCHAR(255) NOT NULL
);
/

ALTER TABLE COUNTRY ADD CONSTRAINT PK_COUNTRY PRIMARY KEY (ID);
/

-- create sequence --
CREATE SEQUENCE COUNTRY_SEQ
INCREMENT 1
MINVALUE 0
MAXVALUE 9223372036854775807
START 0
CACHE 1;
/

-- Specific Code Start --
-- Specific Code End --