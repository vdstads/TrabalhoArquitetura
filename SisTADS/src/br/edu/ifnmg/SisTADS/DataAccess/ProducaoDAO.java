/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.SisTADS.DataAccess;

import br.edu.ifnmg.SisTADS.DomainModel.Producao;
import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.ProducaoRepositorio;
import java.util.List;

/**
 *
 * @author Mauro
 */
public class ProducaoDAO extends DAOGenerico<Producao> implements ProducaoRepositorio{
  
    
    public ProducaoDAO(){
        
        super(Producao.class);
    }
    
    
    @Override
    public List<Producao> Buscar(Producao filtro) {
        
        return Like("nome", filtro.getNome())
               .IgualA("id", filtro.getId())
               .IgualA("orientador", filtro.getOrientador())
               .IgualA("data", filtro.getData())
               .OrderBy("nome", "ASC")
               .Buscar();
    }
}
