/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.Controller;

import br.edu.ifnmg.SisTADS.DomainModel.Aluno;
import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.AlunoRepositorio;
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
public class AlunoController extends ControllerGenerico<Aluno> implements Serializable {

    /**
     * Creates a new instance of AlunoController
     */
    @EJB
    private AlunoRepositorio repositorio;

    public AlunoController() {
        super("", "/index.xhtml");
        entidade = new Aluno();
        filtro = new Aluno();
    }

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }

}
