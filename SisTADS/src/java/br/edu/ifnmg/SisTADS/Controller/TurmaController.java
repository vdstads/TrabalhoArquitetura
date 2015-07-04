/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.Controller;

import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.TurmaRepositorio;
import br.edu.ifnmg.SisTADS.DomainModel.Turma;
import javax.inject.Named;
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
public class TurmaController extends ControllerGenerico<Turma> implements Serializable {

    /**
     * Creates a new instance of TurmaController
     */
    @EJB
    private TurmaRepositorio repositorio;

    public TurmaController() {
        super("listaTurma.xhtml", "editarTurma.xhtml", "cadastroTurma.xhtml");
        entidade = new Turma();
        filtro = new Turma();
    }

    @Override
    public String limparfiltros() {
        filtro = new Turma();
        return super.limparfiltros(); //To change body of generated methods, choose Tools | Templates.
    }

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }

}
