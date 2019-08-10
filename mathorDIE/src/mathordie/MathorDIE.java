package mathordie;

import java.time.LocalDate;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class MathorDIE extends Application {
    public static GridPane grid = new GridPane();
    public static LocalDate dateNow = LocalDate.now();
    public static Button start = new Button();
    public static Label infoText = new Label();
    public static Random rand = new Random();
    public static Label question = new Label();
    public static TextField ansHere = new TextField();
    public static Button submAns = new Button();
    public static Label scoreLab = new Label();
    public static Button tryAgain = new Button();
    public static int nroRan1;
    public static int nroRan2;
    public static String mainEx;
    public static int vastaus;
    public static String pAns;
    public static int pAnsInt;
    public static int score;
    @Override
    public void start(Stage primaryStage) {
        infoText.setText("Remington " + dateNow);
        infoText.setStyle("-fx-font-size: 30px;");
        start.setText("Start");
        start.setStyle("-fx-font-size: 54; -fx-background-color: lightblue;");
        start.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                startGame();
            }
        });
        
        grid.setMinSize(1280, 720);
        grid.add(start, 0, 0);
        grid.add(infoText, 0, 5);
        grid.setVgap(5);
        grid.setHgap(5);
        grid.setAlignment(Pos.CENTER);

        Scene scene = new Scene(grid);
        
        primaryStage.setTitle("Math Or Die");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void startGame() {
        score = 0;
        grid.getChildren().remove(infoText);
        grid.getChildren().remove(start);
        exerciseX();
    }
    
    public static void exerciseX() {
        grid.getChildren().remove(tryAgain);
        grid.getChildren().remove(scoreLab);
        nroRan1 = rand.nextInt(1000) + 1;
        nroRan2 = rand.nextInt(1000) + 1;
        ansHere.setStyle("-fx-font-size: 35px;");
        submAns.setText("Submit");
        submAns.setStyle("-fx-font-size: 20px;");
        question.setStyle("-fx-font-size: 40px;");
        mainEx = (nroRan1 + "+" + nroRan2);
        question.setText(mainEx);
        vastaus = (nroRan1 + nroRan2);
        grid.add(question, 0, 0);
        grid.add(ansHere, 0, 5);
        grid.add(submAns, 0, 10);
        submAns.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                checkAns();
            }
        });
    }
    
    public static void checkAns() {
        pAns = ansHere.getText();
        pAnsInt = Integer.parseInt(pAns);
        if(pAnsInt == vastaus){
            score += 1;
            exerciseX();
            vastaus = (nroRan1 + nroRan2);
        }
        else {
            uLose();
        }
    }

    public static void uLose() {
        grid.getChildren().remove(ansHere);
        grid.getChildren().remove(submAns);
        grid.getChildren().remove(question);
        scoreLab.setStyle("-fx-font-size: 50px;");
        scoreLab.setText("You got " + score);
        tryAgain.setText("Try Again");
        tryAgain.setStyle("-fx-font-size: 34px;");
        grid.add(scoreLab, 0, 0);
        grid.add(tryAgain, 0, 5);
        tryAgain.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                exerciseX();
            }
        });
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
