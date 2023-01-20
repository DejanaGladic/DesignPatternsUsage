package shapes.hexagon;

import model.DrawingModel;
import shapes.Command;

public class AddHexagon implements Command {
	private HexagonAdapter hexagonA;
	private DrawingModel model;
		public AddHexagon(HexagonAdapter hexagonA, DrawingModel model) {
		this.hexagonA = hexagonA;
		this.model = model;
	}


	@Override
	public void execute() {
		model.add(hexagonA);

	}

	@Override
	public void unexecute() {
		model.delete(hexagonA);
	}

}
