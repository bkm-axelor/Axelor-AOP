package com.axelor.student.db.repo;

import com.axelor.db.JpaRepository;
import com.axelor.student.db.City;

public class CityRepository extends JpaRepository<City> {

	public CityRepository() {
		super(City.class);
	}

}

