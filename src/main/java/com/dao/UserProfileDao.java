package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.UserProfileBean;

@Repository
public class UserProfileDao {
	@Autowired
	JdbcTemplate template;

	public void insert(UserProfileBean bean) {
		template.update(
				"insert into user_profile (user_profile_id, user_id,address_proof_type_id,address_proof, profile_picture, pan_number, pan_pic) values (?,?,?,?,?,?,?) "
						,bean.getUserProfileId(), bean.getUserId(), bean.getAddressProofTypeId(),
				bean.getAddressProof(), bean.getProfilePicture(), bean.getPanNumber(), bean.getPanPicture());
	}
}
