package noleggi;

import static org.junit.Assert.*;

import org.junit.Test;

public class NoleggioTest {
	private final String ID = "id";
	private final Cliente cliente = new Cliente("Ciccio", "Formaggio", "ciccio@formaggio.com");
	private int posti = 17;
	
	@Test
	public void constructorIDException() {
		try {
			Noleggio n = new Noleggio("", cliente, posti);
			fail("Eccezione attesa per id di lunghezza 0");
		}
		catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Lunghezza ID deve essere maggiore di 0");
		}
	}
	
	@Test
	public void constructorClientException() {
		try {
			Noleggio n = new Noleggio(ID, null, posti);
			fail("Eccezione attesa per cliente non null");
		}
		catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Cliente non può essere null");
		}
	}
	
	@Test
	public void constructorVeicoliException() {
		try {
			Noleggio n = new Noleggio(ID, cliente, 0);
			fail("Eccezione attesa per veicoli non postivi");
		}
		catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Veicoli deve essere maggiore di 0");
		}
	}

}
