package ejemplo2;

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
	private JComboBox<Categorias> cbCategorias;
	private JButton btnAceptar;

	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cbCategorias = new JComboBox<Categorias>();
		cbCategorias.setBounds(38, 38, 122, 20);
		contentPane.add(cbCategorias);
		
		cbCategorias.addItem(new Categorias(1, "Terror"));
		cbCategorias.addItem(new Categorias(2, "Fantasia"));
		
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, ((Categorias)cbCategorias.getSelectedItem()).getNombre());
			}
		});
		btnAceptar.setBounds(238, 37, 89, 23);
		contentPane.add(btnAceptar);
	}

}
