package shapes.circle;

import model.DrawingModel;
import shapes.Command;

public class AddCircle implements Command {

	private Circle circle;
	private DrawingModel model;
	
	public AddCircle(Circle circle, DrawingModel model) {
		this.circle = circle;
		this.model = model;
	}

	@Override
	public void execute() {
		model.add(circle);

	}

	@Override
	public void unexecute() {
		model.delete(circle);

	}

}
