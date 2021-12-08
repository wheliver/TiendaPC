package Visual;

import java.awt.BorderLayout;
import java.awt.Component;
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

import logico.Cliente;
import logico.Combos;
import logico.Componente;
import logico.Discoduro;
import logico.Factura;
import logico.MemoriaRam;
import logico.Microprocesador;
import logico.TarjetaMadre;
import logico.Tienda;
import logico.Usuario;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Ventas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton RegistrarButton;
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] row;
	private static Componente selected = null;
	private static Combos selected1 = null;
	private JButton agregar;
	private JLabel indentificador;
	private JScrollPane scrollPane;
	private JButton quitar;
	private JLabel PrecioProcesador;
	private JLabel PrecioRam;
	private JLabel PrecioDisco;
	private JLabel PrecioTargeta;
	private JLabel PrecioCombo;
	private JComboBox comboprocesador;
	private JComboBox comboram;
	private JSpinner spndisco;
	private JSpinner spnram;
	private JSpinner spnprocesador;
	private JComboBox combodisco;
	private JComboBox combotargeta;
	private JComboBox combo;
	private JSpinner spncombo;
	private JSpinner spntargeta;
	private ArrayList<auxiliarCarrito> carrito1 = new ArrayList<auxiliarCarrito>();
	private ArrayList<auxiliarCarito2> carrito2 = new ArrayList<auxiliarCarito2>();
	private  Usuario user=null;
	private JButton cancelButton;
	private JButton GuardarCombobutton;

	/**
	 * Launch the application.
	 */
	/**
	public static void main(String[] args) {
		try {
			Ventas dialog = new Ventas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
**/
	/**
	 * Create the dialog.
	 */
	public Ventas() {
		setTitle("Venta Combos");
		setBounds(100, 100, 803, 458);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Eleccion de componentes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 767, 359);
		contentPanel.add(panel);
		panel.setLayout(null);
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(null);
		panel_2.setBounds(346, 25, 400, 312);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		agregar = new JButton("Agregar");
		agregar.setEnabled(false);
		agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Componente c =null;
				int cambio=0;
				Combos d=null;
				auxiliarCarito2 e1 = new auxiliarCarito2(0, null);
				auxiliarCarrito b= new auxiliarCarrito(0, null),b1= new auxiliarCarrito(0, null),b2= new auxiliarCarrito(0, null),b3 = new auxiliarCarrito(0, null);
				boolean aux = false;
				
				if( Integer.valueOf(spncombo.getValue().toString())>0) {
					
				 d = Tienda.getInstance().buscarcombo(combo.getSelectedItem().toString());	
							 for (auxiliarCarito2 a : carrito2) {
						 if(d==a.getCarrito()) {
							 cambio = a.getCantidad();
							 
							 boolean comprobar=true ;
							 for (Componente compi : d.getMiscomponentes()) {
								 c = Tienda.getInstance().buscarcomponente(compi.getNombre());	
								 if(compi instanceof TarjetaMadre) {
											if(c.getCantidadDisponible()-(cambio+Integer.valueOf(spncombo.getValue().toString()))>=c.getCantidadminima()) {
										}else {
											comprobar = false ;
											 JOptionPane.showMessageDialog(null,"No hay suficientes componentes para hacer el cambio en el pedido por favor escojer una sifra menor o igual que :"+String.valueOf(c.getCantidadDisponible()-c.getCantidadminima())+"para la targeta");

											}
										}
										if(compi instanceof MemoriaRam) {
											if(c.getCantidadDisponible()-(cambio+Integer.valueOf(spncombo.getValue().toString()))>=c.getCantidadminima()) {
											}else {
												comprobar = false ;
												 JOptionPane.showMessageDialog(null,"No hay suficientes componentes para hacer el cambio en el pedido por favor escojer una sifra menor o igual que :"+String.valueOf(c.getCantidadDisponible()-c.getCantidadminima())+"para la MemoriaRam");

												}	
											}
										
										 if(compi instanceof Microprocesador) {
												if(c.getCantidadDisponible()-(cambio+Integer.valueOf(spncombo.getValue().toString()))>=c.getCantidadminima()) {
												}else {
													comprobar = false ;
													 JOptionPane.showMessageDialog(null,"No hay suficientes componentes para hacer el cambio en el pedido por favor escojer una sifra menor o igual que :"+String.valueOf(c.getCantidadDisponible()-c.getCantidadminima())+"para el microprosesador");

													}
												}
										 if(compi instanceof Discoduro) {
												if(c.getCantidadDisponible()-(cambio+Integer.valueOf(spncombo.getValue().toString()))>=c.getCantidadminima()) {
												}else {
													comprobar = false ;
													 JOptionPane.showMessageDialog(null,"No hay suficientes componentes para hacer el cambio en el pedido por favor escojer una sifra menor o igual que :"+String.valueOf(c.getCantidadDisponible()-c.getCantidadminima())+"para el disco");

													}
												}}
							 	if(comprobar==true) {								
							  carrito2.remove(a);
							 e1.setCarrito(d);
								e1.setCantidad(cambio+Integer.valueOf(spncombo.getValue().toString()));
								 carrito2.add(e1);
								 aux=true;}
						}
					}
					 if(aux==false) {
						 
						 boolean comprobar=true ;
						 for (Componente compi : d.getMiscomponentes()) {
							 c = Tienda.getInstance().buscarcomponente(compi.getNombre());	
							 if(compi instanceof TarjetaMadre) {
										if(c.getCantidadDisponible()-(Integer.valueOf(spncombo.getValue().toString()))>=c.getCantidadminima()) {
									}else {
										comprobar = false ;
										 JOptionPane.showMessageDialog(null,"No hay suficientes componentes para hacer el cambio en el pedido por favor escojer una sifra menor o igual que :"+String.valueOf(c.getCantidadDisponible()-c.getCantidadminima())+"para la targeta");

										}
									}
									if(compi instanceof MemoriaRam) {
										if(c.getCantidadDisponible()-(Integer.valueOf(spncombo.getValue().toString()))>=c.getCantidadminima()) {
										}else {
											comprobar = false ;
											 JOptionPane.showMessageDialog(null,"No hay suficientes componentes para hacer el cambio en el pedido por favor escojer una sifra menor o igual que :"+String.valueOf(c.getCantidadDisponible()-c.getCantidadminima())+"para la MemoriaRam");

											}	
										}
									
									 if(compi instanceof Microprocesador) {
											if(c.getCantidadDisponible()-(Integer.valueOf(spncombo.getValue().toString()))>=c.getCantidadminima()) {
											}else {
												comprobar = false ;
												 JOptionPane.showMessageDialog(null,"No hay suficientes componentes para hacer el cambio en el pedido por favor escojer una sifra menor o igual que :"+String.valueOf(c.getCantidadDisponible()-c.getCantidadminima())+"para el microprosesador");

												}
											}
									 if(compi instanceof Discoduro) {
											if(c.getCantidadDisponible()-(Integer.valueOf(spncombo.getValue().toString()))>=c.getCantidadminima()) {
											}else {
												comprobar = false ;
												 JOptionPane.showMessageDialog(null,"No hay suficientes componentes para hacer el cambio en el pedido por favor escojer una sifra menor o igual que :"+String.valueOf(c.getCantidadDisponible()-c.getCantidadminima())+"para el disco");

												}
											}}
						 
						 if(comprobar==true) {
						  e1.setCarrito(d);
						 e1.setCantidad(Integer.valueOf(spncombo.getValue().toString()));
						 carrito2.add(e1);
						 }
					 }
								}
				cambio=0;
				aux=false;
				
				if( Integer.valueOf(spndisco.getValue().toString())>0) {
					 c = Tienda.getInstance().buscarcomponente(combodisco.getSelectedItem().toString());	
							 for (auxiliarCarrito a : carrito1) {
								 if(c==a.getCarrito()) {
									 cambio = a.getCantidad();
									 if(c.getCantidadDisponible()-(cambio+Integer.valueOf(spndisco.getValue().toString()))>=c.getCantidadminima()) {
									carrito1.remove(a);
									 b.setCarrito(c);
										b.setCantidad(cambio+Integer.valueOf(spndisco.getValue().toString()));
										 carrito1.add(b);
									
										aux=true;}else {
											 JOptionPane.showMessageDialog(null,"No hay suficientes componentes para hacer el cambio en el pedido por favor escojer una sifra menor o igual que :"+String.valueOf(c.getCantidadDisponible()-c.getCantidadminima())+"para el disco");

										 }
									}
							}
					 if(aux==false) {
						 JOptionPane.showMessageDialog(null,"entre");

						 if(c.getCantidadDisponible()-(Integer.valueOf(spndisco.getValue().toString()))>=c.getCantidadminima()) {
								
							 b.setCarrito(c);
								b.setCantidad(Integer.valueOf(spndisco.getValue().toString()));
								 carrito1.add(b);
								 JOptionPane.showMessageDialog(null,"llene");
								 JOptionPane.showMessageDialog(null,carrito1.get(0).getCantidad());
								 JOptionPane.showMessageDialog(null,carrito1.get(0).getCarrito().getNombre());
						 }else {
									 JOptionPane.showMessageDialog(null,"No hay suficientes componentes para el pedido por favor escojer una sifra menor o igual que :"+String.valueOf(c.getCantidadDisponible()-c.getCantidadminima())+"para el disco");

								 }
					 }
								}
				
				cambio=0;
				aux=false;
			
				if( Integer.valueOf(spntargeta.getValue().toString())>0) {
					 c = Tienda.getInstance().buscarcomponente(combotargeta.getSelectedItem().toString());	
					 for (auxiliarCarrito a : carrito1) {
						 if(c==a.getCarrito()) {
							 cambio = a.getCantidad();
							 if(c.getCantidadDisponible()-(cambio+Integer.valueOf(spntargeta.getValue().toString()))>=c.getCantidadminima()) {
							carrito1.remove(a);
							 b1.setCarrito(c);
								b1.setCantidad(cambio+Integer.valueOf(spntargeta.getValue().toString()));
								 carrito1.add(b1);
							
								aux=true;}else {
									 JOptionPane.showMessageDialog(null,"No hay suficientes componentes para hacer el cambio en el pedido por favor escojer una sifra menor o igual que :"+String.valueOf(c.getCantidadDisponible()-c.getCantidadminima())+"para la targeta");

								 }
							}
					}
					 if(aux==false) {
						// 
						 if(c.getCantidadDisponible()-(Integer.valueOf(spntargeta.getValue().toString()))>=c.getCantidadminima()) {
							
					 b1.setCarrito(c);
						b1.setCantidad(Integer.valueOf(spntargeta.getValue().toString()));
						 carrito1.add(b1);}else {
							 JOptionPane.showMessageDialog(null,"No hay suficientes componentes para el pedido por favor escojer una sifra menor o igual que :"+String.valueOf(c.getCantidadDisponible()-c.getCantidadminima())+"para la targeta");

						 }
					 }
				}
				cambio=0;
				aux=false;
				
				if( Integer.valueOf(spnram.getValue().toString())>0) {
					 c = Tienda.getInstance().buscarcomponente(comboram.getSelectedItem().toString());	
					 for (auxiliarCarrito a : carrito1) {
						 if(c==a.getCarrito()) {
							 cambio = a.getCantidad();
							 if(c.getCantidadDisponible()-(cambio+Integer.valueOf(spnram.getValue().toString()))>=c.getCantidadminima()) {
							carrito1.remove(a);
							 b2.setCarrito(c);
								b2.setCantidad(cambio+Integer.valueOf(spnram.getValue().toString()));
								 carrito1.add(b2);
							
								aux=true;}else {
									 JOptionPane.showMessageDialog(null,"No hay suficientes componentes para hacer el cambio en el pedido por favor escojer una sifra menor o igual que :"+String.valueOf(c.getCantidadDisponible()-c.getCantidadminima())+"para la MemoriaRam");

								 }
							}
					}
					 if(aux==false) {
						 if(c.getCantidadDisponible()-(Integer.valueOf(spnram.getValue().toString()))>=c.getCantidadminima()) {
								
							 b2.setCarrito(c);
								b2.setCantidad(Integer.valueOf(spnram.getValue().toString()));
								 carrito1.add(b2);}else {
									 JOptionPane.showMessageDialog(null,"No hay suficientes componentes para el pedido por favor escojer una sifra menor o igual que :"+String.valueOf(c.getCantidadDisponible()-c.getCantidadminima())+"para la MemoriaRam");

								 }
					 }
				}
				cambio=0;
				aux=false;
				
				if( Integer.valueOf(spnprocesador.getValue().toString())>0) {
					 c = Tienda.getInstance().buscarcomponente(comboprocesador.getSelectedItem().toString());	
					 for (auxiliarCarrito a : carrito1) {
						 if(c==a.getCarrito()) {
							 cambio = a.getCantidad();
							 if(c.getCantidadDisponible()-(cambio+Integer.valueOf(spnprocesador.getValue().toString()))>=c.getCantidadminima()) {
							carrito1.remove(a);
							 b3.setCarrito(c);
								b3.setCantidad(cambio+Integer.valueOf(spnprocesador.getValue().toString()));
								 carrito1.add(b3);
						
								aux=true;}else {
									 JOptionPane.showMessageDialog(null,"No hay suficientes componentes para hacer el cambio en el pedido por favor escojer una sifra menor o igual que :"+String.valueOf(c.getCantidadDisponible()-c.getCantidadminima())+"para el procesador");

								 }
							}
					}
					 if(aux==false) {
						 if(c.getCantidadDisponible()-(Integer.valueOf(spnprocesador.getValue().toString()))>=c.getCantidadminima()) {
								
							 b3.setCarrito(c);
								b3.setCantidad(Integer.valueOf(spnprocesador.getValue().toString()));
								 carrito1.add(b3);}else {
									 JOptionPane.showMessageDialog(null,"No hay suficientes componentes para el pedido por favor escojer una sifra menor o igual que :"+String.valueOf(c.getCantidadDisponible()-c.getCantidadminima())+"para el Microprocesador");

								 }
					 }
				}
				aux=false;
							
				loadTable();
				limpiar();
						
				indentificador.setText("Componentes Agregados");
				
				
			}
		});
		agregar.setBounds(10, 278, 89, 23);
		panel_2.add(agregar);
		agregar.setVisible(false);
		
		indentificador = new JLabel("");
		indentificador.setBackground(Color.WHITE);
		indentificador.setEnabled(false);
		indentificador.setBounds(208, 278, 183, 23);
		panel_2.add(indentificador);
		indentificador.setVisible(false);
		{
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 6, 381, 261);
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int select = table.getSelectedRow();
				if(select!= -1) 
				{
					
					selected = Tienda.getInstance().buscarcomponente((String) table.getValueAt(select, 0));
					selected1=Tienda.getInstance().buscarcombo((String) table.getValueAt(select, 0));
					quitar.setVisible(true);
					quitar.setEnabled(true);
					indentificador.setEnabled(true);
					indentificador.setVisible(true);
									
				}else {
					quitar.setVisible(false);
					quitar.setEnabled(false);
					indentificador.setEnabled(false);
					indentificador.setVisible(false);
				}
			}
		});
		model = new DefaultTableModel();
		String[] headers = {"Nombre","Cantidad:","Precio Total"};
		model.setColumnIdentifiers(headers);
		table.setModel(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    scrollPane.setViewportView(table);
		}
		
		quitar = new JButton("Quitar");
		quitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selected != null) {
				 for (auxiliarCarrito a : carrito1) {
					 if(selected==a.getCarrito()) {
						carrito1.remove(a);
						}
					 }}
				 if(selected1 != null) {
				 for (auxiliarCarito2 b : carrito2) {
					 if(selected1==b.getCarrito()) {
						carrito2.remove(b);
						}
					 }}
				 loadTable();
			}
		});
		quitar.setEnabled(false);
		quitar.setBounds(109, 278, 89, 23);
		panel_2.add(quitar);
		quitar.setVisible(false);
		
		combo = new JComboBox();
		combo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(combo.getSelectedItem().toString() !="                        Seleccionar") {
					spncombo.setEnabled(true);
					spncombo.setValue(0);
					
					Combos c = Tienda.getInstance().buscarcombo(combo.getSelectedItem().toString());				
					PrecioCombo.setText(String.valueOf(c.getPrecio()));
					
					agregar.setEnabled(true);
				}else {
					spncombo.setEnabled(false);
					agregar.setEnabled(false);
					PrecioCombo.setText("");
				}
			}
		});
		combo.setModel(new DefaultComboBoxModel(new String[] {"                        Seleccionar"}));
		combo.setBounds(10, 75, 196, 20);
		panel.add(combo);
		
		combotargeta = new JComboBox();
		combotargeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(combotargeta.getSelectedItem().toString() !="                        Seleccionar") {
					spntargeta.setEnabled(true);
					spntargeta.setValue(0);
					Componente c = Tienda.getInstance().buscarcomponente(combotargeta.getSelectedItem().toString());				
					PrecioTargeta.setText(String.valueOf(c.getPrecio()));
					agregar.setEnabled(true);
				}else {
					spntargeta.setEnabled(false);
					agregar.setEnabled(false);
					PrecioTargeta.setText("");
				}
			}
		});
		combotargeta.setModel(new DefaultComboBoxModel(new String[] {"                        Seleccionar"}));
		combotargeta.setBounds(10, 131, 196, 20);
		panel.add(combotargeta);
		
		combodisco = new JComboBox();
		combodisco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(combodisco.getSelectedItem().toString() !="                        Seleccionar") {
					spndisco.setEnabled(true);
					spndisco.setValue(0);
					Componente c = Tienda.getInstance().buscarcomponente(combodisco.getSelectedItem().toString());				
					PrecioDisco.setText(String.valueOf(c.getPrecio()));
					agregar.setEnabled(true);
				}else {
					spndisco.setEnabled(false);
					agregar.setEnabled(false);
					PrecioDisco.setText("");
				}
			}
		});
		combodisco.setModel(new DefaultComboBoxModel(new String[] {"                        Seleccionar"}));
		combodisco.setBounds(10, 189, 196, 20);
		panel.add(combodisco);
		
		comboram = new JComboBox();
		comboram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboram.getSelectedItem().toString() !="                        Seleccionar") {
					spnram.setEnabled(true);
					spnram.setValue(0);
					Componente c = Tienda.getInstance().buscarcomponente(comboram.getSelectedItem().toString());				
					PrecioRam.setText(String.valueOf(c.getPrecio()));
					agregar.setEnabled(true);
				}else {
					spnram.setEnabled(false);
					agregar.setEnabled(false);
					PrecioRam.setText("");
				}
			}
		});
		comboram.setModel(new DefaultComboBoxModel(new String[] {"                        Seleccionar"}));
		comboram.setBounds(10, 243, 196, 20);
		panel.add(comboram);
		
		comboprocesador = new JComboBox();
		comboprocesador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboprocesador.getSelectedItem().toString() !="                        Seleccionar") {
					spnprocesador.setEnabled(true);
					spnprocesador.setValue(0);
					Componente c = Tienda.getInstance().buscarcomponente(comboprocesador.getSelectedItem().toString());				
					PrecioProcesador.setText(String.valueOf(c.getPrecio()));
					agregar.setEnabled(true);
				}else {
					spnprocesador.setEnabled(false);
					agregar.setEnabled(false);
					PrecioProcesador.setText("");
				}
			}
		});
		comboprocesador.setModel(new DefaultComboBoxModel(new String[] {"                        Seleccionar"}));
		comboprocesador.setBounds(10, 296, 196, 20);
		panel.add(comboprocesador);
		
		JLabel lblNewLabel = new JLabel("Combos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		lblNewLabel.setBounds(68, 50, 67, 14);
		panel.add(lblNewLabel);
		
		JLabel lblTarjetaMadre = new JLabel("Tarjeta madre");
		lblTarjetaMadre.setHorizontalAlignment(SwingConstants.CENTER);
		lblTarjetaMadre.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		lblTarjetaMadre.setBounds(68, 106, 89, 14);
		panel.add(lblTarjetaMadre);
		
		JLabel lblDiscoDuro = new JLabel("Disco duro");
		lblDiscoDuro.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		lblDiscoDuro.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiscoDuro.setBounds(68, 164, 67, 14);
		panel.add(lblDiscoDuro);
		
		JLabel lblMemoriaRam = new JLabel("Memoria Ram");
		lblMemoriaRam.setHorizontalAlignment(SwingConstants.CENTER);
		lblMemoriaRam.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		lblMemoriaRam.setBounds(56, 220, 101, 14);
		panel.add(lblMemoriaRam);
		
		JLabel lblMicroprocesador = new JLabel("Microprocesador");
		lblMicroprocesador.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		lblMicroprocesador.setBounds(56, 274, 120, 14);
		panel.add(lblMicroprocesador);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(334, 11, 423, 337);
		panel.add(panel_1);
		panel_1.setBorder(null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Precio:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(266, 50, 46, 14);
		panel.add(lblNewLabel_1);
		
		PrecioCombo = new JLabel("");
		PrecioCombo.setBounds(266, 78, 46, 14);
		panel.add(PrecioCombo);
		
		PrecioTargeta = new JLabel("");
		PrecioTargeta.setBounds(266, 134, 46, 14);
		panel.add(PrecioTargeta);
		
		PrecioDisco = new JLabel("");
		PrecioDisco.setBounds(266, 192, 46, 14);
		panel.add(PrecioDisco);
		
		PrecioRam = new JLabel("");
		PrecioRam.setBounds(266, 246, 46, 14);
		panel.add(PrecioRam);
		
		PrecioProcesador = new JLabel("");
		PrecioProcesador.setBounds(266, 299, 46, 14);
		panel.add(PrecioProcesador);
		
		spncombo = new JSpinner();
		spncombo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				agregar.setVisible(true);
				agregar.setEnabled(true);
			}
		});
		spncombo.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spncombo.setEnabled(false);
		spncombo.setBounds(216, 75, 29, 20);
		panel.add(spncombo);
		
		spntargeta = new JSpinner();
		spntargeta.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spntargeta.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				agregar.setVisible(true);
				agregar.setEnabled(true);
			}
		});
		spntargeta.setEnabled(false);
		spntargeta.setBounds(216, 131, 29, 20);
		panel.add(spntargeta);
		
		spndisco = new JSpinner();
		spndisco.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spndisco.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				agregar.setVisible(true);
				agregar.setEnabled(true);
			}
		});
		spndisco.setEnabled(false);
		spndisco.setBounds(216, 189, 29, 20);
		panel.add(spndisco);
		
		spnram = new JSpinner();
		spnram.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnram.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				agregar.setVisible(true);
				agregar.setEnabled(true);
			}
		});
		spnram.setEnabled(false);
		spnram.setBounds(216, 243, 29, 20);
		panel.add(spnram);
		
		spnprocesador = new JSpinner();
		spnprocesador.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnprocesador.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				agregar.setVisible(true);
				agregar.setEnabled(true);
			}
		});
		spnprocesador.setEnabled(false);
		spnprocesador.setBounds(216, 296, 29, 20);
		panel.add(spnprocesador);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			GuardarCombobutton = new JButton("Guardar Combo");
			GuardarCombobutton.setActionCommand("OK");
			buttonPane.add(GuardarCombobutton);
			{
				RegistrarButton = new JButton("Comprar");
				RegistrarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						RegistroCliente res = new RegistroCliente();
						res.setusuario(user);

						res.setCarrito1(carrito1);
						res.setCarrito2(carrito2);
						res.setVisible(true);
					}
				});
				RegistrarButton.setActionCommand("OK");
				buttonPane.add(RegistrarButton);
				getRootPane().setDefaultButton(RegistrarButton);
			}
			{
				cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadComponente();
	}

	protected void limpiar() {
		spncombo.setValue(0);
		spndisco.setValue(0);
		spnprocesador.setValue(0);
		spntargeta.setValue(0);
		spnram.setValue(0);
		combo.setSelectedIndex(0);
		combotargeta.setSelectedIndex(0);
		comboram.setSelectedIndex(0);
		combodisco.setSelectedIndex(0);
		comboprocesador.setSelectedIndex(0);
		
	}
		
	public void loadTable () {
		model.setRowCount(0);
		 row = new Object[(model.getColumnCount())];
		 
		 for (auxiliarCarito2 pu : carrito2){
				
				row[0]=pu.getCarrito().getNombre();
			    row[1]=pu.getCantidad();
				row[2] =pu.preciototal();
				model.addRow(row);
				}
		 for (auxiliarCarrito pu : carrito1){
				
			 row[0]=pu.getCarrito().getNombre();
			    row[1]=pu.getCantidad();
				row[2] =pu.preciototal();
				model.addRow(row);}
				
				}
	public void loadComponente() {
		 ArrayList<Componente> compo = Tienda.getInstance().getMiscomponentes();
		 ArrayList<Combos> combo2 = Tienda.getInstance().getMiscombos();
		 for (Componente compi : compo) {
		if(compi instanceof TarjetaMadre) {
		combotargeta.addItem(compi.getNombre());	
		}
		if(compi instanceof MemoriaRam) {
			comboram.addItem(compi.getNombre());	
			}
		
		 if(compi instanceof Microprocesador) {
				comboprocesador.addItem(compi.getNombre());	
				}
		 if(compi instanceof Discoduro) {
				combodisco.addItem(compi.getNombre());	
				}
		 }
		 for (Combos combi : combo2) {		
			combo.addItem(combi.getNombre());	
				
				}
	}

	public void setusuario(Usuario userr) {
		user=userr;
		}
}
