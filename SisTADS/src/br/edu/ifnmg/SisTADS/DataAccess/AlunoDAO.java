/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.DataAccess;

import br.edu.ifnmg.SisTADS.DomainModel.Aluno;
import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.AlunoRepositorio;
import java.util.List;

/**
 *
 * @author Mauro
 */
public class AlunoDAO extends DAOGenerico<Aluno> implements AlunoRepositorio{
    
    public AlunoDAO(){
        super(Aluno.class);
    }
    
    
    @Override
    public List<Aluno> Buscar(Aluno filtro) {
        
        return Like("nome", filtro.getNome())
               .IgualA("id", filtro.getId())
               .IgualA("sexo", filtro.getSexo())
               .IgualA("data", filtro.getData())
               .IgualA("matricula",filtro.getMatricula())
               .IgualA("telefone", filtro.getTelefone())
               .IgualA("rg", filtro.getRg())
               .OrderBy("nome", "ASC")
               .Buscar();
    }
}
