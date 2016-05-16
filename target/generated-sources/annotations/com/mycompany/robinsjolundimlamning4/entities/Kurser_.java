package com.mycompany.robinsjolundimlamning4.entities;

import com.mycompany.robinsjolundimlamning4.entities.Betyg;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-16T14:46:29")
@StaticMetamodel(Kurser.class)
public class Kurser_ { 

    public static volatile SingularAttribute<Kurser, String> namn;
    public static volatile SingularAttribute<Kurser, Integer> id;
    public static volatile CollectionAttribute<Kurser, Betyg> betygCollection;

}