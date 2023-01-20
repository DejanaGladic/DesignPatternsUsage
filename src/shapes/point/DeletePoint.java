package shapes.point;

import model.DrawingModel;
import shapes.Command;

public class DeletePoint implements Command {

	private Point point;
	private DrawingModel model;
	
	public DeletePoint(Point point, DrawingModel model) {
		this.point = point;
		this.model = model;
	}

	@Override
	public void execute() {
		model.delete(point);
		
	}

	@Override
	public void unexecute() {
		model.add(point);
		
	}

}
