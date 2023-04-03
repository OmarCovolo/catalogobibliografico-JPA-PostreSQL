package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Table(name= "books")
public class Libri extends Scritti {
	@Column(nullable=false)
	String autore;
	@Column(nullable=false)
	String genere;
	@OneToMany(mappedBy = "libro")
    private List<Prestito> prestiti;
	
	
	  public Libri(Long isbn, String titolo, Long annoPubblicazione, Long numPagine, String autore, String genere) {
	        super(isbn, titolo, annoPubblicazione, numPagine);
	        this.autore = autore;
	        this.genere = genere;
	    }


	public String getAutore() {
		return autore;
	}


	public void setAutore(String autore) {
		this.autore = autore;
	}


	public String getGenere() {
		return genere;
	}


	public void setGenere(String genere) {
		this.genere = genere;
	}


	@Override
	public String toString() {
		return "Libri [autore=" + autore + ", genere=" + genere + "]";
	}
	
}
