package it.polito.tdp.anagrammi.model;

import java.util.List;

public class TextModel {
	
	public static void main(String[] args) {
		
		Calcola cal = new Calcola();
		
		
		List<String> prova = cal.anagramma("anna");
		System.out.println(prova);
		//System.out.println();
		//System.out.println(cal.soluzioneOk("anna"));
		
	}

}
