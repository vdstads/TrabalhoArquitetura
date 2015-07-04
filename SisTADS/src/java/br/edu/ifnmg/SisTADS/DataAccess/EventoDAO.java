/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.DataAccess;

import br.edu.ifnmg.SisTADS.DomainModel.Evento;
import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.EventoRepositorio;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author Mauro
 */
@Singleton
public class EventoDAO extends DAOGenerico<Evento> implements EventoRepositorio {

    public EventoDAO() {

        super(Evento.class);
    }

    @Override
    public List<Evento> Buscar(Evento filtro) {

        return Like("nome", filtro.getNome())
                .IgualA("id", filtro.getId())
                .IgualA("data", filtro.getData())
                .OrderBy("nome", "ASC")
                .Buscar();
    }
}
