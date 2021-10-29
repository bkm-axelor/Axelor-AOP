package com.axelor.student.web;

import java.util.Map;

import com.axelor.student.db.Student;
import com.axelor.student.db.repo.StudentRepository;

public class StudentRepo extends StudentRepository{
	
	  public Map<String, Object> populate(Map<String, Object> json, Map<String, Object> context) {
	    if (!context.containsKey("json-enhance")) {
	      return json;
	    }
	    try {
	      Long id = (Long) json.get("id");
	      Student student = find(id);
			/*
			 * System.out.println(json); System.out.println(student.getStudentimage());
			 */
	      json.put("studentimage", student.getStudentimage() != null);
	    } catch (Exception e) {
	    }

	    return json;
	  }

}
