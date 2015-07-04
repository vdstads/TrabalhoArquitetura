package br.edu.ifnmg.SisTADS.DomainModel;

import br.edu.ifnmg.SisTADS.DomainModel.Curso;
import br.edu.ifnmg.SisTADS.DomainModel.Turma;
import br.edu.ifnmg.SisTADS.DomainModel.Usuario;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-04T14:20:07")
@StaticMetamodel(Aluno.class)
public class Aluno_ { 

    public static volatile SingularAttribute<Aluno, String> telefone;
    public static volatile SingularAttribute<Aluno, Turma> idTurma;
    public static volatile SingularAttribute<Aluno, Integer> quantidadeIrmaos;
    public static volatile SingularAttribute<Aluno, Usuario> idUsuario;
    public static volatile SingularAttribute<Aluno, String> nome;
    public static volatile SingularAttribute<Aluno, BigDecimal> renda;
    public static volatile SingularAttribute<Aluno, String> localidadeAnteiror;
    public static volatile SingularAttribute<Aluno, Integer> anoDeConclusao;
    public static volatile SingularAttribute<Aluno, String> escolaAnterior;
    public static volatile SingularAttribute<Aluno, String> rg;
    public static volatile SingularAttribute<Aluno, Integer> matricula;
    public static volatile SingularAttribute<Aluno, Curso> idCurso;
    public static volatile SingularAttribute<Aluno, String> nomePai;
    public static volatile SingularAttribute<Aluno, Long> id;
    public static volatile SingularAttribute<Aluno, String> sexo;
    public static volatile SingularAttribute<Aluno, Date> dataNascimento;
    public static volatile SingularAttribute<Aluno, String> nomeMae;

}