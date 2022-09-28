package com.study.springmvc.DesignPattern.session03.IO;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class Main {

	public static void main(String[] args) {
		int c ;
		try {
			InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("C:\\Users\\vic\\git\\PSI202209\\SpringBoot-PSI-2022\\src\\test\\java\\com\\study\\springmvc\\DesignPattern\\session03\\IO\\test.txt")));
			while((c = in.read())>=0) {
				// System.out.println((char)c);
			}
			in.close();
		} catch (Exception e) {
			
		}
	}

}
