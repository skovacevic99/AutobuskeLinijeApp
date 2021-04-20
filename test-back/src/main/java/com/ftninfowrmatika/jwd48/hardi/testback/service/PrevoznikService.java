package com.ftninfowrmatika.jwd48.hardi.testback.service;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Prevoznik;

import java.util.List;

public interface PrevoznikService {

	List<Prevoznik> findAll();
	
	Prevoznik findOneById(Long id);
	
	Prevoznik save(Prevoznik prevoznik);
}
