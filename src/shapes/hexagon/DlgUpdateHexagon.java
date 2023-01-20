package shapes.hexagon;

import javax.swing.JDialog;

import shapes.square.DlgUpdateSquare;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgUpdateHexagon extends JDialog{
	private JTextField txtNewX;
	private JTextField txtNewY;
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
			DlgUpdateHexagon dialog= new DlgUpdateHexagon();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public DlgUpdateHexagon() {
		setTitle("Update hexagon");
		setModal(true);
		setBounds(100, 100, 450, 300);
		
		JPanel pnlUpdateHexa = new JPanel();
		getContentPane().add(pnlUpdateHexa, BorderLayout.CENTER);
		GridBagLayout gbl_pnlUpdateHexa = new GridBagLayout();
		gbl_pnlUpdateHexa.columnWidths = new int[]{0, 0, 0};
		gbl_pnlUpdateHexa.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_pnlUpdateHexa.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlUpdateHexa.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlUpdateHexa.setLayout(gbl_pnlUpdateHexa);
		
		JLabel lblNewX = new JLabel("New X");
		GridBagConstraints gbc_lblNewX = new GridBagConstraints();
		gbc_lblNewX.anchor = GridBagConstraints.EAST;
		gbc_lblNewX.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewX.gridx = 0;
		gbc_lblNewX.gridy = 1;
		pnlUpdateHexa.add(lblNewX, gbc_lblNewX);
		
		txtNewX = new JTextField();
		GridBagConstraints gbc_txtNewX = new GridBagConstraints();
		gbc_txtNewX.insets = new Insets(0, 0, 5, 0);
		gbc_txtNewX.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNewX.gridx = 1;
		gbc_txtNewX.gridy = 1;
		pnlUpdateHexa.add(txtNewX, gbc_txtNewX);
		txtNewX.setColumns(10);
		
		JLabel lblNewY = new JLabel("New Y");
		GridBagConstraints gbc_lblNewY = new GridBagConstraints();
		gbc_lblNewY.anchor = GridBagConstraints.EAST;
		gbc_lblNewY.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewY.gridx = 0;
		gbc_lblNewY.gridy = 2;
		pnlUpdateHexa.add(lblNewY, gbc_lblNewY);
		
		txtNewY = new JTextField();
		GridBagConstraints gbc_txtNewY = new GridBagConstraints();
		gbc_txtNewY.insets = new Insets(0, 0, 5, 0);
		gbc_txtNewY.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNewY.gridx = 1;
		gbc_txtNewY.gridy = 2;
		pnlUpdateHexa.add(txtNewY, gbc_txtNewY);
		txtNewY.setColumns(10);
		
		JLabel lblNewRadius = new JLabel("New radius");
		GridBagConstraints gbc_lblNewRadius = new GridBagConstraints();
		gbc_lblNewRadius.anchor = GridBagConstraints.EAST;
		gbc_lblNewRadius.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewRadius.gridx = 0;
		gbc_lblNewRadius.gridy = 3;
		pnlUpdateHexa.add(lblNewRadius, gbc_lblNewRadius);
		
		txtNewRadius = new JTextField();
		GridBagConstraints gbc_txtNewRadius = new GridBagConstraints();
		gbc_txtNewRadius.insets = new Insets(0, 0, 5, 0);
		gbc_txtNewRadius.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNewRadius.gridx = 1;
		gbc_txtNewRadius.gridy = 3;
		pnlUpdateHexa.add(txtNewRadius, gbc_txtNewRadius);
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
		gbc_btnBorderColor.anchor = GridBagConstraints.NORTH;
		gbc_btnBorderColor.insets = new Insets(0, 0, 5, 5);
		gbc_btnBorderColor.gridx = 0;
		gbc_btnBorderColor.gridy = 4;
		pnlUpdateHexa.add(btnBorderColor, gbc_btnBorderColor);
		btnBorderColor.setBackground(Color.BLACK);
		btnBorderColor.setForeground(Color.WHITE);
		
		btnAreaColor = new JButton("Area color");
		btnAreaColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAreaColor.setBackground(JColorChooser.showDialog(null,"Choose the color", btnAreaColor.getBackground()));
			}
		});
		GridBagConstraints gbc_btnAreaColor = new GridBagConstraints();
		gbc_btnAreaColor.insets = new Insets(0, 0, 5, 0);
		gbc_btnAreaColor.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAreaColor.gridx = 1;
		gbc_btnAreaColor.gridy = 4;
		pnlUpdateHexa.add(btnAreaColor, gbc_btnAreaColor);
		
		
		JPanel pnlBtn = new JPanel();
		getContentPane().add(pnlBtn, BorderLayout.SOUTH);
		GridBagLayout gbl_pnlBtn = new GridBagLayout();
		gbl_pnlBtn.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlBtn.rowHeights = new int[]{0, 0};
		gbl_pnlBtn.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
					x=Integer.parseInt(txtNewX.getText());
					y=Integer.parseInt(txtNewY.getText());
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
		gbc_btnAccept.gridx = 11;
		gbc_btnAccept.gridy = 0;
		pnlBtn.add(btnAccept, gbc_btnAccept);
		btnAccept.setActionCommand("OK");
		getRootPane().setDefaultButton(btnAccept);
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.gridx = 12;
		gbc_btnCancel.gridy = 0;
		pnlBtn.add(btnCancel, gbc_btnCancel);
		btnCancel.setActionCommand("Cancel");
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

	public JTextField getTxtNewX() {
		return txtNewX;
	}

	public void setTxtNewX(JTextField txtNewX) {
		this.txtNewX = txtNewX;
	}

	public JTextField getTxtNewY() {
		return txtNewY;
	}

	public void setTxtNewY(JTextField txtNewY) {
		this.txtNewY = txtNewY;
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
