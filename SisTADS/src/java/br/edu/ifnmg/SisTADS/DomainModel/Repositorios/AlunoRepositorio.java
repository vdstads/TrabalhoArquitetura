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
 * @author Mauro
 */
@Local
public interface AlunoRepositorio extends Repositorio<Aluno> {

    public Aluno AbrirPorNome(String nome);
    public Usuario AbrirUsuario(String email);

    public boolean SalvarUsuario(String email, String senha);

}
