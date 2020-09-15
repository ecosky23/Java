import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowEvent;

class Login extends Frame implements ActionListener{
	private TextField idT, pwdT;
	private Button loginBtn, exitBtn;

	public Login(){
		idT = new TextField();
		setLayout(null);// 모든 배치 깨버리기
		
		Label idL = new Label("아이디");//라벨만들기 
		idL.setBounds(60,80,80,30);// x y 높이 길이

		Label pwdL = new Label("비밀먼호");
		pwdL.setBounds(60,120,80,30);

		idT = new TextField();
		idT.setBounds(140, 80, 100, 30);

		pwdT = new TextField();
		pwdT.setBounds(140,120, 100, 30);
	
		add(idL); add(idT);
		add(pwdL); add(pwdT);

		loginBtn = new Button("로그인"); //새로만들어주기 변수 선언 
		exitBtn = new Button("취소");
	
		loginBtn.setBounds(60,170,100,30);
		exitBtn.setBounds(170,170,100,30);
	
		add(loginBtn); add(exitBtn);
		
		setBackground(new Color(255,200,255));
		setBounds(900,100,300,300);
		setVisible(true);
	
		addWindowListener(new WindowExit()); // WindowExit 클레스의 것을 가져와 사용
		exitBtn.addActionListener(this);
		loginBtn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == loginBtn){
			String id = idT.getText();
			String pwd = pwdT.getText();
			new LoginResult(id, pwd);
		
		}else if(e.getSource() == exitBtn){
			idT.setText(" ");  idT.setText("");//취소를 누르면 입력창의 초기화
			pwdT.setText(" ");  pwdT.setText("");
		}
	}


	public static void main(String[] args){
		new Login();
	}
}
