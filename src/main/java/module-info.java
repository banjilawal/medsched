module edu.ics372.abdnn.medsched {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.ics372.abdnn.medsched to javafx.fxml;
    exports edu.ics372.abdnn.medsched;
}