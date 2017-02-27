create table subjects(
id int primary key auto_increment,
name varchar(20) not null);

insert into subjects(name) values('java');

insert into subjects(name) values('j2ee');

select * from subjects;


truncate subjects;