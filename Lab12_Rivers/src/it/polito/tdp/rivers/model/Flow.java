package it.polito.tdp.rivers.model;

import java.time.LocalDate;

public class Flow {
	
	private int id;
	private LocalDate data;
	private double portata;
	private River fiume;
	
	
	
	public Flow(int id, LocalDate data, double portata, River fiume) {
		super();
		this.id = id;
		this.data = data;
		this.portata = portata;
		this.fiume = fiume;
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((fiume == null) ? 0 : fiume.hashCode());
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(portata);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Flow other = (Flow) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (fiume == null) {
			if (other.fiume != null)
				return false;
		} else if (!fiume.equals(other.fiume))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(portata) != Double.doubleToLongBits(other.portata))
			return false;
		return true;
	}
	
	

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public double getPortata() {
		return portata;
	}
	public void setPortata(double portata) {
		this.portata = portata;
	}
	public River getFiume() {
		return fiume;
	}
	public void setFiume(River fiume) {
		this.fiume = fiume;
	}
	@Override
	public String toString() {
		return id+" "+data+" "+portata+" "+fiume+"\n";
	}
	
	
	
	
	
	

}
