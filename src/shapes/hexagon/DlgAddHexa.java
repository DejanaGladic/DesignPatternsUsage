package shapes.hexagon;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DlgAddHexa extends JDialog{
	private JTextField txtRadius;
	private int radius;
	
	public static void main(String[] args) {
		try {
			DlgAddHexa dialog = new DlgAddHexa();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public DlgAddHexa() {
		setTitle("Add hexagon");
		setBounds(100, 100, 450, 300);
		setModal(true);
		
		JPanel pnlAddHexa = new JPanel();
		getContentPane().add(pnlAddHexa, BorderLayout.CENTER);
		GridBagLayout gbl_pnlAddHexa = new GridBagLayout();
		gbl_pnlAddHexa.columnWidths = new int[]{0, 0, 0};
		gbl_pnlAddHexa.rowHeights = new int[]{0, 0, 0};
		gbl_pnlAddHexa.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlAddHexa.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pnlAddHexa.setLayout(gbl_pnlAddHexa);
		
		JLabel lblAddRadius = new JLabel("Add radius:");
		GridBagConstraints gbc_lblAddRadius = new GridBagConstraints();
		gbc_lblAddRadius.insets = new Insets(0, 0, 0, 5);
		gbc_lblAddRadius.anchor = GridBagConstraints.EAST;
		gbc_lblAddRadius.gridx = 0;
		gbc_lblAddRadius.gridy = 1;
		pnlAddHexa.add(lblAddRadius, gbc_lblAddRadius);
		
		txtRadius = new JTextField();
		GridBagConstraints gbc_txtRadius = new GridBagConstraints();
		gbc_txtRadius.anchor = GridBagConstraints.NORTH;
		gbc_txtRadius.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRadius.gridx = 1;
		gbc_txtRadius.gridy = 1;
		pnlAddHexa.add(txtRadius, gbc_txtRadius);
		txtRadius.setColumns(10);
		
		JPanel plnButton = new JPanel();
		getContentPane().add(plnButton, BorderLayout.SOUTH);
		GridBagLayout gbl_plnButton = new GridBagLayout();
		gbl_plnButton.columnWidths = new int[]{156, 51, 65, 0};
		gbl_plnButton.rowHeights = new int[]{23, 0};
		gbl_plnButton.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_plnButton.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		plnButton.setLayout(gbl_plnButton);
		
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
		
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAdd.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdd.gridx = 1;
		gbc_btnAdd.gridy = 0;
		plnButton.add(btnAdd, gbc_btnAdd);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtRadius.setText("");
				setVisible(false);
			}
		});
		btnCancel.setActionCommand("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCancel.gridx = 2;
		gbc_btnCancel.gridy = 0;
		plnButton.add(btnCancel, gbc_btnCancel);
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

}
