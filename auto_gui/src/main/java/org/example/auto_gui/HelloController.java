package org.example.auto_gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader; // POTRZEBNY DO ŁADOWANIA FXML
import javafx.scene.Scene;     // POTRZEBNY DO TWORZENIA SCENY W NOWYM OKNIE
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane; // POTRZEBNY DO KONTENERA ROOT
import javafx.stage.Stage;     // POTRZEBNY DO TWORZENIA NOWEGO OKNA

public class HelloController {

    // Pola z FXML
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
    @FXML private ComboBox<String> comboSamochody;





    @FXML
    private void initialize() {
        System.out.println("FXML został poprawnie wczytany.");
        comboSamochody.getItems().addAll();
    }

    @FXML
    public void onZwiekszBieg() {
        System.out.println("Zwiększ bieg");
    }

    @FXML
    private void onZmniejszBieg() {
        System.out.println("Zmniejsz bieg");
    }

    @FXML
    private void onWcisnijSprzeglo() {
        System.out.println("Sprzęgło wciśnięte");
    }

    @FXML
    private void onZwolnijSprzeglo() {
        System.out.println("Sprzęgło zwolnione");
    }

    @FXML
    private void onWlaczSilnik() {
        System.out.println("Włączam silnik");
    }

    @FXML
    private void onWylaczSilnik() {
        System.out.println("Wyłączam silnik");
    }

    @FXML
    private void onWlaczAuto() {
        System.out.println("Auto włączone");
    }

    @FXML
    private void onWylaczAuto() {
        System.out.println("Auto wyłączone");
    }
    @FXML
    private void onDodajAuto() {
        try {
            // Użycie FXMLLoader do załadowania nowego ekranu z pliku .fxml
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("auto-adder.fxml"));

            // Załadowanie widoku do Parent
            AnchorPane root = fxmlLoader.load();

            // Klasa Stage jako nowe okno
            Stage stage = new Stage();
            stage.setTitle("Dodawanie Samochodu");
            stage.setScene(new Scene(root));

            // Opcjonalnie: Ustawienie modalności (blokuje interakcję z głównym oknem)
            stage.initModality(javafx.stage.Modality.APPLICATION_MODAL);

            stage.showAndWait(); // Pokazanie okna i czekanie na jego zamknięcie

            // Opcjonalnie: Odświeżenie comboSamochody po powrocie z okna
            // (Wymagałoby to przekazania referencji lub użycia wzorca Observer)

        } catch (Exception e) {
            e.printStackTrace();
            // Opcjonalny komunikat błędu dla użytkownika
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Nie można załadować formularza.");
            alert.setContentText("Sprawdź, czy plik data-input-view.fxml istnieje.");
            alert.showAndWait();
        }
    }
}

