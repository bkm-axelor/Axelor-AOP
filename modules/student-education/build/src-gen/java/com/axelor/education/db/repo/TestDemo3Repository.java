package com.axelor.education.db.repo;

import com.axelor.db.JpaRepository;
import com.axelor.education.db.TestDemo3;

public class TestDemo3Repository extends JpaRepository<TestDemo3> {

	public TestDemo3Repository() {
		super(TestDemo3.class);
	}

}

