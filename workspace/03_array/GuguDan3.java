/*
2*1=2   3*1=3   4*1=4
2*2=4   3*2=6   4*2=8
2*3=6   3*3=9   4*3=12
2*4=8   3*4=12  4*4=16
2*5=10  3*5=15  4*5=20
2*6=12  3*6=18  4*6=24
2*7=14  3*7=21  4*7=28
2*8=16  3*8=24  4*8=32
2*9=18  3*9=27  4*9=36
 5*1=5   6*1=6   7*1=7
 5*2=10  6*2=12  7*2=14
 5*3=15  6*3=18  7*3=21
 5*4=20  6*4=24  7*4=28
 5*5=25  6*5=30  7*5=35
 5*6=30  6*6=36  7*6=42
 5*7=35  6*7=42  7*7=49
 5*8=40  6*8=48  7*8=56
 5*9=45  6*9=54  7*9=63
3중 for문을 사용해라
*/

class GuguDan3 {
	public static void main(String[] args) {
		int dan, i;
		for(i=1; i <= 9; i++){
				for(dan=2; dan <= 4; dan++){
					System.out.print(dan+"*"+i+"="+ dan*i+ "\t");			
}
				System.out.println();				
}
			System.out.println();
		for(i=1; i <= 9; i++){
				for(dan=5; dan <= 7; dan++){
					System.out.print(dan+"*"+i+"="+ dan*i+ "\t");					
}
				System.out.println();				
}
			System.out.println();
		for(i=1; i <= 9; i++){
				for(dan=8; dan <= 9; dan++){
					System.out.print(dan+"*"+i+"="+ dan*i+ "\t");					
}
				System.out.println();
				
}
	
}
}