CREATE SCHEMA bibliography;

CREATE SEQUENCE bibliography.book_seq;
CREATE TABLE bibliography.book (
  id    BIGINT       NOT NULL PRIMARY KEY,
  title VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE bibliography.book_tags (
  book_id BIGINT REFERENCES bibliography.book,
  tags    VARCHAR(255),
  PRIMARY KEY (book_id, tags)
);

CREATE TABLE bibliography.book_publishers (
  book_id BIGINT REFERENCES bibliography.book,
  name    VARCHAR(255) NOT NULL,
  since   INT
);

CREATE TABLE bibliography.book_editions (
  book_id      BIGINT REFERENCES bibliography.book,
  editions_key INT,
  editions     INT
);

CREATE TABLE book_isbns (
  book_id   BIGINT REFERENCES bibliography.book,
  isbns_key VARCHAR(255),
  isbns     VARCHAR(255)
);

CREATE TABLE bibliography.language (
  id   BIGINT       NOT NULL PRIMARY KEY,
  name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE bibliography.country (
  id   BIGINT       NOT NULL PRIMARY KEY,
  name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE book_translations (
  translations_id    BIGINT PRIMARY KEY,
  book_id            BIGINT REFERENCES bibliography.book,
  translations_key   BIGINT REFERENCES bibliography.language,
  translations_value BIGINT REFERENCES bibliography.country
);