-- table foreign keys and indexes --
ALTER TABLE STUPID ADD CONSTRAINT FK_STUPID_1 FOREIGN KEY (FOOL_ID) REFERENCES FOOL;
/

CREATE INDEX FK_STUPID_1 ON STUPID(FOOL_ID);
/

-- Specific Code Start --
-- Specific Code End --
