package view;

import java.awt.Graphics;
import java.util.Iterator;

import javax.swing.JPanel;

import model.DrawingModel;
import shapes.Shape;

public class DrawingView extends JPanel{
	private DrawingModel model;

	public void setModel(DrawingModel model) {
		this.model = model;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (model != null) {
			Iterator<Shape> it = model.getShapeList().iterator();

			while (it.hasNext()) {
				it.next().drawShape(g);
			}
		}
	}

	public DrawingModel getModel() {
		return model;
	}
}
