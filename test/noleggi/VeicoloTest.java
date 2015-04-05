package noleggi;

import static org.junit.Assert.*;

import org.junit.Test;

public class VeicoloTest {
	protected String ID = "id";
	protected String descrizione = "Un bel veicolo da noleggiare";
	protected int veicoliTotali = 5;
	
	@Test
	public void constructorIDException() {
		try {
			Veicolo v = new Veicolo("", descrizione, veicoliTotali);
			fail("Eccezione attesa per id di lunghezza 0");
		}
		catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Lunghezza ID deve essere maggiore di 0");
		}
	}
		
	@Test
	public void constructorDescrizioneException() {
		try {
			Veicolo v = new Veicolo(ID, "", veicoliTotali);
			fail("Eccezione attesa per descrizione di lunghezza 0");
		}
		catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Lunghezza descrizione deve essere maggiore di 0");
		}
	}
	
	@Test
	public void constructorVeicoliTotaliException() {
		try {
			Veicolo v = new Veicolo(ID, descrizione, 0);
			fail("Eccezione attesa per veicoli totali maggiori di 0");
		}
		catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Veicoli totali deve essere maggiore di 0");
		}
	}
	
	@Test
	public void veicoliDisponibili() throws Exception {
		final int veicoliTotali = 40;
		final int veicoliRichiesti = 10;
		Veicolo v = new Veicolo(ID, descrizione, veicoliTotali);
		Cliente c = new Cliente("Ciccio", "Formaggio", "ciccio@formaggio.com");
		for(int i=0; i<veicoliRichiesti; i++) {
			v.addNoleggio(new Noleggio("id" + i, c, 1));
		}
		assertEquals(v.getVeicoliDisponibili(), veicoliTotali - veicoliRichiesti);
	}
		
	@Test
	public void veicoliNonDisponibili() throws Exception {
		final int veicoliTotali = 40;
		final int veicoliRichiesti = 40;
		Veicolo v = new Veicolo(ID, descrizione, veicoliTotali);
		Cliente c = new Cliente("Ciccio", "Formaggio", "ciccio@formaggio.com");
		for(int i=0; i<veicoliRichiesti; i++) {
			v.addNoleggio(new Noleggio("id" + i, c, 1));
		}
		try {
			v.addNoleggio(new Noleggio("id-overflow", c, 1));
			fail("Attesa eccezione veicoli non diponibili");
		}
		catch(Exception e) {
			assertEquals(e.getMessage(), "Veicoli disponibili (0) non sufficienti per i veicoli richiesti (1).");
		}
		
		
	}
}
