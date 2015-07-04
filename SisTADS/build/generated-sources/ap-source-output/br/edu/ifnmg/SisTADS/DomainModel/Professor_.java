package br.edu.ifnmg.SisTADS.DomainModel;

import br.edu.ifnmg.SisTADS.DomainModel.Usuario;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-04T09:54:44")
@StaticMetamodel(Professor.class)
public class Professor_ { 

    public static volatile SingularAttribute<Professor, String> cpf;
    public static volatile SingularAttribute<Professor, String> nomePai;
    public static volatile SingularAttribute<Professor, String> curriculoLattes;
    public static volatile SingularAttribute<Professor, String> nome;
    public static volatile SingularAttribute<Professor, String> estadoCivil;
    public static volatile SingularAttribute<Professor, Usuario> usuario;
    public static volatile SingularAttribute<Professor, Long> id;
    public static volatile SingularAttribute<Professor, String> sexo;
    public static volatile SingularAttribute<Professor, BigDecimal> renda;
    public static volatile SingularAttribute<Professor, String> nomeMae;

}