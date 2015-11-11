package com.wuman.jreadability.news;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Helper {
	public static void writeStringToFile(String str, String fileName, String charsetName) {
		try (OutputStream outputStream = new FileOutputStream(fileName);
				Writer writer = new OutputStreamWriter(outputStream, charsetName);
				BufferedWriter bufferedWriter = new BufferedWriter(writer);) {
			bufferedWriter.write(str);
			bufferedWriter.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeStringToFile(String str, String fileName) {
		writeStringToFile(str, fileName, "utf-8");
	}
}
