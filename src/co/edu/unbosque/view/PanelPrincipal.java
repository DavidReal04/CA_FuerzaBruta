package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.*;
import javax.swing.border.LineBorder;
/**
 * Clase PanelPrincipal, consta del método constructor, del método inicializarComponentes y del método estadoElemento
 * @author David Real
 * @author Diego Nuñez
 */
public class PanelPrincipal extends JPanel{
	/**
	 * Serial de la clase PanelPrincipal
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Objeto de JButton
	 */
	private JButton KMP_Button;
	/**
	 * Objeto de JButton
	 */
	private JButton BM_Button;
	/**
	 * Objeto de JTextField
	 */
	private JTextField texto;
	/**
	 * Objeto de JLabel
	 */
	private JLabel buscar;
	/**
	 * Objeto de JLabel
	 */
	private JLabel algoritmo;
	/**
	 * Objeto de JLabel
	 */
	private JLabel mostrar_cant;
	/**
	 * Objeto de LineBorder
	 */
	private LineBorder recuadroResul;
	/**
	 * Objeto de JRadioButton
	 */
	private JRadioButton caseSensitive;
	
	/**
	 * Método constructor de la clase PanelPrincipal
	 */
	public PanelPrincipal() {
		setLayout(null);
		inicializarComponentes();
		estadoElementos(false);
	}

	/**
	 * Método inicializar componentes de la clase PanelPrincipal
	 */
	private void inicializarComponentes() {
		// TODO Auto-generated method stub
		setBackground(new Color(222,222,222));
		setBorder(new LineBorder(new Color(190, 255, 237)));
		
		buscar = new JLabel("Ingrese Palabra a Buscar");
		buscar.setBounds(10, 320, 305, 20);
		add(buscar);
		
		texto = new JTextField();
		texto.setBounds(15, 345, 305, 20);
		add(texto);
		
		algoritmo = new JLabel("Seleccione Algoritmo de Búsqueda");
		algoritmo.setBounds(10, 370, 200, 20);
		add(algoritmo);
		
		KMP_Button = new JButton("KMP");
		KMP_Button.setBounds(15, 395, 150, 20);
		KMP_Button.setActionCommand("KMP");
		add(KMP_Button);
		
		BM_Button = new JButton("BM");
		BM_Button.setBounds(170, 395, 150, 20);
		BM_Button.setActionCommand("BM");
		add(BM_Button);
		
		recuadroResul = new LineBorder(new Color(255,255,255));
		
		mostrar_cant = new JLabel("La palabra está x veces", SwingConstants.CENTER);
		mostrar_cant.setBounds(350, 345, 200, 20);
		mostrar_cant.setBorder(recuadroResul);
		mostrar_cant.setVisible(false);
		add(mostrar_cant);
		
		caseSensitive = new JRadioButton("Distingue Mayus y Min");
		caseSensitive.setOpaque(false);
		caseSensitive.setBackground(new Color(222,222,222));
		caseSensitive.setBounds(160, 322, 160, 20);
		add(caseSensitive);
		
	}
	
	/**
	 * Método estadoElementos de la clase PanelPrincipal
	 * <p> Oculta o muestra los elementos del Panel
	 * @param estado Booleano que indica si se ocultan o se muestran los elementos
	 */
	public void estadoElementos(boolean estado) {
		buscar.setVisible(estado);
		texto.setVisible(estado);
		algoritmo.setVisible(estado);
		BM_Button.setVisible(estado);
		KMP_Button.setVisible(estado);
	}

	//Getters-Setters
	
	public JRadioButton getCaseSensitive() {
		return caseSensitive;
	}

	public void setCaseSensitive(JRadioButton caseSensitive) {
		this.caseSensitive = caseSensitive;
	}

	public JButton getKMP_Button() {
		return KMP_Button;
	}

	public void setKMP_Button(JButton kMP_Button) {
		KMP_Button = kMP_Button;
	}

	public JButton getBM_Button() {
		return BM_Button;
	}

	public void setBM_Button(JButton bM_Button) {
		BM_Button = bM_Button;
	}

	public JTextField getTexto() {
		return texto;
	}

	public void setTexto(JTextField texto) {
		this.texto = texto;
	}

	public JLabel getBuscar() {
		return buscar;
	}

	public void setBuscar(JLabel buscar) {
		this.buscar = buscar;
	}

	public JLabel getAlgoritmo() {
		return algoritmo;
	}

	public void setAlgoritmo(JLabel algoritmo) {
		this.algoritmo = algoritmo;
	}

	public JLabel getMostrar_cant() {
		return mostrar_cant;
	}

	public void setMostrar_cant(JLabel mostrar_cant) {
		this.mostrar_cant = mostrar_cant;
	}

	public LineBorder getRecuadroResul() {
		return recuadroResul;
	}

	public void setRecuadroResul(LineBorder recuadroResul) {
		this.recuadroResul = recuadroResul;
	}  	
	
}
