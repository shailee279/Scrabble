package com.view.hall;

import com.Game;
import com.model.player.Player;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author xuwang < xuwang2@student.unimelb.edu.au >
 * @id 979895
 * @date 2018/9/18 2:19
 */
public class HallController implements Initializable {

    @FXML private BorderPane borderPane;
    @FXML private TableView<Player> playerList;
    @FXML private TableColumn username;
    @FXML private TableColumn status;
    public static ObservableList<Player> data = FXCollections.observableArrayList();

    private double xOffset;
    private double yOffset;

    public void updateStatus(Player player) {
        data.add(player);
        playerList.setItems(data);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Drag and Drop animation
        //<editor-fold defaultstate="collapsed" desc=" Drag and Drop">
        borderPane.setOnMousePressed(event -> {
            xOffset = Game.getPrimaryStage().getX() - event.getScreenX();
            yOffset = Game.getPrimaryStage().getY() - event.getScreenY();
            borderPane.setCursor(javafx.scene.Cursor.CLOSED_HAND);
        });

        borderPane.setOnMouseDragged(event -> {
            Game.getPrimaryStage().setX(event.getScreenX() + xOffset);
            Game.getPrimaryStage().setY(event.getScreenY() + yOffset);

        });

        borderPane.setOnMouseReleased(event -> {
            borderPane.setCursor(Cursor.DEFAULT);
        });
        //</editor-fold>

        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    // Terminates Application
    public void closeSystem(){
        Platform.exit();
        System.exit(0);
    }

    // Minimize Window
    public void minimizeWindow(){
        Game.getPrimaryStage().setIconified(true);
    }

}
