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

/**
 *
 * @author andre
 */
@Entity
public class PerfilProfessor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 150, nullable = false)
    private String nome;

    @Column(length = 150, nullable = false)
    private String estadoCivil;

    @Column(precision = 8, scale = 2)
    private BigDecimal renda;

    @Column(length = 150, nullable = false)
    private String nomePai;

    @Column(length = 150, nullable = false)
    private String nomeMae;

    public PerfilProfessor(String nome, String estadoCivil, BigDecimal renda, String nomePai, String nomeMae) {
        this.nome = nome;
        this.estadoCivil = estadoCivil;
        this.renda = renda;
        this.nomePai = nomePai;
        this.nomeMae = nomeMae;
    }

    public PerfilProfessor() {
        this.nome = "";
        this.estadoCivil = "";
        this.renda = new BigDecimal(0.00);
        this.nomePai = "";
        this.nomeMae = "";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public void setRenda(BigDecimal renda) {
        this.renda = renda;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
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
        if (!(object instanceof PerfilProfessor)) {
            return false;
        }
        PerfilProfessor other = (PerfilProfessor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.SisTADS.DomainModel.PerfilProfessor[ id=" + id + " ]";
    }

}
