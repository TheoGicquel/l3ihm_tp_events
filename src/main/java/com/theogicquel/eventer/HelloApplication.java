package com.theogicquel.eventer;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public int counterInt = 0;
    @Override
    public void start(Stage stage) throws IOException {
        double globalWidth=250;
        // elements
        Label countLabel = new Label();
        countLabel.setText(""+counterInt);
        countLabel.setWrapText(true);
        countLabel.maxWidth(globalWidth);
        countLabel.setPrefWidth(globalWidth); // needed for proper label text wrap
        countLabel.setAlignment(Pos.CENTER);
        Button plusButton = new Button("+");
        Button minusButton = new Button("-");
        minusButton.setDisable(true);




        plusButton.setOnAction((new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                counterInt++;
                countLabel.setText(""+counterInt);
                minusButton.setDisable(false);
            }
        }));

        minusButton.setOnAction((new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(counterInt==0)
                {
                    minusButton.setDisable(true);
                }else
                {
                    counterInt--;
                    countLabel.setText(""+counterInt);
                }

            }
        }));






        HBox countHBox = new HBox();
        countHBox.setAlignment(Pos.CENTER);
        countHBox.getChildren().add(minusButton);

        countHBox.getChildren().add(countLabel);

        countHBox.getChildren().add(plusButton);


        // layout
        VBox mainVbox = new VBox();
        mainVbox.setPrefWidth(globalWidth);
        //verticalBox.setMargin(textLabel,new Insets(10,10,10,10));
        mainVbox.setAlignment(Pos.CENTER);


        Button razButton = new Button("RAZ");
        mainVbox.getChildren().add(countHBox);
        mainVbox.getChildren().add(razButton);

        stage.setTitle("Message");
        Scene scene = new Scene(mainVbox);
        stage.setWidth(globalWidth);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}