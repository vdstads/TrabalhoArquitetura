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

    protected T entidade;
    protected T filtro;

    protected String paginaListagem;
    protected String paginaEdicao;
    protected String paginaCadastro;

    private Repositorio<T> dao;

    public ControllerGenerico(String paginaListagem, String paginaEdicao, String paginaCadastro) {
        this.paginaListagem = paginaListagem;
        this.paginaEdicao = paginaEdicao;
        this.paginaCadastro = paginaCadastro;
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

    public void salvar() {
        if (dao.Salvar(entidade)) {
            MensagemSucesso("Sucesso!", "Registro salvo com sucesso!");
        } else {
            MensagemErro("Erro!", "Consulte o administrador do sistema!");
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

    public Repositorio<T> getDao() {
        return dao;
    }

    public void setDao(Repositorio<T> dao) {
        this.dao = dao;
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
