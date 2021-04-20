package com.ftninfowrmatika.jwd48.hardi.testback.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Prevoznik;
import com.ftninfowrmatika.jwd48.hardi.testback.service.PrevoznikService;
import com.ftninfowrmatika.jwd48.hardi.testback.support.PrevoznikDtoToPrevoznik;
import com.ftninfowrmatika.jwd48.hardi.testback.support.PrevoznikToPrevoznikDto;
import com.ftninfowrmatika.jwd48.hardi.testback.web.dto.PrevoznikDTO;

@RestController
@RequestMapping(value = "/api/prevoznici", produces = MediaType.APPLICATION_JSON_VALUE)
public class PrevoznikController {
	
	@Autowired
	private PrevoznikService prevoznikService;
	
	@Autowired
	private PrevoznikDtoToPrevoznik toPrevoznik;
	
	@Autowired
	private PrevoznikToPrevoznikDto toDto;
	
	@GetMapping
	public ResponseEntity<List<PrevoznikDTO>> getAll(){
		
		List<Prevoznik> prevoznici = prevoznikService.findAll();
		
		return new ResponseEntity<List<PrevoznikDTO>>(toDto.convert(prevoznici), HttpStatus.OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PrevoznikDTO> create(@Valid @RequestBody PrevoznikDTO dto){
		
		Prevoznik prevoznik = toPrevoznik.convert(dto);
		Prevoznik dodat = prevoznikService.save(prevoznik);
		
		return new ResponseEntity<PrevoznikDTO>(toDto.convert(dodat), HttpStatus.CREATED);
	}

}
