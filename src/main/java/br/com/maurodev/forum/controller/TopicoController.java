package br.com.maurodev.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import br.com.maurodev.forum.dto.TopicoDto;

@RestController
public class TopicoController {

	@RequestMapping("/topicos")
	public List<TopicoDto> lista() {
		Topico topico = new Topico("pequeno principe", "top", new Curso("mauro", "melhor"));
		return TopicoDto.converter(Arrays.asList(topico));
	}
}
