package shapes;

import model.DrawingModel;
import shapes.square.Square;

public class DeleteShape implements Command{
	private Shape shape;
	private DrawingModel model;
	
	private String help;
	
	public DeleteShape(Shape shape, DrawingModel model) {
		this.shape = shape;
		this.model = model;
	}

	@Override
	public void execute() {
		
		model.delete(shape);
		
		help="DELETE_EXECUTE_"+shape.toString();
		
	}

	@Override
	public void unexecute() {
		model.add(shape);
		
		help="DELETE_UNEXECUTE_"+shape.toString();
		
	}

	public String getHelp() {
		return help;
	}

	public void setHelp(String help) {
		this.help = help;
	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

}
