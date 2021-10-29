package com.axelor.student.db.repo;

import com.axelor.db.JpaRepository;
import com.axelor.student.db.Subject;

public class SubjectRepository extends JpaRepository<Subject> {

	public SubjectRepository() {
		super(Subject.class);
	}

}

