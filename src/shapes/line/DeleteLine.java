package shapes.line;

import model.DrawingModel;
import shapes.Command;

public class DeleteLine implements Command{
	
	private Line line;
	private DrawingModel model;
	
	public DeleteLine(Line line, DrawingModel model) {
		this.line = line;
		this.model = model;
	}

	@Override
	public void execute() {
		model.delete(line);

	}

	@Override
	public void unexecute() {
		model.add(line);

	}


}
