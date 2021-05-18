package com.home.icerenan.otp.controller;

import com.home.icerenan.otp.utils.BasicConfigMapCacheUtils;
import com.home.icerenan.otp.utils.GoogleAuthenticatorUtils;
import com.home.icerenan.otp.utils.GridPandMapCacheUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.apache.commons.lang3.StringUtils;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class ViewController implements Initializable {

    @FXML
    private ListView listView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private void initHome(){
        if(BasicConfigMapCacheUtils.getInstance().size()<1){
            return;
        }
        for(Map.Entry<String,String> map:BasicConfigMapCacheUtils.getInstance().entrySet()){
            String key = map.getKey();
            String value = map.getValue();
            if(StringUtils.isBlank(key)||StringUtils.isBlank(value)){
                continue;
            }
            this.initGridPaneMap(key,value);
        }
    }

    private void initGridPaneMap(String key,String value){
        GridPane gridPane = GridPandMapCacheUtils.getInstance().get(key);
        this.initGridPane(gridPane,key,value);
        GridPandMapCacheUtils.getInstance().put(key,gridPane);
    }

    private void initGridPane(GridPane gridPand,String key,String value){
        if(gridPand == null){
            gridPand = new GridPane();
        }
        gridPand.setHgap(2);
        gridPand.setVgap(1);
        Label label = new Label(key+"：");
        TextField textField = new TextField(GoogleAuthenticatorUtils.getCode(value));
        textField.setEditable(false);
        textField.setStyle("-fx-background-color: transparent;");
        gridPand.add(label,0,1);
        gridPand.add(textField,1,1);
    }
}
