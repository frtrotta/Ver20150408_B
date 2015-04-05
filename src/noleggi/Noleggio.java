package noleggi;

public class Noleggio {
	private String ID;
	private Cliente cliente;
	private int veicoli;
	
	public Noleggio(String ID, Cliente cliente, int veicoli) {
		if (ID.length() > 0)
			this.ID = ID;
		else
			throw new IllegalArgumentException("Lunghezza ID deve essere maggiore di 0");
		
		if (cliente != null)
			this.cliente = cliente;
		else
			throw new IllegalArgumentException("Cliente non può essere null");
		
		if (veicoli > 0)
			this.veicoli = veicoli;
		else
			throw new IllegalArgumentException("Veicoli deve essere maggiore di 0");
	}

	public String getID() {
		return ID;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public int getVeicoli() {
		return veicoli;
	}

	@Override
	public String toString() {
		return "Noleggio [ID=" + ID + ", cliente=" + cliente + ", veicoli="
				+ veicoli + "]";
	}
}
