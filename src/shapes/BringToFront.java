package shapes;

import java.util.Collections;

import model.DrawingModel;

public class BringToFront implements Command {

	private DrawingModel model;
	private Shape shape;
	private int shapeIndex;
	
	private String help;
	
	public BringToFront(DrawingModel model, Shape shape) {
		this.model = model;
		this.shape = shape;
	}

	@Override
	public void execute() {
		
		shapeIndex=model.getShapeList().indexOf(shape);

		model.delete(shape);
		model.add(shape);
		
		help="BRINGTOFRONT_EXECUTE_"+shape.toString();
	}

	@Override
	public void unexecute() {
		model.delete(shape);
		model.addOn(shapeIndex, shape);
		
		help="BRINGTOFRONT_UNEXECUTE_"+shape.toString();

	}

	public String getHelp() {
		return help;
	}

	public void setHelp(String help) {
		this.help = help;
	}

	

}
