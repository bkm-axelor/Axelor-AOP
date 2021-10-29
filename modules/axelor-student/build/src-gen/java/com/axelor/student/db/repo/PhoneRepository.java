package com.axelor.student.db.repo;

import com.axelor.db.JpaRepository;
import com.axelor.student.db.Phone;

public class PhoneRepository extends JpaRepository<Phone> {

	public PhoneRepository() {
		super(Phone.class);
	}

}

