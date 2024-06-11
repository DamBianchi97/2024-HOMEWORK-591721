package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {


	private Labirinto lab;
	private Giocatore player;
	
	public Partita(Labirinto labirinto) {
		this.lab = labirinto;
		player = new Giocatore();
		this.finita = false;
	}
	
	public Giocatore getPlayer() {
		return player;
	}
	public void setPlayer(Giocatore player) {
		this.player = player;
	}
	public Labirinto getLab() {
		return lab;
	}
	public void setLab(Labirinto lab) {
		this.lab = lab;
	}

	private boolean finita;

	

	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.lab.getStanzaCorrente()== this.lab.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.getPlayer().getCfu() == 0);
	}

	public boolean haiPerso() {
		return this.getPlayer().getCfu()==0;
	}
	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}


}
