package pl.sda.weather.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pl.sda.weather.model.Weather;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class RootController {

    @FXML
    private TextField city;
    @FXML
    private Label temperature;
    @FXML
    private Button check;
    @FXML
    private ImageView logo;


    public void getWeather(ActionEvent actionEvent) {

        ObjectMapper objectMapper = new ObjectMapper();

        Weather weather = null;
        try {
            weather = objectMapper.readValue(new URL("http://api.apixu.com/v1/current.json?key=e5434bc67a674701ac281204191307&q=" + city.getText()), Weather.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        temperature.setText(Double.toString(weather.getCurrent().getTemp_c()));
        Image image = new Image( "http:" + weather.getCurrent().getCondition().getIcon());
        logo.setImage(image);


    }

}



