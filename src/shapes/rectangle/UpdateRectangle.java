package shapes.rectangle;

import shapes.Command;
import shapes.square.Square;

public class UpdateRectangle implements Command{
	
	private Rectangle oldState;
	private Rectangle newState;
	private Rectangle  originalState;

	public UpdateRectangle(Rectangle oldState, Rectangle newState) {
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
		originalState.setWidth(oldState.getWidth());
		originalState.setColor(oldState.getColor());
		originalState.setInnerColor(oldState.getInnerColor());
		
		
		oldState.getUpLeft().setX(newState.getUpLeft().getX());
		oldState.getUpLeft().setY(newState.getUpLeft().getY());
		oldState.setSide(newState.getSide());
		oldState.setWidth(newState.getWidth());
		oldState.setColor(newState.getColor());
		oldState.setInnerColor(newState.getInnerColor());*/
		
	}

	@Override
	public void unexecute() {
		oldState=originalState.clone();
		/*oldState.getUpLeft().setX(originalState.getUpLeft().getX());
		oldState.getUpLeft().setY(originalState.getUpLeft().getY());
		oldState.setSide(originalState.getSide());
		oldState.setWidth(originalState.getWidth());
		oldState.setColor(originalState.getColor());
		oldState.setInnerColor(originalState.getInnerColor());*/

	}

}
