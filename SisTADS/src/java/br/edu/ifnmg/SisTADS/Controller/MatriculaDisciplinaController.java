/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.Controller;

import br.edu.ifnmg.SisTADS.DomainModel.MatriculaDisciplina;
import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.MatriculaDisciplinaRepositorio;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author andre
 */
@Named(value = "matriculaDisciplinaController")
@SessionScoped
public class MatriculaDisciplinaController extends ControllerGenerico<MatriculaDisciplina> implements Serializable {

    /**
     * Creates a new instance of MatriculaDisciplinaController
     */
    @EJB
    private MatriculaDisciplinaRepositorio repositorio;

    public MatriculaDisciplinaController() {
        super("listaMatriculaDisciplina.xhtml", "editarMatriculaDisciplina.xhtml", "cadastroMatriculaDisciplina.xhtml");
        entidade = new MatriculaDisciplina();
        filtro = new MatriculaDisciplina();
    }

    @Override
    public String limparfiltros() {
        filtro = new MatriculaDisciplina();
        return super.limparfiltros(); //To change body of generated methods, choose Tools | Templates.
    }

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }

}
