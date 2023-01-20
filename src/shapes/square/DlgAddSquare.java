package shapes.square;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;


import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgAddSquare extends JDialog{
	
	private JTextField lengthSide;
	private int side;
	
	public static void main(String[] args) {
		try {
			DlgAddSquare dialog = new DlgAddSquare();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public DlgAddSquare() {
		setTitle("Add square");
		setBounds(100, 100, 450, 300);
		setModal(true);
		
		JPanel pnlAddSquare = new JPanel();
		getContentPane().add(pnlAddSquare, BorderLayout.CENTER);
		GridBagLayout gbl_pnlAddSquare = new GridBagLayout();
		gbl_pnlAddSquare.columnWidths = new int[]{0, 0, 0, 0};
		gbl_pnlAddSquare.rowHeights = new int[]{0, 0, 0, 0};
		gbl_pnlAddSquare.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlAddSquare.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlAddSquare.setLayout(gbl_pnlAddSquare);
		
		JLabel lblAddSideLength = new JLabel("Add side length:");
		GridBagConstraints gbc_lblAddSideLength = new GridBagConstraints();
		gbc_lblAddSideLength.insets = new Insets(0, 0, 0, 5);
		gbc_lblAddSideLength.anchor = GridBagConstraints.EAST;
		gbc_lblAddSideLength.gridx = 1;
		gbc_lblAddSideLength.gridy = 2;
		pnlAddSquare.add(lblAddSideLength, gbc_lblAddSideLength);
		
		lengthSide = new JTextField();
		GridBagConstraints gbc_lengthSide = new GridBagConstraints();
		gbc_lengthSide.anchor = GridBagConstraints.WEST;
		gbc_lengthSide.gridx = 2;
		gbc_lengthSide.gridy = 2;
		pnlAddSquare.add(lengthSide, gbc_lengthSide);
		lengthSide.setColumns(10);
		
		JPanel pnlButton = new JPanel();
		getContentPane().add(pnlButton, BorderLayout.SOUTH);
		GridBagLayout gbl_pnlButton = new GridBagLayout();
		gbl_pnlButton.columnWidths = new int[]{191, 0, 51, 0, 0};
		gbl_pnlButton.rowHeights = new int[]{23, 0};
		gbl_pnlButton.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlButton.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlButton.setLayout(gbl_pnlButton);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					side=Integer.parseInt(lengthSide.getText().toString());
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
		
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdd.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAdd.gridx = 2;
		gbc_btnAdd.gridy = 0;
		pnlButton.add(btnAdd, gbc_btnAdd);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lengthSide.setText("");
				setVisible(false);
			}
		});
		btnCancel.setActionCommand("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.gridx = 3;
		gbc_btnCancel.gridy = 0;
		pnlButton.add(btnCancel, gbc_btnCancel);
	}

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}

}
