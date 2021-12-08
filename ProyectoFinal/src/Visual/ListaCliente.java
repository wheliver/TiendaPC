package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Cliente;
import logico.Componente;
import logico.Tienda;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Cursor;

public class ListaCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static Object[] row;
	private static DefaultTableModel model;
	private JScrollPane scrollPane;
	private JButton btnModificar;
	private Cliente selected = null;
	private JButton cancelButton;
	private JButton btnAgregarCliente;

	/**
	 * Launch the application.
	 *//**
	public static void main(String[] args) {
		try {
			Tienda.getInstance().cargarTienda();
			ListaCliente dialog = new ListaCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaCliente() {
		setTitle("Listado de clientes\r\n");
		setBounds(100, 100, 671, 657);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		model = new DefaultTableModel();
		String [] headers = {"Nombre","Direccion","Telefono","RNC","Cedula"};
		model.setColumnIdentifiers(headers);
		row = new Object[model.getColumnCount()];
		for (Cliente pu : Tienda.getInstance().getMisclientes()){
			 row[0]=pu.getNombre();
			    row[1]=pu.getDireccion();
			    row[2] =pu.getTelefono();
			    row[3] = pu.getRnc();
			    row[4] = pu.getCedula();
				model.addRow(row);
			 
		 }
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 635, 558);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 635, 558);
		panel.add(scrollPane);
		
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int aux = table.getSelectedRow();
				if(aux!=-1){
					btnModificar.setEnabled(true);
					String code = (String) table.getValueAt(aux, 0);
					selected = Tienda.getInstance().buscarCliente(code);
			}
			}
		});
		scrollPane.setViewportView(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnModificar = new JButton("Modificar");
				btnModificar.setEnabled(false);
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
							ModificarCliente reg = new ModificarCliente();
							reg.setVisible(true);
						}
				});
				
				btnAgregarCliente = new JButton("Agregar Cliente");
				btnAgregarCliente.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						RegistroCliente reg = new RegistroCliente();
						reg.setVisible(true);
					}
				});
				
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblNewLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						loadTable();
					}
				});
				lblNewLabel.setIcon(new ImageIcon(ListaCliente.class.getResource("/Images/refresh.png")));
				buttonPane.add(lblNewLabel);
				buttonPane.add(btnAgregarCliente);
				btnModificar.setActionCommand("OK");
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnModificar);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane.setViewportView(table);
			table.setModel(model);
		}
	}

	protected void loadTable() {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		for (int i = 0 ; i < Tienda.getInstance().getMisclientes().size();i++) 
		{
			row[0] = Tienda.getInstance().getMisclientes().get(i).getNombre();
			row[1] = Tienda.getInstance().getMisclientes().get(i).getDireccion();
			row[2] = Tienda.getInstance().getMisclientes().get(i).getTelefono();
			row[3] = Tienda.getInstance().getMisclientes().get(i).getRnc();
			row[4] = Tienda.getInstance().getMisclientes().get(i).getCedula();
			model.addRow(row);
		}
	}
}

