-------------------------------------------------------------
---- FUNCTION unaccent_string: turn accent to lowercase  ----
-------------------------------------------------------------
CREATE OR REPLACE FUNCTION unaccent(text)
RETURNS text
IMMUTABLE
STRICT
LANGUAGE SQL
AS $$
SELECT translate(
    lower($1),
    'âãäåāăąÁÂÃÄÅĀĂĄèééêëēĕėęěĒĔĖĘĚìíîïìĩīĭÌÍÎÏÌĨĪĬóôõöōŏőÒÓÔÕÖŌŎŐùúûüũūŭůÙÚÛÜŨŪŬŮ',
    'aaaaaaaaaaaaaaaeeeeeeeeeeeeeeeiiiiiiiiiiiiiiiiooooooooooooooouuuuuuuuuuuuuuuu'
);
$$;

-------------------------------------------------------------
---- FUNCTION long_to_string ----
-------------------------------------------------------------
CREATE OR REPLACE FUNCTION long_to_string(bigint)
RETURNS text
IMMUTABLE
STRICT
LANGUAGE SQL
AS $$
SELECT $1::varchar;
$$;

select long_to_string(45958);


-------------------------------------------------------------
---- FUNCTION date_to_string ----
-------------------------------------------------------------
CREATE OR REPLACE FUNCTION date_to_string(timestamp)
RETURNS text
IMMUTABLE
STRICT
LANGUAGE SQL
AS $$
SELECT $1::varchar;
$$;

select date_to_string('2006/01/30');

