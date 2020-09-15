class Test{
	@Override
		public String toString(){
		return getClass()+"@개바부";//getclass는 앞의 클래스의 값(class test)을 가져온다.
	}
	}

class Sample{}


class ObjectMain extends Object{
	public static void main(String[] args) {
		Test t = new Test();
		System.out.println("객체 t =" + t);//객체 t =Test@15db9742
		System.out.println("객체 t =" + t.toString());//위의 주소와 똑같이 나옴
		System.out.println();

		Sample s = new Sample();
		System.out.println("객체 s =" + s);
		System.out.println("객체 s =" + s.toString());//Sample@15db9742
		System.out.println("객체 s =" + s.hashCode());//위의 16진수가 10진수로 나온다 366712642

		String str = "apple";
		System.out.println("객체 str =" + str);//apple
		System.out.println("객체 str =" + str.toString());
		System.out.println("객체 str =" + str.hashCode());//믿지 마삼

		Object cc = new Object();
		Object dd = new Object();
		System.out.println("cc==dd : "+(cc==dd));//false 주소값(참조값) 비교하는 것 둘은다르다
		System.out.println("cc.equals(dd) : "+cc.equals(dd));//false
		System.out.println();

		Object ee = new Object("apple");
		Object ff = new Object("apple");
		System.out.println("ee==ff : "+(ee==ff));//false 주소값 비교
		System.out.println("ee.equals(ff) : "+ee.equals(ff));//true 문자열 apple 비교
	}
}
/*
class Object{
	public String toString(){// 클래스@16진수
	public int hashCode(){}//주소 값을 10진수로 변경
	public boolean equals(Object){}//참조값 비교
	}
}

public String extends Object{
	public String toString(){} //문자열
	public int hashCode(){}// 문자열을 10진수로 변한 시킨것 (문자열 무한 개수)
	public boolean equals(Object){}//문자열을 비교해주는 것
}

*/