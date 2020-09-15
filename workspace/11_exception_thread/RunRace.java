import java.awt.*;
import java.awt.event.*;
class RunRace extends Frame implements ActionListener{
		private Button btn;
		private int count;
		private Racer[] racer;
	
		public RunRace(String[] args){
			super("말 경주");		
			btn = new Button(" 출발 ");

			count = Integer.parseInt(args[0]);//입력한 말의 개수
			
			setVisible(true);
			setBounds(700,200,600,400);

			Panel p = new Panel(new GridLayout(count,1));//말의 개수에 따라 패널 생성
			
			
			racer = new Racer[count];
				for(int i = 0; i<racer.length; i++){
				racer[i] = new Racer(args[i+1]);
				p.add(racer[i]);
			//	racer[i].setBackground(new Color((int)(Math.random()*255,255,255)));//배경색 랜덤으로 나오게하기
			}//for
			
			Panel p2 = new Panel(new FlowLayout(FlowLayout.RIGHT));//버튼을 오른쪽으로 보내기위해
			
			p2.add(btn);

			add("Center",p);
			add("South",p2);
	
			addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
				}
				});

			btn.addActionListener(this);
		}//RunRace

			@Override
			public void actionPerformed(ActionEvent e){
				btn.setEnabled(false);//버튼 한번 누르면 비활성화시키기
				Thread[] t =new Thread[count];
				
				for(int i = 0; i<count; i++){
				t[i] = new Thread(racer[i]);//스레드 생성
				t[i].setPriority((int)(Math.random()*10)+1);//우선순위 1~10
				t[i].start();//스레드 시작 - 스레드 실행(run())
				}
			}


	public static void main(String[] args){
		
		if(args.length < 2){
			System.out.println("Usage : java RunRace count name1, ...");
			System.exit(0);
		}

		if(Integer.parseInt(args[0]) != args.length-1){
			System.out.println("말 마리수와 이름의 개수가 맞지 않습니다.");
			System.exit(0);
		}

		new RunRace(args);

	}
}
