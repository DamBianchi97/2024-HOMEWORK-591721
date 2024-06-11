package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.ConfiguratoreProperties;

public class Giocatore {
	private int cfu;
	private Borsa bag;
	

	static final private int CFU_INIZIALI = ConfiguratoreProperties.getCFU();
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.bag = new Borsa();
	}
	
	public Borsa getBag() {
		return bag;
	}

	public void setBag(Borsa bag) {
		this.bag = bag;
	}

	
	public int getCfu() {
		return this.cfu;
	}

	public void setCfu() {
		 this.cfu --;		
	}	
	
}
