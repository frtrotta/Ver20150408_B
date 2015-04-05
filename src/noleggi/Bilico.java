package noleggi;

public class Bilico extends Veicolo {
	private double portata;

	public Bilico(String ID, String descrizione, int veicoliTotali, double portata) {
		super(ID, descrizione, veicoliTotali);
		if(portata > 0)
			this.portata = portata;
		else
			throw new IllegalArgumentException("Portata deve essere positivo");
	}

	public double getDispersi() {
		return portata;
	}
}
