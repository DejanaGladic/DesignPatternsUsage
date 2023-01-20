package shapes.line;

import model.DrawingModel;
import shapes.Command;
import shapes.point.Point;

public class AddLine implements Command {
	
	private Line line;
	private DrawingModel model;
	
	public AddLine(Line line, DrawingModel model) {
		this.line = line;
		this.model = model;
	}

	@Override
	public void execute() {
		model.add(line);

	}

	@Override
	public void unexecute() {
		model.delete(line);

	}

}
