import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

class ScoreImpl implements Score {
	private List<ScoreDTO> list = new ArrayList<ScoreDTO>();//�θ� �����ϰ� List�� �ޱ�

	public void input(ScoreDTO dto){
		list.add(dto);
	}

	public void output(DefaultTableModel model){
		model.setRowCount(0);//����� �������� �ѹ��� �Է°��� ������ �ϱ����� ��ɾ�
							//�����ָ� ��´��������� ���̺� ������ ��ӳ���

		for(ScoreDTO dto : list){//����Ʈ�� dto�� ����
			Vector<String> v = new Vector<String>();
			v.add(dto.getHak());
			v.add(dto.getName());
			v.add(dto.getKor()+"");
			v.add(dto.getEng()+"");
			v.add(dto.getMath()+"");
			v.add(dto.getTot()+"");
			v.add(dto.getAvg());

			model.addRow(v);//model�࿡ ���� ���� �ֱ�
		}//for	
	}

	public int search(DefaultTableModel model, String hak){//�������̽��� score���� ���� �Ѱ���� �Ѵ�.
		model.setNumRows(0);//����� �������� �ѹ��� �Է°��� ������ �ϱ����� ��ɾ�

		int sw=0;// sw scoreform���� �����ٰ���
		for(ScoreDTO dto : list){
			if(hak.equals(dto.getHak())) {
				Vector<String> v = new Vector<String>();
				v.add(dto.getHak());
				v.add(dto.getName());
				v.add(dto.getKor()+"");
				v.add(dto.getEng()+"");
				v.add(dto.getMath()+"");
				v.add(dto.getTot()+"");
				v.add(dto.getAvg());

				model.addRow(v);//v���� model�� ���̱�
				sw=1;//for������ ������ sw�� 1�̵ȴ� ������ ������ �״�� sw�� 0�̴�.
			}//if
		}//for

		return sw;//sw���� ���� ���༭ scoreform���� sw���� ���� �ְ� ����� �Ѵ�.
	}

	public void to_desc(){
		Collections.sort(list);
	}

	public void save(){
		//���� ���̾�α�
		JFileChooser chooser = new JFileChooser();//���� ���̾�α�
		int result = chooser.showSaveDialog(null);
		File file = null;
		if(result == JFileChooser.APPROVE_OPTION){
			file = chooser.getSelectedFile();
		}

		if(file==null) return;
		
		try{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			//���۷� ��ü�� ������ ���ۿ��� ���Ϸ� �ٽú�����.
			for(ScoreDTO dto : list){
				oos.writeObject(dto);
			}
			oos.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void load(){
		//�ε���̾�α�
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(null);
		File file = null;
		if(result == JFileChooser.APPROVE_OPTION){
			file = chooser.getSelectedFile();
		}

		if(file==null) return;

		list.clear();//�ε��ϱ����� ����Ʈ�� �ѹ� ���� �ֱ�
		try{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
				
			while(true){
				try{
					ScoreDTO dto = (ScoreDTO)ois.readObject();//�о�� ���� ����ȭ���༭ dto�� ��������Ѵ�.
					list.add(dto);
				}catch(EOFException e){ //EOF - End Of File
					break;
				}

			}//while

			ois.close();
		}catch(IOException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
}
