package co.edu.unbosque.model;

import java.util.ArrayList;

/**
 * Clase Boyer_Moore, consta del método constructor, del método buscar y del método reglaCaracterMalo
 * <p>Implementación del algorimo Boyer Moore 
 * @author David Real
 * @author Diego Nuñez
 */
public class Boyer_Moore {
	
	/**
	 * ArrayList con Objetos de tipo Integer
	 */
	private ArrayList<Integer> text_pos;
	/**
	 * Objeto de tipo int
	 */
	private final int NUM_CARACTERES;
	
	public Boyer_Moore() {
		text_pos = new ArrayList<>();
		NUM_CARACTERES=1824;
	}
	
	/**
	 * Método buscar de la clase Boyer_Moore
	 * @param texto Arreglo de caracteres que contiene el texto donde se hace la busqueda
	 * @param patron Arreglo de caracteres que contiene el texto a buscar
	 */
	public void buscar(char[] texto, char[] patron) {
		
		int len_texto = texto.length;
		int len_patron = patron.length;
		int[] caracErroneo = new int[NUM_CARACTERES];
		int desp=0;
		
		reglaCaracterMalo(patron, len_patron, caracErroneo);
		
		while(desp <= (len_texto-len_patron)) {
			int i = len_patron-1;
			while(i>=0 && patron[i] == texto[desp+i]){
				i--;				
			}
			if(i<0) {
				text_pos.add(desp);
				if(desp+len_patron < len_texto) {
					desp += len_patron-caracErroneo[texto[desp+len_patron]];
				}else {
					desp +=1;
				}
			}else{
				desp += getMax(1, i-caracErroneo[texto[desp+i]]);
			}
		}		
	}
	/**
	 * Método reglaCaracterMalo de la clase Boyer_Moore
	 * @param cadena Arreglo de caracteres que contiene el texto a buscar
	 * @param tam Número entero que indica el tamaño de la cadena
	 * @param caracterMalo Arreglo de numeros enteros
	 */
	public void reglaCaracterMalo(char[] cadena, int tam, int[] caracterMalo) {
		
		for (int i = 0; i < NUM_CARACTERES; i++) {
			caracterMalo[i] = -1;
		}
		
		for (int i = 0; i < tam; i++) {
			int num = (int) cadena[i];
			caracterMalo[num] = i;
		}	
	}
	
	/**
	 * Método getMax de la clase Boyer_Moore
	 * @param num1 Numero entero
	 * @param num2 Numero entero
	 * @return Mayor de los números ingresados
	 */
	
	public int getMax(int num1, int num2) {
		if(num1>num2) {
			return num1;
		}
		return num2;
	}

	//Getter-Setters
	public ArrayList<Integer> getText_pos() {
		return text_pos;
	}

	public void setText_pos(ArrayList<Integer> text_pos) {
		this.text_pos = text_pos;
	}

}
