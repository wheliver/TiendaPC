package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import logico.Cliente;
import logico.Factura;
import logico.Tienda;

import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;

public class Factura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static Object[] row;
	private static DefaultTableModel model;
	private JButton salirButton;
	private JButton btnver;
	private JButton btnSalir;
	private JTextField textFieldCedula;
	private JButton btnBuscar;
    private Factura selected = null; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Factura dialog = new Factura();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Factura() {
		setTitle("Listado de facturas");
		setBounds(100, 100, 755, 585);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 65, 719, 424);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 720, 478);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int aux = table.getSelectedRow();
				if(aux!=-1){
					btnSalir.setEnabled(true);
					btnver.setEnabled(true);
					String code = (String) table.getValueAt(aux, 0);
			}
			}
			});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		model = new DefaultTableModel();
		String [] headers = {"Codigo","Precio Total", "Cliente","Vendedor","Pagado"};
		model.setColumnIdentifiers(headers);
		table.setModel(model);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 495, 719, 40);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(620, 11, 89, 23);
		panel_1.add(btnSalir);
		
		btnver = new JButton("Ver");
		btnver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select = table.getSelectedRow();
				if(select!= -1) 
				{
				selected = Tienda.getInstance().buscarFacturaCodigo((String) table.getValueAt(select, 0));
				 ArrayList<String> rr = new  ArrayList<String>();
				 String tipo="";
				
			}
			}
		});
		btnver.setEnabled(false);
		btnver.setBounds(521, 11, 89, 23);
		panel_1.add(btnver);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Introduzca la cedula del cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 11, 719, 43);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		
		btnBuscar = new JButton("Buscar Cliente");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldCedula.getText()=="") {
					JOptionPane.showMessageDialog(null,"Por favor introducir su cedula para ver sus facturas");
				}else {
					Cliente clientt = Tienda.getInstance().BuscarCliente(textFieldCedula.getText());
				loadTable(clientt);
				}
			}

	public void loadTable (Cliente clientt) {
	model.setRowCount(0);
	 row = new Object[(model.getColumnCount())];
	 
	if(clientt==null) {
		JOptionPane.showMessageDialog(null,"ESTE CLIENTE NUNCA A REALIZADO UNA COMPRA POR FAVOR COMPRE PARA TENER FACTURAS");
	}else{
		 for (logico.Factura pu : Tienda.getInstance().getMisfacturas()){
			
			 if(pu.getCliente().getCedula().equalsIgnoreCase(clientt.getCedula()) ) {
			row[0]=pu.getCodigo();
		    row[1]=pu.getpreciototal();
			row[2] =pu.getCliente().getNombre();
			row[3] =pu.getVendedor().getNombre();
			row[4] =pu.isPagado();
			model.addRow(row);
			}
			 
		}}
	 
}
		});
		btnBuscar.setBounds(459, 11, 118, 23);
		panel_2.add(btnBuscar);
		
		textFieldCedula = new JTextField();
		textFieldCedula.setBounds(198, 12, 251, 20);
		panel_2.add(textFieldCedula);
		textFieldCedula.setColumns(10);
		{
	}
	}	
}
