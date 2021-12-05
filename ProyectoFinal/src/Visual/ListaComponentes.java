package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Componente;
import logico.Discoduro;
import logico.MemoriaRam;
import logico.Microprocesador;
import logico.OrdenCompra;
import logico.Proveedor;
import logico.TarjetaMadre;
import logico.Tienda;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ListaComponentes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static Object[] row;
	private static DefaultTableModel model;
	private JTable table;
	private JScrollPane scrollPane;
	private Componente selected = null;
	private JButton btnModificar;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
			Tienda.getInstance().cargarTienda();
			System.out.println(Tienda.getInstance().getMiscomponentes().size());
			ListaComponentes dialog = new ListaComponentes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaComponentes() {
		setBounds(100, 100, 763, 575);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		model = new DefaultTableModel();
		String [] headers = {"Nombre","Precio","Cantidad disponible","Proveedor","Tipo Componente"};
		model.setColumnIdentifiers(headers);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 85, 727, 407);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
		});
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 727, 407);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int aux = table.getSelectedRow();
				if(aux!=-1){
					btnModificar.setEnabled(true);
					String code = (String) table.getValueAt(aux, 0);
			}
			}
		});
		scrollPane.setViewportView(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnModificar = new JButton("Modificar\r\n");
				btnModificar.setEnabled(false);
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(selected!=null){
							componenteNuevo cq = new componenteNuevo();
							cq.setVisible(true);
						}
					}
				});
				btnModificar.setActionCommand("OK");
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnModificar);
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
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		table.setModel(model);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Filtros", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 11, 727, 67);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				loadTable(comboBox.getSelectedIndex());
						
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"           <<Todos>>", "Tarjeta Madre", "Disco duro", "Memoria ram", "Microprocesador"}));
		comboBox.setBounds(54, 36, 150, 20);
		panel_1.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Tipo de componentes");
		lblNewLabel.setBounds(54, 11, 150, 14);
		panel_1.add(lblNewLabel);
		loadTable(0);
	}
	public void loadTable(int opcion) {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		String tipoCompo = "Todos";
		if(opcion == 0) {
			for (Componente componenter : Tienda.getInstance().getMiscomponentes()) {

				if(componenter instanceof Discoduro) {
					tipoCompo = "Disco duro";
				}		
				if(componenter instanceof TarjetaMadre) {
					tipoCompo = "Tarjeta Madre";
				}		
					
				if(componenter instanceof MemoriaRam) {
					tipoCompo = "Memoria ram";
				}
				if(componenter instanceof Microprocesador) {
					tipoCompo = "Microprocesador";
				}
				row[0] = componenter.getNombre();
				row[1] = componenter.getPrecio();
				row[2] = componenter.getCantidadDisponible();
				row[3]= componenter.getProveedor().getNombre();
				row[4] = tipoCompo;
				model.addRow(row);
			}
							
				}
		if(opcion == 1) {
			for (Componente componenter : Tienda.getInstance().getMiscomponentes()) {

				if(componenter instanceof Discoduro) {
					tipoCompo = "Disco duro";
				}		
				if(componenter instanceof TarjetaMadre) {
					tipoCompo = "Tarjeta Madre";
					row[0] = componenter.getNombre();
					row[1] = componenter.getPrecio();
					row[2] = componenter.getCantidadDisponible();
					row[3]= componenter.getProveedor().getNombre();
					row[4] = tipoCompo;
					model.addRow(row);
				}}}
		if(opcion == 2) {
			for (Componente componenter : Tienda.getInstance().getMiscomponentes()) {

				if(componenter instanceof Discoduro) {
					tipoCompo = "Disco duro";
					row[0] = componenter.getNombre();
					row[1] = componenter.getPrecio();
					row[2] = componenter.getCantidadDisponible();
					row[3]= componenter.getProveedor().getNombre();
					row[4] = tipoCompo;
					model.addRow(row);
				}}}
		if(opcion == 3) {
			for (Componente componenter : Tienda.getInstance().getMiscomponentes()) {

				if(componenter instanceof  MemoriaRam) {
					tipoCompo = "MemoriaRam";
					row[0] = componenter.getNombre();
					row[1] = componenter.getPrecio();
					row[2] = componenter.getCantidadDisponible();
					row[3]= componenter.getProveedor().getNombre();
					row[4] = tipoCompo;
					model.addRow(row);
				}}}
		if(opcion == 4) {
			for (Componente componenter : Tienda.getInstance().getMiscomponentes()) {

				if(componenter instanceof   Microprocesador) {
					tipoCompo = "Microprocesador";
					row[0] = componenter.getNombre();
					row[1] = componenter.getPrecio();
					row[2] = componenter.getCantidadDisponible();
					row[3]= componenter.getProveedor().getNombre();
					row[4] = tipoCompo;
					model.addRow(row);
				}}}
		
	}
}

