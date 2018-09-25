package com.view.table;

import com.Game;
import com.view.hall.HallController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * @author xuwang < xuwang2@student.unimelb.edu.au >
 * @id 979895
 * @date 2018/9/17 19:26
 */
public class TableController implements Initializable{

    @FXML private BorderPane borderPane;
    @FXML public Label title;
    public static final int TableWidth = 1100;
    public static final int TableHeight = 825;
    public static final int hWidth = 500;
    public static final int hHeight = 600;
    private double xOffset;
    private double yOffset;

    @FXML private Label player1Name;
    @FXML private Label player1Score;
    @FXML public Label player1Ready;
    @FXML private ImageView player1Turn;
    @FXML private Label player2Name;
    @FXML private Label player2Score;
    @FXML private Label player2Ready;
    @FXML private ImageView player2Turn;
    @FXML private Label player3Name;
    @FXML private Label player3Score;
    @FXML private Label player3Ready;
    @FXML private ImageView player3Turn;
    @FXML private Label player4Name;
    @FXML private Label player4Score;
    @FXML private Label player4Ready;
    @FXML private ImageView player4Turn;
    @FXML private Button helpbutton;

    private static TableController instance;
    private static Stage readyStage;
    public static ReadyController readyController;

    public TableController(){
        instance = this;
    }

    public static TableController getInstance() {
        return instance;
    }

    public Stage getReadyStage(){
        return readyStage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Drag and Drop animation
        //<editor-fold defaultstate="collapsed" desc=" Drag and Drop">
        borderPane.setOnMousePressed(event -> {
            xOffset = HallController.getStage().getX() - event.getScreenX();
            yOffset = HallController.getStage().getY() - event.getScreenY();
            borderPane.setCursor(Cursor.CLOSED_HAND);
        });

        borderPane.setOnMouseDragged(event -> {
            HallController.getStage().setX(event.getScreenX() + xOffset);
            HallController.getStage().setY(event.getScreenY() + yOffset);

        });

        borderPane.setOnMouseReleased(event -> {
            borderPane.setCursor(Cursor.DEFAULT);
        });
        //</editor-fold>

        //player name
        player1Name.setText("Player 1");
        player2Name.setText("Player 2");
        player3Name.setText("Player 3");
        player4Name.setText("Player 4");

        //player score
        player1Score.setText("0");
        player2Score.setText("0");
        player3Score.setText("0");
        player4Score.setText("0");

        //player ready
        player1Ready.setVisible(false);
        player2Ready.setVisible(false);
        player3Ready.setVisible(false);
        player4Ready.setVisible(false);

        //player turn
        player1Turn.setImage(new Image(getClass().getClassLoader().getResource("images/true.png").toString()));
        player2Turn.setImage(new Image(getClass().getClassLoader().getResource("images/false.png").toString()));
        player3Turn.setImage(new Image(getClass().getClassLoader().getResource("images/false.png").toString()));
        player4Turn.setImage(new Image(getClass().getClassLoader().getResource("images/false.png").toString()));
    }

    @FXML
    public void showReadyStage() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/ready.fxml"));
        Parent window = (Pane) fxmlLoader.load();
        readyController = fxmlLoader.getController();
        readyController.title.setText(HallController.tableNumber);
        Scene scene = new Scene(window);
        scene.setFill(null);

        Platform.runLater(() -> {
            readyStage = new Stage();
            // Paternity
            readyStage.initOwner(title.getScene().getWindow());
            readyStage.initStyle(StageStyle.UNDECORATED);
            readyStage.initStyle(StageStyle.TRANSPARENT);
            readyStage.initModality(Modality.APPLICATION_MODAL);
            readyStage.setWidth(TableWidth);
            readyStage.setHeight(TableHeight);
            readyStage.setScene(scene);
            readyStage.show();
        });
    }

    @FXML
    private void confirm() {
        //TODO - send to server (playerStatus = inGame, playerAction = game_content)
    }

    @FXML
    private void pass(){
        //TODO - send to server (playerStatus = inGame, playerAction = pass)
    }



    @FXML
    void help(ActionEvent event) {
    	Platform.runLater(()->{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Welcome to Scrabble");
            alert.setHeaderText("About Scrabble:");
            alert.setContentText("The players turn by turn can place alphabet tiles on the grid to form a word.The player who places the associated letter"
            		+ " will get points equal to the length of the word.The word is considered valid if all the other players vote in favour of the word."
            		+ "The game ends when there is no place in the grid");
            alert.showAndWait();
    	});
//    	 try {
//    	    	Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/login.fxml"));
//    	        readyStage.initStyle(StageStyle.UNDECORATED);
//    	        Scene scene = new Scene(root, hWidth, hHeight);
//    	        readyStage.setScene(scene);
//    	        readyStage.setResizable(false);
//    	        readyStage.show();
//    	        readyStage.setOnCloseRequest(e -> Platform.exit());
//    	    	  }
//    	        catch (IOException e) {
//    				// TODO Auto-generated catch block
//    				e.printStackTrace();
//    			}

    }
//    @FXML
//    private void help(){
//    	  // helpController.getPrimaryStage().show();
//    	  try {
//    	Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/login.fxml"));
//        readyStage.initStyle(StageStyle.UNDECORATED);
//        Scene scene = new Scene(root, hWidth, hHeight);
//        readyStage.setScene(scene);
//        readyStage.setResizable(false);
//        readyStage.show();
//        readyStage.setOnCloseRequest(e -> Platform.exit());
//    	  }
//        catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    }

    // return to game hall
    public void returnHall() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Exit");
        alert.setHeaderText("Confirmation");
        alert.setContentText("Are you sure you want to exit this game ?");
        Optional result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            HallController.getStage().close();
            Game.getPrimaryStage().show();
            //TODO - send to server (playerStatus = inHall)
            Game.returnToHall();
        }
    }

    // Minimize Window
    public void minimizeWindow(){
        HallController.getStage().setIconified(true);
    }

}
