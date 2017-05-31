package it.polito.tdp.rivers.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import it.polito.tdp.rivers.model.Flow;
import it.polito.tdp.rivers.model.River;



public class RiverDAO {
	
	public List<River> getAllRivers(){
		final String sql = "SELECT * FROM river ORDER BY id ";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			

			ResultSet rs = st.executeQuery();
			List <River> rivers = new ArrayList <River>();

			while (rs.next()) {
				
				River r = new River (rs.getInt("id"), rs.getString("name"));
				rivers.add(r);

			
			}
			rs.close();
			conn.close();
		
			return rivers;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
	
	public TreeMap <Integer, Flow> getFlowsFromRivers(River river){
		final String sql = "SELECT * FROM flow WHERE river = ?  ORDER BY id ";
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, river.getId());

			ResultSet rs = st.executeQuery();
			TreeMap <Integer, Flow> misurazioni_per_fiume = new TreeMap <Integer, Flow>();
			

			while (rs.next()) {
				Flow flow = new Flow (rs.getInt("id"), rs.getDate("day").toLocalDate(), rs.getFloat("flow"), river);
				misurazioni_per_fiume.put(flow.getId(), flow);
				

			
			}
			rs.close();
			conn.close();
		
			return misurazioni_per_fiume;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
	}

}
