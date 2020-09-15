import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.Image;
class WindowTest extends Frame{

	public void init(){
		setBounds(700,100,300,400);
			setVisible(true);
	}

	@Override
	public void paint(Graphics g){
		Toolkit t = Toolkit.getDefaultToolkit();//클래스 생성 추상이라서 new가 안된다
		//Image img= t.getImage("lion.png");//이미지 불러오기 라이언 이미지 불러온다 그걸 img에 넣는다.
		Image img= t.getImage("D:/java_se/workspace/07_abstract/lion.png");
		//g.drawImage(img,30,100,this); // 이미지 그리기 그림은 자기자신에 붙여야 된서 this를 쓴다
										//getImage(그림,위치, 위치 , 어디에붙일건지)

	/*g.drawImage(img,				// 화면 크기 조정하기
				30, 100, 250, 300, //화면 위치
				238, 220, 0, 0,	//이미지 위치
				this);			//거꾸로 만들기
*/
		g.drawImage(img,				
					30, 100, 250, 300, 
					238, 0, 0, 220,	
					this);

	
	}
	public static void main(String[] args) {
		new WindowTest().init();//생성자
		
		
	}
}
// 드라이브 경로는 /로쓴다. 