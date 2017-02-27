package com.senthamil.catapp.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.senthamil.catapp.model.StudentMark;

public class AssessmentDAOTest {

	@Test
	public void testFindById() {

		AssessmentDAO dao = new AssessmentDAO();
		StudentMark studentMark = dao.findById(1);
		System.out.println(studentMark);
	}

}
