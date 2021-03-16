package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.ProofTypeBean;

@Repository
public class ProofTypeDao {

	@Autowired
	JdbcTemplate stmt;

	public List<ProofTypeBean> getAllProofType() {

		List<ProofTypeBean> proof = stmt.query("select * from proof_type",
				new BeanPropertyRowMapper<ProofTypeBean>(ProofTypeBean.class));

		System.out.println(proof.get(0).getProofTypeId());
		System.out.println(proof.get(0).getProofTypeName());
		return proof;
	}
}
