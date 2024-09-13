create table primary_entity
(
    id   integer not null
        constraint primary_entity_pk
            primary key,
    name text
);
INSERT INTO primary_entity (id, name) VALUES (1, 'Primary ONE');


