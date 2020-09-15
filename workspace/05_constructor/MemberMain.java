import java.util.Scanner;
class MemberMain{
	Scanner scan = new Scanner(System.in);
	MemberDTO[] ar = new MemberDTO[5];//배열의 객체선언
	public void menu(){
		int choice;
		while(true){
		System.out.println();
		System.out.println("**********");
		System.out.println("1.가입 ");
		System.out.println("2.출력 ");
		System.out.println("3.수정 ");
		System.out.println("4.탈퇴 ");
		System.out.println("5.끝 ");
		System.out.println("**********");
		System.out.println("번호: ");
		choice = scan.nextInt();
		if(choice == 5)break;

		if(choice == 1) this.insert();//1번을 누르면 아래의 매소드 실행
		else if(choice == 2) list();
		else if(choice == 3) update();
		else if(choice == 4) delete();
		else System.out.println("1~5번 숫자만 입력하세요 ");
		}//while
	}

	public void insert(){
		int i;
		for(i = 0; i<ar.length; i++){
			if(ar[i] == null){
			ar[i] = new MemberDTO();
			System.out.println("이름 : ");
			ar[i].setName(scan.next());
			System.out.println("나이 : ");
			ar[i].setAge(scan.nextInt());
			System.out.println("전화번호 : ");
			ar[i].setPhone(scan.next());
			System.out.println("주소 : ");
			ar[i].setAddress(scan.next());
			break;
			}//for 빈자리가 있는지 확인
			}

			if(i==ar.length){System.out.println("5명의 정원이 꽉 찼습니다.");
				return;//메소드를 벗어나라 i가 ar.length==5 와 같아지면 정원이 꽉찬것
			}//배열의 인원이 다참

			int count=0;
			for(i=0; i<ar.length; i++){
				if(ar[i] == null)count++;
			}//배열의 빈자리가 남아있는지 알아보는 과정
			System.out.println("1 row creaded");
			System.out.println(count+"자리 남았습니다. ");		
	}
	public void list(){
			System.out.println("이름\t나이\t전화번호\t주소");
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
		System.out.println("핸드폰 번호 입력: ");
		String phone = scan.next();
		int i;
		for(i = 0; i<ar.length; i++){
			if(ar[i] != null){
				if(ar[i].getPhone().equals(phone)){
					System.out.println(ar[i].getName()+"\t"
									+ar[i].getAge()+"\t"
									+ar[i].getPhone()+"\t"
									+ar[i].getAddress());

									//수정
					System.out.println();
					System.out.print("수정할 이름 입력: ");
					ar[i].setName(scan.next());
					System.out.print("전화번호 : ");
					ar[i].setPhone(scan.next());
					System.out.print("주소 : ");
					ar[i].setAddress(scan.next());

					System.out.println("1 row(s) updated");
					break;
				}
			}
		}//for
		if(i==ar.length)
			System.out.println("찾는 회원이 없습니다");
	}
		public void delete(){
			System.out.println();
			System.out.print("핸드폰 번호 입력: ");
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
			System.out.println("찾는 회원이 없습니다.");
		
	}
	public static void main(String[] args){
		MemberMain main = new MemberMain();
		main.menu();
		System.out.println("프로그램을 종료합니다.");
	}
}
