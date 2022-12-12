create table if not exists category(
    id serial primary key,
    category_name varchar
);

create table if not exists book_category(
    id serial,
    book_id int references book(id),
    category_id int references category(id),
    unique(book_id, category_id)
);