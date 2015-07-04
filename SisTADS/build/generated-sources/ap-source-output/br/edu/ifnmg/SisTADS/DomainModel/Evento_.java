package br.edu.ifnmg.SisTADS.DomainModel;

import br.edu.ifnmg.SisTADS.DomainModel.Cidade;
import br.edu.ifnmg.SisTADS.DomainModel.TipoEvento;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-04T09:54:44")
@StaticMetamodel(Evento.class)
public class Evento_ { 

    public static volatile SingularAttribute<Evento, Cidade> cidade;
    public static volatile SingularAttribute<Evento, Date> data;
    public static volatile SingularAttribute<Evento, TipoEvento> tipoEvento;
    public static volatile SingularAttribute<Evento, String> nome;
    public static volatile SingularAttribute<Evento, Long> id;

}