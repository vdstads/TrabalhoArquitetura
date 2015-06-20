/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.DataAccess;

import br.edu.ifnmg.SisTADS.DomainModel.ParticipacaoEvento;
import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.ParticipacaoEventoRepositorio;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author andre
 */
@Singleton
public class ParticipacaoEventoDAO extends DAOGenerico<ParticipacaoEvento> implements ParticipacaoEventoRepositorio {

    public ParticipacaoEventoDAO() {
        super(ParticipacaoEvento.class);
    }

    @Override
    public List<ParticipacaoEvento> Buscar(ParticipacaoEvento filtro) {
        return Buscar();
    }

}
