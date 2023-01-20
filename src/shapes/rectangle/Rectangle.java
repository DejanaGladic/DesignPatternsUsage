package shapes.rectangle;

import java.awt.Color;
import java.awt.Graphics;


import shapes.line.Line;
import shapes.point.Point;
import shapes.square.Square;

public class Rectangle extends Square{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6859883464482238316L;
	private int widthS;

	public Rectangle() {

	}
	
	public Rectangle(Point upLeft, int width, int side) {
		super.upLeft = upLeft;
		this.widthS = width;
		this.side = side;
	}
	
	public Rectangle(Point upLeft, int width, int side, Color color) {
		this(upLeft, width, side);
		setColor(color);
	}
	public Rectangle (Point upLeft, int width, int side, Color color, Color innerColor) {
		this(upLeft, width, side, color);
		setInnerColor(innerColor);
	}
	
	
	//IMPLEMENT INTERFEJS
	//pomeriNa i pomeriZa ne postoji jer se moze koristiti ono kod kvadrata, ali ne moze p1.pomeriNa() jer nam treba goreLevo koje nije vidljivo za taj pravougaonik u klasi kvadrat(vidi tamo metodu) pa mora p1.getGoreLevo().pomeriNa()
	//nema compareTo jer moze iz kvadrata i poredi se povrsina koja je metoda da se poredi stranica koja je promenljiva moralo bi kod poziva kao i ono pomeriNa
	
	
	//PREKLOPLJENO IZ KVADRATA
	public double surfaceArea() {
		return side * widthS;
	}
	public double volume() {
		return 2*side + 2*widthS;
	}
	
	public void drawShape(Graphics g) {
		g.setColor(getColor());
		g.drawRect(upLeft.getX(), upLeft.getY(), widthS, side);
		
		fillShape(g);
		
		if (isSelected())
			selectedShape(g);
	}
	public void selectedShape(Graphics g) {
		g.setColor(Color.BLUE);
		new Line(getUpLeft(), new Point(getUpLeft().getX()+widthS, getUpLeft().getY())).selectedShape(g);
		new Line(getUpLeft(), new Point(getUpLeft().getX(), getUpLeft().getY()+side)).selectedShape(g);
		new Line(new Point(getUpLeft().getX()+widthS, getUpLeft().getY()), diagonal().getEnd()).selectedShape(g);
		new Line(new Point(getUpLeft().getX(), getUpLeft().getY()+side), diagonal().getEnd()).selectedShape(g);
	} //slicno kao i kod kvadrata
	
	public void fillShape(Graphics g) {
		g.setColor(getInnerColor());
		g.fillRect(upLeft.getX()+1, upLeft.getY()+1, widthS-1, side-1);
	}
	
	public boolean contains(int x, int y) {
		if(this.getUpLeft().getX()<=x 
				&& x<=(this.getUpLeft().getX() + widthS)
				&& this.getUpLeft().getY()<=y 
				&& y<=(this.getUpLeft().getY() + side))
			return true;
		else 
			return false;
	}
	
	
	
	//METODE
	public Line diagonal() {
		Point downRight = new Point(upLeft.getX()+widthS, upLeft.getY()+side);
		return new Line(upLeft,downRight);
	}
	//centar nije preklopljen vec se poziva iz kvadrata jer je metoda ista
	public int getWidthS() {
		return widthS;
	}
	public void setWidth(int width) {
		this.widthS = width;
	}
	
	
	//PREKLOPLJENO IZ OBJECT
	public String toString() {
		return "RECTANGLE:UPLEFT("+upLeft.getX()+","+upLeft.getY()+") SIDE("+side+") WIDTH("+widthS+") "+getColor()+" "+getInnerColor();
	}
	public boolean equals(Object obj) {
		if(obj instanceof Rectangle) {
			Rectangle forward = (Rectangle) obj;
			if(upLeft.equals(forward.upLeft) && 
					side == forward.side && 
							widthS == forward.widthS)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	public Rectangle clone() {
		Rectangle originalState=new Rectangle();
		
		originalState.setUpLeft(new Point(this.getUpLeft().getX(),this.getUpLeft().getX()));
		originalState.setSide(this.getSide());
		originalState.setWidth(this.getWidthS());
		originalState.setColor(this.getColor());
		originalState.setInnerColor(this.getInnerColor());
		
		return originalState;
	}
}
