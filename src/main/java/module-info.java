module com.mycompany.project {
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.persistence;
    requires java.sql;
    requires javafx.controls;
    opens com.mycompany.project to org.hibernate.orm.core; 
    exports com.mycompany.project;
}
