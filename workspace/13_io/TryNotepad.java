import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.ScrollPaneConstants;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.BufferedWriter;

class TryNotepad extends JFrame implements ActionListener{
	private JTextArea output; 	
	private JScrollPane sc;
	private MenuPane menu;
	private File file;
	
	public TryNotepad(){

		Container c = getContentPane();
		output = new JTextArea();
		sc = new JScrollPane(output);
		sc.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);//�����ʿ� ��ũ�ѻ��ܼ� ������
		
		menu = new MenuPane();
		setJMenuBar(menu);

		c.add(sc);

		setBounds(700,100,700,500);
		setVisible(true);
		setTitle("���ܸ޸���");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				int result = JOptionPane.showConfirmDialog(TryNotepad.this,//�޽��� �����ġ
										 "������ �����Ͻðڽ��ϱ�?",//�޼���
										"����",//����
										JOptionPane.YES_NO_CANCEL_OPTION,//���ø޴�
										JOptionPane.QUESTION_MESSAGE);//�̹���
			 if(result == JOptionPane.YES_OPTION){//�����ϰ� ����
				saveDialog();//���� ���̾�α�
				fileWrite();//���� �б�
				System.exit(0);
			 }else if(result == JOptionPane.NO_OPTION){//���� ���ϰ� ����
				System.exit(0);
			 }
			}
		});
	
	}
	
	public void event(){
		menu.getExitM().addActionListener(this);
		menu.getNewM().addActionListener(this);
		menu.getOpenM().addActionListener(this);
		menu.getSaveM().addActionListener(this);
		menu.getCutM().addActionListener(this);
		menu.getCopyM().addActionListener(this);
		menu.getPasteM().addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){

		if(e.getSource() == menu.getExitM()){
			 int result = JOptionPane.showConfirmDialog(this,
										 "������ �����Ͻðڽ��ϱ�?",
										"����",
										JOptionPane.YES_NO_CANCEL_OPTION,
										JOptionPane.QUESTION_MESSAGE);
			 if(result == JOptionPane.YES_OPTION){//�����ϰ� ����
				saveDialog();//���� ���̾�α�
				fileWrite();//���� �б�
				System.exit(0);
			 }else if(result == JOptionPane.NO_OPTION){//���� ���ϰ� ����
				System.exit(0);
			 }


		}else if(e.getSource() == menu.getNewM()){
			output.setText("");
		}else if(e.getSource() == menu.getOpenM()){
			openDialog();//���� ���̾�α�
			fileRead();//���� �б�
		}else if(e.getSource() == menu.getSaveM()){
			saveDialog();//���� ���̾�α�
			fileWrite();//���� �б�
		}else if(e.getSource() == menu.getCutM()){
			output.cut();
		}else if(e.getSource() == menu.getCopyM()){
			output.copy();
		}else if(e.getSource() == menu.getPasteM()){
			output.paste();
		}
	}

	public void openDialog(){//�޴��ٿ� ���������� ������ ����޴��� ������.
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(this);

		if(result == JFileChooser.APPROVE_OPTION){
			 file = chooser.getSelectedFile();
		}
		JOptionPane.showMessageDialog(this, file);//������ ��ġ�� �޽����� ��Ÿ���ش�.
	}
	public void fileRead(){
		if(file==null) return;
		output.setText("");
		try{
		BufferedReader br = new BufferedReader(new FileReader(file));//������ ���� ��������
		String line;

		while((line = br.readLine())!=null){//���Ͼ��� ������ ���� �б�(����ġ�� �������� �����̴�.)
			//output.setText(line); - �����
			output.append(line+"\n");
		}//while    ���پ��о ������ ���� null�̵ȴ�.
		br.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}

	public void saveDialog(){//���� �����ϱ�
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showSaveDialog(this);//���� ���̾�α׿��� ���̺�� �ٲ��ֱ⸸ �ϸ�ȴ�.

		if(result == JFileChooser.APPROVE_OPTION){
			 file = chooser.getSelectedFile();
		}
		JOptionPane.showMessageDialog(this, file);
		
	}

	public void fileWrite(){//�ҷ�����, ����
		if(file==null) return;
		try{
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		String data = output.getText();
		bw.write(data);
		bw.close();
	}catch(IOException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		new TryNotepad().event();
	}
}
/*
1. ���� ���̾�α�(x, �޴� - ����)
"������ �����Ͻðڽ��ϱ�?" - ��, �ƴϿ�, ���

2.MenuPane.java
����Ű - �߶󳻱� ALT + X
		���� ALT + C
		�ٿ��ֱ� ALT + v

3.ó�� ������ �ؼ� ���� ���̾�α� - ���(error)
���� �ߴ°� �ȶ߰� �ϱ�
*/