package it.polito.tdp.rivers.db;

import it.polito.tdp.rivers.model.River;

public class TestDAO {

	public static void main(String[] args) {
	RiverDAO dao = new RiverDAO();
	
	System.out.println(dao.getAllRivers());
	River r = new River (1, "Jokulsa Eystri River");
	System.out.println(dao.getFlowsFromRivers(r));

	}

}
