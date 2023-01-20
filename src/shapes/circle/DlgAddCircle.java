package shapes.circle;

import javax.swing.JDialog;
import javax.swing.JPanel;

import shapes.square.DlgAddSquare;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgAddCircle extends JDialog{
	private JTextField txtRadius;
	private int radius;
	
	public static void main(String[] args) {
		try {
			DlgAddCircle dialog = new DlgAddCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public DlgAddCircle() {
		setTitle("Add circle");
		setBounds(100, 100, 450, 300);
		setModal(true);
		
		JPanel pnlAddCircle = new JPanel();
		getContentPane().add(pnlAddCircle, BorderLayout.CENTER);
		GridBagLayout gbl_pnlAddCircle = new GridBagLayout();
		gbl_pnlAddCircle.columnWidths = new int[]{0, 0, 0, 0};
		gbl_pnlAddCircle.rowHeights = new int[]{0, 0, 0};
		gbl_pnlAddCircle.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlAddCircle.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pnlAddCircle.setLayout(gbl_pnlAddCircle);
		
		JLabel lblRadius = new JLabel("Radius:");
		GridBagConstraints gbc_lblRadius = new GridBagConstraints();
		gbc_lblRadius.insets = new Insets(0, 0, 0, 5);
		gbc_lblRadius.anchor = GridBagConstraints.EAST;
		gbc_lblRadius.gridx = 1;
		gbc_lblRadius.gridy = 1;
		pnlAddCircle.add(lblRadius, gbc_lblRadius);
		
		txtRadius = new JTextField();
		GridBagConstraints gbc_txtRadius = new GridBagConstraints();
		gbc_txtRadius.anchor = GridBagConstraints.NORTH;
		gbc_txtRadius.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRadius.gridx = 2;
		gbc_txtRadius.gridy = 1;
		pnlAddCircle.add(txtRadius, gbc_txtRadius);
		txtRadius.setColumns(10);
		
		JPanel pnlButton = new JPanel();
		getContentPane().add(pnlButton, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
						
					radius=Integer.parseInt(txtRadius.getText().toString());
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
		pnlButton.add(btnAdd);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtRadius.setText("");
				setVisible(false);
			}
		});
		btnCancel.setActionCommand("Cancel");
		pnlButton.add(btnCancel);
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

}
