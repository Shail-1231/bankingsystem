CREATE TABLE role(
	
	role_id serial PRIMARY KEY,
	role_name varchar(40) NOT NULL
);

insert into role values (1, 'Admin');
insert into role values (2, 'Customer');