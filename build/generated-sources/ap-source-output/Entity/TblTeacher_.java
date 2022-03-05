package Entity;

import Entity.TblStd;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-03-06T01:48:08")
@StaticMetamodel(TblTeacher.class)
public class TblTeacher_ { 

    public static volatile SingularAttribute<TblTeacher, Integer> teacherId;
    public static volatile SingularAttribute<TblTeacher, String> teacherName;
    public static volatile CollectionAttribute<TblTeacher, TblStd> tblStdCollection;

}