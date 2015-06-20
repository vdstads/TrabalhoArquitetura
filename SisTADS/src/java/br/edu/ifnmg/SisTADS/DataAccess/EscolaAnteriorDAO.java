/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.SisTADS.DataAccess;

import br.edu.ifnmg.SisTADS.DomainModel.EscolaAnterior;
import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.EscolaAnteriorRepositorio;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author Mauro
 */
@Singleton
public class EscolaAnteriorDAO extends DAOGenerico<EscolaAnterior> implements EscolaAnteriorRepositorio{
 
    public EscolaAnteriorDAO(){
        
        super(EscolaAnterior.class);
    }   
    
    
    @Override
    public List<EscolaAnterior> Buscar(EscolaAnterior filtro) {
        
        return Like("nome", filtro.getNome())
               .IgualA("id", filtro.getId())
               .IgualA("anoConclusao", filtro.getAnoConclusao())
               .IgualA("localidade", filtro.getLocalidade())
               .OrderBy("nome", "ASC")
               .Buscar();
    }
}
