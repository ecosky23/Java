class Final{
	public final String FRUIT="사과";
	public final String FRUIT2;

	public static final String ANIMAL="사자";
	public static final String ANIMAL2;
	static{ANIMAL2 = "기린";}
	public Final(){FRUIT2 = "딸기";}
}


class FinalMain{
	public static void main(String[] args) {
		final int AGE = 10;
		System.out.println("상수 AGE =" +AGE);

		//AGE++; ERROR 상수는 변할수 없는 수이기 때문에 변하면 안된다

		final int AGE2;
		AGE2 = 20;
		System.out.println("상수 AGE2 =" +AGE2);

		Final fi = new Final();
		
		System.out.println("FRUIT = "+fi.FRUIT);
		System.out.println("FRUIT2 = "+fi.FRUIT2);
		System.out.println("ANIMAL = "+fi.ANIMAL);
		System.out.println("ANIMAL2 = "+fi.ANIMAL2);
	}
}
