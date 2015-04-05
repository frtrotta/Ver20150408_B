package noleggi;

import java.util.*;

public class Veicolo {
	private String ID;
	private String descrizione;
	private int veicoliTotali;
	@SuppressWarnings("rawtypes")
	private Vector noleggi;
	
	@SuppressWarnings("rawtypes")
	public Veicolo(String ID, String descrizione, int veicoliTotali) {
		if (ID.length() > 0 )
			this.ID = ID;
		else
			throw new IllegalArgumentException("Lunghezza ID deve essere maggiore di 0");
		
		if (descrizione.length() > 0)
			this.descrizione = descrizione;
		else
			throw new IllegalArgumentException("Lunghezza descrizione deve essere maggiore di 0");
		
		if (veicoliTotali > 0)
			this.veicoliTotali = veicoliTotali;
		else
			throw new IllegalArgumentException("Veicoli totali deve essere maggiore di 0");
		noleggi = new Vector();
	}
	
	public String getID() {
		return ID;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public int getVeicoliTotali() {
		return veicoliTotali;
	}
	
	@SuppressWarnings("rawtypes")
	public Vector getNoleggi() {
		return noleggi;
	}
	
	public int getVeicoliDisponibili() {
		int r = veicoliTotali;
		for(int i=0; i<noleggi.size(); i++)
			r -= ((Noleggio)noleggi.elementAt(i)).getVeicoli();
		return r;
	}
	
	@SuppressWarnings("unchecked")
	public void addNoleggio(Noleggio p) throws Exception {
		if(p != null) {
			int postiDisponibili = this.getVeicoliDisponibili();
			int postiRichiesti = p.getVeicoli();
			if(postiRichiesti <= postiDisponibili) {
				noleggi.addElement(p);
			}
			else {
				throw new Exception("Posti disponibili (" + postiDisponibili + ") non sufficienti per i posti richiesti (" + postiRichiesti + ").");
			}
		}
		else {
			throw new IllegalArgumentException("Prenotazione non può essere null");
		}
	}
}
