package com.study.springmvc.DesignPattern.session03.IO;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Main2 {

	public static void main(String[] args) throws IOException {
		InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("C:\\Users\\vic\\git\\PSI202209\\SpringBoot-PSI-2022\\src\\test\\java\\com\\study\\springmvc\\DesignPattern\\session03\\IO\\test.txt")));
		byte[] bytes = new byte[ in.available()]; // 放入 byte 陣列 
		int z; // ASCII 字元儲存
		while((z = in .read(bytes, 0, bytes.length)) != -1)
		{
		    String s = new String(bytes, "utf-8");
		} 
		in .close();
		}
	}


