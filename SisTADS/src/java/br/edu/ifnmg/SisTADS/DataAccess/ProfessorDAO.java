/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.DataAccess;

import br.edu.ifnmg.SisTADS.DomainModel.Professor;
import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.ProfessorRepositorio;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author andre
 */
public class ProfessorDAO extends DAOGenerico<Professor> implements ProfessorRepositorio{
    
     public ProfessorDAO() {
        super(Professor.class);
    }

     
    @Override
    public List<Professor> Buscar(Professor filtro) {
        
        return Like("nome", filtro.getNome())
               .IgualA("id", filtro.getId())
               .IgualA("sexo", filtro.getSexo())
               .IgualA("cpf", filtro.getCpf())
               .IgualA("curriculoLattes",filtro.getCurriculoLattes())
               .OrderBy("nome", "ASC")
               .Buscar();
    }

    @Override
    public Professor AbrirPorCPF(String cpf) {
        Query consulta = manager.createQuery("select o from Professor o "
                + "where o.cpf = :cpf");
        consulta.setParameter("cpf", cpf);
        return (Professor)consulta.getSingleResult();
    }
        
   
    
}
