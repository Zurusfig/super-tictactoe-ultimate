package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class InfoPane extends HBox {
    private Text infoText;
    public InfoPane(){
        super();
        setAlignment(Pos.CENTER);
        setPrefWidth(200);
        setPrefHeight(80);
        setSpacing(20);
        initializeInfoText();
        setBackground(Background.fill(Color.rgb(75, 40, 77)));
        getChildren().add(infoText);
    }

    private void initializeInfoText() {
        infoText= new Text("No Item Found Yet");
        Font font = Font.loadFont(getClass().getResourceAsStream("/res/fonts/pixel2.ttf"), 25);
        infoText.setFont(font);
        infoText.setFill(Color.rgb(255,170,213));

    }

    public void setInfoText(String text) {
        infoText.setText(text);
    }
}
