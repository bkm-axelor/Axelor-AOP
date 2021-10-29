package com.axelor.education.db.repo;

import com.axelor.db.JpaRepository;
import com.axelor.db.Query;
import com.axelor.education.db.TestDemo;

public class TestDemoRepository extends JpaRepository<TestDemo> {

	public TestDemoRepository() {
		super(TestDemo.class);
	}

	public TestDemo findByName(String name) {
		return Query.of(TestDemo.class)
				.filter("self.name = :name")
				.bind("name", name)
				.fetchOne();
	}

}

