package principal;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class PanelListar extends JPanel {
	private JLabel lblPeliculas;
	private JList<Pelicula>list;
	private DefaultListModel<Pelicula> dlModel;
	
	public void setListModel(DefaultListModel<Pelicula> model) {
		dlModel = model;
		list.setModel(dlModel);
	}
	
	public PanelListar() {
		setLayout(null);
		
		lblPeliculas = new JLabel("Peliculas");
		lblPeliculas.setBounds(44, 131, 46, 14);
		add(lblPeliculas);
		
		list = new JList<Pelicula>();
		list.setBounds(102, 21, 320, 251);
		add(list);
		
		
	}
	
}
