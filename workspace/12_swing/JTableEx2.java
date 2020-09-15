import java.awt.*;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.JOptionPane;

class JTableEx2 extends JFrame implements ActionListener{
	private ArrayList<PersonDTO> list;
	private Vector<String> vector;
	private DefaultTableModel model;
	private JTable table;
	private JButton addBtn, delBtn;


	public JTableEx2(){
		list = new ArrayList<PersonDTO>();
		list.add(new PersonDTO("hong","ȫ�浿","111","010-123-1234"));
		list.add(new PersonDTO("conan","�ڳ�","333","010-777-7777"));
	

		//Ÿ��Ʋ
		vector = new Vector<String>();
		vector.addElement("���̵�");
		vector.addElement("�̸�");
		vector.add("��й�ȣ");
		vector.add("�ڵ���");

		model = new DefaultTableModel(vector, 0){//1�� �־��ָ� ��ĭ�� �ϳ������
			public boolean isCellEditable(int r, int c){//���������ϰ� �Ѵ�.
				return (c != 0) ? true : false;//���̵� �����Ұ����ϰ� �Ѵ�.
			}	
		};//�̸� ���ุ������� �Է�

		table = new JTable(model);//���� ���̺� �� �ֱ�

		JScrollPane scroll = new JScrollPane(table);//JTable�� ��ũ�ѿ� ���̱�
		
		//������
		for(PersonDTO dto : list){
			Vector<String> v = new Vector<String>();
			v.add(dto.getId());
			v.add(dto.getName());
			v.add(dto.getPwd());
			v.add(dto.getTel());

			model.addRow(v);//�࿡ ���� ���� �ֱ�
		}//for

		//��ư �߰�
		addBtn = new JButton("�߰�");
		delBtn = new JButton("����");		

		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p.add(addBtn);
		p.add(delBtn);

		Container c = getContentPane();
		c.add("Center", scroll);
		c.add("South", p);

		setBounds(700,100,500,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//�̺�Ʈ
		addBtn.addActionListener(this);
		delBtn.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == addBtn){
			insert();
		}else if(e.getSource() == delBtn){
			delete();
		}
	}

	public void insert(){		
		String id = JOptionPane.showInputDialog(this, "���̵� �Է��ϼ���");//������ â�߰� �ϴ°�
		if( id == null || id.length()==0){
			JOptionPane.showMessageDialog(this, "���̵�� �ʼ� �Է»����Դϴ�.");
			return;
		}

		for(int i =0; i<model.getRowCount(); i++){//���̺��� ���Ǽ�
			if(id.equals(model.getValueAt(i,0))){//getValueAt���� ������ ���� �Լ�
				JOptionPane.showMessageDialog(this, "������� ���̵� �Դϴ�.");
					return;
			}
		}

		String name = JOptionPane.showInputDialog(this, "�̸��� �Է��ϼ���");
		String pwd = JOptionPane.showInputDialog(this, "�н����带 �Է��ϼ���");
		String tel = JOptionPane.showInputDialog(this, "��ȭ��ȣ�� �Է��ϼ���");
		
		Vector<String> v = new Vector<String>();//���� ����
			v.add(id);//���Ϳ� �����Է�
			v.add(name);
			v.add(pwd);
			v.add(tel);

			model.addRow(v);//addRow�ٻ��� �ϰ� model�� �Է� �ϱ�
		}

		public void delete(){
			int sw = 0;
			String id = JOptionPane.showInputDialog(this, "������ ���̵� �Է��ϼ���");
			for(int i =0; i<model.getRowCount(); i++){//���̺��� ���Ǽ�
			if(id.equals(model.getValueAt(i,0))){//getValueAt���� ������ ���� �Լ�
				model.removeRow(i);
					i--;
					sw=1;
			}
			}//for	

			if(sw==0){
				JOptionPane.showMessageDialog(this, "������ �̸��� �����ϴ�.");
			}


		}//delete()
		
	public static void main(String[] args){
		new JTableEx2();
	}
}
//���̵� �Է����� ������ �׳� ��������
//���̵� �ߺ��Ǹ� "������� ���̵� �Դϴ�." 
//JOptionPane.showMessageDialog(this, "������ξ��̵��Դϴ�.')�� ���� ��������
//�̸� �Է�, ��й�ȣ �Է�, �ڵ��� �Է�, ���̺� �߰�