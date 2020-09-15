import java.util.Scanner;
class SungJuk2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("이름을 입력하세요: ");
		String name = scanner.next();
		System.out.println("국어점수를 입력하세요: ");
		int kor = scanner.nextInt();
		System.out.println("수학점수를 입력하세요: ");
		int math = scanner.nextInt();
		System.out.println("영어점수를 입력하세요: ");
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
	System.out.println("국어\t영어\t수학\t총점\t평균");
	System.out.println(kor + "\t"+ eng + "\t" 
					+ math +"\t"+ tot + "\t"+
					String.format("%.2f", avg));
	}

}
