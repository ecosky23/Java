import java.io.IOException;
class ExceptionTest2 {
	private int dan;

	public void input() throws IOException{//���⼭ ������ ������ ����϶� //������
		System.out.print("���ϴ� ���� �Է�: ");
		dan = System.in.read()-'0';//1������ �ƽ�Ű�ڵ�� ���´�. ���� 0�� 48�̴�.
									// �ƽ�Ű �ڵ� ���� ������ ������ �������� ���´�.
	}
	
	public void output(){
		if(dan <=9 && dan > 1){
			for(int i = 1; i <= 9; i++){
				System.out.println(dan+"*"+ i +" = " +dan*i);
			}//for
		}else{
			//	System.out.println("���ڴ� 2~9������ ����");
			try{
			//Exception�� �߻��Ϸ��� �Ѵ�. �Ϻη� error�� �߻���Ű�����Ѵ�
		//	throw new Exception("���ڴ� 2~9������ ����");
			throw new MakeException("���ڴ� 2~9������ ����");

			}catch(Exception e){
				e.printStackTrace();//���ÿ� �ִ� ��� �����޼����� �������Ѵ�.
			}
		}
	}

	public static void main(String[] args) throws IOException{// IOException�� ȣ��� ������ ��� ��������Ѵ�.
		ExceptionTest2 et = new ExceptionTest2();
			et.input();//ȣ��
			et.output();
	}
}
