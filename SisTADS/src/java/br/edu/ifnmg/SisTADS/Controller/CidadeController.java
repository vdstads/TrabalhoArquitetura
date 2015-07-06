/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.Controller;

import br.edu.ifnmg.SisTADS.DomainModel.Cidade;
import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.CidadeRepositorio;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author andre
 */
@Named(value = "cidadeController")
@SessionScoped
public class CidadeController extends ControllerGenerico<Cidade> implements Serializable {

    /**
     * Creates a new instance of CidadeController
     */
    @EJB
    private CidadeRepositorio repositorio;

    public CidadeController() {
        super("listaCidade.xhtml", "editarCidade.xhtml", "cadastroCidade.xhtml");
        entidade = new Cidade();
        filtro = new Cidade();
    }

    @Override
    public String limparfiltros() {
        filtro = new Cidade();
        return super.limparfiltros(); //To change body of generated methods, choose Tools | Templates.
    }

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }

}
