package com.portfolio.fileio;

import javax.servlet.http.Part;

public interface UploadResumeIO {

	public boolean isExist();
	
	public String writeResume(Part part);
	
	public boolean deleteResume();
}
