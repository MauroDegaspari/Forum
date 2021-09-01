package br.com.maurodev.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.maurodev.forum.model.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

}
