class SungJukMain {
	public static void main(String[] args) {
		SungJuk a = new SungJuk();
		a.setData("홍길동",90,91,91);
		a.calcTot();
		a.calcAvg();
		a.calcGrade();

		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t학점");
		System.out.println(a.getName()+"\t"
								+a.getKor()+"\t"
								+ a.getEng()+"\t"
								+ a.getMath()+"\t"
								+ a.getTot()+"\t"
								+ String.format("%.2f",a.getAvg())+"\t"
								+ a.getGrade());
		SungJuk b = new SungJuk();
		b.setData("김전일",85,80,81);
		b.calcTot();
		b.calcAvg();
		b.calcGrade();
		System.out.println(b.getName()+"\t"
								+b.getKor()+"\t"
								+b.getEng()+"\t"
								+b.getMath()+"\t"
								+b.getTot()+"\t"
								+ String.format("%.2f",b.getAvg())+"\t"
								+b.getGrade());

		SungJuk c = new SungJuk();
		c.setData("남도일",89,82,63);
		c.calcTot();
		c.calcAvg();
		c.calcGrade();
		System.out.println(c.getName()+"\t"
								+c.getKor()+"\t"
								+c.getEng()+"\t"
								+c.getMath()+"\t"
								+c.getTot()+"\t"
								+ String.format("%.2f",c.getAvg())+"\t"
								+c.getGrade());
	}
}
// 이름 국어 영어 수학  총점 평균 학점
// 홍길동 90 91 91
// 김전일 85 80 91
// 남도일 89 82 63
//클래스 생성
//메소드 호출
//학점 - 평균 90이상이면 A
//			80		B
//			70		C
//			60		D
//		그외         F	