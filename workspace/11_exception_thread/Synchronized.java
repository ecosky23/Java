class Synchronized extends Thread{
	private static int count=0;

	public static void main(String[] args){
		Synchronized aa = new Synchronized();//스레드 생성 3개 생성
		Synchronized bb = new Synchronized();
		Synchronized cc = new Synchronized();
		
		aa.setName("aa");
		bb.setName("bb");
		cc.setName("cc");
		//스레드 시작 - 스레드 실행
		aa.start();
		bb.start();
		cc.start();
	}

	public void run(){
		synchronized(Synchronized.class){//동기화
	//	synchronized(this){동기화가 안된다
		for(int i = 1; i<=5; i++){
			count++;
			System.out.println(Thread.currentThread().getName()+" count= "+count);//현재 스레드 보기
		}
	}
	}

}
