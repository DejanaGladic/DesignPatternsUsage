package shapes.square;

import model.DrawingModel;
import shapes.Command;

public class AddSquare implements Command{

	private Square square;
	private DrawingModel model;
	
	public AddSquare(Square square, DrawingModel model) {
		this.square = square;
		this.model = model;
	}

	@Override
	public void execute() {
		model.add(square);
		
	}

	@Override
	public void unexecute() {
		model.delete(square);
		
	}

	
}
