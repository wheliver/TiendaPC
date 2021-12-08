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
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class RegistroCliente extends JDialog {

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
	public RegistroCliente() {
		setTitle("Registro Cliente-Factura");
		setBounds(100, 100, 609, 406);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 95, 572, 224);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			textField_Nombre = new JTextField();
			textField_Nombre.setBackground(Color.WHITE);
			textField_Nombre.setBorder(null);
			textField_Nombre.setEnabled(false);
			textField_Nombre.setColumns(10);
			textField_Nombre.setBounds(10, 46, 217, 20);
			panel.add(textField_Nombre);
			
			textField_direccion = new JTextField();
			textField_direccion.setBorder(null);
			textField_direccion.setBackground(Color.WHITE);
			textField_direccion.setEnabled(false);
			textField_direccion.setColumns(10);
			textField_direccion.setBounds(10, 107, 217, 20);
			panel.add(textField_direccion);
			
			textField_RNC = new JTextField();
			textField_RNC.setBorder(null);
			textField_RNC.setBackground(Color.WHITE);
			textField_RNC.setEnabled(false);
			textField_RNC.setColumns(10);
			textField_RNC.setBounds(10, 175, 217, 20);
			panel.add(textField_RNC);
			
			textField_Telefono = new JTextField();
			textField_Telefono.setBorder(null);
			textField_Telefono.setBackground(Color.WHITE);
			textField_Telefono.setEnabled(false);
			textField_Telefono.setColumns(10);
			textField_Telefono.setBounds(325, 46, 217, 20);
			panel.add(textField_Telefono);
			
			textField_Cedula = new JTextField();
			textField_Cedula.setBackground(Color.WHITE);
			textField_Cedula.setBorder(null);
			textField_Cedula.setEnabled(false);
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
			lblRnc.setBounds(86, 150, 46, 14);
			panel.add(lblRnc);
			
			JLabel lblTelefono = new JLabel("Telefono");
			lblTelefono.setBounds(415, 21, 58, 14);
			panel.add(lblTelefono);
			
			JLabel lblCedula = new JLabel("Cedula");
			lblCedula.setBounds(415, 82, 46, 14);
			panel.add(lblCedula);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 69, 196, 2);
			panel.add(separator);
			
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(10, 138, 217, 1);
			panel.add(separator_1);
			
			JSeparator separator_2 = new JSeparator();
			separator_2.setBounds(325, 138, 217, 1);
			panel.add(separator_2);
			
			JSeparator separator_3 = new JSeparator();
			separator_3.setBounds(325, 77, 217, 1);
			panel.add(separator_3);
			
			JSeparator separator_4 = new JSeparator();
			separator_4.setBounds(10, 206, 217, 1);
			panel.add(separator_4);
			
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(RegistroCliente.class.getResource("/Images/usuario.png")));
			lblNewLabel_1.setBounds(30, 11, 46, 24);
			panel.add(lblNewLabel_1);
			
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(RegistroCliente.class.getResource("/Images/direccion-de-casa.png")));
			label.setBounds(30, 77, 24, 30);
			panel.add(label);
			
			JLabel label_1 = new JLabel("");
			label_1.setIcon(new ImageIcon(RegistroCliente.class.getResource("/Images/id-card.png")));
			label_1.setBounds(30, 150, 46, 26);
			panel.add(label_1);
			
			JLabel label_2 = new JLabel("");
			label_2.setIcon(new ImageIcon(RegistroCliente.class.getResource("/Images/telefono.png")));
			label_2.setBounds(375, 11, 30, 24);
			panel.add(label_2);
			
			JLabel label_3 = new JLabel("New label");
			label_3.setBounds(348, 82, 46, 14);
			panel.add(label_3);
		}
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
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
					textField_Nombre.setEnabled(true);
					textField_direccion.setEnabled(true);
					textField_RNC.setEnabled(true);
					textField_Telefono.setEnabled(true);
					textField_Cedula.setEnabled(true);
		    		 JOptionPane.showMessageDialog(null, "ES UN CLIENTE NUEVO POR FAVOR LLENE LOS CAMPOS Y PROCEDA A COMPRAR");
		    		 RegistrarButton.setText("Registrar");
		    	}else{
		    		textField_Nombre.setText(cli.getNombre());
		    		textField_direccion.setText(cli.getDireccion());
		    		textField_RNC.setText(cli.getRnc());
		    		textField_Telefono.setText(cli.getTelefono());
		    		textField_Cedula.setText(cli.getCedula());
		    		
		    		
		    		 textField_Nombre.setEnabled(false);
						textField_direccion.setEnabled(false);
						textField_RNC.setEnabled(false);
						textField_Telefono.setEnabled(false);
						textField_Cedula.setEnabled(false);
						 JOptionPane.showMessageDialog(null,"GRACIAS POR VOLVER A COMPRAR");
						 RegistrarButton.setText("Comprar");
						 
			}
			}
		});
		button.setBounds(220, 42, 130, 23);
		panel.add(button);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				RegistrarButton = new JButton("");
				RegistrarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

					
					
						if(RegistrarButton.getText().equalsIgnoreCase("Comprar")) {
							Componente ac = null;
							Combos acc=null;
							// terminar el proceso de comprar 
							int s=	JOptionPane.showOptionDialog(
									RegistrarButton,
										   "Seleccione un Metodo de Pago", 
										   "Metodos de Pago",
										   JOptionPane.YES_NO_CANCEL_OPTION,
										   JOptionPane.QUESTION_MESSAGE,
										   null,    // null para icono por defecto.
										   new Object[] { "A Credito", "Al Contado", "Cancela" },   // null para YES, NO y CANCEL
										   "opcion 1");
							if(s==-1 || s>1) {
								//credito
								 JOptionPane.showMessageDialog(null,"POR FAVRO SELECIONAR UN METODO DE PAGO");
								 
							}
							if(s==1) {
								//contado
								 JOptionPane.showMessageDialog(null,"GRACIAS POR COMPRAR AL CONTADO");
								 // limite de credito preestablecido para los clientes es de 20000 pesos
								 
								 Factura fa = new Factura(String.valueOf(codigodefactura),20000,user,carrito2,carrito1,Tienda.getInstance().buscarCliente(textField_Cedula.getText()),"contado",true);
								 fa.setMiscombos(carrito2);
								 fa.setMiscomponentes(carrito1);
								Tienda.getInstance().insetarFactura(fa); 
								 codigodefactura=codigodefactura+1;
								 for (auxiliarCarrito au : carrito1) {
								ac =Tienda.getInstance().buscarcomponente(au.getCarrito().getNombre());
								ac.setCantidadDisponible(ac.getCantidadDisponible()-au.getCantidad());
								if(ac.getCantidadDisponible()<=ac.getCantidadminima()) {
									Date fechadehoy = new Date();
									OrdenCompra ad = new OrdenCompra(String.valueOf(codigodeordendecompra),fechadehoy,"Proceso",(au.getCantidad()*2),ac,ac.getPrecio(),ac.getProveedor(), "Decidir");
								codigodeordendecompra=codigodeordendecompra +1;
								Tienda.getInstance().insertarOrdendecompra(ad);
								
								}
								}
								 for (auxiliarCarito2 au2 : carrito2) {
									for (int i = 0; i < au2.getCantidad(); i++) {
										
										 for (Componente au : au2.getCarrito().getMiscomponentes()) {
												ac =Tienda.getInstance().buscarcomponente(au.getNombre());
												ac.setCantidadDisponible(ac.getCantidadDisponible()-1);
												}
										 		}
									for (Componente auh : au2.getCarrito().getMiscomponentes()) {
										ac =Tienda.getInstance().buscarcomponente(auh.getNombre());
									if(ac.getCantidadDisponible()<=ac.getCantidadminima()) {
										Date fechadehoy = new Date();
										OrdenCompra ad = new OrdenCompra(String.valueOf(codigodeordendecompra),fechadehoy,"Proceso",(au2.getCantidad()*2),ac,ac.getPrecio(),ac.getProveedor(), "decidir");
									codigodeordendecompra=codigodeordendecompra +1;
									Tienda.getInstance().insertarOrdendecompra(ad);
									
									}}
								} 
								 dispose();
														}
							if(s==0) {
								//credito
								 JOptionPane.showMessageDialog(null,"GRACIAS POR COMPRAR A PLAZO");
								
								 Factura fa = new Factura(String.valueOf(codigodefactura),20000,user,carrito2,carrito1,Tienda.getInstance().buscarCliente(textField_Cedula.getText()),"contado",false);
								 fa.setMiscombos(carrito2);
								 fa.setMiscomponentes(carrito1);							
								 Cliente clie = Tienda.getInstance().buscarCliente(textField_Cedula.getText());
							clie.setCuentasxCobrar(clie.getCuentasxCobrar()+fa.getpreciototal());
							if(clie.getCuentasxCobrar()>clie.getLimiteCredito()) {
								clie.setCuentasxCobrar(clie.getCuentasxCobrar()-fa.getpreciototal());
								JOptionPane.showMessageDialog(null,"ESTA FACTURA ECEDE SU LIMITE DE CREDITO DISCUPE PERO NO SERA POSIBLE VENDERLA");
							}else {
								 Tienda.getInstance().insetarFactura(fa); 
								 codigodefactura=codigodefactura+1;
								 for (auxiliarCarrito au : carrito1) {
								ac =Tienda.getInstance().buscarcomponente(au.getCarrito().getNombre());
								ac.setCantidadDisponible(ac.getCantidadDisponible()-au.getCantidad());
								if(ac.getCantidadDisponible()<=ac.getCantidadminima()) {
									Date fechadehoy = new Date();
									OrdenCompra ad = new OrdenCompra(String.valueOf(codigodeordendecompra),fechadehoy,"Proceso",(au.getCantidad()*2),ac,ac.getPrecio(),ac.getProveedor(), "Decidir");
								codigodeordendecompra=codigodeordendecompra +1;
								Tienda.getInstance().insertarOrdendecompra(ad);
								
								}
								}
								 for (auxiliarCarito2 au2 : carrito2) {
									for (int i = 0; i < au2.getCantidad(); i++) {
										
										 for (Componente au : au2.getCarrito().getMiscomponentes()) {
												ac =Tienda.getInstance().buscarcomponente(au.getNombre());
												ac.setCantidadDisponible(ac.getCantidadDisponible()-1);
												}
										 		}
									for (Componente auh : au2.getCarrito().getMiscomponentes()) {
										ac =Tienda.getInstance().buscarcomponente(auh.getNombre());
									if(ac.getCantidadDisponible()<=ac.getCantidadminima()) {
										Date fechadehoy = new Date();
										OrdenCompra ad = new OrdenCompra(String.valueOf(codigodeordendecompra),fechadehoy,"Proceso",(au2.getCantidad()*2),ac,ac.getPrecio(),ac.getProveedor(), "decidir");
									codigodeordendecompra=codigodeordendecompra +1;
									Tienda.getInstance().insertarOrdendecompra(ad);
									
									}}
								} 
							}
						//	JOptionPane.showOptionDialog(RegistrarButton,"Selecciones un Metodo de Pago","Metodos De Pago",JOptionPane.YES_NO_CANCEL_OPTION,null,JOptionPane.QUESTION_MESSAGE,new Object[] { "Credito", "Contado", "Cancel"});
							dispose();
						}
							
					}
						if(RegistrarButton.getText().equalsIgnoreCase("Registrar")) {
							
							Cliente a = new Cliente(textField_Nombre.getText(),textField_direccion.getText(),textField_Telefono.getText(),textField_RNC.getText(),textField_Cedula.getText());
							Tienda.getInstance().insertarCliente(a);
							Tienda.getInstance().guardarTienda();
							 JOptionPane.showMessageDialog(null,"Registro Satisfactorio","Informacion",JOptionPane.INFORMATION_MESSAGE);
													 
			                 //clean();
							 cli = Tienda.getInstance().buscarCliente(textField_Cedula.getText().toString());
							 textField_Nombre.setText(cli.getNombre());
					    		textField_direccion.setText(cli.getDireccion());
					    		textField_RNC.setText(cli.getRnc());
					    		textField_Telefono.setText(cli.getTelefono());
					    		textField_Cedula.setText(cli.getCedula());
					    		
			                 textField_Nombre.setEnabled(false);
								textField_direccion.setEnabled(false);
								textField_RNC.setEnabled(false);
								textField_Telefono.setEnabled(false);
								textField_Cedula.setEnabled(false);
								
								 RegistrarButton.setText("Comprar");
								}
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
