/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.Controller;

import br.edu.ifnmg.SisTADS.DomainModel.Disciplina;
import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.DisciplinaRepositorio;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

/**
 *
 * @author andre
 */
@Named(value = "disciplinaConvert")
@SessionScoped
public class DisciplinaConvert implements Serializable, Converter {

    /**
     * Creates a new instance of DisciplinaConvert
     */
    @EJB
    private DisciplinaRepositorio repositorio;

    public DisciplinaConvert() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")) {
            return null;
        } else {
            Long id = Long.parseLong(value);
            return repositorio.Abrir(id);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        } else {
            Disciplina disciplina = (Disciplina) value;
            if (disciplina.getId() == null) {
                return null;
            }
            return disciplina.getId().toString();
        }
    }
}
