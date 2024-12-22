package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JTable;

public class PanelListar extends JPanel {
	private JTable tblPersonas;

	/**
	 * Create the panel.
	 */
	public PanelListar() {
		setLayout(null);
		
		tblPersonas = new JTable();
		tblPersonas.setBounds(32, 271, 382, -249);
		add(tblPersonas);

	}
}
