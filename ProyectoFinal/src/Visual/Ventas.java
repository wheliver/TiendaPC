package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Ventas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton RegistrarButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Ventas dialog = new Ventas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Ventas() {
		setTitle("Venta Combos");
		setBounds(100, 100, 508, 414);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Eleccion de componentes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 472, 320);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"                        None"}));
		comboBox.setBounds(144, 48, 196, 20);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"                        None"}));
		comboBox_1.setBounds(144, 104, 196, 20);
		panel.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"                        None"}));
		comboBox_2.setBounds(144, 162, 196, 20);
		panel.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"                        None"}));
		comboBox_3.setBounds(144, 216, 196, 20);
		panel.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"                        None"}));
		comboBox_4.setBounds(144, 269, 196, 20);
		panel.add(comboBox_4);
		
		JLabel lblNewLabel = new JLabel("Combos");
		lblNewLabel.setBounds(214, 23, 67, 14);
		panel.add(lblNewLabel);
		
		JLabel lblTarjetaMadre = new JLabel("Tarjeta madre");
		lblTarjetaMadre.setBounds(202, 79, 89, 14);
		panel.add(lblTarjetaMadre);
		
		JLabel lblDiscoDuro = new JLabel("Disco duro");
		lblDiscoDuro.setBounds(202, 137, 67, 14);
		panel.add(lblDiscoDuro);
		
		JLabel lblMemoriaRam = new JLabel("Memoria Ram");
		lblMemoriaRam.setBounds(202, 191, 79, 14);
		panel.add(lblMemoriaRam);
		
		JLabel lblMicroprocesador = new JLabel("Microprocesador");
		lblMicroprocesador.setBounds(202, 247, 101, 14);
		panel.add(lblMicroprocesador);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton GuardarCombobutton = new JButton("Guardar Combo");
			GuardarCombobutton.setActionCommand("OK");
			buttonPane.add(GuardarCombobutton);
			{
				RegistrarButton = new JButton("Registrar");
				RegistrarButton.setActionCommand("OK");
				buttonPane.add(RegistrarButton);
				getRootPane().setDefaultButton(RegistrarButton);
			}
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
		}
	}
}
