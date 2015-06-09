/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.DomainModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
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
    private InstituicaoFutura instituicaoFutura;

    @ManyToOne
    private EscolaAnterior escolaAnterior;

    public PerfilAluno(int quantidadeIrmaos, BigDecimal renda, String nomeMae, String nomePai, InstituicaoFutura idInstituicaoFutura, EscolaAnterior idEscolaAnterior) {
        this.quantidadeIrmaos = quantidadeIrmaos;
        this.renda = renda;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
        this.instituicaoFutura = idInstituicaoFutura;
        this.escolaAnterior = idEscolaAnterior;
    }

    public PerfilAluno() {
        this.quantidadeIrmaos = 0;
        this.renda = new BigDecimal(0.00);
        this.nomeMae = "";
        this.nomePai = "";
        this.instituicaoFutura = new InstituicaoFutura();
        this.escolaAnterior = new EscolaAnterior();
    }

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

    public InstituicaoFutura getInstituicaoFutura() {
        return instituicaoFutura;
    }

    public void setInstituicaoFutura(InstituicaoFutura instituicaoFutura) {
        this.instituicaoFutura = instituicaoFutura;
    }

    public EscolaAnterior getEscolaAnterior() {
        return escolaAnterior;
    }

    public void setEscolaAnterior(EscolaAnterior escolaAnterior) {
        this.escolaAnterior = escolaAnterior;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.instituicaoFutura);
        hash = 97 * hash + Objects.hashCode(this.escolaAnterior);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        final PerfilAluno other = (PerfilAluno) object;
        if (!Objects.equals(this.instituicaoFutura, other.instituicaoFutura)) {
            return false;
        }
        if (!Objects.equals(this.escolaAnterior, other.escolaAnterior)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.SisTADS.DomainModel.perfilAluno[ id=" + id + " ]";
    }

}
