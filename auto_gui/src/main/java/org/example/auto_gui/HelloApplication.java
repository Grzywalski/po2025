package org.example.auto_gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(
                HelloApplication.class.getResource("hello-view.fxml")
        );

        Scene scene = new Scene(fxmlLoader.load(), 1200, 600);
        stage.setTitle("symulator auta");
        stage.setScene(scene);
        HelloController controller = fxmlLoader.getController();

        stage.setOnCloseRequest(event -> {
            controller.zatrzymajWszystkieSamochody();
        });
        stage.show();

    }

    public static void main(String[] args) {
        launch();

    }

}
