package shapes.circle;

import java.awt.Color;
import java.awt.Graphics;


import shapes.SurfaceShapes;
import shapes.line.Line;
import shapes.point.Point;

public class Circle extends SurfaceShapes{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5887124537925400142L;
	private Point center;
	private int radius;

	public Circle() {
	}
	
	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}

	public Circle(Point center, int radius, Color color) {
		this.center = center;
		this.radius = radius;
		setColor(color);
	}

	public Circle(Point center, int radius, Color color, Color innerColor) {
		this.center = center;
		this.radius = radius;
		setColor(color);
		setInnerColor(innerColor);
	}


	@Override
	public int compareTo(Object o) {
		if(o instanceof Circle){
			return (int) (this.radius-((Circle) o).radius);
		}
		else 
			return 0;
	}

	@Override
	public void moveTo(int x, int y) {
		center.moveTo(x, y);
		
	}

	@Override
	public void moveFor(int forX, int forY) {
		center.moveFor(forX, forY);
		
	}

	@Override
	public double surfaceArea() {
		return radius*radius*Math.PI;
	}

	@Override
	public double volume() {
		return 2*radius*Math.PI;
	}

	@Override
	public void fillShape(Graphics g) {
		g.setColor(getInnerColor());
		g.fillOval(center.getX()-radius+1, center.getY()-radius+1, 2*radius-2, 2*radius-2);
	}

	@Override
	public void drawShape(Graphics g) {
		g.setColor(getColor());
		g.drawOval(center.getX()-radius, center.getY()-radius, 2*radius, 2*radius);
		
		fillShape(g);
		
		if(isSelected())
			selectedShape(g);
		
	}

	@Override
	public void selectedShape(Graphics g) {
		new Line(new Point(center.getX(), center.getY()-radius), 
				new Point(center.getX(), center.getY() + radius)).selectedShape(g);
		new Line(new Point(center.getX()-radius, center.getY()), 
				new Point(center.getX()+radius, center.getY())).selectedShape(g);
		
	}//opet metodu selektovan pozivamo nad linijama

	@Override
	public boolean containsPoint(int x, int y) {
		if(new Point(x, y).distance(getCenter()) <= radius)
			return true;
		else
			return false;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	//PREKLOPLJENE IZ OBJECT
		public String toString() {
			return "CIRCLE:CENTER("+center.getX()+","+center.getY()+") RADIUS("+radius+") "+getColor()+" "+getInnerColor();
		}
		public boolean equals(Object obj) {
			if(obj instanceof Circle) {
				Circle forwardCircle = (Circle) obj;
				if(center.equals(forwardCircle.center) && radius == forwardCircle.radius)
					return true;
				else
					return false;
			}
			else
				return false;
			
			
		}
		
	public Circle clone() {
		Circle originalState=new Circle();
		
		originalState.setCenter(new Point(this.getCenter().getX(),this.getCenter().getY()));
		originalState.setRadius(this.getRadius());
		originalState.setColor(this.getColor());
		originalState.setInnerColor(this.getInnerColor());
			
		return originalState;
	}

}
