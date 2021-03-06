/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.DataAccess;

import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.TipoProducaoRepositorio;
import br.edu.ifnmg.SisTADS.DomainModel.TipoProducao;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author andre
 */
@Singleton
public class TipoProducaoDAO extends DAOGenerico<TipoProducao> implements TipoProducaoRepositorio {

    public TipoProducaoDAO() {
        super(TipoProducao.class);
    }

    @Override
    public List<TipoProducao> Buscar(TipoProducao filtro) {
        return Like("nome", filtro.getNome())
                .Buscar();
    }

}
