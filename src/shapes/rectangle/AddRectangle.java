package shapes.rectangle;

import model.DrawingModel;
import shapes.Command;
import shapes.square.Square;

public class AddRectangle implements Command {

	private Rectangle rectangle;
	private DrawingModel model;
	
	public AddRectangle(Rectangle rectangle, DrawingModel model) {
		this.rectangle = rectangle;
		this.model = model;
	}

	@Override
	public void execute() {
		model.add(rectangle);
		
	}

	@Override
	public void unexecute() {
		model.delete(rectangle);
		
	}
	

}
