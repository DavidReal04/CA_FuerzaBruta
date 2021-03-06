package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.DefaultHighlighter.DefaultHighlightPainter;
import javax.swing.text.Highlighter;
/**
 * Clase VentanaPrincipal, consta del m?todo constructor y de el m?todo inicializarComponentes
 * @author David Real
 * @author Diego Nu?ez
 */
public class VentanaPrincipal extends JFrame{

	/**
	 *Serial de la clase VentanaPrincipal 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Objeto de PanelPrincipal que permite acceder a sus atributos y m?todos
	 */
	private PanelPrincipal principal;
	/**
	 * Objeto de JMenuBar
	 */
	private JMenuBar menu;
	/**
	 * Objeto de JMenu
	 */
	private JMenu archivo;
	/**
	 * Objeto de JMenuItem
	 */
	private JMenuItem abrirFile;
	/**
	 * Objeto de JFileChooser
	 */
	private JFileChooser fileChooser;
	/**
	 * Objeto de JTextPane
	 */
	private JTextPane texto;
	/**
	 * Objeto de JScrollPane
	 */
	private JScrollPane scrollPane;
	/**
	 * Objeto de DefaultHighlightPainter 
	 */
	private DefaultHighlightPainter highlight;
	
	/**
	 * M?todo Constructor de la clase VentanaPrincipal
	 */
	public VentanaPrincipal() {
		
		setTitle("Algoritmos FB");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.lightGray);
		
		inicializarComponentes();
		
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * M?todo inicializarComponentes de la clase VentanaPrincipal
	 */
	private void inicializarComponentes() {
	// TODO Auto-generated method stub
		
		principal = new PanelPrincipal();
		principal.setBounds(5, 5, 575,325);
		principal.setOpaque(false);
		getContentPane().add(principal);
		
		texto = new JTextPane();
		texto.setText("Por Favor, cargue un archivo .txt");
		texto.setEditable(false);
		add(texto);	
		
		scrollPane = new JScrollPane(texto);
        scrollPane.setBounds(10, 10, 565,315);
        add(scrollPane);
		
		menu = new JMenuBar();
		setJMenuBar(menu);
		
		archivo = new JMenu("Archivo");
		menu.add(archivo);
		
		abrirFile = new JMenuItem("Abrir");
		abrirFile.setActionCommand("Abrir");
		archivo.add(abrirFile);
		
		fileChooser = new JFileChooser();
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de texto (.txt)", "txt"));
		
		highlight = new DefaultHighlighter.DefaultHighlightPainter(Color.yellow);
		
	}
	
	//Getters-Setters
	
	public DefaultHighlightPainter getHighlight() {
		return highlight;
	}

	public void setHighlight(DefaultHighlightPainter highlight) {
		this.highlight = highlight;
	}

	public JTextPane getTexto() {
		return texto;
	}

	public void setTexto(JTextPane texto) {
		this.texto = texto;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public PanelPrincipal getPrincipal() {
		return principal;
	}

	public void setPrincipal(PanelPrincipal principal) {
		this.principal = principal;
	}

	public JMenuBar getMenu() {
		return menu;
	}

	public void setMenu(JMenuBar menu) {
		this.menu = menu;
	}

	public JMenu getArchivo() {
		return archivo;
	}

	public void setArchivo(JMenu archivo) {
		this.archivo = archivo;
	}

	public JFileChooser getFileChooser() {
		return fileChooser;
	}

	public void setFileChooser(JFileChooser fileChooser) {
		this.fileChooser = fileChooser;
	}

	public JMenuItem getAbrirFile() {
		return abrirFile;
	}

	public void setAbrirFile(JMenuItem abrirFile) {
		this.abrirFile = abrirFile;
	}
	

}
