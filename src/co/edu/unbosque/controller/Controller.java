package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;

import co.edu.unbosque.model.Boyer_Moore;
import co.edu.unbosque.model.Knuth_Morris_Pratt;
import co.edu.unbosque.view.VentanaPrincipal;

public class Controller implements ActionListener{
	
	private VentanaPrincipal vPrincipal;
	private Boyer_Moore bm;
	private Knuth_Morris_Pratt kmp;
	private Scanner leer;

	public Controller() {
		vPrincipal = new VentanaPrincipal();
		bm = new Boyer_Moore();
		kmp = new Knuth_Morris_Pratt();
		asignarOyentes();
	}

	private void asignarOyentes() {
		// TODO Auto-generated method stub
		vPrincipal.getAbrirFile().addActionListener(this);
		vPrincipal.getPrincipal().getBM_Button().addActionListener(this);
		vPrincipal.getPrincipal().getKMP_Button().addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Abrir")) {
			vPrincipal.getFileChooser().showOpenDialog(vPrincipal);
			File file = vPrincipal.getFileChooser().getSelectedFile();
			try {
				if(file!=null){
					vPrincipal.getTexto().setText("");
					vPrincipal.getPrincipal().getMostrar_cant().setText("");
					leer = new Scanner(file);
					while(leer.hasNextLine()) {
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
			vPrincipal.getTexto().setCaretPosition(0);
			vPrincipal.getTexto().getHighlighter().removeAllHighlights();
			kmp.getText_pos().clear();
			if(vPrincipal.getPrincipal().getTexto().getText().equals("")) {
				vPrincipal.getPrincipal().getMostrar_cant().setText("No ingresó ninguna palabra");
			}else {
				kmp.busquedaKMP(vPrincipal.getTexto().getText().toCharArray(), vPrincipal.getPrincipal().getTexto().getText().toCharArray());
				vPrincipal.getPrincipal().getMostrar_cant().setText("El texto aparece "+kmp.getText_pos().size()+" veces");
				vPrincipal.getPrincipal().getMostrar_cant().setVisible(true);
				resaltar(kmp.getText_pos(), vPrincipal.getPrincipal().getTexto().getText().length());
				vPrincipal.getTexto().setCaretPosition(kmp.getText_pos().get(0));
			}
			
		}else if(e.getActionCommand().equals("BM")) {
			vPrincipal.getTexto().setCaretPosition(0);
			vPrincipal.getTexto().getHighlighter().removeAllHighlights();
			bm.getText_pos().clear();
			if(vPrincipal.getPrincipal().getTexto().getText().equals("")) {	
				vPrincipal.getPrincipal().getMostrar_cant().setText("No ingresó ninguna palabra");
			}else {
				bm.buscar(vPrincipal.getTexto().getText().toCharArray(), vPrincipal.getPrincipal().getTexto().getText().toCharArray());
				vPrincipal.getPrincipal().getMostrar_cant().setText("El texto aparece "+bm.getText_pos().size()+" veces");
				vPrincipal.getPrincipal().getMostrar_cant().setVisible(true);
				resaltar(bm.getText_pos(), vPrincipal.getPrincipal().getTexto().getText().length());
				vPrincipal.getTexto().setCaretPosition(bm.getText_pos().get(0));
			}
		}
	} 
	
	public void resaltar(ArrayList<Integer> pos, int tam) {
		try {
			for (int i = 0; i < pos.size(); i++) {
				vPrincipal.getTexto().getHighlighter().addHighlight(pos.get(i), (pos.get(i)+tam), vPrincipal.getHighlight());
			}
		} catch (BadLocationException e1) {}
	}
	
}
