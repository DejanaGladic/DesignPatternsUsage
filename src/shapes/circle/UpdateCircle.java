package shapes.circle;

import shapes.Command;

public class UpdateCircle implements Command {
	
	private Circle oldState;
	private Circle newState;
	private Circle originalState;

	public UpdateCircle(Circle oldState, Circle newState) {
		this.oldState = oldState;
		this.newState = newState;
	}

	@Override
	public void execute() {
		originalState=oldState.clone();		
		oldState=newState.clone();
		/*originalState.getCenter().setX(oldState.getCenter().getX());
		originalState.getCenter().setY(oldState.getCenter().getY());
		originalState.setRadius(oldState.getRadius());
		originalState.setColor(oldState.getColor());
		originalState.setInnerColor(oldState.getInnerColor());
		
		
		oldState.getCenter().setX(newState.getCenter().getX());
		oldState.getCenter().setY(newState.getCenter().getY());
		oldState.setRadius(newState.getRadius());
		oldState.setColor(newState.getColor());
		oldState.setInnerColor(newState.getInnerColor());*/
		
	}

	@Override
	public void unexecute() {
		oldState=originalState.clone();
		/*oldState.getCenter().setX(originalState.getCenter().getX());
		oldState.getCenter().setY(originalState.getCenter().getY());
		oldState.setRadius(originalState.getRadius());
		oldState.setColor(originalState.getColor());
		oldState.setInnerColor(originalState.getInnerColor());*/

	}

}
