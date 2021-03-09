-- table foreign keys and indexes --
ALTER TABLE CITY ADD CONSTRAINT FK_CITY_0 FOREIGN KEY (REGION_ID) REFERENCES REGION
/

CREATE INDEX IDX_CITY_F0 ON CITY(REGION_ID)
/

-- Specific Code Start --
-- Specific Code End --

