drop table if exists authors;
create table authors(
    id int primary key auto_increment,
    name varchar(50) not null,
    surname varchar(60) not null,
    created bit,
    created_on datetime null,
    updated_on datetime null

);