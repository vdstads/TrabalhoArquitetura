/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.SisTADS.DataAccess;

import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.TipoEventoRepositorio;
import br.edu.ifnmg.SisTADS.DomainModel.TipoEvento;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author Mauro
 */
@Singleton
public class TipoEventoDAO extends DAOGenerico<TipoEvento> implements TipoEventoRepositorio{
     
    public TipoEventoDAO(){
        
        super(TipoEvento.class);
    }
    
    
    @Override
    public List<TipoEvento> Buscar(TipoEvento filtro) {
        
        return Like("nome", filtro.getNome())
               .IgualA("id", filtro.getId())
               .OrderBy("nome", "ASC")
               .Buscar();
    }
}
