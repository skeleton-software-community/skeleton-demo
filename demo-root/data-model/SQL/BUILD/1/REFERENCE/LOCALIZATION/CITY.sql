-- create table --
CREATE TABLE CITY
(
id BIGINT,
REGION_ID INTEGER NOT NULL,
CODE VARCHAR(255) NOT NULL,
LABEL VARCHAR(255) NOT NULL
);
/

ALTER TABLE CITY ADD CONSTRAINT PK_CITY PRIMARY KEY (ID);
/

-- create sequence --
CREATE SEQUENCE CITY_id_seq
INCREMENT 1
MINVALUE 0
MAXVALUE 9223372036854775807
START 0
CACHE 1;
/

ALTER TABLE CITY ADD CONSTRAINT UC_CITY UNIQUE (REGION_ID,CODE);
/

-- Specific Code Start --
-- Specific Code End --
