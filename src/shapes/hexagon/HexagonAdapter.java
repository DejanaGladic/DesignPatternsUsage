package shapes.hexagon;

import java.awt.Color;
import java.awt.Graphics;

import hexagon.Hexagon;
import shapes.SurfaceShapes;
import shapes.line.Line;
import shapes.point.Point;
import shapes.square.Square;

public class HexagonAdapter extends SurfaceShapes{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7825292253824030467L;
	private Hexagon hexagon;
	
	public HexagonAdapter() {
		
	}
	
	public HexagonAdapter(Hexagon h) {
		this.hexagon=hexagon;
	}
		
	public HexagonAdapter(int x, int y, int radius) {
		hexagon=new Hexagon(x, y, radius);
	}

	public HexagonAdapter(int x, int y, int radius, Color color) {
		this(x,y, radius);
		hexagon.setBorderColor(color);
	}
	public HexagonAdapter(int x, int y, int radius, Color color, Color innerColor) {
		this(x,y, radius, color);
		hexagon.setAreaColor(innerColor);
	}
	

	@Override
	public int compareTo(Object obj) {
		if(obj instanceof Hexagon){
			Hexagon help  = (Hexagon) obj;
			return this.hexagon.getR() - help.getR();
		}
		else 
			return 0;
	}

	@Override
	public void moveTo(int x, int y) {
		//nije implementirano, ne zahteva se
		
	}

	@Override
	public void moveFor(int forX, int forY) {
		//nije implementirano, ne zahteva se
		
	}

	@Override
	public double surfaceArea() {
		//nije implementirano, ne zahteva se
		return 0;
	}

	@Override
	public double volume() {
		//nije implementirano, ne zahteva se
		return 0;
	}

	@Override
	public void fillShape(Graphics g) {
		//sadrzana u metodi drawShape()
	}

	@Override
	public void drawShape(Graphics g) {
		hexagon.paint(g);
		
	}

	@Override
	public void selectedShape(Graphics g) {
		
	}

	@Override
	public boolean containsPoint(int x, int y) {
		return hexagon.doesContain(x, y);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof HexagonAdapter) {
			Hexagon hex = ((HexagonAdapter) obj).hexagon;
			return hexagon.getX() == hex.getX() && hexagon.getY() == hex.getY() && hexagon.getR() == hex.getR();
		}
		return false;
	}

	
	//PREKLOPLJENE IZ OBJECT
	public String toString() {
		return "HEXAGON:CENTER(" + hexagon.getX() + ","+hexagon.getY() + ") RADIUS(" + hexagon.getR() + ") "+hexagon.getBorderColor()+" "+hexagon.getAreaColor();	}
	
	
	public HexagonAdapter clone() {

		HexagonAdapter original=new HexagonAdapter(this.getHexagon().getX(),this.getHexagon().getY(),this.getHexagon().getR());
		original.getHexagon().setBorderColor(this.getHexagon().getBorderColor());
		original.getHexagon().setAreaColor(this.getHexagon().getAreaColor());
		
		return original;
	}
	
	public Hexagon getHexagon() {
		return hexagon;
	}
	public void setHexagon(Hexagon hexagon) {
		this.hexagon = hexagon;
	}
	
	@Override
	public boolean isSelected() {
		return hexagon.isSelected();
	}
	
	@Override
	public void setSelected(boolean selected) {
		super.setSelected(selected);
		hexagon.setSelected(selected);
	}
	

	

}
