/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.DomainModel;

import java.io.Serializable;
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

    @Column(length = 150, nullable = false)
    private String nome;

    @Column(length = 1, nullable = false)
    private String sexo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    private int matricula;

    private int telefone;

    private int rg;

    @ManyToOne
    private Turma idTurma;

    @ManyToOne
    private Curso idCurso;

    @ManyToOne
    private Evento idEvento;

    @ManyToOne
    private Producao idProducao;

    @OneToOne
    private PerfilAluno idPerfilAluno;

    @OneToOne
    private Usuario idUsuario;

    public Aluno(String nome, String sexo, Date data, int matricula, int telefone, int rg, Turma idTurma, Curso idCurso, Evento idEvento, Producao idProducao, PerfilAluno idPerfilAluno, Usuario usuario) {
        this.nome = nome;
        this.sexo = sexo;
        this.data = data;
        this.matricula = matricula;
        this.telefone = telefone;
        this.rg = rg;
        this.idTurma = idTurma;
        this.idCurso = idCurso;
        this.idEvento = idEvento;
        this.idProducao = idProducao;
        this.idPerfilAluno = idPerfilAluno;
        this.idUsuario = usuario;
    }

    public Aluno() {
        this.nome = "";
        this.sexo = "";
        this.data = new Date();
        this.matricula = 0;
        this.telefone = 0;
        this.rg = 0;
        this.idTurma = new Turma();
        this.idCurso = new Curso();
        this.idEvento = new Evento();
        this.idProducao = new Producao();
        this.idPerfilAluno = new PerfilAluno();
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
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

    public Evento getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Evento idEvento) {
        this.idEvento = idEvento;
    }

    public Producao getIdProducao() {
        return idProducao;
    }

    public void setIdProducao(Producao idProducao) {
        this.idProducao = idProducao;
    }

    public PerfilAluno getIdPerfilAluno() {
        return idPerfilAluno;
    }

    public void setIdPerfilAluno(PerfilAluno idPerfilAluno) {
        this.idPerfilAluno = idPerfilAluno;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idTurma);
        hash = 97 * hash + Objects.hashCode(this.idCurso);
        hash = 97 * hash + Objects.hashCode(this.idEvento);
        hash = 97 * hash + Objects.hashCode(this.idProducao);
        hash = 97 * hash + Objects.hashCode(this.idPerfilAluno);
        hash = 97 * hash + Objects.hashCode(this.idPerfilAluno);
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
        if (!Objects.equals(this.idEvento, other.idEvento)) {
            return false;
        }
        if (!Objects.equals(this.idProducao, other.idProducao)) {
            return false;
        }
        if (!Objects.equals(this.idPerfilAluno, other.idPerfilAluno)) {
            return false;
        }
        if (!Objects.equals(this.idUsuario, other.idUsuario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.SisTADS.DomainModel.Aluno[ id=" + id + " ]";
    }

}
