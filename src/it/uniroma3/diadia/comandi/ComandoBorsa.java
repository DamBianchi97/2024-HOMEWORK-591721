package it.uniroma3.diadia.comandi;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoBorsa implements Comando{

	private String metodoOrdinamento;

	@Override 
	public void esegui(Partita partita) {
		IO io = new IOConsole();
		if (metodoOrdinamento != null && metodoOrdinamento.equals(new String("lista"))) {
			List<Attrezzo> list = partita.getPlayer().getBag().getContenutoOrdinatoPerPeso();
			io.mostraMessaggioSequenziale("{ ");
			for (Attrezzo it : list) io.mostraMessaggioSequenziale(it.getNome()+" ");
			io.mostraMessaggio("}");
		}
		else if (metodoOrdinamento != null && metodoOrdinamento.equals(new String("set"))) {
			SortedSet<Attrezzo> it = partita.getPlayer().getBag().getContenutoOrdinatoPerNome();
			io.mostraMessaggioSequenziale("[ ");
			for (Attrezzo tmp : it) io.mostraMessaggioSequenziale(tmp.getNome()+" ");
			io.mostraMessaggio("]");
		}
		else if (metodoOrdinamento != null && metodoOrdinamento.equals(new String("mappa"))) {
			Map<Integer,Set<Attrezzo>> map = partita.getPlayer().getBag().getContenutoRaggruppatoPerPeso();
			for (Integer k : map.keySet()) {
				Set<Attrezzo> value = map.get(k);
				// io.mostraMessaggioSequenziale("( "+ k);
				io.mostraMessaggio("( "+ k + "{ " + value + " } ) ;");	
			}		
		}
		else io.mostraMessaggio(partita.getPlayer().getBag().toString());
	}

	@Override
	public void setParametro(String parametro) {
		this.metodoOrdinamento = parametro;

	}

	@Override
	public String getNome() {
		return "borsa";
	}

	@Override
	public String getParametro() {
		return this.metodoOrdinamento;
	}
}
