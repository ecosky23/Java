import java.awt.*;
import java.awt.event.*;
class RunRace extends Frame implements ActionListener{
		private Button btn;
		private int count;
		private Racer[] racer;
	
		public RunRace(String[] args){
			super("�� ����");		
			btn = new Button(" ��� ");

			count = Integer.parseInt(args[0]);//�Է��� ���� ����
			
			setVisible(true);
			setBounds(700,200,600,400);

			Panel p = new Panel(new GridLayout(count,1));//���� ������ ���� �г� ����
			
			
			racer = new Racer[count];
				for(int i = 0; i<racer.length; i++){
				racer[i] = new Racer(args[i+1]);
				p.add(racer[i]);
			//	racer[i].setBackground(new Color((int)(Math.random()*255,255,255)));//���� �������� �������ϱ�
			}//for
			
			Panel p2 = new Panel(new FlowLayout(FlowLayout.RIGHT));//��ư�� ���������� ����������
			
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
				btn.setEnabled(false);//��ư �ѹ� ������ ��Ȱ��ȭ��Ű��
				Thread[] t =new Thread[count];
				
				for(int i = 0; i<count; i++){
				t[i] = new Thread(racer[i]);//������ ����
				t[i].setPriority((int)(Math.random()*10)+1);//�켱���� 1~10
				t[i].start();//������ ���� - ������ ����(run())
				}
			}


	public static void main(String[] args){
		
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
