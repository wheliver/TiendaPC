package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;

public class Factura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private Object[] row;
	private DefaultTableModel model;
	private JButton salirButton;
	private JButton btnModificar_1;
	private JButton btnEliminar;

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
		setBounds(100, 100, 557, 466);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 521, 354);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 521, 354);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int aux = table.getSelectedRow();
				if(aux!=-1){
					btnEliminar.setEnabled(true);
					btnModificar_1.setEnabled(true);
					String code = (String) table.getValueAt(aux, 0);
			}
			}
			});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		model = new DefaultTableModel();
		String [] headers = {"Codigo","Precio Total", "Cliente","Tipo de pago"};
		model.setColumnIdentifiers(headers);
		table.setModel(model);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 376, 521, 40);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(422, 11, 89, 23);
		panel_1.add(btnEliminar);
		
		btnModificar_1 = new JButton("Modificar");
		btnModificar_1.setEnabled(false);
		btnModificar_1.setBounds(323, 11, 89, 23);
		panel_1.add(btnModificar_1);
		{
	}
	}	
}
