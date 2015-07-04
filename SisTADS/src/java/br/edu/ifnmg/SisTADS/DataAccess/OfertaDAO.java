/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.DataAccess;

import br.edu.ifnmg.SisTADS.DomainModel.Oferta;
import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.OfertaRepositorio;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author andre
 */
@Singleton
public class OfertaDAO extends DAOGenerico<Oferta> implements OfertaRepositorio {

    public OfertaDAO() {
        super(Oferta.class);
    }

    @Override
    public List<Oferta> Buscar(Oferta filtro) {
        return OrderBy("id", "desc")
                .Buscar();
    }

}
