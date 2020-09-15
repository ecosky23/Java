import java.util.ArrayList;
import java.util.Scanner;
//import java.util.Iterator;
class SungJukAction{
	//private ArrayList<SungJukDTO> list;
	Scanner scanner = new Scanner(System.in);
	ArrayList<SungJukDTO> list = new ArrayList<SungJukDTO>();
	
	SungJukDTO dto = new SungJukDTO();
	
	int choice;

	public void menu(){
		while(true){
		System.out.println("***********");
		System.out.println("  1.�Է�");
		System.out.println("  2.���");
		System.out.println("  3.�˻�");
		System.out.println("  4.����");
		System.out.println("  5.����");
		System.out.println("  6.��");
		System.out.println("***********");
		System.out.println();
		System.out.print("��ȣ :  ");
		choice = scanner.nextInt();
		if(choice == 6) break;

		if(choice == 1) insertArticle();
		else if(choice == 2) printArticle();
		else if(choice == 3) searchArticle();
		else if(choice == 4) deleteArticle();
		else if(choice == 5) sortArticle();
		//else if(choice == 6){System.out.println(); 
		//					 System.out.println("�߸��Է��ϼ̽��ϴ�.");}
		}//while
	}
		
	public ArrayList<SungJukDTO> insertArticle(){
		
		System.out.print("��ȣ �Է� : ");
			int	no = scanner.nextInt();
		System.out.print("�̸� �Է� : ");
			String name = scanner.next();
		System.out.print("���� �Է� : ");
			int kor = scanner.nextInt();
		System.out.print("���� �Է� : ");
			int eng = scanner.nextInt();
		System.out.print("���� �Է� : ");
			int math = scanner.nextInt();
		
		  dto.SungJukDTO(no, name, kor, eng, math);
		
			list.add(dto);
		
			return list;	
		
	}

	public void printArticle(){
		System.out.println("��ȣ\t�̸�\t����\t����\t����\t���");
		for(int i = 0; i < list.size(); i++){
		System.out.println(list.get(i).getNo()+"\t"
							+list.get(i).getName()+"\t"
							+list.get(i).getEng()+"\t"
							+list.get(i).getMath()+"\t"
							+list.get(i).calcTot()+"\t"
							+list.get(i).calcAvg()+"\n");
		}
	}

	public void searchArticle(){
		for(int i = 0; i < list.size(); i++){
		System.out.print("�˻� �� �̸� �Է�: ");
			String name = scanner.next();
			if(name.equals(list.get(i).getName())){
				System.out.println("��ȣ\t�̸�\t����\t����\t����\t���");
				System.out.println(list.get(i).getNo()+"\t"
							+list.get(i).getName()+"\t"
							+list.get(i).getEng()+"\t"
							+list.get(i).getMath()+"\t"
							+list.get(i).calcTot()+"\t"
							+list.get(i).calcAvg());
			}
		}
	}
		
	public void deleteArticle(){
		System.out.print("���� �� �̸� �Է�: ");
		String name = scanner.next();
		for(int i = 0; i < list.size(); i++){
			if(name.equals(list.get(i).getName())){
				list.remove(i);
		System.out.print("�����͸� ���� �Ͽ����ϴ�. ");
			}else{
				System.out.println("������ �����Ͱ� �����ϴ�. ");
			}
		}
	}
/*		
		System.out.print("���� �� �̸� �Է�: ");
		String name = scanner.next();
		int sw = 0;

		Iterator<SungJukDTO> it = list.iterator();//�ݺ���
		while(it.hasNext()){//���� ��ġ�� �׸��� ������ true ������ false
		SungJukDTO dto = it.next()//���� ��ġ�� �׸��� ������ �������� �̵�
		if(name.equals(list.get(i).getName())){
			it.remove();//it.next()���� ��ȯ�� �׸��� �����.
			sw=1
		}
		}//while

*/


	public void sortArticle(){
		while(true){
				System.out.println();
				System.out.println("1. �̸����� ��������");
				System.out.println("");
				System.out.println("");
				System.out.println("");

		}
	}


}
