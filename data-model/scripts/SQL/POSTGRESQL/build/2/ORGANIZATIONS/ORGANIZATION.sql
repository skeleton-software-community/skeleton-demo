ALTER TABLE ORGANIZATION ADD CONSTRAINT UC_ORGANIZATION UNIQUE (CODE);
/

ALTER TABLE ORGANIZATION ADD CONSTRAINT UC_ORGANIZATION_C1 UNIQUE (ORGANIZATION_DESCRIPTION_ID);
/

-- table foreign keys and indexes --
ALTER TABLE ORGANIZATION ADD CONSTRAINT FK_ORGANIZATION_1 FOREIGN KEY (ORGANIZATION_DESCRIPTION_ID) REFERENCES ORGANIZATION_DESCRIPTION;
/

CREATE INDEX IDX_ORGANIZATION_UC ON ORGANIZATION(CODE);
/

CREATE INDEX IDX_ORGANIZATION_C1 ON ORGANIZATION(ORGANIZATION_DESCRIPTION_ID);
/

-- Specific Code Start --
-- Specific Code End --
