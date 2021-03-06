/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.Controller;

import br.edu.ifnmg.SisTADS.DomainModel.Curso;
import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.CursoRepositorio;
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
@Named(value = "cursoConvert")
@SessionScoped
public class CursoConvert implements Serializable, Converter {

    /**
     * Creates a new instance of CursoConvert
     */
    @EJB
    private CursoRepositorio repositorio;

    public CursoConvert() {
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
            Curso curso = (Curso) value;
            if (curso.getId() == null) {
                return null;
            }
            return curso.getId().toString();
        }
    }

}
