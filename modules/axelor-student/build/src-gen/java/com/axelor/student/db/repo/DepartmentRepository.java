package com.axelor.student.db.repo;

import com.axelor.db.JpaRepository;
import com.axelor.student.db.Department;

public class DepartmentRepository extends JpaRepository<Department> {

	public DepartmentRepository() {
		super(Department.class);
	}

}

