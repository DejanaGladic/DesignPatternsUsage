package shapes;

import java.util.ArrayList;

import model.DrawingModel;

public class DeleteMultipleShapes implements Command {
	
	private DrawingModel model;
	private ArrayList<Shape> shapes;
	
	private String help;
	
	private String easyToParse="";

	public DeleteMultipleShapes(DrawingModel model, ArrayList<Shape> shapes) {
		this.model = model;
		this.shapes = shapes;
	}

	@Override
	public void execute() {
		
		model.removeMultiple(shapes);
		
		for(int i=0;i<shapes.size();i++) {
			easyToParse+=shapes.get(i).toString()+";";
		}
		
		help="DELETEMULTIPLE_EXECUTE_"+easyToParse;
	}

	@Override
	public void unexecute() {
		model.addMultiple(shapes);
		
		help="DELETEMULTIPLE_UNEXECUTE_"+shapes;

	}

	public String getHelp() {
		return help;
	}

	public void setHelp(String help) {
		this.help = help;
	}

	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}

}
