import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

class SungJukAction {
	private ArrayList<SungJukDTO> list;
	Scanner scanner = new Scanner(System.in);

	public SungJukAction(){
		list = new ArrayList<SungJukDTO>();
	}

	public void menu(){
		int choice;
		while(true){
			System.out.println();
			System.out.println("*****************");
			System.out.println("   1. �Է�");
			System.out.println("   2. ���");
			System.out.println("   3. �˻�");
			System.out.println("   4. ����");
			System.out.println("   5. ����");
			System.out.println("   6. ��");
			System.out.println("*****************");
			System.out.print("   > ");
			choice = scanner.nextInt();
			if(choice == 6) break;

			if(choice == 1) insertArticle();
			else if(choice == 2) printArticle();
			else if(choice == 3) searchArticle();
			else if(choice == 4) deleteArticle();
			else if(choice == 5) sortArticle();
		}//while
	}//menu()

	public void insertArticle(){
		System.out.print("��ȣ �Է� : ");
		int no = scanner.nextInt();
		for(int i=0; i<list.size(); i++){
			if(no == list.get(i).getNo()){
				System.out.println("�ߺ��� ��ȣ�Դϴ�");
				return;
			}
		}

		System.out.print("�̸� �Է� : ");
		String name = scanner.next();
		System.out.print("���� �Է� : ");
		int kor = scanner.nextInt();
		System.out.print("���� �Է� : ");
		int eng = scanner.nextInt();
		System.out.print("���� �Է� : ");
		int math = scanner.nextInt();
		
		SungJukDTO dto = new SungJukDTO(no, name,kor,eng,math);
		dto.calc();

		list.add(dto);
	}

	public void printArticle(){
		System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���");
		for(SungJukDTO dto : list){
			System.out.println(dto);
		}
	}
	
	public void searchArticle(){
		int sw=0;
		System.out.print("�˻� �� �̸� �Է� : ");
		String name = scanner.next();
		for(SungJukDTO dto : list){
			if(name.equals(dto.getName())){
				System.out.println(dto);
				sw=1;
			}
		}//for

		if(sw==0) System.out.println("ã���� �ϴ� �̸��� �����ϴ�");
	}

	public void deleteArticle() {
		System.out.print("���� �� �̸� �Է� : ");
		String name = scanner.next();
		int sw = 0;

		Iterator<SungJukDTO> it = list.iterator();	
		while(it.hasNext()){  //���� ��ġ�� �׸��� ������ T, ������ F
			SungJukDTO dto = it.next(); //���� ��ġ�� �׸��� ������ �������� �̵�
			if(name.equals(dto.getName())){
				it.remove(); //it.next()���� ��ȯ�� �׸��� �����
				sw=1;
			}
		}//while

		if(sw == 0){
			System.out.println("ã���� �ϴ� �̸��� �����ϴ�");
		}else {
			System.out.println("�����͸� �����Ͽ����ϴ�");
		}
	}

	public void sortArticle() {
		while(true){
			System.out.println();
			System.out.println("1. �̸����� ��������");
			System.out.println("2. �������� ��������");
			System.out.println("3. �����޴�");
			System.out.print("   ��ȣ �Է� : ");
			int num = scanner.nextInt();
			if(num==3) break;

			if(num==1){
				Comparator<SungJukDTO> com = new Comparator<SungJukDTO>(){
					@Override
					public int compare(SungJukDTO t1, SungJukDTO t2){
						return t1.getName().compareTo(t2.getName());
					}
				};

				Collections.sort(list, com);
				printArticle();

			}else if(num==2){
				Collections.sort(list);
				printArticle();
			}
		}
	}

	
	
}
