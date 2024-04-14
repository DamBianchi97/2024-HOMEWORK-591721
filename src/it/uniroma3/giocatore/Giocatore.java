package it.uniroma3.giocatore;

public class Giocatore {
	private int cfu;
	private Borsa bag;
	

	static final private int CFU_INIZIALI = 20;
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
