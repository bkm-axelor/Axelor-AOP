package com.axelor.meta.web;

import com.axelor.education.db.StudentsEducation;
import com.axelor.meta.CallMethod;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;

public class Gender {

	/*
	 * this is for calling the method
	 * 
	 * @CallMethod public String addprefix(String name,Integer value) {
	 * System.out.println(value); System.out.println(name); if(value != null && name
	 * != null) { if(value==1) { return "Mr."+name ; } else { return "Mrs."+name ; }
	 * } else { return name; } }
	 */
	@CallMethod
	public void addprefix(ActionRequest request, ActionResponse response) {
		StudentsEducation student = request.getContext().asType(StudentsEducation.class);
		StringBuffer name = new StringBuffer(student.getName());
		String value = student.getGender();

	//	System.out.println(value);
	//	System.out.println(name);
		
		String fname ;
		String xname= name.toString();
		
		
		if (value != null && name != null) {
			if (xname.contains("Mr.") || xname.contains("Mrs.")) {
				// System.out.println("This is one 1");
				String[] namesplit = name.toString().split("\\.");
				// System.out.println("hii");
				// System.out.println(Arrays.toString(namesplit));
				String dummy;
				dummy = namesplit[1].toString();
				// System.out.println("this is dummy"+dummy);
				if (value.equals("1")) {
					fname = "Mr. " + dummy;
				} else {
					fname = "Mrs. " + dummy;
				}
				// System.out.println(fname);
			} else {
				// System.out.println("This is two 2");
				if (value.equals("1")) {
					fname = "Mr. " + xname ;
				} else {
					fname = "Mrs. " + xname ;
				}
				// System.out.println(fname);
			}

		}
		else {
			// System.out.println("This is three 3");
			fname = xname;
			// System.out.println(fname);
		}
		// System.out.println(fname);
		 response.setValue("name", fname);
	}
}
