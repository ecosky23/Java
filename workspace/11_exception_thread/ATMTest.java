import java.util.Scanner;
class ATMTest implements Runnable{
	private long depositeMoney=100000;//�ܾ�
	private long balance;//ã���� �ϴ� �ݾ�

	public static void main(String[] args){
		ATMTest atm = new ATMTest();

		Thread mom = new Thread(atm, "����");//atm�� ������ ����
		Thread son = new Thread(atm, "�Ƶ�");
		mom.start();//������ ����
		son.start();
	}

	@Override
	public synchronized void run(){//�ѹ��� �Ѹ��� ���´� �Ƶ������ ������ �Ƶ鳡���� ���´�
		System.out.println(Thread.currentThread().getName()+"�� �ȳ��ϼ���");//���� �����带 ��������
		
		Scanner scan = new Scanner(System.in);
		System.out.print("ã���� �ϴ� �ݾ� �Է�: ");
		balance = scan.nextLong();
		
		withDraw();
			
	
	}
	public void withDraw(){
		if (depositeMoney >= balance ){
			if(balance%10000 == 0){
				depositeMoney = depositeMoney-balance;
				System.out.print("�ܾ���"+depositeMoney+"�� �Դϴ�.");
			}else System.out.print("���� ������ �Է��ϼ���");
		}else{
			System.out.println("�ܾ��ʰ�");
		}
		
	}
}
