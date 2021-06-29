CREATE TABLE IF NOT EXISTS HOTELS (
  HOTEL_ID BIGINT PRIMARY KEY NOT NULL,
  HOTEL_NAME VARCHAR,
  DESCRIPTION VARCHAR,
  PHOTO_URL VARCHAR,
  CITY VARCHAR,
  STATE VARCHAR,
  STATE_CODE VARCHAR,
  ADDRESS VARCHAR,
  POSTAL_CODE VARCHAR,
  LATITUDE FLOAT,
  LONGITUDE FLOAT,
  PRICE INT,
  AVAILABILITY BOOLEAN
);

CREATE EXTENSION pgcrypto;

CREATE OR REPLACE FUNCTION generate_uid(size INT) RETURNS TEXT AS $$
DECLARE
  characters TEXT := 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
  bytes BYTEA := gen_random_bytes(size);
  l INT := length(characters);
  i INT := 0;
  output TEXT := '';
BEGIN
  WHILE i < size LOOP
    output := output || substr(characters, get_byte(bytes, i) % l + 1, 1);
    i := i + 1;
  END LOOP;
  RETURN output;
END;
$$ LANGUAGE plpgsql VOLATILE;

CREATE TABLE IF NOT EXISTS RESERVATION (
  RESERVATION_ID TEXT PRIMARY KEY DEFAULT generate_uid(10),
  HOTEL_NAME TEXT,
  CHECK_IN DATE,
  CHECK_OUT DATE,
  GUEST_LIST TEXT,
  RESERVATION_DATE DATE DEFAULT CURRENT_DATE
);

CREATE TABLE IF NOT EXISTS GUEST (
  GUEST_ID BIGSERIAL PRIMARY KEY,
  FIRST_NAME VARCHAR(64),
  LAST_NAME VARCHAR(64)
);

CREATE INDEX IDX_RES_DATE_ ON RESERVATION(RESERVATION_DATE);
