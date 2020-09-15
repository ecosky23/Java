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
			System.out.println("   1. 입력");
			System.out.println("   2. 출력");
			System.out.println("   3. 검색");
			System.out.println("   4. 삭제");
			System.out.println("   5. 정렬");
			System.out.println("   6. 끝");
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
		System.out.print("번호 입력 : ");
		int no = scanner.nextInt();
		for(int i=0; i<list.size(); i++){
			if(no == list.get(i).getNo()){
				System.out.println("중복된 번호입니다");
				return;
			}
		}

		System.out.print("이름 입력 : ");
		String name = scanner.next();
		System.out.print("국어 입력 : ");
		int kor = scanner.nextInt();
		System.out.print("영어 입력 : ");
		int eng = scanner.nextInt();
		System.out.print("수학 입력 : ");
		int math = scanner.nextInt();
		
		SungJukDTO dto = new SungJukDTO(no, name,kor,eng,math);
		dto.calc();

		list.add(dto);
	}

	public void printArticle(){
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
		for(SungJukDTO dto : list){
			System.out.println(dto);
		}
	}
	
	public void searchArticle(){
		int sw=0;
		System.out.print("검색 할 이름 입력 : ");
		String name = scanner.next();
		for(SungJukDTO dto : list){
			if(name.equals(dto.getName())){
				System.out.println(dto);
				sw=1;
			}
		}//for

		if(sw==0) System.out.println("찾고자 하는 이름이 없습니다");
	}

	public void deleteArticle() {
		System.out.print("삭제 할 이름 입력 : ");
		String name = scanner.next();
		int sw = 0;

		Iterator<SungJukDTO> it = list.iterator();	
		while(it.hasNext()){  //현재 위치에 항목이 있으면 T, 없으면 F
			SungJukDTO dto = it.next(); //현재 위치에 항목을 꺼내고 다음으로 이동
			if(name.equals(dto.getName())){
				it.remove(); //it.next()에서 반환한 항목을 지운다
				sw=1;
			}
		}//while

		if(sw == 0){
			System.out.println("찾고자 하는 이름이 없습니다");
		}else {
			System.out.println("데이터를 삭제하였습니다");
		}
	}

	public void sortArticle() {
		while(true){
			System.out.println();
			System.out.println("1. 이름으로 오름차순");
			System.out.println("2. 총점으로 내림차순");
			System.out.println("3. 이전메뉴");
			System.out.print("   번호 입력 : ");
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
