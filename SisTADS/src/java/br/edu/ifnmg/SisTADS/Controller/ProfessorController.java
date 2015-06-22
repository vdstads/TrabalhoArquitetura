/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.Controller;

import br.edu.ifnmg.SisTADS.DomainModel.Professor;
import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.ProfessorRepositorio;
import br.edu.ifnmg.SisTADS.DomainModel.Usuario;
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
    public ProfessorController() {
        super("", "");
        entidade = new Professor();
        filtro = new Professor();
    }

    @EJB
    private ProfessorRepositorio repositorio;

    @Override
    public String voltar() {
        return "index.xhtml";
    }

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }

}
