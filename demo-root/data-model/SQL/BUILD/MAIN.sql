DROP SCHEMA IF EXISTS public CASCADE;
CREATE SCHEMA public;
-- Specific Code Start --



-------------------------------------------------------------
---- FUNCTION unaccent: turn accent to lowercase  ----
-------------------------------------------------------------
CREATE OR REPLACE FUNCTION unaccent(text)
RETURNS text
IMMUTABLE
STRICT
LANGUAGE SQL
AS $$
SELECT translate(
    lower($1),
    'àâäèéêëîïôöûü',
    'aaaeeeeiioouu'
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


-- Specific Code End --
