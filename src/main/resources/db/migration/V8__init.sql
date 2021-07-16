CREATE TABLE transaction(
	
	transaction_id varchar(20) PRIMARY KEY,
	account_id integer references account(account_id),
	type varchar(20),
	description varchar(100),
	date_time timestamp default current_timestamp,
	amount integer NOT NULL,
	updated_balance integer
);