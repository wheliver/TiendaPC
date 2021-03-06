package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import logico.Cliente;
import logico.Combos;
import logico.Componente;
import logico.Factura;
import logico.OrdenCompra;
import logico.Tienda;
import logico.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

public class ModificarCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton RegistrarButton;
	private JTextField textField_Nombre;
	private JTextField textField_direccion;
	private JTextField textField_RNC;
	private JTextField textField_Telefono;
	private JTextField textField_Cedula;
	private Cliente cli = null;
	private JTextField textFieldBuscar;
	private JButton SalirButton;
	private ArrayList<auxiliarCarrito> carrito1 = new ArrayList<auxiliarCarrito>();
	private ArrayList<auxiliarCarito2> carrito2 = new ArrayList<auxiliarCarito2>();
	private int codigodefactura = 1;
	private int codigodeordendecompra = 1;
	private  Usuario user=null;

	/**
	 * Launch the application.
	 *//**
	public static void main(String[] args) {
		try {
			Tienda.getInstance().cargarTienda();
			System.out.println(Tienda.getInstance().getMisclientes().size());
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
	public ModificarCliente() {
		setTitle("Modificar Cliente");
		setBounds(100, 100, 609, 377);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 95, 572, 224);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			textField_Nombre = new JTextField();
			textField_Nombre.setColumns(10);
			textField_Nombre.setBounds(10, 46, 217, 20);
			panel.add(textField_Nombre);
			
			textField_direccion = new JTextField();
			textField_direccion.setColumns(10);
			textField_direccion.setBounds(10, 107, 217, 20);
			panel.add(textField_direccion);
			
			textField_RNC = new JTextField();
			textField_RNC.setColumns(10);
			textField_RNC.setBounds(10, 163, 217, 20);
			panel.add(textField_RNC);
			
			textField_Telefono = new JTextField();
			textField_Telefono.setColumns(10);
			textField_Telefono.setBounds(325, 46, 217, 20);
			panel.add(textField_Telefono);
			
			textField_Cedula = new JTextField();
			textField_Cedula.setColumns(10);
			textField_Cedula.setBounds(325, 107, 217, 20);
			panel.add(textField_Cedula);
			
			JLabel lblNewLabel = new JLabel("Nombre");
			lblNewLabel.setBounds(86, 21, 46, 14);
			panel.add(lblNewLabel);
			
			JLabel lblDireccion = new JLabel("Direccion");
			lblDireccion.setBounds(86, 82, 58, 14);
			panel.add(lblDireccion);
			
			JLabel lblRnc = new JLabel("RNC");
			lblRnc.setBounds(86, 138, 46, 14);
			panel.add(lblRnc);
			
			JLabel lblTelefono = new JLabel("Telefono");
			lblTelefono.setBounds(415, 21, 58, 14);
			panel.add(lblTelefono);
			
			JLabel lblCedula = new JLabel("Cedula");
			lblCedula.setBounds(415, 82, 46, 14);
			panel.add(lblCedula);
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Agregar cedula", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 573, 73);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		textFieldBuscar = new JTextField();
		textFieldBuscar.setColumns(10);
		textFieldBuscar.setBounds(166, 11, 217, 20);
		panel.add(textFieldBuscar);
		
		JButton button = new JButton("Buscar cliente");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cli = Tienda.getInstance().buscarCliente(textFieldBuscar.getText().toString());
				if (cli == null) {
		    		 JOptionPane.showMessageDialog(null, "Cedula incorrecta");
		    	}else{
		    		textField_Nombre.setText(cli.getNombre());
		    		textField_direccion.setText(cli.getDireccion());
		    		textField_RNC.setText(cli.getRnc());
		    		textField_Telefono.setText(cli.getTelefono());
		    		textField_Cedula.setText(cli.getCedula());
					JOptionPane.showMessageDialog(null,"Puede modificar cliente");
			}
			}
		});
		button.setBounds(220, 42, 130, 23);
		panel.add(button);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				RegistrarButton = new JButton("Modificar");
				RegistrarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cli.setCedula(textField_Cedula.getText());
						cli.setDireccion(textField_direccion.getText());
						cli.setRnc(textField_RNC.getText());
						cli.setTelefono(textField_Telefono.getText());
						cli.setNombre(textField_Nombre.getText());
						 JOptionPane.showMessageDialog(null,"Modificacion Correcta","Informacion",JOptionPane.INFORMATION_MESSAGE);
						 clean();
						 dispose();						 
		                 //clean();
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
	private void clean() {
		textField_Nombre.setText("");
		textField_direccion.setText("");
		textField_RNC.setText("");
		textField_Telefono.setText("");
		textField_Cedula.setText("");
		
	}

	public void setCarrito1(ArrayList<auxiliarCarrito> carrito1) {
		this.carrito1 = carrito1;
	}

	public void setCarrito2(ArrayList<auxiliarCarito2> carrito2) {
		this.carrito2 = carrito2;
	}

	public void setusuario(Usuario user2) {
		// TODO Auto-generated method stub
		user=user2;
	}
}
