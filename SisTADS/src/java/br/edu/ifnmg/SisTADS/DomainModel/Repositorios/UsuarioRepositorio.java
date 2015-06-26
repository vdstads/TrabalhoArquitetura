/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.DomainModel.Repositorios;

import br.edu.ifnmg.SisTADS.DomainModel.Aluno;
import br.edu.ifnmg.SisTADS.DomainModel.Professor;
import br.edu.ifnmg.SisTADS.DomainModel.Usuario;
import javax.ejb.Local;

/**
 *
 * @author andre
 */
@Local
public interface UsuarioRepositorio extends Repositorio<Usuario>{
    public Usuario login(Usuario usuario);
    public Professor verificarProfessor(Usuario usuario);
    public Aluno verificarAluno(Usuario usuario);
}
