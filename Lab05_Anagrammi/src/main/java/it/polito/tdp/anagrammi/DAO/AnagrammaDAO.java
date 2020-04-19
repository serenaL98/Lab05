package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.anagrammi.model.Calcola;

public class AnagrammaDAO {

	Calcola prova;
	
	public boolean isCorrect(String anagramma) {
		
		boolean presente = false;
		
		//se l'anagramma è nel dizionario presente ==true
		final String sql = "SELECT * FROM parola WHERE nome =? ";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, anagramma);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				presente = true;
			}
			
			conn.close();
			
		}catch(SQLException e) {
			throw new RuntimeException("Errore db", e);
		}
		
		return presente;
	}
	
	public void setModel(Calcola calcola) {
		this.prova = calcola;
	}

}
