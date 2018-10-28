package ats.modello;

import java.util.Date;

public class Viaggio {
	private Long id;
	private Autista autista;
	private Taxi taxi;
	private Cliente cliente;
	private Date data;
	private String partenza;
	private String destinazione;
	private Double kilometri;
	private Double prezzo;
	private Integer stato;
	private Integer feedback;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Autista getAutista() {
		return autista;
	}
	public void setAutista(Autista autista) {
		this.autista = autista;
	}
	public Taxi getTaxi() {
		return taxi;
	}
	public void setTaxi(Taxi taxi) {
		this.taxi = taxi;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getPartenza() {
		return partenza;
	}
	public void setPartenza(String partenza) {
		this.partenza = partenza;
	}
	public String getDestinazione() {
		return destinazione;
	}
	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
	}
	public Double getKilometri() {
		return kilometri;
	}
	public void setKilometri(Double kilometri) {
		this.kilometri = kilometri;
	}
	public Double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}
	public Integer getStato() {
		return stato;
	}
	public void setStato(Integer stato) {
		this.stato = stato;
	}
	public Integer getFeedback() {
		return feedback;
	}
	public void setFeedback(Integer feedback) {
		this.feedback = feedback;
	}
	@Override
	public String toString() {
		return "Viaggio [id=" + id + ", autista=" + autista.getId() + ", taxi=" + taxi.getId() + ", cliente=" + cliente.getId() + ", data="
				+ data + ", partenza=" + partenza + ", destinazione=" + destinazione + ", kilometri=" + kilometri
				+ ", prezzo=" + prezzo + ", stato=" + stato + ", feedback=" + feedback + "]";
	}
	
}
