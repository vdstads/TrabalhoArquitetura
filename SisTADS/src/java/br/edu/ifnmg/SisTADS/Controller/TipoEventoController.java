/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.Controller;

import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.TipoEventoRepositorio;
import br.edu.ifnmg.SisTADS.DomainModel.TipoEvento;
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
public class TipoEventoController extends ControllerGenerico<TipoEvento> implements Serializable {

    /**
     * Creates a new instance of TipoEventoController
     */
    @EJB
    private TipoEventoRepositorio repositorio;

    public TipoEventoController() {
        super("listaTipoEvento.xhtml", "editarTipoEvento.xhtml","cadastroTipoEvento.xhtml");
        entidade = new TipoEvento();
        filtro = new TipoEvento();
    }

    @Override
    public String limparfiltros() {
        filtro = new TipoEvento();
        return "listaTipoEvento.xhtml";
    }

    
    @PostConstruct
    public void configurar(){
        setDao(repositorio);
    }

}
