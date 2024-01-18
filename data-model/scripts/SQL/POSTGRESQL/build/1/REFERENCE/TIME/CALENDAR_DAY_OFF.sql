-- create table --
CREATE TABLE CALENDAR_DAY_OFF
(
id INTEGER,
CALENDAR_ID INTEGER NOT NULL,
DAY_OFF_DATE DATE NOT NULL,
DAY_OFF_LABEL VARCHAR(255) NULL
);
/

ALTER TABLE CALENDAR_DAY_OFF ADD CONSTRAINT PK_CALENDAR_DAY_OFF PRIMARY KEY (ID);
/

-- create sequence --
CREATE SEQUENCE CALENDAR_DAY_OFF_SEQ
INCREMENT 1
MINVALUE 0
MAXVALUE 9223372036854775807
START 0
CACHE 1;
/

-- Specific Code Start --
-- Specific Code End --
