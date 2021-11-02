package com.axelor.education.db.repo;

import com.axelor.db.JpaRepository;
import com.axelor.education.db.TestDemo4;

public class TestDemo4Repository extends JpaRepository<TestDemo4> {

	public TestDemo4Repository() {
		super(TestDemo4.class);
	}

}

