import java.util.Scanner;
class MemberMain{
	Scanner scan = new Scanner(System.in);
	MemberDTO[] ar = new MemberDTO[5];//�迭�� ��ü����
	public void menu(){
		int choice;
		while(true){
		System.out.println();
		System.out.println("**********");
		System.out.println("1.���� ");
		System.out.println("2.��� ");
		System.out.println("3.���� ");
		System.out.println("4.Ż�� ");
		System.out.println("5.�� ");
		System.out.println("**********");
		System.out.println("��ȣ: ");
		choice = scan.nextInt();
		if(choice == 5)break;

		if(choice == 1) this.insert();//1���� ������ �Ʒ��� �żҵ� ����
		else if(choice == 2) list();
		else if(choice == 3) update();
		else if(choice == 4) delete();
		else System.out.println("1~5�� ���ڸ� �Է��ϼ��� ");
		}//while
	}

	public void insert(){
		int i;
		for(i = 0; i<ar.length; i++){
			if(ar[i] == null){
			ar[i] = new MemberDTO();
			System.out.println("�̸� : ");
			ar[i].setName(scan.next());
			System.out.println("���� : ");
			ar[i].setAge(scan.nextInt());
			System.out.println("��ȭ��ȣ : ");
			ar[i].setPhone(scan.next());
			System.out.println("�ּ� : ");
			ar[i].setAddress(scan.next());
			break;
			}//for ���ڸ��� �ִ��� Ȯ��
			}

			if(i==ar.length){System.out.println("5���� ������ �� á���ϴ�.");
				return;//�޼ҵ带 ����� i�� ar.length==5 �� �������� ������ ������
			}//�迭�� �ο��� ����

			int count=0;
			for(i=0; i<ar.length; i++){
				if(ar[i] == null)count++;
			}//�迭�� ���ڸ��� �����ִ��� �˾ƺ��� ����
			System.out.println("1 row creaded");
			System.out.println(count+"�ڸ� ���ҽ��ϴ�. ");		
	}
	public void list(){
			System.out.println("�̸�\t����\t��ȭ��ȣ\t�ּ�");
		for(MemberDTO data : ar){
			if(data != null){
				System.out.println(data.getName()+"\t"
									+data.getAge()+"\t"
									+data.getPhone()+"\t"
									+data.getAddress());
			}
		}
	}
	public void update(){
		System.out.println();
		System.out.println("�ڵ��� ��ȣ �Է�: ");
		String phone = scan.next();
		int i;
		for(i = 0; i<ar.length; i++){
			if(ar[i] != null){
				if(ar[i].getPhone().equals(phone)){
					System.out.println(ar[i].getName()+"\t"
									+ar[i].getAge()+"\t"
									+ar[i].getPhone()+"\t"
									+ar[i].getAddress());

									//����
					System.out.println();
					System.out.print("������ �̸� �Է�: ");
					ar[i].setName(scan.next());
					System.out.print("��ȭ��ȣ : ");
					ar[i].setPhone(scan.next());
					System.out.print("�ּ� : ");
					ar[i].setAddress(scan.next());

					System.out.println("1 row(s) updated");
					break;
				}
			}
		}//for
		if(i==ar.length)
			System.out.println("ã�� ȸ���� �����ϴ�");
	}
		public void delete(){
			System.out.println();
			System.out.print("�ڵ��� ��ȣ �Է�: ");
			String phone = scan.next();
			int i;
			for(i = 0; i<ar.length; i++){
				if(ar[i] != null){
					if(ar[i].getPhone().equals(phone)){
					ar[i] = null;
					System.out.println("1 row creaded");
					break;
				}
			}
		}
		if(i==ar.length)
			System.out.println("ã�� ȸ���� �����ϴ�.");
		
	}
	public static void main(String[] args){
		MemberMain main = new MemberMain();
		main.menu();
		System.out.println("���α׷��� �����մϴ�.");
	}
}
