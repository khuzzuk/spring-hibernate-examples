CREATE SCHEMA hr;
CREATE TABLE hr.person (
  id           BIGINT       NOT NULL PRIMARY KEY,
  first_name   VARCHAR(255) NOT NULL,
  second_name  VARCHAR(255) NOT NULL,
  last_name    VARCHAR(255) NOT NULL,
  job_position VARCHAR(255),
  salary       DOUBLE PRECISION,
  role         VARCHAR(64)
)