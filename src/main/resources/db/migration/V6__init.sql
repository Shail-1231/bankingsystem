CREATE TABLE account_type(
	
	account_type_id integer PRIMARY KEY,
	type varchar(10)
);

insert into account_type values (1, 'Current');
insert into account_type values (2, 'Savings')