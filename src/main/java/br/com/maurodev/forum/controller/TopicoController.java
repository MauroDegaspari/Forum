package br.com.maurodev.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.maurodev.forum.dto.TopicoDto;
import br.com.maurodev.forum.modelo.Curso;
import br.com.maurodev.forum.modelo.Topico;

@RestController
public class TopicoController {

	@RequestMapping("/topicos")
	public List<TopicoDto> lista() {
		Topico topico = new Topico("teste5", "top", new Curso("mauro", "melhor"));
		return TopicoDto.converter(Arrays.asList(topico));
	}
}
