package com.portfolio.validation;

import javax.servlet.http.Part;

public class ValidateProfilePictureImpl implements ValidateProfilePicture {

	private String result;
	@SuppressWarnings("finally")
	@Override
	public String validateProfilePicture(Part part) {
		
		try 
		{
			long size = part.getSize();
			
			String contentType = part.getContentType();
			
			if(!contentType.endsWith("png"))
			{
				result="Invalid Format : Must be png";
			}
			else if(size>1048576)
			{
				result="File Size Exceeded";
			}
			else
			{
				result="valid";
			}
		}
		catch (Exception e) 
		{
				result="Someting Went Wrong";
				e.printStackTrace();
		}
		finally {
			return result;
		}
		
	}

}
