package shapes.rectangle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import shapes.square.DlgUpdateSquare;

public class DlgUpdateRectangle extends JDialog{
	private JTextField txtNewX;
	private JTextField txtNewY;
	private JTextField txtNewLength;
	private JTextField txtNewWidth;
	
	private int x;
	private int y;
	private int side;
	private int widthS;
	
	private Color borderColor;
	private Color areaColor;
	
	private JButton btnAreaColor;
	private JButton btnBorderColor;
	
	private boolean updateCancel=true;
	
	
	public static void main(String[] args) {
		try {
			DlgUpdateRectangle dialog= new DlgUpdateRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public DlgUpdateRectangle() {
		setTitle("Update rectangle");
		setModal(true);
		setBounds(100, 100, 450, 300);
		
		JPanel pnlUpdateRect = new JPanel();
		getContentPane().add(pnlUpdateRect, BorderLayout.CENTER);
		GridBagLayout gbl_pnlUpdateRect = new GridBagLayout();
		gbl_pnlUpdateRect.columnWidths = new int[]{0, 0, 0};
		gbl_pnlUpdateRect.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_pnlUpdateRect.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlUpdateRect.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlUpdateRect.setLayout(gbl_pnlUpdateRect);
		
		JLabel lblNewXOf = new JLabel("New X of up left");
		GridBagConstraints gbc_lblNewXOf = new GridBagConstraints();
		gbc_lblNewXOf.anchor = GridBagConstraints.EAST;
		gbc_lblNewXOf.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewXOf.gridx = 0;
		gbc_lblNewXOf.gridy = 1;
		pnlUpdateRect.add(lblNewXOf, gbc_lblNewXOf);
		
		txtNewX = new JTextField();
		GridBagConstraints gbc_txtNewX = new GridBagConstraints();
		gbc_txtNewX.insets = new Insets(0, 0, 5, 0);
		gbc_txtNewX.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNewX.gridx = 1;
		gbc_txtNewX.gridy = 1;
		pnlUpdateRect.add(txtNewX, gbc_txtNewX);
		txtNewX.setColumns(10);
		
		JLabel lblNewYOf = new JLabel("New Y of up left");
		GridBagConstraints gbc_lblNewYOf = new GridBagConstraints();
		gbc_lblNewYOf.anchor = GridBagConstraints.EAST;
		gbc_lblNewYOf.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewYOf.gridx = 0;
		gbc_lblNewYOf.gridy = 2;
		pnlUpdateRect.add(lblNewYOf, gbc_lblNewYOf);
		
		txtNewY = new JTextField();
		GridBagConstraints gbc_txtNewY = new GridBagConstraints();
		gbc_txtNewY.insets = new Insets(0, 0, 5, 0);
		gbc_txtNewY.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNewY.gridx = 1;
		gbc_txtNewY.gridy = 2;
		pnlUpdateRect.add(txtNewY, gbc_txtNewY);
		txtNewY.setColumns(10);
		
		JLabel lblNewLenght = new JLabel("New lenght");
		GridBagConstraints gbc_lblNewLenght = new GridBagConstraints();
		gbc_lblNewLenght.anchor = GridBagConstraints.EAST;
		gbc_lblNewLenght.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLenght.gridx = 0;
		gbc_lblNewLenght.gridy = 3;
		pnlUpdateRect.add(lblNewLenght, gbc_lblNewLenght);
		
		txtNewLength = new JTextField();
		GridBagConstraints gbc_txtNewLength = new GridBagConstraints();
		gbc_txtNewLength.insets = new Insets(0, 0, 5, 0);
		gbc_txtNewLength.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNewLength.gridx = 1;
		gbc_txtNewLength.gridy = 3;
		pnlUpdateRect.add(txtNewLength, gbc_txtNewLength);
		txtNewLength.setColumns(10);
		
		JLabel lblNewWidth = new JLabel("New width");
		GridBagConstraints gbc_lblNewWidth = new GridBagConstraints();
		gbc_lblNewWidth.anchor = GridBagConstraints.EAST;
		gbc_lblNewWidth.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewWidth.gridx = 0;
		gbc_lblNewWidth.gridy = 4;
		pnlUpdateRect.add(lblNewWidth, gbc_lblNewWidth);
		
		txtNewWidth = new JTextField();
		GridBagConstraints gbc_txtNewWidth = new GridBagConstraints();
		gbc_txtNewWidth.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNewWidth.gridx = 1;
		gbc_txtNewWidth.gridy = 4;
		pnlUpdateRect.add(txtNewWidth, gbc_txtNewWidth);
		txtNewWidth.setColumns(10);
		
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
		gbc_btnBorderColor.insets = new Insets(0, 0, 0, 5);
		gbc_btnBorderColor.gridx = 0;
		gbc_btnBorderColor.gridy = 5;
		pnlUpdateRect.add(btnBorderColor, gbc_btnBorderColor);
		
		btnAreaColor = new JButton("Area color");
		btnBorderColor.setBackground(Color.BLACK);
		btnBorderColor.setForeground(Color.WHITE);
		btnAreaColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAreaColor.setBackground(JColorChooser.showDialog(null,"Choose the color", btnAreaColor.getBackground()));
			}
		});
		GridBagConstraints gbc_btnAreaColor = new GridBagConstraints();
		gbc_btnAreaColor.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAreaColor.gridx = 1;
		gbc_btnAreaColor.gridy = 5;
		pnlUpdateRect.add(btnAreaColor, gbc_btnAreaColor);
		
		
		JPanel pnlBtn = new JPanel();
		getContentPane().add(pnlBtn, BorderLayout.SOUTH);
		GridBagLayout gbl_pnlBtn = new GridBagLayout();
		gbl_pnlBtn.columnWidths = new int[]{184, 65, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlBtn.rowHeights = new int[]{23, 0};
		gbl_pnlBtn.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlBtn.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlBtn.setLayout(gbl_pnlBtn);
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					x=Integer.parseInt(txtNewX.getText());
					y=Integer.parseInt(txtNewY.getText());
					side=Integer.parseInt(txtNewLength.getText());
					widthS=Integer.parseInt(txtNewWidth.getText());
					
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
		gbc_btnAccept.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAccept.gridx = 5;
		gbc_btnAccept.gridy = 0;
		pnlBtn.add(btnAccept, gbc_btnAccept);
		btnAccept.setActionCommand("OK");
		getRootPane().setDefaultButton(btnAccept);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateCancel=true;
				dispose();
			}
		});
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.gridx = 6;
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

	public int getWidthS() {
		return widthS;
	}

	public void setWidthS(int widthS) {
		this.widthS = widthS;
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

	public JTextField getTxtNewWidth() {
		return txtNewWidth;
	}

	public void setTxtNewWidth(JTextField txtNewWidth) {
		this.txtNewWidth = txtNewWidth;
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
