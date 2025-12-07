package org.example.auto_gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.example.auto_gui.carAddControler;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloController {
    @FXML private Pane canvasPane;

    private Image carImage;

    private final List<Samochod> listaSamochodow = new ArrayList<>();
    private Samochod aktualneAuto;

    @FXML private TextField tfNazwa;
    @FXML private TextField tfIloscBiegow;
    @FXML private TextField tfAktualnyBieg;
    @FXML private TextField tfObrotySilnika;
    @FXML private Button btnZwiekszBieg;
    @FXML private Button btnZmniejszBieg;
    @FXML private Button btnWcisnijSprzeglo;
    @FXML private Button btnZwolnijSprzeglo;
    @FXML private Button btnWlaczSilnik;
    @FXML private Button btnWylaczSilnik;
    @FXML private Button btnWlaczAuto;
    @FXML private Button btnWylaczAuto;
    @FXML private Button btnDodajAuto;

    @FXML private ComboBox<Samochod> comboSamochody;
    @FXML
    private void initialize() {
        System.out.println("FXML został poprawnie wczytany.");

        comboSamochody.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {

            if (oldVal != null) {

                oldVal.widokSamochodu.setStyle("-fx-border-color: gray; -fx-border-width: 1;");
            }


            if (newVal != null) {
                aktualneAuto = newVal;
                newVal.widokSamochodu.setStyle("-fx-border-color: gold; -fx-border-width: 3;");
                newVal.widokSamochodu.setVisible(true);

                wyswietlDaneAuta(aktualneAuto);
            }
        });

        Samochod domyslneAuto = new Samochod("Domyślna Toyota", 5);
        dodajAutoDoListy(domyslneAuto);
        comboSamochody.getSelectionModel().selectFirst();
        try {
            carImage = new Image(HelloApplication.class.getResource("car.png").toExternalForm());
        } catch (Exception e) {
            System.err.println("Błąd ładowania obrazu car.jpg: " + e.getMessage());
            carImage = null;
        }
    }

    private void dodajAutoDoListy(Samochod auto) {
        listaSamochodow.add(auto);
        comboSamochody.getItems().add(auto);
        if (canvasPane != null && auto.widokSamochodu != null) {
            canvasPane.getChildren().add(auto.widokSamochodu);
            auto.widokSamochodu.setVisible(true);
        }
    }
    private void wyswietlDaneAuta(Samochod auto) {
        if (auto != null) {
            tfNazwa.setText(auto.getNazwa());
            tfIloscBiegow.setText(String.valueOf(auto.getSkrzynia().getIloscBiegow()));
            tfAktualnyBieg.setText(String.valueOf(auto.getSkrzynia().getAktualnyBieg()));
            tfObrotySilnika.setText(String.valueOf(auto.getSilnik().getObroty()));
            btnWcisnijSprzeglo.setText(auto.getSprzeglo().isWcisniete() ? "Sprzęgło (WCIŚNIĘTE)" : "Wciśnij Sprzęgło");
            btnWlaczSilnik.setText(auto.getSilnik().isWlaczony() ? "Silnik (WŁĄCZONY)" : "Włącz Silnik");

        } else {
            tfNazwa.clear();
            tfIloscBiegow.clear();
            tfAktualnyBieg.clear();
            tfObrotySilnika.clear();
        }
    }



    @FXML
    private void onDodajAuto() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(
                    HelloApplication.class.getResource("auto-adder.fxml")
            );

            AnchorPane root = fxmlLoader.load();
            carAddControler autoAdderController = fxmlLoader.getController();

            Stage stage = new Stage();
            stage.setTitle("Dodawanie Samochodu");
            stage.setScene(new Scene(root));
            stage.initModality(javafx.stage.Modality.APPLICATION_MODAL);

            stage.showAndWait();

            Samochod noweAuto = autoAdderController.getNoweAuto();

            if (noweAuto != null) {
                dodajAutoDoListy(noweAuto);
                comboSamochody.getSelectionModel().select(noweAuto);
            }

        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Nie można załadować formularza.");
            alert.setContentText("Sprawdź, czy plik auto-adder.fxml istnieje.");
            alert.showAndWait();
        }
    }

    private void wykonajAkcje(Runnable akcja) {
        if (aktualneAuto != null) {
            akcja.run();
            wyswietlDaneAuta(aktualneAuto);
        } else {
            System.out.println("Błąd: Nie wybrano żadnego samochodu.");
        }
    }

    @FXML
    public void onZwiekszBieg() {
        wykonajAkcje(() -> aktualneAuto.zwiekszBieg());
    }

    @FXML
    private void onZmniejszBieg() {
        wykonajAkcje(() -> aktualneAuto.zmniejszBieg());
    }

    @FXML
    private void onWcisnijSprzeglo() {
        wykonajAkcje(() -> aktualneAuto.wcisnijSprzeglo());
    }

    @FXML
    private void onZwolnijSprzeglo() {
        wykonajAkcje(() -> aktualneAuto.zwolnijSprzeglo());
    }

    @FXML
    private void onWlaczSilnik() {
        wykonajAkcje(() -> aktualneAuto.wlaczSilnik());
    }

    @FXML
    private void onWylaczSilnik() {
        wykonajAkcje(() -> aktualneAuto.wylaczSilnik());
    }

    @FXML
    private void onWlaczAuto() {
        wykonajAkcje(() -> aktualneAuto.wlaczAuto());
    }

    @FXML
    private void onWylaczAuto() {
        wykonajAkcje(() -> aktualneAuto.wylaczAuto());
    }

    @FXML
    public void onTestPrzesun() {
        wykonajAkcje(() -> {

            double predkosc = aktualneAuto.getAktualnyBieg() * aktualneAuto.getObrotySilnika() / 1000.0;

            aktualneAuto.przesun(10, 0);
        });
    }
}