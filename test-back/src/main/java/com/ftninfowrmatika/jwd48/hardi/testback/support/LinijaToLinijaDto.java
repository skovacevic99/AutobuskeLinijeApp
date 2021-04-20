package com.ftninfowrmatika.jwd48.hardi.testback.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Linija;
import com.ftninfowrmatika.jwd48.hardi.testback.web.dto.LinijaDTO;

@Component
public class LinijaToLinijaDto implements Converter<Linija, LinijaDTO> {

	@Override
	public LinijaDTO convert(Linija source) {
		LinijaDTO dto = new LinijaDTO();
		dto.setBrojMesta(source.getBrojMesta());
		dto.setCenaKarte(source.getCenaKarte());
		dto.setDestinacija(source.getDestinacija());
		dto.setId(source.getId());
		dto.setPrevoznikId(source.getPrevoznik().getId());
		dto.setPrevoznikNaziv(source.getPrevoznik().getNaziv());
		dto.setVremePolaska(source.getVremePolaska());
		return dto;
	}
	
	public List<LinijaDTO> convert(List<Linija> linije){
		List<LinijaDTO> dto = new ArrayList<LinijaDTO>();
		for(Linija linija : linije) {
			dto.add(convert(linija));
		}
		return dto;
	}

}
