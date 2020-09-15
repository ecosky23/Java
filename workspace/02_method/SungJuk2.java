import java.util.Scanner;
class SungJuk2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("�̸��� �Է��ϼ���: ");
		String name = scanner.next();
		System.out.println("���������� �Է��ϼ���: ");
		int kor = scanner.nextInt();
		System.out.println("���������� �Է��ϼ���: ");
		int math = scanner.nextInt();
		System.out.println("���������� �Է��ϼ���: ");
		int eng = scanner.nextInt();
		
		SungJuk2 sj = new SungJuk2();
		int tot = sj.calcTot(kor, eng, math);
		double avg = sj.calcAvg(tot);
		sj.disp(name, kor, eng, math, tot, avg);
		scanner.close();
	}

	public int calcTot(int kor, int eng, int math){
		return kor + eng + math;
	}
	public double calcAvg(int tot){
		return tot/3.0;
	}
	public void disp(String name, int kor, int eng, int math, int tot, double avg){
	System.out.println();
	System.out.println(" ******" + name + " *****");
	System.out.println("����\t����\t����\t����\t���");
	System.out.println(kor + "\t"+ eng + "\t" 
					+ math +"\t"+ tot + "\t"+
					String.format("%.2f", avg));
	}

}
