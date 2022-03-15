module ru.javarush.bator_shaibonov_javarush_project_1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens ru.javarush.bator_shaibonov_javarush_project_1 to javafx.fxml;
    exports ru.javarush.bator_shaibonov_javarush_project_1;
    exports ru.javarush.bator_shaibonov_javarush_project_1.controllers;
    opens ru.javarush.bator_shaibonov_javarush_project_1.controllers to javafx.fxml;
}