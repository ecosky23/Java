class SnackTest extends Thread{//������ ���
	private String str;

		public SnackTest(String str){
			this.str = str;
		}

		public void run(){
			for(int i = 1; i<=5; i++){
				System.out.println(str+"\t i = "+i+"\t"+Thread.currentThread());//�������Ǵ� ������ ������
			}
		}

	public static void main(String[] args){
		SnackTest aa = new SnackTest("�����");//������ ����
		SnackTest bb = new SnackTest("��īĨ");
		SnackTest cc = new SnackTest("������");

		aa.setName("�����");//�����忡 �̸��ֱ�
		bb.setName("��īĨ");
		cc.setName("������");

		//�켱����

		aa.setPriority(Thread.NORM_PRIORITY);// �⺻�� 5
		bb.setPriority(Thread.MIN_PRIORITY);//1
		cc.setPriority(Thread.MAX_PRIORITY);//10

		aa.start();//������ ���� - ������ ����(run()) 
		try{
		aa.join();//�����带 �����·εд� �����带 �����

		}catch(InterruptedException e){
			e.printStackTrace();
		}
		bb.start();
		cc.start();
	}
}
