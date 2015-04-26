/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.SisTADS.DataAccess;

import br.edu.ifnmg.SisTADS.DomainModel.PerfilProfessor;
import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.PerfilProfessorRepositorio;
import java.util.List;

/**
 *
 * @author Mauro
 */
public class PerfilProfessorDAO extends DAOGenerico<PerfilProfessor> implements PerfilProfessorRepositorio{
   
    
    public PerfilProfessorDAO(){
        
        super(PerfilProfessor.class);
    }
    
    
    @Override
    public List<PerfilProfessor> Buscar(PerfilProfessor filtro) {
        
        return Like("nome", filtro.getNome())
               .IgualA("id", filtro.getId())
               .IgualA("nomeMae", filtro.getNomeMae())
               .IgualA("nomePai", filtro.getNomePai())
               .IgualA("estadoCivil", filtro.getEstadoCivil())
               .IgualA("renda", filtro.getRenda())
               .OrderBy("nome", "ASC")
               .Buscar();
    }
}
