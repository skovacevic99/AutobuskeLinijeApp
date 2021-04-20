package com.ftninfowrmatika.jwd48.hardi.testback.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Prevoznik;
import com.ftninfowrmatika.jwd48.hardi.testback.service.PrevoznikService;
import com.ftninfowrmatika.jwd48.hardi.testback.web.dto.PrevoznikDTO;

@Component
public class PrevoznikDtoToPrevoznik implements Converter<PrevoznikDTO, Prevoznik>{

	@Autowired
	private PrevoznikService prevoznikService;
	
	@Override
	public Prevoznik convert(PrevoznikDTO dto) {
		Prevoznik entity;
		
		if(dto.getId() == null) {
			entity = new Prevoznik();
		} else {
			entity = prevoznikService.findOneById(dto.getId());
		}
		
		if(entity != null) {
			entity.setAdresa(dto.getAdresa());
			entity.setNaziv(dto.getNaziv());
			entity.setPIB(dto.getPib());
			return entity;
		}
		return null;
	}

}
