create database case_study_jsp_servlet;
use case_study_jsp_servlet;

create table position (
id int auto_increment primary key,
`name` varchar(45) 
);

select a.*, c.id as contract_id from attach_facility a join contract_detail ct on a.id = ct.attach_facility_id join contract c on ct.contract_id = c.id ;
select c.*, e.name as employee_name,cs.name as customer_name,f.name as facility_name,  (ifnull(f.cost,0) + sum(ifnull(ct.quantity,0) * ifnull(a.cost,0)))  as tong_tien from contract c join facility f on c.facility_id = f.id join contract_detail ct on c.id = ct.contract_id join attach_facility a on ct.attach_facility_id = a.id join customer cs on c.customer_id = cs.id
join employee e on c.employee_id = e.id group by c.id order by c.id;

create table education_degree(
id int auto_increment primary key,
`name` varchar(45) 
); 

create table division (
id int auto_increment primary key,
`name` varchar(45) 
);

create table `role`(
role_id int auto_increment primary key,
role_name varchar(255) 
);

create table `user` (
username varchar(255) primary key,
`password` varchar(255) 
);

create table user_role (
role_id int auto_increment,
username varchar(255),
primary key(role_id,username),
foreign key(role_id) references `role` (role_id),
foreign key(username) references `user` (username)
);

create table employee(
id int auto_increment primary key,
`name` varchar(45) not null,
date_of_birth date not null,
id_card varchar(45) not null,
salary double not null ,
phone_number varchar(45) not null,
email varchar(45) ,
address varchar(45) ,
position_id int not null,
education_degree_id int not null,
division_id int not null,
username varchar(255) ,
foreign key(position_id) references position (id),
foreign key(education_degree_id) references education_degree (id),
foreign key(division_id) references division (id),
foreign key(username) references `user` (username)
);

create table customer_type (
id int auto_increment primary key,
`name` varchar(45) 
);

create table customer(
id int auto_increment primary key,
customer_type_id int not null ,
`name` varchar(45) not null,
date_of_birth date not null,
gender bit(1) not null ,
id_card varchar(45) not null unique,
phone_number varchar(45) not null unique,
email varchar(45) unique ,
address varchar(45) ,
foreign key(customer_type_id) references customer_type (id)
);





create table facility_type (
id int auto_increment primary key,
`name` varchar(45) 
);

create table rent_type(
id int auto_increment primary key,
`name` varchar(45) 
);

create table facility (
id int auto_increment primary key,
`name` varchar(45) not null,
area int ,
cost double not null,
max_people int ,
rent_type_id int not null,
facility_type_id int not null,
standard_room varchar(45) ,
description_other_convenience varchar(45) ,
pool_area double,
number_of_floors int ,
facility_free text  ,
foreign key(rent_type_id) references rent_type (id),
foreign key(facility_type_id) references facility_type (id)
);

create table attach_facility(
id int auto_increment primary key,
`name` varchar(45) not null,
cost double not null,
unit varchar(10) not null,
`status` varchar(45) 
);

create table contract(
id int auto_increment primary key,
start_date datetime not null,
end_date datetime not null,
deposit double not null,
employee_id int not null,
customer_id int not null,
facility_id int not null,
foreign key(employee_id) references employee (id),
foreign key(customer_id) references customer (id),
foreign key(facility_id) references facility (id)
);

create table contract_detail(
id int auto_increment primary key,
contract_id int,
attach_facility_id int,
quantity int,
foreign key(attach_facility_id) references attach_facility(id),
foreign key(contract_id) references contract(id)
);




create table contract_detail(
id int auto_increment primary key,
contract_id int not null ,
attach_facility_id int not null,
quantity int not null,
foreign key(contract_id) references contract (id),
foreign key(attach_facility_id) references attach_facility (id)
);