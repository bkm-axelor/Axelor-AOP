package com.axelor.student.db.repo;

import com.axelor.db.JpaRepository;
import com.axelor.student.db.SAddress;

public class SAddressRepository extends JpaRepository<SAddress> {

	public SAddressRepository() {
		super(SAddress.class);
	}

}

