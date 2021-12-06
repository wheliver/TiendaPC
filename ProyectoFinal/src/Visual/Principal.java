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
import java.awt.event.ActionEvent;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDialog;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Cursor;

public class Principal extends JFrame {

	private JPanel contentPane;
	private  Usuario user=null;

	/**
	 * Launch the application.
	 */
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
			public void windowClosing(WindowEvent e) 
			{
				Tienda.getInstance().guardarTienda();
			}
		});
		
		setResizable(false);
		setBounds(100, 100, 637, 473);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Vender");
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
		
		JMenu mnNewMenu_3 = new JMenu("Facturas");
		mnNewMenu_3.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Lista facturas");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LisFactura fl = new LisFactura();
				fl.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Orden Compra");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrdenCompraList ol = new OrdenCompraList();
				ol.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				ol.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Clientes");
		mnNewMenu_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Lista Clientes");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaCliente lcc = new ListaCliente();
				lcc.setVisible(true);
				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_2 = new JMenu("Componentes");
		mnNewMenu_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Lista de componentes");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListaComponentes lc = new ListaComponentes();
				lc.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Introducir Componete Nuevo");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				componenteNuevo cn = new componenteNuevo();
				cn.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Crear Combo");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CrearCombo cr = new CrearCombo();
				cr.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_4 = new JMenu("Usuarios ");
		mnNewMenu_4.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Introducir un nuevo vendedor");
		mnNewMenu_4.add(mntmNewMenuItem_6);
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearUser cu = new CrearUser();
				cu.setVisible(true);
				
			}
		});
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(null);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 36));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(526, 368, 95, 45);
		panel.add(lblNewLabel);
	}

	public void setusuario(Usuario dameloger) {
		user=dameloger;
			}
}
