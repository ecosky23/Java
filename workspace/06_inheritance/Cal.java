import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
class Cal extends Frame{
		private Button cancel, back;
		private Label dispL, inputL;
		private StringBuffer inputBuf, dispBuf;
		private	Button[] button;


		public Cal(){

			setBounds(900,200,400,500);
			setVisible(true);
			
			addWindowListener(new WindowAdapter(){//윈도우 어뎁터는 추상클레스
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
			});
		}
	public static void main(String[] args) {
		new Cal();
	}
}
