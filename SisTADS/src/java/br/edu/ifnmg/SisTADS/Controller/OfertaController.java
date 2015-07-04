/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.Controller;

import br.edu.ifnmg.SisTADS.DomainModel.Oferta;
import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.OfertaRepositorio;
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
public class OfertaController extends ControllerGenerico<Oferta> implements Serializable {

    /**
     * Creates a new instance of OfertaController
     */
    @EJB
    private OfertaRepositorio repositorio;

    public OfertaController() {
        super("listaOferta.xhtml", "editarOferta.xhtml", "cadastroOferta.xhtml");
        entidade = new Oferta();
        filtro = new Oferta();
    }

    @Override
    public String limparfiltros() {
        filtro = new Oferta();
        return super.limparfiltros(); //To change body of generated methods, choose Tools | Templates.
    }

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }

}
