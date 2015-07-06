/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.Controller;

import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.TurmaRepositorio;
import br.edu.ifnmg.SisTADS.DomainModel.Turma;
import java.io.IOException;
import java.io.InputStream;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author andre
 */
@Named(value = "turmaController")
@SessionScoped
public class TurmaController extends ControllerGenerico<Turma> implements Serializable {

    /**
     * Creates a new instance of TurmaController
     */
    @EJB
    private TurmaRepositorio repositorio;

    public TurmaController() {
        super("listaTurma.xhtml", "editarTurma.xhtml", "cadastroTurma.xhtml");
        entidade = new Turma();
        filtro = new Turma();
    }

    public void imprimirRelatorio() {
        InputStream reportStream = null;
        try {
            reportStream = getClass().getResourceAsStream("/relatorio/AlunoPorTurma.jasper");

            JRDataSource ds = new JRBeanCollectionDataSource(getListagem(), true);

            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, null, ds);

            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            httpServletResponse.addHeader("Content-disposition", "attachment; filename=" + "Aluno por Turma" + ".pdf");
            ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
            FacesContext.getCurrentInstance().responseComplete();

        } catch (JRException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String limparfiltros() {
        filtro = new Turma();
        return super.limparfiltros(); //To change body of generated methods, choose Tools | Templates.
    }

    @PostConstruct
    public void configurar() {
        setDao(repositorio);
    }

}
