/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.SisTADS.DomainModel.Repositorios;

import br.edu.ifnmg.SisTADS.DomainModel.Professor;
import javax.ejb.Local;

/**
 *
 * @author Mauro
 */
@Local
public interface ProfessorRepositorio extends Repositorio<Professor>{
    
    
     public Professor AbrirPorCPF(String cpf);
}
