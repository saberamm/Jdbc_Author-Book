create table writers
(
    author_id serial
        primary key
        unique
                          not null,
    name      varchar(20) not null,
    last_name varchar(20) not null,
    age       integer     not null
);

alter table writers
    owner to postgres;
----------------------
create table books
(
    book_id    serial
        primary key
        unique
                           not null,
    title      varchar(20) not null,
    print_year integer     not null,
    authors_id integer     not null
        constraint books_writers_author_id_fk
            references writers
);

alter table books
    owner to postgres;

