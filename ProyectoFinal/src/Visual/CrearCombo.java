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
import logico.Discoduro;
import logico.MemoriaRam;
import logico.Microprocesador;
import logico.TarjetaMadre;
import logico.Tienda;
import javax.swing.SpinnerNumberModel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.ImageIcon;

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
	private JPanel panel;

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
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(null);
		panel.setBounds(10, 11, 424, 62);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre del Combo");
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 125, 14);
		panel.add(lblNewLabel);
		
		textFieldCombroNombre = new JTextField();
		textFieldCombroNombre.setBounds(135, 8, 279, 20);
		panel.add(textFieldCombroNombre);
		textFieldCombroNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Descuento Aplicado");
		lblNewLabel_1.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 36, 125, 15);
		panel.add(lblNewLabel_1);
		
		spinnerDescuento = new JSpinner();
		spinnerDescuento.setModel(new SpinnerNumberModel(new Float(0), new Float(0), new Float(50), new Float(1)));
		spinnerDescuento.setBounds(135, 33, 60, 20);
		panel.add(spinnerDescuento);
		
		JLabel lblNewLabel_3 = new JLabel("Codigo");
		lblNewLabel_3.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		lblNewLabel_3.setBounds(226, 36, 60, 14);
		panel.add(lblNewLabel_3);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setBounds(282, 33, 132, 20);
		panel.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(Color.WHITE);
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
		lblNewLabel_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(179, 11, 114, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblDiscoDuro = new JLabel("Disco Duro");
		lblDiscoDuro.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		lblDiscoDuro.setBounds(182, 58, 78, 14);
		panel_1.add(lblDiscoDuro);
		
		JLabel lblMemoriaRam = new JLabel("Memoria Ram");
		lblMemoriaRam.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		lblMemoriaRam.setBounds(179, 114, 103, 14);
		panel_1.add(lblMemoriaRam);
		
		JLabel lblMircroprocesador = new JLabel("Microprocesador");
		lblMircroprocesador.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		lblMircroprocesador.setBounds(179, 166, 114, 14);
		panel_1.add(lblMircroprocesador);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(CrearCombo.class.getResource("/Images/motherboard (1).png")));
		lblNewLabel_4.setBounds(276, 11, 31, 21);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(CrearCombo.class.getResource("/Images/hard-drive.png")));
		lblNewLabel_5.setBounds(276, 58, 31, 24);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(CrearCombo.class.getResource("/Images/ram.png")));
		lblNewLabel_6.setBounds(276, 108, 46, 20);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(CrearCombo.class.getResource("/Images/microprocesador.png")));
		lblNewLabel_7.setBounds(289, 166, 46, 21);
		panel_1.add(lblNewLabel_7);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Guardar Combo");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(validarCampos()) 
						{
							llenarcombo();
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
		loadComponente();
	}
	protected void llenarcombo() {
		Componente a1=null,b=null,c=null,d=null;
		d = Tienda.getInstance().buscarcomponente(ComboTarjetaMadre.getSelectedItem().toString());
		carrito.add(d);
		a1 = Tienda.getInstance().buscarcomponente(ComboDisco.getSelectedItem().toString());
		carrito.add(a1);
		b = Tienda.getInstance().buscarcomponente(ComboRam.getSelectedItem().toString());
		carrito.add(b);
		c = Tienda.getInstance().buscarcomponente(ComboMircroprocesador.getSelectedItem().toString());
		carrito.add(c);
		String q = textFieldCodigo.getText();
		String g = textFieldCombroNombre.getText();
        int s = Integer.valueOf(spinnerDescuento.getValue().toString());
		Combos a = new Combos(q,g,s,carrito); 
		Tienda.getInstance().insetarCombo(a);
		
		JOptionPane.showMessageDialog(null,"Registro satisfecho");
	}

	public boolean validarCampos() {
		boolean aux = true;
		String a = textFieldCombroNombre.getText();
		String s = textFieldCodigo.getText();
		String f = ComboDisco.getSelectedItem().toString();
        String g = ComboRam.getSelectedItem().toString();
        String b = ComboTarjetaMadre.getSelectedItem().toString();
        String h = ComboMircroprocesador.getSelectedItem().toString();
		
        if(a.equalsIgnoreCase("")) 
        {
        	JOptionPane.showMessageDialog(null,"Debe Registrar un nombre");
        	aux = false;
        }
        if(s.equals(""))
        {
        	JOptionPane.showMessageDialog(null,"Debe Registrar un codigo");
        	aux = false;
        }
        if(f.equals(""))
        {
        	JOptionPane.showMessageDialog(null,"Debe agregar un disco duro");
        	aux = false;
        }
        if(g.equalsIgnoreCase("                                         Seleccionar")) 
        {
        	JOptionPane.showMessageDialog(null,"Debe agregar una Memoria Ram");
        	aux = false;
        }
        if(b.equalsIgnoreCase("                                         Seleccionar"))
        	{
        	JOptionPane.showMessageDialog(null,"Debe agregar una tarjeta madre");
        	aux = false;
        	}
        if(h.equalsIgnoreCase("                                         Seleccionar")) 
        {
        	JOptionPane.showMessageDialog(null,"Debe agregar un microprocesador");
        	aux = false;
        }
        if(Float.valueOf(spinnerDescuento.getValue().toString()) == 0)
        {
        	aux = false;
        	JOptionPane.showMessageDialog(null,"Debe aplicar un descuento");
 	    }
		return aux;
	}
	
	public void loadComponente() {
		 ArrayList<Componente> compo = Tienda.getInstance().getMiscomponentes();
		 for (Componente compi : compo) {
		if(compi instanceof TarjetaMadre) {
		ComboTarjetaMadre.addItem(compi.getNombre());	
		}
		if(compi instanceof MemoriaRam) {
			ComboRam.addItem(compi.getNombre());	
			}
		
		 if(compi instanceof Microprocesador) {
				ComboMircroprocesador.addItem(compi.getNombre());	
				}
		 if(compi instanceof Discoduro) {
				ComboDisco.addItem(compi.getNombre());	
				}
		 }
		 
	}
}