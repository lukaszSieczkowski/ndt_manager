package pl.ndt.manager.utils;

import java.io.BufferedOutputStream;
import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileTool {

	/**
	 * Saves file in server directory
	 * @param file Saved file
	 * @param ownerNameAndSurname Files owner surname
	 * @return file name;
	 */
	public String saveFile(MultipartFile file,String ownerNameAndSurname) {
		String fileName= String.valueOf(System.currentTimeMillis())+"_"+ownerNameAndSurname;
		System.out.println("FileName = "+ fileName);

		try {
			String fileDirectory = System.getProperty("catalina.home") +
	                  File.separator + "NDT_MANAGER_FILES" + File.separator + fileName+".pdf";
		
			byte[] bytes = file.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(fileDirectory)));
			stream.write(bytes);
			stream.close();	

		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName;
	}
	
	
}