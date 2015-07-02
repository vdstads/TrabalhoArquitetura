/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.Controller;

import br.edu.ifnmg.SisTADS.DomainModel.Professor;
import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.ProfessorRepositorio;
import br.edu.ifnmg.SisTADS.DomainModel.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
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
public class ProfessorController extends ControllerGenerico<Professor> implements Serializable {

    /**
     * Creates a new instance of ProfessorController
     */
    @EJB
    private ProfessorRepositorio repositorio;

    public ProfessorController() {
        super("", "", "");
        entidade = new Professor();
        filtro = new Professor();
    }

    @Override
    public void salvar() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            entidade.setUsuario(usuario);
            if (repositorio.Salvar(entidade)) {
                MensagemSucesso("Sucesso!", "Registro salvo com sucesso!");
                Professor professor = repositorio.AbrirPorNome(entidade.getNome());
                session.setAttribute("professor", professor);
                FacesContext.getCurrentInstance().getExternalContext().redirect("professor");
            } else {
                MensagemErro("Erro!", "Consulte o administrador do sistema!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }

}
