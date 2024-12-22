package ejemplo1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame extends JFrame {

	private JPanel contentPane;
	private JButton btnAceptar;
	private JComboBox<String> cbLocalidades;

	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cbLocalidades = new JComboBox<String>();
		cbLocalidades.setBounds(44, 45, 132, 20);
		contentPane.add(cbLocalidades);
		
		cbLocalidades.addItem("Tigre");
		cbLocalidades.addItem("San Fernando");
		cbLocalidades.addItem("San Isidro");
		cbLocalidades.addItem("Vicente Lopez");
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, cbLocalidades.getSelectedItem());
			}
		});
		btnAceptar.setBounds(203, 44, 89, 23);
		contentPane.add(btnAceptar);
	}
}
