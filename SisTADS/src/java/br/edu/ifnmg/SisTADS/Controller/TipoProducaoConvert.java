/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.Controller;

import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.TipoProducaoRepositorio;
import br.edu.ifnmg.SisTADS.DomainModel.TipoEvento;
import br.edu.ifnmg.SisTADS.DomainModel.TipoProducao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author andre
 */
@Named(value = "tipoProducaoConvert")
@SessionScoped
public class TipoProducaoConvert implements Serializable, Converter {

    /**
     * Creates a new instance of TipoProducaoConvert
     */
    @EJB
    private TipoProducaoRepositorio repositorio;

    public TipoProducaoConvert() {
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
            TipoProducao tipoProducao = (TipoProducao) value;
            if (tipoProducao.getId() == null) {
                return null;
            }
            return tipoProducao.getId().toString();
        }
    }

}
