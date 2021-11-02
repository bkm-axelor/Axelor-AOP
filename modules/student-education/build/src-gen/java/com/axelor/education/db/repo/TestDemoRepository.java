package com.axelor.education.db.repo;

import com.axelor.db.JpaRepository;
import com.axelor.db.Query;
import com.axelor.education.db.TestDemo;

public class TestDemoRepository extends JpaRepository<TestDemo> {

	public TestDemoRepository() {
		super(TestDemo.class);
	}

	public TestDemo findByCode(String code) {
		return Query.of(TestDemo.class)
				.filter("self.code = :code")
				.bind("code", code)
				.fetchOne();
	}

}

