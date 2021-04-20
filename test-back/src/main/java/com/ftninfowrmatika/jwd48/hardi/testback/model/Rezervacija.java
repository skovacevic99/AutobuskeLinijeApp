package com.ftninfowrmatika.jwd48.hardi.testback.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Rezervacija {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
	private Linija linija;

	public Rezervacija() {
	}
	
	public Rezervacija(Long id, Linija linija) {
		this.id = id;
		this.linija = linija;
	}
	
	public Rezervacija(Linija linija) {
		this.linija = linija;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Linija getLinija() {
		return linija;
	}

	public void setLinija(Linija linija) {
		this.linija = linija;
	}
	
	
}
