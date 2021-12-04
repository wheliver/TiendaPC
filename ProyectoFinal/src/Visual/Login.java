package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Tienda;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField_User;
	private JTextField textField_Password;
	private JButton btnCreateUser;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Tienda.getInstance().cargarTienda();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		setBounds(100, 100, 413, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User");
		lblNewLabel.setBounds(177, 31, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(163, 121, 85, 14);
		panel.add(lblPassword);
		
		textField_User = new JTextField();
		textField_User.setBounds(79, 56, 235, 20);
		panel.add(textField_User);
		textField_User.setColumns(10);
		
		textField_Password = new JTextField();
		textField_Password.setColumns(10);
		textField_Password.setBounds(79, 149, 235, 20);
		panel.add(textField_Password);
		
		btnLogin = new JButton("Log in");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String u = textField_User.getText();
				String o = textField_Password.getText();
				if(Tienda.getInstance().confirmLogin(u,o)){
					
					Principal frame = new Principal();
					frame.setusuario(Tienda.getInstance().dameloger(u,o));
					dispose();
					frame.setVisible(true);
				}
				else
				{
					 JOptionPane.showMessageDialog(null,"Este usuario no existe","Aviso",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnLogin.setBounds(149, 203, 113, 23);
		panel.add(btnLogin);
		
		btnCreateUser = new JButton("Create user");
		btnCreateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearUser c = new CrearUser();
				c.setVisible(true);
			}
		});
		btnCreateUser.setBounds(149, 254, 113, 23);
		panel.add(btnCreateUser);
	}
}
