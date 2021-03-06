/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.DomainModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author andre
 */
@Entity
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 150, nullable = false, unique = true)
    private String nome;

    @Column(length = 1, nullable = false)
    private String sexo;

    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    private int matricula;

    @Column(length = 25, nullable = false)
    private String telefone;

    @Column(length = 25, nullable = false)
    private String rg;

    private int quantidadeIrmaos;

    @Column(precision = 8, scale = 2)
    private BigDecimal renda;

    @Column(length = 500, nullable = false)
    private String nomeMae;

    @Column(length = 500, nullable = false)
    private String nomePai;

    @Column(length = 500, nullable = false)
    private String escolaAnterior;
    @Column(length = 500, nullable = false)
    private String localidadeAnteiror;

    private int anoDeConclusao;

    @ManyToOne
    private Turma idTurma;

    @ManyToOne
    private Curso idCurso;

    @OneToOne
    private Usuario idUsuario;

    public Aluno() {
        this.renda = new BigDecimal("0.00");
        this.idTurma = new Turma();
        this.idCurso = new Curso();
        this.idUsuario = new Usuario();
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
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

    public Turma getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Turma idTurma) {
        this.idTurma = idTurma;
    }

    public Curso getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Curso idCurso) {
        this.idCurso = idCurso;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEscolaAnterior() {
        return escolaAnterior;
    }

    public void setEscolaAnterior(String escolaAnterior) {
        this.escolaAnterior = escolaAnterior;
    }

    public String getLocalidadeAnteiror() {
        return localidadeAnteiror;
    }

    public void setLocalidadeAnteiror(String localidadeAnteiror) {
        this.localidadeAnteiror = localidadeAnteiror;
    }

    public int getAnoDeConclusao() {
        return anoDeConclusao;
    }

    public void setAnoDeConclusao(int anoDeConclusao) {
        this.anoDeConclusao = anoDeConclusao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.idTurma);
        hash = 97 * hash + Objects.hashCode(this.idCurso);
        hash = 97 * hash + Objects.hashCode(this.idUsuario);
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

        final Aluno other = (Aluno) object;
        if (!Objects.equals(this.idTurma, other.idTurma)) {
            return false;
        }
        if (!Objects.equals(this.idCurso, other.idCurso)) {
            return false;
        }
        if (!Objects.equals(this.idUsuario, other.idUsuario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nome;
    }

}
