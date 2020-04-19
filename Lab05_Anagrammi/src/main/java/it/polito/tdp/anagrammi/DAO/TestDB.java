package it.polito.tdp.anagrammi.DAO;

//import it.polito.tdp.anagrammi.model.Calcola;

public class TestDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnagrammaDAO a = new AnagrammaDAO();
		System.out.println("STAMPO IO: "+a.isCorrect("anna"));
		/*
		Calcola ctep = new Calcola();
		System.out.println("STAMPO IO: "+ctep.anagramma("anna"));
		System.out.println("La parola 'anna' è nel dizionario? "+ctep.isCorrect("anna"));*/
		//System.out.println("ANAGRAMMA di 'anna':\n"+ctep.soluzioneOk("anna"));
	}

}
