CREATE TABLE person (
  id                         BIGINT       NOT NULL,
  first_name                 VARCHAR(255) NOT NULL,
  second_name                VARCHAR(255) NOT NULL,
  last_name                  VARCHAR(255) NOT NULL,
  person_address_city        VARCHAR(255),
  person_address_street      VARCHAR(255),
  person_address_house       VARCHAR(255),
  person_address_flat        VARCHAR(255),
  person_address_postal_code VARCHAR(255),
  PRIMARY KEY (id, first_name, second_name, last_name)
)