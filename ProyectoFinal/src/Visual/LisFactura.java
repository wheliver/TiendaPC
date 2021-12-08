package Visual;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import logico.Factura;
import logico.Cliente;
import logico.Tienda;
import java.awt.Color;

public class LisFactura extends JDialog {

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
    private JButton btnCambiarEstado;

	/**
	 * Launch the application.
	 *//**
	public static void main(String[] args) {
		try {
			LisFactura dialog = new LisFactura();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LisFactura() {
		getContentPane().setBackground(Color.WHITE);
		setTitle("Listado de facturas");
		setBounds(100, 100, 755, 585);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		model = new DefaultTableModel();
		String [] headers = {"Codigo","Precio Total", "Cliente","Vendedor","Pagado"};
		model.setColumnIdentifiers(headers);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 495, 719, 40);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(620, 11, 89, 23);
		panel_1.add(btnSalir);
		
		btnver = new JButton("Ver");
		btnver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select = table.getSelectedRow();
				if(select!= -1) 
				{
					
				selected = Tienda.getInstance().buscarFacturaCodigo((String) table.getValueAt(select, 0));
				Representacionvisualdefactura rp = new Representacionvisualdefactura();
				rp.setCodigo(selected.getCodigo());
				rp.setCliente(selected.getCliente().getNombre());
				rp.setEstado(selected.isPagado());
				rp.setTipodepago(selected.getTipodepago());
				rp.setVendedor(selected.getVendedor().getNombre());
				rp.setTotal(String.valueOf(selected.getpreciototal()));
				rp.setCarrito1(selected.getMiscomponentes());
				rp.setCarrito2(selected.getMiscombos());
				rp.loadTable();
				rp.setVisible(true);
				
			}
			}
		});
		btnver.setEnabled(false);
		btnver.setBounds(521, 11, 89, 23);
		panel_1.add(btnver);
		
		btnCambiarEstado = new JButton("");
		btnCambiarEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selected.Pagado() == false)
				{
					selected.setPagado(true);
					btnCambiarEstado.setVisible(false);
					JOptionPane.showMessageDialog(null,"La factura del cliente fue pagada");
				}
				
			}

		});
		btnCambiarEstado.setEnabled(false);
		btnCambiarEstado.setBounds(362, 11, 149, 23);
		panel_1.add(btnCambiarEstado);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
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
		});
		btnBuscar.setBounds(459, 11, 118, 23);
		panel_2.add(btnBuscar);
		
		textFieldCedula = new JTextField();
		textFieldCedula.setBounds(198, 12, 251, 20);
		panel_2.add(textFieldCedula);
		textFieldCedula.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 65, 719, 424);
		contentPanel.add(scrollPane);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int aux = table.getSelectedRow();
				if(aux!=-1){
					btnSalir.setEnabled(true);
					btnver.setEnabled(true);
					btnCambiarEstado.setEnabled(true);

					if(selected.isPagado() == false)
					{
						btnCambiarEstado.setText("Pagar");
						btnCambiarEstado.setVisible(true);
					}
					else {
						btnCambiarEstado.setEnabled(false);
						btnCambiarEstado.setVisible(false);
					}
					
					String code = (String) table.getValueAt(aux, 0);
			}
			}
			});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		table.setModel(model);
	
	}
	public void loadTable (Cliente clientt) {
	model.setRowCount(0);
	 row = new Object[(model.getColumnCount())];
	 
	if(clientt==null) {
		JOptionPane.showMessageDialog(null,"ESTE CLIENTE NUNCA A REALIZADO UNA COMPRA POR FAVOR COMPRE PARA TENER FACTURAS");
	}else{
		 for (Factura pu : Tienda.getInstance().getMisfacturas()){
			
			 if(pu.getCliente().getCedula().equalsIgnoreCase(clientt.getCedula()) ) {
			row[0]=pu.getCodigo();
		    row[1]=pu.getpreciototal();
			row[2] =pu.getCliente().getNombre();
			row[3] =pu.getVendedor().getNombre();
			row[4] =pu.Pagado();
			model.addRow(row);
			}
			 
		}}
	 
}
}
