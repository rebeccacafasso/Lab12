package it.polito.tdp.rivers.model;

public class TestModel {

	public static void main(String[] args) {
		River r = new River (1, "Jokulsa Eystri River");
		Simulator s = new Simulator();
		
		s.misurazionePerFiume(r);
		
		System.out.println(r.getPortataMedio());
		System.out.println(r.getNumeroMisurazioni());
		System.out.println(r.getPrima());
		System.out.println(r.getUltima());
	}

}
