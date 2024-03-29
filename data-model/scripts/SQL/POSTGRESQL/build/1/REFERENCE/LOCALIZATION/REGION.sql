-- create table --
CREATE TABLE REGION
(
id INTEGER,
COUNTRY_ID SMALLINT NOT NULL,
CODE VARCHAR(255) NOT NULL,
LABEL VARCHAR(255) NOT NULL
);
/

ALTER TABLE REGION ADD CONSTRAINT PK_REGION PRIMARY KEY (ID);
/

-- create sequence --
CREATE SEQUENCE REGION_SEQ
INCREMENT 1
MINVALUE 0
MAXVALUE 9223372036854775807
START 0
CACHE 1;
/

-- Specific Code Start --
-- Specific Code End --
