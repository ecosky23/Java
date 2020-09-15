class SnackTest extends Thread{//스레드 상속
	private String str;

		public SnackTest(String str){
			this.str = str;
		}

		public void run(){
			for(int i = 1; i<=5; i++){
				System.out.println(str+"\t i = "+i+"\t"+Thread.currentThread());//현재실행되는 스레드 보여줘
			}
		}

	public static void main(String[] args){
		SnackTest aa = new SnackTest("새우깡");//스레드 생성
		SnackTest bb = new SnackTest("포카칩");
		SnackTest cc = new SnackTest("꼬북이");

		aa.setName("새우깡");//스레드에 이름주기
		bb.setName("포카칩");
		cc.setName("꼬북이");

		//우선순위

		aa.setPriority(Thread.NORM_PRIORITY);// 기본값 5
		bb.setPriority(Thread.MIN_PRIORITY);//1
		cc.setPriority(Thread.MAX_PRIORITY);//10

		aa.start();//스레드 시작 - 스레드 실행(run()) 
		try{
		aa.join();//스레드를 대기상태로둔다 스레드를 멈춘다

		}catch(InterruptedException e){
			e.printStackTrace();
		}
		bb.start();
		cc.start();
	}
}
