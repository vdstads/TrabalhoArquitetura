/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.Controller;

import br.edu.ifnmg.SisTADS.DomainModel.Aluno;
import br.edu.ifnmg.SisTADS.DomainModel.Professor;
import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.UsuarioRepositorio;
import br.edu.ifnmg.SisTADS.DomainModel.Usuario;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Enumeration;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author andre
 */
@ManagedBean
@SessionScoped
public class UsuarioController extends ControllerGenerico<Usuario> implements Serializable {

    /**
     * Creates a new instance of UsuarioController
     */
    public UsuarioController() {
        super("index.xhtml", "cadastroUsuario.xhtml");
        entidade = new Usuario();
        filtro = new Usuario();
    }

    @EJB
    private UsuarioRepositorio repositorio;

    public String logout() {
        HttpSession session;
        FacesContext context = FacesContext.getCurrentInstance();
        session = (HttpSession) context.getExternalContext().getSession(false);
        session.setAttribute("usuario", null);

        Enumeration<String> vals = session.getAttributeNames();

        while (vals.hasMoreElements()) {
            session.removeAttribute(vals.nextElement());
        }
        return "/index.xhtml";
    }

    public String login() {
        Usuario usuario = repositorio.login(entidade);
        HttpSession session;
        FacesContext context = FacesContext.getCurrentInstance();
        session = (HttpSession) context.getExternalContext().getSession(false);
        session.setAttribute("usuario", usuario);
        if (usuario.getNivel().equals("Administrador")) {
            try {
                return "admin/index.xhtml";
            } catch (Exception e) {
                e.printStackTrace();
                return "index.xhtml";
            }
        } else if (usuario.getNivel().equals("Professor")) {
            Professor professor = repositorio.verificarProfessor(usuario);
            if (professor == null) {
                return "cadastroProfessor.xhtml";
            } else {
                MensagemErro("", "tem");
                return "professor/index.xhtml";
            }
        } else if (usuario.getNivel().equals("Aluno")) {
            Aluno aluno = repositorio.verificarAluno(usuario);
            if (aluno == null) {
                return "/cadastroAluno.xhtml";
            } else {
                return "aluno/index.xhtml";
            }
        }
        return "index.xhtml";
    }

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }

}
