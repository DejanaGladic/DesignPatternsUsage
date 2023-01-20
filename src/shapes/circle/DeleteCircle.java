package shapes.circle;

import model.DrawingModel;
import shapes.Command;

public class DeleteCircle implements Command {

	private Circle circle;
	private DrawingModel model;
	
	public DeleteCircle(Circle circle, DrawingModel model) {
		this.circle = circle;
		this.model = model;
	}
	@Override
	public void execute() {
		model.delete(circle);

	}

	@Override
	public void unexecute() {
		model.add(circle);

	}

}
