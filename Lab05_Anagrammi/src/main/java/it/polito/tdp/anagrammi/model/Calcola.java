package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Calcola {
	
	AnagrammaDAO anaDAO= new AnagrammaDAO();
	
	List<String> soluzione;
	
	public List<String> anagramma(String parola){
		this.soluzione = new ArrayList<String>();
		
		//CASO INIZIALE
		parola = parola.toUpperCase();
		List<Character> disponibili = new ArrayList<Character>();
		
		for(int i=0; i<parola.length(); i++) {
			disponibili.add(parola.charAt(i));
		}
		
		cerca("", 0, disponibili);
		return this.soluzione;
	}
	
	private void cerca(String parziale, int livello, List<Character> disponibili) {
		//CASO FINALE
		if(disponibili.size()==0) {
			soluzione.add(parziale);
		}
		//CASO PARZIALE
		for(Character c : disponibili) {
			String parzialeN = parziale + c;
			
			List<Character> rimanenti = new ArrayList<Character>(disponibili);
			
			rimanenti.remove(c);
			cerca(parzialeN, livello+1, rimanenti);
		}
	}
	
	public boolean isCorrect(String anagramma) {
		return anaDAO.isCorrect(anagramma); 
	}

	public List<String> soluzioneOk(List<String> input){
		//rimuovi duplicati
		List<String> noDuplex = new ArrayList<String>();
		
		for(String s: input) {
			
			boolean trovato = false;
			
			for(String t: noDuplex) {
				if(s.equals(t)) {
					trovato = true;
				}
			}
			
			if(trovato == false) {
				noDuplex.add(s);
			}
		}
		
		return noDuplex;
	}
	
}
