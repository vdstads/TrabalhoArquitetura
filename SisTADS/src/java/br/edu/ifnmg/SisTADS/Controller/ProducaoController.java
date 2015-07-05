/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.Controller;

import br.edu.ifnmg.SisTADS.DomainModel.Producao;
import br.edu.ifnmg.SisTADS.DomainModel.Professor;
import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.ProducaoRepositorio;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author andre
 */
@ManagedBean
@SessionScoped
public class ProducaoController extends ControllerGenerico<Producao> implements Serializable {

    /**
     * Creates a new instance of producaoController
     */
    @EJB
    private ProducaoRepositorio repositorio;

    public ProducaoController() {
        super("listaProducao.xhtml", "editarProducao.xhtml", "cadastroProducao.xhtml");
        entidade = new Producao();
        filtro = new Producao();
    }

    public String salvarProfessor() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        Professor professor = (Professor) session.getAttribute("professor");
        entidade.setProfessor(professor);
        if (repositorio.Salvar(entidade)) {
            MensagemSucesso("Sucesso!", "Registro salvo com sucesso!");
            return "listaProducao.xhtml";
        } else {
            MensagemErro("Erro!", "Consulte o administrador do sistema!");
            return "";
        }
    }

    @Override
    public String limparfiltros() {
        filtro = new Producao();
        return super.limparfiltros(); //To change body of generated methods, choose Tools | Templates.
    }

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }
}
