package com.portfolio.fileio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.Part;

public class UploadResumeIOImpl implements UploadResumeIO {

	private boolean boolresult;
	private String result;
	private InputStream is;
	private FileOutputStream fos;
	
	@Override
	public boolean isExist() {
			try 
			{
				String path="D:\\New Portfolio Wesite\\Yash@Portfoilo\\Yash__Portfolio\\src\\main\\webapp\\resume\\YashNagarResume.pdf";
				File file = new File(path);
				boolresult=file.exists();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		return boolresult;
	}

	@Override
	public String writeResume(Part part) {
		try 
		{
			String path="D:\\New Portfolio Wesite\\Yash@Portfoilo\\Yash__Portfolio\\src\\main\\webapp\\resume\\YashNagarResume.pdf";
			is=part.getInputStream();
			byte b[] = new byte[is.available()];
			is.read(b);
			
			fos = new FileOutputStream(path);
			fos.write(b);
			
			result="Uploaded";
		}
		catch (Exception e)
		{
			result="Something Went Wrong";
			e.printStackTrace();
		}
		finally {
			try 
			{
				is.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public boolean deleteResume() {
		try 
		{
			String path="D:\\New Portfolio Wesite\\Yash@Portfoilo\\Yash__Portfolio\\src\\main\\webapp\\resume\\YashNagarResume.pdf";
			
			File file = new File(path);
			boolresult=file.delete();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return boolresult;
	}

}
