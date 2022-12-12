alter table book drop column author;
alter table book add column author_id int;
alter table book add constraint fk_author foreign key (author_id) references author (id);
alter table author add constraint unique_author unique(name);