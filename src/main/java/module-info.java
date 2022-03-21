module com.theogicquel.eventer {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.theogicquel.eventer to javafx.fxml;
    exports com.theogicquel.eventer;
}