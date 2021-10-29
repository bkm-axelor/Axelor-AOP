package com.axelor.student.db.repo;

import com.axelor.db.JpaRepository;
import com.axelor.student.db.State;

public class StateRepository extends JpaRepository<State> {

	public StateRepository() {
		super(State.class);
	}

}

