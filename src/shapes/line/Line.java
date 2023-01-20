package shapes.line;

import java.awt.Color;
import java.awt.Graphics;


import shapes.Shape;
import shapes.point.Point;

public class Line extends Shape{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5622258777119355998L;
	private Point start;
	private Point end;
	
	public Line() {
		// TODO Auto-generated constructor stub
	}
	public Line(Point start, Point end) {
		this.start = start;
		this.end = end;
	}
	public Line(Point start, Point end, Color color) {
		this(start, end);
		setColor(color);
	}
	
	

	@Override
	public int compareTo(Object arg0) {
		if(arg0 instanceof Line){
			return (int) (this.length()-((Line) arg0).length());
		}
		else 
			return 0;
	}

	@Override
	public void moveTo(int x, int y) {
		start.moveTo(x, y);
		end.moveTo(x, y);
		
	}

	@Override
	public void moveFor(int forX, int forY) {
		start.moveFor(forX, forY);
		end.moveFor(forY, forY);
		
	}

	@Override
	public void drawShape(Graphics g) {
		g.setColor(getColor());
		g.drawLine(start.getX(), start.getY(), end.getX(), end.getY());
		
				
		if(isSelected())
			selectedShape(g);
		
	}

	@Override
	public void selectedShape(Graphics g) {
		g.setColor(Color.BLUE);
		start.selectedShape(g);
		end.selectedShape(g);
		midPoint().selectedShape(g); //koristimo metodu iz tacke za selekciju preko krajnje pocetne i sredine linije
		
	}

	@Override
	public boolean containsPoint(int x, int y) {
		Point helpPoint = new Point(x, y);
		if((start.distance(helpPoint)+end.distance(helpPoint))-length()<=1)
			return true;
		else
			return false;
	}
	
	//METODE
		public double length() {
			return start.distance(end);
		}
		public Point midPoint(){
			int midX = (start.getX() + end.getX())/2;
			int midY = (start.getY() + end.getY())/2;
			Point middle= new Point(midX, midY);
			return middle;
		}
		public Point getStart() {
			return start;
		}
		public void setStart(Point start) {
			this.start = start;
		}
		public Point getEnd() {
			return end;
		}
		public void setEnd(Point end) {
			this.end = end;
		}
		
		
		//PREKLOPLJENO IZ OBJECT
		public String toString() {
			return "LINE:("+start.getX() +"-"+start.getY()+")->("+end.getX()+"-"+end.getY()+")->"+getColor().toString();
		}
		
		public boolean equals(Object obj) {
			if(obj instanceof Line) {
				Line forwardLine = (Line) obj;
				if(start.equals(forwardLine.getStart()) && end.equals(forwardLine.end))
					return true;
				else
					return false;
			}
			else
				return false;
		}
		
		public Line clone() {
			Line originalState=new Line();
			
			originalState.setStart(new Point(this.getStart().getX(),this.getStart().getY()));
			originalState.setEnd(new Point(this.getEnd().getX(),this.getEnd().getY()));

			originalState.setColor(this.getColor());
			
			return originalState;
		}
		

}
