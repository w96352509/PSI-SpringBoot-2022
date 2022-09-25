package com.study.springmvc.DesignPattern.session02.book.practise;

public class Main {

	public static void main(String[] args) {
		SubjectImpl subject = new SubjectImpl();
		Observer observer = new ObserverImpl(subject);
		Observer observer2 = new ObserverImpl2(subject);
		subject.setVideoName("阿低");
		
	}
	
}
