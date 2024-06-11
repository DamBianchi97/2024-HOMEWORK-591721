package it.uniroma3.diadia.giocatore;


import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.ConfiguratoreProperties;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.AttrezzoComparatorNome;
import it.uniroma3.diadia.attrezzi.AttrezzoComparatorPeso;


public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = ConfiguratoreProperties.getPesoMax();
	private LinkedList<Attrezzo> attrezzi;
	private int pesoMax;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new LinkedList<>(); 
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax()) return false;
		this.attrezzi.add(attrezzo);
		return true;
	}

	public int getPesoMax() {
		return pesoMax;
	}
	
	  /**
     * Restituisce l'oggetto attrezzo corrispondente al nome inserito.
     * @param nomeAttrezzo il nome dell'attrezzo da cercare.
     * @return l'oggetto Attrezzo corrispondente al nome cercato.
     */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		for(Attrezzo it : this.attrezzi) {
			if (it.getNome().equals(nomeAttrezzo)) return it;
		}
		return null;
	}

	public int getPeso() {
		int peso = 0;
		for(Attrezzo a : this.attrezzi)
				peso += a.getPeso();
		return peso;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	public boolean removeAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.remove(getAttrezzo(nomeAttrezzo));
	}
	
	public LinkedList<Attrezzo> getListaAttrezzi(){
		return this.attrezzi;
	}
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> list = new LinkedList<Attrezzo>();
		list.addAll(this.attrezzi);
		Collections.sort(list, new AttrezzoComparatorPeso());
		return list;
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		SortedSet<Attrezzo> it = new TreeSet<Attrezzo>(new AttrezzoComparatorNome());
		it.addAll(this.attrezzi);
		return it;
	}
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		SortedSet<Attrezzo> it = new TreeSet<Attrezzo>(new AttrezzoComparatorPeso());
		it.addAll(this.attrezzi);
		return it;
	}
	
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer,Set<Attrezzo>> map = new HashMap<>();
		for (Attrezzo a : this.attrezzi) {
			if (!map.containsKey(a.getPeso())) {
				Set<Attrezzo> tmp = new HashSet<Attrezzo>();
				tmp.add(a);
				map.put(a.getPeso(), tmp);
			}
			else map.get(a.getPeso()).add(a);
		}
		return map;	
	}
	
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.attrezzi.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (Attrezzo it : this.attrezzi) s.append(it.toString()+" ");				
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}
