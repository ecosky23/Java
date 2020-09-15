class FruitDTO{
	private String pum;
	private int jan, feb, mar, tot; 
	private static int sumJan, sumFeb, sumMar; 
	
	public FruitDTO(String pum, int jan, int feb, int mar){
		this.pum = pum;
		this.jan = jan;
		this.feb = feb;
		this.mar = mar;
	}
	public void calcTot(){
		tot = jan + feb + mar;

		sumJan += jan;
		sumFeb += feb;
		sumMar += mar;
			
	}
	public void display(){
		
		System.out.println(pum+"\t"
							+jan+"\t"
							+feb+"\t"
							+mar+"\t"
							+tot);
			
	}
	public static void output(){
		System.out.println("\t"+sumJan+"\t"+sumFeb+"\t"+sumMar);
	}

	
}

class FruitMain {
	public static void main(String[] args) {
				FruitDTO[] aa = new FruitDTO[3];
		            aa[0] = new FruitDTO("사과",100,80,75);
					aa[1] = new FruitDTO("포도",30,25,10);
					aa[2] = new FruitDTO("딸기",25,30,90);

				System.out.println("------------");
				System.out.println("PUM\tJAN\tFEB\tMAR\tTOT");
				System.out.println("------------");	

				for(FruitDTO data : aa){
					data.calcTot();
					data.display();

				}
				System.out.println("=============");
				FruitDTO.output();
	}
}
