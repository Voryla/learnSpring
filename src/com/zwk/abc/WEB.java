package com.zwk.abc;

import org.junit.jupiter.api.Test;

public class WEB {

	public <T> T gets(String w,Integer v, adb<T> adb){
		return adb.doWork(w,v);
	}
	@Test
	public void test(){
		WEB web=new WEB();
		String abc=web.gets("3",4,(a,b)->{
			return a+b;
		});
		System.out.println(abc);
	}
}
