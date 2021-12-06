package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import logico.Componente;
import logico.OrdenCompra;
import logico.Proveedor;
import logico.Tienda;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

public class OrdenCompraList extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static Object[] row;
	private static DefaultTableModel model;
	private OrdenCompra selected = null;
	private Componente selected1 = null;
	private Proveedor selected2 = null;
	private JScrollPane scrollPane;
	private JButton btnEstado;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Tienda.getInstance().cargarTienda();
			OrdenCompraList dialog = new OrdenCompraList();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public OrdenCompraList() {
		setTitle("Lista Orden Compra");
		setBounds(100, 100, 1019, 646);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		model = new DefaultTableModel();
		String [] headers = {"Codigo","Fecha","Tipo pago","Cantidad disponible","Estado"};
		model.setColumnIdentifiers(headers);
		
		
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 983, 552);
			contentPanel.add(scrollPane);
			{
				table = new JTable();
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				scrollPane.setViewportView(table);
				table.setModel(model);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnEstado = new JButton("");
				btnEstado.setEnabled(false);
				btnEstado.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(selected.getEstado().equalsIgnoreCase("Proceso"))
						{
							selected.setEstado("Confirmado");
							btnEstado.setEnabled(false);
							//Total(cantidad*preciunitario) se le sume a la cuenta por pagar 
							selected.getProveedor().setCuentaxpagar((selected.getCantidad()*selected.getPreciounitario())+ selected.getProveedor().getCuentaxpagar());
						}
						
						if(selected.getEstado().equalsIgnoreCase("Confirmado"))
						{
		
							selected.setEstado("Entregado");
							btnEstado.setEnabled(false);
							selected1.setCantidadDisponible(selected.getCantidad()+ selected1.getCantidadDisponible());
							selected.getProveedor().setCuentaxpagar(selected1.getProveedor().getCuentaxpagar()-(selected.getCantidad()*selected.getPreciounitario()));
						}
						if(selected.getEstado().equalsIgnoreCase("Entregado"))
						{
							btnEstado.setEnabled(false);
						}
						loadtable();
					}
				});
				btnEstado.setActionCommand("OK");
				buttonPane.add(btnEstado);
				getRootPane().setDefaultButton(btnEstado);
			}
			{
				btnSalir = new JButton("Salir");
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnSalir.setActionCommand("Cancel");
				buttonPane.add(btnSalir);
			}
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int aux = table.getSelectedRow();
					
					if(aux!=-1){
						selected = Tienda.getInstance().buscarOrdendecompra((String) table.getValueAt(aux, 0));
						selected1 = selected.getCompo();
						btnSalir.setEnabled(true);
						btnEstado.setEnabled(true);

						if(selected.getEstado().equalsIgnoreCase("Proceso"))
						{
							btnEstado.setText("Confirmar");
							btnEstado.setVisible(true);
							btnEstado.setEnabled(true);
						}
						if(selected.getEstado().equalsIgnoreCase("Confirmado"))
						{
							btnEstado.setText("Completar");
							btnEstado.setVisible(true);
							btnEstado.setEnabled(true);
						}
				}
					loadtable();
				}
				});
			
		}
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		table.setModel(model);
		loadtable();
	}
	public void loadtable(){
		model.setRowCount(0);
		 row = new Object[(model.getColumnCount())];
		 for (OrdenCompra pu : Tienda.getInstance().getMis_orden()){
			 row[0]=pu.getCodigo();
			    row[1]=pu.getFecha();
			    row[2] =pu.getTipodepago();
			    row[3] = pu.getCompo().getCantidadDisponible();
				row[4] =pu.getEstado();
				model.addRow(row);
			 
		 }
	}
	}


