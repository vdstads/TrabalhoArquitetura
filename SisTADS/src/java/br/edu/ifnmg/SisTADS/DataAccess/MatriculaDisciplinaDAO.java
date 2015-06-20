/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.DataAccess;

import br.edu.ifnmg.SisTADS.DomainModel.MatriculaDisciplina;
import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.MatriculaDisciplinaRepositorio;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author andre
 */
@Singleton
public class MatriculaDisciplinaDAO extends DAOGenerico<MatriculaDisciplina> implements MatriculaDisciplinaRepositorio{

    public MatriculaDisciplinaDAO() {
        super(MatriculaDisciplina.class);
    }

    @Override
    public List<MatriculaDisciplina> Buscar(MatriculaDisciplina filtro) {
        return Buscar();
    }
    
    

    
}
