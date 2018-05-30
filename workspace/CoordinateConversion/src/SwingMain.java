import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SwingMain {

	private JFrame frmCoordinateConverter;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingMain window = new SwingMain();
					window.frmCoordinateConverter.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SwingMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCoordinateConverter = new JFrame();
		frmCoordinateConverter.setResizable(false);
		frmCoordinateConverter.setForeground(SystemColor.menu);
		frmCoordinateConverter.setTitle("Coordinate Converter");
		frmCoordinateConverter.setBounds(100, 100, 581, 167);
		frmCoordinateConverter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCoordinateConverter.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel_container = new JPanel();
		panel_container.setBackground(SystemColor.menu);
		frmCoordinateConverter.getContentPane().add(panel_container);
		panel_container.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panel_entry = new JPanel();
		panel_container.add(panel_entry);

		JLabel lblEnterCoordinates = new JLabel("Enter coordinates:");
		panel_entry.add(lblEnterCoordinates);

		textField_1 = new JTextField();
		panel_entry.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		panel_entry.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		panel_entry.add(textField_3);
		textField_3.setColumns(10);

		JPanel panel_from = new JPanel();
		panel_container.add(panel_from);

		JLabel lblFrom = new JLabel("From:");
		panel_from.add(lblFrom);

		JRadioButton rdbtnFromRect = new JRadioButton("Rectangular");
		panel_from.add(rdbtnFromRect);
		buttonGroup.add(rdbtnFromRect);

		JRadioButton rdbtnFromCyl = new JRadioButton("Cylindrical");
		panel_from.add(rdbtnFromCyl);
		buttonGroup.add(rdbtnFromCyl);

		JRadioButton rdbtnFromSph = new JRadioButton("Spherical");
		panel_from.add(rdbtnFromSph);
		buttonGroup.add(rdbtnFromSph);

		JPanel panel_to = new JPanel();
		panel_container.add(panel_to);

		JLabel lblTo = new JLabel("To:");
		panel_to.add(lblTo);

		JRadioButton rdbtnToRect = new JRadioButton("Rectangular");
		buttonGroup_1.add(rdbtnToRect);
		panel_to.add(rdbtnToRect);

		JRadioButton rdbtnToCyl = new JRadioButton("Cylindrical");
		buttonGroup_1.add(rdbtnToCyl);
		panel_to.add(rdbtnToCyl);

		JRadioButton rdbtnToSph = new JRadioButton("Spherical");
		buttonGroup_1.add(rdbtnToSph);
		panel_to.add(rdbtnToSph);

		JButton btnNewButton = new JButton("Convert!");
		panel_entry.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isDouble(textField_1.getText()) && isDouble(textField_1.getText())
						&& isDouble(textField_1.getText())) {

					double a = (Double.parseDouble(textField_1.getText()));
					double b = (Double.parseDouble(textField_2.getText()));
					double c = (Double.parseDouble(textField_3.getText()));

					if (rdbtnFromRect.isSelected() && rdbtnToCyl.isSelected()) {
						Cylindrical coord = new Rectangular(a, b, c).toCylindrical();

						textField_1.setText(Double.toString(coord.r));
						textField_2.setText(Double.toString(coord.theta));
						textField_3.setText(Double.toString(coord.z));
					} 
					else if (rdbtnFromRect.isSelected() && rdbtnToSph.isSelected()) {
						Spherical coord = new Rectangular(a, b, c).toSpherical();

						textField_1.setText(Double.toString(coord.rho));
						textField_2.setText(Double.toString(coord.theta));
						textField_3.setText(Double.toString(coord.phi));
					}
					else if (rdbtnFromCyl.isSelected() && rdbtnToRect.isSelected()) {
						Rectangular coord = new Cylindrical(a, b, c).toRectangular();

						textField_1.setText(Double.toString(coord.x));
						textField_2.setText(Double.toString(coord.y));
						textField_3.setText(Double.toString(coord.z));
					}
					else if (rdbtnFromCyl.isSelected() && rdbtnToSph.isSelected()) {
						Spherical coord = new Cylindrical(a, b, c).toSpherical();

						textField_1.setText(Double.toString(coord.rho));
						textField_2.setText(Double.toString(coord.theta));
						textField_3.setText(Double.toString(coord.phi));
					}
					else if (rdbtnFromSph.isSelected() && rdbtnToRect.isSelected()) {
						Rectangular coord = new Spherical(a, b, c).toRectangular();

						textField_1.setText(Double.toString(coord.x));
						textField_2.setText(Double.toString(coord.y));
						textField_3.setText(Double.toString(coord.z));
					}
					else if (rdbtnFromSph.isSelected() && rdbtnToCyl.isSelected()) {
						Cylindrical coord = new Spherical(a, b, c).toCylindrical();

						textField_1.setText(Double.toString(coord.r));
						textField_2.setText(Double.toString(coord.theta));
						textField_3.setText(Double.toString(coord.z));
					}
				} else {
					JOptionPane.showMessageDialog(frmCoordinateConverter, "Please enter numerical values only.");
				}
			}

		});

		JButton btnHelp = new JButton("Help");
		panel_container.add(btnHelp);
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frmCoordinateConverter,
						"Rectangular: (x, y, z)\nCylindrical: (r, theta, z)\nSpherical: (rho, theta, phi)\n"
						+ "All angles measured in radians");
			}
		});
	}

	private boolean isDouble(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
