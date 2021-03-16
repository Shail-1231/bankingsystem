CREATE TABLE request(
	
	request_id integer NOT NULL,
	date_of_request date,
	request_type varchar(40),
	comment varchar(40),
	status varchar(30),
	user_id integer references user_info(user_id),
	account_id integer references account(account_id)	
);