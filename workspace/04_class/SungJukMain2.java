class SungJukMain2{
	public static void main(String[] args) {
		SungJuk[] ar = new SungJuk[3]; //��ü �迭
		ar[0] = new SungJuk(); //Ŭ���� �����
		ar[1] = new SungJuk();
		ar[2] = new SungJuk();

		ar[0].setData("ȫ�浿",90,91,91);
		ar[1].setData("������",85,80,81);
		ar[2].setData("������",89,82,63);

		for(int i= 0; i<ar.length; i++){
		ar[i].calcTot();		
		ar[i].calcAvg();
		ar[i].calcGrade();

		System.out.println(ar[i].getName()+"\t"
								+ar[i].getKor()+"\t"
								+ ar[i].getEng()+"\t"
								+ ar[i].getMath()+"\t"
								+ ar[i].getTot()+"\t"
								+ String.format("%.2f",ar[i].getAvg())+"\t"
								+ ar[i].getGrade());
		}
	}
}
