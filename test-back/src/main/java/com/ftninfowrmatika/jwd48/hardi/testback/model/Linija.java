package com.ftninfowrmatika.jwd48.hardi.testback.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Linija {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false)
	private Integer brojMesta;
	
	@Column
	private Double cenaKarte;
	
	@Column
	private String vremePolaska;
	
	@Column(nullable = false)
	private String destinacija;
	
	@ManyToOne
	private Prevoznik prevoznik;
	
	@OneToMany(mappedBy = "linija", cascade = CascadeType.ALL)
	private List<Rezervacija> rezervacije = new ArrayList<Rezervacija>();

	public Linija() {
	}

	public Linija(Integer brojMesta, Double cenaKarte, String vremePolaska, String destinacija, Prevoznik prevoznik) {
		this.brojMesta = brojMesta;
		this.cenaKarte = cenaKarte;
		this.vremePolaska = vremePolaska;
		this.destinacija = destinacija;
		this.prevoznik = prevoznik;
	}

	public Linija(Long id, Integer brojMesta, Double cenaKarte, String vremePolaska, String destinacija,
			Prevoznik prevoznik) {
		this.id = id;
		this.brojMesta = brojMesta;
		this.cenaKarte = cenaKarte;
		this.vremePolaska = vremePolaska;
		this.destinacija = destinacija;
		this.prevoznik = prevoznik;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Linija other = (Linija) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getBrojMesta() {
		return brojMesta;
	}

	public void setBrojMesta(Integer brojMesta) {
		this.brojMesta = brojMesta;
	}

	public Double getCenaKarte() {
		return cenaKarte;
	}

	public void setCenaKarte(Double cenaKarte) {
		this.cenaKarte = cenaKarte;
	}

	public String getVremePolaska() {
		return vremePolaska;
	}

	public void setVremePolaska(String vremePolaska) {
		this.vremePolaska = vremePolaska;
	}

	public String getDestinacija() {
		return destinacija;
	}

	public void setDestinacija(String destinacija) {
		this.destinacija = destinacija;
	}

	public Prevoznik getPrevoznik() {
		return prevoznik;
	}

	public void setPrevoznik(Prevoznik prevoznik) {
		this.prevoznik = prevoznik;
	}
	
	public List<Rezervacija> getRezervacije() {
		return rezervacije;
	}

	public void setRezervacije(List<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	}

	@Override
	public String toString() {
		return "Linija [id=" + id + ", brojMesta=" + brojMesta + ", cenaKarte=" + cenaKarte + ", vremePolaska="
				+ vremePolaska + ", destinacija=" + destinacija + ", prevoznik=" + prevoznik + "]";
	}
	
}
