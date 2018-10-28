package ats.modello;

public class Taxi {
	private Long id;
	private String marca;
	private String modello;
	private String targa;
	private Integer annoDiImmatricolazione;
	private Integer posti;
	private Double prezzoPerKilometro;
	private Boolean disponibile;
	private Autista autista;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public Integer getAnnoDiImmatricolazione() {
		return annoDiImmatricolazione;
	}
	public void setAnnoDiImmatricolazione(Integer annoDiImmatricolazione) {
		this.annoDiImmatricolazione = annoDiImmatricolazione;
	}
	public Integer getPosti() {
		return posti;
	}
	public void setPosti(Integer posti) {
		this.posti = posti;
	}
	public Double getPrezzoPerKilometro() {
		return prezzoPerKilometro;
	}
	public void setPrezzoPerKilometro(Double prezzoPerKilometro) {
		this.prezzoPerKilometro = prezzoPerKilometro;
	}
	public Boolean getDisponibile() {
		return disponibile;
	}
	public void setDisponibile(Boolean disponibile) {
		this.disponibile = disponibile;
	}
	public Autista getAutista() {
		return autista;
	}
	public void setAutista(Autista autista) {
		this.autista = autista;
	}
	@Override
	public String toString() {
		return "Taxi [id=" + id + ", marca=" + marca + ", modello=" + modello + ", targa=" + targa
				+ ", annoDiImmatricolazione=" + annoDiImmatricolazione + ", posti=" + posti + ", prezzoPerKilometro="
				+ prezzoPerKilometro + ", disponibile=" + disponibile + ", autista=" + autista.getId() + "]";
	}
	
	
}
