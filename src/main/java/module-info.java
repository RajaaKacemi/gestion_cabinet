module ma.enset.gestionconsultation {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens ma.enset.gestionconsultation.controllers to javafx.fxml;
    opens ma.enset.gestionconsultation.entities;
    exports ma.enset.gestionconsultation;
}