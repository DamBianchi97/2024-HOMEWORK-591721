package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;


public abstract class AbstractComando implements Comando{
	private static final String NOME = "AbstractComando";
	private IO io;
	private String parametro;
	
	abstract public void esegui(Partita partita);
	
	@Override
	public String getNome() {
		return this.NOME;
	}
	
	@Override
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	
	@Override
	public String getParametro() {
		return this.parametro;
	}
	
	@Override
	public void setIo(IO io) {
		this.io = io;
	}
	
	public IO getIo() {
		return this.io;
	}
}
