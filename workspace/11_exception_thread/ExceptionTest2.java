import java.io.IOException;
class ExceptionTest2 {
	private int dan;

	public void input() throws IOException{//여기서 에러가 날것을 대비하라 //구현부
		System.out.print("원하는 단을 입력: ");
		dan = System.in.read()-'0';//1개문자 아스키코드로 나온다. 문자 0은 48이다.
									// 아스키 코드 값을 빼야지 원래의 구구단이 나온다.
	}
	
	public void output(){
		if(dan <=9 && dan > 1){
			for(int i = 1; i <= 9; i++){
				System.out.println(dan+"*"+ i +" = " +dan*i);
			}//for
		}else{
			//	System.out.println("숫자는 2~9까지만 가능");
			try{
			//Exception을 발생하려고 한다. 일부러 error을 발생시키려고한다
		//	throw new Exception("숫자는 2~9까지만 가능");
			throw new MakeException("숫자는 2~9까지만 가능");

			}catch(Exception e){
				e.printStackTrace();//스택에 있는 모든 에러메세지를 나오게한다.
			}
		}
	}

	public static void main(String[] args) throws IOException{// IOException은 호출부 구현부 모두 적어줘야한다.
		ExceptionTest2 et = new ExceptionTest2();
			et.input();//호출
			et.output();
	}
}
