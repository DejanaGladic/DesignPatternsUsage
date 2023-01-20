package strategy;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultListModel;

import controller.DrawingController;
import frame.DrawingFrame;
import model.DrawingModel;
import shapes.AddShape;
import shapes.BringToBack;
import shapes.BringToFront;
import shapes.Command;
import shapes.DeleteMultipleShapes;
import shapes.DeleteShape;
import shapes.Shape;
import shapes.ToBack;
import shapes.ToFront;
import shapes.UpdateShape;
import shapes.circle.Circle;
import shapes.hexagon.HexagonAdapter;
import shapes.line.Line;
import shapes.point.Point;
import shapes.rectangle.Rectangle;
import shapes.square.Square;

public class FileLog implements Strategy {
	
	private DrawingFrame frame;
	private DrawingModel model;
	private DrawingController controller;
	
	private BufferedWriter writer;
	private BufferedReader reader;
	
	public FileLog(DrawingFrame frame, DrawingModel model, DrawingController controller) {
		this.frame = frame;
		this.model = model;
		this.controller = controller;
	}


	@Override
	public void save(File file) {
		try {
			writer = new BufferedWriter(new FileWriter(file + ".log"));
			DefaultListModel<String> list = frame.getDlmLogList();
			for (int i = 0; i < frame.getDlmLogList().size(); i++) {
				writer.write(list.getElementAt(i));
				writer.newLine();
			
			}
			writer.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void open(File file) {
		try {
			reader = new BufferedReader(new FileReader(file));
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}


	public void getLine() {
		String command;
		Command commandToExecute=null;

		try {
			command=reader.readLine();
			
			if (command!=null && command.length()!=0) {
				
				if (!command.split("_")[1].equals("UNEXECUTE"))
					controller.getDlmLogList().addElement(command);
				
				if (command != null) {
					String[] cmd = command.split("_");

					switch (cmd[0]) {

					case "ADD":
						Shape shape = parseShape(cmd[2].split(":")[0], cmd[2].split(":")[1]);
						commandToExecute = new AddShape(shape, model);

						break;

					case "SELECT":
						Shape shapeS = parseShape(cmd[1].split(":")[0], cmd[1].split(":")[1]);
						System.out.println(shapeS);
						int s = model.getShapeList().indexOf(shapeS);
						System.out.println(s);

						model.getShape(s).setSelected(true);

						controller.setNumberOfSelection(controller.getNumberOfSelection() + 1);
						controller.changed();

						break;

					case "UNSELECT":
						Shape shapeUs = parseShape(cmd[1].split(":")[0], cmd[1].split(":")[1]);
						int uS = model.getShapeList().indexOf(shapeUs);

						model.getShape(uS).setSelected(false);

						controller.setNumberOfSelection(controller.getNumberOfSelection() - 1);
						controller.changed();

						break;

					case "UPDATE":
						Shape oldShape = parseShape(cmd[2].split("->")[0].split(":")[0],
								cmd[2].split("->")[0].split(":")[1]);

						Shape newShape = parseShape(cmd[2].split("->")[0].split(":")[0],
								cmd[2].split("->")[1].split(":")[1]);

						if (cmd[1].equals("EXECUTE")) {
							int index = model.getShapeList().indexOf(oldShape);
							commandToExecute = new UpdateShape(model.getShape(index), newShape);
						}
						break;

					case "DELETE":
						Shape shapeD = parseShape(cmd[2].split(":")[0], cmd[2].split(":")[1]);

						if (cmd[1].equals("EXECUTE")) {
							//nije nam potrebno da ovde trazimo index oblika jer ce on sam pronaci oblike u listi koje treba da obrise 
							commandToExecute = new DeleteShape(shapeD, model);
							
							controller.setNumberOfSelection(controller.getNumberOfSelection() - 1);
							controller.changed();

						}
						break;

					case "DELETEMULTIPLE":
						Shape shapeToDelete;
						ArrayList<Shape> shapesToDelete = new ArrayList<Shape>();

						for (int j = 0; j < cmd[2].split(";").length; j++) {
							shapeToDelete = parseShape(cmd[2].split(";")[j].split(":")[0],
									cmd[2].split(";")[j].split(":")[1]);
							shapesToDelete.add(shapeToDelete);
						}

						if (cmd[1].equals("EXECUTE")) {
							commandToExecute = new DeleteMultipleShapes(model, shapesToDelete);
							
							controller.setNumberOfSelection(controller.getNumberOfSelection() - cmd[2].split(";").length);
							controller.changed();
						}
						break;

					case "TOFRONT":
						if (cmd[1].equals("EXECUTE")) {
							Shape shapeF = parseShape(cmd[2].split(":")[0], cmd[2].split(":")[1]);
							int j = model.getShapeList().indexOf(shapeF);
							commandToExecute = new ToFront(model, model.getShape(j));
						}
						break;
						
					case "TOBACK":
						if (cmd[1].equals("EXECUTE")) {
							Shape shapeB = parseShape(cmd[2].split(":")[0], cmd[2].split(":")[1]);
							int b = model.getShapeList().indexOf(shapeB);
							commandToExecute = new ToBack(model, model.getShape(b));
						}
						break;

					case "BRINGTOFRONT":
						if (cmd[1].equals("EXECUTE")) {
							Shape shapeBF = parseShape(cmd[2].split(":")[0], cmd[2].split(":")[1]);
							int bf = model.getShapeList().indexOf(shapeBF);					
							commandToExecute = new BringToFront(model, model.getShape(bf));
						}
						break;
						
					case "BRINGTOBACK":
						if (cmd[1].equals("EXECUTE")) {
							Shape shapeBB = parseShape(cmd[2].split(":")[0], cmd[2].split(":")[1]);
							int bb = model.getShapeList().indexOf(shapeBB);
							commandToExecute = new BringToBack(model, model.getShape(bb));
						}
						break;
					
					default:
						break;

					}
					
					if (cmd[1].equals("EXECUTE")) {
						controller.doCmd(commandToExecute);
					} else if (cmd[1].equals("UNEXECUTE")) {
						//undoCmd ce se dobro izvrsiti jer je uvek kad se poziva unexecute ustv izvrsen undo poslednje komande
						controller.undoCmd();
					}
					frame.getView().repaint();
				} 
				
			}else{
				frame.getBtnParseLog().setEnabled(false);
				controller.getDlmLogList().addElement("------Completed------");
			}			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}


	private Shape parseShape(String shape, String values) {
		
		if(shape.equals("POINT")) {
			String[] value1=values.split("-");
			String[] value2=value1[1].split(" ");
			
			return new Point(Integer.parseInt(value1[0].substring(1)),Integer.parseInt(value2[0].substring(0,value2[0].length()-1)),parseColor(value2[1]));
		}else if(shape.equals("LINE")) {
			String[] value1=values.split("->");
			String[] startPoint=value1[0].split("-");
			String[] endPoint=value1[1].split("-");
			
			return new Line(new Point(Integer.parseInt(startPoint[0].substring(1)),Integer.parseInt(startPoint[1].substring(0,startPoint[1].length()-1))),
					new Point(Integer.parseInt(endPoint[0].substring(1)),Integer.parseInt(endPoint[1].substring(0,endPoint[1].length()-1)))
					,parseColor(value1[2]));

		}else if(shape.equals("CIRCLE")) {
			String[] value1=values.split(" ");
			String[] center=value1[0].split(",");
			
			return new Circle(new Point(Integer.parseInt(center[0].substring(7)), Integer.parseInt(center[1].substring(0,center[1].length()-1))),
					Integer.parseInt(value1[1].substring(7, value1[1].length()-1)),
					parseColor(value1[2]),parseColor(value1[3]));
			
		}else if(shape.equals("SQUARE")) {
			String[] value1=values.split(" ");
			String[] upLeft=value1[0].split(",");
			
			return new Square(new Point(Integer.parseInt(upLeft[0].substring(7)), Integer.parseInt(upLeft[1].substring(0,upLeft[1].length()-1))),
					Integer.parseInt(value1[1].substring(5, value1[1].length()-1)),
					parseColor(value1[2]),parseColor(value1[3]));
			
		}else if(shape.equals("RECTANGLE")) {
			String[] value1=values.split(" ");
			String[] upLeft=value1[0].split(",");
			
			return new Rectangle(new Point(Integer.parseInt(upLeft[0].substring(7)), Integer.parseInt(upLeft[1].substring(0,upLeft[1].length()-1))),
					Integer.parseInt(value1[2].substring(6, value1[2].length()-1)),
					Integer.parseInt(value1[1].substring(5, value1[1].length()-1)),
					parseColor(value1[3]),parseColor(value1[4]));
			
		}else if(shape.equals("HEXAGON")) {
			String[] value1=values.split(" ");
			String[] center=value1[0].split(",");
			
			return new HexagonAdapter(Integer.parseInt(center[0].substring(7)), Integer.parseInt(center[1].substring(0,center[1].length()-1)),
					Integer.parseInt(value1[1].substring(7, value1[1].length()-1)),
					parseColor(value1[2]),parseColor(value1[3]));
			
		}
		return null;
	}


	private Color parseColor(String string) {
		String colors = string.substring(15, string.length()-1);
		String [] rgb = colors.split(",");
		
		int r = Integer.parseInt(rgb[0].substring(2, rgb[0].length()));
		int g = Integer.parseInt(rgb[1].substring(2, rgb[1].length()));
		int b = Integer.parseInt(rgb[2].substring(2, rgb[2].length()));
		return new Color(r,g,b);
	}

}
