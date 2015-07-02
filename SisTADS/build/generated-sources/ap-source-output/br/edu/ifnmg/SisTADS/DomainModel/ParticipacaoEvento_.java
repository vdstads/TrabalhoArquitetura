package br.edu.ifnmg.SisTADS.DomainModel;

import br.edu.ifnmg.SisTADS.DomainModel.Aluno;
import br.edu.ifnmg.SisTADS.DomainModel.Evento;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-01T20:41:32")
@StaticMetamodel(ParticipacaoEvento.class)
public class ParticipacaoEvento_ { 

    public static volatile SingularAttribute<ParticipacaoEvento, Aluno> aluno;
    public static volatile SingularAttribute<ParticipacaoEvento, Evento> evento;
    public static volatile SingularAttribute<ParticipacaoEvento, Date> data;
    public static volatile SingularAttribute<ParticipacaoEvento, Long> id;

}