package org.example.auto_gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class carAddControler {


    @FXML private TextField inputNazwa;
    @FXML private TextField inputMaxBiegi;
    @FXML private TextField inputKonie;
    @FXML private Label validationLabel;
    @FXML private ComboBox<String> inputSCT;

    @FXML private Button btnAnuluj;
    @FXML private Button btnAutoAdd;

    private Samochod noweAuto;

    @FXML
    private void initialize() {
        System.out.println("Auto Adder Controller załadowany.");
        validationLabel.setText("");
        inputSCT.setValue("czy spelnia SCT ?");
        inputSCT.getItems().addAll("Spelnia", "nie spelnia");
    }

    public Samochod getNoweAuto() {
        return noweAuto;
    }

    @FXML
    public void handleAddCar() {
        String nazwa = inputNazwa.getText().trim();
        String maxBiegiTekst = inputMaxBiegi.getText().trim();
        String konie = inputKonie.getText().trim();
        String Sct = inputSCT.getValue();
        boolean SCT;
        if (Sct.equals("Spelnia")){
            SCT = true;
        }else {
            SCT = false;
        }

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
        int Konie;
        try {
            Konie = Integer.parseInt(konie);
            if (maxBiegi < 1 || maxBiegi > 1000) {
                validationLabel.setText("Liczba koni musi być w zakresie 1-1000.");
                return;
            }
        } catch (NumberFormatException e) {
            validationLabel.setText("Liczba koni musi być poprawną liczbą całkowitą.");
            return;
        }

        noweAuto = new Samochod(nazwa, maxBiegi,Konie,SCT);
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