package com.mycompany.robinsjolundimlamning4.entities;

import com.mycompany.robinsjolundimlamning4.entities.BetygPK;
import com.mycompany.robinsjolundimlamning4.entities.Kurser;
import com.mycompany.robinsjolundimlamning4.entities.Studenter;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-16T14:46:29")
@StaticMetamodel(Betyg.class)
public class Betyg_ { 

    public static volatile SingularAttribute<Betyg, Kurser> kurser;
    public static volatile SingularAttribute<Betyg, String> betyg;
    public static volatile SingularAttribute<Betyg, BetygPK> betygPK;
    public static volatile SingularAttribute<Betyg, Studenter> studenter;

}