package it.polito.tdp.rivers.model;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class River {
	
	private int id;
	private String nome;
	private Flow prima;
	private Flow ultima;
	
	private TreeMap <Integer, Flow> misurazioni;

	public River(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	

	public Flow getPrima() {
		if (prima==null){
			this.calcolaPrimaUltima();
		}
		return prima;
	}



	public Flow getUltima() {
		if (ultima==null){
			this.calcolaPrimaUltima();
		}
		return ultima;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TreeMap<Integer, Flow> getMisurazioni() {
		return misurazioni;
	}

	public void setMisurazioni(TreeMap<Integer, Flow> misurazioni) {
		this.misurazioni = misurazioni;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		River other = (River) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return id+" "+nome+"\n";
	} 
	
	public void calcolaPrimaUltima(){
		List <Flow> temp = new ArrayList <Flow>(misurazioni.values());
		Flow min = temp.get(0);
		Flow max = temp.get(0);
		for (Flow f : this.misurazioni.values()){
			if (f.getData().isBefore(min.getData())){
				min = f;
			}
			if(f.getData().isAfter(max.getData())){
				max=f;
			}
			
			
		}
		prima = min;
		ultima = max;
			
	}
	
	public int getNumeroMisurazioni (){
		return misurazioni.size();
	}
	
	public double getPortataMedio(){
		double somma= 0.0;
		for (Flow f : this.misurazioni.values()){
			somma += f.getPortata();
		}
		return somma/misurazioni.size();
	}
	
	
	
	

}
