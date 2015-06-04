/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.SisTADS.DataAccess;

import br.edu.ifnmg.SisTADS.DomainModel.PerfilAluno;
import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.PerfilAlunoRepositorio;
import java.util.List;

/**
 *
 * @author Mauro
 */
public class PerfilAlunoDAO extends DAOGenerico<PerfilAluno> implements PerfilAlunoRepositorio{
    
    
    public PerfilAlunoDAO(){
        
        super(PerfilAluno.class);
    }
    
    
    @Override
    public List<PerfilAluno> Buscar(PerfilAluno filtro) {
        
        return Like("nomeMae", filtro.getNomeMae())
               .IgualA("nomePai", filtro.getNomePai())
               .IgualA("id", filtro.getId())
               .IgualA("quantidadeIrmaos", filtro.getQuantidadeIrmaos())
               .IgualA("renda", filtro.getRenda())
               .OrderBy("nomeMae", "ASC")
               .Buscar();
    }
}
