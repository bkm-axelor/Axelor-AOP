package com.axelor.meta.web;

import com.axelor.education.db.StudentsEducation;
import com.axelor.i18n.I18n;
import com.axelor.meta.translation.ITranslation;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;

public class EducationStudent {

	// @Inject private EducationStudentServices edustdu;
	public void onConfirmJob(ActionRequest request, ActionResponse response) {
		StudentsEducation student = request.getContext().asType(StudentsEducation.class);
		Boolean job = student.getJob();
		// String job = student.getJob();
	//	System.out.println("job status ");
	//	System.out.println(I18n.get(ITranslation.JOB_Confirm));

		if (job) {
			try {
				throw new Exception(I18n.get(ITranslation.JOB_Confirm));
			} catch (Exception e) {
				response.setError(e.getMessage());
			}

		}
	}

}
