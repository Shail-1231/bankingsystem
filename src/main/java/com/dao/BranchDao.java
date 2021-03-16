package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.bean.BranchBean;

@Repository
public class BranchDao {

	@Autowired
	JdbcTemplate stmt;

	public List<BranchBean> getAllBranch() {

		List<BranchBean> branch = stmt.query("select * from branch",
				new BeanPropertyRowMapper<BranchBean>(BranchBean.class));

		System.out.println(branch.get(0).getBranchId());
		System.out.println(branch.get(0).getBranchName());
		return branch;
	}

}
