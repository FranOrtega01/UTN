package ejemplo2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	JButton btn;
	JTextField txtName;
	
	public Ventana(int x, int y, int width, int height, String title) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x, y , 552, 311);
		setTitle(title);
		getContentPane().setLayout(null);
		
		txtName = new JTextField(10);
		txtName.setBounds(63, 33, 200, 36);
		
		btn = new JButton();
		btn.setText("Aceptar");
		btn.setBounds(63, 80, 200, 30);
		// btn.addActionListener(new eventBtn(txtName));
		
		eventBtn eventoBoton = new eventBtn();
		eventoBoton.setTxtNombre(txtName);
		btn.addActionListener(eventoBoton);
		
		
		getContentPane().add(btn);
		getContentPane().add(txtName);
	}
	
	public void Visibility (boolean estado) {
		setVisible(estado);
	}
}


class eventBtn implements ActionListener{

	private JTextField txtNombre;
	

//	public eventBtn(JTextField txt) {
//		txtNombre = txt;
//	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Mensaje: " + txtNombre.getText());
		
	}
	
}