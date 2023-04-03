package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Table(name= "user")

public class Utente {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long numerotessera;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String cognome;
	@Column(nullable=false)
	private LocalDate datanascita;
	@OneToMany(mappedBy = "utente")
    private List<Prestito> prestiti;
	
	
    public Utente(String nome, String cognome, LocalDate datanascita, Long numerotessera) {
        this.nome = nome;
        this.cognome = cognome;
        this.datanascita = datanascita;
        this.numerotessera = numerotessera;
    }
	
	
	
	
	
	@Override
	public String toString() {
		return "Utente [numerotessera=" + numerotessera + ", nome=" + nome + ", cognome=" + cognome + ", datanascita="
				+ datanascita + "]";
	}
	
	public Long getNumerotessera() {
		return numerotessera;
	}
	public void setNumerotessera(Long numerotessera) {
		this.numerotessera = numerotessera;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public LocalDate getDatanascita() {
		return datanascita;
	}
	public void setDatanascita(LocalDate datanascita) {
		this.datanascita = datanascita;
	}
	


}
