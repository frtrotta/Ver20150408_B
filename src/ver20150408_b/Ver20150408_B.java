package ver20150408_b;

import noleggi.*;

public class Ver20150408_B {

	public static void main(String[] args) throws Exception {
		Bilico a = new Bilico("a1", "Un bilico capiente", 5, 10000);

		Cliente c = new Cliente("Ciccio", "Formaggio", "ciccio@formaggio.com");
		
		Noleggio n = new Noleggio("p1", c, 2);
		a.addNoleggio(n);
		System.out.println("Prenotazioni: " + a.getNoleggi().size());
		n = new Noleggio("p2", c, 1);
		a.addNoleggio(n);
		System.out.println("Prenotazioni: " + a.getNoleggi().size());
		try {
			n = new Noleggio("p3", c, 4);
			throw new Exception("Eccezione non lanciata");
		}
		catch (Exception e) {
			System.out.println("Prenotazione non aggiunta");
			System.out.println("Prenotazioni: " + a.getNoleggi().size());
		}
	}

}
