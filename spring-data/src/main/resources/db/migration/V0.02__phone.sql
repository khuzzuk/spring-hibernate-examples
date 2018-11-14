CREATE SCHEMA structure;

CREATE SEQUENCE structure.phone_number_seq;

CREATE TABLE structure.phone_number (
  id     BIGINT       NOT NULL,
  number VARCHAR(255) NOT NULL UNIQUE,
  last_update TIMESTAMP,
  phone_type VARCHAR(32),
  PRIMARY KEY (id)
)