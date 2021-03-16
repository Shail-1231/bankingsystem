CREATE TABLE branch(
	
	branch_id integer PRIMARY KEY,
	branch_name varchar(30) NOT NULL,
	address varchar(200) NOT NULL,
	code integer,
	contact_number varchar(11) NOT NULL,
	over_draft_int_rate integer DEFAULT 6,
	over_draft_limit integer
)

