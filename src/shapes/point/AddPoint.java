package shapes.point;

import model.DrawingModel;
import shapes.Command;

public class AddPoint implements Command{

	private Point point;
	private DrawingModel model;
	
	public AddPoint(Point point, DrawingModel model) {
		this.point = point;
		this.model = model;
	}

	@Override
	public void execute() {
		model.add(point);
		
	}

	@Override
	public void unexecute() {
		model.delete(point);
		
	}
		

}
