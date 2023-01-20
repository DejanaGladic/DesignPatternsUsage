package shapes.circle;

import javax.swing.JDialog;
import javax.swing.JPanel;

import shapes.point.DlgUpdatePoint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.DrawingController;


public class DlgUpdateCircle extends JDialog{
	private JTextField txtXCenter;
	private JTextField txtYCenter;
	private JTextField txtNewRadius;
	
	private int x;
	private int y;
	private int radius;
	
	private Color borderColor;
	private Color areaColor;
	
	private JButton btnAreaColor;
	private JButton btnBorderColor;
	
	private boolean updateCancel=true;
	
	public static void main(String[] args) {
		try {
			DlgUpdateCircle dialog= new DlgUpdateCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public DlgUpdateCircle() {
		setTitle("Update circle");
		setModal(true);
		setBounds(100, 100, 450, 300);
		
		
		JPanel pnlUpdateCircle = new JPanel();
		getContentPane().add(pnlUpdateCircle, BorderLayout.CENTER);
		GridBagLayout gbl_pnlUpdateCircle = new GridBagLayout();
		gbl_pnlUpdateCircle.columnWidths = new int[]{0, 0, 0};
		gbl_pnlUpdateCircle.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_pnlUpdateCircle.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlUpdateCircle.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlUpdateCircle.setLayout(gbl_pnlUpdateCircle);
		
		JLabel lblNewXOf = new JLabel("New X of center");
		GridBagConstraints gbc_lblNewXOf = new GridBagConstraints();
		gbc_lblNewXOf.anchor = GridBagConstraints.EAST;
		gbc_lblNewXOf.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewXOf.gridx = 0;
		gbc_lblNewXOf.gridy = 1;
		pnlUpdateCircle.add(lblNewXOf, gbc_lblNewXOf);
		
		txtXCenter = new JTextField();
		GridBagConstraints gbc_txtXCenter = new GridBagConstraints();
		gbc_txtXCenter.insets = new Insets(0, 0, 5, 0);
		gbc_txtXCenter.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtXCenter.gridx = 1;
		gbc_txtXCenter.gridy = 1;
		pnlUpdateCircle.add(txtXCenter, gbc_txtXCenter);
		txtXCenter.setColumns(10);
		
		JLabel lblNewYOf = new JLabel("New Y of center");
		GridBagConstraints gbc_lblNewYOf = new GridBagConstraints();
		gbc_lblNewYOf.anchor = GridBagConstraints.EAST;
		gbc_lblNewYOf.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewYOf.gridx = 0;
		gbc_lblNewYOf.gridy = 2;
		pnlUpdateCircle.add(lblNewYOf, gbc_lblNewYOf);
		
		txtYCenter = new JTextField();
		GridBagConstraints gbc_txtYCenter = new GridBagConstraints();
		gbc_txtYCenter.insets = new Insets(0, 0, 5, 0);
		gbc_txtYCenter.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtYCenter.gridx = 1;
		gbc_txtYCenter.gridy = 2;
		pnlUpdateCircle.add(txtYCenter, gbc_txtYCenter);
		txtYCenter.setColumns(10);
		
		JLabel lblNewRadius = new JLabel("New radius");
		GridBagConstraints gbc_lblNewRadius = new GridBagConstraints();
		gbc_lblNewRadius.anchor = GridBagConstraints.EAST;
		gbc_lblNewRadius.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewRadius.gridx = 0;
		gbc_lblNewRadius.gridy = 3;
		pnlUpdateCircle.add(lblNewRadius, gbc_lblNewRadius);
		
		txtNewRadius = new JTextField();
		GridBagConstraints gbc_txtNewRadius = new GridBagConstraints();
		gbc_txtNewRadius.insets = new Insets(0, 0, 5, 0);
		gbc_txtNewRadius.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNewRadius.gridx = 1;
		gbc_txtNewRadius.gridy = 3;
		pnlUpdateCircle.add(txtNewRadius, gbc_txtNewRadius);
		txtNewRadius.setColumns(10);
		
		btnBorderColor = new JButton("Border color");
		btnBorderColor.setBackground(Color.WHITE);
		btnBorderColor.setForeground(Color.BLACK);
		btnBorderColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnBorderColor.setBackground(JColorChooser.showDialog(null,"Choose the color", btnBorderColor.getBackground()));
			}
		});
		GridBagConstraints gbc_btnBorderColor = new GridBagConstraints();
		gbc_btnBorderColor.insets = new Insets(0, 0, 0, 5);
		gbc_btnBorderColor.gridx = 0;
		gbc_btnBorderColor.gridy = 5;
		pnlUpdateCircle.add(btnBorderColor, gbc_btnBorderColor);
		
		btnAreaColor = new JButton("Area color");
		btnBorderColor.setBackground(Color.BLACK);
		btnBorderColor.setForeground(Color.WHITE);
		btnAreaColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAreaColor.setBackground(JColorChooser.showDialog(null,"Choose the color", btnAreaColor.getBackground()));
			}
		});
		GridBagConstraints gbc_btnAreaColor = new GridBagConstraints();
		gbc_btnAreaColor.anchor = GridBagConstraints.WEST;
		gbc_btnAreaColor.gridx = 1;
		gbc_btnAreaColor.gridy = 5;
		pnlUpdateCircle.add(btnAreaColor, gbc_btnAreaColor);
		
		JPanel pnlBtn = new JPanel();
		getContentPane().add(pnlBtn, BorderLayout.SOUTH);
		GridBagLayout gbl_pnlBtn = new GridBagLayout();
		gbl_pnlBtn.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlBtn.rowHeights = new int[]{0, 0};
		gbl_pnlBtn.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlBtn.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlBtn.setLayout(gbl_pnlBtn);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.gridx = 11;
		gbc_btnCancel.gridy = 0;
		pnlBtn.add(btnCancel, gbc_btnCancel);
		btnCancel.setActionCommand("Cancel");
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				try {
					x=Integer.parseInt(txtXCenter.getText());
					y=Integer.parseInt(txtYCenter.getText());
					radius=Integer.parseInt(txtNewRadius.getText());
					
					borderColor=btnBorderColor.getBackground();
					areaColor=btnAreaColor.getBackground();
					
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
		gbc_btnAccept.gridx = 10;
		gbc_btnAccept.gridy = 0;
		pnlBtn.add(btnAccept, gbc_btnAccept);
		btnAccept.setActionCommand("OK");
		getRootPane().setDefaultButton(btnAccept);
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public Color getAreaColor() {
		return areaColor;
	}

	public void setAreaColor(Color areaColor) {
		this.areaColor = areaColor;
	}


	public JTextField getTxtXCenter() {
		return txtXCenter;
	}

	public void setTxtXCenter(JTextField txtXCenter) {
		this.txtXCenter = txtXCenter;
	}

	public JTextField getTxtYCenter() {
		return txtYCenter;
	}

	public void setTxtYCenter(JTextField txtYCenter) {
		this.txtYCenter = txtYCenter;
	}

	public JTextField getTxtNewRadius() {
		return txtNewRadius;
	}

	public void setTxtNewRadius(JTextField txtNewRadius) {
		this.txtNewRadius = txtNewRadius;
	}

	public JButton getBtnAreaColor() {
		return btnAreaColor;
	}

	public void setBtnAreaColor(JButton btnAreaColor) {
		this.btnAreaColor = btnAreaColor;
	}

	public JButton getBtnBorderColor() {
		return btnBorderColor;
	}

	public void setBtnBorderColor(JButton btnBorderColor) {
		this.btnBorderColor = btnBorderColor;
	}

	public boolean isUpdateCancel() {
		return updateCancel;
	}

	public void setUpdateCancel(boolean updateCancel) {
		this.updateCancel = updateCancel;
	}


}
