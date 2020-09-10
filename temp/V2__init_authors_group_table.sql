drop table if exists author_groups;
create table author_groups(
                        id int primary key auto_increment,
                        created bit
);
alter table authors add column author_group_id int null;
alter table authors add foreign key (author_group_id) references author_groups(id);