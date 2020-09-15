import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;


class Calculator extends Frame implements ActionListener{
	String[] str = new String[]{"7","8","9","/",
								"4","5","6","*"
								,"1","2","3","-"
								,".","0","=","+"}; 
		private Label dispL, inputL;// 라벨 2개
		private Button[] button; // 버튼 16개 
		private Button back, cancel;// 버튼 2개
		private StringBuffer dispBuf, inputBuf;
		private double result;
		private char op;

		private DecimalFormat df = new DecimalFormat("#,###.###");//3번째마다 쉼표찍고
																//소수점 3자리까지
		public Calculator(){
			super("계산기");			
			
			setBackground(new Color(194,238,254));//배경색 선택
			
			Button[] button = new Button[16]; //배열로 버튼 16개만들고

			dispL = new Label("",Label.RIGHT);//라벨 2개 만들기
			inputL = new Label("0", Label.RIGHT);//문자열로 0 집어넣기 오른쪽 정렬
			
			dispBuf = new StringBuffer();
			inputBuf = new StringBuffer("0");

			dispL.setFont(new Font("Consolas",Font.BOLD, 20));
			inputL.setFont(new Font("Consolas",Font.BOLD, 20));
			
			
			dispL.setBackground(new Color(255,255,255)); //라벨의 배경
			inputL.setBackground(new Color(255,255,255));
			
			
			back = new Button("←"); //버튼 2개에 글 입력
			cancel = new Button("C");
			
			Panel an = new Panel();		//전체 파넬 만들기
			Panel p1 = new Panel();	
			Panel p2 = new Panel();
			Panel p3 = new Panel();		
			Panel p4 = new Panel();		
			Panel la1 = new Panel();
			Panel la2 = new Panel();
			Panel c = new Panel();	

			an.setLayout(new GridLayout(7, 1, 5, 6)); // 파넬의 행과 열 옆의 사이즈 입력	
			p1.setLayout(new GridLayout(1, 4, 6, 5)); // 내부 파넬 7개 만들기					
			p2.setLayout(new GridLayout(1, 4, 6, 5));			
			p3.setLayout(new GridLayout(1, 4, 6, 5));		
			p4.setLayout(new GridLayout(1, 4, 6, 5));		
			la1.setLayout(new GridLayout(1, 1, 10, 10)); //라벨 파넬 입력		
			la2.setLayout(new GridLayout(1, 1, 10, 10));	
			c.setLayout(new GridLayout(1, 2, 5, 1)); //취소 파넬 입력
			
			back.addActionListener(this);// 백스피에스 
			cancel.addActionListener(this);//C 이벤트주기

			for(int i = 0; i < button.length; i++){// 버튼에 글 입력
				button[i] = new Button(str[i]);
				button[i].addActionListener(this);
				if(i<=3){
						p1.add(button[i]); // 줄별로 입력
				}else if(i<=7){
						p2.add(button[i]);
				}else if(i<=11){
						p3.add(button[i]);
				}else if(i<=15){
						p4.add(button[i]);
				}
			}		
			
			la1.add(dispL);  //라벨을 라벨판넬에 입력
			la2.add(inputL);
			c.add(back);//라벨에 백스페이스 입력
			c.add(cancel);
			
			an.add(la1); //전체 판넬에 하나씩 입력
			an.add(la2);
			an.add(c);
			an.add(p1);
			an.add(p2);
			an.add(p3);
			an.add(p4);

			add(an);//전체 판넬을 입력

			setBounds(900,200,400,500);//계산기 크기설정
			setVisible(true);//계산기 모습보이게
			setResizable(false);//계산기 크기고정

			addWindowListener(new WindowAdapter(){//윈도우 어뎁터는 추상클레스
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
			});

		}
		
	public void actionPerformed(ActionEvent e){
		String push = e.getActionCommand();
		if( push == "1" || 
			push == "2" ||
			push == "3" ||
			push == "4" ||
			push == "5" ||
			push == "6" ||
			push == "7" ||
			push == "8" ||
			push == "9" || 
			push == "0"){
				
				dispL.setText(dispBuf+"");

				if(inputBuf.length() == 1 && inputBuf.toString().equals("0")){
					inputBuf.delete(0,1);//0에서 첫글자까지 삭제
				}
				
				inputBuf.append(push);
				//inputL.setText(inputBuf+"");
				inputL.setText(inputBuf+"");
				//inputBuf를 String로 변환 그것을 더블형으로 변환하고 다시 포멧형식으로 변환
		}else if(push=="C"){
			dispBuf.delete(0, dispBuf.length());
			inputBuf.delete(0, inputBuf.length());
			inputBuf.append("0");

			dispL.setText("");
			inputL.setText("0");
			result=op=0;

		}else if(push=="←"){
				inputBuf.delete(inputBuf.length()-1,inputBuf.length());
				if(inputBuf.length()==0) inputBuf.append("0");
				inputL.setText(inputBuf+"");

		}else if(push=="."){
				if(inputBuf.indexOf(".")== -1){
					inputBuf.append(".");
				}
				inputL.setText(inputBuf+"");
		}else if(push=="+"){
				calc();//계산
				op = '+';

				dispBuf.append(inputBuf+"+");
				dispL.setText(dispBuf+"");
				inputL.setText(df.format(result));//중간결과
				inputBuf.delete(0,inputBuf.length());
		}else if(push=="-"){
				calc();//계산
				op = '-';
				dispBuf.append(inputBuf+"-");
				dispL.setText(dispBuf+"");
			inputL.setText(df.format(result));
			inputBuf.delete(0,inputBuf.length());
		}else if(push=="*"){
			calc();//계산
			op = '*';
			dispBuf.append(inputBuf+"*");
			dispL.setText(dispBuf+"");
			inputL.setText(df.format(result));
			inputBuf.delete(0,inputBuf.length());
		}else if(push=="/"){
			calc();//계산
			op = '/';
			dispBuf.append(inputBuf+"/");
			dispL.setText(dispBuf+"");
			inputL.setText(df.format(result));
			inputBuf.delete(0,inputBuf.length());
		}else if(push=="="){
			if(inputBuf.length()==0)return;
			calc();
			op = 0;
			dispBuf.append(inputBuf+"=");
			dispL.setText(dispBuf+"");
			inputL.setText(df.format(result));//최종결과

			inputBuf.delete(0,inputBuf.length());//다지워 버리기
			dispBuf.delete(0,inputBuf.length());
						
		}
	}//actionPerformed

	public void calc(){
		if(op==0) result = Double.parseDouble(inputBuf+"");
		else if(op=='+')result = result + Double.parseDouble(inputBuf+"");
		else if(op=='-')result = result - Double.parseDouble(inputBuf+"");
		else if(op=='*')result = result * Double.parseDouble(inputBuf+"");
		else if(op=='/')result = result / Double.parseDouble(inputBuf+"");
	}

	public static void main(String[] args) {
			new Calculator();

	}
}
