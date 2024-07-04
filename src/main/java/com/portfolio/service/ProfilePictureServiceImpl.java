package com.portfolio.service;

import javax.servlet.http.Part;

import com.portfolio.fileio.ProfilePictureIOImpl;
import com.portfolio.validation.ValidateProfilePictureImpl;

public class ProfilePictureServiceImpl implements ProfilePictureService {

	
	private boolean boolresult;
	private String result;
	@Override
	public String uploadProfilePicture(Part part) {
		
		//Get the Data here after the Validation
		result=new ValidateProfilePictureImpl().validateProfilePicture(part);
		if(result.equals("valid"))
		{
			try 
			{
				 ProfilePictureIOImpl profilePictureIOImpl = new ProfilePictureIOImpl();
				boolresult=profilePictureIOImpl.isExist();
				if(boolresult)
				{
					//update: Delete the write
					boolresult=profilePictureIOImpl.deleteProfilePicture();
					if(boolresult)
					{
						result=profilePictureIOImpl.writeProfilePicture(part);
						if(result.equals("Uploaded"))
						{
							result="Profile Picture Uploaded Successfully !!";
						}
					}
				}
				else
				{
					//Insert : Write
					result=profilePictureIOImpl.writeProfilePicture(part);
					if(result.equals("Uploaded"));
					{
						result="Profile Picture Uploaded Successfully !!";
					}
				}
			}
			catch (Exception e) 
			{
				e.printStackTrace();
				result="Something Went Wrong";
			}
		}
		return result;
	}
	
}
