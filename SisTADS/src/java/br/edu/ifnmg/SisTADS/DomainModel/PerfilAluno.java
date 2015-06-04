/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.DomainModel;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author andre
 */
@Entity
public class PerfilAluno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int quantidadeIrmaos;

    @Column(precision = 8, scale = 2)
    private BigDecimal renda;

    @Column(length = 150, nullable = false)
    private String nomeMae;

    @Column(length = 150, nullable = false)
    private String nomePai;

    @ManyToOne
    private InstituicaoFutura idInstituicaoFutura;

    @ManyToOne
    private EscolaAnterior idEscolaAnterior;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidadeIrmaos() {
        return quantidadeIrmaos;
    }

    public void setQuantidadeIrmaos(int quantidadeIrmaos) {
        this.quantidadeIrmaos = quantidadeIrmaos;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public void setRenda(BigDecimal renda) {
        this.renda = renda;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public InstituicaoFutura getIdInstituicaoFutura() {
        return idInstituicaoFutura;
    }

    public void setIdInstituicaoFutura(InstituicaoFutura idInstituicaoFutura) {
        this.idInstituicaoFutura = idInstituicaoFutura;
    }

    public EscolaAnterior getIdEscolaAnterior() {
        return idEscolaAnterior;
    }

    public void setIdEscolaAnterior(EscolaAnterior idEscolaAnterior) {
        this.idEscolaAnterior = idEscolaAnterior;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilAluno)) {
            return false;
        }
        PerfilAluno other = (PerfilAluno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.SisTADS.DomainModel.perfilAluno[ id=" + id + " ]";
    }

}
