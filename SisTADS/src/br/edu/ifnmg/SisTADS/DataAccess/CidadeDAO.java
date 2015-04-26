/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.SisTADS.DataAccess;

import br.edu.ifnmg.SisTADS.DomainModel.Cidade;
import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.CidadeRepositorio;
import java.util.List;

/**
 *
 * @author Mauro
 */
public class CidadeDAO extends DAOGenerico<Cidade> implements CidadeRepositorio{
    
    
    public CidadeDAO(){
        
        super(Cidade.class);
    }
    
    
    @Override
    public List<Cidade> Buscar(Cidade filtro) {
        
        return Like("nome", filtro.getNome())
               .IgualA("id", filtro.getId())
               .IgualA("estado", filtro.getEstado())
               .OrderBy("nome", "ASC")
               .Buscar();
    }
}
