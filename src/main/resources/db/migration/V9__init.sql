CREATE TABLE request(
	
	request_id serial NOT NULL,
	date_of_request timestamp default current_timestamp,
	request_type varchar(40),
	comment varchar(40),
	status varchar(30) default ('not approved'),
	user_id integer references user_info(user_id),
	account_id integer references account(account_id)	
);