/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.Controller;

import br.edu.ifnmg.SisTADS.DomainModel.Disciplina;
import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.DisciplinaRepositorio;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author andre
 */
@ManagedBean
@SessionScoped
public class DisciplinaController extends ControllerGenerico<Disciplina> implements Serializable {

    /**
     * Creates a new instance of disciplinaController
     */
    @EJB
    private DisciplinaRepositorio repositorio;
    
    public DisciplinaController() {
        super("listaDisciplina.xhtml", "editarDisciplina.xhtml","cadastroDisciplina.xhtml");
        entidade = new Disciplina();
        filtro = new Disciplina();
    }

    @Override
    public String limparfiltros() {
        filtro = new Disciplina();
        return "listaDisciplina.xhtml";
    }
    
    @PostConstruct
    public void configurar(){
        setDao(repositorio);
    }
    
}
