package br.com.maurodev.forum.controller.form;

import br.com.maurodev.forum.model.Topico;
import br.com.maurodev.forum.repository.TopicoRepository;

public class AtualizarTopicoForm {
	
	private String titulo;
	private String mensagem;
	
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
	public Topico atualizar(Long id, TopicoRepository repo) {
		 Topico topico = repo.getOne(id);
		 topico.setTitulo(this.titulo);
		 topico.setMensagem(this.mensagem);
		return topico;
	}
	
	

}

