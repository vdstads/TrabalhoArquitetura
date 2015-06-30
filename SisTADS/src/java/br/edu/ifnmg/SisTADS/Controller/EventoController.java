/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.Controller;

import br.edu.ifnmg.SisTADS.DomainModel.Evento;
import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.EventoRepositorio;
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
public class EventoController extends ControllerGenerico<Evento> implements Serializable {

    /**
     * Creates a new instance of EventoController
     */
    @EJB
    private EventoRepositorio repositorio;

    public EventoController() {
        super("listaEvento.xhtml", "editarEvento.xhtml","cadastroEvento.xhtml");
        entidade = new Evento();
        filtro = new Evento();
    }

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }

}
