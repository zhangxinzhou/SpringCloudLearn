drop table if EXISTS user;
create table user(
id BIGINT,
username varchar(40),
name varchar(20),
age int(3),
balance DECIMAL(10,2),
primary key (id)
);
