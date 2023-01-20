package shapes.rectangle;

import javax.swing.JDialog;
import javax.swing.JPanel;

import shapes.square.DlgAddSquare;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgAddRect extends JDialog{
	private JTextField txtSide;
	private JTextField txtWidth;
	
	private int side;
	private int widthRect;
	
	public static void main(String[] args) {
		try {
			DlgAddSquare dialog = new DlgAddSquare();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public DlgAddRect() {
		setTitle("Add rectangle");
		setBounds(100, 100, 450, 300);
		setModal(true);
		
		JPanel pnlAddRect = new JPanel();
		getContentPane().add(pnlAddRect, BorderLayout.CENTER);
		GridBagLayout gbl_pnlAddRect = new GridBagLayout();
		gbl_pnlAddRect.columnWidths = new int[]{0, 0, 0};
		gbl_pnlAddRect.rowHeights = new int[]{0, 0, 0, 0};
		gbl_pnlAddRect.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlAddRect.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlAddRect.setLayout(gbl_pnlAddRect);
		
		JLabel lblAddLengthSide = new JLabel("Add length side:");
		GridBagConstraints gbc_lblAddLengthSide = new GridBagConstraints();
		gbc_lblAddLengthSide.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddLengthSide.anchor = GridBagConstraints.EAST;
		gbc_lblAddLengthSide.gridx = 0;
		gbc_lblAddLengthSide.gridy = 1;
		pnlAddRect.add(lblAddLengthSide, gbc_lblAddLengthSide);
		
		txtSide = new JTextField();
		GridBagConstraints gbc_txtSide = new GridBagConstraints();
		gbc_txtSide.insets = new Insets(0, 0, 5, 0);
		gbc_txtSide.anchor = GridBagConstraints.NORTH;
		gbc_txtSide.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSide.gridx = 1;
		gbc_txtSide.gridy = 1;
		pnlAddRect.add(txtSide, gbc_txtSide);
		txtSide.setColumns(10);
		
		JLabel lblAddWidth = new JLabel("Add width:");
		GridBagConstraints gbc_lblAddWidth = new GridBagConstraints();
		gbc_lblAddWidth.anchor = GridBagConstraints.EAST;
		gbc_lblAddWidth.insets = new Insets(0, 0, 0, 5);
		gbc_lblAddWidth.gridx = 0;
		gbc_lblAddWidth.gridy = 2;
		pnlAddRect.add(lblAddWidth, gbc_lblAddWidth);
		
		txtWidth = new JTextField();
		GridBagConstraints gbc_txtWidth = new GridBagConstraints();
		gbc_txtWidth.anchor = GridBagConstraints.NORTH;
		gbc_txtWidth.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtWidth.gridx = 1;
		gbc_txtWidth.gridy = 2;
		pnlAddRect.add(txtWidth, gbc_txtWidth);
		txtWidth.setColumns(10);
		
		JPanel pnlButtons = new JPanel();
		getContentPane().add(pnlButtons, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					side=Integer.parseInt(txtSide.getText().toString());
					widthRect=Integer.parseInt(txtWidth.getText().toString());
					setVisible(false);
				}
				
				catch(NumberFormatException e){
						
					JOptionPane.showMessageDialog(rootPane, "Check inserted value!");	
					e.printStackTrace();
						
				}
			}
		});
		btnAdd.setActionCommand("OK");
		getRootPane().setDefaultButton(btnAdd);
		pnlButtons.add(btnAdd);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtSide.setText("");
				txtWidth.setText("");
				setVisible(false);
			}
		});
		btnCancel.setActionCommand("Cancel");
		pnlButtons.add(btnCancel);
	}
	public int getSide() {
		return side;
	}
	public void setSide(int side) {
		this.side = side;
	}
	public int getWidthRect() {
		return widthRect;
	}
	public void setWidthRect(int widthRect) {
		this.widthRect = widthRect;
	}
	

}
