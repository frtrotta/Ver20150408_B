package noleggi;

import static org.junit.Assert.*;

import org.junit.Test;

public class AutoTest extends VeicoloTest {

	@Test
	public void constructorPorteaException() {
		try {
			Auto a = new Auto(ID, descrizione, veicoliTotali, 0);
			fail("Eccezione attesa per porte positivo");
		}
		catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Porte deve essere positivo");
		}
	}

}
