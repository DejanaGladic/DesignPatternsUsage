package shapes;



import shapes.circle.Circle;
import shapes.hexagon.HexagonAdapter;
import shapes.line.Line;
import shapes.point.Point;
import shapes.rectangle.Rectangle;
import shapes.square.Square;

public class UpdateShape implements Command{

	private Shape oldState;
	private Shape newState;
	private Shape originalState;
	
	private String help;

	public UpdateShape(Shape oldState, Shape newState) {
		this.oldState = oldState;
		this.newState = newState;
	}

	@Override
	public void execute() {
		help="UPDATE_EXECUTE_"+oldState.toString()+"->"+newState.toString();
		
		originalState=oldState.clone();		

		if(oldState instanceof Point) {
			((Point) oldState).setX(((Point) newState).getX());
			((Point) oldState).setY(((Point) newState).getY());
			oldState.setColor(newState.getColor());

		}
		
		else if(oldState instanceof Rectangle) {
			((Rectangle) oldState).getUpLeft().setX(((Rectangle) newState).getUpLeft().getX());
			((Rectangle) oldState).getUpLeft().setY(((Rectangle) newState).getUpLeft().getY());
			((Rectangle) oldState).setSide(((Rectangle) newState).getSide());
			((Rectangle) oldState).setWidth(((Rectangle) newState).getWidthS());
			oldState.setColor(newState.getColor());
			((Rectangle) oldState).setInnerColor(((Rectangle) newState).getInnerColor());
		}
		else if(oldState instanceof Square) {
			((Square) oldState).getUpLeft().setX(((Square) newState).getUpLeft().getX());
			((Square) oldState).getUpLeft().setY(((Square) newState).getUpLeft().getY());
			((Square) oldState).setSide(((Square) newState).getSide());
			oldState.setColor(newState.getColor());
			((Square) oldState).setInnerColor(((Square) newState).getInnerColor());
		}
		else if(oldState instanceof Circle) {
			((Circle) oldState).getCenter().setX(((Circle) newState).getCenter().getX());
			((Circle) oldState).getCenter().setY(((Circle) newState).getCenter().getY());
			((Circle) oldState).setRadius(((Circle) newState).getRadius());
			oldState.setColor(newState.getColor());
			((Circle) oldState).setInnerColor(((Circle) newState).getInnerColor());
			
		}
		else if(oldState instanceof Line) {
			((Line) oldState).getStart().setX(((Line) newState).getStart().getX());
			((Line) oldState).getStart().setY(((Line) newState).getStart().getY());
			((Line) oldState).getEnd().setX(((Line) newState).getEnd().getX());
			((Line) oldState).getEnd().setY(((Line) newState).getEnd().getY());
			oldState.setColor(newState.getColor());
			
		}
		else if(oldState instanceof HexagonAdapter) {
			((HexagonAdapter) oldState).getHexagon().setX(((HexagonAdapter) newState).getHexagon().getX());
			((HexagonAdapter) oldState).getHexagon().setY(((HexagonAdapter) newState).getHexagon().getY());
			((HexagonAdapter) oldState).getHexagon().setR(((HexagonAdapter) newState).getHexagon().getR());
			((HexagonAdapter) oldState).getHexagon().setBorderColor(((HexagonAdapter) newState).getHexagon().getBorderColor());
			((HexagonAdapter) oldState).getHexagon().setAreaColor(((HexagonAdapter) newState).getHexagon().getAreaColor());
		}
		
		
		
	}

	@Override
	public void unexecute() {
		//oldState=originalState.clone();
		
		if(oldState instanceof Point) {
			((Point) oldState).setX(((Point) originalState).getX());
			((Point) oldState).setY(((Point) originalState).getY());
			oldState.setColor(originalState.getColor());
		}
		else if(oldState instanceof Rectangle) {
			((Rectangle) oldState).getUpLeft().setX(((Rectangle) originalState).getUpLeft().getX());
			((Rectangle) oldState).getUpLeft().setY(((Rectangle) originalState).getUpLeft().getY());
			((Rectangle) oldState).setSide(((Rectangle) originalState).getSide());
			((Rectangle) oldState).setWidth(((Rectangle) originalState).getWidthS());
			oldState.setColor(originalState.getColor());
			((Rectangle) oldState).setInnerColor(((Rectangle) originalState).getInnerColor());
		}
		else if(oldState instanceof Square) {
			((Square) oldState).getUpLeft().setX(((Square) originalState).getUpLeft().getX());
			((Square) oldState).getUpLeft().setY(((Square) originalState).getUpLeft().getY());
			((Square) oldState).setSide(((Square) originalState).getSide());
			oldState.setColor(originalState.getColor());
			((Square) oldState).setInnerColor(((Square) originalState).getInnerColor());
		}
		else if(oldState instanceof Circle) {
			((Circle) oldState).getCenter().setX(((Circle) originalState).getCenter().getX());
			((Circle) oldState).getCenter().setY(((Circle) originalState).getCenter().getY());
			((Circle) oldState).setRadius(((Circle) originalState).getRadius());
			oldState.setColor(originalState.getColor());
			((Circle) oldState).setInnerColor(((Circle) originalState).getInnerColor());
		}
		else if(oldState instanceof Line) {
			((Line) oldState).getStart().setX(((Line) originalState).getStart().getX());
			((Line) oldState).getStart().setY(((Line) originalState).getStart().getY());
			((Line) oldState).getEnd().setX(((Line) originalState).getEnd().getX());
			((Line) oldState).getEnd().setY(((Line) originalState).getEnd().getY());
			oldState.setColor(originalState.getColor());
						
		}
		else if(oldState instanceof HexagonAdapter) {
			
			((HexagonAdapter) oldState).getHexagon().setX(((HexagonAdapter) originalState).getHexagon().getX());
			((HexagonAdapter) oldState).getHexagon().setY(((HexagonAdapter) originalState).getHexagon().getY());
			((HexagonAdapter) oldState).getHexagon().setR(((HexagonAdapter) originalState).getHexagon().getR());
			((HexagonAdapter) oldState).getHexagon().setBorderColor(((HexagonAdapter) originalState).getHexagon().getBorderColor());
			((HexagonAdapter) oldState).getHexagon().setAreaColor(((HexagonAdapter) originalState).getHexagon().getAreaColor());
			
		}
		
		help="UPDATE_UNEXECUTE_"+oldState.toString()+"->"+originalState.toString();
	}

	public String getHelp() {
		return help;
	}

	public void setHelp(String help) {
		this.help = help;
	}

}
