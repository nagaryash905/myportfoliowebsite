package com.portfolio.service;

import javax.servlet.http.Part;

import com.portfolio.fileio.UploadResumeIOImpl;
import com.portfolio.validation.ValidateResumeImpl;

public class UploadResumeServiceImpl implements UploadResumeService {

	
	private boolean boolresult;
	private String result;
	@Override
	public String uploadResumeService(Part part) {
		
		//Get the Data here after the Validation
		result=new ValidateResumeImpl().validateResume(part);
		if(result.equals("valid"))
		{
			try 
			{
				UploadResumeIOImpl uploadResumeIOImpl = new UploadResumeIOImpl();
				boolresult=uploadResumeIOImpl.isExist();
				if(boolresult)
				{
					//update: Delete the write
					boolresult=uploadResumeIOImpl.deleteResume();
					if(boolresult)
					{
						result=uploadResumeIOImpl.writeResume(part);
						if(result.equals("Uploaded"))
						{
							result="Resume Uploaded Successfully !!";
						}
					}
				}
				else
				{
					//Insert : Write
					result=uploadResumeIOImpl.writeResume(part);
					if(result.equals("Uploaded"));
					{
						result="Resume Uploaded Successfully !!";
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
