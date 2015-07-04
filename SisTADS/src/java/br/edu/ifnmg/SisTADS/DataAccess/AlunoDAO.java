/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.DataAccess;

import br.edu.ifnmg.SisTADS.DomainModel.Aluno;
import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.AlunoRepositorio;
import br.edu.ifnmg.SisTADS.DomainModel.Usuario;
import java.util.List;
import javax.ejb.Singleton;
import javax.persistence.Query;

/**
 *
 * @author Mauro
 */
@Singleton
public class AlunoDAO extends DAOGenerico<Aluno> implements AlunoRepositorio {

    public AlunoDAO() {
        super(Aluno.class);
    }

    @Override
    public List<Aluno> Buscar(Aluno filtro) {

        return Like("nome", filtro.getNome())
                .Like("sexo", filtro.getSexo())
                .IgualA("id", filtro.getId())
                .OrderBy("nome", "ASC")
                .Buscar();
    }

    @Override
    public Aluno AbrirPorNome(String nome) {
        try {
            Query consulta = manager.createQuery("select o from Aluno o "
                    + "where o.nome = :nome");
            consulta.setParameter("nome", nome);
            return (Aluno) consulta.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean SalvarUsuario(String email, String senha) {
        try {
            Usuario usuario = new Usuario();
            usuario.setEmail(email);
            usuario.setSenha(usuario.criptografica(senha));
            usuario.setNivel("Aluno");
            manager.persist(usuario);
            manager.flush();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Usuario AbrirUsuario(String email) {
        try {
            Query consulta = manager.createQuery("select o from Usuario o "
                    + "where o.email = :email");
            consulta.setParameter("email", email);
            return (Usuario) consulta.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
