-- create table --
CREATE TABLE ORGANIZATION
(
ID NUMBER(10,0),
CODE VARCHAR2(255) NOT NULL,
ORGANIZATION_DESCRIPTION_ID NUMBER(19,0) NOT NULL,
CONSTRAINT PK_ORGANIZATION PRIMARY KEY (ID) USING INDEX (CREATE INDEX IDX_ORGANIZATION_PK ON ORGANIZATION(ID)
)
/

-- create sequence --
CREATE SEQUENCE ORGANIZATION_SEQ MINVALUE 0 NOMAXVALUE START WITH 0 INCREMENT BY 1 NOCYCLE
/

-- Specific Code Start --
-- Specific Code End --
