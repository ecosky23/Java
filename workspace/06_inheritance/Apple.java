package com.apple; //com.apple;   com 패키지 않에 apple클래스가 있다.

import com.zoo.Zoo;

class Apple{
	public static void main(String[] args) {
		System.out.println("빨간사과");
		//zoo클래스의 tiger매소드 호출
		
		Zoo zoo = new Zoo();
		zoo.tiger();
		//zoo.giraffe();
		//zoo.elephant();
		//zoo.lion();
		
		
	}
}

