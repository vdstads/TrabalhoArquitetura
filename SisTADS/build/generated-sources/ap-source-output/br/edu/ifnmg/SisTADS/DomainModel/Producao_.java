package br.edu.ifnmg.SisTADS.DomainModel;

import br.edu.ifnmg.SisTADS.DomainModel.Aluno;
import br.edu.ifnmg.SisTADS.DomainModel.Professor;
import br.edu.ifnmg.SisTADS.DomainModel.TipoProducao;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-05T23:23:41")
@StaticMetamodel(Producao.class)
public class Producao_ { 

    public static volatile SingularAttribute<Producao, Professor> professor;
    public static volatile SingularAttribute<Producao, Aluno> aluno;
    public static volatile SingularAttribute<Producao, Date> data;
    public static volatile SingularAttribute<Producao, TipoProducao> tipoProducao;
    public static volatile SingularAttribute<Producao, String> nome;
    public static volatile SingularAttribute<Producao, Long> id;

}