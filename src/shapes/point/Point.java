package shapes.point;

import java.awt.Color;
import java.awt.Graphics;

import shapes.Shape;


public class Point extends Shape{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1495426378760059668L;
	private int x;
	private int y;
	
	
	public Point() {

	}

	public Point(int x, int y) {
		this.x = x;
		setY(y);
	}
	public Point(int x, int y, Color color) {
		this(x, y);
		setColor(color);
	}	

	
	//INTERFEJS IMPLEMENTACIJA
	public void moveTo(int x, int y) {
		this.x = x;
		setY(y);
	}
	
	public void moveFor(int forX, int forY) {
		this.x += forX;
		this.y = this.y + forY;
	}
	
	public int compareTo(Object o) {
		if(o instanceof Point) {
			Point start = new Point(0, 0);
			return (int) (this.distance(start) - ((Point) o).distance(start));
		}
		else
			return 0;
	}
	
	
	//IMPLEMENTACIJA METODA IZ OBLIK
	public void drawShape(Graphics g) {
		//g.setColor(pronadjiBoju(getBoja()));
		g.setColor(getColor());
		g.drawLine(x-2, y, x+2, y);
		g.drawLine(x, y+2, x, y-2);
		
		if(isSelected()) //ako je selektovan pozovi metodu koja iscrtava kvadrat za selekciju
			selectedShape(g);
	}
	
	public void selectedShape(Graphics g) {
		g.setColor(Color.BLUE); //postoji metoda setColor u Graphics
		g.drawRect(x-3, y-3, 6, 6); //kvadrat oko tacke ako je selektovana, stranice tog kvadrata su 6,a linija koja cini tacku je cela duzine 4 pa u skladu sa tim  tako racunamo goreLevo
	}
	
	public boolean containsPoint(int x, int y) {
		if(this.distance(new Point(x, y))<=2)
			return true;
		return false;
	}
	
	
	//METODE
	public double distance(Point t) {
		int dX = x - t.x;
		int dY = t.y - y;
		double d = Math.sqrt(dX*dX + dY*dY);
		return d;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int newX) {
		x = newX;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int newY) {
		this.y = newY;
	}
	
	
	//PREKLOPLJENE IZ OBJECT
	public String toString() {
		return "POINT:"+"(" + x + "-" + y + ") "+getColor().toString();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			Point forwardPoint = (Point)obj;
			if (x==forwardPoint.getX() &&
				y==forwardPoint.getY()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public Point clone() {
		Point originalState=new Point();
		
		originalState.setX(this.getX());
		originalState.setY(this.getY());
		originalState.setColor(this.getColor());
		
		return originalState;
	}



	

}
