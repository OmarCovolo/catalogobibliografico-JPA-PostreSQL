package model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Table(name= "lending")
public class Prestito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "elemento_isbn")
    private Scritti elemento;

    @ManyToOne
    @JoinColumn(name = "libro_isbn", referencedColumnName = "isbn")
    private Libri libro;

    @ManyToOne
    @JoinColumn(name = "rivista_isbn", referencedColumnName = "isbn")
    private Riviste rivista;

    private LocalDate dataInizio;
    private LocalDate dataRestituzionePrevista;
    private LocalDate dataRestituzioneEffettiva;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	public Scritti getElemento() {
		return elemento;
	}
	public void setElemento(Scritti elemento) {
		this.elemento = elemento;
	}
	public Libri getLibro() {
		return libro;
	}
	public void setLibro(Libri libro) {
		this.libro = libro;
	}
	public Riviste getRivista() {
		return rivista;
	}
	public void setRivista(Riviste rivista) {
		this.rivista = rivista;
	}
	public LocalDate getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}
	public LocalDate getDataRestituzionePrevista() {
		return dataRestituzionePrevista;
	}
	public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
		this.dataRestituzionePrevista = dataRestituzionePrevista;
	}
	public LocalDate getDataRestituzioneEffettiva() {
		return dataRestituzioneEffettiva;
	}
	public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
		this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
	}
	@Override
	public String toString() {
		return "Prestito [id=" + id + ", utente=" + utente + ", elemento=" + elemento + ", libro=" + libro
				+ ", rivista=" + rivista + ", dataInizio=" + dataInizio + ", dataRestituzionePrevista="
				+ dataRestituzionePrevista + ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva + "]";
	}

	    
}
