package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.BadLocationException;

import co.edu.unbosque.model.Boyer_Moore;
import co.edu.unbosque.model.Knuth_Morris_Pratt;
import co.edu.unbosque.view.VentanaPrincipal;

/**
 * Clase Controller, consta del método constructor y de los métodos asignarOyentes y actionPerformed
 * <p>Relaciona las clases del paquete model con las clases del paquete view y controla las interacciones entre ellas
 * @author David Real
 * @author Diego Nuñez
 */
public class Controller implements ActionListener{
	/**
	 * Objeto de VentantaPrincipal que permite acceder a sus atributos y métodos
	 */
	private VentanaPrincipal vPrincipal;
	/**
	 * Objeto de Boyer_Moore que permite acceder a sus atributos y métodos
	 */
	private Boyer_Moore bm;
	/**
	 * Objeto de Knuth_Morris_Pratt que permite acceder a sus atributos y métodos
	 */
	private Knuth_Morris_Pratt kmp;
	/**
	 * Objeto de Scanner que permite acceder a sus atributos y métodos
	 */
	private Scanner leer;

	/**
	 * Método Constuctor de la clase Controller
	 */
	public Controller() {
		vPrincipal = new VentanaPrincipal();
		bm = new Boyer_Moore();
		kmp = new Knuth_Morris_Pratt();
		asignarOyentes();
	}

	/**
	 * Método asignarOyentes de la clase Controller
	 * <p>Añade actionListener a los botones de view
	 */
	private void asignarOyentes() {
		// TODO Auto-generated method stub
		vPrincipal.getAbrirFile().addActionListener(this);
		vPrincipal.getPrincipal().getBM_Button().addActionListener(this);
		vPrincipal.getPrincipal().getKMP_Button().addActionListener(this);
		
	}

	/**
	 * Método actionPerformed de la clase Controller
	 * <p>Se invoca cuando ocurre una acción
	 * @param e Objeto a procesar de la clase ActionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Abrir")) {
			//Acción del Botón abrir
			//Abrir archivo txt
			vPrincipal.getFileChooser().showOpenDialog(vPrincipal);
			File file = vPrincipal.getFileChooser().getSelectedFile();
			try {
				if(file!=null){
					vPrincipal.getTexto().setText("");
					vPrincipal.getPrincipal().getMostrar_cant().setText("");
					leer = new Scanner(file);
					while(leer.hasNextLine()) {
						//Plasmar contenido del archivo en el JTextPanel de VentanaPrincipal
						vPrincipal.getTexto().setText(vPrincipal.getTexto().getText().concat(new String(leer.nextLine().getBytes(),"utf8") +"\n"));
					}
					leer.close();
					vPrincipal.getPrincipal().estadoElementos(true);
					vPrincipal.setSize(600, 500);
					vPrincipal.getPrincipal().setBounds(5, 5, 575,425);
				}
			} catch (FileNotFoundException e1) {
			} catch (UnsupportedEncodingException e2) {}
			
		}else if(e.getActionCommand().equals("KMP")) {
			//Accón del botón KMP
			//Borrar estados anteriores
			vPrincipal.getTexto().setCaretPosition(0);
			vPrincipal.getTexto().getHighlighter().removeAllHighlights();
			kmp.getText_pos().clear();
			//Obtener que se quiere buscar, validarlo y pasarlo al algoritmo
			String busqueda = vPrincipal.getPrincipal().getTexto().getText(); 
			if(busqueda.equals("")) {
				vPrincipal.getPrincipal().getMostrar_cant().setText("No ingresó ninguna palabra");
			}else {
				String text = vPrincipal.getTexto().getText();
				if(vPrincipal.getPrincipal().getCaseSensitive().isSelected()==false) {
					text = text.toLowerCase();
					busqueda = busqueda.toLowerCase();
				}
				kmp.busquedaKMP(text.toCharArray(), busqueda.toCharArray());
				vPrincipal.getPrincipal().getMostrar_cant().setText("El texto aparece "+kmp.getText_pos().size()+" veces");
				vPrincipal.getPrincipal().getMostrar_cant().setVisible(true);
				resaltar(kmp.getText_pos(), busqueda.length());
				if(kmp.getText_pos().size()!=0){
					vPrincipal.getTexto().setCaretPosition(kmp.getText_pos().get(0));
				}
			}
			
		}else if(e.getActionCommand().equals("BM")) {
			//Acción del botón BM
			//Borrar estados anteriores
			vPrincipal.getTexto().setCaretPosition(0);
			vPrincipal.getTexto().getHighlighter().removeAllHighlights();
			bm.getText_pos().clear();
			//Obtener que se quiere buscar, validarlo y pasarlo al algoritmo
			String busqueda = vPrincipal.getPrincipal().getTexto().getText();
			if(busqueda.equals("")) {
				vPrincipal.getPrincipal().getMostrar_cant().setText("No ingresó ninguna palabra");
			}else {
				String text = vPrincipal.getTexto().getText();
				if(vPrincipal.getPrincipal().getCaseSensitive().isSelected()==false) {
					text = text.toLowerCase();
					busqueda = busqueda.toLowerCase();
				}
				bm.buscar(text.toCharArray(), busqueda.toCharArray());
				vPrincipal.getPrincipal().getMostrar_cant().setText("El texto aparece "+bm.getText_pos().size()+" veces");
				vPrincipal.getPrincipal().getMostrar_cant().setVisible(true);
				resaltar(bm.getText_pos(), busqueda.length());
				if(bm.getText_pos().size()!=0){
					vPrincipal.getTexto().setCaretPosition(bm.getText_pos().get(0));
				}
			}
		}
	} 
	
	/**
	 * Método resaltar de la clase Controller
	 * 
	 * @param pos Arreglo de Enteros que contiene las posiciones donde inicia el texto
	 * @param tam Objeto de tipo Int que indica el tamaño del texto
	 */
	public void resaltar(ArrayList<Integer> pos, int tam) {
		try {
			for (int i = 0; i < pos.size(); i++) {
				vPrincipal.getTexto().getHighlighter().addHighlight(pos.get(i), (pos.get(i)+tam), vPrincipal.getHighlight());
			}
		} catch (BadLocationException e1) {}
	}
	
}
