package gui;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import logic.GameLogic;
import logic.GameUtils;

import java.util.ArrayList;

public class TicTacToeCell extends Pane {

    private boolean isDrawn;
    private Color baseColor;

    private int xPosition;
    private int yPosition;

    private int xBoard;

    private int yBoard;

    private String oURL;
    private String xURL;


    public TicTacToeCell(int BoardX, int BoardY, int cellX, int cellY) {
        super();
        this.oURL = "res/o1.png";
        this.xURL = "res/x1.png";
        this.setxBoard(BoardX);
        this.setyBoard(BoardY);
        this.setxPosition(cellX);
        this.setyPosition(cellY);
        setPrefSize(50, 50);
        setBaseColor(Color.ROSYBROWN);
        initializeCellColor();


        this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                onClickHandler();
            }
        });
    }

    private void onClickHandler() {
        if (!GameLogic.getInstance().isGameEnd()) {
            if (GameLogic.getInstance().isErasePhase()) {
                int cellValue = GameLogic.getInstance().getBoard()[xBoard][yBoard][xPosition][yPosition];
                char playerTurn = GameLogic.getInstance().getCurrentPlayer();
                int playerValue = 1;
                if (playerTurn == 'O') playerValue = 2;
                if (cellValue == playerValue || cellValue == 0) {
                    GameLogic.getInstance().getInfoPane().setInfoText("Don't erase your own cell or an empty cell!");
                } else {
                    GameLogic.getInstance().getBoard()[xBoard][yBoard][xPosition][yPosition] = 0;
                    initializeCellColor();
                    GameLogic.getInstance().setErasePhase(false);
                }
            } else if(GameLogic.getInstance().getIceBlocksLeft() != 0){
                int cellValue = GameLogic.getInstance().getBoard()[xBoard][yBoard][xPosition][yPosition];
                if(cellValue == 0){
                    freezeCell();
                    GameLogic.getInstance().getBoard()[xBoard][yBoard][xPosition][yPosition] = 3;
                    GameLogic.getInstance().setIceBlocksLeft(GameLogic.getInstance().getIceBlocksLeft()-1);
                }
            }
            else {
                if (!isDrawn) {
                    GameLogic.getInstance().drawNumber(xBoard, yBoard, xPosition, yPosition);

                    if (GameLogic.getInstance().isCanDraw()) {
                        updateCellGraphic(xBoard, yBoard, xPosition, yPosition);
                        GameLogic.getInstance().setFrozenRoundLeft(GameLogic.getInstance().getFrozenRoundLeft()-1);
                    }
                    GameLogic.getInstance().setCanDraw(false);
                    GameUtils.updateInvetoryUI();
                }
            }
        }
    }


    private void updateCellGraphic(int xBoard, int yBoard, int xPosition, int yPosition) {
        int[][][][] board = GameLogic.getInstance().getBoard();
        if (board[xBoard][yBoard][xPosition][yPosition] == 1) {
            //System.out.println("Draw: "+ GameLogic.getInstance().getCurrentPlayer());
            draw(new Image(xURL), Color.DEEPPINK);
        } else if (board[xBoard][yBoard][xPosition][yPosition] == 2) {
            //System.out.println("Draw: "+ GameLogic.getInstance().getCurrentPlayer());
            draw(new Image(oURL), Color.PURPLE);
        } else {
            initializeCellColor();
        }

    }



    private void draw(Image image, Color backgroundColor) {
        BackgroundFill bgFill = new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY);
        BackgroundFill[] bgFillA = {bgFill};
        BackgroundSize bgSize = new BackgroundSize(50, 50, false, false, false, false);
        BackgroundImage bgImg = new BackgroundImage(image, null, null, null, bgSize);
        BackgroundImage[] bgImgA = {bgImg};
        this.setBackground(new Background(bgFillA, bgImgA));
        this.setDrawn(true);

    }


    private void freezeCell() {
        this.setDrawn(false);
        setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
    }

    public void initializeCellColor() {
        this.setDrawn(false);
        setBackground(new Background(new BackgroundFill(baseColor, null, null)));
    }


    public void setDrawn(boolean isDrawn) {
        this.isDrawn = isDrawn;
    }


    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public int getxBoard() {
        return xBoard;
    }

    public void setxBoard(int xBoard) {
        this.xBoard = xBoard;
    }

    public int getyBoard() {
        return yBoard;
    }

    public void setyBoard(int yBoard) {
        this.yBoard = yBoard;
    }

    public Color getBaseColor() {
        return baseColor;
    }

    public void setBaseColor(Color baseColor) {
        this.baseColor = baseColor;
    }


}
