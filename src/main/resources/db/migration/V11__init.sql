CREATE TABLE loan_transaction(

	loan_id integer references loan(loan_id),
	user_id integer references user_info(user_id),
	date_of_confirmation date NOT NULL,
	transaction_type varchar(30) NOT NULL,
	amount integer NOT NULL
);