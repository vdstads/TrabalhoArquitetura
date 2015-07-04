/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.Controller;

import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.TipoEventoRepositorio;
import br.edu.ifnmg.SisTADS.DomainModel.TipoEvento;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author andre
 */
@ManagedBean
@SessionScoped
public class TipoEventoConvert implements Serializable, Converter {

    @EJB
    private TipoEventoRepositorio repositorio;

    public TipoEventoConvert() {
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
            TipoEvento tipoEvento = (TipoEvento) value;
            if (tipoEvento.getId() == null) {
                return null;
            }
            return tipoEvento.getId().toString();
        }
    }

}
