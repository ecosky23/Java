class SungJukMain {
	public static void main(String[] args) {
		SungJuk a = new SungJuk();
		a.setData("ȫ�浿",90,91,91);
		a.calcTot();
		a.calcAvg();
		a.calcGrade();

		System.out.println("�̸�\t����\t����\t����\t����\t���\t����");
		System.out.println(a.getName()+"\t"
								+a.getKor()+"\t"
								+ a.getEng()+"\t"
								+ a.getMath()+"\t"
								+ a.getTot()+"\t"
								+ String.format("%.2f",a.getAvg())+"\t"
								+ a.getGrade());
		SungJuk b = new SungJuk();
		b.setData("������",85,80,81);
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
		c.setData("������",89,82,63);
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
// �̸� ���� ���� ����  ���� ��� ����
// ȫ�浿 90 91 91
// ������ 85 80 91
// ������ 89 82 63
//Ŭ���� ����
//�޼ҵ� ȣ��
//���� - ��� 90�̻��̸� A
//			80		B
//			70		C
//			60		D
//		�׿�         F	