package co.edu.unbosque.model;

import java.util.ArrayList;

public class Knuth_Morris_Pratt {
	
	private ArrayList<Integer> text_pos;
	
	public Knuth_Morris_Pratt() {
		text_pos = new ArrayList<>();
	}
	
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

	public ArrayList<Integer> getText_pos() {
		return text_pos;
	}

	public void setText_pos(ArrayList<Integer> text_pos) {
		this.text_pos = text_pos;
	}
	
}
