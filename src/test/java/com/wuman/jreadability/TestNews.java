package com.wuman.jreadability;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;

import com.wuman.jreadability.news.ReadabilityNews;

public class TestNews {

	public static void main(String[] args) throws IOException {
		URL url = new URL("http://news.qq.com/a/20151102/021831.htm?tu_biz=1.114.1.0");
		ReadabilityNews readability = new ReadabilityNews(url, 30000);
		
//		InputStream inputStream = new FileInputStream("/home/liyuncong/test/347具赴缅远征军遗骸将归国.html");
//		Reader reader = new InputStreamReader(inputStream, "UTF-8");
//		BufferedReader bufferedReader = new BufferedReader(reader);
//		String html = "";
//		String line = "";
//		while ((line = bufferedReader.readLine()) != null) {
//			html += line + System.lineSeparator();
//		}
//		bufferedReader.close();
		
//		Readability readability = new Readability(html);
		readability.init();
		String cleanHtml = readability.outerHtml();
		
		System.out.println(".........");
		System.out.println(cleanHtml);
		
		OutputStream outputStream = new FileOutputStream("/home/liyuncong/test1.html");
		Writer writer = new OutputStreamWriter(outputStream, "gb2312");
		BufferedWriter bufferedWriter = new BufferedWriter(writer);
		bufferedWriter.write(cleanHtml);
		bufferedWriter.close();
	}

}
