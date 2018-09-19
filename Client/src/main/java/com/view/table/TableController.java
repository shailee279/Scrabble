package com.view.table;

import com.Game;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author xuwang < xuwang2@student.unimelb.edu.au >
 * @id 979895
 * @date 2018/9/17 19:26
 */
public class TableController implements Initializable{

    @FXML private BorderPane borderPane;
    @FXML public Label title;

    public static final int TableWidth = 1000;
    public static final int TableHeight = 700;
    private double xOffset;
    private double yOffset;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Drag and Drop animation
        //<editor-fold defaultstate="collapsed" desc=" Drag and Drop">
        borderPane.setOnMousePressed(event -> {
            xOffset = Game.getPrimaryStage().getX() - event.getScreenX();
            yOffset = Game.getPrimaryStage().getY() - event.getScreenY();
            borderPane.setCursor(Cursor.CLOSED_HAND);
        });

        borderPane.setOnMouseDragged(event -> {
            Game.getPrimaryStage().setX(event.getScreenX() + xOffset);
            Game.getPrimaryStage().setY(event.getScreenY() + yOffset);

        });

        borderPane.setOnMouseReleased(event -> {
            borderPane.setCursor(Cursor.DEFAULT);
        });
        //</editor-fold>
    }
    // Terminates Application
    public void returnHall(){
        //TODO - return hall


    }

    // Minimize Window
    public void minimizeWindow(){
        Game.getPrimaryStage().setIconified(true);
    }

}
