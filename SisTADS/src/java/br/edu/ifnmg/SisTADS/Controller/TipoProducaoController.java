/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.Controller;

import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.TipoProducaoRepositorio;
import br.edu.ifnmg.SisTADS.DomainModel.TipoProducao;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author andre
 */
@ManagedBean
@SessionScoped
public class TipoProducaoController extends ControllerGenerico<TipoProducao> implements Serializable {

    /**
     * Creates a new instance of TipoDeProducaoController
     */
    @EJB
    private TipoProducaoRepositorio repositorio;

    public TipoProducaoController() {
        super("listaTipoProducao.xhtml", "editarTipoProducao.xhtml", "cadastroTipoProducao.xhtml");
        entidade = new TipoProducao();
        filtro = new TipoProducao();
    }

    @Override
    public String limparfiltros() {
        filtro = new TipoProducao();
        return super.limparfiltros(); //To change body of generated methods, choose Tools | Templates.
    }

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }

}
