import java.text.DecimalFormat;
class SungJukDTO implements Comparable<SungJukDTO>{
	private int no;
	private String name;
	private int kor, eng, math, tot;
	private double avg;

	public void SungJukDTO(int no, String name, int kor, int eng, int math){
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public int calcTot(){
		tot = kor + eng + math;
		return tot;
	}
	public double calcAvg(){
		return avg = (double)tot/3;		
	}

	public int getNo(){return no;}
	public String getName(){return name;}
	public int getEng(){return eng;}
	public int getMath(){return math;}
	public int getTot(){return tot;}
	public double getAvg(){return avg;}
	
	@Override
		public String toString(){
			return no+"\t"+name+"\t"
							+kor+"\t"
							+eng+"\t"
							+math+"\t"
							+tot+"\t"
							+new DecimalFormat("#,###.###").format(avg);
		}

	@Override
		public int compareTo(SungJukDTO o){
			return 
		}


}
