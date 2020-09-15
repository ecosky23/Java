class JoinTest implements Runnable{
	@Override
	public void run(){
		for(int i = 1; i<=5; i++){
			System.out.println(i);
			try{
			Thread.sleep(500);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}


class JoinMain{
	public static void main(String[] args)throws InterruptedException{
		JoinTest jt = new JoinTest();
		Thread t = new Thread(jt);//������ ����
		System.out.println("�����尡 ����");
		t.start();//������ ����
		
		t.join();//������ ���� �����尡 ������ ������ ���׹��׵ȴ� �׷��� ���⼭ �����帣 �����༭
					//������� �Ϸ��� �����带 �����ؾ� �Ѵ�.

		System.out.println("������ ����");
		
	}
	
}
