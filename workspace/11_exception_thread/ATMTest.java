import java.util.Scanner;
class ATMTest implements Runnable{
	private long depositeMoney=100000;//잔액
	private long balance;//찾고자 하는 금액

	public static void main(String[] args){
		ATMTest atm = new ATMTest();

		Thread mom = new Thread(atm, "엄마");//atm에 스레드 생성
		Thread son = new Thread(atm, "아들");
		mom.start();//스레드 시작
		son.start();
	}

	@Override
	public synchronized void run(){//한번에 한명씩만 들어온다 아들들어오면 엄마는 아들끝나고 들어온다
		System.out.println(Thread.currentThread().getName()+"님 안녕하세요");//현재 스레드를 가져오기
		
		Scanner scan = new Scanner(System.in);
		System.out.print("찾고자 하는 금액 입력: ");
		balance = scan.nextLong();
		
		withDraw();
			
	
	}
	public void withDraw(){
		if (depositeMoney >= balance ){
			if(balance%10000 == 0){
				depositeMoney = depositeMoney-balance;
				System.out.print("잔액은"+depositeMoney+"원 입니다.");
			}else System.out.print("만원 단위로 입력하세요");
		}else{
			System.out.println("잔액초과");
		}
		
	}
}
