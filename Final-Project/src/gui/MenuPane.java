package gui;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import static gui.UIConstants.*;

public class MenuPane extends StackPane {

    private Button startBtn;

    private Button howToPlayBtn;

    private String playerX;
    private String playerO;

    private String titleURL;

    private String bgURL;

    private VBox centerPane;
    private HBox inputPane;

    private TextField xInput;
    private TextField oInput;

    private String xName;
    private String oName;

    public MenuPane() {
        super();

        Image titleImg = new Image(TITLE_URL);
        ImageView title = new ImageView(titleImg);
        title.setPreserveRatio(true);
        title.setFitHeight(250);
        setMargin(title,new Insets(40,40,40,40));
        title.setEffect(new DropShadow(10,Color.BLACK));

        Image playerXImg = new Image(PLAYER_X_URL);
        ImageView playerXAnims = new ImageView(playerXImg);
        playerXAnims.setPreserveRatio(true);
        playerXAnims.setFitHeight(200);
        setMargin(playerXAnims, new Insets(40,40,40,40));

        Image playerOImg = new Image(PLAYER_O_URL);
        ImageView playerOAnims = new ImageView(playerOImg);
        playerOAnims.setPreserveRatio(true);
        playerOAnims.setFitHeight(200);
        setMargin(playerOAnims, new Insets(40,40,40,40));

        Image bgImg = new Image(BG_URL);
        setBackground(new Background(new BackgroundImage(bgImg,null,null,null, null)));

        setBackground(new Background(new BackgroundFill(Color.PURPLE,null,null)));
        setBackground(new Background(new BackgroundImage(bgImg,null,null,null, null)));

        centerPane = new VBox();
        centerPane.setAlignment(Pos.CENTER);
        startBtn = new Button("Start!");

        Font font1 = Font.loadFont(getClass().getResourceAsStream("/res/fonts/pixel2.ttf"), 35);
        Font font2 = Font.loadFont(getClass().getResourceAsStream("/res/fonts/pixel2.ttf"), 35);
        Font font3 = Font.loadFont(getClass().getResourceAsStream("/res/fonts/pixel2.ttf"), 18);

        Text instructionText = new Text("Enter Name for Each Players");
        instructionText.setFont(font1);
        instructionText.setFill(Color.rgb(255,170,213));
        instructionText.setStroke(Color.rgb(75,44,78));
        instructionText.setStrokeWidth(1);

        startBtn.setFont(font2);
        startBtn.setTextFill(Color.rgb(75,44,78));
        startBtn.setAlignment(Pos.BASELINE_CENTER);
        startBtn.setBackground(new Background(new BackgroundFill(Color.rgb(255,170,213),new CornerRadii(6),null)));
        startBtn.setMinSize(100,50);
        startBtn.setBorder(new Border(new BorderStroke(Color.rgb(75,44,78),BorderStrokeStyle.SOLID,new CornerRadii(3),new BorderWidths(5))));

        howToPlayBtn = new Button("How To Play");
        howToPlayBtn.setFont(font2);
        howToPlayBtn.setTextFill(Color.rgb(75,44,78));
        howToPlayBtn.setAlignment(Pos.BASELINE_CENTER);
        howToPlayBtn.setBackground(new Background(new BackgroundFill(Color.rgb(255,170,213),new CornerRadii(6),null)));
        howToPlayBtn.setBorder(new Border(new BorderStroke(Color.rgb(75,44,78),BorderStrokeStyle.SOLID,new CornerRadii(3),new BorderWidths(5))));
        howToPlayBtn.setPrefSize(290,50);

        inputPane = new HBox();

        xInput = new TextField();
        xInput.setPromptText("Enter Name for Player X");
        xInput.setPrefWidth(270);
        xInput.setPrefHeight(25);
        xInput.setBackground(new Background(new BackgroundFill(Color.rgb(248,226,241),new CornerRadii(6),null)));
        xInput.setFont(font3);
        xInput.addEventFilter(KeyEvent.KEY_TYPED, maxLength(13));

        oInput = new TextField();
        oInput.setPromptText("Enter Name for Player O");
        oInput.setPrefWidth(270);
        oInput.setPrefHeight(25);
        oInput.setBackground(new Background(new BackgroundFill(Color.rgb(248,226,241),new CornerRadii(6),null)));
        oInput.setFont(font3);
        oInput.addEventFilter(KeyEvent.KEY_TYPED, maxLength(13));

        inputPane.getChildren().addAll(xInput,oInput);
        inputPane.setSpacing(50);
        inputPane.setAlignment(Pos.CENTER);


        centerPane.getChildren().addAll(instructionText,inputPane,startBtn,howToPlayBtn);
        centerPane.setSpacing(30);

        centerPane.setTranslateY(100);

        Text credits = new Text("Created by Ittichet Thongsang and Weeraphat Kawthaisong");
        credits.setFont(font1);
        credits.setFill(Color.rgb(255,170,213));
        credits.setStroke(Color.rgb(75,44,78));
        credits.setStrokeWidth(1);

        setAlignment(title,Pos.TOP_CENTER);
        setAlignment(centerPane,Pos.CENTER);
        setAlignment(playerXAnims,Pos.BOTTOM_LEFT);
        setAlignment(playerOAnims,Pos.BOTTOM_RIGHT);

        getChildren().addAll(title,centerPane, playerXAnims,playerOAnims);

    }

    public EventHandler<KeyEvent> maxLength(final Integer i) {
        return new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent arg0) {

                TextField tx = (TextField) arg0.getSource();
                if (tx.getText().length() >= i) {
                    arg0.consume();
                }

            }

        };

    }

    public Button getStartBtn() {
        return startBtn;
    }

    public Button getHowToPlayBtn() {
        return howToPlayBtn;
    }

    public TextField getxInput() {
        return xInput;
    }

    public void setxInput(TextField xInput) {
        this.xInput = xInput;
    }

    public TextField getoInput() {
        return oInput;
    }

    public void setoInput(TextField oInput) {
        this.oInput = oInput;
    }

    public String getxName() {
        return xName;
    }

    public void setxName(String xName) {
        this.xName = xName;
    }

    public String getoName() {
        return oName;
    }

    public void setoName(String oName) {
        this.oName = oName;
    }


}
