package shapes.square;

import model.DrawingModel;
import shapes.Command;

public class DeleteSquare implements Command{
	
	private Square square;
	private DrawingModel model;
	
	public DeleteSquare(Square square, DrawingModel model) {
		this.square = square;
		this.model = model;
	}

	@Override
	public void execute() {
		model.delete(square);
		
	}

	@Override
	public void unexecute() {
		model.add(square);
		
	}

}
