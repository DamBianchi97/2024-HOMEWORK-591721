package it.uniroma3.diadia.comandi;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoBorsa extends AbstractComando{

	private static final String NOME = "borsa";
	
	@Override 
	public void esegui(Partita partita) {
		if (this.getParametro() != null && this.getParametro().equals(new String("lista"))) {
			List<Attrezzo> list = partita.getPlayer().getBag().getContenutoOrdinatoPerPeso();
			this.getIo().mostraMessaggioSequenziale("{ ");
			for (Attrezzo it : list) this.getIo().mostraMessaggioSequenziale(it.getNome()+" ");
			this.getIo().mostraMessaggio("}");
		}
		else if (this.getParametro() != null && this.getParametro().equals(new String("set"))) {
			SortedSet<Attrezzo> it = partita.getPlayer().getBag().getContenutoOrdinatoPerNome();
			this.getIo().mostraMessaggioSequenziale("[ ");
			for (Attrezzo tmp : it) this.getIo().mostraMessaggioSequenziale(tmp.getNome()+" ");
			this.getIo().mostraMessaggio("]");
		}
		else if (this.getParametro() != null && this.getParametro().equals(new String("mappa"))) {
			Map<Integer,Set<Attrezzo>> map = partita.getPlayer().getBag().getContenutoRaggruppatoPerPeso();
			for (Integer k : map.keySet()) {
				Set<Attrezzo> value = map.get(k);
				// io.mostraMessaggioSequenziale("( "+ k);
				this.getIo().mostraMessaggio("( "+ k + "{ " + value + " } ) ;");	
			}		
		}
		else this.getIo().mostraMessaggio(partita.getPlayer().getBag().toString());
	}
	
}
