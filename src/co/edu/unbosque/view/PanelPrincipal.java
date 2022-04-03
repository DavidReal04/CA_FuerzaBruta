package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class PanelPrincipal extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton KMP_Button;
	private JButton BM_Button;
	private JTextField texto;
	private JLabel buscar;
	private JLabel algoritmo;
	private JLabel mostrar_cant;
	private LineBorder recuadroResul;
	
	public PanelPrincipal() {
		setLayout(null);
		inicializarComponentes();
		estadoElementos(false);
	}

	private void inicializarComponentes() {
		// TODO Auto-generated method stub
		setBackground(new Color(222,222,222));
		setBorder(new LineBorder(new Color(190, 255, 237)));
		
		buscar = new JLabel("Ingrese Palabra a Buscar (distingue mayús y min)");
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
		
	}
	
	public void estadoElementos(boolean estado) {
		buscar.setVisible(estado);
		texto.setVisible(estado);
		algoritmo.setVisible(estado);
		BM_Button.setVisible(estado);
		KMP_Button.setVisible(estado);
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
