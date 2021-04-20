package com.ftninfowrmatika.jwd48.hardi.testback.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Linija;
import com.ftninfowrmatika.jwd48.hardi.testback.model.Rezervacija;
import com.ftninfowrmatika.jwd48.hardi.testback.service.LinijaService;
import com.ftninfowrmatika.jwd48.hardi.testback.service.RezervacijaService;
import com.ftninfowrmatika.jwd48.hardi.testback.support.LinijaDtoToLinija;
import com.ftninfowrmatika.jwd48.hardi.testback.support.LinijaToLinijaDto;
import com.ftninfowrmatika.jwd48.hardi.testback.web.dto.LinijaDTO;

@RestController
@RequestMapping(value = "/api/linije", produces = MediaType.APPLICATION_JSON_VALUE)
public class LinijaController {
	
	@Autowired
	private LinijaService linijaService;
	
	@Autowired
	private LinijaToLinijaDto toDto;
	
	@Autowired
	private LinijaDtoToLinija toLinija;
	
	@Autowired
	private RezervacijaService rezervacijaService;
	
	@GetMapping
	private ResponseEntity<List<LinijaDTO>> getAll(
			@RequestParam(defaultValue = "0", value = "pageNo") int pageNo,
			@RequestParam(required = false) String destinacija,
			@RequestParam(required = false) Long prevoznikId,
			@RequestParam(required = false) Double maksCena
			){
		
		Page<Linija> linije = linijaService.find(destinacija, prevoznikId, maksCena, pageNo);
		
		 HttpHeaders headers = new HttpHeaders();
	     headers.add("Total-Pages", Integer.toString(linije.getTotalPages()));
	     
	     return new ResponseEntity<List<LinijaDTO>>(toDto.convert(linije.getContent()), headers, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LinijaDTO> getOne(@PathVariable Long id){
		
		Linija linija = linijaService.findOneById(id);
		
		return new ResponseEntity<LinijaDTO>(toDto.convert(linija), HttpStatus.OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LinijaDTO> create(@Valid @RequestBody LinijaDTO dto){
		
		Linija linija = toLinija.convert(dto);
		Linija sacuvana = linijaService.save(linija);
		
		return new ResponseEntity<LinijaDTO>(toDto.convert(sacuvana), HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LinijaDTO> update(@Valid @RequestBody LinijaDTO dto, @PathVariable Long id){
		
		if(id != dto.getId()) {
			return new ResponseEntity<LinijaDTO>(HttpStatus.BAD_REQUEST);
		} 
		
		Linija linija = toLinija.convert(dto);
		Linija izmenjena = linijaService.update(linija);
		
		return new ResponseEntity<LinijaDTO>(toDto.convert(izmenjena), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
		Linija obrisana = linijaService.delete(id);
		
		if(obrisana != null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/rezervacije/{id}")
	public ResponseEntity<LinijaDTO> linije(@PathVariable Long id){
		
		Linija linija = linijaService.findOneById(id);
		
		if(linija.getBrojMesta() > 0) {
			linija.setBrojMesta(linija.getBrojMesta() - 1);
			linijaService.update(linija);
			Rezervacija rezervacija = new Rezervacija(linija);
			rezervacijaService.save(rezervacija);
		} else {
			return new ResponseEntity<LinijaDTO>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<LinijaDTO>(toDto.convert(linija), HttpStatus.OK);
	}

}
