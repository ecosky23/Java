import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class RunRace extends Frame implements ActionListener {
	private Button btn;
	private int count;
	private Racer[] racer;

	public RunRace(String[] args){
		super("말 경주");
		btn = new Button(" 출발 ");

		count = Integer.parseInt(args[0]);

		Panel p = new Panel(new GridLayout(count,1));
		racer = new Racer[count];
		for(int i=0; i<racer.length; i++){
			racer[i] = new Racer(args[i+1]);
			p.add(racer[i]);
			//racer[i].setBackground(new Color((int)(Math.random()*256), 200, (int)(Math.random()*256)));
		}//for

		Panel p2 = new Panel(new FlowLayout(FlowLayout.RIGHT));
		p2.add(btn);

		add("Center", p);
		add("South", p2);

		setBounds(700, 200, 600, 400);
		setVisible(true);
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});

		//이벤트
		btn.addActionListener(this);

	}//RunRace()

	@Override
	public void actionPerformed(ActionEvent e){
		btn.setEnabled(false);
		Thread[] t = new Thread[count];

		for(int i=0; i<count; i++){
			t[i] = new Thread(racer[i]); //스레드 생성
			t[i].setPriority((int)(Math.random()*10)+1); //우선순위 1~10
			t[i].start(); //스레드 시작 - 스레드 실행(run())
		}
	}

	public static void main(String[] args) {
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
