CREATE TABLE loan(

	loan_id serial PRIMARY KEY,
	date_of_request timestamp default current_timestamp,
	user_id integer references user_info(user_id),
	rate_of_interest integer NOT NULL,
	approx_emi integer NOT NULL,
	duration date NOT NULL,
	processing_fee integer NOT NULL,
	status varchar(20),
	principal_amount integer NOT NULL,
	balance_amount integer NOT NULL
);