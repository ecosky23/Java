/*주차장 관리
********
1.입차
2.출차
3.목록
4.끝
********
번호:
*/
import java.util.Scanner;
class ArrayTest3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean[] car = new boolean[5];
		while(true){
			System.out.println();
			System.out.println("********");
			System.out.println("1.입차");
			System.out.println("2.출차");
			System.out.println("3.목록");
			System.out.println("4.끝");
			System.out.println("********");
			System.out.print("번호: ");
			int number = scanner.nextInt();
			System.out.println();
			if(number == 1){
				System.out.print("몇번자리에 주차하시겠습니까?");
				int park = scanner.nextInt();
				if(car[park-1]==false){
					car[park-1]=true;
					System.out.println(park+"위치에주차 가능 합니다.");
					System.out.println(park+"번째 위치에 입차 되었습니다.");
				}else {
					System.out.println(park+"주차 불가능 합니다.");
				}
			}else if(number == 2){
				System.out.print("몇번째 자리에서 출차하시겠습니까?");
					int park = scanner.nextInt();
				if(car[park-1]==true){
					car[park-1]=false;
					System.out.println(park+"번째 자리에서 출차 되었습니다.");				
				}else {
					System.out.println(park+"번째 위치에 차가없습니다.");
				}
			}else if(number == 3){
				for(int i = 0; i < car.length; i++){
					System.out.println((i+1)+"번째 위치: "+car[i]);
				}//for
					
			}else if(number == 4){
				System.out.println("이용 끝~~");
				break;
			}
			
		}
	}
}
