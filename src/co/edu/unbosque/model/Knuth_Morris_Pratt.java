package co.edu.unbosque.model;

import java.util.ArrayList;
/**
 * Clase Knuth_Morris_Pratt, consta del método constructor y método busquedaKMP
 * <p>Implementación del algorimo Knuth Morris Pratt 
 * @author David Real
 * @author Diego Nuñez
 */
public class Knuth_Morris_Pratt {
	
	/**
	 * ArrayList con Objetos de tipo Integer
	 */
	private ArrayList<Integer> text_pos;
	
	/**
	 * Método constructor de la clase Knuth_Morris_Pratt
	 */
	public Knuth_Morris_Pratt() {
		text_pos = new ArrayList<>();
	}
	/**
	 * Método busquedaKMP de la clase Knuth_Morris_Pratt
	 * @param text Arreglo de caracteres que contiene el texto donde se hace la busqueda
	 * @param pat Arreglo de caracteres que contiene el texto a buscar
	 */
	public void busquedaKMP(char[] text, char[] pat){
        if (pat == null || pat.length == 0){
            text_pos.add(0);
        }
 
        char[] chars = pat;
        int[] next = new int[pat.length + 1];
        for (int i = 1; i < pat.length; i++){
            int j = next[i + 1];
 
            while (j > 0 && chars[j] != chars[i]) {
                j = next[j];
            }
 
            if (j > 0 || chars[j] == chars[i]) {
                next[i + 1] = j + 1;
            }
        }
 
        for (int i = 0, j = 0; i < text.length; i++){
            if (j < pat.length && text[i] == pat[j]){
                if (++j == pat.length) {
                    text_pos.add(i - j + 1);
                }
            }
            else if (j > 0){
                j = next[j];
                i--;
            }
        }
    }

	/**
	 * Método getText_pos de la clase Knuth_Morris_Pratt
	 * @return Objeto text_pos de la clase Knuth_Morris_Pratt
	 */
	public ArrayList<Integer> getText_pos() {
		return text_pos;
	}
	
	/**
	 * Método setText_pos de la clase Knuth_Morris_Pratt
	 * @param text_pos ArrayList con objetos de tipo Integer
	 */
	public void setText_pos(ArrayList<Integer> text_pos) {
		this.text_pos = text_pos;
	}
	
}
