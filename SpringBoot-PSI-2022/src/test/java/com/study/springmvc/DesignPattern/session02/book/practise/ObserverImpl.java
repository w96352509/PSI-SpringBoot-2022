package com.study.springmvc.DesignPattern.session02.book.practise;

public class ObserverImpl implements Observer {

	private Subject subject;
	
	public ObserverImpl(Subject subject) {
		this.subject = subject;
		subject.addObserver(this);
	}

    @Override
	public void update(String videoName) {
		System.out.println("頻道1更新" + videoName);
	}

}
