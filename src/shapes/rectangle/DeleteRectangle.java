package shapes.rectangle;

import model.DrawingModel;
import shapes.Command;

public class DeleteRectangle implements Command {

	private Rectangle rectangle;
	private DrawingModel model;
	
	public DeleteRectangle(Rectangle rectangle, DrawingModel model) {
		this.rectangle = rectangle;
		this.model = model;
	}

	@Override
	public void execute() {
		model.delete(rectangle);
		
	}

	@Override
	public void unexecute() {
		model.add(rectangle);
		
	}
	
}
