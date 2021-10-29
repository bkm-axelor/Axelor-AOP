package com.axelor.education.db.repo;

import com.axelor.db.JpaRepository;
import com.axelor.education.db.Education;

public class EducationRepository extends JpaRepository<Education> {

	public EducationRepository() {
		super(Education.class);
	}

}

