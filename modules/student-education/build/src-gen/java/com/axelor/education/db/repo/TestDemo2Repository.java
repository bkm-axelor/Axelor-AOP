package com.axelor.education.db.repo;

import com.axelor.db.JpaRepository;
import com.axelor.db.Query;
import com.axelor.education.db.TestDemo2;

public class TestDemo2Repository extends JpaRepository<TestDemo2> {

	public TestDemo2Repository() {
		super(TestDemo2.class);
	}

	public TestDemo2 findByCode(String code) {
		return Query.of(TestDemo2.class)
				.filter("self.code = :code")
				.bind("code", code)
				.fetchOne();
	}

	public TestDemo2 findByName(String name) {
		return Query.of(TestDemo2.class)
				.filter("self.name = :name")
				.bind("name", name)
				.fetchOne();
	}

}

