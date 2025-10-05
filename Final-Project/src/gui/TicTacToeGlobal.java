package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class TicTacToeGlobal extends GridPane {
    private ArrayList<TicTacToePane> allPanes;

    public TicTacToeGlobal() {
        super();
        this.allPanes = new ArrayList<TicTacToePane>();
        this.setHgap(4);
        this.setVgap(4);
        this.setPadding(new Insets(8));
        this.setAlignment(Pos.CENTER);
        this.setPrefWidth(800);
        this.setPrefHeight(800);

        setBackground(new Background(new BackgroundFill(Color.rgb(125, 79, 128),null,null)));

        for(int i = 0;i<3;i++) {
            for(int j =0;j<3;j++) {
                this.allPanes.add(new TicTacToePane(i,j));
                this.add(allPanes.get((i*3)+j), i, j);
            }
        }
    }

    public ArrayList<TicTacToePane> getAllPanes() {
        return allPanes;
    }


}
