-- create table --
CREATE TABLE STUPID
(
id BIGINT,
CODE VARCHAR(255) NOT NULL,
FOOL_ID VARCHAR(255) NOT NULL
);
/

ALTER TABLE STUPID ADD CONSTRAINT PK_STUPID PRIMARY KEY (ID);
/

-- create sequence --
CREATE SEQUENCE STUPID_SEQ
INCREMENT 1
MINVALUE 0
MAXVALUE 9223372036854775807
START 0
CACHE 1;
/

-- Specific Code Start --
-- Specific Code End --
