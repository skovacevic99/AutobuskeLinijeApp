package com.ftninfowrmatika.jwd48.hardi.testback.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.sun.istack.NotNull;

public class LinijaDTO {

    @Positive(message = "Id mora biti pozitivan broj.")
    private Long id;
    
    @Positive(message = "Broj mesta mora biti pozitivna vrednost.")
    private Integer brojMesta;
    
    private Double cenaKarte;
    
    @NotNull
    @NotBlank(message = "Destinacija ne moze ostati prazan tekst.")
    private String destinacija;
    
    private String vremePolaska;
    
    private Long prevoznikId;
    
    private String prevoznikNaziv;

	public LinijaDTO() {
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

	public String getDestinacija() {
		return destinacija;
	}

	public void setDestinacija(String destinacija) {
		this.destinacija = destinacija;
	}

	public String getVremePolaska() {
		return vremePolaska;
	}

	public void setVremePolaska(String vremePolaska) {
		this.vremePolaska = vremePolaska;
	}

	public Long getPrevoznikId() {
		return prevoznikId;
	}

	public void setPrevoznikId(Long prevoznikId) {
		this.prevoznikId = prevoznikId;
	}

	public String getPrevoznikNaziv() {
		return prevoznikNaziv;
	}

	public void setPrevoznikNaziv(String prevoznikNaziv) {
		this.prevoznikNaziv = prevoznikNaziv;
	}
    
}
