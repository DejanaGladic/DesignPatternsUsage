package frame;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.DrawingController;
import shapes.Shape;
import view.DrawingView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;

import javax.swing.JToggleButton;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.GridBagConstraints;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;

import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Scrollbar;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JList;

public class DrawingFrame extends JFrame {
	
	private DrawingView drawingView=new DrawingView();
	private DrawingController controller;
	private final ButtonGroup buttonGroup = new ButtonGroup();
		
	private JButton btnModify;
	private JButton btnDelete;
	
	private JButton btnUndo;
	private JButton btnRedo;
	
	
	private JList listOFLog;
	private DefaultListModel<String> dlmLogList;
	private JButton btnParseLog;
	
	private JFileChooser chooser;
	private JFileChooser chooserOpen;
	
	private JButton btnBorderColor;
	private JButton btnAreaColor;
	
	private JButton btnBringToBack;
	private JButton btnBringToFront;
	private JButton btnTofront;
	private JButton btnToback;
	
	public DrawingFrame(JList listOFLog) throws HeadlessException {
		super();
		this.listOFLog = listOFLog;
	}


	public DrawingFrame() {
		setTitle("Gladi\u0107 Dejana IT11-2016");
		
		getContentPane().add(drawingView, BorderLayout.CENTER);
		

		//panel za oblike
		JPanel shapeView = new JPanel();
		getContentPane().add(shapeView, BorderLayout.NORTH);
		GridBagLayout gbl_shapeView = new GridBagLayout();
		gbl_shapeView.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_shapeView.rowHeights = new int[]{0, 0, 0};
		gbl_shapeView.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_shapeView.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		shapeView.setLayout(gbl_shapeView);
		
		JToggleButton tglbtnPoint = new JToggleButton("Point");
		tglbtnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.tglButtonClick(tglbtnPoint.getText());
			}
		});
		buttonGroup.add(tglbtnPoint);
		GridBagConstraints gbc_tglbtnPoint = new GridBagConstraints();
		gbc_tglbtnPoint.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnPoint.gridx = 0;
		gbc_tglbtnPoint.gridy = 0;
		shapeView.add(tglbtnPoint, gbc_tglbtnPoint);
		
		JToggleButton tglbtnLine = new JToggleButton("Line");
		tglbtnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.tglButtonClick(tglbtnLine.getText());
			}
		});
		buttonGroup.add(tglbtnLine);
		GridBagConstraints gbc_tglbtnLine = new GridBagConstraints();
		gbc_tglbtnLine.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnLine.gridx = 1;
		gbc_tglbtnLine.gridy = 0;
		shapeView.add(tglbtnLine, gbc_tglbtnLine);
		
		JToggleButton tglbtnCircle = new JToggleButton("Circle");
		tglbtnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.tglButtonClick(tglbtnCircle.getText());
			}
		});
		buttonGroup.add(tglbtnCircle);
		GridBagConstraints gbc_tglbtnCircle = new GridBagConstraints();
		gbc_tglbtnCircle.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnCircle.anchor = GridBagConstraints.WEST;
		gbc_tglbtnCircle.gridx = 2;
		gbc_tglbtnCircle.gridy = 0;
		shapeView.add(tglbtnCircle, gbc_tglbtnCircle);
		
		JToggleButton tglbtnSquare = new JToggleButton("Square");
		tglbtnSquare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.tglButtonClick(tglbtnSquare.getText());
			}
		});
		buttonGroup.add(tglbtnSquare);
		GridBagConstraints gbc_tglbtnSquare = new GridBagConstraints();
		gbc_tglbtnSquare.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnSquare.gridx = 3;
		gbc_tglbtnSquare.gridy = 0;
		shapeView.add(tglbtnSquare, gbc_tglbtnSquare);
		
		JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
		tglbtnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.tglButtonClick(tglbtnRectangle.getText());
			}
		});
		buttonGroup.add(tglbtnRectangle);
		GridBagConstraints gbc_tglbtnRectangle = new GridBagConstraints();
		gbc_tglbtnRectangle.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnRectangle.gridx = 4;
		gbc_tglbtnRectangle.gridy = 0;
		shapeView.add(tglbtnRectangle, gbc_tglbtnRectangle);
		
		JToggleButton tglbtnHexagon = new JToggleButton("Hexagon");
		tglbtnHexagon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.tglButtonClick(tglbtnHexagon.getText());
			}
		});
		buttonGroup.add(tglbtnHexagon);
		GridBagConstraints gbc_tglbtnHexagon = new GridBagConstraints();
		gbc_tglbtnHexagon.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnHexagon.gridx = 5;
		gbc_tglbtnHexagon.gridy = 0;
		shapeView.add(tglbtnHexagon, gbc_tglbtnHexagon);
		
		btnBorderColor = new JButton("Border color");
		btnBorderColor.setBackground(Color.BLACK);
		btnBorderColor.setForeground(Color.WHITE);
		btnBorderColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnBorderColor.setBackground(JColorChooser.showDialog(null,"Choose the color", btnBorderColor.getBackground()));
			}
		});
		GridBagConstraints gbc_btnBorderColor = new GridBagConstraints();
		gbc_btnBorderColor.insets = new Insets(0, 0, 0, 5);
		gbc_btnBorderColor.gridx = 0;
		gbc_btnBorderColor.gridy = 1;
		shapeView.add(btnBorderColor, gbc_btnBorderColor);
		
		btnAreaColor = new JButton("Area color");
		btnAreaColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAreaColor.setBackground(JColorChooser.showDialog(null,"Choose the color", btnAreaColor.getBackground()));
			}
		});
		btnAreaColor.setBackground(Color.WHITE);
		btnAreaColor.setForeground(Color.BLACK);
		GridBagConstraints gbc_btnAreaColor = new GridBagConstraints();
		gbc_btnAreaColor.insets = new Insets(0, 0, 0, 5);
		gbc_btnAreaColor.gridx = 1;
		gbc_btnAreaColor.gridy = 1;
		shapeView.add(btnAreaColor, gbc_btnAreaColor);
		
		
		//panel za obrisi, selektuj...
		JPanel commandView = new JPanel();
		getContentPane().add(commandView, BorderLayout.WEST);
		GridBagLayout gbl_commandView = new GridBagLayout();
		gbl_commandView.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_commandView.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_commandView.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_commandView.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		commandView.setLayout(gbl_commandView);
		
		JToggleButton tglbtnSelect = new JToggleButton("Select");
		tglbtnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.tglButtonClick(tglbtnSelect.getText());
			}
		});
		buttonGroup.add(tglbtnSelect);
		GridBagConstraints gbc_tglbtnSelect = new GridBagConstraints();
		gbc_tglbtnSelect.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnSelect.gridx = 0;
		gbc_tglbtnSelect.gridy = 0;
		commandView.add(tglbtnSelect, gbc_tglbtnSelect);
		
		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				chooserOpen = new JFileChooser();
				chooserOpen.setFileSelectionMode(JFileChooser.OPEN_DIALOG);
				chooserOpen.setFileSelectionMode(JFileChooser.FILES_ONLY); 
				chooserOpen.enableInputMethods(false);
				chooserOpen.setMultiSelectionEnabled(false);
				chooserOpen.setFileHidingEnabled(false);
				chooserOpen.setEnabled(true);
				chooserOpen.setDialogTitle("Open");
				chooserOpen.setAcceptAllFileFilterUsed(false);
				
				chooserOpen.setFileFilter(new FileNameExtensionFilter("Draw file", "ser"));
				chooserOpen.setFileFilter(new FileNameExtensionFilter("Log file", "log"));
				
				controller.open();
			}
		});
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.SAVE_DIALOG);
			    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY); 
				chooser.enableInputMethods(false);
				chooser.setMultiSelectionEnabled(false);
				chooser.setFileHidingEnabled(false);
				chooser.setEnabled(true);
				chooser.setDialogTitle("Save");
				chooser.setAcceptAllFileFilterUsed(false);
				
				controller.save();
			}
		});
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave.gridx = 0;
		gbc_btnSave.gridy = 1;
		commandView.add(btnSave, gbc_btnSave);
		
		btnRedo = new JButton("Redo");
		btnRedo.setEnabled(false);
		btnRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.redoCmd();
			}
		});
		
		btnUndo = new JButton("Undo");
		btnUndo.setEnabled(false);
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.undoCmd();
			}
		});
		
		btnDelete = new JButton("Delete");
		btnDelete.setEnabled(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.buttonClick(btnDelete.getText());
			}
		});
		
		btnModify = new JButton("Modify");
		btnModify.setEnabled(false);
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.buttonClick(btnModify.getText());
			}
		});
		GridBagConstraints gbc_btnModify = new GridBagConstraints();
		gbc_btnModify.insets = new Insets(0, 0, 5, 5);
		gbc_btnModify.gridx = 0;
		gbc_btnModify.gridy = 2;
		commandView.add(btnModify, gbc_btnModify);
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 5, 5);
		gbc_btnDelete.gridx = 0;
		gbc_btnDelete.gridy = 3;
		commandView.add(btnDelete, gbc_btnDelete);
		GridBagConstraints gbc_btnUndo = new GridBagConstraints();
		gbc_btnUndo.insets = new Insets(0, 0, 5, 5);
		gbc_btnUndo.gridx = 0;
		gbc_btnUndo.gridy = 4;
		commandView.add(btnUndo, gbc_btnUndo);
		GridBagConstraints gbc_btnRedo = new GridBagConstraints();
		gbc_btnRedo.insets = new Insets(0, 0, 5, 5);
		gbc_btnRedo.gridx = 0;
		gbc_btnRedo.gridy = 5;
		commandView.add(btnRedo, gbc_btnRedo);
		GridBagConstraints gbc_btnOpen = new GridBagConstraints();
		gbc_btnOpen.insets = new Insets(0, 0, 0, 5);
		gbc_btnOpen.gridx = 0;
		gbc_btnOpen.gridy = 6;
		commandView.add(btnOpen, gbc_btnOpen);
		
		//panel za log
		dlmLogList = new DefaultListModel<String>();
		JPanel logView = new JPanel();
		getContentPane().add(logView, BorderLayout.SOUTH);
		
		JScrollPane scrollPane = new JScrollPane();
		logView.add(scrollPane);
		
		listOFLog = new JList();
		scrollPane.setViewportView(listOFLog);
		listOFLog.setModel(dlmLogList);
		
		//panel za promenu pozicije po Z osi
		JPanel positionView = new JPanel();
		getContentPane().add(positionView, BorderLayout.EAST);
		GridBagLayout gbl_positionView = new GridBagLayout();
		gbl_positionView.columnWidths = new int[]{89, 0};
		gbl_positionView.rowHeights = new int[]{23, 0, 0, 0, 0, 0};
		gbl_positionView.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_positionView.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		positionView.setLayout(gbl_positionView);
		
		btnBringToBack = new JButton("BringToBack");
		btnBringToBack.setEnabled(false);
		btnBringToBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.positionOfZ(btnBringToBack.getText());
			}
		});
		GridBagConstraints gbc_btnBringToBack = new GridBagConstraints();
		gbc_btnBringToBack.insets = new Insets(0, 0, 5, 0);
		gbc_btnBringToBack.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnBringToBack.gridx = 0;
		gbc_btnBringToBack.gridy = 0;
		positionView.add(btnBringToBack, gbc_btnBringToBack);
		
		btnBringToFront = new JButton("BringToFront");
		btnBringToFront.setEnabled(false);
		btnBringToFront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.positionOfZ(btnBringToFront.getText());
			}
		});
		GridBagConstraints gbc_btnBringToFront = new GridBagConstraints();
		gbc_btnBringToFront.insets = new Insets(0, 0, 5, 0);
		gbc_btnBringToFront.gridx = 0;
		gbc_btnBringToFront.gridy = 1;
		positionView.add(btnBringToFront, gbc_btnBringToFront);
		
		btnToback = new JButton("ToBack");
		btnToback.setEnabled(false);
		btnToback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.positionOfZ(btnToback.getText());
			}
		});
		GridBagConstraints gbc_btnToback = new GridBagConstraints();
		gbc_btnToback.insets = new Insets(0, 0, 5, 0);
		gbc_btnToback.gridx = 0;
		gbc_btnToback.gridy = 2;
		positionView.add(btnToback, gbc_btnToback);
		
		btnTofront = new JButton("ToFront");
		btnTofront.setEnabled(false);
		btnTofront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.positionOfZ(btnTofront.getText());
			}
		});
		GridBagConstraints gbc_btnTofront = new GridBagConstraints();
		gbc_btnTofront.insets = new Insets(0, 0, 5, 0);
		gbc_btnTofront.gridx = 0;
		gbc_btnTofront.gridy = 3;
		positionView.add(btnTofront, gbc_btnTofront);
		
		btnParseLog = new JButton("Parse log");
		btnParseLog.setEnabled(false);
		btnParseLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.doParse();
			}
		});
		GridBagConstraints gbc_btnParseLog = new GridBagConstraints();
		gbc_btnParseLog.gridx = 0;
		gbc_btnParseLog.gridy = 4;
		positionView.add(btnParseLog, gbc_btnParseLog);
		
		
		
		
		drawingView.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controller.mouseClicked(arg0);
			}
		});
		
	}
	

	public DrawingView getView() {
		return drawingView;
	}
	public void setController(DrawingController controller) {
		this.controller = controller;

	}


	public JButton getBtnModify() {
		return btnModify;
	}


	public void setBtnModify(JButton btnModify) {
		this.btnModify = btnModify;
	}


	public JButton getBtnDelete() {
		return btnDelete;
	}


	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}


	public JButton getBtnUndo() {
		return btnUndo;
	}


	public void setBtnUndo(JButton btnUndo) {
		this.btnUndo = btnUndo;
	}


	public JButton getBtnRedo() {
		return btnRedo;
	}


	public void setBtnRedo(JButton btnRedo) {
		this.btnRedo = btnRedo;
	}


	public JList getListOFLog() {
		return listOFLog;
	}


	public void setListOFLog(JList listOFLog) {
		this.listOFLog = listOFLog;
	}


	public DefaultListModel<String> getDlmLogList() {
		return dlmLogList;
	}


	public void setDlmLogList(DefaultListModel<String> dlmLogList) {
		this.dlmLogList = dlmLogList;
	}


	public JFileChooser getChooser() {
		return chooser;
	}


	public void setChooser(JFileChooser chooser) {
		this.chooser = chooser;
	}


	public JFileChooser getChooserOpen() {
		return chooserOpen;
	}


	public void setChooserOpen(JFileChooser chooserOpen) {
		this.chooserOpen = chooserOpen;
	}


	public JButton getBtnBorderColor() {
		return btnBorderColor;
	}


	public void setBtnBorderColor(JButton btnBorderColor) {
		this.btnBorderColor = btnBorderColor;
	}


	public JButton getBtnAreaColor() {
		return btnAreaColor;
	}


	public void setBtnAreaColor(JButton btnAreaColor) {
		this.btnAreaColor = btnAreaColor;
	}


	public JButton getBtnParseLog() {
		return btnParseLog;
	}


	public void setBtnParseLog(JButton btnParseLog) {
		this.btnParseLog = btnParseLog;
	}


	public JButton getBtnBringToBack() {
		return btnBringToBack;
	}


	public void setBtnBringToBack(JButton btnBringToBack) {
		this.btnBringToBack = btnBringToBack;
	}


	public JButton getBtnBringToFront() {
		return btnBringToFront;
	}


	public void setBtnBringToFront(JButton btnBringToFront) {
		this.btnBringToFront = btnBringToFront;
	}


	public JButton getBtnTofront() {
		return btnTofront;
	}


	public void setBtnTofront(JButton btnTofront) {
		this.btnTofront = btnTofront;
	}


	public JButton getBtnToback() {
		return btnToback;
	}


	public void setBtnToback(JButton btnToback) {
		this.btnToback = btnToback;
	}

}
