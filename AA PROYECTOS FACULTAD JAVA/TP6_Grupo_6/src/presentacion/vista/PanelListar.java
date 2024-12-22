package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JTable;

public class PanelListar extends JPanel {
	private static final long serialVersionUID = 3881960875483125156L;
	private JTable table;

	public PanelListar() {
		setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 51, 418, 226);
		add(table);
	}
}
