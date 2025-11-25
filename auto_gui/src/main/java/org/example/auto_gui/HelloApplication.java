package org.example.auto_gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        System.out.println("Classpath root: " + System.getProperty("java.class.path"));
        System.out.println(HelloApplication.class.getResource("/hello-view.fxml"));


        FXMLLoader fxmlLoader = new FXMLLoader(
                HelloApplication.class.getResource("hello-view.fxml")
        );

        Scene scene = new Scene(fxmlLoader.load(), 400, 200);
        stage.setTitle("Minimal JavaFX App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
