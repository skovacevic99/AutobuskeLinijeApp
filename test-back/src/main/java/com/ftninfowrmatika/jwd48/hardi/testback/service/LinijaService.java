package com.ftninfowrmatika.jwd48.hardi.testback.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Linija;

public interface LinijaService {

	List<Linija> findAll();
	
	Linija findOneById(Long id);
	
	Linija save(Linija linija);
	
	Linija update(Linija linija);
	
	Linija delete(Long id);

	Page<Linija> find(String destinacija, Long prevoznikId, Double maksCena, int pageNo);
}
