package shapes.line;

import javax.swing.JDialog;

import shapes.square.DlgUpdateSquare;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgUpdateLine extends JDialog{
	private JTextField newXofStart;
	private JTextField newYofStart;
	private JTextField newXofEnd;
	private JTextField newYofEnd;
	
	private int xStart;
	private int yStart;
	private int xEnd;
	private int yEnd;
	
	private Color borderColor;
	
	private JButton btnBorderColor;
	
	private boolean updateCancel=true;

	
	public static void main(String[] args) {
		try {
			DlgUpdateLine dialog= new DlgUpdateLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public DlgUpdateLine() {
		setTitle("Update line");
		setModal(true);
		setBounds(100, 100, 450, 300);
		
		JPanel pnlUpdateLine = new JPanel();
		getContentPane().add(pnlUpdateLine, BorderLayout.CENTER);
		GridBagLayout gbl_pnlUpdateLine = new GridBagLayout();
		gbl_pnlUpdateLine.columnWidths = new int[]{0, 0, 0};
		gbl_pnlUpdateLine.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_pnlUpdateLine.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlUpdateLine.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlUpdateLine.setLayout(gbl_pnlUpdateLine);
		
		JLabel lblNewXOf = new JLabel("New X of start point");
		GridBagConstraints gbc_lblNewXOf = new GridBagConstraints();
		gbc_lblNewXOf.anchor = GridBagConstraints.EAST;
		gbc_lblNewXOf.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewXOf.gridx = 0;
		gbc_lblNewXOf.gridy = 1;
		pnlUpdateLine.add(lblNewXOf, gbc_lblNewXOf);
		
		newXofStart = new JTextField();
		GridBagConstraints gbc_newXofStart = new GridBagConstraints();
		gbc_newXofStart.insets = new Insets(0, 0, 5, 0);
		gbc_newXofStart.fill = GridBagConstraints.HORIZONTAL;
		gbc_newXofStart.gridx = 1;
		gbc_newXofStart.gridy = 1;
		pnlUpdateLine.add(newXofStart, gbc_newXofStart);
		newXofStart.setColumns(10);
		
		JLabel lblNewYOf = new JLabel("New Y of start point");
		GridBagConstraints gbc_lblNewYOf = new GridBagConstraints();
		gbc_lblNewYOf.anchor = GridBagConstraints.EAST;
		gbc_lblNewYOf.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewYOf.gridx = 0;
		gbc_lblNewYOf.gridy = 2;
		pnlUpdateLine.add(lblNewYOf, gbc_lblNewYOf);
		
		newYofStart = new JTextField();
		GridBagConstraints gbc_newYofStart = new GridBagConstraints();
		gbc_newYofStart.insets = new Insets(0, 0, 5, 0);
		gbc_newYofStart.fill = GridBagConstraints.HORIZONTAL;
		gbc_newYofStart.gridx = 1;
		gbc_newYofStart.gridy = 2;
		pnlUpdateLine.add(newYofStart, gbc_newYofStart);
		newYofStart.setColumns(10);
		
		JLabel lblNewXOf_1 = new JLabel("New X of end point");
		GridBagConstraints gbc_lblNewXOf_1 = new GridBagConstraints();
		gbc_lblNewXOf_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewXOf_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewXOf_1.gridx = 0;
		gbc_lblNewXOf_1.gridy = 3;
		pnlUpdateLine.add(lblNewXOf_1, gbc_lblNewXOf_1);
		
		newXofEnd = new JTextField();
		GridBagConstraints gbc_newXofEnd = new GridBagConstraints();
		gbc_newXofEnd.insets = new Insets(0, 0, 5, 0);
		gbc_newXofEnd.fill = GridBagConstraints.HORIZONTAL;
		gbc_newXofEnd.gridx = 1;
		gbc_newXofEnd.gridy = 3;
		pnlUpdateLine.add(newXofEnd, gbc_newXofEnd);
		newXofEnd.setColumns(10);
		
		JLabel lblNewYOf_1 = new JLabel("New Y of end point");
		GridBagConstraints gbc_lblNewYOf_1 = new GridBagConstraints();
		gbc_lblNewYOf_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewYOf_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewYOf_1.gridx = 0;
		gbc_lblNewYOf_1.gridy = 4;
		pnlUpdateLine.add(lblNewYOf_1, gbc_lblNewYOf_1);
		
		btnBorderColor = new JButton("Border color");
		btnBorderColor.setBackground(Color.WHITE);
		btnBorderColor.setForeground(Color.BLACK);
		btnBorderColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnBorderColor.setBackground(JColorChooser.showDialog(null,"Choose the color", btnBorderColor.getBackground()));
			}
		});
		
		newYofEnd = new JTextField();
		GridBagConstraints gbc_newYofEnd = new GridBagConstraints();
		gbc_newYofEnd.insets = new Insets(0, 0, 5, 0);
		gbc_newYofEnd.fill = GridBagConstraints.HORIZONTAL;
		gbc_newYofEnd.gridx = 1;
		gbc_newYofEnd.gridy = 4;
		pnlUpdateLine.add(newYofEnd, gbc_newYofEnd);
		newYofEnd.setColumns(10);
		GridBagConstraints gbc_btnBorderColor = new GridBagConstraints();
		gbc_btnBorderColor.insets = new Insets(0, 0, 0, 5);
		gbc_btnBorderColor.gridx = 0;
		gbc_btnBorderColor.gridy = 5;
		pnlUpdateLine.add(btnBorderColor, gbc_btnBorderColor);
				
		
		JPanel pnlBtn = new JPanel();
		getContentPane().add(pnlBtn, BorderLayout.SOUTH);
		GridBagLayout gbl_pnlBtn = new GridBagLayout();
		gbl_pnlBtn.columnWidths = new int[]{184, 65, 0, 0, 0, 0, 0};
		gbl_pnlBtn.rowHeights = new int[]{23, 0};
		gbl_pnlBtn.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlBtn.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlBtn.setLayout(gbl_pnlBtn);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateCancel=true;
				dispose();
			}
		});
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					xStart=Integer.parseInt(newXofStart.getText());
					yStart=Integer.parseInt(newYofStart.getText());
					xEnd=Integer.parseInt(newXofEnd.getText());
					yEnd=Integer.parseInt(newYofEnd.getText());
					
					borderColor=btnBorderColor.getBackground();
					
					updateCancel=false;
					
					dispose();
					
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(rootPane, "Check inserted value!");	
					e.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnAccept = new GridBagConstraints();
		gbc_btnAccept.insets = new Insets(0, 0, 0, 5);
		gbc_btnAccept.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAccept.gridx = 4;
		gbc_btnAccept.gridy = 0;
		pnlBtn.add(btnAccept, gbc_btnAccept);
		btnAccept.setActionCommand("OK");
		getRootPane().setDefaultButton(btnAccept);
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.gridx = 5;
		gbc_btnCancel.gridy = 0;
		pnlBtn.add(btnCancel, gbc_btnCancel);
		btnCancel.setActionCommand("Cancel");
	}

	public int getxStart() {
		return xStart;
	}

	public void setxStart(int xStart) {
		this.xStart = xStart;
	}

	public int getyStart() {
		return yStart;
	}

	public void setyStart(int yStart) {
		this.yStart = yStart;
	}

	public int getxEnd() {
		return xEnd;
	}

	public void setxEnd(int xEnd) {
		this.xEnd = xEnd;
	}

	public int getyEnd() {
		return yEnd;
	}

	public void setyEnd(int yEnd) {
		this.yEnd = yEnd;
	}

	public JTextField getNewXofStart() {
		return newXofStart;
	}

	public void setNewXofStart(JTextField newXofStart) {
		this.newXofStart = newXofStart;
	}

	public JTextField getNewYofStart() {
		return newYofStart;
	}

	public void setNewYofStart(JTextField newYofStart) {
		this.newYofStart = newYofStart;
	}

	public JTextField getNewXofEnd() {
		return newXofEnd;
	}

	public void setNewXofEnd(JTextField newXofEnd) {
		this.newXofEnd = newXofEnd;
	}

	public JTextField getNewYofEnd() {
		return newYofEnd;
	}

	public void setNewYofEnd(JTextField newYofEnd) {
		this.newYofEnd = newYofEnd;
	}

	public JButton getBtnBorderColor() {
		return btnBorderColor;
	}

	public void setBtnBorderColor(JButton btnBorderColor) {
		this.btnBorderColor = btnBorderColor;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public boolean isUpdateCancel() {
		return updateCancel;
	}

	public void setUpdateCancel(boolean updateCancel) {
		this.updateCancel = updateCancel;
	}
	
	

}
