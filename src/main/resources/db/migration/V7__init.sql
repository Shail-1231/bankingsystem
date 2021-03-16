CREATE TABLE account(
	
	account_id serial PRIMARY KEY,
	user_id integer references user_info(user_id),
	branch_id integer references branch(branch_id),
	account_number varchar(11) NOT NULL,
	account_type_id integer references account_type(account_type_id),
	balance integer NOT NULL,
	over_draft integer,
	over_draft_limit integer
);