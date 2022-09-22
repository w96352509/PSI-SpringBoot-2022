package com.study.springmvc.DesignPattern.session01.StrategyMode;

public class Calculator {

	private int now = 0 ;
	
	private IStrategy iStrategy;
	
	public int execute(int a , int b){
        return iStrategy.caculate(a,b);
    }
	
	public void reset(){
        this.now = 0 ;
    }
	
	public void setStrategy(DoType doType) {
		
		switch (doType){
        case ADD:
            this.iStrategy = new Add();
            break;
        case MINUS:
           this.iStrategy = new Miuns();
            break;
        case DIVIDE:
            this.iStrategy = new Div();
            break;
     }
	}
	
	enum DoType{
        ADD , MINUS , DIVIDE , MULTYPLY
    }
	
}
