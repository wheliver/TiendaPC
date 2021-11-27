package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Componente;
import logico.Proveedor;
import logico.TarjetaMadre;
import logico.Tienda;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Panel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Rectangle;

public class componenteNuevo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField TextFieldMarca;
	private JTextField textFieldMarca;
	private JTextField textFieldModelo;
	private JTextField textfieldMarca;
	private JTextField textfieldTipoconector;
	private JTextField textfieldModelo;
	private JRadioButton rDisco;
	private JRadioButton rTarjetaMadre;
	private JPanel panelRam;
	private JPanel panel2;
	private JPanel panel;
	private JPanel panelDisco;
	private JPanel panelMadre;
	private JRadioButton rRam;
	private JSpinner spnprecio;
	private JSpinner spncantidad;
	private JSpinner spnMinima;
	private JTextField textFieldNombreComponente;
	private JTextField textFieldTipoConexion;
	private JComboBox cbxCapacidadAlmacenamiento;
	private JTextField textFieldTipoMemoria;
	private JComboBox comboBoxCantidadMemoria;
	private JTextField textFieldMarca1;
	private JTextField textFieldModelo2;
	private JTextField textFieldTipoconetor;
	private JComboBox cbxVelocidad;
	private JPanel panelProcesador;
	private JRadioButton rProcesador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			componenteNuevo dialog = new componenteNuevo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public componenteNuevo() {
		
		
		
		setResizable(false);
		setTitle(".:. INTRODUCION DE NUEVO COMPONENTE .:.");
		setBounds(100, 100, 530, 433);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Introduccion de Componente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			panelMadre = new JPanel();
			panelMadre.setLayout(null);
			panelMadre.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelMadre.setBounds(6, 229, 508, 119);
			contentPanel.add(panelMadre);
			{
				JLabel lblMarca = new JLabel("Marca");
				lblMarca.setBounds(10, 11, 106, 14);
				panelMadre.add(lblMarca);
			}
			{
				textfieldMarca = new JTextField();
				textfieldMarca.setColumns(10);
				textfieldMarca.setBounds(10, 36, 136, 20);
				panelMadre.add(textfieldMarca);
			}
			{
				JLabel lblTipoDeConector = new JLabel("Tipo de conector");
				lblTipoDeConector.setBounds(10, 71, 106, 14);
				panelMadre.add(lblTipoDeConector);
			}
			{
				textfieldTipoconector = new JTextField();
				textfieldTipoconector.setColumns(10);
				textfieldTipoconector.setBounds(10, 88, 136, 20);
				panelMadre.add(textfieldTipoconector);
			}
			{
				textfieldModelo = new JTextField();
				textfieldModelo.setColumns(10);
				textfieldModelo.setBounds(206, 36, 136, 20);
				panelMadre.add(textfieldModelo);
			}
			{
				JLabel lblRadioInterior = new JLabel("Modelo");
				lblRadioInterior.setBounds(206, 11, 115, 14);
				panelMadre.add(lblRadioInterior);
			}
			
			JLabel lblTipoDeRam = new JLabel("Tipo de Ram");
			lblTipoDeRam.setBounds(206, 71, 106, 14);
			panelMadre.add(lblTipoDeRam);
			
			JComboBox cbxTipoRam = new JComboBox();
			cbxTipoRam.setModel(new DefaultComboBoxModel(new String[] {"<<Seleccionar>>", "DR1", "DR2", "DR3", "DR4", "DR5"}));
			cbxTipoRam.setBounds(206, 88, 136, 20);
			panelMadre.add(cbxTipoRam);
		}
		{
			panel = new JPanel();
			panel.setBounds(6, 23, 508, 143);
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblPrecio = new JLabel("Precio ");
				lblPrecio.setBounds(362, 71, 104, 15);
				lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
				panel.add(lblPrecio);
			}
			{
				spnprecio = new JSpinner();
				spnprecio.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
				spnprecio.setBounds(362, 97, 136, 20);
				panel.add(spnprecio);
			}
			{
				JLabel lblCantidadInicial = new JLabel("Cantidad inicial");
				lblCantidadInicial.setBounds(10, 71, 104, 15);
				lblCantidadInicial.setFont(new Font("Tahoma", Font.PLAIN, 12));
				panel.add(lblCantidadInicial);
			}
			{
				spncantidad = new JSpinner();
				spncantidad.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
				spncantidad.setBounds(10, 97, 136, 20);
				panel.add(spncantidad);
			}
			
			JLabel lblCantidadMinima = new JLabel("Cantidad Minima");
			lblCantidadMinima.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblCantidadMinima.setBounds(178, 71, 104, 15);
			panel.add(lblCantidadMinima);
			
			spnMinima = new JSpinner();
			spnMinima.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spnMinima.setBounds(178, 97, 136, 20);
			panel.add(spnMinima);
			
			JLabel lblNombreDelComponente = new JLabel("Nombre del Componente ");
			lblNombreDelComponente.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNombreDelComponente.setBounds(10, 11, 155, 15);
			panel.add(lblNombreDelComponente);
			
			textFieldNombreComponente = new JTextField();
			textFieldNombreComponente.setBounds(10, 37, 488, 20);
			panel.add(textFieldNombreComponente);
			textFieldNombreComponente.setColumns(10);
		}
		{
			panelDisco = new JPanel();
			panelDisco.setLayout(null);
			panelDisco.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelDisco.setBounds(6, 229, 508, 119);
			contentPanel.add(panelDisco);
			{
				JLabel lblMarca = new JLabel("Marca");
				lblMarca.setBounds(10, 11, 110, 14);
				panelDisco.add(lblMarca);
			}
			{
				textFieldMarca = new JTextField();
				textFieldMarca.setColumns(10);
				textFieldMarca.setBounds(10, 36, 136, 20);
				panelDisco.add(textFieldMarca);
			}
			{
				JLabel lblModelo = new JLabel("Modelo");
				lblModelo.setBounds(206, 11, 102, 14);
				panelDisco.add(lblModelo);
			}
			{
				textFieldModelo = new JTextField();
				textFieldModelo.setColumns(10);
				textFieldModelo.setBounds(206, 36, 136, 20);
				panelDisco.add(textFieldModelo);
			}
			
			JLabel lblCapacidadAlmacenamiento = new JLabel("Tipo Conexion");
			lblCapacidadAlmacenamiento.setBounds(10, 71, 106, 14);
			panelDisco.add(lblCapacidadAlmacenamiento);
			
			textFieldTipoConexion = new JTextField();
			textFieldTipoConexion.setBounds(10, 88, 136, 20);
			panelDisco.add(textFieldTipoConexion);
			textFieldTipoConexion.setColumns(10);
			
			cbxCapacidadAlmacenamiento = new JComboBox();
			cbxCapacidadAlmacenamiento.setModel(new DefaultComboBoxModel(new String[] {"<<Seleccionar>>", "2TB", "4TB", "6TB", "8TB", "10TB"}));
			cbxCapacidadAlmacenamiento.setBounds(206, 88, 136, 20);
			panelDisco.add(cbxCapacidadAlmacenamiento);
			
			JLabel lblNewLabel_1 = new JLabel("Almacenamiento");
			lblNewLabel_1.setBounds(206, 71, 155, 14);
			panelDisco.add(lblNewLabel_1);
		}
		{
			panel2 = new JPanel();
			panel2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel2.setBounds(6, 177, 508, 41);
			contentPanel.add(panel2);
			panel2.setLayout(null);
			{
				rRam = new JRadioButton("Ram");
				rRam.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					panelRam.setVisible(true);
						panelDisco.setVisible(false);
						panelMadre.setVisible(false);
						panelProcesador.setVisible(false);
						rRam.setSelected(true);
						rDisco.setSelected(false);
						rProcesador.setSelected(false);
						rTarjetaMadre.setSelected(false);	
					}
					
				});
				rRam.setBounds(126, 7, 91, 23);
				panel2.add(rRam);
			}
			{
				rDisco = new JRadioButton("Disco");
				rDisco.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panelDisco.setVisible(true);
						panelRam.setVisible(false);
						panelMadre.setVisible(false);
						panelProcesador.setVisible(false);
						rRam.setSelected(false);
						rDisco.setSelected(true);
						rTarjetaMadre.setSelected(false);
						rProcesador.setSelected(false);
					}
				});
				rDisco.setBounds(219, 7, 98, 23);
				panel2.add(rDisco);
			}
			{
				rTarjetaMadre = new JRadioButton("Tarjeta Madre");
				rTarjetaMadre.setSelected(true);
				rTarjetaMadre.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panelMadre.setVisible(true);
						panelDisco.setVisible(false);
						panelRam.setVisible(false);
						panelProcesador.setVisible(false);
		                
						rRam.setSelected(false);
						rDisco.setSelected(false);
						rTarjetaMadre.setSelected(true);
						rProcesador.setSelected(false);
					}
				});
				rTarjetaMadre.setBounds(6, 7, 118, 23);
				panel2.add(rTarjetaMadre);
			}
			
			rProcesador = new JRadioButton("Procesador");
			rProcesador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelDisco.setVisible(false);
					panelRam.setVisible(false);
					panelMadre.setVisible(false);
					panelProcesador.setVisible(true);
					rRam.setSelected(false);
					rDisco.setSelected(false);
					rTarjetaMadre.setSelected(false);
					rProcesador.setSelected(true);
				}
			});
			rProcesador.setBounds(318, 7, 98, 23);
			panel2.add(rProcesador);
		}
		{
			panelRam = new JPanel();
			panelRam.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelRam.setBounds(6, 229, 508, 119);
			contentPanel.add(panelRam);
			panelRam.setLayout(null);
			
			JLabel lblNewLabel_3 = new JLabel("Cantidad de Memoria");
			lblNewLabel_3.setBounds(206, 11, 150, 14);
			panelRam.add(lblNewLabel_3);
			
			JLabel lblNewLabel_2 = new JLabel("Tipo Memoria");
			lblNewLabel_2.setBounds(10, 71, 106, 14);
			panelRam.add(lblNewLabel_2);
			{
				JLabel lblNewLabel = new JLabel("Marca");
				lblNewLabel.setBounds(10, 11, 103, 14);
				panelRam.add(lblNewLabel);
			}
			
			comboBoxCantidadMemoria = new JComboBox();
			comboBoxCantidadMemoria.setModel(new DefaultComboBoxModel(new String[] {"<<Seleccionar>>", "8GB", "16GB"}));
			comboBoxCantidadMemoria.setBounds(206, 36, 136, 20);
			panelRam.add(comboBoxCantidadMemoria);
			
			textFieldTipoMemoria = new JTextField();
			textFieldTipoMemoria.setBounds(10, 88, 136, 20);
			panelRam.add(textFieldTipoMemoria);
			textFieldTipoMemoria.setColumns(10);
			{
				TextFieldMarca = new JTextField();
				TextFieldMarca.setBounds(10, 36, 136, 20);
				panelRam.add(TextFieldMarca);
				TextFieldMarca.setColumns(10);
			}
		}
		
		panelProcesador = new JPanel();
		panelProcesador.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelProcesador.setBounds(6, 229, 508, 119);
		contentPanel.add(panelProcesador);
		panelProcesador.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Marca");
		lblNewLabel_4.setBounds(10, 11, 110, 14);
		panelProcesador.add(lblNewLabel_4);
		
		textFieldMarca1 = new JTextField();
		textFieldMarca1.setBounds(10, 36, 136, 20);
		panelProcesador.add(textFieldMarca1);
		textFieldMarca1.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Modelo");
		lblNewLabel_5.setBounds(206, 11, 102, 14);
		panelProcesador.add(lblNewLabel_5);
		
		textFieldModelo2 = new JTextField();
		textFieldModelo2.setBounds(206, 36, 136, 20);
		panelProcesador.add(textFieldModelo2);
		textFieldModelo2.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Tipo de conector");
		lblNewLabel_6.setBounds(10, 71, 106, 14);
		panelProcesador.add(lblNewLabel_6);
		
		textFieldTipoconetor = new JTextField();
		textFieldTipoconetor.setBounds(10, 88, 136, 20);
		panelProcesador.add(textFieldTipoconetor);
		textFieldTipoconetor.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Velocidad");
		lblNewLabel_7.setBounds(206, 71, 106, 14);
		panelProcesador.add(lblNewLabel_7);
		
		cbxVelocidad = new JComboBox();
		cbxVelocidad.setModel(new DefaultComboBoxModel(new String[] {"<<Seleccionar>>", "2,4GHz", "3,0GHz", "3,30GHz"}));
		cbxVelocidad.setBounds(206, 88, 136, 20);
		panelProcesador.add(cbxVelocidad);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Facbricar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(validarCampos()) {
						Componente compo = null;
						String nombre = textFieldNombreComponente.getText();
						int numeroserie = Tienda.getInstance().getGeneradorcodigoCompo();
						int cantidad = Integer.valueOf(spncantidad.getValue().toString());
						float precio = Float.valueOf(spnprecio.getValue().toString());
						int cantidadmininima = Integer.valueOf(spnMinima.getValue().toString());
						
						
						if(rTarjetaMadre.isSelected()) {
							compo = new TarjetaMadre(nombre, precio, cantidadmininima, cantidadmininima, cantidadmininima, null, "", "", "", "", null);
						}
						
						/**if(rCilindro.isSelected()) {
							compo =  new Cilindro(Base,unitario,codigo,cant,Float.valueOf(Longitud.getText()),Float.valueOf(RadioCilindro.getText()));
						}
						
						if(rCilindrohueco.isSelected()) {
							compo = new Cilindrohueco(Base,unitario,codigo,cant,Float.valueOf(Longitud2.getText()),Float.valueOf(RadioCilindrohueco.getText()),Float.valueOf(RadioInterior.getText()));
						}
						**///
						//Tienda.getInstance().intrduc(compo);
						JOptionPane.showMessageDialog(null, "Se Introdujo correctamente el Componente ");
						limpiarVentana();
						}else{
							JOptionPane.showMessageDialog(null, "Completar campos para poder fabricar  los Quesos ");
						}
					
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public void limpiarVentana() {
	
		textFieldMarca.setText("");
		textfieldModelo.setText("");
		textFieldModelo.setText("");
		TextFieldMarca.setText("");
		textfieldMarca.setText("");
		textfieldTipoconector.setText("");
		
		spnprecio.setValue(0);
		spncantidad.setValue(0);
	}
	public boolean validarCampos() {
		boolean aux = false;
		String codigo = String.valueOf(Tienda.getInstance().getGeneradorcodigoCompo());
		float unitario = Float.valueOf(spncantidad.getValue().toString());
		float Base = Float.valueOf(spnprecio.getValue().toString());
		if(!(codigo.equalsIgnoreCase("")) && unitario>0 && Base>0){
			aux = true;
		}
		return aux;
	}
}
