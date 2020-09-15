
/*
2´Ü ~ 9´Ü
2*1=2
2*2=4
2*3=6
2*4=8
2*5=10
....
2*9=18
3*1=3
....
3*9=27
*/


class GuguDan {
	public static void main(String[] args) {
		int dan, i;
		for(dan=2; dan <= 9; dan++){
			for(i=1; i <= 9; i++){
				System.out.println(dan+"*"+i+"="+ dan*i);
			}
		
		System.out.println();
		}
		
	}
}
