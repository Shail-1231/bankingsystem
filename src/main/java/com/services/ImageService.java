package com.services;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {

	public void uploadImage(MultipartFile file, String path,String fileName) {

		File mainPath = new File(
				"C:\\Users\\shail\\Documents\\workspace-spring-tool-suite-4-4.9.0.RELEASE\\bank-system\\src\\main\\webapp\\resources\\images\\");
		
		File userDir = new File(mainPath, path);
		System.out.println(path);
		userDir.mkdirs();
		System.out.println(file.getSize());
		File copyFile = new File(userDir,fileName);
		try {
			copyFile.createNewFile();
			byte allBytes[] = file.getBytes();
			FileUtils.writeByteArrayToFile(copyFile, allBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
