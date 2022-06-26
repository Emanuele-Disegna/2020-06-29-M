package it.polito.tdp.imdb.model;

public class RegistaAdiacente {
	private Director d;
	private int peso;
	public RegistaAdiacente(Director d, int peso) {
		super();
		this.d = d;
		this.peso = peso;
	}
	public Director getD() {
		return d;
	}
	public void setD(Director d) {
		this.d = d;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	@Override
	public String toString() {
		return d + " con peso " + peso +"\n";
	}
	
	
}	
