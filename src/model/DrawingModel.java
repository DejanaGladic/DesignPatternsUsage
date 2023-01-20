package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

import shapes.Observer;
import shapes.Shape;
import shapes.hexagon.HexagonAdapter;

public class DrawingModel {
	
	private ArrayList<Shape> shapeList=new ArrayList<Shape>();
	
	private int numberOfSelection;
	
	private PropertyChangeSupport pcs;
	
	private Observer observer=new Observer();
	
	public DrawingModel() {
		pcs=new PropertyChangeSupport(this);
		pcs.addPropertyChangeListener(observer);
	}
	public void add(Shape s) {
		shapeList.add(s);
	}
	
	public void addOn(int shapeIndex, Shape shape) {
		shapeList.add(shapeIndex, shape);
	} 
	public void removeAt(int shapeIndex) {
		shapeList.remove(shapeIndex);
	}
	public void delete(Shape s) {

		shapeList.remove(s);
	}
	
	public ArrayList<Shape> getShapeList(){
		return shapeList;
	}
	
	public Shape getShape(int i) {
		return shapeList.get(i);
	}
	
	public void addMultiple(ArrayList<Shape> shapes) {
		shapeList.addAll(shapes);
		
	}
	public void removeMultiple(ArrayList<Shape> shapes) {
		shapeList.removeAll(shapes);
		
	}
	
	
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		pcs.addPropertyChangeListener(pcl);
	}
	public PropertyChangeSupport getPcs() {
		return pcs;
	}
	public void setPcs(PropertyChangeSupport pcs) {
		this.pcs = pcs;
	}
	public void somethingChanged(int numberOfSelection) {
		
		pcs.firePropertyChange("numberOfSelection",this.numberOfSelection,numberOfSelection);
	}
	public Observer getObserver() {
		return observer;
	}
	public void setObserver(Observer observer) {
		this.observer = observer;
	}

	
	
	
}
