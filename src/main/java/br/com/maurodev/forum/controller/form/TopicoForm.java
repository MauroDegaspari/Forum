package br.com.maurodev.forum.controller.form;

import br.com.maurodev.forum.model.Curso;
import br.com.maurodev.forum.model.Topico;
import br.com.maurodev.forum.repository.CursoRepository;

public class TopicoForm {
	
	private String titulo;
	private String mensagem;
	private String nomeCurso;
	
	public Topico converter(CursoRepository repo) {
		Curso curso = repo.findByNome(nomeCurso);
		return new Topico(titulo, mensagem, curso);
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

}
