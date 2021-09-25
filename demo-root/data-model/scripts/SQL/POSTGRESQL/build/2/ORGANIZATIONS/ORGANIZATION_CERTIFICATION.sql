ALTER TABLE ORGANIZATION_CERTIFICATION ADD CONSTRAINT UC_ORGANIZATION_CERTIFICATION UNIQUE (ORGANIZATION_ID);
/

ALTER TABLE ORGANIZATION_CERTIFICATION ADD CONSTRAINT UC_ORGANIZATION_CERTIFICATION_C0 UNIQUE (ORGANIZATION_ID);
/

-- table foreign keys and indexes --
ALTER TABLE ORGANIZATION_CERTIFICATION ADD CONSTRAINT FK_ORGANIZATION_CERTIFICATION_0 FOREIGN KEY (ORGANIZATION_ID) REFERENCES ORGANIZATION;
/

CREATE INDEX IDX_ORGANIZATION_CERTIFICATION_UC ON ORGANIZATION_CERTIFICATION(ORGANIZATION_ID);
/

CREATE INDEX IDX_ORGANIZATION_CERTIFICATION_C0 ON ORGANIZATION_CERTIFICATION(ORGANIZATION_ID);
/

-- Specific Code Start --
-- Specific Code End --
