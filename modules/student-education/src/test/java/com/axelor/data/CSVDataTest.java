package com.axelor.data;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.axelor.data.csv.CSVImporter;
import com.axelor.education.db.repo.TestDemo2Repository;
import com.axelor.education.db.repo.TestDemoRepository;
import com.axelor.inject.Beans;
import com.axelor.test.GuiceModules;
import com.axelor.test.GuiceRunner;

@RunWith(GuiceRunner.class)
@GuiceModules(DataModule.class)
public class CSVDataTest {

	/* @Inject TestDemoRepository testDemoRepository ; */

	@Test
	public void testDefault() throws IOException {
		System.out.println("hi");
		System.err.println(Beans.get(TestDemoRepository.class).all().fetch());
		System.err.println(Beans.get(TestDemo2Repository.class).all().fetch());
		Importer importer = new CSVImporter("data/csv-config.xml", "data/csv");
		importer.run();
		System.err.println(Beans.get(TestDemoRepository.class).all().fetch());
		System.err.println(Beans.get(TestDemo2Repository.class).all().fetch());
		System.out.println("hi end");
	}
}
