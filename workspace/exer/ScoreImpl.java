import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

class ScoreImpl implements Score {
	private List<ScoreDTO> list = new ArrayList<ScoreDTO>();//부모값 참조하게 List로 받기

	public void input(ScoreDTO dto){
		list.add(dto);
	}

	public void output(DefaultTableModel model){
		model.setRowCount(0);//출력을 눌렀을때 한번만 입력값이 나오게 하기위한 명령어
							//안해주면 출력눌르때마다 테이블에 정보가 계속나옴

		for(ScoreDTO dto : list){//리스트값 dto로 전달
			Vector<String> v = new Vector<String>();
			v.add(dto.getHak());
			v.add(dto.getName());
			v.add(dto.getKor()+"");
			v.add(dto.getEng()+"");
			v.add(dto.getMath()+"");
			v.add(dto.getTot()+"");
			v.add(dto.getAvg());

			model.addRow(v);//model행에 백터 내용 넣기
		}//for	
	}

	public int search(DefaultTableModel model, String hak){//인터페이스인 score에도 같이 넘겨줘야 한다.
		model.setNumRows(0);//출력을 눌렀을때 한번만 입력값이 나오게 하기위한 명령어

		int sw=0;// sw scoreform으로 보내줄것임
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

				model.addRow(v);//v값을 model에 붙이기
				sw=1;//for문으로 들어오면 sw가 1이된다 들어오지 않으면 그대로 sw가 0이다.
			}//if
		}//for

		return sw;//sw값을 리턴 해줘서 scoreform에서 sw값을 쓸수 있게 해줘야 한다.
	}

	public void to_desc(){
		Collections.sort(list);
	}

	public void save(){
		//저장 다이얼로그
		JFileChooser chooser = new JFileChooser();//저장 다이얼로그
		int result = chooser.showSaveDialog(null);
		File file = null;
		if(result == JFileChooser.APPROVE_OPTION){
			file = chooser.getSelectedFile();
		}

		if(file==null) return;
		
		try{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			//버퍼로 객체를 보내고 버퍼에서 파일로 다시보낸다.
			for(ScoreDTO dto : list){
				oos.writeObject(dto);
			}
			oos.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void load(){
		//로드다이얼로그
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(null);
		File file = null;
		if(result == JFileChooser.APPROVE_OPTION){
			file = chooser.getSelectedFile();
		}

		if(file==null) return;

		list.clear();//로드하기전에 리스트를 한번 지워 주기
		try{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
				
			while(true){
				try{
					ScoreDTO dto = (ScoreDTO)ois.readObject();//읽어온 값을 형변화해줘서 dto로 전해줘야한다.
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
