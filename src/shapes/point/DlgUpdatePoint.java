package shapes.point;

import javax.swing.JDialog;
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


public class DlgUpdatePoint extends JDialog{
	
	private JTextField txtNewX;
	private JTextField txtNewY;
	private JButton btnBorderColor;
	
	private int xPoint;
	private int yPoint;
	private Color borderColor;
	
	private boolean updateCancel=true;
	
	
	public static void main(String[] args) {
		try {
			DlgUpdatePoint dialog= new DlgUpdatePoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public DlgUpdatePoint() {
		setTitle("Update Point");
		setModal(true);
		setBounds(100, 100, 450, 300);
		
		JPanel pnlUpdateP = new JPanel();
		getContentPane().add(pnlUpdateP, BorderLayout.CENTER);
		GridBagLayout gbl_pnlUpdateP = new GridBagLayout();
		gbl_pnlUpdateP.columnWidths = new int[]{0, 0, 0, 0};
		gbl_pnlUpdateP.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_pnlUpdateP.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlUpdateP.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlUpdateP.setLayout(gbl_pnlUpdateP);
		
		JLabel lblNewX = new JLabel("New X:");
		GridBagConstraints gbc_lblNewX = new GridBagConstraints();
		gbc_lblNewX.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewX.gridx = 1;
		gbc_lblNewX.gridy = 1;
		pnlUpdateP.add(lblNewX, gbc_lblNewX);
		
		txtNewX = new JTextField();
		GridBagConstraints gbc_txtNewX = new GridBagConstraints();
		gbc_txtNewX.insets = new Insets(0, 0, 5, 0);
		gbc_txtNewX.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNewX.gridx = 2;
		gbc_txtNewX.gridy = 1;
		pnlUpdateP.add(txtNewX, gbc_txtNewX);
		txtNewX.setColumns(10);
		
		JLabel lblNewY = new JLabel("New Y:");
		GridBagConstraints gbc_lblNewY = new GridBagConstraints();
		gbc_lblNewY.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewY.gridx = 1;
		gbc_lblNewY.gridy = 2;
		pnlUpdateP.add(lblNewY, gbc_lblNewY);
		
		txtNewY = new JTextField();
		GridBagConstraints gbc_txtNewY = new GridBagConstraints();
		gbc_txtNewY.insets = new Insets(0, 0, 5, 0);
		gbc_txtNewY.anchor = GridBagConstraints.NORTH;
		gbc_txtNewY.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNewY.gridx = 2;
		gbc_txtNewY.gridy = 2;
		pnlUpdateP.add(txtNewY, gbc_txtNewY);
		txtNewY.setColumns(10);
		
		btnBorderColor = new JButton("Border color");
		btnBorderColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnBorderColor.setBackground(JColorChooser.showDialog(null,"Choose the color", btnBorderColor.getBackground()));
			}
		});
		GridBagConstraints gbc_btnBorderColor = new GridBagConstraints();
		gbc_btnBorderColor.insets = new Insets(0, 0, 0, 5);
		gbc_btnBorderColor.gridx = 1;
		gbc_btnBorderColor.gridy = 3;
		pnlUpdateP.add(btnBorderColor, gbc_btnBorderColor);
		
		JPanel pnlBtn = new JPanel();
		getContentPane().add(pnlBtn, BorderLayout.SOUTH);
		GridBagLayout gbl_pnlBtn = new GridBagLayout();
		gbl_pnlBtn.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlBtn.rowHeights = new int[]{0, 0, 0};
		gbl_pnlBtn.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlBtn.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
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
					xPoint=Integer.parseInt(txtNewX.getText());
					yPoint=Integer.parseInt(txtNewY.getText());
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
		gbc_btnAccept.gridx = 10;
		gbc_btnAccept.gridy = 1;
		pnlBtn.add(btnAccept, gbc_btnAccept);
		btnAccept.setActionCommand("OK");
		getRootPane().setDefaultButton(btnAccept);
		btnAccept.setActionCommand("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.gridx = 11;
		gbc_btnCancel.gridy = 1;
		pnlBtn.add(btnCancel, gbc_btnCancel);
	}

	public int getxPoint() {
		return xPoint;
	}

	public void setxPoint(int xPoint) {
		this.xPoint = xPoint;
	}

	public int getyPoint() {
		return yPoint;
	}

	public void setyPoint(int yPoint) {
		this.yPoint = yPoint;
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
