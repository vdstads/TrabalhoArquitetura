package br.edu.ifnmg.SisTADS.DomainModel;

import br.edu.ifnmg.SisTADS.DomainModel.Disciplina;
import br.edu.ifnmg.SisTADS.DomainModel.Professor;
import br.edu.ifnmg.SisTADS.DomainModel.Turma;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-04T22:34:56")
@StaticMetamodel(Oferta.class)
public class Oferta_ { 

    public static volatile SingularAttribute<Oferta, Professor> professor;
    public static volatile SingularAttribute<Oferta, Disciplina> disciplina;
    public static volatile SingularAttribute<Oferta, Long> id;
    public static volatile SingularAttribute<Oferta, Integer> semestre;
    public static volatile SingularAttribute<Oferta, Turma> turma;

}