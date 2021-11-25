package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Componente;
import logico.Tienda;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Ventas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton RegistrarButton;
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] row;
	private Componente selected = null;
	private JButton agregar;
	private JLabel indentificador;
	private JScrollPane scrollPane;
	private JButton quitar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Ventas dialog = new Ventas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Ventas() {
		setTitle("Venta Combos");
		setBounds(100, 100, 663, 414);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Eleccion de componentes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 627, 320);
		contentPanel.add(panel);
		panel.setLayout(null);
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(216, 25, 401, 284);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		agregar = new JButton("Agregar");
		agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selected.getCantidadDisponible()>0) {
					indentificador.setText("Queso agregado a la lista");
				}else {
					 JOptionPane.showMessageDialog(null,"Este queso ya fue agregado a la lista selecione otro para agregar");
				}
				
			}
		});
		agregar.setEnabled(false);
		agregar.setBounds(10, 250, 89, 23);
		panel_2.add(agregar);
		agregar.setVisible(false);
		
		indentificador = new JLabel("");
		indentificador.setEnabled(false);
		indentificador.setBounds(208, 250, 183, 23);
		panel_2.add(indentificador);
		indentificador.setVisible(false);
		{
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 6, 381, 233);
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int select = table.getSelectedRow();
				if(select!= -1) 
				{
					
					selected = Tienda.getInstance().buscarcomponente((String) table.getValueAt(select, 0));
					agregar.setVisible(true);
					agregar.setEnabled(true);
					quitar.setVisible(true);
					quitar.setEnabled(true);
					indentificador.setEnabled(true);
					indentificador.setVisible(true);
					
					if (selected.getCantidadDisponible()>0) {
						indentificador.setText("Disponible para agregar");
										
					}else {
						indentificador.setText("Queso agregado a la lista");
					}
		
					
				
				}
			}
		});
		model = new DefaultTableModel();
		String[] headers = {"codigo","Queso de Tipo :","Precio"};
		model.setColumnIdentifiers(headers);
		table.setModel(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    scrollPane.setViewportView(table);
		}
		
		quitar = new JButton("Quitar");
		quitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selected.getCantidadDisponible()>0) {
				//trabajar en como quitar y poner el componente 
					//	selected.setCantidaddequesos(1);
					indentificador.setText("Disponible para agregar");
				}else {
					 JOptionPane.showMessageDialog(null,"Este queso ya fue quitado de la lista selecione otro para quitarlo");
				}
			}
		});
		quitar.setEnabled(false);
		quitar.setBounds(109, 250, 89, 23);
		panel_2.add(quitar);
		quitar.setVisible(false);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"                        None"}));
		comboBox.setBounds(10, 50, 196, 20);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"                        None"}));
		comboBox_1.setBounds(10, 106, 196, 20);
		panel.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"                        None"}));
		comboBox_2.setBounds(10, 164, 196, 20);
		panel.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"                        None"}));
		comboBox_3.setBounds(10, 218, 196, 20);
		panel.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"                        None"}));
		comboBox_4.setBounds(10, 271, 196, 20);
		panel.add(comboBox_4);
		
		JLabel lblNewLabel = new JLabel("Combos");
		lblNewLabel.setBounds(80, 25, 67, 14);
		panel.add(lblNewLabel);
		
		JLabel lblTarjetaMadre = new JLabel("Tarjeta madre");
		lblTarjetaMadre.setBounds(68, 81, 89, 14);
		panel.add(lblTarjetaMadre);
		
		JLabel lblDiscoDuro = new JLabel("Disco duro");
		lblDiscoDuro.setBounds(68, 139, 67, 14);
		panel.add(lblDiscoDuro);
		
		JLabel lblMemoriaRam = new JLabel("Memoria Ram");
		lblMemoriaRam.setBounds(68, 193, 79, 14);
		panel.add(lblMemoriaRam);
		
		JLabel lblMicroprocesador = new JLabel("Microprocesador");
		lblMicroprocesador.setBounds(68, 249, 101, 14);
		panel.add(lblMicroprocesador);
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(216, 25, 246, 284);
		panel.add(panel_1);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton GuardarCombobutton = new JButton("Guardar Combo");
			GuardarCombobutton.setActionCommand("OK");
			buttonPane.add(GuardarCombobutton);
			{
				RegistrarButton = new JButton("Registrar");
				RegistrarButton.setActionCommand("OK");
				buttonPane.add(RegistrarButton);
				getRootPane().setDefaultButton(RegistrarButton);
			}
			{
				JButton cancelButton = new JButton("Salir");
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
}
