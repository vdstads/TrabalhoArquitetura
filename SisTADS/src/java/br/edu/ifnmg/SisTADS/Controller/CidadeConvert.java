/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.Controller;

import br.edu.ifnmg.SisTADS.DomainModel.Cidade;
import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.CidadeRepositorio;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

/**
 *
 * @author andre
 */
@Named(value = "cidadeConvert")
@SessionScoped
public class CidadeConvert implements Serializable, Converter {

    @EJB
    private CidadeRepositorio repositorio;

    public CidadeConvert() {
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
        if (value == null || value.toString().equals("")) {
            return null;
        } else {
            Cidade cidade = (Cidade) value;
            if (cidade.getId() == null) {
                return null;
            }
            return cidade.getId().toString();
        }
    }

}
