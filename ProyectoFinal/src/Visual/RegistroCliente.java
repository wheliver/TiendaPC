package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;

public class RegistroCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton RegistrarButton;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistroCliente dialog = new RegistroCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistroCliente() {
		setTitle("Registro Cliente-Factura");
		setBounds(100, 100, 588, 445);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 552, 351);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			textField = new JTextField();
			textField.setBounds(162, 11, 217, 20);
			panel.add(textField);
			textField.setColumns(10);
			
			JButton btnNewButton = new JButton("Buscar cliente");
			btnNewButton.setBounds(217, 42, 130, 23);
			panel.add(btnNewButton);
			
			textField_1 = new JTextField();
			textField_1.setEnabled(false);
			textField_1.setColumns(10);
			textField_1.setBounds(10, 149, 217, 20);
			panel.add(textField_1);
			
			textField_2 = new JTextField();
			textField_2.setEnabled(false);
			textField_2.setColumns(10);
			textField_2.setBounds(10, 224, 217, 20);
			panel.add(textField_2);
			
			textField_3 = new JTextField();
			textField_3.setEnabled(false);
			textField_3.setColumns(10);
			textField_3.setBounds(10, 296, 217, 20);
			panel.add(textField_3);
			
			textField_4 = new JTextField();
			textField_4.setEnabled(false);
			textField_4.setColumns(10);
			textField_4.setBounds(325, 149, 217, 20);
			panel.add(textField_4);
			
			textField_5 = new JTextField();
			textField_5.setEnabled(false);
			textField_5.setColumns(10);
			textField_5.setBounds(325, 224, 217, 20);
			panel.add(textField_5);
			
			JLabel lblNewLabel = new JLabel("Nombre");
			lblNewLabel.setBounds(86, 124, 46, 14);
			panel.add(lblNewLabel);
			
			JLabel lblDireccion = new JLabel("Direccion");
			lblDireccion.setBounds(86, 199, 58, 14);
			panel.add(lblDireccion);
			
			JLabel lblRnc = new JLabel("RNC");
			lblRnc.setBounds(86, 271, 46, 14);
			panel.add(lblRnc);
			
			JLabel lblTelefono = new JLabel("Telefono");
			lblTelefono.setBounds(413, 124, 58, 14);
			panel.add(lblTelefono);
			
			JLabel lblCedula = new JLabel("Cedula");
			lblCedula.setBounds(413, 199, 46, 14);
			panel.add(lblCedula);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				RegistrarButton = new JButton("Registrar");
				RegistrarButton.setActionCommand("OK");
				buttonPane.add(RegistrarButton);
				getRootPane().setDefaultButton(RegistrarButton);
			}
			{
				JButton SalirButton = new JButton("Salir");
				SalirButton.setActionCommand("Cancel");
				buttonPane.add(SalirButton);
			}
		}
	}
}
