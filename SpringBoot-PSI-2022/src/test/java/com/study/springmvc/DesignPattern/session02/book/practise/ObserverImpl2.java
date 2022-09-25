package com.study.springmvc.DesignPattern.session02.book.practise;

public class ObserverImpl2 implements Observer {

	private Subject subject;
	
	public ObserverImpl2(Subject subject) {
		this.subject = subject;
		subject.addObserver(this);
	}

    @Override
	public void update(String videoName) {
		System.out.println("頻道2更新" + videoName);
	}

}
