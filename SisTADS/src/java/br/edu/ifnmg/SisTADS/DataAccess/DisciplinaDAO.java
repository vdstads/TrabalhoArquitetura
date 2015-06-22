/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.SisTADS.DataAccess;

import br.edu.ifnmg.SisTADS.DomainModel.Disciplina;
import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.DisciplinaRepositorio;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author Mauro
 */
@Singleton
public class DisciplinaDAO extends DAOGenerico<Disciplina> implements DisciplinaRepositorio{
    
    
    public DisciplinaDAO(){
        
        super(Disciplina.class);
    }
    
    
    @Override
    public List<Disciplina> Buscar(Disciplina filtro) {
        
        return Like("nome", filtro.getNome())
               .IgualA("id", filtro.getId())
               .OrderBy("nome", "ASC")
               .Buscar();
    }
}

