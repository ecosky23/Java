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
		Thread t = new Thread(jt);//스레드 생성
		System.out.println("쓰레드가 시작");
		t.start();//스레드 시작
		
		t.join();//스레드 해제 스레드가 있으면 순서가 뒤죽박죽된다 그래서 여기서 쓰레드르 끝내줘서
					//순서대로 하려면 스레드를 해제해야 한다.

		System.out.println("쓰레드 종료");
		
	}
	
}
