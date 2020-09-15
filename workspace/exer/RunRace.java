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
		super("�� ����");
		btn = new Button(" ��� ");

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

		//�̺�Ʈ
		btn.addActionListener(this);

	}//RunRace()

	@Override
	public void actionPerformed(ActionEvent e){
		btn.setEnabled(false);
		Thread[] t = new Thread[count];

		for(int i=0; i<count; i++){
			t[i] = new Thread(racer[i]); //������ ����
			t[i].setPriority((int)(Math.random()*10)+1); //�켱���� 1~10
			t[i].start(); //������ ���� - ������ ����(run())
		}
	}

	public static void main(String[] args) {
		if(args.length < 2){
			System.out.println("Usage : java RunRace count name1, ...");
			System.exit(0);
		}

		if(Integer.parseInt(args[0]) != args.length-1){
			System.out.println("�� �������� �̸��� ������ ���� �ʽ��ϴ�.");
			System.exit(0);
		}

		new RunRace(args);		
	}
}
