CREATE TABLE email (
  id      BIGINT NOT NULL PRIMARY KEY,
  content TEXT,
  email   VARCHAR(255),
  subject VARCHAR(255)
);

CREATE TABLE system_email(
  id      BIGINT NOT NULL PRIMARY KEY,
  from_system BOOLEAN
);


CREATE TABLE sms (
  id           BIGINT NOT NULL PRIMARY KEY,
  content      TEXT,
  phone_number VARCHAR(255)
);