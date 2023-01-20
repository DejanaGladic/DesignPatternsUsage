package shapes.hexagon;

import model.DrawingModel;
import shapes.Command;

public class DeleteHexagon implements Command{
	
	private HexagonAdapter hexagonA;
	private DrawingModel model;
	
	public DeleteHexagon(HexagonAdapter hexagonA, DrawingModel model) {
		this.hexagonA = hexagonA;
		this.model = model;
	}


	@Override
	public void execute() {
		model.delete(hexagonA);

	}

	@Override
	public void unexecute() {
		model.add(hexagonA);
	}

}
