package com.axelor.student.Module;

import com.axelor.app.AxelorModule;
import com.axelor.student.db.repo.StudentRepository;
import com.axelor.student.web.StudentRepo;

public class StudentModule extends AxelorModule {
	@Override
	protected void configure() {
	    bind(StudentRepository.class).to(StudentRepo.class);
	  }
}
