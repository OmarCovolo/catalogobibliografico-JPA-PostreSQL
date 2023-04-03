package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Table(name= "scritti")
public class Scritti implements Serializable{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "ISBN")
	private Long isbn;
	@Column(nullable=false)
	private String titolo;
	@Column(nullable=false)
	private Long annopubblicazione;
	@Column(nullable=false)
	private Long numeropagine;
	@OneToMany(mappedBy = "elemento")
    private List<Prestito> prestiti;
	
	

	    public Scritti(Long isbn, String titolo, Long annoPubblicazione, Long numPagine) {
	        this.isbn = isbn;
	        this.titolo = titolo;
	        this.annopubblicazione = annoPubblicazione;
	        this.numeropagine = numPagine;
	    }




	@Override
	public String toString() {
		return "Scritti [isbn=" + isbn + ", titolo=" + titolo + ", annopubblicazione=" + annopubblicazione
				+ ", numeropagine=" + numeropagine + "]";
	}
	
	public Long getIsbn() {
		return isbn;
	}
	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public Long getAnnopubblicazione() {
		return annopubblicazione;
	}
	public void setAnnopubblicazione(Long annopubblicazione) {
		this.annopubblicazione = annopubblicazione;
	}
	public Long getNumeropagine() {
		return numeropagine;
	}
	public void setNumeropagine(Long numeropagine) {
		this.numeropagine = numeropagine;
	}
	
}
