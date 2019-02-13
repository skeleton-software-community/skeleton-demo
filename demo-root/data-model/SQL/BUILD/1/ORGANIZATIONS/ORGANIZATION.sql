-- create table --
CREATE TABLE ORGANIZATION
(
id INTEGER,
CODE VARCHAR(255) NOT NULL,
ORGANIZATION_DESCRIPTION_ID BIGINT NOT NULL
);
/

ALTER TABLE ORGANIZATION ADD CONSTRAINT PK_ORGANIZATION PRIMARY KEY (ID);
/

-- create sequence --
CREATE SEQUENCE ORGANIZATION_id_seq
INCREMENT 1
MINVALUE 0
MAXVALUE 9223372036854775807
START 0
CACHE 1;
/

ALTER TABLE ORGANIZATION ADD CONSTRAINT UC_ORGANIZATION UNIQUE (CODE);
/

-- Specific Code Start --
-- Specific Code End --
