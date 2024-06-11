package it.uniroma3.diadia.personaggi;

import java.util.List;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio{
	private static final String MESSAGGIO_REGALO = "AHAHAHAHAH";
	public Strega(String nome, String presentaz) {
		super(nome, presentaz);

	}

	@Override
	public String agisci(Partita partita) {
		List<Stanza> stanzeAdiacenti = partita.getLab().getStanzaCorrente().getStanzeAdiacenti();
		if (this.haSalutato()) {
			Stanza stanzaPiuOggetti = stanzeAdiacenti.get(0);
			for (Stanza s : stanzeAdiacenti) {
				if(s.getNumeroAttrezzi() >= stanzaPiuOggetti.getNumeroAttrezzi())
					stanzaPiuOggetti = s;
			}
			partita.getLab().setStanzaCorrente(stanzaPiuOggetti);
		}
		else {
			Stanza stanzaMenoOggetti = stanzeAdiacenti.get(0);
			for (Stanza s : stanzeAdiacenti) {
				if(s.getNumeroAttrezzi() <= stanzaMenoOggetti.getNumeroAttrezzi())
					stanzaMenoOggetti = s;
			}
			partita.getLab().setStanzaCorrente(stanzaMenoOggetti);

		}
		return null;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		partita.getPlayer().getBag().removeAttrezzo(attrezzo.getNome());
		return MESSAGGIO_REGALO;
	}

}
