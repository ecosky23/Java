import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
class JTableModel extends AbstractTableModel{//javax.swing.table�� �߻�Ŭ������
	Object[][] data = {{"Nari","����ġ",new Integer(1234),"����ģ��"},
						{"One","������",new Integer(1111),"������"},
						{"tow","������",new Integer(2222),"�Ϳ�����"},
						{"three","�ƶ�ġ",new Integer(3333),"���Ƹ� ģ��"}};

	String[] name = {"���̵�","�̸�","��й�ȣ","����"};//�ʵ�� ��

	public int getColumnCount(){//���̺��� ���Ǽ� [�ʼ�]
		return name.length;//return 4;�� ����
	}
	public int getRowCount(){//���̺��� ���Ǽ� [�ʼ�]
		return data.length;//return 4;�� ����
	}
	public Object getValueAt(int r, int c){//���� ������ ���� [�ʼ�]
		return data[r][c];//return 4;�� ����
	}
	public boolean isCellEditable(int r, int c){//���������ϰ� �Ѵ�.
		return (c != 0) ? true : false;
	}
	public String getColumnName(int c){//���̺��� Ÿ��Ʋ�� �ο�
		return name[c];
	}
	public void setValueAt(Object obj, int r, int c){//�ʵ尪 ����
		data[r][c]=obj;
	}
	
	
}


public class JTableEx extends JFrame{
	JTable table;
	JTableModel model;//����� ������ Ŭ����
	public JTableEx(){
		model = new JTableModel(); table = new JTable(model);
		add(new JScrollPane(table));//��ũ�ѹ� �����ϸ鼭
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,200,300,300);
		setVisible(true);
	
}


	public static void main(String[] args){
		new JTableEx();
	}
}
