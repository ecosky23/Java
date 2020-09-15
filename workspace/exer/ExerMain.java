
class ExerMain {
	public static void main(String[] args) {
		Exer[] a = new Exer[3];

		a[0] = new Exer();
		a[1] = new Exer();
		a[2] = new Exer();

		a[0].setData("È«±æµ¿",90,90,90);
		a[1].setData("±èÀüÀÏ",80,70,60);
		a[2].setData("È«±æµ¿",60,70,90);
		
		for(int i = 0; i < a.length; i++){
			a[i].setTot();
			a[i].setAvg();
			a[i].setGrade();
			System.out.println(a[i].getName()+"\t"
							+a[i].getKor()+"\t"
							+a[i].getEng()+"\t"
							+a[i].getMath()+"\t"
							+a[i].getTot()+"\t"
							+String.format("%.2f",a[i].getAvg())+"\t"
							+a[i].getGrade());


		}
	}
}
