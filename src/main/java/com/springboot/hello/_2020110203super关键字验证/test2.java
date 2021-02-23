package com.springboot.hello._2020110203super关键字验证;

public class test2 {
 
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
        a ab = new b();
        ab = new b();
	}
 
}
class a {
	static{
		
		System.out.println("a.......");
		
	}

	public a()
	{
		System.out.println("1.......");
	}
}
 
class b extends a{
	static{
		
		System.out.println("b......");
	}
	public b(){
		System.out.println("2.........");
	}
}