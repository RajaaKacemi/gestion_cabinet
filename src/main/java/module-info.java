module ma.enset.gestionconsultations {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;

    opens ma.enset.gestionconsultations.controllers to javafx.fxml;
    exports ma.enset.gestionconsultations;
}
