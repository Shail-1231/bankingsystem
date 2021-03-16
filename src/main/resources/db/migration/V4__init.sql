CREATE TABLE user_profile(
	
	user_profile_id integer PRIMARY KEY,
	user_id integer references user_info(user_id),
	address_proof_type_id integer references proof_type(proof_type_id),
	address_proof varchar(100),
	profile_picture varchar(100),
	pan_number varchar(20),
	pan_pic varchar(100)
)