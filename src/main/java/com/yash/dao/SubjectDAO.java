package com.yash.dao;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.yash.model.Subject;

public interface SubjectDAO 
{
	public Subject saveSubject(Subject sub);
	public List<Subject> getSubject();
}
