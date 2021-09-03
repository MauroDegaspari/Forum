package br.com.maurodev.forum.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.maurodev.forum.controller.form.TopicoForm;
import br.com.maurodev.forum.dto.TopicoDto;
import br.com.maurodev.forum.model.Topico;
import br.com.maurodev.forum.repository.CursoRepository;
import br.com.maurodev.forum.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

	@Autowired
	private TopicoRepository repo;
	
	@Autowired
	private CursoRepository cursoRepo;
	
	@GetMapping
	public List<TopicoDto> lista(String nomeCurso) {
		if (nomeCurso == null) {
		List<Topico> topico = repo.findAll(); 
		return TopicoDto.converter(topico);
		}
		else {
			List<Topico> topico = repo.findByCursoNome(nomeCurso); 
			return TopicoDto.converter(topico);
		}
		
	}
		@PostMapping
		public ResponseEntity<TopicoDto> cadastrar(@RequestBody TopicoForm topicoForm, UriComponentsBuilder uriBuilder) {
			Topico topico = topicoForm.converter(cursoRepo);
			repo.save(topico);
			
			URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
			return ResponseEntity.created(uri).body(new TopicoDto(topico));
		}
		
	}
	
	/* 
	   INSERT INTO USUARIO(nome, email, senha) VALUES('Aluno', 'aluno@email.com', '123456');

		INSERT INTO CURSO(nome, categoria) VALUES('Spring Boot', 'Programação');
		INSERT INTO CURSO(nome, categoria) VALUES('HTML 5', 'Front-end');
		
		INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida', 'Erro ao criar projeto', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1);
		INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 2', 'Projeto não compila', '2019-05-05 19:00:00', 'NAO_RESPONDIDO', 1, 1);
		INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 3', 'Tag HTML', '2019-05-05 20:00:00', 'NAO_RESPONDIDO', 1, 2);

	*/
	
	 

