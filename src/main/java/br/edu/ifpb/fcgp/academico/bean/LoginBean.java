package br.edu.ifpb.fcgp.academico.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.edu.ifpb.fcgp.academico.controller.UsuarioController;
import br.edu.ifpb.fcgp.academico.model.Coodernador;
import br.edu.ifpb.fcgp.academico.model.Disciplina;
import br.edu.ifpb.fcgp.academico.model.Nota;
import br.edu.ifpb.fcgp.academico.model.Usuario;

@Named(value = "LoginBean")
@SessionScoped
public class LoginBean extends GenericAcademicoBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	
	
	
	
	
	private Usuario usuarioLogado;
	private Coodernador cod;
	private List<Nota> nota;
	private List<Disciplina> diciplina;
	
	

	
    private String login;
    private String senha;
    
    
	
	@Inject
	private UsuarioController controller;
	
	
	

	
	
	public String Login() {
		
		
		usuarioLogado = controller.Login(login, senha);
		
		try {
			cod = controller.CoodAtivo(usuarioLogado.getId());
			nota = controller.getNota(usuarioLogado.getId());
			diciplina = controller.getDiciplinaAluno();
			
		} catch (Exception e) {
			
		}
		
	   
		
		
		if(usuarioLogado == null  ) {
			
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!",
			           "Erro no Login!"));
			return null;
			
		}else {
			
			
			 HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			 
			 if (session != null) {
				 session.setAttribute("usuario", usuarioLogado);
				 if(usuarioLogado.getTipo().equals("ALUNO")) {
					 return "/alunos/alunologado?faces-redirect=true";
					 
				 }
				 try {
					 if(cod.isAtivo() == true) {
						 return "/coodernador/coodernadorlogado?faces-redirect=true"; 
					 }
					
				} catch (Exception e) {
					 return "/professor/professorlogado?faces-redirect=true"; 
				}
	
				 
			 }
			 return null;
			
			
			
		}
		
		
	}
	

	
	public String logOff() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.invalidate();
        return "/login/login?faces-redirect=true";
    }
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public Coodernador getCod() {
		return cod;
	}

	public void setCod(Coodernador cod) {
		this.cod = cod;
	}



	public List<Nota> getNota() {
		return nota;
	}



	public void setNota(List<Nota> nota) {
		this.nota = nota;
	}



	public List<Disciplina> getDiciplina() {
		return diciplina;
	}



	public void setDiciplina(List<Disciplina> diciplina) {
		this.diciplina = diciplina;
	}
	
	






	
	
	
	
	
	
	
	
	

	

	
	
	



	
	

	

	


	
	
	
	
	
	
}
