package com.portfolio.fileio;

import javax.servlet.http.Part;

public interface ProfilePictureIO {

	public boolean isExist();
	
	public String writeProfilePicture(Part part);
	
	public boolean deleteProfilePicture();
}
