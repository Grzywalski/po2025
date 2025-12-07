package org.example.auto_gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class carAddControler {


    @FXML private TextField inputNazwa;
    @FXML private TextField inputMaxBiegi;
    @FXML private Label validationLabel;

    @FXML private Button btnAnuluj;
    @FXML private Button btnAutoAdd;

    private Samochod noweAuto;

    @FXML
    private void initialize() {
        System.out.println("Auto Adder Controller załadowany.");
        validationLabel.setText("");
    }

    public Samochod getNoweAuto() {
        return noweAuto;
    }

    @FXML
    public void handleAddCar() {
        String nazwa = inputNazwa.getText().trim();
        String maxBiegiTekst = inputMaxBiegi.getText().trim();

        if (nazwa.isEmpty()) {
            validationLabel.setText("Nazwa samochodu nie może być pusta.");
            return;
        }

        int maxBiegi;
        try {
            maxBiegi = Integer.parseInt(maxBiegiTekst);
            if (maxBiegi < 1 || maxBiegi > 10) {
                validationLabel.setText("Liczba biegów musi być w zakresie 1-10.");
                return;
            }
        } catch (NumberFormatException e) {
            validationLabel.setText("Liczba biegów musi być poprawną liczbą całkowitą.");
            return;
        }

        noweAuto = new Samochod(nazwa, maxBiegi);
        System.out.println("Pomyślnie utworzono auto: " + noweAuto.getNazwa() + " z " + maxBiegi + " biegami.");


        zamknijOkno();
    }

    @FXML
    private void handleCancel() {
        noweAuto = null;
        System.out.println("Anulowano dodawanie samochodu.");
        zamknijOkno();
    }

    private void zamknijOkno() {

        Stage stage = (Stage) btnAutoAdd.getScene().getWindow();
        stage.close();
    }
}