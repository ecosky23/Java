class Factory{
	private int product;

	public synchronized void produce(){
		if(product>4){//������ 4���� ������ �����ߴ�
			System.out.println("���� �ߴ�: "+product);
			try{
			wait();//�����ߴ�
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		product++;
		System.out.println("����: "+product);
		notifyAll();//���� �����带 ������
	}

	public synchronized void sell(){
		if(product<1){
			System.out.println("�Һ� �ߴ�: "+product);
			try{
			wait();//�����ߴ�
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		product--;
		System.out.println("�Һ� �ߴ�:"+product);
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
		Worker w = new Worker(f);//������ ����
		Buyer b = new Buyer(f);
		w.start();
		b.start();
	}
}
