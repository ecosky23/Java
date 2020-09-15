class SungJuk {
	private String name;
	private int kor, eng, math, tot;
	private double avg;
	private char grade;
	
	public void setData(String n, int k, int e, int m){
		name = n;
		kor = k;
		eng = e;
		math = m;
	}			
	public void calcTot(){
		tot = kor+eng+math;
	}
	public void	calcAvg(){
		avg = (double)tot/3;
		}
	public void calcGrade(){
		if(avg>=90) grade = 'A';
		else if(avg>=80) grade = 'B';
		else if(avg>=70) grade = 'C';
		else if(avg>=60) grade = 'D';
		else grade = 'F';
	}

	public String getName(){return name;}
	public int getKor(){return kor;}
	public int getEng(){return eng;}
	public int getMath(){return math;}
	public int getTot(){return tot;}
	public double getAvg(){return avg;}
	public char getGrade(){return grade;}
}
/*//setData(이름, 국어, 영어, 수학)
//메소드 작성
//calcTot()
//calcAvg()
//calcGrade()
getName()
getKor()
getEng()
getMath()
getTot()
getAvg()
getGrade()

*/