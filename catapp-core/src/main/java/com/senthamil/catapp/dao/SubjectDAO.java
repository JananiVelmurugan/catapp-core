package com.senthamil.catapp.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.senthamil.catapp.model.Subject;
import com.senthamil.catapp.util.ConnectionUtil;

public class SubjectDAO {
	private JdbcTemplate jdbcTemplate = ConnectionUtil.getjdbcTemplate();

	public List<Subject> list() {
		String sql = "select id,name from subjects";
		List<Subject> list = jdbcTemplate.query(sql, (rs, rowNo) -> {
			Subject subject = new Subject();
			subject.setId(rs.getInt("id"));
			subject.setName(rs.getString("name"));
			return subject;
		});
		return list;
	}

	public Subject findById(Integer id) {
		String sql = "select id,name from subjects where id=?";
		Object[] args = { id };
		Subject list = jdbcTemplate.queryForObject(sql, args, (rs, rowNo) -> {
			Subject s = new Subject();
			s.setId(rs.getInt("id"));
			s.setName(rs.getString("name"));
			return s;
		});
		return list;
	}

	public List<String> listOfSubject() {
		String sql = "select name from subjects";
		List<String> list = jdbcTemplate.queryForList(sql, String.class);
		return list;
	}
}
