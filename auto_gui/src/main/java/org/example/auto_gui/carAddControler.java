package org.example.auto_gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class carAddControler {

    // Pola z FXML
    @FXML private TextField inputNazwa;
    @FXML private TextField inputMaxBiegi;
    @FXML private TextField validationLabel;



    @FXML private Button btnAnuluj;
    @FXML private Button btnAutoAdd;


    @FXML
    private void initialize() {
        System.out.println("auto adder zaladowany.");
    }

    @FXML
    public void handleAddCar() {
        System.out.println("dodano auto");
    }

    @FXML
    private void handleCancel() {
        System.out.println("anulowano");
    }}


