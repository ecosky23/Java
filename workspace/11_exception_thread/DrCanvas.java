import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class DrCanvas extends Canvas{
	private MsPaint msPaint;
	public DrCanvas(MsPaint msPaint){//msPaint값을 받아온다
		 
		this.setBackground(new Color(192,240,255));
		this.msPaint = msPaint;

	}


	@Override
	public void paint(Graphics g){
		int x1, y1, x2, y2, z1, z2;
		//복원 - ArrayList에 있는 ShapeDTO를 하나씩 꺼내서 다시 그린다
		for(ShapeDTO dto : msPaint.getList()){
			x1 = dto.getX1();
			y1 = dto.getY1();
			x2 = dto.getX2();
			y2 = dto.getY2();
			z1 = dto.getZ1();
			z2 = dto.getZ2();
			//색
			switch(dto.getCombo()){
			case 0 : g.setColor(new Color(255,0,0)); break;//setcolor은 그래픽에서 나온다
			case 1 : g.setColor(new Color(55,202,81)); break;
			case 2 : g.setColor(new Color(51,26,232)); break;
			case 3 : g.setColor(new Color(196,62,189)); break;
			case 4 : g.setColor(new Color(132,233,251)); break;
		}
		//도형



		//좌표
			x1 = Integer.parseInt(msPaint.getX1T().getText().trim());
			y1 = Integer.parseInt(msPaint.getY2T().getText().trim());
			x2 = Integer.parseInt(msPaint.getX2T().getText().trim());
			y2 = Integer.parseInt(msPaint.getY1T().getText().trim());
			z1 = Integer.parseInt(msPaint.getZ1T().getText().trim());
			z2 = Integer.parseInt(msPaint.getZ2T().getText().trim());
		//색깔
		
		switch(msPaint.getCombo().setSelectedIndex()){
			case 0 : g.setColor(new Color(255,0,0)); break;//setcolor은 그래픽에서 나온다
			case 1 : g.setColor(new Color(55,202,81)); break;
			case 2 : g.setColor(new Color(51,26,232)); break;
			case 3 : g.setColor(new Color(196,62,189)); break;
			case 4 : g.setColor(new Color(132,233,251)); break;
		}
		//도형
		if(dto.getFill()){
			if(dto.getShape() == Figure.LINE)
				g.drawLine(x1, y1, x2, y2);
			else if(dto.getShape() == Figure.CIRCLE)
				g.fillOval(Math.min(x1,x2), Math.min(y1,y2), Math.abs(y2-y1));// 마이너스 값이 안나오게 절대화를 시켜줘야 한다. 
			else if(dto.getShape() == Figure.RECT)// Math.abs는 절대화를 시켜주는 메소드
				g.fillRect(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1));
			else if(dto.getShape() == Figure.ROUNDRECT)
				g.fillRoundRect((Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
		}else{
			if(dto.getShape() == Figure.LINE)
				g.drawLine(x1, y1, x2, y2);
			else if(dto.getShape() == Figure.CIRCLE)
				g.fillOval(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1));
			else if(dto.getShape() == Figure.RECT)
				g.fillRect((Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1));
			else if(dto.getShape() == Figure.ROUNDRECT)
				g.fillRoundRect((Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
		}
	}

		if(msPaint.getFill.getStateChange()==ItemEvent.SELECTED){
			
			if(msPaint.getLine().isSelected())
				g.drawLine(x1, y1, x2, y2);
			else if(msPaint.getCircle().isSelected())
				g.fillOval(Math.min(x1,x2), Math.min(y1,y2), Math.abs(y2-y1));// 마이너스 값이 안나오게 절대화를 시켜줘야 한다. 
			else if(msPaint.getRect().isSelected())// Math.abs는 절대화를 시켜주는 메소드
				g.fillRect(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1));
			else if(msPaint.getRoundRect().isSelected())
				g.fillRoundRect((Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
		}else{
			if(msPaint.getLine().isSelected())
				g.drawLine(x1, y1, x2, y2);
			else if(msPaint.getCircle().isSelected())
				g.fillOval(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1));
			else if(msPaint.getRect().isSelected())
				g.fillRect((Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1));
			else if(msPaint.getRoundRect().isSelected())
				g.fillRoundRect((Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
		}
}

//	}
//}
/*
1.버튼을 클릭하면 도형이 그려진다.

2.mousePressed mouseDragged 이벤트가 발생한다
mousePressed가 되면 시작좌표라서 x1T, y1T값이 바뀐다
mouseDragged가 되면 x2T, y2T값이 바뀐다.

*/