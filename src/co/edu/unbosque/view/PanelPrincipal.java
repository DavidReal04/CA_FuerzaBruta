package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class PanelPrincipal extends JPanel{
	
	private JTextPane texto;
	
	public PanelPrincipal() {
		setLayout(null);
		inicializarComponentes();
	}

	private void inicializarComponentes() {
		// TODO Auto-generated method stub
		setBackground(new Color(222,222,222));
		setBorder(new LineBorder(new Color(190, 255, 237)));
		
		texto = new JTextPane();
		add(texto);	
		
	}  	

}
