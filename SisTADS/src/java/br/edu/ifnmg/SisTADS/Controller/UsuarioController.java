package br.edu.ifnmg.SisTADS.Controller;

import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.UsuarioRepositorio;
import br.edu.ifnmg.SisTADS.DomainModel.Usuario;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author andre
 */
@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController implements Serializable{

    private Usuario entidade;
    private Usuario filtro;

    @EJB
    private UsuarioRepositorio dao;

    public UsuarioController() {
        entidade = new Usuario();
        filtro = new Usuario();
    }

    public Usuario getEntidade() {
        return entidade;
    }

    public void setEntidade(Usuario entidade) {
        this.entidade = entidade;
    }

    public Usuario getFiltro() {
        return filtro;
    }

    public void setFiltro(Usuario filtro) {
        this.filtro = filtro;
    }

}
