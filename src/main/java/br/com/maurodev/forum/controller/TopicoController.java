package br.com.maurodev.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.maurodev.forum.dto.TopicoDto;
import br.com.maurodev.forum.model.Topico;
import br.com.maurodev.forum.repository.TopicoRepository;

@RestController
public class TopicoController {

	@Autowired
	private TopicoRepository repo;
	
	@RequestMapping("/topicos")
	public List<TopicoDto> lista() {
		List<Topico> topico = repo.findAll(); 
		return TopicoDto.converter(topico);
	}
}
