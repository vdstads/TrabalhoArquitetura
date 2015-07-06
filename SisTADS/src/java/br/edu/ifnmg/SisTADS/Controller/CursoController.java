/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.Controller;

import br.edu.ifnmg.SisTADS.DomainModel.Curso;
import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.CursoRepositorio;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

/**
 *
 * @author andre
 */
//@ManagedBean
@Named(value = "cursoController")
@SessionScoped
public class CursoController extends ControllerGenerico<Curso> implements Serializable {

    /**
     * Creates a new instance of CursoController
     */
    @EJB
    private CursoRepositorio repositorio;

    public CursoController() {
        super("listaCurso.xhtml", "editarCurso.xhtml", "cadastroCurso.xhtml");
        entidade = new Curso();
        filtro = new Curso();
    }

    @Override
    public String limparfiltros() {
        filtro = new Curso();
        return super.limparfiltros(); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }

}
