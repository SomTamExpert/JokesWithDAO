module bbw.km {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mongo.java.driver;

    opens bbw.km to javafx.fxml;
    exports bbw.km;
}
