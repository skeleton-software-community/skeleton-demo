-- create table --
CREATE TABLE FOOL
(
ID VARCHAR2(255),
CODE VARCHAR2(255) NOT NULL,
DESCRIPTION CLOB NULL,
LONG_FIELD NUMBER(19,0) NULL,
BOOLEAN_FIELD NUMBER(1,0) NULL,
DOUBLE_FIELD FLOAT(24) NULL,
DECIMAL_FIELD NUMBER NULL,
DATE_FIELD DATE NULL,
DATETIME_FIELD TIMESTAMP NULL,
CONSTRAINT PK_FOOL PRIMARY KEY (ID) USING INDEX (CREATE INDEX IDX_FOOL_PK ON FOOL(ID)
)
/

-- Specific Code Start --
-- Specific Code End --

