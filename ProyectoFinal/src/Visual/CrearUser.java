package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;

import logico.Tienda;
import logico.Usuario;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearUser extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNombre;
	private JTextField textFieldDireccion;
	private JTextField textFieldTelefono;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;
	private JButton btnRegistrar;
	private JButton btnSalir;
	private JComboBox cbxTipoCuent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Tienda.getInstance().cargarTienda();
			CrearUser dialog = new CrearUser();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearUser() {
		
		setBounds(100, 100, 467, 375);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 434, 268);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(68, 22, 46, 20);
		panel.add(lblNewLabel);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(22, 55, 159, 20);
		panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Direccion");
		lblNewLabel_1.setBounds(68, 113, 76, 14);
		panel.add(lblNewLabel_1);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setBounds(22, 138, 159, 20);
		panel.add(textFieldDireccion);
		textFieldDireccion.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Telefono");
		lblNewLabel_2.setBounds(256, 25, 59, 14);
		panel.add(lblNewLabel_2);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setBounds(229, 55, 141, 20);
		panel.add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Username");
		lblNewLabel_3.setBounds(254, 113, 82, 14);
		panel.add(lblNewLabel_3);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(229, 138, 141, 20);
		panel.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setBounds(68, 187, 76, 14);
		panel.add(lblNewLabel_4);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(22, 212, 159, 20);
		panel.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Tipo Cuenta");
		lblNewLabel_5.setBounds(249, 187, 87, 14);
		panel.add(lblNewLabel_5);
		
		cbxTipoCuent = new JComboBox();
		cbxTipoCuent.setModel(new DefaultComboBoxModel(new String[] {"       <<Seleccione>>", "Administrador", "Usuario"}));
		cbxTipoCuent.setBounds(229, 212, 141, 20);
		panel.add(cbxTipoCuent);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String b = textFieldNombre.getText();
						String c = textFieldDireccion.getText();
						String d = textFieldTelefono.getText();
						String h = textFieldUsername.getText();
						String p = textFieldPassword.getText();
						String v = cbxTipoCuent.getSelectedItem().toString();
						
						Usuario a = new Usuario(b,c,d,v,h,p);
						Tienda.getInstance().insertarUsuario(a);
						Tienda.getInstance().guardarTienda();
						JOptionPane.showMessageDialog(null,"Registro Satisfactorio","Informacion",JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				btnSalir = new JButton("Salir");
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnSalir.setActionCommand("Cancel");
				buttonPane.add(btnSalir);
			}
		}
	}
}
