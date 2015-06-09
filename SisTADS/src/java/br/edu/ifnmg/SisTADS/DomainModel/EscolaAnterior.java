/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.DomainModel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author andre
 */
@Entity
public class EscolaAnterior implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 150, nullable = false)
    private String nome;

    @Temporal(TemporalType.TIMESTAMP)
    private Date anoConclusao;

    @Column(length = 150, nullable = false)
    private String localidade;

    public EscolaAnterior(String nome, Date anoConclusao, String localidade) {
        this.nome = nome;
        this.anoConclusao = anoConclusao;
        this.localidade = localidade;
    }

    public EscolaAnterior() {
        this.nome = "";
        this.anoConclusao = new Date();
        this.localidade = "";
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

    public Date getAnoConclusao() {
        return anoConclusao;
    }

    public void setAnoConclusao(Date anoConclusao) {
        this.anoConclusao = anoConclusao;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
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
        if (!(object instanceof EscolaAnterior)) {
            return false;
        }
        EscolaAnterior other = (EscolaAnterior) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.SisTADS.DomainModel.EscolaAnterior[ id=" + id + " ]";
    }

}
