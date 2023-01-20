package shapes;

import model.DrawingModel;

public class BringToBack implements Command {

	private DrawingModel model;
	private Shape shape;
	private int shapeIndex;
	
	private String help;
	

	public BringToBack(DrawingModel model, Shape shape) {
		this.model = model;
		this.shape = shape;
	}
	
	@Override
	public void execute() {
	
		shapeIndex=model.getShapeList().indexOf(shape);
		
		model.delete(shape);
		model.addOn(0,shape);
		help="BRINGTOBACK_EXECUTE_"+shape.toString();

	}

	@Override
	public void unexecute() {
		model.delete(shape);
		model.addOn(shapeIndex, shape);
		help="BRINGTOBACK_UNEXECUTE_"+shape.toString();
	}

	public String getHelp() {
		return help;
	}

	public void setHelp(String help) {
		this.help = help;
	}

}
