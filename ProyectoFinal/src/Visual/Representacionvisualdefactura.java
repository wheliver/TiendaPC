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
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

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
	 *//**
	public static void main(String[] args) {
		try {
			Representacionvisualdefactura dialog = new Representacionvisualdefactura();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/

	/*
	 * Create the dialog.
	 */
	public Representacionvisualdefactura() {
		setBounds(100, 100, 658, 578);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("    Factura de Venta");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 50));
		lblNewLabel.setBounds(121, 0, 400, 46);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CODIGO:");
		lblNewLabel_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		lblNewLabel_1.setBounds(63, 57, 56, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblCliente = new JLabel("CLIENTE:");
		lblCliente.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		lblCliente.setBounds(63, 95, 56, 14);
		contentPanel.add(lblCliente);
		
		JLabel lblVendedor = new JLabel("VENDEDOR:");
		lblVendedor.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		lblVendedor.setBounds(63, 137, 74, 14);
		contentPanel.add(lblVendedor);
		
		JLabel lblTipoDePago = new JLabel("Tipo de Pago:");
		lblTipoDePago.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		lblTipoDePago.setBounds(402, 69, 85, 14);
		contentPanel.add(lblTipoDePago);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		lblEstado.setBounds(409, 107, 72, 14);
		contentPanel.add(lblEstado);
		
		codigo = new JLabel("");
		codigo.setBounds(119, 57, 200, 14);
		contentPanel.add(codigo);
		
		cliente = new JLabel("");
		cliente.setBounds(119, 95, 200, 14);
		contentPanel.add(cliente);
		
		vendedor = new JLabel("");
		vendedor.setBounds(147, 137, 200, 14);
		contentPanel.add(vendedor);
		
		tipodepago = new JLabel("");
		tipodepago.setBounds(497, 69, 135, 14);
		contentPanel.add(tipodepago);
		
		estado = new JLabel("");
		estado.setBounds(456, 107, 166, 14);
		contentPanel.add(estado);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
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
				scrollPane2.setBounds(10, 184, 622, 286);
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
		lblTotal.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		lblTotal.setBounds(471, 481, 72, 14);
		contentPanel.add(lblTotal);
		
		total = new JLabel("");
		total.setBounds(520, 481, 112, 14);
		contentPanel.add(total);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(119, 82, 200, 2);
		contentPanel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(119, 120, 200, 2);
		contentPanel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(147, 162, 200, 2);
		contentPanel.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(Color.BLACK);
		separator_3.setBounds(497, 94, 135, 2);
		contentPanel.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBackground(Color.BLACK);
		separator_4.setBounds(456, 132, 166, 2);
		contentPanel.add(separator_4);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Representacionvisualdefactura.class.getResource("/Images/usuario.png")));
		lblNewLabel_2.setBounds(34, 85, 30, 24);
		contentPanel.add(lblNewLabel_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Representacionvisualdefactura.class.getResource("/Images/escaner-de-codigo-de-barras.png")));
		label.setBounds(34, 44, 30, 40);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Representacionvisualdefactura.class.getResource("/Images/vendedor.png")));
		label_1.setBounds(34, 129, 30, 33);
		contentPanel.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Representacionvisualdefactura.class.getResource("/Images/efectivo.png")));
		label_2.setBounds(374, 57, 30, 24);
		contentPanel.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Representacionvisualdefactura.class.getResource("/Images/estados-financieros.png")));
		label_3.setBounds(374, 96, 30, 24);
		contentPanel.add(label_3);
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
