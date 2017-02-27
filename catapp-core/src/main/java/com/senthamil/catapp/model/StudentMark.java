package com.senthamil.catapp.model;

import lombok.Data;

@Data
public class StudentMark {
	private Integer id;
	private Integer cat1;
	private Integer cat2;
	private Integer cat3;
	private Integer internal;
	Student student;
	Subject subject;
}
