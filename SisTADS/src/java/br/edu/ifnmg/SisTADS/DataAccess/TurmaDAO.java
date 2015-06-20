/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.SisTADS.DataAccess;

import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.TurmaRepositorio;
import br.edu.ifnmg.SisTADS.DomainModel.Turma;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author Mauro
 */
@Singleton
public class TurmaDAO extends DAOGenerico<Turma> implements TurmaRepositorio{
    
    
    public TurmaDAO(){
        
        super(Turma.class);
    }
    
    
    @Override
    public List<Turma> Buscar(Turma filtro) {
        
        return Like("ingresso", filtro.getIngresso())
               .IgualA("id", filtro.getId())
               .IgualA("ano", filtro.getAno())
               .IgualA("periodo", filtro.getPeriodo())
               .OrderBy("ingresso", "ASC")
               .Buscar();
    }
}
