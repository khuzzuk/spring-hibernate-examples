CREATE TABLE person (
  id      BIGINT       NOT NULL,
  name    VARCHAR(255) NOT NULL,
  surname VARCHAR(255) NOT NULL,
  city VARCHAR(255),
  street VARCHAR(255),
  house_number VARCHAR(255),
  flat_number VARCHAR(255),
  postal_code VARCHAR(255),
  PRIMARY KEY (id, name, surname)
)