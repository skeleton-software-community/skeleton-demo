-- create table --
CREATE TABLE REGION
(
ID NUMBER(10,0),
COUNTRY_ID NUMBER(5,0) NOT NULL,
CODE VARCHAR2(255) NOT NULL,
LABEL VARCHAR2(255) NOT NULL,
CONSTRAINT PK_REGION PRIMARY KEY (ID) USING INDEX (CREATE INDEX IDX_REGION_PK ON REGION(ID)
)
/

-- create sequence --
CREATE SEQUENCE REGION_SEQ MINVALUE 0 NOMAXVALUE START WITH 0 INCREMENT BY 1 NOCYCLE
/

-- Specific Code Start --
-- Specific Code End --

