class EmployeeDTO {
	
		private String name;
		private	String position;
		private int basicPay;
		private int extraPay;
		private double taxRate;
		private int salary;

		public void setData(String n, String p, int b, int e){
					name = n;
					position = p;
					basicPay = b;
					extraPay = e;
		}
		public void setTaxRate(double t){
					taxRate = t;				
		}
		public int calcPay(){
			salary = (int)(basicPay + extraPay - (basicPay + extraPay)*taxRate);
			return salary;
		}
		
		public String getName(){return name;}
		public String getPosition(){return position;}
		public int getBasicPay(){return basicPay;}
		public int getExtraPay(){return extraPay;}
		public double getTaxRate(){return taxRate;}
		

	}
	


/*
DTO(Data transfer object)
vo(value object)
bean
*/