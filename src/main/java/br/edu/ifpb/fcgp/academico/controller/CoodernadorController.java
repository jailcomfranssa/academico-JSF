package br.edu.ifpb.fcgp.academico.controller;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifpb.fcgp.academico.dao.CoodernadorDAO;
import br.edu.ifpb.fcgp.academico.dao.Transactional;
import br.edu.ifpb.fcgp.academico.model.Coodernador;

public class CoodernadorController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CoodernadorDAO coodernadorDAO;
	
	@Transactional
	public void excluir(Coodernador coodernador) {
		coodernadorDAO.delete(coodernador);
	}
	
	@Transactional
	public Coodernador  update(Coodernador coodernador) {
		return coodernadorDAO.update(coodernador);
	}
	public void refresh(Coodernador coodernador) {
		coodernadorDAO.refresh(coodernador);
	}
	public List<Coodernador> findAll() {
		return coodernadorDAO.findAll();
	}
	public Coodernador find(Integer id) {
		return coodernadorDAO.find(id);
	}
	
	//ooooooooooooooooooooooooooooooooooooooooooooooo
	
	
	@Transactional
	public Coodernador insert(Coodernador coodernador) {
		return coodernadorDAO.insert(coodernador);
	}
	@Transactional
	public void saveOrUpdate(Coodernador coodernador) {
		if (coodernador.getId() != null) {
			coodernador = coodernadorDAO.update(coodernador);
		} else {
			coodernadorDAO.insert(coodernador);
		}
		
	}

}
