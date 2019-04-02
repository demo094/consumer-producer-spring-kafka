package com.sample.consumer.service.impl;

import com.sample.consumer.service.IFileSaveService;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by demo094 on 2019-04-02.
 */
@Service
public class DefaultFileSaveService implements IFileSaveService {
	private static final Logger logger = Logger.getLogger(DefaultFileSaveService.class.getName());

	private static final String DEST_FILE_DIR = System.getProperty("user.home")+ "\\Desktop\\";
	private static final String DEST_FILE_NAME = "mytext.txt";

	@Override
	public boolean save(String content) {
		System.out.println("SAVING FILE");
		File textFile = new File(DEST_FILE_DIR, DEST_FILE_NAME);
		try {
			FileWriter fileWriter = new FileWriter(textFile);
			try (BufferedWriter out = new BufferedWriter(fileWriter)) {
				out.write(content);
			}
		} catch (IOException e) {
			logger.log(Level.WARNING, "Exception while saving file", e);
			return false;
		}
		return true;
	}
}
