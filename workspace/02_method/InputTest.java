class InputTest{
	public static void main(String[] args){
		System.out.println("�迭�� args = " + args);

		for(int i =0; i < args.length; i++){ //args.length�� ��ɾ�
			System.out.println("args["+i+"] = " + args[i]);
			System.out.println("���ڼ� =  " + args[i].length());//args[i].length()�� �޼ҵ�(�Լ�)
			System.out.println("ù���� =  " + args[i].charAt(0));//������ ���°�ڸ� ���ڸ� �̾Ƴ��� �Լ�
			System.out.println();
		}//for
		System.out.println("Ȯ���� for");
		for(String data : args){
			System.out.println(data);
		}
		
	}
	
}



/*
����				�迭
�ڷ��� ������		�ڷ���[] �迭�� = {��, ��, ��};

�޼ҵ�()
*/