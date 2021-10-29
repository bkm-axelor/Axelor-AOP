package com.axelor.education.db.repo;

import com.axelor.db.JpaRepository;
import com.axelor.db.Query;
import com.axelor.education.db.StudentsEducation;

public class StudentsEducationRepository extends JpaRepository<StudentsEducation> {

	public StudentsEducationRepository() {
		super(StudentsEducation.class);
	}

	public StudentsEducation findByName(String name) {
		return Query.of(StudentsEducation.class)
				.filter("self.name = :name")
				.bind("name", name)
				.fetchOne();
	}

}

