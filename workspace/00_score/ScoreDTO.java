class ScoreDTO{

		private int hak;
		private String name;
		private int kor;
		private int eng;
		private int math;
		private int tot;
		private int avg;

		public ScoreDTO(int hak, String name, int kor, int eng, int math){
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}	

		 


	//	public String setHak(){return hak;}

		public int calcTot(){
			return tot = kor + eng + math;
		}

		public double calcAvg(){
			return avg = tot/3;
		}

		public int getHak(){return hak;}
		public String getName(){return name;}
		public int getKor(){return kor;}
		public int getEng(){return eng;}
		public int getMath(){return math;}
		public int getTot(){return tot;}
		public double getAvg(){return avg;}
	
}
