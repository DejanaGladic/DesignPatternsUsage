package shapes.square;

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

import shapes.point.DlgUpdatePoint;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgUpdateSquare extends JDialog{
	private JTextField txtNewX;
	private JTextField txtNewY;
	private JTextField txtNewLength;
	
	private int x;
	private int y;
	private int side;
	
	private Color borderColor;
	private Color areaColor;
	
	private JButton btnAreaColor;
	private JButton btnBorderColor;
	
	private boolean updateCancel=true;

	
	public static void main(String[] args) {
		try {
			DlgUpdateSquare dialog= new DlgUpdateSquare();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public DlgUpdateSquare() {
		setTitle("Update square");
		setModal(true);
		setBounds(100, 100, 450, 300);
		
		JPanel pnlUpdateSquare = new JPanel();
		getContentPane().add(pnlUpdateSquare, BorderLayout.CENTER);
		GridBagLayout gbl_pnlUpdateSquare = new GridBagLayout();
		gbl_pnlUpdateSquare.columnWidths = new int[]{0, 0, 0};
		gbl_pnlUpdateSquare.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_pnlUpdateSquare.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlUpdateSquare.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE, 0.0};
		pnlUpdateSquare.setLayout(gbl_pnlUpdateSquare);
		
		JLabel lblNewXOf = new JLabel("New X of up left");
		GridBagConstraints gbc_lblNewXOf = new GridBagConstraints();
		gbc_lblNewXOf.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewXOf.anchor = GridBagConstraints.EAST;
		gbc_lblNewXOf.gridx = 0;
		gbc_lblNewXOf.gridy = 1;
		pnlUpdateSquare.add(lblNewXOf, gbc_lblNewXOf);
		
		txtNewX = new JTextField();
		GridBagConstraints gbc_txtNewX = new GridBagConstraints();
		gbc_txtNewX.insets = new Insets(0, 0, 5, 0);
		gbc_txtNewX.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNewX.gridx = 1;
		gbc_txtNewX.gridy = 1;
		pnlUpdateSquare.add(txtNewX, gbc_txtNewX);
		txtNewX.setColumns(10);
		
		JLabel lblNewYOf = new JLabel("New Y of up left");
		GridBagConstraints gbc_lblNewYOf = new GridBagConstraints();
		gbc_lblNewYOf.anchor = GridBagConstraints.EAST;
		gbc_lblNewYOf.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewYOf.gridx = 0;
		gbc_lblNewYOf.gridy = 2;
		pnlUpdateSquare.add(lblNewYOf, gbc_lblNewYOf);
		
		txtNewY = new JTextField();
		GridBagConstraints gbc_txtNewY = new GridBagConstraints();
		gbc_txtNewY.insets = new Insets(0, 0, 5, 0);
		gbc_txtNewY.anchor = GridBagConstraints.NORTH;
		gbc_txtNewY.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNewY.gridx = 1;
		gbc_txtNewY.gridy = 2;
		pnlUpdateSquare.add(txtNewY, gbc_txtNewY);
		txtNewY.setColumns(10);
		
		JLabel lblNewLength = new JLabel("New length");
		GridBagConstraints gbc_lblNewLength = new GridBagConstraints();
		gbc_lblNewLength.anchor = GridBagConstraints.EAST;
		gbc_lblNewLength.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLength.gridx = 0;
		gbc_lblNewLength.gridy = 3;
		pnlUpdateSquare.add(lblNewLength, gbc_lblNewLength);
		
		txtNewLength = new JTextField();
		GridBagConstraints gbc_txtNewLength = new GridBagConstraints();
		gbc_txtNewLength.insets = new Insets(0, 0, 5, 0);
		gbc_txtNewLength.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNewLength.gridx = 1;
		gbc_txtNewLength.gridy = 3;
		pnlUpdateSquare.add(txtNewLength, gbc_txtNewLength);
		txtNewLength.setColumns(10);
		
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
		pnlUpdateSquare.add(btnBorderColor, gbc_btnBorderColor);
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
		pnlUpdateSquare.add(btnAreaColor, gbc_btnAreaColor);
		
		
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
					side=Integer.parseInt(txtNewLength.getText());
					
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
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.gridx = 11;
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

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
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

	public JTextField getTxtNewLength() {
		return txtNewLength;
	}

	public void setTxtNewLength(JTextField txtNewLength) {
		this.txtNewLength = txtNewLength;
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
