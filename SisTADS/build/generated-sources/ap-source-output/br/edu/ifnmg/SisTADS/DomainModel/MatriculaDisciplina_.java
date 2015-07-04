package br.edu.ifnmg.SisTADS.DomainModel;

import br.edu.ifnmg.SisTADS.DomainModel.Aluno;
import br.edu.ifnmg.SisTADS.DomainModel.Oferta;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-04T14:20:07")
@StaticMetamodel(MatriculaDisciplina.class)
public class MatriculaDisciplina_ { 

    public static volatile SingularAttribute<MatriculaDisciplina, Aluno> aluno;
    public static volatile SingularAttribute<MatriculaDisciplina, Oferta> oferta;
    public static volatile SingularAttribute<MatriculaDisciplina, Long> id;

}