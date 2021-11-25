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

public class componenteNuevo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField RadioEsfera;
	private JTextField RadioCilindro;
	private JTextField Longitud;
	private JTextField RadioCilindrohueco;
	private JTextField Longitud2;
	private JTextField RadioInterior;
	private JRadioButton rCilindro;
	private JRadioButton rCilindrohueco;
	private JPanel panel3;
	private JPanel panel2;
	private JPanel panel;
	private JPanel panel4;
	private JPanel panel5;
	private JRadioButton rEsfera;
	private JSpinner spnprecio;
	private JSpinner spncantidad;
	private JSpinner spnMinima;
	private JTextField textField;

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
		setBounds(100, 100, 530, 472);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "Introcion de Componente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			panel5 = new JPanel();
			panel5.setLayout(null);
			panel5.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel5.setBounds(6, 229, 508, 119);
			contentPanel.add(panel5);
			{
				JLabel lblMarca = new JLabel("Marca");
				lblMarca.setBounds(10, 11, 106, 14);
				panel5.add(lblMarca);
			}
			{
				RadioCilindrohueco = new JTextField();
				RadioCilindrohueco.setColumns(10);
				RadioCilindrohueco.setBounds(10, 36, 136, 20);
				panel5.add(RadioCilindrohueco);
			}
			{
				JLabel lblTipoDeConector = new JLabel("Tipo de conector");
				lblTipoDeConector.setBounds(10, 71, 106, 14);
				panel5.add(lblTipoDeConector);
			}
			{
				Longitud2 = new JTextField();
				Longitud2.setColumns(10);
				Longitud2.setBounds(10, 88, 136, 20);
				panel5.add(Longitud2);
			}
			{
				RadioInterior = new JTextField();
				RadioInterior.setColumns(10);
				RadioInterior.setBounds(206, 36, 136, 20);
				panel5.add(RadioInterior);
			}
			{
				JLabel lblRadioInterior = new JLabel("Modelo");
				lblRadioInterior.setBounds(206, 11, 115, 14);
				panel5.add(lblRadioInterior);
			}
			
			JLabel lblTipoDeRam = new JLabel("Tipo de Ram");
			lblTipoDeRam.setBounds(206, 71, 106, 14);
			panel5.add(lblTipoDeRam);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"<<Seleccionar>>", "DR1", "DR2", "DR3", "DR4", "DR5"}));
			comboBox.setBounds(206, 88, 136, 20);
			panel5.add(comboBox);
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
			
			textField = new JTextField();
			textField.setBounds(10, 37, 488, 20);
			panel.add(textField);
			textField.setColumns(10);
		}
		{
			panel4 = new JPanel();
			panel4.setLayout(null);
			panel4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel4.setBounds(6, 229, 422, 119);
			contentPanel.add(panel4);
			{
				JLabel lblRadioCilindro = new JLabel("Radio Cilindro");
				lblRadioCilindro.setBounds(10, 11, 110, 14);
				panel4.add(lblRadioCilindro);
			}
			{
				RadioCilindro = new JTextField();
				RadioCilindro.setColumns(10);
				RadioCilindro.setBounds(10, 36, 136, 20);
				panel4.add(RadioCilindro);
			}
			{
				JLabel lblLongitud = new JLabel("Longitud");
				lblLongitud.setBounds(206, 11, 102, 14);
				panel4.add(lblLongitud);
			}
			{
				Longitud = new JTextField();
				Longitud.setColumns(10);
				Longitud.setBounds(206, 36, 136, 20);
				panel4.add(Longitud);
			}
		}
		{
			panel2 = new JPanel();
			panel2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel2.setBounds(6, 177, 508, 41);
			contentPanel.add(panel2);
			panel2.setLayout(null);
			{
				rEsfera = new JRadioButton("Ram");
				rEsfera.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					panel3.setVisible(true);
						panel4.setVisible(false);
						panel5.setVisible(false);
						rEsfera.setSelected(true);
						rCilindro.setSelected(false);
						rCilindrohueco.setSelected(false);	
					}
					
				});
				rEsfera.setBounds(126, 7, 91, 23);
				panel2.add(rEsfera);
			}
			{
				rCilindro = new JRadioButton("Disco");
				rCilindro.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panel4.setVisible(true);
						panel3.setVisible(false);
						panel5.setVisible(false);
						rEsfera.setSelected(false);
						rCilindro.setSelected(true);
						rCilindrohueco.setSelected(false);	
					}
				});
				rCilindro.setBounds(219, 7, 98, 23);
				panel2.add(rCilindro);
			}
			{
				rCilindrohueco = new JRadioButton("Targeta Madre");
				rCilindrohueco.setSelected(true);
				rCilindrohueco.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panel5.setVisible(true);
						panel4.setVisible(false);
						panel3.setVisible(false);
						rEsfera.setSelected(false);
						rCilindro.setSelected(false);
						rCilindrohueco.setSelected(true);	
					}
				});
				rCilindrohueco.setBounds(6, 7, 118, 23);
				panel2.add(rCilindrohueco);
			}
			
			JRadioButton rdbtnProcesador = new JRadioButton("Procesador");
			rdbtnProcesador.setBounds(318, 7, 98, 23);
			panel2.add(rdbtnProcesador);
		}
		{
			panel3 = new JPanel();
			panel3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel3.setBounds(6, 229, 422, 119);
			contentPanel.add(panel3);
			panel3.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Radio Esfera");
				lblNewLabel.setBounds(10, 11, 103, 14);
				panel3.add(lblNewLabel);
			}
			{
				RadioEsfera = new JTextField();
				RadioEsfera.setBounds(10, 36, 136, 20);
				panel3.add(RadioEsfera);
				RadioEsfera.setColumns(10);
			}
		}
		/*
		 protected float precio;
protected int cantidadDisponible;
protected int numeroserie;
protected int cantidadminima;
Proveedor proveedor;
		 */
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
						int numeroserie = Tienda.getInstance().getGeneradorcodigoCompo();
						int cantidad = Integer.valueOf(spncantidad.getValue().toString());
						float precio = Float.valueOf(spnprecio.getValue().toString());
						int cantidadmininima = Integer.valueOf(spnMinima.getValue().toString());
						
						/*
						if(rEsfera.isSelected()) {
							compo = new Esfera(precio,unitario,codigo,cant,Float.valueOf(RadioEsfera.getText()));
						}
						
						if(rCilindro.isSelected()) {
							compo =  new Cilindro(Base,unitario,codigo,cant,Float.valueOf(Longitud.getText()),Float.valueOf(RadioCilindro.getText()));
						}
						
						if(rCilindrohueco.isSelected()) {
							compo = new Cilindrohueco(Base,unitario,codigo,cant,Float.valueOf(Longitud2.getText()),Float.valueOf(RadioCilindrohueco.getText()),Float.valueOf(RadioInterior.getText()));
						}
						
						Tienda.getInstance().intrduc(compo);
						JOptionPane.showMessageDialog(null, "Se Introdujo correctamente el Componente ");
						limpiarVentana();*/
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
	
		RadioCilindro.setText("");
		RadioInterior.setText("");
		Longitud.setText("");
		RadioEsfera.setText("");
		RadioCilindrohueco.setText("");
		Longitud2.setText("");
		
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
