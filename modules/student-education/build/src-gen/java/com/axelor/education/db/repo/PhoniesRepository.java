package com.axelor.education.db.repo;

import com.axelor.db.JpaRepository;
import com.axelor.education.db.Phonies;

public class PhoniesRepository extends JpaRepository<Phonies> {

	public PhoniesRepository() {
		super(Phonies.class);
	}

}

