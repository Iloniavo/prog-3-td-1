create table if not exists book
(
    id     serial,
    author varchar,
    title  varchar,
    page_number int not null default 0,
    release_date date,
    primary key (id)
);

create table if not exists author(
    id serial primary key,
    name varchar,
    particularity varchar,
    birth_date date
);