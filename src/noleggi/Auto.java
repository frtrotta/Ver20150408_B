package noleggi;

public class Auto extends Veicolo {
	private int porte;
	
	public Auto(String ID, String descrizione, int veicoliTotali, int porte) {
		super(ID, descrizione, veicoliTotali);
		if(porte > 0)
			this.porte = porte;
		else
			throw new IllegalArgumentException("Porte deve essere positivo");
	}

	public int getDivorzi() {
		return porte;
	}
}
