package com.ftninfowrmatika.jwd48.hardi.testback.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Prevoznik;
import com.ftninfowrmatika.jwd48.hardi.testback.web.dto.PrevoznikDTO;

@Component
public class PrevoznikToPrevoznikDto implements Converter<Prevoznik, PrevoznikDTO> {

	@Override
	public PrevoznikDTO convert(Prevoznik source) {
		PrevoznikDTO dto = new PrevoznikDTO();
		dto.setAdresa(source.getAdresa());
		dto.setId(source.getId());
		dto.setNaziv(source.getNaziv());
		dto.setPib(source.getPIB());
		return dto;
	}
	
	public List<PrevoznikDTO> convert(List<Prevoznik> prevoznici){
		List<PrevoznikDTO> dto = new ArrayList<PrevoznikDTO>();
		for(Prevoznik p : prevoznici) {
			dto.add(convert(p));
		}
		return dto;
	}

}
