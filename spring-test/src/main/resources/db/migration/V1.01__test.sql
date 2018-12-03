CREATE SCHEMA test;

CREATE SEQUENCE test.entity_seq;
CREATE TABLE test.entity (
  id BIGINT PRIMARY KEY,
  name VARCHAR(255) UNIQUE
);

CREATE SEQUENCE test.linked_entity_seq;
CREATE TABLE test.linked_entity (
  id BIGINT PRIMARY KEY,
  name VARCHAR(255) UNIQUE
);

CREATE TABLE test.entity_linked (
  my_entity_id BIGINT REFERENCES test.entity,
  linked_id BIGINT REFERENCES test.linked_entity,
  PRIMARY KEY (my_entity_id, linked_id)
);
