package ejemplo1;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		//frame.setSize(500, 500);
		//frame.setLocation(350, 350);
		
		frame.setBounds(500, 200, 500, 500);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Titulo 1");
		
		JButton btn = new JButton();
		btn.setText("Aceptar");
		btn.setBounds(10, 15, 140, 30);

		frame.setLayout(null);
		frame.setVisible(true);
		frame.getContentPane().add(btn);
	}
}
