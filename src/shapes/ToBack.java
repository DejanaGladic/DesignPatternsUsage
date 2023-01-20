package shapes;

import java.util.Collections;

import model.DrawingModel;

public class ToBack implements Command {

	private DrawingModel model;
	private Shape shape;
	private int shapeIndex;
	
	private String help;

	public ToBack(DrawingModel model, Shape shape) {
		this.model = model;
		this.shape = shape;
	}
	
	@Override
	public void execute() {
		
		shapeIndex=model.getShapeList().indexOf(shape);
		
		if(shapeIndex>0) {
			//Collections.swap(model.getShapeList(), shapeIndex-1, shapeIndex);
			model.removeAt(shapeIndex);
			model.addOn(shapeIndex - 1, shape);
		
			help="TOBACK_EXECUTE_"+shape.toString();
		}
	}

	@Override
	public void unexecute() {
		//Collections.swap(model.getShapeList(), shapeIndex+1, shapeIndex);
			
		model.removeAt(shapeIndex-1);
		model.addOn(shapeIndex, shape);
		
		help="TOBACK_UNEXECUTE_"+shape.toString();
		
	}

	public String getHelp() {
		return help;
	}

	public void setHelp(String help) {
		this.help = help;
	}

}
