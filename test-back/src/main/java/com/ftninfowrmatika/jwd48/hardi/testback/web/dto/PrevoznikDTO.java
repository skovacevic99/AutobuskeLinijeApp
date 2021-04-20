package com.ftninfowrmatika.jwd48.hardi.testback.web.dto;

import javax.validation.constraints.Positive;

public class PrevoznikDTO {

    @Positive(message = "Id mora biti pozitivan broj.")
    private Long id;
    
    private String pib;
    
    private String adresa;
    
    private String naziv;

	public PrevoznikDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
    
}
