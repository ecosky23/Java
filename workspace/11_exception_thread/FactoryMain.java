class Factory{
	private int product;

	public synchronized void produce(){
		if(product>4){//물건이 4개가 넘으면 생산중단
			System.out.println("생산 중단: "+product);
			try{
			wait();//생산중단
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		product++;
		System.out.println("생산: "+product);
		notifyAll();//상대방 스레드를 깨워라
	}

	public synchronized void sell(){
		if(product<1){
			System.out.println("소비 중단: "+product);
			try{
			wait();//생산중단
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		product--;
		System.out.println("소비 중단:"+product);
		notifyAll();
	}
}

class Worker extends Thread{
	private Factory factory;

	public Worker(Factory factory){
		this.factory = factory;
	}

	public void run(){
		for(int i =0; i<12; i++){
			factory.produce();
		}
	}
}

class Buyer extends Thread{
	private Factory factory;

	public Buyer(Factory factory){
		this.factory = factory;
	}

	public void run(){
		for(int i =0; i<12; i++){
			factory.sell();
		}
	}
}


class FactoryMain{
	public static void main(String[] args){
		Factory f = new Factory();
		Worker w = new Worker(f);//스레드 생성
		Buyer b = new Buyer(f);
		w.start();
		b.start();
	}
}
