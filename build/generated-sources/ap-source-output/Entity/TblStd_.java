package Entity;

import Entity.TblStudent;
import Entity.TblTeacher;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-03-07T03:54:51")
@StaticMetamodel(TblStd.class)
public class TblStd_ { 

    public static volatile SingularAttribute<TblStd, Integer> stdid;
    public static volatile CollectionAttribute<TblStd, TblStudent> tblStudentCollection;
    public static volatile CollectionAttribute<TblStd, TblTeacher> tblTeacherCollection;
    public static volatile SingularAttribute<TblStd, String> stdname;

}