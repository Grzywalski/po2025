package org.example.auto_gui;

import javafx.fxml.FXML;
import javafx.scene.control.*;

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

    @FXML private ComboBox<String> comboSamochody;



    // --------- PRZYKŁADOWE PUSTE METODY ----------

    @FXML
    private void initialize() {
        System.out.println("FXML został poprawnie wczytany.");
        comboSamochody.getItems().addAll("Auto 1", "Auto 2", "Auto 3");
    }

    @FXML
    private void onZwiekszBieg() {
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
}
