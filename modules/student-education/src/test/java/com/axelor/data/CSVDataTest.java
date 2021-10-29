package com.axelor.data;

import java.io.IOException;

import org.junit.Test;

import com.axelor.data.csv.CSVImporter;

public class CSVDataTest {
	
	/* @Inject TestDemoRepository testDemoRepository ; */

	@Test
	public void testDefault() throws IOException{
		System.out.println("hi");
		Importer importer = new CSVImporter("data/csv-config.xml", "data/csv");
		importer.run();
		System.out.println("hi end");
	}
}
