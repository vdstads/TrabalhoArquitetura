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
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Enumeration;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author andre
 */
@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController extends ControllerGenerico<Usuario> implements Serializable {

    /**
     * Creates a new instance of UsuarioController
     */
    @EJB
    private UsuarioRepositorio repositorio;

    public UsuarioController() {
        super("listaUsuario.xhtml", "editarUsuario.xhtml", "cadastroUsuario.xhtml");
        entidade = new Usuario();
        filtro = new Usuario();
    }

    @Override
    public String limparfiltros() {
        filtro = new Usuario();
        return super.limparfiltros(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String novo() {
        entidade = new Usuario();
        return super.novo(); //To change body of generated methods, choose Tools | Templates.
    }

    public String logout() {
        MensagemErro(null, "logout");
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        session.setAttribute("usuario", null);
        Enumeration<String> vals = session.getAttributeNames();
        while (vals.hasMoreElements()) {
            session.removeAttribute(vals.nextElement());
        }
        return "/index.xhtml";
    }

    public String login() {
        Usuario usuario = repositorio.login(entidade);
        if (usuario == null) {
            MensagemErro("Acesso", "Login ou Senha Inválidos!");
            return null;
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
            session.setAttribute("usuario", usuario);
            if (usuario.getNivel().equals("Administrador")) {
                return "admin/index.xhtml";
            } else if (usuario.getNivel().equals("Professor")) {
                Professor professor = repositorio.verificarProfessor(usuario);
                if (professor == null) {
                    return "CadastroProfessor.xhtml";
                } else {
                    session.setAttribute("professor", professor);
                    return "/professor/index.xhtml";
                }
            } else if (usuario.getNivel().equals("Aluno")) {
                Aluno aluno = repositorio.verificarAluno(usuario);
                session.setAttribute("aluno", aluno);
                return "/aluno/index.xhtml";
            }
        }
        return null;
    }

    public String getNomeBotao() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario.getNivel().equals("Administrador")) {
            return "Administrador - Logout";
        } else if (usuario.getNivel().equals("Professor")) {
            Professor professor = repositorio.verificarProfessor(usuario);
            return professor.getNome() + " - Logout";
        } else if (usuario.getNivel().equals("Aluno")) {
            Aluno aluno = repositorio.verificarAluno(usuario);
            return "Aluno - Logout";
        }
        return null;
    }

    public void configurar() {
        setDao(repositorio);
    }

}
