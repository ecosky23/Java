import java.util.Scanner;
class StringTest{
	public static void main(String[] args) {
		String aa;
		String bb;
		String cc;
 		Scanner scanner = new Scanner(System.in);
		System.out.print("문자열 입력: ");
		 aa = scanner.nextLine();
		System.out.print("현재 문자열 입력: ");
		 bb = scanner.nextLine();
		 System.out.print("바꿀 문자열 입력: ");
		 cc = scanner.nextLine();
		System.out.println(aa.replace(bb,cc));//1번
		
		String dd;
		String ee;
		String ff;
 		
		System.out.print("문자열 입력: ");
		 dd = scanner.nextLine();
		 dd = dd.toLowerCase();
		System.out.print("현재 문자열 입력: ");
		 ee = scanner.nextLine();
		 System.out.print("바꿀 문자열 입력: ");
		 ff = scanner.nextLine();
		System.out.println(dd.replace(ee,ff));

		String gg;
		String hh;
		String ii;
 		
		System.out.print("문자열 입력: ");
		 gg = scanner.nextLine(); 
		System.out.print("현재 문자열 입력: ");
		 hh = scanner.nextLine();
		 System.out.print("바꿀 문자열 입력: ");
		 ii = scanner.nextLine();
		System.out.println(gg.replace(hh,ii));
		
		String jj;
		String kk;
		String ll;
 		int index;
		int count;
		System.out.print("문자열 입력: ");
		 jj = scanner.nextLine(); 
		 jj = jj.toLowerCase();
		System.out.print("현재 문자열 입력: ");
		 kk = scanner.nextLine();
		 System.out.print("바꿀 문자열 입력: ");
		 ll = scanner.nextLine();
		System.out.print(jj.replace(kk,ll));
		while((index=jj.indexOf(jj, index)) != -1){
			index += jj.length();
			count++;
		}
		System.out.println(jj.replace(jj,finds));
		
		for(;;){
				System.out.print("문자열 입력: ");
				 aa = scanner.nextLine(); 
				
				System.out.print("현재 문자열 입력: ");
				 bb = scanner.nextLine();
				 System.out.print("바꿀 문자열 입력: ");
				 cc = scanner.nextLine();
				System.out.println(aa.replace(bb,cc));
				if(aa.length() < bb.length()){
					System.out.println("입력한 문자열의 크기가 작습니다.");
				}
			break;
		}
	}
	}

