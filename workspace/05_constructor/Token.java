import java.util.StringTokenizer;
class Token{
	public static void main(String[] args) {
		String str = "학원,집,,게임방";// 토근으로 분해 "학원""집""게임방" 3개나옴
									//split으로 분해"학원" "집" " " "게임방" 4개나옴	
	
			StringTokenizer st = new StringTokenizer(str, ",");
			System.out.println("토큰 개수 = "+ st.countTokens());

			while(st.hasMoreTokens()){
				System.out.println(st.nextToken());
			}//토근이 있으면 계속 반복 없으면 멈춤
			System.out.println("=============");

			String[] ar = str.split(",");
			for(String data : ar){
				System.out.println(data);// 학원, 집, 빈공간, 게임방 4가지 나옴
			}
	}
	
	
}
