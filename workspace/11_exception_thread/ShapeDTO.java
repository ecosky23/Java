enum Figure {
	LINE, CIRCLE, RECT, ROUNDRECT, PEN;//enum에서는 (;)세미콜론 없어도됨
}

class ShapeDTO{//도형 1개의 정보
	public static final int LINE = 1;
	public static final int CIRCLE = 2;

	private int x1, y1, x2, y2, z1, z2;
	private boolean fill; 
	private Figure shape;
	private int combo;

	public void setX1(int x1){
		this.x1 = x1;
	}
	public void setY1(int y1){
		this.y1 = y1;
	}
	public void setX2(int x2){
		this.x2 = x2;
	}
	public void setY2(int y2){
		this.y2 = y2;
	}
	public void setZ1(int z1){
		this.z1 = z1;
	}
	public void setZ2(int z2){
		this.z2 = z2;
	}

	public boolean setFill(int x1){
		this.x1 = x1;
	}

}
