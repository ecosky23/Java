import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.Panel;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//Frame - BorderLayout(동서남북배치)
class WindowTest2 extends Frame implements ActionListener, WindowListener{
	private Button newBtn, exitBtn;
	private TextArea area;

	public void init(){
		newBtn = new Button("새로만들기"); //새로만들어주기 변수 선언 
		exitBtn = new Button("종료");

		area = new TextArea();// 글씨스게 만드는것을 넣어주는 것
		area.setFont(new Font("새굴림",Font.BOLD,20));//글꼴 글자 크기와 폰트를 지정해줌

		Panel p = new Panel();//FlowLayout(중앙 부터 순서대로 배치) 페널을 만들어서 
		p.setBackground(new Color(255,200,255));
		p.add(newBtn);// 페널에 버튼 올리기
		p.add(exitBtn);

		add("North", p);//페널을 북쪽 화면창에 올리기
		add("Center",area); // 글씨쓰는것을 화면에 더해주기

		setBounds(900,100,300,400);
		setVisible(true);

		//이벤트
		this.addWindowListener(this);
		exitBtn.addActionListener(this);// 1.종료버튼을 누르면 나가지게 행동하게하는 명령어
		newBtn.addActionListener(this);// 뉴 버튼을 누르면 행동하게 하는명령어 this는 구동어가 이 클래스에존재한다는 것
}
//ActionListener override

	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand() == "새로만들기"){  // 버튼이 아니라 나와 있는 모양 과 글로 찾는 것
											//계산기에서는 이게더 편하다.
		//if(e.getSource() == newBtn){ // 뉴 버튼이라고 지정되어 있는 것을 누르는 것
			area.setText(" "); //new 버튼을 누르면 초기화 하겠다.
		}else if(e.getSource() == exitBtn){ // 누른버튼이 종료버튼인지 확인
			System.exit(0);
		}// 2.종료버튼 누르면 종료되는 구동
	}
//WindowListener override
	public void windowActivated(WindowEvent e){}//활성화
	public void windowClosed(WindowEvent e){}//x를 누르고 사후처리
	public void windowClosing(WindowEvent e){System.exit(0);}//x를 누르는 순간
	public void windowDeactivated(WindowEvent e){}//비활성화
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}

	public static void main(String[] args) {
		new WindowTest2().init();
	}
}
