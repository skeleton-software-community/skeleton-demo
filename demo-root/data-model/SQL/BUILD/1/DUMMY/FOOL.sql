-- create table --
CREATE TABLE FOOL
(
id BIGINT,
CODE VARCHAR(255) NOT NULL,
DESCRIPTION TEXT NULL,
LONG_FIELD BIGINT NULL,
BOOLEAN_FIELD BOOLEAN NULL,
DOUBLE_FIELD_2 DOUBLE PRECISION NULL,
DOUBLE_FIELD_4 DOUBLE PRECISION NULL,
DATE_FIELD TIMESTAMP WITH TIME ZONE NULL,
DATETIME_FIELD TIMESTAMP WITH TIME ZONE NULL
);
/

ALTER TABLE FOOL ADD CONSTRAINT UC_FOOL UNIQUE (CODE);
/

ALTER TABLE FOOL ADD CONSTRAINT PK_FOOL PRIMARY KEY (ID);
/

-- create sequence --
CREATE SEQUENCE FOOL_id_seq
INCREMENT 1
MINVALUE 0
MAXVALUE 9223372036854775807
START 0
CACHE 1;
/

-- Specific Code Start --
-- Specific Code End --
