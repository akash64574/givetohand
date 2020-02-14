package com.give2hand.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileUtil {

	public byte[] getTaxCertificate(String taxUrl) throws IOException {
		
		try {
			File file = new File(taxUrl);
			FileInputStream fis = new FileInputStream(file);
			byte[] data = new byte[(int) file.length()];
			fis.read(data);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			data = bos.toByteArray();
			fis.close();
			return data;
		}
		catch (IOException e) {
	       log.error("Error Occured in FileUtil...");
	    }
		return null;
	}

}
