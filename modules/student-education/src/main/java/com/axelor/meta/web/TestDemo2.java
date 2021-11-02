package com.axelor.meta.web;

import java.io.IOException;

import com.axelor.data.Importer;
import com.axelor.data.csv.CSVImporter;

public class TestDemo2 {
	
	public void testDefault() throws IOException{
		System.out.println("hi2");
		Importer importer = new CSVImporter("data/csv-config.xml", "data/csv");
		importer.run();
		System.out.println("hi2 end");
	}

}
