package com.axelor.student.db.repo;

import com.axelor.db.JpaRepository;
import com.axelor.student.db.Country;

public class CountryRepository extends JpaRepository<Country> {

	public CountryRepository() {
		super(Country.class);
	}

}

