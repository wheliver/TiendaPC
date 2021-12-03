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
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;

import logico.Combos;
import logico.Componente;
import logico.Tienda;
import javax.swing.SpinnerNumberModel;

public class CrearCombo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldCombroNombre;
	private JComboBox ComboRam;
	private JComboBox ComboDisco;
	private JComboBox ComboTarjetaMadre;
	private JSpinner spinnerDescuento;
	private JButton okButton;
	private Componente selected1 = null;
	private ArrayList<Componente> carrito;
	private JComboBox ComboMircroprocesador;
	private JTextField textFieldCodigo;
	private JButton btnLimpiar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrearCombo dialog = new CrearCombo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearCombo() {
		setTitle("Creacion de un combo\r\n");
		setBounds(100, 100, 460, 401);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 424, 62);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre del Combo");
		lblNewLabel.setBounds(10, 11, 125, 14);
		panel.add(lblNewLabel);
		
		textFieldCombroNombre = new JTextField();
		textFieldCombroNombre.setBounds(135, 8, 279, 20);
		panel.add(textFieldCombroNombre);
		textFieldCombroNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Descuento Aplicado");
		lblNewLabel_1.setBounds(10, 36, 125, 15);
		panel.add(lblNewLabel_1);
		
		spinnerDescuento = new JSpinner();
		spinnerDescuento.setModel(new SpinnerNumberModel(0, 0, 50, 5));
		spinnerDescuento.setBounds(135, 33, 60, 20);
		panel.add(spinnerDescuento);
		
		JLabel lblNewLabel_3 = new JLabel("Codigo");
		lblNewLabel_3.setBounds(226, 36, 46, 14);
		panel.add(lblNewLabel_3);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setBounds(282, 33, 132, 20);
		panel.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 84, 424, 234);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		ComboTarjetaMadre = new JComboBox();
		ComboTarjetaMadre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ComboTarjetaMadre.getSelectedItem().toString() !="                                         Seleccionar") {
				Combos c = Tienda.getInstance().buscarcombo(ComboTarjetaMadre.getSelectedItem().toString());
				}
			}
		});
		ComboTarjetaMadre.setModel(new DefaultComboBoxModel(new String[] {"                                         Seleccionar"}));
		ComboTarjetaMadre.setBounds(68, 35, 298, 20);
		panel_1.add(ComboTarjetaMadre);
		
		ComboDisco = new JComboBox();
		ComboDisco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ComboTarjetaMadre.getSelectedItem().toString() !="                                         Seleccionar") {
				Combos c = Tienda.getInstance().buscarcombo(ComboDisco.getSelectedItem().toString());
					}
			}
		});
		ComboDisco.setModel(new DefaultComboBoxModel(new String[] {"                                         Seleccionar"}));
		ComboDisco.setBounds(68, 83, 298, 20);
		panel_1.add(ComboDisco);
		
		ComboRam = new JComboBox();
		ComboRam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ComboTarjetaMadre.getSelectedItem().toString() !="                                         Seleccionar") {
				Combos c = Tienda.getInstance().buscarcombo(ComboRam.getSelectedItem().toString());
						}
				
			}
		});
		ComboRam.setModel(new DefaultComboBoxModel(new String[] {"                                         Seleccionar"}));
		ComboRam.setBounds(68, 139, 298, 20);
		panel_1.add(ComboRam);
		
		ComboMircroprocesador = new JComboBox();
		ComboMircroprocesador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ComboTarjetaMadre.getSelectedItem().toString() !="                                         Seleccionar") {
				Combos c = Tienda.getInstance().buscarcombo(ComboMircroprocesador.getSelectedItem().toString());
							}
				
			}
		});
		ComboMircroprocesador.setModel(new DefaultComboBoxModel(new String[] {"                                         Seleccionar"}));
		ComboMircroprocesador.setBounds(68, 191, 298, 20);
		panel_1.add(ComboMircroprocesador);
		
		JLabel lblNewLabel_2 = new JLabel("Tarjeta Madre");
		lblNewLabel_2.setBounds(190, 11, 114, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblDiscoDuro = new JLabel("Disco Duro");
		lblDiscoDuro.setBounds(190, 58, 78, 14);
		panel_1.add(lblDiscoDuro);
		
		JLabel lblMemoriaRam = new JLabel("Memoria Ram");
		lblMemoriaRam.setBounds(190, 114, 103, 14);
		panel_1.add(lblMemoriaRam);
		
		JLabel lblMircroprocesador = new JLabel("Mircroprocesador");
		lblMircroprocesador.setBounds(190, 170, 103, 14);
		panel_1.add(lblMircroprocesador);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Guardar Combo");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					if(textFieldCombroNombre == null) {
						JOptionPane.showMessageDialog(null,"Debe Registrar un nombre");
						
					}
					if(textFieldCodigo == null) 
					{
						JOptionPane.showMessageDialog(null,"Debe Registrar un codigo");
					}
					if(Integer.valueOf(spinnerDescuento.getValue().toString()) < 1)
							{
						JOptionPane.showMessageDialog(null,"Debe poner un descuento de al menos 1%");
						
							}
					if(ComboTarjetaMadre.getSelectedItem().toString() == "                                         Seleccionar" ) 
					{
						JOptionPane.showMessageDialog(null,"Debe agregar una tarjeta madre");
					}
					if(ComboDisco.getSelectedItem().toString() == "                                         Seleccionar" ) 
					{
						JOptionPane.showMessageDialog(null,"Debe agregar un disco duro");
					}
					if(ComboRam.getSelectedItem().toString() == "                                         Seleccionar" ) 
					{
						JOptionPane.showMessageDialog(null,"Debe agregar una Memoria Ram");
					}
					if(ComboMircroprocesador.getSelectedItem().toString() == "                                         Seleccionar" ) 
					{
						JOptionPane.showMessageDialog(null,"Debe agregar un microprocesador");
					}
				
					else {	
						selected1 = Tienda.getInstance().buscarcomponente(ComboTarjetaMadre.getSelectedItem().toString());
						carrito.add(selected1);
						selected1 = Tienda.getInstance().buscarcomponente(ComboDisco.getSelectedItem().toString());
						carrito.add(selected1);
						selected1 = Tienda.getInstance().buscarcomponente(ComboRam.getSelectedItem().toString());
						carrito.add(selected1);
						selected1 = Tienda.getInstance().buscarcomponente(ComboMircroprocesador.getSelectedItem().toString());
						carrito.add(selected1);
						String q = textFieldCodigo.getText();
						String g = textFieldCombroNombre.getText();
				        int s = Integer.valueOf(spinnerDescuento.getValue().toString());
						Combos a = new Combos(q,g,s,carrito); 
						
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
				btnLimpiar = new JButton("Limpiar");
				btnLimpiar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					textFieldCombroNombre.setText("");
					textFieldCodigo.setText("");
					spinnerDescuento.setValue(0);
					ComboTarjetaMadre.setSelectedIndex(0);
					ComboDisco.setSelectedIndex(0);
					ComboRam.setSelectedIndex(0);
					ComboMircroprocesador.setSelectedIndex(0);
					}
				});
				buttonPane.add(btnLimpiar);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void loadcompos() {
		// TODO Auto-generated method stub
	}
}