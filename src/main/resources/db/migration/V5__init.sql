CREATE TABLE branch(
	
	branch_id integer PRIMARY KEY,
	branch_name varchar(30) NOT NULL,
	address varchar(200) NOT NULL,
	code integer,
	contact_number varchar(11) NOT NULL,
	over_draft_int_rate integer DEFAULT 6,
	loan_int_rate integer,
	over_draft_limit integer
);

insert into branch values (1, 'Paldi', 'Near Hirabaug Crossing', 1, '9999999999', 6, 10.5,  10000000);
insert into branch values (2, 'Kathwada', 'Opp Vintage Car Museum', 2, '8888888888', 5, 9.5, 100000);
insert into branch values (3, 'Bopal', 'Opp SOBO Center', 3, '7777777777', 6, 11, 10000000);
insert into branch values (4, 'Prahladnagar', 'Safal Pegasus', 4, '6666666666', 7, 11.5, 10000000);

