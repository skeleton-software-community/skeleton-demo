-- create table --
CREATE TABLE CALENDAR
(
id INTEGER,
CODE VARCHAR(255) NOT NULL,
LABEL VARCHAR(255) NOT NULL
);
/

ALTER TABLE CALENDAR ADD CONSTRAINT PK_CALENDAR PRIMARY KEY (ID);
/

-- create sequence --
CREATE SEQUENCE CALENDAR_SEQ
INCREMENT 1
MINVALUE 0
MAXVALUE 9223372036854775807
START 0
CACHE 1;
/

-- Specific Code Start --
-- Specific Code End --