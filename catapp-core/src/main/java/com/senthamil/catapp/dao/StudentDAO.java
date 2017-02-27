package com.senthamil.catapp.dao;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.senthamil.catapp.model.Student;
import com.senthamil.catapp.util.ConnectionUtil;

public class StudentDAO { 
	private JdbcTemplate jdbcTemplate = ConnectionUtil.getjdbcTemplate();

	public void save(Student student) {
		String sql = "INSERT INTO students(NAME,dept) VALUES(?,?)";
		Object[] args = { student.getName(), student.getDept() };
		int rows = jdbcTemplate.update(sql, args);
		System.out.println("number of row inserted " + rows);
	}

	public List<Student> findAll() {
		String sql = "select id,name,dept from students";
		List<Student> students = jdbcTemplate.query(sql, (rs, rowNo) -> {
			Student student = new Student();
			student.setId(rs.getInt("id"));
			student.setName(rs.getString("name"));
			student.setDept(rs.getString("dept"));
			return student;
		});
		return students;
	}

	public Student findById(Integer id) {
		String sql = "select id,name,dept from students where id=?";
		Object[] args = { id };
		Student student = null;
		try {

			student = jdbcTemplate.queryForObject(sql, args, (rs, rowNo) -> {
				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setDept(rs.getString("dept"));
				System.out.println(s);
				return s;
			});
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e);
		}
		return student;
	}
}
