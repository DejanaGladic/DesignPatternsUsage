package shapes.square;

import shapes.Command;
import shapes.circle.Circle;

public class UpdateSquare implements Command{
	
	private Square oldState;
	private Square newState;
	private Square originalState;

	public UpdateSquare(Square oldState, Square newState) {
		this.oldState = oldState;
		this.newState = newState;
	}

	@Override
	public void execute() {
		originalState=oldState.clone();		
		oldState=newState.clone();
		/*originalState.getUpLeft().setX(oldState.getUpLeft().getX());
		originalState.getUpLeft().setY(oldState.getUpLeft().getY());
		originalState.setSide(oldState.getSide());
		originalState.setColor(oldState.getColor());
		originalState.setInnerColor(oldState.getInnerColor());
		
		
		oldState.getUpLeft().setX(newState.getUpLeft().getX());
		oldState.getUpLeft().setY(newState.getUpLeft().getY());
		oldState.setSide(newState.getSide());
		oldState.setColor(newState.getColor());
		oldState.setInnerColor(newState.getInnerColor());*/
		
	}

	@Override
	public void unexecute() {
		oldState=originalState.clone();
		/*oldState.getUpLeft().setX(originalState.getUpLeft().getX());
		oldState.getUpLeft().setY(originalState.getUpLeft().getY());
		oldState.setSide(originalState.getSide());
		oldState.setColor(originalState.getColor());
		oldState.setInnerColor(originalState.getInnerColor());*/

	}

}
