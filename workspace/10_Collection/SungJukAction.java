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
		System.out.println("  1.입력");
		System.out.println("  2.출력");
		System.out.println("  3.검색");
		System.out.println("  4.삭제");
		System.out.println("  5.정렬");
		System.out.println("  6.끝");
		System.out.println("***********");
		System.out.println();
		System.out.print("번호 :  ");
		choice = scanner.nextInt();
		if(choice == 6) break;

		if(choice == 1) insertArticle();
		else if(choice == 2) printArticle();
		else if(choice == 3) searchArticle();
		else if(choice == 4) deleteArticle();
		else if(choice == 5) sortArticle();
		//else if(choice == 6){System.out.println(); 
		//					 System.out.println("잘못입력하셨습니다.");}
		}//while
	}
		
	public ArrayList<SungJukDTO> insertArticle(){
		
		System.out.print("번호 입력 : ");
			int	no = scanner.nextInt();
		System.out.print("이름 입력 : ");
			String name = scanner.next();
		System.out.print("국어 입력 : ");
			int kor = scanner.nextInt();
		System.out.print("영어 입력 : ");
			int eng = scanner.nextInt();
		System.out.print("수학 입력 : ");
			int math = scanner.nextInt();
		
		  dto.SungJukDTO(no, name, kor, eng, math);
		
			list.add(dto);
		
			return list;	
		
	}

	public void printArticle(){
		System.out.println("번호\t이름\t국어\t영어\t총점\t평균");
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
		System.out.print("검색 할 이름 입력: ");
			String name = scanner.next();
			if(name.equals(list.get(i).getName())){
				System.out.println("번호\t이름\t국어\t영어\t총점\t평균");
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
		System.out.print("삭제 할 이름 입력: ");
		String name = scanner.next();
		for(int i = 0; i < list.size(); i++){
			if(name.equals(list.get(i).getName())){
				list.remove(i);
		System.out.print("데이터를 삭제 하였습니다. ");
			}else{
				System.out.println("삭제할 데이터가 없습니다. ");
			}
		}
	}
/*		
		System.out.print("삭제 할 이름 입력: ");
		String name = scanner.next();
		int sw = 0;

		Iterator<SungJukDTO> it = list.iterator();//반복문
		while(it.hasNext()){//현재 위치에 항목이 있으면 true 없으면 false
		SungJukDTO dto = it.next()//현재 위치에 항목을 꺼내고 다음으로 이동
		if(name.equals(list.get(i).getName())){
			it.remove();//it.next()에서 반환한 항목을 지운다.
			sw=1
		}
		}//while

*/


	public void sortArticle(){
		while(true){
				System.out.println();
				System.out.println("1. 이름으로 오름차순");
				System.out.println("");
				System.out.println("");
				System.out.println("");

		}
	}


}
