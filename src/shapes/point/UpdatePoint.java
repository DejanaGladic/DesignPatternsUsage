package shapes.point;

import shapes.Command;

public class UpdatePoint implements Command {

	private Point oldState;
	private Point newState;
	private Point originalState;
	
	public UpdatePoint(Point oldState, Point newState) {
		this.oldState = oldState;
		this.newState = newState;
	}

	@Override
	public void execute() {
		
		originalState=oldState.clone();		
		oldState=newState.clone();
		
		/*this=oldState
		originalState.setX(this.getX());
		originalState.setY(this.getY());
		originalState.setColor(this.getColor());
		
		oldState.setX(newState.getX());
		oldState.setY(newState.getY());
		oldState.setColor(newState.getColor());*/

	}

	@Override
	public void unexecute() {
		
		oldState=originalState.clone();
		/*oldState.setX(originalState.getX());
		oldState.setY(originalState.getY());
		oldState.setColor(originalState.getColor());*/

	}

}
