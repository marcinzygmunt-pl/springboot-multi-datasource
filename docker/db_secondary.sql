create table secondary_entity
(
    id   integer not null
        constraint secondary_entity_pk
            primary key,
    company text
);
INSERT INTO secondary_entity (id, company) VALUES (1, 'Secondary ONE');