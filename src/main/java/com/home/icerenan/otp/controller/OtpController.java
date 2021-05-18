package com.home.icerenan.otp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OtpController implements Initializable {

    @FXML
    private  MenuItem home;

    @FXML
    private  MenuItem exit;

    @FXML
    private  MenuItem view;

    @FXML
    private  MenuItem add;

    @FXML
    private  MenuItem help;

    @FXML
    private  MenuItem about;
    @FXML
    private BorderPane borderPane;




    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void otpHome(ActionEvent actionEvent) {
    }

    public void otpExit(ActionEvent actionEvent) {

    }

    public void otpView(ActionEvent actionEvent) {
        URL resource = getClass().getResource("/com/home/icerenan/otp/view/view.fxml");
        try {
            setCenter(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void otpAdd(ActionEvent actionEvent) {

    }

    public void otpHelp(ActionEvent actionEvent) {

    }

    public void otpAbout(ActionEvent actionEvent) {

    }

    private void setCenter(URL url) throws IOException {
        FXMLLoader loader = new FXMLLoader(url);
        loader.load();
        Parent center = loader.getRoot();
        borderPane.setCenter(center);
    }
}
