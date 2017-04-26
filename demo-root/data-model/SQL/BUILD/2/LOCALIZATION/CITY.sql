-- table foreign keys and indexes --
ALTER TABLE CITY ADD CONSTRAINT FK_CITY_1 FOREIGN KEY (REGION_ID) REFERENCES REGION;
/

CREATE INDEX FK_CITY_1 ON CITY(REGION_ID);
/

-- Specific Code Start --
-- Specific Code End --
