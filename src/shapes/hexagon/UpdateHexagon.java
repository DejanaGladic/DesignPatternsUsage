package shapes.hexagon;

import shapes.Command;
import shapes.square.Square;

public class UpdateHexagon implements Command{
	
	private Square oldState;
	private Square newState;
	private Square originalState;

	public UpdateHexagon(Square oldState, Square newState) {
		this.oldState = oldState;
		this.newState = newState;
	}

	@Override
	public void execute() {
		originalState=oldState.clone();		
		oldState=newState.clone();

		
	}

	@Override
	public void unexecute() {
		oldState=originalState.clone();

	}

}
