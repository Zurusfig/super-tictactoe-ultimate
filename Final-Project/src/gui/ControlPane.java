package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.GameLogic;

public class ControlPane extends HBox {

    private Text gameText;
    private TicTacToeGlobal ticTacToeGlobal;

    public ControlPane(TicTacToeGlobal ticTacToeGlobal) {
        super();
        this.ticTacToeGlobal = ticTacToeGlobal;
        setAlignment(Pos.CENTER);
        setPrefWidth(200);
        setPrefHeight(100);
        setSpacing(20);
        initializeGameText();
        getChildren().add(gameText);
        setPadding(new Insets(20));
        setBackground(new Background(new BackgroundFill(Color.rgb(75, 40, 77), null, null)));

    }

    private void initializeGameText() {
        gameText = new Text("X Turn");
        Font font = Font.loadFont(getClass().getResourceAsStream("/res/fonts/pixel2.ttf"), 35);
        gameText.setFont(font);
        gameText.setFill(Color.rgb(255, 170, 213));

    }

    public void updateGameText(String text) {
        gameText.setText(text);

    }


    public void initiateNewGame() {
        GameLogic.getInstance().newGame();
        for (TicTacToePane pane : ticTacToeGlobal.getAllPanes()) {
            pane.getxRect().setVisible(false);
            pane.getoRect().setVisible(false);
            pane.getTieRect().setVisible(false);
            for (TicTacToeCell cell : pane.getAllCells()) {
                cell.initializeCellColor();
            }
        }

    }

    public TicTacToeGlobal getTicTacToeGlobal() {
        return ticTacToeGlobal;
    }

}
