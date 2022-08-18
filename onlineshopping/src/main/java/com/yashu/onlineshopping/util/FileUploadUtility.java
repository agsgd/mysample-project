package com.yashu.onlineshopping.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
	
	
	private static final String ABS_PATH="D:\\D drive\\From_D_Yashwanth\\Spring Projects\\Sample-Project\\onlineshopping\\WebContent\\WEB-INF\\assets\\images\\";
	private static  String REAL_PATH="";
	
	private static final Logger logger=LoggerFactory.getLogger(FileUploadUtility.class);
	
	public static void uploadFile(HttpServletRequest request,MultipartFile file,String code){
		
		//get real Path
		
		REAL_PATH=request.getServletContext().getRealPath("/assets/images/");
		
		logger.info(REAL_PATH);
		
		
		// to make sure all the directory exists
		//please create the directory
		
		if(!new File(ABS_PATH).exists()){
			new File(ABS_PATH).mkdir();
		}
		
		if(!new File(REAL_PATH).exists()){
			new File(REAL_PATH).mkdir();
		}
		
		try{
			//server upload
			file.transferTo(new File(REAL_PATH + code + ".jpg"));
			// project directory upload
	        file.transferTo(new File(ABS_PATH + code + ".jpg"));		
		}catch(IOException e){
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
