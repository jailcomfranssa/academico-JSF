package br.edu.ifpb.fcgp.academico.controller;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifpb.fcgp.academico.dao.CursoDAO;
import br.edu.ifpb.fcgp.academico.model.Curso;

public class CursoController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CursoDAO cursoDAO;

	public List<Curso> findAll() {
		return cursoDAO.findAll();
	}
	
	

}
