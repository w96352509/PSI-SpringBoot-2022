package com.study.springmvc.DesignPattern.session03.SingletonFactory;

public class SingletonFactory {

	private SingletonFactory() {}
	
	// 取得內部類別方法
	public static Factory getColaFactory() {
		return ColaFactory.colaFactory;
	}
	
	// 取得內部類別方法
	public static Factory getHumbergerFactory() {
		return HumbergerFactory.humbergerFactory;
	}
	
    
	private static class ColaFactory implements Factory{
        private static ColaFactory colaFactory = new ColaFactory();
		
        private ColaFactory() {};
        
		@Override
		public Product getProduct() {
			return new Cola();
		}
		
	}
	
	private static class HumbergerFactory implements Factory{

		private static HumbergerFactory humbergerFactory = new HumbergerFactory();
		
		private HumbergerFactory() {};
		
		@Override
		public Product getProduct() {
			return new Humberger();
		}
		
	}
	
}

