package shapes.line;

import shapes.Command;
import shapes.point.Point;

public class UpdateLine implements Command {

	private Line oldState;
	private Line newState;
	private Line originalState;
	

	public UpdateLine(Line oldState, Line newState) {
		this.oldState = oldState;
		this.newState = newState;
	}
	@Override
	public void execute() {
		originalState=oldState.clone();		
		oldState=newState.clone();
		/*originalState.getStart().setX(oldState.getStart().getX());
		originalState.getStart().setY(oldState.getStart().getY());
		originalState.getEnd().setX(oldState.getEnd().getX());
		originalState.getEnd().setY(oldState.getEnd().getY());
		originalState.setColor(oldState.getColor());
		
		
		oldState.getStart().setX(newState.getStart().getX());
		oldState.getStart().setY(newState.getStart().getY());
		oldState.getEnd().setX(newState.getEnd().getX());
		oldState.getEnd().setY(newState.getEnd().getY());
		oldState.setColor(oldState.getColor());*/
		
	}

	@Override
	public void unexecute() {
		
		oldState=originalState.clone();
		/*oldState.getStart().setX(originalState.getStart().getX());
		oldState.getStart().setY(originalState.getStart().getY());
		oldState.getEnd().setX(originalState.getEnd().getX());
		oldState.getEnd().setY(originalState.getEnd().getY());
		oldState.setColor(oldState.getColor());*/

	}

}
