//[실행결과]
//책제목			저자		단가		개수		합계
//신나는 Java		홍길동	25000	10		단가 개수 곱한값
//재밌는 웹		김전일	35000	7	
//신기한 스크립트	남도일	30000	8
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
	//생성자를 통해서 책제목 저자 단가 개수를 입력받는다.
	//calc()에서 total를 구한다.
}

class BookOrder {
	public static void main(String[] args) {
		BookDTO[] aa = new BookDTO[3];
		aa[0] = new BookDTO("신나는 Java",	"홍길동",25000,10);
		aa[1] = new BookDTO("재밌는 웹","김전일",35000,7);
		aa[2] = new BookDTO("스크립트","남도일",30000,8);
				
		System.out.println("책제목\t저자\t단가\t개수\t합계");
		
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
