/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.SisTADS.DataAccess;

import br.edu.ifnmg.SisTADS.DomainModel.Curso;
import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.CursoRepositorio;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author Mauro
 */
@Singleton
public class CursoDAO extends DAOGenerico<Curso> implements CursoRepositorio{
    
    
    public CursoDAO(){
        
        super(Curso.class);
    }
    
    @Override
    public List<Curso> Buscar(Curso filtro) {
        
        return Like("nome", filtro.getNome())
               .IgualA("id", filtro.getId())
               .OrderBy("nome", "ASC")
               .Buscar();
    }
}
