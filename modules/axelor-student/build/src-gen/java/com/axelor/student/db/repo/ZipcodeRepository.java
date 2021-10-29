package com.axelor.student.db.repo;

import com.axelor.db.JpaRepository;
import com.axelor.student.db.Zipcode;

public class ZipcodeRepository extends JpaRepository<Zipcode> {

	public ZipcodeRepository() {
		super(Zipcode.class);
	}

}

