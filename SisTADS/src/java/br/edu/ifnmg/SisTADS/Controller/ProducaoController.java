/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.SisTADS.Controller;


import br.edu.ifnmg.SisTADS.DomainModel.Producao;
import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.ProducaoRepositorio;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Mauro
 */

@ManagedBean
@SessionScoped
public class ProducaoController extends ControllerGenerico<Producao> implements Serializable {
    
    /**
     * Creates a new instance of ProducaoController
     */
    @EJB
    private ProducaoRepositorio repositorio;

   
    public ProducaoController() {
        super("listaProducao.xhtml", "editarProducao.xhtml","cadastroProducao.xhtml");
        entidade = new Producao();
        filtro = new Producao();
    }

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }
    
}
