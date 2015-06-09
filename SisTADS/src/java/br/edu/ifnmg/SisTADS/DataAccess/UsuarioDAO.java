/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.DataAccess;

import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.UsuarioRepositorio;
import br.edu.ifnmg.SisTADS.DomainModel.Usuario;
import java.util.List;
import javax.ejb.Singleton;

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

}
