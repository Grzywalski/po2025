package org.example.auto_gui;

import javafx.application.Platform;
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

public class HelloController implements Listener {
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
    @FXML private Button btndodajGazu;
    @FXML private Button btnHamuj;
    @FXML private Button btnUsunAuto;

    @FXML private ComboBox<Samochod> comboSamochody;
    @FXML
    private void initialize() {
        System.out.println("FXML został poprawnie wczytany.");

        comboSamochody.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {

            if (newVal != null) {
                if (aktualneAuto != null) aktualneAuto.removeListener(this);
                aktualneAuto = newVal;
                aktualneAuto.addListener(this);
                update();
            }
        });

        Samochod domyslneAuto = new Samochod("Domyślna Toyota", 5);
        dodajAutoDoListy(domyslneAuto);
        domyslneAuto.addListener(this);
        comboSamochody.getSelectionModel().selectFirst();
        try {
            carImage = new Image(HelloApplication.class.getResource("car.png").toExternalForm());
        } catch (Exception e) {
            System.err.println("Błąd ładowania obrazu car.jpg: " + e.getMessage());
            carImage = null;
        }
        canvasPane.setOnMouseClicked(e -> {
            if (aktualneAuto == null) {
                System.out.println("Nie wybrano auta");
                return;
            }
            double x = e.getX();
            double y = e.getY();
            aktualneAuto.jedzDo(new Pozycja(x,y));
            System.out.println(x + " " + y);
        });


    }
    @Override
    public void update() {
        if (aktualneAuto != null) {
            Platform.runLater(() -> {
                tfNazwa.setText(aktualneAuto.getNazwa());
                tfIloscBiegow.setText(String.valueOf(aktualneAuto.getSkrzynia().getIloscBiegow()));
                tfAktualnyBieg.setText(String.valueOf(aktualneAuto.getSkrzynia().getAktualnyBieg()));
                tfObrotySilnika.setText(String.valueOf(aktualneAuto.getSilnik().getObroty()));
                btnWcisnijSprzeglo.setText(aktualneAuto.getSprzeglo().stanSprzegla() ? "Sprzęgło (WCIŚNIĘTE)" : "Wciśnij Sprzęgło");
                btnWlaczSilnik.setText(aktualneAuto.getSilnik().isWlaczony() ? "Silnik (WŁĄCZONY)" : "Włącz Silnik");
                btnWlaczAuto.setText(aktualneAuto.isAutoOn() ? "Auto (Włączone)" : "Włącz Auto");
                aktualneAuto.aktualizujWidokNaPlanszy();
            });
        }else{
            tfNazwa.clear();
            tfIloscBiegow.clear();
            tfAktualnyBieg.clear();
            tfObrotySilnika.clear();
            btnWcisnijSprzeglo.setText("Wciśnij Sprzęgło");
            btnWlaczSilnik.setText("Włącz Silnik");
            btnWlaczAuto.setText("Włącz Auto");
        }
    }


    private void dodajAutoDoListy(Samochod auto) {
        listaSamochodow.add(auto);
        comboSamochody.getItems().add(auto);
        if (canvasPane != null && auto.widokSamochodu != null) {
            canvasPane.getChildren().add(auto.widokSamochodu);
            auto.widokSamochodu.setVisible(true);
            auto.addListener(() -> auto.aktualizujWidokNaPlanszy());
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
                noweAuto.addListener(this);
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
    @FXML
    private void onUsunAuto(){
        if (aktualneAuto == null) {
            System.out.println("Brak auta do usunięcia");
            return;
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Usuń auto");
        alert.setHeaderText("Czy na pewno chcesz usunąć auto?");
        alert.setContentText(aktualneAuto.getNazwa());

        if (alert.showAndWait().orElse(ButtonType.CANCEL) != ButtonType.OK) {
            return;
        }

        aktualneAuto.usunAuto();
        canvasPane.getChildren().remove(aktualneAuto.widokSamochodu);

        listaSamochodow.remove(aktualneAuto);
        comboSamochody.getItems().remove(aktualneAuto);

        if (!listaSamochodow.isEmpty()) {
            Samochod nowe = listaSamochodow.get(0);
            comboSamochody.getSelectionModel().select(nowe);
            aktualneAuto = nowe;
            aktualneAuto.addListener(this);
            update();
        } else {
            aktualneAuto = null;
            update();
        }

    }

    private void wykonajAkcje(Runnable akcja) {
        if (aktualneAuto != null) {
            akcja.run();
        } else {
            System.out.println("Błąd: Nie wybrano żadnego samochodu.");
        }
    }

    @FXML
    public void onZwiekszBieg() {
        wykonajAkcje(() -> aktualneAuto.zwiekszBieg());
    }
    @FXML
    public void onZwiekszObroty(){
        wykonajAkcje(()->aktualneAuto.silnik.zwiekszObroty(200));
    }
    @FXML
    public void onZmniejszObroty(){
        wykonajAkcje(()->aktualneAuto.silnik.zmniejszObroty(200));

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
    public void zatrzymajWszystkieSamochody() {
        for (Samochod auto : listaSamochodow) {
            auto.usunAuto();
        }
    }

}