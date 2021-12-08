package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Tienda;
import logico.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.DropMode;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtIngreseUnNombre;
	private JTextField textField_Password;
	private JButton btnLogin;
	private JSeparator separator;
	private JSeparator separator_1;
	private JLabel lblNewLabel_2;
	private JLabel lblInicioSesion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tienda.getInstance().cargarTienda();
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 524);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		lblNewLabel.setBounds(27, 131, 169, 20);
		panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		lblPassword.setBounds(27, 234, 169, 20);
		panel.add(lblPassword);
		
		txtIngreseUnNombre = new JTextField();
		txtIngreseUnNombre.setToolTipText("Ingrese un nombre usuario");
		txtIngreseUnNombre.setFont(new Font("Times New Roman", Font.BOLD, 11));
		txtIngreseUnNombre.setForeground(Color.GRAY);
		txtIngreseUnNombre.setBorder(null);
		txtIngreseUnNombre.setBounds(27, 162, 179, 20);
		panel.add(txtIngreseUnNombre);
		txtIngreseUnNombre.setColumns(10);
		
		textField_Password = new JTextField();
		textField_Password.setFont(new Font("Times New Roman", Font.BOLD, 11));
		textField_Password.setForeground(Color.GRAY);
		textField_Password.setToolTipText("Ingrese la contrase\u00F1a");
		textField_Password.setBorder(null);
		textField_Password.setColumns(10);
		textField_Password.setBounds(27, 265, 179, 20);
		panel.add(textField_Password);
		
		btnLogin = new JButton("Log in");
		btnLogin.setFont(new Font("Teko SemiBold", Font.BOLD, 14));
		btnLogin.setForeground(SystemColor.textHighlightText);
		btnLogin.setBackground(SystemColor.textHighlight);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String u = txtIngreseUnNombre.getText();
				String o = textField_Password.getText();
				if(Tienda.getInstance().confirmLogin(u,o)){
					
					Principal frame = new Principal();
					frame.setusuario(Tienda.getInstance().dameloger(u,o));
					frame.chequeodeentrada();
					frame.setVisible(true);
						
					dispose();
				}
				else
				{
					 JOptionPane.showMessageDialog(null,"Este usuario no existe","Aviso",JOptionPane.INFORMATION_MESSAGE);
					 txtIngreseUnNombre.setText("");
					 textField_Password.setText("");
				}
			}
		});
		btnLogin.setBounds(50, 318, 142, 29);
		panel.add(btnLogin);
		
		separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(27, 191, 169, 2);
		panel.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(27, 288, 169, 2);
		panel.add(separator_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/Images/pexels-lucie-liz-3165335 (1).jpg")));
		lblNewLabel_1.setBounds(271, 0, 290, 475);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/Images/pc-de-la-torre (2).png")));
		lblNewLabel_2.setBounds(162, 11, 85, 82);
		panel.add(lblNewLabel_2);
		
		lblInicioSesion = new JLabel("Inicio Sesion");
		lblInicioSesion.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		lblInicioSesion.setBounds(10, 48, 142, 20);
		panel.add(lblInicioSesion);
	}
}
