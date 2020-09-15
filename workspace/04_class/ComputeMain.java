/*
[½ÇÇà°á°ú]
X   Y   SUMÇÕ	SUBÂ÷	 MUL°ö	  DIV¸ò(¼Ò¼öÀÌÇÏ 3Â°Â¥¸®)
320 258
126 89
257 126
*/
class ComputeTest{
		private int x, y, sum, sub, mul;		
		private double div;

	public void setX(int x){this.x = x;}
	public void setY(int y){this.y = y;}
	public void calc(){
		sum = x + y;
		sub = x - y;
		mul = x * y;
		div = (double)x/y;}
	
	public int getX(){return x;}
	public int getY(){return y;}
	public int getSum(){return sum;}
	public int getSub(){return sub;}
	public int getMul(){return mul;}
	public String getDiv(){return String.format("%.3f",div);}	
}

class ComputeMain {
	public static void main(String[] args) {
		ComputeTest[] ct = new ComputeTest[3];
		ct[0] = new ComputeTest();
		ct[1] = new ComputeTest();
		ct[2] = new ComputeTest();
				
		ct[0].setX(320); ct[0].setY(258);
		ct[1].setX(126); ct[1].setY(89);
		ct[2].setX(257); ct[2].setY(126);
		
		
		System.out.println("X\tY\tÇÕ\tÂ÷\t°ö\t¸ò");
		for(ComputeTest cp : ct){
		cp.calc();
		
		System.out.println(cp.getX()+"\t"
			+cp.getY()+"\t"
			+cp.getSum()+"\t"
			+cp.getSub()+"\t"
			+cp.getMul()+"\t"
			+cp.getDiv()+"\t"
			);
		}
	}
}
