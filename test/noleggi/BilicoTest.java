package noleggi;

import static org.junit.Assert.*;

import org.junit.Test;

public class BilicoTest extends VeicoloTest {

	@Test
	public void constructorPortataException() {
		try {
			Bilico b = new Bilico(ID, descrizione, veicoliTotali, 0);
			fail("Eccezione attesa per portata positiva");
		}
		catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Portata deve essere positivo");
		}
	}

}
