package com.ftninfowrmatika.jwd48.hardi.testback.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Linija;
import com.ftninfowrmatika.jwd48.hardi.testback.repository.LinijaRepository;
import com.ftninfowrmatika.jwd48.hardi.testback.service.LinijaService;

@Service
public class JpaLinijaService implements LinijaService {
	
	@Autowired
	private LinijaRepository linijaRepository;

	@Override
	public List<Linija> findAll() {
		return linijaRepository.findAll();
	}

	@Override
	public Linija findOneById(Long id) {
		return linijaRepository.findOneById(id);
	}

	@Override
	public Linija save(Linija linija) {
		return linijaRepository.save(linija);
	}

	@Override
	public Linija update(Linija linija) {
		return linijaRepository.save(linija);
	}

	@Override
	public Linija delete(Long id) {
		Linija linija = linijaRepository.findOneById(id);
		if(linija != null) {
			linijaRepository.deleteById(id);
			return linija;
		}
		return null;
	}

	@Override
	public Page<Linija> find(String destinacija, Long prevoznikId, Double maksCena, int pageNo) {
		return linijaRepository.search(destinacija, prevoznikId, maksCena, PageRequest.of(pageNo, 4));
	}

}
