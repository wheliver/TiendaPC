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
import javax.swing.table.DefaultTableModel;

import logico.Componente;
import logico.Discoduro;
import logico.MemoriaRam;
import logico.Microprocesador;
import logico.TarjetaMadre;
import logico.Tienda;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Representacionvisualdefactura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel estado;
	private JLabel tipodepago;
	private JLabel vendedor;
	private JLabel cliente;
	private JLabel codigo;
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] row;
	private JLabel total;
	private ArrayList<auxiliarCarrito> carrito1 = new ArrayList<auxiliarCarrito>();
	private ArrayList<auxiliarCarito2> carrito2 = new ArrayList<auxiliarCarito2>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Representacionvisualdefactura dialog = new Representacionvisualdefactura();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Representacionvisualdefactura() {
		setBounds(100, 100, 658, 530);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("    Factura de Venta");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 50));
		lblNewLabel.setBounds(143, 11, 400, 55);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CODIGO:");
		lblNewLabel_1.setBounds(10, 69, 46, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblCliente = new JLabel("CLIENTE:");
		lblCliente.setBounds(10, 94, 46, 14);
		contentPanel.add(lblCliente);
		
		JLabel lblVendedor = new JLabel("VENDEDOR:");
		lblVendedor.setBounds(10, 119, 72, 14);
		contentPanel.add(lblVendedor);
		
		JLabel lblTipoDePago = new JLabel("Tipo de Pago");
		lblTipoDePago.setBounds(409, 69, 72, 14);
		contentPanel.add(lblTipoDePago);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(409, 94, 72, 14);
		contentPanel.add(lblEstado);
		
		codigo = new JLabel("");
		codigo.setBounds(66, 69, 46, 14);
		contentPanel.add(codigo);
		
		cliente = new JLabel("");
		cliente.setBounds(66, 94, 46, 14);
		contentPanel.add(cliente);
		
		vendedor = new JLabel("");
		vendedor.setBounds(76, 119, 46, 14);
		contentPanel.add(vendedor);
		
		tipodepago = new JLabel("");
		tipodepago.setBounds(316, 69, 46, 14);
		contentPanel.add(tipodepago);
		
		estado = new JLabel("");
		estado.setBounds(289, 94, 46, 14);
		contentPanel.add(estado);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
			{
				JScrollPane scrollPane2 = new JScrollPane();
				scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				scrollPane2.setBounds(10, 155, 622, 261);
				contentPanel.add(scrollPane2, BorderLayout.CENTER);
				
				table = new JTable();
				
				model = new DefaultTableModel();
				String[] headers = {"Nombre","Precio por unidad ","Cantidad Comprada","Proveedor","Tipo Componente"};
				model.setColumnIdentifiers(headers);
				table.setModel(model);
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			    scrollPane2.setViewportView(table);
				}
		}
		
		JLabel lblTotal = new JLabel("TOTAL:");
		lblTotal.setBounds(471, 427, 72, 14);
		contentPanel.add(lblTotal);
		
		total = new JLabel("");
		total.setBounds(316, 427, 46, 14);
		contentPanel.add(total);
		loadTable();
	}
	public void loadTable () {
		model.setRowCount(0);
		 row = new Object[(model.getColumnCount())];
		String tipoCompo = null;
		 for (auxiliarCarito2 pu : carrito2){
				tipoCompo="Combo";
			 row[0]=pu.getCarrito().getNombre();
				row[1]=pu.getCarrito().getPrecio();
			    row[2]=pu.getCantidad();
			    row[3]="Tienda";
			    row[4] = tipoCompo;
				model.addRow(row);
				}
		 for (auxiliarCarrito pu : carrito1){
			Componente componenter = pu.getCarrito();
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
				row[0]=pu.getCarrito().getNombre();
				row[1]=pu.getCarrito().getPrecio();
			    row[2]=pu.getCantidad();
			    row[3]=pu.getCarrito().getProveedor().getNombre();
			    row[4] = tipoCompo;
				model.addRow(row);
				}
				}

	public void setEstado(boolean estado1) {
		if (estado1 == true) {
			estado.setText("Pagada");
		}else {
			estado.setText("Pendiente");
		}
		
		
	}

	public void setTipodepago(String tipodepago1) {
		tipodepago.setText(tipodepago1);
	}

	public void setVendedor(String vendedor1) {
		this.vendedor.setText( vendedor1);
	}

	public void setCliente(String cliente1) {
		this.cliente.setText( cliente1);
	}

	public void setCodigo(String codigo1) {
		this.codigo.setText( codigo1);
	}

	public void setTotal(String total1) {
		this.total.setText( total1);
	}

	public void setCarrito1(ArrayList<auxiliarCarrito> carrito1) {
		this.carrito1 = carrito1;
	}

	public void setCarrito2(ArrayList<auxiliarCarito2> carrito2) {
		this.carrito2 = carrito2;
	}
}
