import java.io.Serializable;
import java.text.DecimalFormat;

class ScoreDTO implements Comparable<ScoreDTO>, Serializable {
	private String hak;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;

	public void calc() {
		tot = kor + eng + math;
		avg = tot/3.0;
	}

	public void setHak(String hak) {this.hak = hak;}
	public void setName(String name) {this.name = name;}
	public void setKor(int kor) {this.kor = kor;}
	public void setEng(int eng) {this.eng = eng;}
	public void setMath(int math) {this.math = math;}

	public String getHak() {return hak;}
	public String getName() {return name;}
	public int getKor() {return kor;}
	public int getEng() {return eng;}
	public int getMath() {return math;}
	public int getTot() {return tot;}
	public String getAvg() {
		return new DecimalFormat("0.###").format(avg);
	}

	@Override
	public int compareTo(ScoreDTO dto){
		/*		//내림차순
		if(this.tot > dto.tot) return -1;
		else if(this.tot < dto.tot) return 1;
		else return 0;			*/
		//조건 연산자
		//조건 ? 참 : 거짓;
		return this.tot > dto.tot ? -1 : 1;
	}
}















