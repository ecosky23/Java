import java.util.StringTokenizer;
class Token{
	public static void main(String[] args) {
		String str = "�п�,��,,���ӹ�";// ������� ���� "�п�""��""���ӹ�" 3������
									//split���� ����"�п�" "��" " " "���ӹ�" 4������	
	
			StringTokenizer st = new StringTokenizer(str, ",");
			System.out.println("��ū ���� = "+ st.countTokens());

			while(st.hasMoreTokens()){
				System.out.println(st.nextToken());
			}//����� ������ ��� �ݺ� ������ ����
			System.out.println("=============");

			String[] ar = str.split(",");
			for(String data : ar){
				System.out.println(data);// �п�, ��, �����, ���ӹ� 4���� ����
			}
	}
	
	
}
