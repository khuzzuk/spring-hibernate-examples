CREATE SCHEMA relation;

CREATE TABLE relation.person (
  id   BIGINT NOT NULL PRIMARY KEY,
  name VARCHAR(255)
);

CREATE TABLE relation.address (
  id       BIGINT NOT NULL PRIMARY KEY,
  city     VARCHAR(255),
  street   VARCHAR(255),
  house    VARCHAR(255),
  flat     VARCHAR(255),
  zip_code VARCHAR(255)
);

CREATE TABLE relation.person_addresses (
  person_id  BIGINT NOT NULL UNIQUE REFERENCES relation.person,
  addresses_id BIGINT NOT NULL REFERENCES relation.address,
  PRIMARY KEY (person_id, addresses_id)
);

CREATE SCHEMA project;

CREATE TABLE project.project (
  id   BIGINT NOT NULL PRIMARY KEY,
  name VARCHAR(255)
);

CREATE TABLE project.person_projects (
  person_id BIGINT REFERENCES relation.person,
  project_id BIGINT REFERENCES project.project,
  PRIMARY KEY (person_id, project_id)
);