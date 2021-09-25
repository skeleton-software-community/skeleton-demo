ALTER TABLE CITY ADD CONSTRAINT UC_CITY UNIQUE (REGION_ID,CODE);
/

-- table foreign keys and indexes --
ALTER TABLE CITY ADD CONSTRAINT FK_CITY_0 FOREIGN KEY (REGION_ID) REFERENCES REGION;
/

CREATE INDEX IDX_CITY_UC ON CITY(REGION_ID,CODE);
/

CREATE INDEX IDX_CITY_C0 ON CITY(REGION_ID);
/

-- Specific Code Start --
-- Specific Code End --
