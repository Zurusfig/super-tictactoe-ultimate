package gui;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import logic.GameLogic;

import javax.swing.text.Position;

import static gui.UIConstants.*;

public class WinPane extends StackPane {
    private Text winText;


    private ImageView playerXAnims;
    private ImageView playerOAnims;
    private ImageView tieAnims;

    private javafx.scene.control.Button menuButton;

    public WinPane() {
        super();

        winText = new Text("WON!!!");



        setPrefSize(UIConstants.SCENE_WIDTH,UIConstants.SCENE_HEIGHT);
        Image bgImg = new Image(BG_URL);
        setBackground(new Background(new BackgroundImage(bgImg,null,null,null, null)));

        Font font1 = Font.loadFont(getClass().getResourceAsStream("/res/fonts/pixel2.ttf"), 35);
        Font font2 = Font.loadFont(getClass().getResourceAsStream("/res/fonts/pixel2.ttf"), 70);
        winText.setFont(font2);
        winText.setFill(Color.rgb(255,170,213));
        winText.setStroke(Color.rgb(75,44,78));
        winText.setStrokeWidth(2);

        winText.setTextAlignment(TextAlignment.CENTER);
        setAlignment(winText, Pos.CENTER);

        menuButton = new Button("Home");
        menuButton.setFont(font1);
        menuButton.setTextFill(Color.rgb(75,44,78));
        menuButton.setAlignment(Pos.BASELINE_CENTER);
        menuButton.setBackground(new Background(new BackgroundFill(Color.rgb(255,170,213),new CornerRadii(6),null)));
        menuButton.setMinSize(75,50);
        menuButton.setBorder(new Border(new BorderStroke(Color.rgb(75,44,78),BorderStrokeStyle.SOLID,new CornerRadii(3),new BorderWidths(5))));
        menuButton.setOpacity(0.5);
        menuButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                GameLogic.getInstance().getControlPane().initiateNewGame();
            }
        });

        setAlignment(menuButton,Pos.TOP_RIGHT);
        setMargin(menuButton, new Insets(40,40,40,40));



        Image playerXImg = new Image(X_WIN_URL);
        playerXAnims = new ImageView(playerXImg);
        addAnims(playerXAnims,Pos.BOTTOM_LEFT);
//        playerXAnims.setPreserveRatio(true);
//        playerXAnims.setFitHeight(200);
//        setAlignment(playerXAnims,Pos.BOTTOM_LEFT);
//        setMargin(playerXAnims, new Insets(40,40,40,40));
//        playerXAnims.setVisible(false);


        Image playerOImg = new Image(O_WIN_URL);
        playerOAnims = new ImageView(playerOImg);
        addAnims(playerOAnims,Pos.BOTTOM_RIGHT);

//        playerOAnims.setPreserveRatio(true);
//        playerOAnims.setFitHeight(200);
//        setAlignment(playerOAnims,Pos.BOTTOM_RIGHT);
//        setMargin(playerOAnims, new Insets(40,40,40,40));
//        playerOAnims.setVisible(false);

        Image tieImg = new Image(TIE_URL);
        tieAnims = new ImageView(tieImg);
        addAnims(tieAnims, Pos.BOTTOM_CENTER);

//        tieAnims.setPreserveRatio(true);
//        tieAnims.setFitHeight(200);
//        setAlignment(tieAnims,Pos.BOTTOM_CENTER);
//        setMargin(tieAnims, new Insets(40,40,40,40));
//        tieAnims.setVisible(false);


        getChildren().add(winText);
        getChildren().addAll(playerXAnims,playerOAnims,tieAnims,menuButton);
    }

    public void addAnims(ImageView anims, Pos position){
        anims.setPreserveRatio(true);
        anims.setFitHeight(200);
        setAlignment(anims,position);
        setMargin(anims, new Insets(40,40,40,40));
        anims.setVisible(false);
    }

    public void toggleXWin(boolean bool){
        getPlayerXAnims().setVisible(bool);
    }
    public void toggleOWin(boolean bool){
        getPlayerOAnims().setVisible(bool);
    }
    public void toggleTieWin(boolean bool){
        getTieAnims().setVisible(bool);
    }




    public Text getWinText() {
        return winText;
    }

    public ImageView getPlayerXAnims() {
        return playerXAnims;
    }

    public ImageView getPlayerOAnims() {
        return playerOAnims;
    }

    public ImageView getTieAnims() {
        return tieAnims;
    }

    public Button getMenuButton() {
        return menuButton;
    }
}
