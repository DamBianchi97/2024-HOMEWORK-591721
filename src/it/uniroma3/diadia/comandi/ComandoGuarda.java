package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {

	@Override
	public void esegui(Partita partita) {
		IO io = new IOConsole();
		io.mostraMessaggio(partita.getLab().getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("CFU rimanenti :"+ partita.getPlayer().getCfu());
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}
	@Override
	public String getNome() {
		return "guarda";
	}

	@Override
	public String getParametro() {
		return null;
	}
}
