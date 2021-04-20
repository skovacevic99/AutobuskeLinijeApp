package com.ftninfowrmatika.jwd48.hardi.testback.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Linija;
import com.ftninfowrmatika.jwd48.hardi.testback.service.LinijaService;
import com.ftninfowrmatika.jwd48.hardi.testback.service.PrevoznikService;
import com.ftninfowrmatika.jwd48.hardi.testback.web.dto.LinijaDTO;

@Component
public class LinijaDtoToLinija implements Converter<LinijaDTO, Linija> {
	
	@Autowired
	private LinijaService linijaServie;
	
	@Autowired
	private PrevoznikService prevoznikService;

	@Override
	public Linija convert(LinijaDTO dto) {
		Linija entity;
		
		if(dto.getId() == null) {
			entity = new Linija();
		} else {
			entity = linijaServie.findOneById(dto.getId());
		}
		
		if(entity != null) {
			entity.setBrojMesta(dto.getBrojMesta());
			entity.setCenaKarte(dto.getCenaKarte());
			entity.setDestinacija(dto.getDestinacija());
			entity.setPrevoznik(prevoznikService.findOneById(dto.getPrevoznikId()));
			entity.setVremePolaska(dto.getVremePolaska());
			return entity;
		}
		return null;
	}

}
