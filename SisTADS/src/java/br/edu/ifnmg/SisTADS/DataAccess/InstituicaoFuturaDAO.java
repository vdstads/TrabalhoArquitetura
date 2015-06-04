/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.SisTADS.DataAccess;

import br.edu.ifnmg.SisTADS.DomainModel.InstituicaoFutura;
import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.InstituicaoFuturaRepositorio;
import java.util.List;

/**
 *
 * @author Mauro
 */
public class InstituicaoFuturaDAO extends DAOGenerico<InstituicaoFutura> implements InstituicaoFuturaRepositorio{
    
    public InstituicaoFuturaDAO(){
        
        super(InstituicaoFutura.class);
    }
    
    
    @Override
    public List<InstituicaoFutura> Buscar(InstituicaoFutura filtro) {
        
        return Like("nome", filtro.getNome())
               .IgualA("id", filtro.getId())
               .IgualA("atividade", filtro.getAtividade())
               .IgualA("ano", filtro.getAno())
               .OrderBy("nome", "ASC")
               .Buscar();
    }
    
}
