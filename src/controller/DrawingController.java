package controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.color.CMMException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


import javax.swing.DefaultListModel;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import frame.DrawingFrame;
import hexagon.Hexagon;
import model.DrawingModel;
import shapes.AddShape;
import shapes.BringToBack;
import shapes.BringToFront;
import shapes.Command;
import shapes.DeleteMultipleShapes;
import shapes.DeleteShape;
import shapes.Observer;
import shapes.Shape;
import shapes.ToBack;
import shapes.ToFront;
import shapes.UpdateShape;
import shapes.circle.Circle;
import shapes.circle.DlgAddCircle;
import shapes.circle.DlgUpdateCircle;
import shapes.hexagon.DlgAddHexa;
import shapes.hexagon.DlgUpdateHexagon;
import shapes.hexagon.HexagonAdapter;
import shapes.line.DlgUpdateLine;
import shapes.line.Line;
import shapes.point.DlgUpdatePoint;
import shapes.point.Point;
import shapes.rectangle.DlgAddRect;
import shapes.rectangle.DlgUpdateRectangle;
import shapes.rectangle.Rectangle;
import shapes.square.DlgAddSquare;
import shapes.square.DlgUpdateSquare;
import shapes.square.Square;
import strategy.Context;
import strategy.FileDraw;
import strategy.FileLog;

public class DrawingController {
	
	private DrawingModel model;
	private DrawingFrame frame;
	private String buttonName;
	
	private boolean firstClick=true;
	private Point start;
	
	//krecemo od jedinice da bismo omogucili nesmetano selektovanje
	private int numberOfSelection=1;
	
	//liste za undo i redo
	private ArrayList<Command> undoCommands;
	private ArrayList<Command> redoCommands;
	
	//private String undoRedo;
	private String btn;
	
	private String zPosition;
	
	private DefaultListModel<String> dlmLogList;
	
	private Context context;
	
	private FileLog fileLog;
	

	public DrawingController(DrawingModel model, DrawingFrame frame) {
		this.model = model;
		this.frame = frame;
		
		this.undoCommands=new ArrayList<Command>();
		this.redoCommands=new ArrayList<Command>();
		this.dlmLogList=frame.getDlmLogList();
	}

	public void mouseClicked(MouseEvent a) {

		AddShape cmdAddShape;
		
		if(buttonName!=null) {
			if(buttonName.equals("Point")) {
				Point p=new Point(a.getX(),a.getY(),frame.getBtnBorderColor().getBackground());
				cmdAddShape=new AddShape(p, model);
				doCmd(cmdAddShape);
				
				dlmLogList.addElement(cmdAddShape.getHelp());
			}
			else if(buttonName.equals("Line")){
				
				if(firstClick==true) {
					start=new Point(a.getX(),a.getY());
					firstClick=false;
				}else if(firstClick==false) {
					Line l=new Line(start,new Point(a.getX(),a.getY()),frame.getBtnBorderColor().getBackground());
					firstClick=true;
					cmdAddShape=new AddShape(l, model);
					doCmd(cmdAddShape);
					
					dlmLogList.addElement(cmdAddShape.getHelp());

				}
			}
			else if(buttonName.equals("Rectangle")) {
				DlgAddRect dar=new DlgAddRect();
				dar.setVisible(true);
				Rectangle r=new Rectangle(new Point(a.getX(),a.getY()),dar.getWidthRect(), dar.getSide(),frame.getBtnBorderColor().getBackground(),frame.getBtnAreaColor().getBackground());
				if(dar.getSide()>0 && dar.getWidthRect()>0) {
					cmdAddShape=new AddShape(r, model);
					doCmd(cmdAddShape);
					
					dlmLogList.addElement(cmdAddShape.getHelp());
				}
				else if(dar.getSide()<0 || dar.getWidthRect()<0)
					JOptionPane.showMessageDialog(null, "Value can't be negative", "Warning", JOptionPane.ERROR_MESSAGE);

			}
			else if(buttonName.equals("Square")) {
				DlgAddSquare das=new DlgAddSquare();
				das.setVisible(true);
				Square s=new Square(new Point(a.getX(),a.getY()), das.getSide(),frame.getBtnBorderColor().getBackground(),frame.getBtnAreaColor().getBackground());
				if(das.getSide()>0) {
					cmdAddShape=new AddShape(s, model);
					doCmd(cmdAddShape);
					
					dlmLogList.addElement(cmdAddShape.getHelp());
				}
				else if(das.getSide()<0)
					JOptionPane.showMessageDialog(null, "Value can't be negative", "Warning", JOptionPane.ERROR_MESSAGE);

			}

			else if(buttonName.equals("Circle")) {
				DlgAddCircle dac=new DlgAddCircle();
				dac.setVisible(true);
				Circle c=new Circle(new Point(a.getX(),a.getY()), dac.getRadius(),frame.getBtnBorderColor().getBackground(),frame.getBtnAreaColor().getBackground());
				if(dac.getRadius()>0) {
					cmdAddShape=new AddShape(c, model);
					doCmd(cmdAddShape);
					
					dlmLogList.addElement(cmdAddShape.getHelp());
				}
				else if(dac.getRadius()<0)
					JOptionPane.showMessageDialog(null, "Value can't be negative", "Warning", JOptionPane.ERROR_MESSAGE);

			}
			else if(buttonName.equals("Hexagon")) {
				DlgAddHexa dah=new DlgAddHexa();
				dah.setVisible(true);
				HexagonAdapter c=new HexagonAdapter(a.getX(),a.getY(), dah.getRadius(),frame.getBtnBorderColor().getBackground(),frame.getBtnAreaColor().getBackground());

				if(dah.getRadius()>0) {
					cmdAddShape=new AddShape(c, model);
					doCmd(cmdAddShape);
					
					dlmLogList.addElement(cmdAddShape.getHelp());
				}
				else if(dah.getRadius()<0)
					JOptionPane.showMessageDialog(null, "Value can't be negative", "Warning", JOptionPane.ERROR_MESSAGE);

			}
			else if(buttonName.equals("Select")) {
				for(int i=model.getShapeList().size()-1; i>=0; i--) {
					if(model.getShape(i).containsPoint(a.getX(), a.getY())) {
						
						if(model.getShape(i).isSelected()==false)
						{
							model.getShape(i).setSelected(true);
							++numberOfSelection;						
							changed();
							
							dlmLogList.addElement("SELECT_" + model.getShape(i).toString());
							
							i=0;
							
							
						}
						else {
							
							model.getShape(i).setSelected(false);
							--numberOfSelection;							
							changed();
							
							dlmLogList.addElement("UNSELECT_" + model.getShape(i).toString());
							
							i=0;
						}
						
					}	
					
				}	

			}
			
			
			if(buttonName.equals("Line")==false && firstClick==false)
				firstClick=true;
			
		}

		frame.getView().repaint();

	}


	public void tglButtonClick(String buttonName) {
		
		this.buttonName=buttonName;
	}
	
	
	//DO UNDO REDO
	
	public void doCmd(Command c) {
		c.execute();
		
		undoCommands.add(c);
	
		redoCommands.clear();
		frame.getBtnRedo().setEnabled(false);
		frame.getBtnUndo().setEnabled(true);
		
	}
	
	public void undoCmd() {
		
		//deselektuje one koji su ostali u listi oblika na undo-ako to treba
		for(int i=model.getShapeList().size()-1; i>=0; i--) {
			model.getShape(i).setSelected(false);
		}
		numberOfSelection=1;
		
		changed();
		
		
		undoCommands.get(undoCommands.size()-1).unexecute();
		
		Command cmd=undoCommands.get(undoCommands.size()-1);
		
		if(cmd instanceof AddShape) {
			
			if(((AddShape) cmd).getShape().isSelected()==true)
			{
				//deselektuje onaj oblik koji add.unexecute() i obavestava da je doslo do promene
				((AddShape) cmd).getShape().setSelected(false);
				numberOfSelection--;
				changed();
			}
			
			dlmLogList.addElement(((AddShape)cmd).getHelp());
		}else if(cmd instanceof DeleteShape) {
			
			//????brisem selektovanje na svaki undo pa mi ovaj uslov ni ne treba tako 
			if(((DeleteShape) cmd).getShape().isSelected()==true)
			{
				//zapisuje da se onaj oblik koji je obrisan vratio kao selektovan da bi se enable dugmad????
				numberOfSelection++;
				changed();
			}
			
			dlmLogList.addElement(((DeleteShape)cmd).getHelp());
		}else if(cmd instanceof UpdateShape) {
			dlmLogList.addElement(((UpdateShape)cmd).getHelp());
			
		}else if(cmd instanceof DeleteMultipleShapes) {
			dlmLogList.addElement(((DeleteMultipleShapes)cmd).getHelp());
			
		}else if(cmd instanceof ToFront) {
			dlmLogList.addElement(((ToFront)cmd).getHelp());
			
		}else if(cmd instanceof ToBack) {
			dlmLogList.addElement(((ToBack)cmd).getHelp());
			
		}else if(cmd instanceof BringToFront) {
			dlmLogList.addElement(((BringToFront)cmd).getHelp());
			
		}else if(cmd instanceof BringToBack) {
			dlmLogList.addElement(((BringToBack)cmd).getHelp());
		}
			
		redoCommands.add(undoCommands.get(undoCommands.size()-1));
		frame.getBtnRedo().setEnabled(true);
		
		undoCommands.remove(undoCommands.size()-1);
		if(undoCommands.size()==0)
			frame.getBtnUndo().setEnabled(false);

		
		frame.getView().repaint();
	}
	
	public void redoCmd() {
		
		if(redoCommands.size()>0) {
			
			redoCommands.get(redoCommands.size()-1).execute();
			
			Command cmd=redoCommands.get(redoCommands.size()-1);
			
			if(cmd instanceof AddShape) {
				dlmLogList.addElement(((AddShape)cmd).getHelp());
			}else if(cmd instanceof DeleteShape) {
				dlmLogList.addElement(((DeleteShape)cmd).getHelp());
			}else if(cmd instanceof UpdateShape) {
				dlmLogList.addElement(((UpdateShape)cmd).getHelp());
			}
			
			undoCommands.add(redoCommands.get(redoCommands.size()-1));
			if(undoCommands.size()>0)
				frame.getBtnUndo().setEnabled(true);
			
			redoCommands.remove(redoCommands.size()-1);
			if(redoCommands.size()==0)
				frame.getBtnRedo().setEnabled(false);
		
			frame.getView().repaint();
		}
		
	}

	public void buttonClick(String text) {
		btn=text;
		
		Shape selectedShape;
		
		UpdateShape cmdUpdateShape;
		DeleteMultipleShapes cmdDeleteShapes;
		DeleteShape cmdDeleteShape;
		
		Object[] options = {"Yes","No"};
		int n;
		
		
		if(btn.equals("Modify")) {
			for(int i=model.getShapeList().size()-1; i>=0; i--) {
			
			if(model.getShape(i).isSelected()==true) {
							
					selectedShape=model.getShape(i);
					
					if(selectedShape instanceof Point) {
						
						DlgUpdatePoint dlg=new DlgUpdatePoint();
						
						dlg.getTxtNewX().setText(((Point)selectedShape).getX()+"");
						dlg.getTxtNewY().setText(((Point)selectedShape).getY()+"");
						dlg.getBtnBorderColor().setBackground(((Point)selectedShape).getColor());
						
						dlg.setVisible(true);

						if (!dlg.isUpdateCancel()) {
							Point p = new Point(dlg.getxPoint(), dlg.getyPoint(),
									dlg.getBtnBorderColor().getBackground());
							cmdUpdateShape = new UpdateShape(selectedShape, p);
							doCmd(cmdUpdateShape);
							dlmLogList.addElement(cmdUpdateShape.getHelp());
						}

						
					}
					else if(selectedShape instanceof Rectangle) {
						
						DlgUpdateRectangle dlg=new DlgUpdateRectangle();
						
						dlg.getTxtNewX().setText(((Rectangle)selectedShape).getUpLeft().getX()+"");
						dlg.getTxtNewY().setText(((Rectangle)selectedShape).getUpLeft().getY()+"");
						dlg.getTxtNewLength().setText(((Rectangle)selectedShape).getSide()+"");
						dlg.getTxtNewWidth().setText(((Rectangle)selectedShape).getWidthS()+"");
						dlg.getBtnBorderColor().setBackground(((Rectangle)selectedShape).getColor());
						dlg.getBtnAreaColor().setBackground(((Rectangle)selectedShape).getInnerColor());
						
						dlg.setVisible(true);
						
						if (!dlg.isUpdateCancel()) {
							Rectangle r = new Rectangle(new Point(dlg.getX(), dlg.getY()), dlg.getWidthS(),
									dlg.getSide(), dlg.getBtnBorderColor().getBackground(),
									dlg.getBtnAreaColor().getBackground());
							cmdUpdateShape = new UpdateShape(selectedShape, r);
							doCmd(cmdUpdateShape);
							dlmLogList.addElement(cmdUpdateShape.getHelp());
						}

					}
					else if(selectedShape instanceof Square) {
						
						DlgUpdateSquare dlg=new DlgUpdateSquare();
						
						dlg.getTxtNewX().setText(((Square)selectedShape).getUpLeft().getX()+"");
						dlg.getTxtNewY().setText(((Square)selectedShape).getUpLeft().getY()+"");
						dlg.getTxtNewLength().setText(((Square)selectedShape).getSide()+"");
						dlg.getBtnBorderColor().setBackground(((Square)selectedShape).getColor());
						dlg.getBtnAreaColor().setBackground(((Square)selectedShape).getInnerColor());
						
						dlg.setVisible(true);
						
						if (!dlg.isUpdateCancel()) {
							Square s = new Square(new Point(dlg.getX(), dlg.getY()), dlg.getSide(),
									dlg.getBtnBorderColor().getBackground(), dlg.getBtnAreaColor().getBackground());
							cmdUpdateShape = new UpdateShape(selectedShape, s);
							doCmd(cmdUpdateShape);
							dlmLogList.addElement(cmdUpdateShape.getHelp());
						}

					}
					else if(selectedShape instanceof Circle) {
						
						DlgUpdateCircle dlg=new DlgUpdateCircle();
						
						dlg.getTxtXCenter().setText(((Circle)selectedShape).getCenter().getX()+"");
						dlg.getTxtYCenter().setText(((Circle)selectedShape).getCenter().getY()+"");
						dlg.getTxtNewRadius().setText(((Circle)selectedShape).getRadius()+"");
						dlg.getBtnBorderColor().setBackground(((Circle)selectedShape).getColor());
						dlg.getBtnAreaColor().setBackground(((Circle)selectedShape).getInnerColor());

						dlg.setVisible(true);
						
						if (!dlg.isUpdateCancel()) {
							Circle c = new Circle(new Point(dlg.getX(), dlg.getY()), dlg.getRadius(),
									dlg.getBorderColor(), dlg.getAreaColor());
							cmdUpdateShape = new UpdateShape(selectedShape, c);
							doCmd(cmdUpdateShape);
							dlmLogList.addElement(cmdUpdateShape.getHelp());
						}

					}
					else if(selectedShape instanceof Line) {
						
						DlgUpdateLine dlg=new DlgUpdateLine();
						
						dlg.getNewXofStart().setText(((Line)selectedShape).getStart().getX()+"");
						dlg.getNewYofStart().setText(((Line)selectedShape).getStart().getY()+"");
						dlg.getNewXofEnd().setText(((Line)selectedShape).getEnd().getX()+"");
						dlg.getNewYofEnd().setText(((Line)selectedShape).getEnd().getY()+"");
						dlg.getBtnBorderColor().setBackground(((Line)selectedShape).getColor());
						
						dlg.setVisible(true);
						
						if (!dlg.isUpdateCancel()) {
							Line l = new Line(new Point(dlg.getxStart(), dlg.getyStart()),
									new Point(dlg.getxEnd(), dlg.getyEnd()), dlg.getBorderColor());
							cmdUpdateShape = new UpdateShape(selectedShape, l);
							doCmd(cmdUpdateShape);
							dlmLogList.addElement(cmdUpdateShape.getHelp());
						}

					}
					else if(selectedShape instanceof HexagonAdapter) {
						DlgUpdateHexagon dlg=new DlgUpdateHexagon();
						
						dlg.getTxtNewX().setText(((HexagonAdapter)selectedShape).getHexagon().getX()+"");
						dlg.getTxtNewY().setText(((HexagonAdapter)selectedShape).getHexagon().getY()+"");
						dlg.getTxtNewRadius().setText(((HexagonAdapter)selectedShape).getHexagon().getR()+"");
						dlg.getBtnBorderColor().setBackground(((HexagonAdapter)selectedShape).getHexagon().getBorderColor());
						dlg.getBtnAreaColor().setBackground(((HexagonAdapter)selectedShape).getHexagon().getAreaColor());

						
						dlg.setVisible(true);
						
						if (!dlg.isUpdateCancel()) {
							HexagonAdapter h = new HexagonAdapter(dlg.getX(), dlg.getY(), dlg.getRadius(),
									dlg.getBtnBorderColor().getBackground(), dlg.getBtnAreaColor().getBackground());
							cmdUpdateShape = new UpdateShape(selectedShape, h);
							doCmd(cmdUpdateShape);
							dlmLogList.addElement(cmdUpdateShape.getHelp());
						}
						
					}

				}
			}
		}
					
		else if(btn.equals("Delete")) {
			
			ArrayList<Shape>selectedShapes=new ArrayList<Shape>();
			for(int i=model.getShapeList().size()-1; i>=0; i--) {
				
				if(model.getShape(i).isSelected()==true) {
				
					model.getShape(i).setSelected(false);
				
					selectedShapes.add(model.getShape(i));
				
				}
			}
			
			n = JOptionPane.showOptionDialog(null,
				    "Are you sure you want to delete selected shapes?",
				    "Delete Confirmation",
				    JOptionPane.YES_NO_OPTION,
				    JOptionPane.QUESTION_MESSAGE,
				    null,     //do not use a custom Icon
				    options,  //the titles of buttons
				    options[0]);
			
			if(n==0) {
				if(selectedShapes.size()==1) {
					cmdDeleteShape=new DeleteShape(selectedShapes.get(0), model);									
					doCmd(cmdDeleteShape);				
					dlmLogList.addElement(cmdDeleteShape.getHelp());
					
				}
				else if (selectedShapes.size()>1) {
					cmdDeleteShapes = new DeleteMultipleShapes(model, selectedShapes);
					doCmd(cmdDeleteShapes);
					dlmLogList.addElement(cmdDeleteShapes.getHelp());
				}
				numberOfSelection=1;
				changed();
			}
			
			
		}
				
			
		
		frame.getView().repaint();
		
	}
	
	public void changed() {
		model.somethingChanged(numberOfSelection);				
		frame.getBtnDelete().setEnabled(model.getObserver().isDelete());
		frame.getBtnModify().setEnabled(model.getObserver().isUpdate());
		
		frame.getBtnBringToFront().setEnabled(model.getObserver().isMoveForZ());
		frame.getBtnBringToBack().setEnabled(model.getObserver().isMoveForZ());
		frame.getBtnToback().setEnabled(model.getObserver().isMoveForZ());
		frame.getBtnTofront().setEnabled(model.getObserver().isMoveForZ());
		
	}

	public void positionOfZ(String text) {
		
		zPosition=text;
		
		for(int i=model.getShapeList().size()-1; i>=0; i--) {
			
			if(model.getShape(i).isSelected()==true) {
				
				if(zPosition.equals("BringToFront")) {
					
					BringToFront btf=new BringToFront(model, model.getShape(i));
					doCmd(btf);
					
					dlmLogList.addElement(btf.getHelp());
					break;
				}
				else if(zPosition.equals("ToFront")) {
					
					ToFront tf=new ToFront(model, model.getShape(i));
					doCmd(tf);
					
					dlmLogList.addElement(tf.getHelp());
					break;
				}else if(zPosition.equals("ToBack")) {
					
					ToBack tb=new ToBack(model, model.getShape(i));
					doCmd(tb);
					
					dlmLogList.addElement(tb.getHelp());
					break;
				}else if(zPosition.equals("BringToBack")) {
					
					BringToBack btb=new BringToBack(model, model.getShape(i));
					doCmd(btb);
					
					dlmLogList.addElement(btb.getHelp());
					break;
				}
			}
		}
		
		frame.getView().repaint();
		
	}
	
	//nisi je iskoristila, kontam ni ne treba ti
	public  Color chooseColor(Color colorBefore) {
		Color newColor=JColorChooser.showDialog(null,"Choose the color", colorBefore);
		
		if(newColor!=null)
			return newColor;
		else
			return colorBefore;
	}
	

	public void save() {
		if (!model.getShapeList().isEmpty()) {
			frame.getChooser().setFileFilter(new FileNameExtensionFilter("Draw file", "ser"));
		}
		if (!dlmLogList.isEmpty()) 
			frame.getChooser().setFileFilter(new FileNameExtensionFilter("Log file", "log"));
		
		if(frame.getChooser().showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			if (frame.getChooser().getFileFilter().getDescription().equals("Draw file"))
					context = new Context(new FileDraw(model));
			
			if (frame.getChooser().getFileFilter().getDescription().equals("Log file"))
					context = new Context(new FileLog(frame, model, this));
			context.save(frame.getChooser().getSelectedFile());
		}
		
		frame.getChooser().setVisible(false);
		
	}

	public void open() {
		
		frame.getBtnParseLog().setEnabled(true);
		if(frame.getChooserOpen().showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			model.removeMultiple(model.getShapeList());
			dlmLogList.removeAllElements();
			undoCommands.clear();
			redoCommands.clear();
			frame.getView().repaint();
			
			if (frame.getChooserOpen().getFileFilter().getDescription().equals("Draw file")) {
				context = new Context(new FileDraw(model));
			}
			else if (frame.getChooserOpen().getFileFilter().getDescription().equals("Log file")) {
				fileLog=new FileLog(frame, model, this);
				context = new Context(fileLog);
			}
			context.open(frame.getChooserOpen().getSelectedFile());
		}	
		frame.getChooserOpen().setVisible(false);
	}

	public void doParse() {
		
		fileLog.getLine();
	}

	public DefaultListModel<String> getDlmLogList() {
		return dlmLogList;
	}

	public void setDlmLogList(DefaultListModel<String> dlmLogList) {
		this.dlmLogList = dlmLogList;
	}

	public int getNumberOfSelection() {
		return numberOfSelection;
	}

	public void setNumberOfSelection(int numberOfSelection) {
		this.numberOfSelection = numberOfSelection;
	}
	
	
	
	

}
