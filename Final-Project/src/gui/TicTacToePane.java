package gui;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.ImageCursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import logic.GameLogic;
import logic.GameUtils;

import java.awt.*;
import java.awt.font.ImageGraphicAttribute;
import java.util.ArrayList;

public class TicTacToePane extends StackPane {

    private ArrayList<TicTacToeCell> allCells;

    private Rectangle xRect;
    private Pane xPane;
    private Rectangle oRect;
    private Rectangle tieRect;


    private GridPane pane;

    public TicTacToePane(int x, int y) {
        super();
        pane = new GridPane();
        this.allCells = new ArrayList<TicTacToeCell>();
        pane.setHgap(4);
        pane.setVgap(4);
        pane.setPadding(new Insets(1));
        pane.setAlignment(Pos.CENTER);
        pane.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        pane.setBackground(new Background(new BackgroundFill(Color.MISTYROSE, CornerRadii.EMPTY, Insets.EMPTY)));

        pane.setMaxSize(180, 180);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.allCells.add(new TicTacToeCell(x, y, i, j));
                pane.add(allCells.get((i * 3) + j), i, j);
            }
        }

        this.xPane = new Pane();
        xPane.setPrefSize(180, 180);

        xRect = new Rectangle();
        initializeRect(xRect, Color.DEEPPINK);

        xRect.setOnMouseClicked(e -> resetLocalBoard(x, y));


        oRect = new Rectangle();
        initializeRect(oRect, Color.PURPLE);

        oRect.setOnMouseClicked(e -> resetLocalBoard(x, y));

        tieRect = new Rectangle();
        initializeRect(tieRect, Color.LIGHTGRAY);
        tieRect.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if ((GameLogic.getInstance().getGlobalBoard()[x][y] == -1) && GameLogic.getInstance().isTieBreaker()) {
                    char user = GameLogic.getInstance().getCurrentPlayer();
                    if (user == 'X') {
                        xRect.setVisible(true);
                        GameLogic.getInstance().getGlobalBoard()[x][y] = 1;
                    } else {
                        oRect.setVisible(true);
                        GameLogic.getInstance().getGlobalBoard()[x][y] = 2;
                    }
                    tieRect.setVisible(false);
                    GameLogic.getInstance().setTieBreaker(false);
                    GameLogic.getInstance().initiatingWin();
                }
            }
        });


        this.getChildren().add(pane);
        this.getChildren().addAll(xRect, oRect, tieRect);

    }


    public void initializeRect(Rectangle rect, Color color) {
        rect.setFill(color);
        rect.setHeight(180);
        rect.setWidth(180);
        rect.setOpacity(0.5);
        rect.setVisible(false);
    }

    public void resetLocalBoard(int x, int y) {
        if (GameLogic.getInstance().getGlobalBoard()[x][y] != 0 && GameLogic.getInstance().isUpgradedErasePhase()) {
            GameLogic.getInstance().getGlobalBoard()[x][y] = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    GameLogic.getInstance().getBoard()[x][y][i][j] = 0;
                }
            }
            for (TicTacToeCell cell : getAllCells()) {
                cell.initializeCellColor();
            }
            xRect.setVisible(false);
            oRect.setVisible(false);
            tieRect.setVisible(false);
            GameLogic.getInstance().setUpgradedErasePhase(false);
        }
    }


    public ArrayList<TicTacToeCell> getAllCells() {
        return allCells;
    }

    public Rectangle getxRect() {
        return xRect;
    }

    public Rectangle getoRect() {
        return oRect;
    }

    public Rectangle getTieRect() {
        return tieRect;
    }

    public GridPane getPane() {
        return pane;
    }

}
