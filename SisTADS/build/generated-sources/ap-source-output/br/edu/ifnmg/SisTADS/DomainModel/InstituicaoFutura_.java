package br.edu.ifnmg.SisTADS.DomainModel;

import br.edu.ifnmg.SisTADS.DomainModel.Aluno;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-04T14:20:07")
@StaticMetamodel(InstituicaoFutura.class)
public class InstituicaoFutura_ { 

    public static volatile SingularAttribute<InstituicaoFutura, String> atividade;
    public static volatile SingularAttribute<InstituicaoFutura, Aluno> aluno;
    public static volatile SingularAttribute<InstituicaoFutura, Date> ano;
    public static volatile SingularAttribute<InstituicaoFutura, String> nome;
    public static volatile SingularAttribute<InstituicaoFutura, Long> id;

}