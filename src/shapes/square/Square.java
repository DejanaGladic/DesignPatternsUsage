package shapes.square;

import java.awt.Color;
import java.awt.Graphics;


import shapes.SurfaceShapes;
import shapes.line.Line;
import shapes.point.Point;

public class Square extends SurfaceShapes{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7257033325651687561L;
	protected Point upLeft;
	protected int side;
	
	public Square () {
		
	}
	public Square (Point upLeft,int side) {
		this.upLeft = upLeft;
		this.side = side;
	}
	public Square (Point upLeft,int side, Color color) {
		this(upLeft, side);
		setColor(color);
		
	}
	public Square (Point upLeft,int side, Color color, Color innerColor) {
		this(upLeft, side,color);
		setInnerColor(innerColor);
	}
	


	//METODE
	public Line diagonal() {
		Point downLeft = new Point(upLeft.getX()+side, upLeft.getY()+side);
		return new Line(upLeft, downLeft);
	}
	public Point center() { //vraca objekat a ne referencu pa se nista ne moze setovati
		return diagonal().midPoint();
	}
	

	
	//PREKLOPLJENE IZ OBJECT
	public String toString() {
		
		return "SQUARE:UPLEFT("+upLeft.getX()+","+upLeft.getY()+") SIDE("+side+") "+getColor()+" "+getInnerColor();
	}
	public boolean equals(Object obj) {
		if(obj instanceof Square) {
			Square forwardSquare = (Square) obj;
			if(upLeft.equals(forwardSquare.upLeft) && side == forwardSquare.side)
				return true;
			else
				return false;
		}
		else
			return false;
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Square){
			return (int) (-this.surfaceArea()+((Square) o).surfaceArea());
		}
		else 
			return 0;
	}

	@Override
	public void moveTo(int x, int y) {
		upLeft.moveTo(x, y);
		
	}

	@Override
	public void moveFor(int forX, int forY) {
		upLeft.moveFor(forX, forY);
		
	}

	@Override
	public double surfaceArea() {
		return side * side;
	}

	@Override
	public double volume() {
		return 4 * side;
	}

	@Override
	public void fillShape(Graphics g) {
		g.setColor(getInnerColor());
		g.fillRect(upLeft.getX()+1, upLeft.getY()+1, side-1, side-1);
		
	}

	@Override
	public void drawShape(Graphics g) {
		g.setColor(getColor());
		g.drawRect(upLeft.getX(), upLeft.getY(), side, side);
		
		fillShape(g);
		
		if (isSelected())
			selectedShape(g);
		
	}

	@Override
	public void selectedShape(Graphics g) {
		new Line(getUpLeft(), new Point(getUpLeft().getX()+side, getUpLeft().getY())).selectedShape(g);
		new Line(getUpLeft(), new Point(getUpLeft().getX(), getUpLeft().getY()+side)).selectedShape(g);
		new Line(new Point(getUpLeft().getX()+side, getUpLeft().getY()), diagonal().getEnd()).selectedShape(g);
		new Line(new Point(getUpLeft().getX(), getUpLeft().getY()+side), diagonal().getEnd()).selectedShape(g);
	}//svaka linija je stranica kvadrata, pa nad linijom pozivamo metodu selektovan; sva temena i sredine stranica moraju biti selektovane pa ovako to radimo
	

	@Override
	public boolean containsPoint(int x, int y) {
		if(this.getUpLeft().getX()<=x 
				&& x<=(this.getUpLeft().getX() + side)
				&& this.getUpLeft().getY()<=y 
				&& y<=(this.getUpLeft().getY() + side))
			return true;
		else 
			return false;
	}
	
	public Point getUpLeft() {
		return upLeft;
	}
	public void setUpLeft(Point upLeft) {
		this.upLeft = upLeft;
	}
	public int getSide() {
		return side;
	}
	public void setSide(int side) {
		this.side = side;
	}
	
	
	public Square clone() {
		Square originalState=new Square();
		
		originalState.setUpLeft(new Point(this.getUpLeft().getX(),this.getUpLeft().getX()));
		originalState.setSide(this.getSide());
		originalState.setColor(this.getColor());
		originalState.setInnerColor(this.getInnerColor());
		
		return originalState;
	}

}
