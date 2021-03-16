CREATE TABLE user_info(

	user_id serial PRIMARY KEY,
	first_name varchar(40) NOT NULL,
	last_name varchar(40) NOT NULL,
	email varchar(100),
	password varchar(40) NOT NULL,
	address varchar(200) NOT NULL,
	role_id serial references role(role_id),
	wrong_attempt integer CHECK (wrong_attempt < 4),
	is_lock integer CHECK (is_lock < 2)
)