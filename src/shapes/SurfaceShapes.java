package shapes;

import java.awt.Color;
import java.awt.Graphics;

public abstract class SurfaceShapes extends Shape{
private Color innerColor = Color.WHITE;
	
	public abstract double surfaceArea();
	public abstract double volume();
	public abstract void fillShape(Graphics g);
	public Color getInnerColor() {
		return innerColor;
	}
	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}

}
