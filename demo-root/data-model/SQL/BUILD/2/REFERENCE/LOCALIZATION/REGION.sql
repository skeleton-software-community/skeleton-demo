-- table foreign keys and indexes --
ALTER TABLE REGION ADD CONSTRAINT FK_REGION_0 FOREIGN KEY (COUNTRY_ID) REFERENCES COUNTRY;
/

CREATE INDEX FK_REGION_0 ON REGION(COUNTRY_ID);
/

-- Specific Code Start --
-- Specific Code End --