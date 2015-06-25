/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.DataAccess;

import br.edu.ifnmg.SisTADS.DomainModel.Professor;
import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.UsuarioRepositorio;
import br.edu.ifnmg.SisTADS.DomainModel.Usuario;
import java.util.List;
import javax.ejb.Singleton;
import javax.persistence.Query;

/**
 *
 * @author andre
 */
@Singleton
public class UsuarioDAO extends DAOGenerico<Usuario> implements UsuarioRepositorio {

    public UsuarioDAO() {
        super(Usuario.class);
    }

    @Override
    public List<Usuario> Buscar(Usuario filtro) {
        return Like("email", filtro.getEmail())
                .IgualA("id", filtro.getId())
                .OrderBy("email", "ASC")
                .Buscar();
    }

    @Override
    public Usuario login(Usuario usuario) {
        Query consulta = manager.createQuery("select o from Usuario o "
                + "where o.email = :email and o.senha = :senha");
        consulta.setParameter("email", usuario.getEmail());
        consulta.setParameter("senha", usuario.getSenha());
        return (Usuario) consulta.getSingleResult();
    }

    @Override
    public Professor verificarProfessor(Usuario usuario) {
        try {
            if (usuario != null) {
                String Consulta = "select o from Professor o join o.usuario u ";

                Consulta = Consulta + " where u.id = " + usuario.getId().toString() + "";
                Query query = manager.createQuery(Consulta);
                return (Professor) query.getSingleResult();
            } else {
                return null;
            }

        } catch (Exception e) {
            return null;
        }
    }

}
