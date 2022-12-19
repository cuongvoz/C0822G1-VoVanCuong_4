create database demo;
use demo;
create table student(
id int auto_increment primary key,
`name` varchar(55),
point float,
age int,
gender boolean
);

insert into student (name,point,age,gender) values ('Cường',4,21,1),('Lanh',8,23,1),('Liên',7,23,0);