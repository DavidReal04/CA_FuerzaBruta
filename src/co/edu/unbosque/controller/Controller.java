package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import co.edu.unbosque.view.VentanaPrincipal;

public class Controller implements ActionListener{
	
	private VentanaPrincipal vPrincipal;
	private Scanner leer;

	public Controller() {
		
		vPrincipal = new VentanaPrincipal();
		asignarOyentes();
	}

	private void asignarOyentes() {
		// TODO Auto-generated method stub
		vPrincipal.getAbrirFile().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Abrir")) {
			vPrincipal.getFileChooser().showOpenDialog(vPrincipal);
			File file = vPrincipal.getFileChooser().getSelectedFile();
			try {
				leer = new Scanner(file);
				while(leer.hasNextLine()) {
					vPrincipal.getTexto().setText(vPrincipal.getTexto().getText() + new String(leer.nextLine().getBytes(),"utf8") +"\n");
				}
				leer.close();
			} catch (FileNotFoundException e1) {
			} catch (UnsupportedEncodingException e2) {}
			
		}
	}
	
}
