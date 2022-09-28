package com.study.springmvc.DesignPattern.session03.IO;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.transform.Source;

public class LowerCaseInputStream extends FilterInputStream {

	public LowerCaseInputStream(InputStream in) {
		super(in); // 存取父類別的成員
	}

	@Override
	public int read() throws IOException {
		int c = super.read();  // 不在有數據可用 return -1
		System.out.println("ASC : "+c); // ascii 字元 
		return (c==-1? c : Character.toLowerCase((char)c));
	}

	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		System.out.println(off);
		System.out.println(len);
		int result = super.read(b, off, len);
		System.out.println(result);
		for(int i = off ; i <off+result ; i++) {
			System.out.println("b: "+b[i]);
			b[i] = (byte)Character.toLowerCase((byte)b[i]);
		}
		return result ;
	}

	
	
	
	
}
