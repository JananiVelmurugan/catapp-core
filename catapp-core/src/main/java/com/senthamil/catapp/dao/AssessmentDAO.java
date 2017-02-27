package com.senthamil.catapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.senthamil.catapp.model.Student;
import com.senthamil.catapp.model.StudentMark;
import com.senthamil.catapp.model.Subject;
import com.senthamil.catapp.util.ConnectionUtil;

public class AssessmentDAO {
	private JdbcTemplate jdbcTemplate = ConnectionUtil.getjdbcTemplate();
	StudentDAO studentDAO = new StudentDAO();
	SubjectDAO subjectDAO = new SubjectDAO();

	public List<StudentMark> findAll() {
		String sql = "select id,student_id,subject_id,cat1,cat2,cat3,internal from  student_mark_details";
		List<StudentMark> list = jdbcTemplate.query(sql, (rs, rowNo) -> {
			return convert(rs);
		});

		return list;
	}

	public StudentMark findById(Integer id) {
		String sql = "select id,student_id,subject_id,cat1,cat2,cat3,internal from  student_mark_details where id=?";
		Object[] args = { id };
		StudentMark list = jdbcTemplate.queryForObject(sql, args, (rs, rowNo) -> {
			return convert(rs);

		});

		return list;
	}

	public StudentMark convert(ResultSet rs) throws SQLException {
		Student student = studentDAO.findById(rs.getInt("student_id"));

		Subject subject = subjectDAO.findById(rs.getInt("subject_id"));

		StudentMark mark = new StudentMark();

		mark.setId(rs.getInt("id"));
		mark.setStudent(student);
		mark.setSubject(subject);
		mark.setCat1(rs.getInt("cat1"));
		mark.setCat2(rs.getInt("cat2"));
		mark.setCat3(rs.getInt("cat3"));
		mark.setInternal(rs.getInt("internal"));

		return mark;
	}
}
