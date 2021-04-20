package com.ftninfowrmatika.jwd48.hardi.testback.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Prevoznik;
import com.ftninfowrmatika.jwd48.hardi.testback.repository.PrevoznikRepository;
import com.ftninfowrmatika.jwd48.hardi.testback.service.PrevoznikService;

@Service
public class JpaPrevoznikService implements PrevoznikService {

	@Autowired
	private PrevoznikRepository prevoznikRepository;
	
	@Override
	public List<Prevoznik> findAll() {
		return prevoznikRepository.findAll();
	}

	@Override
	public Prevoznik findOneById(Long id) {
		return prevoznikRepository.findOneById(id);
	}

	@Override
	public Prevoznik save(Prevoznik prevoznik) {
		return prevoznikRepository.save(prevoznik);
	}

}
