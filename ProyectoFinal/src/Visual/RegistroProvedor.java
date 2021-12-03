package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Cliente;
import logico.Proveedor;
import logico.Tienda;
import javax.swing.UIManager;
import java.awt.Color;

public class RegistroProvedor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton RegistrarButton;
	private JTextField textField_Nombre;
	private JTextField textField_direccion;
	private JTextField textField_RNC;
	private JTextField textField_Telefono;
	private Proveedor cli = null;
	private JTextField textField_buscarprovedor;
	private JButton SalirButton;
	private JButton btnBuscarProveedor;
	private JLabel componentel;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistroProvedor dialog = new RegistroProvedor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistroProvedor() {
		setTitle("Registro Proveedor");
		setBounds(100, 100, 610, 420);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 95, 572, 237);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			textField_Nombre = new JTextField();
			textField_Nombre.setEnabled(false);
			textField_Nombre.setColumns(10);
			textField_Nombre.setBounds(10, 46, 217, 20);
			panel.add(textField_Nombre);
			
			textField_direccion = new JTextField();
			textField_direccion.setEnabled(false);
			textField_direccion.setColumns(10);
			textField_direccion.setBounds(10, 107, 217, 20);
			panel.add(textField_direccion);
			
			textField_RNC = new JTextField();
			textField_RNC.setEnabled(false);
			textField_RNC.setColumns(10);
			textField_RNC.setBounds(325, 107, 217, 20);
			panel.add(textField_RNC);
			
			textField_Telefono = new JTextField();
			textField_Telefono.setEnabled(false);
			textField_Telefono.setColumns(10);
			textField_Telefono.setBounds(325, 46, 217, 20);
			panel.add(textField_Telefono);
			
			JLabel lblNewLabel = new JLabel("Nombre");
			lblNewLabel.setBounds(86, 21, 46, 14);
			panel.add(lblNewLabel);
			
			JLabel lblDireccion = new JLabel("Direccion");
			lblDireccion.setBounds(86, 82, 58, 14);
			panel.add(lblDireccion);
			
			JLabel lblRnc = new JLabel("RNC");
			lblRnc.setBounds(415, 93, 46, 14);
			panel.add(lblRnc);
			
			JLabel lblTelefono = new JLabel("Telefono");
			lblTelefono.setBounds(415, 21, 58, 14);
			panel.add(lblTelefono);
			
			JLabel lblNewLabel_1 = new JLabel("Componente");
			lblNewLabel_1.setBounds(86, 163, 85, 14);
			panel.add(lblNewLabel_1);
			
			componentel = new JLabel("");
			componentel.setBounds(10, 180, 46, 14);
			panel.add(componentel);
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Agregar RNC", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 573, 73);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		textField_buscarprovedor = new JTextField();
		textField_buscarprovedor.setColumns(10);
		textField_buscarprovedor.setBounds(166, 11, 217, 20);
		panel.add(textField_buscarprovedor);
		
		btnBuscarProveedor = new JButton("Buscar Proveedor");
		btnBuscarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cli = Tienda.getInstance().buscarProveedor(textField_buscarprovedor.getText());
				if (cli == null) {
					textField_Nombre.setEnabled(true);
					textField_direccion.setEnabled(true);
					textField_RNC.setEnabled(true);
					textField_Telefono.setEnabled(true);
		    		 JOptionPane.showMessageDialog(null, "ES UN PROVEEDOR NUEVO POR FAVOR LLENE LOS CAMPOS Y PROCEDA A COMPRAR");
		    	}
				if(cli != null){
		    		textField_Nombre.setText(cli.getNombre());
		    		textField_direccion.setText(cli.getDireccion());
		    		textField_RNC.setText(cli.getRnc());
		    		textField_Telefono.setText(cli.getTelefono());
		    		 JOptionPane.showMessageDialog(null,"GRACIAS POR VOLVER");
		    		
		    		 textField_Nombre.setEnabled(false);
						textField_direccion.setEnabled(false);
						textField_RNC.setEnabled(false);
						textField_Telefono.setEnabled(false);
			}
			}
		});
		btnBuscarProveedor.setBounds(207, 42, 150, 23);
		panel.add(btnBuscarProveedor);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				RegistrarButton = new JButton("Registrar");
				RegistrarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Proveedor a = new Proveedor(textField_Nombre.getText(),textField_RNC.getText(),textField_Telefono.getText(),textField_direccion.getText());
						Tienda.getInstance().insertarProveedor(a);
						 JOptionPane.showMessageDialog(null,"Registro Satisfactorio","Informacion",JOptionPane.INFORMATION_MESSAGE);
		                 clean();
		                 textField_Nombre.setEnabled(false);
							textField_direccion.setEnabled(false);
							textField_RNC.setEnabled(false);
							textField_Telefono.setEnabled(false);
					}

					private void clean() {
						textField_Nombre.setText("");
			    		textField_direccion.setText("");
			    		textField_RNC.setText("");
			    		textField_Telefono.setText("");
					}
				});
				RegistrarButton.setActionCommand("OK");
				buttonPane.add(RegistrarButton);
				getRootPane().setDefaultButton(RegistrarButton);
			}
			{
				SalirButton = new JButton("Salir");
				SalirButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				SalirButton.setActionCommand("Cancel");
				buttonPane.add(SalirButton);
			}
		}
	}
	public void nombredecomponete(String nombree) {
		componentel.setText(nombree);
	}
}
