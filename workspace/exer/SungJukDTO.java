import java.text.DecimalFormat;

class SungJukDTO implements Comparable<SungJukDTO> {
	private int no;
	private String name;
	private int kor, eng, math, tot;
	private double avg;

	public SungJukDTO(int no, String name, int kor, int eng, int math){
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public void calc(){
		tot = kor+eng+math;
		avg = (double)tot/3;
	}

	public int getNo(){
		return this.no;
	}

	public String getName(){
		return this.name;
	}

	@Override
	public String toString(){
		return no+"\t"
			  +name+"\t"
			  +kor+"\t"
			  +eng+"\t"
			  +math+"\t"
			  +tot+"\t"
			  +new DecimalFormat("###.###").format(avg);
	}

	@Override
	public int compareTo(SungJukDTO o){
		return this.tot < o.tot ? 1 : -1; //내림차순
	}	
}










