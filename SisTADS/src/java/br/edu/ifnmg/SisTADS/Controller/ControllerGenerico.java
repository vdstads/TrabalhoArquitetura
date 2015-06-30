/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.Controller;

import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.Repositorio;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author andre
 */
public class ControllerGenerico<T> {

    /**
     * Creates a new instance of ControllerGenerico
     */
    public ControllerGenerico(String paginaListagem, String paginaEdicao, String paginaCadastro) {
        this.paginaCadastro = paginaCadastro;
        this.paginaListagem = paginaListagem;
        this.paginaEdicao = paginaEdicao;
    }

    protected T entidade;
    protected T filtro;

    protected String paginaListagem;
    protected String paginaEdicao;
    protected String paginaCadastro;

    private Repositorio<T> dao;

    protected Repositorio<T> getDao() {
        return dao;
    }

    protected void setDao(Repositorio<T> dao) {
        this.dao = dao;
    }

    public T getEntidade() {
        return entidade;
    }

    public void setEntidade(T entidade) {
        this.entidade = entidade;
    }

    public T getFiltro() {
        return filtro;
    }

    public void setFiltro(T filtro) {
        this.filtro = filtro;
    }

    protected void MensagemSucesso(String titulo, String msg) {
        FacesContext context = FacesContext.getCurrentInstance();

        FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, titulo);
        context.addMessage(null, m);
        context.getExternalContext().getFlash().setKeepMessages(true);
    }

    protected void MensagemErro(String titulo, String msg) {
        FacesContext context = FacesContext.getCurrentInstance();

        FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, titulo);
        context.addMessage(null, m);
        context.getExternalContext().getFlash().setKeepMessages(true);
    }

    public String salvar() {
        if (dao.Salvar(entidade)) {
            MensagemSucesso("Sucesso!", "Registro salvo com sucesso!");
            return paginaListagem;
        } else {
            MensagemErro("Erro!", "Consulte o administrador do sistema!");
            return "";
        }
    }

    public String apagar() {
        if (dao.Apagar(entidade)) {
            MensagemSucesso("Sucesso!", "Registro removido com sucesso!");
            return paginaListagem;
        } else {
            MensagemErro("Erro!", "Consulte o administrador do sistema!");
            return null;
        }

    }

    public void editar() {
        dao.Apagar(entidade);
        dao.Salvar(entidade);
        MensagemSucesso("Sucesso!", "Registro Editado com sucesso!");
    }

    public String voltar() {
        return paginaListagem;
    }

    public String filtrar() {
        return paginaListagem;
    }

    public String limparfiltros() {
        return paginaListagem;
    }

    public String novo() {
        return paginaCadastro;
    }

    public String abrir(T obj) {
        entidade = obj;
        return paginaEdicao;
    }

    public List<T> getListagem() {
        return dao.Buscar(filtro);
    }
}
