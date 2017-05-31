package it.polito.tdp.rivers.model;

import java.time.LocalDate;

public class Evento implements Comparable <Evento>{

	
	
	
	private LocalDate data;
	private double f_in;
	public Evento(LocalDate data, double f_in) {
		super();
		this.f_in=f_in;
		this.data = data;
	}
	
	
	
	public double getF_in() {
		return f_in;
	}



	public void setF_in(double f_in) {
		this.f_in = f_in;
	}



	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	@Override
	public int compareTo(Evento altro) {
		if (this.getData().isBefore(altro.getData()))
			return -1;
		if (this.getData().isBefore(altro.getData()))
			return 1;
		return 0;
	}
	
	
	
	
}
