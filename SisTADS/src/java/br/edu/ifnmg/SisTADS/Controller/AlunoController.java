/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.Controller;

import br.edu.ifnmg.SisTADS.DomainModel.Aluno;
import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.AlunoRepositorio;
import br.edu.ifnmg.SisTADS.DomainModel.Usuario;
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
public class AlunoController extends ControllerGenerico<Aluno> implements Serializable {

    /**
     * Creates a new instance of AlunoController
     */
    @EJB
    private AlunoRepositorio repositorio;
    private String email;
    private String senha;

    public AlunoController() {
        super("listaAluno.xhtml", "editarAluno.xhtml", "cadastroAluno.xhtml");
        entidade = new Aluno();
        filtro = new Aluno();
    }

    @Override
    public String limparfiltros() {
        filtro = new Aluno();
        return super.limparfiltros(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String salvar() {
        if (repositorio.SalvarUsuario(email, senha)) {
            return super.salvar(); //To change body of generated methods, choose Tools | Templates.
        } else {
            MensagemErro("Erro!", "Consulte o administrador do sistema!");
            return "";
        }
    }

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
