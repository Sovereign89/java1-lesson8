module ru.geekbrains.gbjava18 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;

    opens ru.geekbrains.gbjava18 to javafx.fxml;
    exports ru.geekbrains.gbjava18;
}