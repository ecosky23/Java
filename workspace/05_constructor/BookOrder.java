//[������]
//å����			����		�ܰ�		����		�հ�
//�ų��� Java		ȫ�浿	25000	10		�ܰ� ���� ���Ѱ�
//��մ� ��		������	35000	7	
//�ű��� ��ũ��Ʈ	������	30000	8
class BookDTO{
	private String title;
	private String author;
	private int price;
	private int qty;
	private int total;

	public BookDTO(String title, String author, int price, int qty){
	this.title = title;
	this.author = author;
	this.price = price;
	this.qty = qty;}
	

	public void calc(){total = price * qty;}

	public String getTitle(){return title;}
	public String getAuthor(){return author;}
	public int getPrice(){return price;}
	public int getQty(){return qty;}
	public int getTotal(){return total;}
	//�����ڸ� ���ؼ� å���� ���� �ܰ� ������ �Է¹޴´�.
	//calc()���� total�� ���Ѵ�.
}

class BookOrder {
	public static void main(String[] args) {
		BookDTO[] aa = new BookDTO[3];
		aa[0] = new BookDTO("�ų��� Java",	"ȫ�浿",25000,10);
		aa[1] = new BookDTO("��մ� ��","������",35000,7);
		aa[2] = new BookDTO("��ũ��Ʈ","������",30000,8);
				
		System.out.println("å����\t����\t�ܰ�\t����\t�հ�");
		
		for(BookDTO data : aa){
		data.calc();
		System.out.println(data.getTitle()+"\t"
					+data.getAuthor()+"\t"
					+data.getPrice()+"\t"
					+data.getQty()+"\t"
					+data.getTotal());
		}
	}
}
