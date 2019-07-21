package pl.sda.weather.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RootController {

    @FXML
    private TextField city;
    @FXML
    private Label temperature;
    @FXML
    private Button check;


    public void getWeather(ActionEvent actionEvent) {

        System.out.println("Klik");
        temperature.setText(city.getText());
    }
}
