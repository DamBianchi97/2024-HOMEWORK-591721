package it.uniroma3.diadia.ambienti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
 */

public class Stanza {

	private String nome;
	private Set<Attrezzo> attrezzi;
	private Map<Direzioni,Stanza> stanzeAdiacenti;
	private AbstractPersonaggio personaggio;


	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome il nome della stanza
	 */
	public Stanza(String nome) {
		this.nome = nome;
		this.stanzeAdiacenti = new HashMap<>();
		this.attrezzi = new HashSet<>();
	}

	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public void impostaStanzaAdiacente(Direzioni direzione, Stanza stanza) {
		if (!this.stanzeAdiacenti.containsKey(direzione)) {
			this.stanzeAdiacenti.put(direzione,stanza);
		}
	}
	
	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 */
	public List<Stanza> getStanzeAdiacenti() {
		List<Stanza> list = new ArrayList<Stanza>();
		for (Stanza stanza : stanzeAdiacenti.values()) {
			list.add(stanza);
		}
		return list;
	}
	
	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(Direzioni direzione) {
		return this.stanzeAdiacenti.get(direzione);
	}

	/**
	 * Restituisce la nome della stanza.
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
	public Set<Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		return (this.attrezzi.add(attrezzo));
	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		risultato.append("\nUscite: ");
		this.stanzeAdiacenti.forEach((key, value) -> risultato.append(" " + key));
		risultato.append("\nAttrezzi nella stanza: ");
		for (Attrezzo attrezzo : this.attrezzi) {
			risultato.append(attrezzo.toString()+" ");
		}
		if (this.getPersonaggio()!= null)
		risultato.append("\nPersonaggio nella stanza: " + this.getPersonaggio());
		return risultato.toString();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		for (Attrezzo it : this.attrezzi) {
			if (it.getNome().equals(nomeAttrezzo)) return true;
		}
		return false;
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;
		for (Attrezzo attrezzo : this.attrezzi) {
			if (attrezzo != null && attrezzo.getNome().equals(nomeAttrezzo))
				attrezzoCercato = attrezzo;
		}
		return attrezzoCercato;	
	}

	@Override
	public int hashCode() {
		return this.nome.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stanza that = (Stanza) obj;
		return this.getNome().equals(that.getNome());
	}
	
	
	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		return (this.attrezzi.remove(attrezzo));
	}


	public int getNumeroAttrezzi() {
		return this.attrezzi.size();
	}

	public Set<Direzioni> getDirezioni() {
		return this.stanzeAdiacenti.keySet();
	}

	public void setPersonaggio(AbstractPersonaggio personaggio) {
		this.personaggio = personaggio;
	}
	public AbstractPersonaggio getPersonaggio() {
		return this.personaggio;
	}
}