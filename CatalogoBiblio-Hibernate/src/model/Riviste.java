package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Table(name= "magazines")
class Riviste extends Scritti {

	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
    private Peridicita periodicita;
	@OneToMany(mappedBy = "rivista")
    private List<Prestito> prestiti;

    public Riviste(Long isbn, String titolo, Long annoPubblicazione, Long numPagine, Peridicita periodicita) {
        super(isbn, titolo, annoPubblicazione, numPagine);
        this.periodicita = periodicita;
    }

	public Peridicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Peridicita periodicita) {
		this.periodicita = periodicita;
	}

	@Override
	public String toString() {
		return "Riviste [periodicita=" + periodicita + "]";
	}
    
}