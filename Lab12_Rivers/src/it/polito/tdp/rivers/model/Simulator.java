package it.polito.tdp.rivers.model;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import it.polito.tdp.rivers.db.RiverDAO;
import javafx.event.Event;

public class Simulator {
	
	private RiverDAO dao = new RiverDAO();
	private List <River>fiumi;
	//parametri del simulatore
	private int giorniInsoddisfatti;
	private double occupazioneMedia;
	double f_med;
	double k;
	double q;
	double c;
	int num_sim;
	
	double f_in;
	
	int c_tot;
	
	
	private PriorityQueue<Evento> queue;
	
	//stato del mondo
	
	
	//misure di interesse
	
	//coda degli eventi
	
	public Simulator(){
		
		occupazioneMedia=0.0;
		this.queue = new PriorityQueue <>();
//		f_med =0.0;
//		k=0.0;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public double getOccupazioneMedia() {
		return occupazioneMedia;
	}


















	public void setOccupazioneMedia(double occupazioneMedia) {
		this.occupazioneMedia = occupazioneMedia;
	}


















	public int getGiorniInsoddisfatti() {
		return giorniInsoddisfatti;
	}


















	public List<River> getFiumi(){
		if (fiumi==null){
			fiumi = new ArrayList <River>(dao.getAllRivers());
		}
		return fiumi;
		
	}
	
	
	public void misurazionePerFiume (River river){
		river.setMisurazioni(dao.getFlowsFromRivers(river));
	}


















	public void addEvento(Flow f) {
		
    		Evento e = new Evento (f.getData(), f.getPortata());
    		queue.add(e);
    	}


















	public void setParametri(double f_med, double k, int num_sim) {
		this.f_med = f_med;
		this.k=k;
		this.num_sim = num_sim;
		
		
		
	}


















	public void run() {
		giorniInsoddisfatti=0;
		c_tot =0;
		double q= k * f_med * 2592000;
		
		double c = q/2.0;
		
		double f_out_min = f_med*0.8;
		
		
		
		
	
		
		while(!queue.isEmpty()) {
			
			
			
			
			Evento e = queue.poll() ;
			double probabilita = Math.random();
			
			//calcolo f_in 
			f_in = e.getF_in();
			
			//calcolo il nuovo c = c + f_in
			c = c+ f_in;
				//Verifico che sia < Q
			if (c > q){
				//se no c nuovo = c precedente
				c = q;
			}
			
			if (probabilita <= 0.05){
				f_out_min = 10*f_out_min;
			}
			
			
				
				//verifico se c > f_out_min
			if (c>f_out_min){
				// SI: ho abbastanza acqua
					//c= c-f_out_min
				c = c - f_out_min;
			}else{
				// NO : c=0; insoddisfatti++;
				c=0;
				this.giorniInsoddisfatti++;
			}
			
		c_tot += c;			
		}
		occupazioneMedia = c_tot/num_sim;
		
		
		
	}
	
	

	

		
		
	
	
	
	
	
	
	
	

}
