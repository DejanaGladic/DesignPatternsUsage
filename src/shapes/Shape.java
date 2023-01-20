package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JToggleButton.ToggleButtonModel;

import frame.DrawingFrame;




public abstract class Shape implements Serializable, Moveable, Cloneable, Comparable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 8233851235496097855L;
	private Color color = Color.BLACK;
	private boolean selected;
		
	public Shape() {
		
	}
	public Shape(Color color) {
		this.color = color;
	}
	
	public  Color findColor(String color) {
		if(color.equalsIgnoreCase("white"))
			return Color.WHITE;
		else if(color.equalsIgnoreCase("blue"))
			return Color.BLUE;
		else if(color.equalsIgnoreCase("green"))
			return Color.GREEN;
		else if(color.equalsIgnoreCase("red"))
			return Color.RED;
		else if(color.equalsIgnoreCase("yellow"))
			return Color.YELLOW;
		else if(color.equalsIgnoreCase("pink"))
			return Color.PINK;
		else
			return Color.BLACK;
	}
	
	public abstract void drawShape(Graphics g);
	public abstract void selectedShape(Graphics g);
	public abstract boolean containsPoint(int x, int y);
	public abstract Shape clone();
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	


}
