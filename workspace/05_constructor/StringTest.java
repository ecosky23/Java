import java.util.Scanner;
class StringTest{
	public static void main(String[] args) {
		String aa;
		String bb;
		String cc;
 		Scanner scanner = new Scanner(System.in);
		System.out.print("���ڿ� �Է�: ");
		 aa = scanner.nextLine();
		System.out.print("���� ���ڿ� �Է�: ");
		 bb = scanner.nextLine();
		 System.out.print("�ٲ� ���ڿ� �Է�: ");
		 cc = scanner.nextLine();
		System.out.println(aa.replace(bb,cc));//1��
		
		String dd;
		String ee;
		String ff;
 		
		System.out.print("���ڿ� �Է�: ");
		 dd = scanner.nextLine();
		 dd = dd.toLowerCase();
		System.out.print("���� ���ڿ� �Է�: ");
		 ee = scanner.nextLine();
		 System.out.print("�ٲ� ���ڿ� �Է�: ");
		 ff = scanner.nextLine();
		System.out.println(dd.replace(ee,ff));

		String gg;
		String hh;
		String ii;
 		
		System.out.print("���ڿ� �Է�: ");
		 gg = scanner.nextLine(); 
		System.out.print("���� ���ڿ� �Է�: ");
		 hh = scanner.nextLine();
		 System.out.print("�ٲ� ���ڿ� �Է�: ");
		 ii = scanner.nextLine();
		System.out.println(gg.replace(hh,ii));
		
		String jj;
		String kk;
		String ll;
 		int index;
		int count;
		System.out.print("���ڿ� �Է�: ");
		 jj = scanner.nextLine(); 
		 jj = jj.toLowerCase();
		System.out.print("���� ���ڿ� �Է�: ");
		 kk = scanner.nextLine();
		 System.out.print("�ٲ� ���ڿ� �Է�: ");
		 ll = scanner.nextLine();
		System.out.print(jj.replace(kk,ll));
		while((index=jj.indexOf(jj, index)) != -1){
			index += jj.length();
			count++;
		}
		System.out.println(jj.replace(jj,finds));
		
		for(;;){
				System.out.print("���ڿ� �Է�: ");
				 aa = scanner.nextLine(); 
				
				System.out.print("���� ���ڿ� �Է�: ");
				 bb = scanner.nextLine();
				 System.out.print("�ٲ� ���ڿ� �Է�: ");
				 cc = scanner.nextLine();
				System.out.println(aa.replace(bb,cc));
				if(aa.length() < bb.length()){
					System.out.println("�Է��� ���ڿ��� ũ�Ⱑ �۽��ϴ�.");
				}
			break;
		}
	}
	}

