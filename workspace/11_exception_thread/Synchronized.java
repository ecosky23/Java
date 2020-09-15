class Synchronized extends Thread{
	private static int count=0;

	public static void main(String[] args){
		Synchronized aa = new Synchronized();//������ ���� 3�� ����
		Synchronized bb = new Synchronized();
		Synchronized cc = new Synchronized();
		
		aa.setName("aa");
		bb.setName("bb");
		cc.setName("cc");
		//������ ���� - ������ ����
		aa.start();
		bb.start();
		cc.start();
	}

	public void run(){
		synchronized(Synchronized.class){//����ȭ
	//	synchronized(this){����ȭ�� �ȵȴ�
		for(int i = 1; i<=5; i++){
			count++;
			System.out.println(Thread.currentThread().getName()+" count= "+count);//���� ������ ����
		}
	}
	}

}
