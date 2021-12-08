package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Tienda;
import logico.Usuario;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDialog;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class Principal extends JFrame {

	private JPanel contentPane;
	private  Usuario user=null;
	private JLabel LblX;
	private JPanel panelHover;
	private JMenu usuario;
	private JMenu mnNewMenu_2;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_3;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;
	private JMenuItem mntmNewMenuItem_7;
	private JMenuItem introducirusuario;

	/**
	 * Launch the application.
	 *//**
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension j = getToolkit().getScreenSize();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) 
			{
				Tienda.getInstance().guardarTienda();
			}
		});
		
		setResizable(false);
		setBounds(100, 100, 637, 473);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Vender");
		mnNewMenu.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Venta");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventas v= new Ventas();
				v.setusuario(user);

				v.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		mnNewMenu_3 = new JMenu("Facturas");
		mnNewMenu_3.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		menuBar.add(mnNewMenu_3);
		
		mntmNewMenuItem_3 = new JMenuItem("Lista facturas");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LisFactura fl = new LisFactura();
				fl.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_3);
		
		mntmNewMenuItem_1 = new JMenuItem("Orden Compra");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrdenCompraList ol = new OrdenCompraList();
				ol.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				ol.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_1);
		
		mnNewMenu_1 = new JMenu("Clientes");
		mnNewMenu_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem_2 = new JMenuItem("Lista Clientes");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaCliente lcc = new ListaCliente();
				lcc.setVisible(true);
				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		mnNewMenu_2 = new JMenu("Componentes");
		mnNewMenu_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		menuBar.add(mnNewMenu_2);
		
		mntmNewMenuItem_4 = new JMenuItem("Lista de componentes");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListaComponentes lc = new ListaComponentes();
				lc.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		mntmNewMenuItem_5 = new JMenuItem("Introducir Componete Nuevo");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				componenteNuevo cn = new componenteNuevo();
				cn.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		mntmNewMenuItem_7 = new JMenuItem("Crear Combo");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CrearCombo cr = new CrearCombo();
				cr.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_7);
		
		usuario = new JMenu("Usuarios ");
		usuario.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		menuBar.add(usuario);
		
		introducirusuario = new JMenuItem("Introducir un nuevo vendedor");
		usuario.add(introducirusuario);
		
		JMenu mnNewMenu_5 = new JMenu("Respaldo");
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Hacer Respaldo");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Socket socket = null;
				InputStream in = null;
				OutputStream out = null;

				try {
					socket = new Socket("127.0.0.1",8906);
					in = new FileInputStream("Tienda.dat");
					out = socket.getOutputStream();
				} catch (FileNotFoundException err) {
					JOptionPane.showMessageDialog(null, "No existe data para realizar un respaldo", "Respaldo Fallido",
							JOptionPane.ERROR_MESSAGE);
				} catch (UnknownHostException uhe) {
					JOptionPane.showMessageDialog(null, "No existe data para realizar un respaldo", "Respaldo Fallido",
							JOptionPane.ERROR_MESSAGE);
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}

				try {
					int count;
					byte[] bytes = new byte[8192];
					while ((count = in.read(bytes)) > 0) {
						out.write(bytes, 0, count);
					}

					out.close();
					in.close();
					socket.close();

					JOptionPane.showMessageDialog(null, "Respaldo guardado en la carpeta", "Respaldo hecho",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_8);
		introducirusuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearUser cu = new CrearUser();
				cu.setVisible(true);
				
			}
		});
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelHover = new JPanel();
		panelHover.setBackground(Color.WHITE);
		panelHover.setBounds(514, 345, 82, 50);
		contentPane.add(panelHover);
		panelHover.setLayout(null);
		
		LblX = new JLabel("X");
		LblX.setBounds(0, 0, 82, 50);
		panelHover.add(LblX);
		LblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panelHover.setBackground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelHover.setBackground(Color.white);
			}
		});
		LblX.setHorizontalAlignment(SwingConstants.CENTER);
		LblX.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/Images/monitor-de-pc.png")));
		lblNewLabel.setBounds(241, 84, 153, 168);
		contentPane.add(lblNewLabel);
	}

	public void setusuario(Usuario dameloger) {
		user=dameloger;
			}
	public void chequeodeentrada() {
		if(user.getLogin().equalsIgnoreCase("Administrador")) {
			// decidir que se vera y que nno
			introducirusuario.setEnabled(true);
			introducirusuario.setVisible(true);
			usuario.setEnabled(true);
		}else {
			introducirusuario.setEnabled(false);
			introducirusuario.setVisible(false);
			usuario.setEnabled(false);
		}
	}
}
