import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;


class Calculator extends Frame implements ActionListener{
	String[] str = new String[]{"7","8","9","/",
								"4","5","6","*"
								,"1","2","3","-"
								,".","0","=","+"}; 
		private Label dispL, inputL;// �� 2��
		private Button[] button; // ��ư 16�� 
		private Button back, cancel;// ��ư 2��
		private StringBuffer dispBuf, inputBuf;
		private double result;
		private char op;

		private DecimalFormat df = new DecimalFormat("#,###.###");//3��°���� ��ǥ���
																//�Ҽ��� 3�ڸ�����
		public Calculator(){
			super("����");			
			
			setBackground(new Color(194,238,254));//���� ����
			
			Button[] button = new Button[16]; //�迭�� ��ư 16�������

			dispL = new Label("",Label.RIGHT);//�� 2�� �����
			inputL = new Label("0", Label.RIGHT);//���ڿ��� 0 ����ֱ� ������ ����
			
			dispBuf = new StringBuffer();
			inputBuf = new StringBuffer("0");

			dispL.setFont(new Font("Consolas",Font.BOLD, 20));
			inputL.setFont(new Font("Consolas",Font.BOLD, 20));
			
			
			dispL.setBackground(new Color(255,255,255)); //���� ���
			inputL.setBackground(new Color(255,255,255));
			
			
			back = new Button("��"); //��ư 2���� �� �Է�
			cancel = new Button("C");
			
			Panel an = new Panel();		//��ü �ĳ� �����
			Panel p1 = new Panel();	
			Panel p2 = new Panel();
			Panel p3 = new Panel();		
			Panel p4 = new Panel();		
			Panel la1 = new Panel();
			Panel la2 = new Panel();
			Panel c = new Panel();	

			an.setLayout(new GridLayout(7, 1, 5, 6)); // �ĳ��� ��� �� ���� ������ �Է�	
			p1.setLayout(new GridLayout(1, 4, 6, 5)); // ���� �ĳ� 7�� �����					
			p2.setLayout(new GridLayout(1, 4, 6, 5));			
			p3.setLayout(new GridLayout(1, 4, 6, 5));		
			p4.setLayout(new GridLayout(1, 4, 6, 5));		
			la1.setLayout(new GridLayout(1, 1, 10, 10)); //�� �ĳ� �Է�		
			la2.setLayout(new GridLayout(1, 1, 10, 10));	
			c.setLayout(new GridLayout(1, 2, 5, 1)); //��� �ĳ� �Է�
			
			back.addActionListener(this);// �齺�ǿ��� 
			cancel.addActionListener(this);//C �̺�Ʈ�ֱ�

			for(int i = 0; i < button.length; i++){// ��ư�� �� �Է�
				button[i] = new Button(str[i]);
				button[i].addActionListener(this);
				if(i<=3){
						p1.add(button[i]); // �ٺ��� �Է�
				}else if(i<=7){
						p2.add(button[i]);
				}else if(i<=11){
						p3.add(button[i]);
				}else if(i<=15){
						p4.add(button[i]);
				}
			}		
			
			la1.add(dispL);  //���� ���ǳڿ� �Է�
			la2.add(inputL);
			c.add(back);//�󺧿� �齺���̽� �Է�
			c.add(cancel);
			
			an.add(la1); //��ü �ǳڿ� �ϳ��� �Է�
			an.add(la2);
			an.add(c);
			an.add(p1);
			an.add(p2);
			an.add(p3);
			an.add(p4);

			add(an);//��ü �ǳ��� �Է�

			setBounds(900,200,400,500);//���� ũ�⼳��
			setVisible(true);//���� ������̰�
			setResizable(false);//���� ũ�����

			addWindowListener(new WindowAdapter(){//������ ��ʹ� �߻�Ŭ����
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
					inputBuf.delete(0,1);//0���� ù���ڱ��� ����
				}
				
				inputBuf.append(push);
				//inputL.setText(inputBuf+"");
				inputL.setText(inputBuf+"");
				//inputBuf�� String�� ��ȯ �װ��� ���������� ��ȯ�ϰ� �ٽ� ������������ ��ȯ
		}else if(push=="C"){
			dispBuf.delete(0, dispBuf.length());
			inputBuf.delete(0, inputBuf.length());
			inputBuf.append("0");

			dispL.setText("");
			inputL.setText("0");
			result=op=0;

		}else if(push=="��"){
				inputBuf.delete(inputBuf.length()-1,inputBuf.length());
				if(inputBuf.length()==0) inputBuf.append("0");
				inputL.setText(inputBuf+"");

		}else if(push=="."){
				if(inputBuf.indexOf(".")== -1){
					inputBuf.append(".");
				}
				inputL.setText(inputBuf+"");
		}else if(push=="+"){
				calc();//���
				op = '+';

				dispBuf.append(inputBuf+"+");
				dispL.setText(dispBuf+"");
				inputL.setText(df.format(result));//�߰����
				inputBuf.delete(0,inputBuf.length());
		}else if(push=="-"){
				calc();//���
				op = '-';
				dispBuf.append(inputBuf+"-");
				dispL.setText(dispBuf+"");
			inputL.setText(df.format(result));
			inputBuf.delete(0,inputBuf.length());
		}else if(push=="*"){
			calc();//���
			op = '*';
			dispBuf.append(inputBuf+"*");
			dispL.setText(dispBuf+"");
			inputL.setText(df.format(result));
			inputBuf.delete(0,inputBuf.length());
		}else if(push=="/"){
			calc();//���
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
			inputL.setText(df.format(result));//�������

			inputBuf.delete(0,inputBuf.length());//������ ������
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
