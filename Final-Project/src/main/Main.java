package main;

import gui.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logic.BackgroundSong;
import logic.GameLogic;
import logic.GameUtils;
import gui.UIConstants;

import java.util.ArrayList;

public class Main extends Application{



	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		BackgroundSong.getInstance().playBackgroundMusic();
		MenuPane menuPane = new MenuPane();
		menuPane.setPrefHeight(UIConstants.SCENE_HEIGHT);
		menuPane.setPrefWidth(UIConstants.SCENE_WIDTH);

		WinPane winPane = new WinPane();
		HowToPlayPane howToPlayPane = new HowToPlayPane();


		BorderPane root = new BorderPane();
		BorderPane centerPane = new BorderPane();
		root.setPrefHeight(UIConstants.SCENE_HEIGHT);
		root.setPrefWidth(UIConstants.SCENE_WIDTH);


		TicTacToeGlobal ticTacToeGlobal = new TicTacToeGlobal();
		ControlPane controlPane = new ControlPane(ticTacToeGlobal);
		InfoPane infoPane = new InfoPane();
		XPlayerPane xPlayerPane= new XPlayerPane();
		OPlayerPane oPlayerPane = new OPlayerPane();



		GameLogic.getInstance().setControlPane(controlPane);
		GameLogic.getInstance().setXPlayerPane(xPlayerPane);
		GameLogic.getInstance().setOPlayerPane(oPlayerPane);
		GameLogic.getInstance().setInfoPane(infoPane);
		centerPane.setTop(controlPane);

		centerPane.setCenter(ticTacToeGlobal);


		root.setCenter(centerPane);

		root.setLeft(xPlayerPane);
		root.setRight(oPlayerPane);
		centerPane.setBottom(infoPane);


		Scene scene = new Scene(root);
		Scene menuScene = new Scene(menuPane);
		Scene winScene = new Scene(winPane);

		Scene howToPlayScene = new Scene(howToPlayPane);



		//adding events
		menuPane.getStartBtn().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				primaryStage.setScene(scene);
				controlPane.initiateNewGame();
				GameLogic.getInstance().newGame();
				GameLogic.getInstance().updateHighLight();
				String xName = menuPane.getxInput().getText();
				String oName = menuPane.getoInput().getText();
				GameLogic.getInstance().getPlayerX().setName(xName);
				GameLogic.getInstance().getPlayerO().setName(oName);
				xPlayerPane.getTitleText().setText(xName+"'s\nInventory");
				oPlayerPane.getTitleText().setText(oName+"'s\nInventory");
				controlPane.updateGameText(xName+"'s Turn");
				xPlayerPane.setxName(xName);
				oPlayerPane.setoName(oName);

				GameUtils.removeInventoryUI('X');
				GameUtils.removeInventoryUI('O');

				infoPane.setInfoText("LET THE GAME BEGIN!!");

				winPane.toggleOWin(false);
				winPane.toggleXWin(false);
				winPane.toggleTieWin(false);



			}
		});

		menuPane.getStartBtn().setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				menuScene.setCursor(Cursor.HAND);
				menuPane.getStartBtn().setBackground(new Background(new BackgroundFill(Color.rgb(239,203,227),new CornerRadii(6),null)));
			}
		});
		menuPane.getStartBtn().setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				menuScene.setCursor(Cursor.DEFAULT);
				menuPane.getStartBtn().setBackground(new Background(new BackgroundFill(Color.rgb(255,170,213),new CornerRadii(6),null)));
			}
		});

		menuPane.getHowToPlayBtn().setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				menuScene.setCursor(Cursor.HAND);
				menuPane.getHowToPlayBtn().setBackground(new Background(new BackgroundFill(Color.rgb(239,203,227),new CornerRadii(6),null)));
			}
		});
		menuPane.getHowToPlayBtn().setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				menuScene.setCursor(Cursor.DEFAULT);
				menuPane.getHowToPlayBtn().setBackground(new Background(new BackgroundFill(Color.rgb(255,170,213),new CornerRadii(6),null)));
			}
		});
		menuPane.getHowToPlayBtn().setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				primaryStage.setScene(howToPlayScene);
			}
		});


		winPane.getMenuButton().setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				winScene.setCursor(Cursor.HAND);
				winPane.getMenuButton().setOpacity(1);
			}
		});

		winPane.getMenuButton().setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				winScene.setCursor(Cursor.DEFAULT);
				winPane.getMenuButton().setOpacity(0.5);
			}
		});

		winPane.getMenuButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				primaryStage.setScene(menuScene);

			}
		});

		howToPlayPane.getMenuButton().setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				howToPlayScene.setCursor(Cursor.HAND);
				howToPlayPane.getMenuButton().setOpacity(1);
			}
		});

		howToPlayPane.getMenuButton().setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				howToPlayScene.setCursor(Cursor.DEFAULT);
				howToPlayPane.getMenuButton().setOpacity(0.5);
			}
		});

		howToPlayPane.getMenuButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				primaryStage.setScene(menuScene);

//				GameLogic.getInstance().newGame();
//				TicTacToeGlobal ticTacToeGlobal1 = new TicTacToeGlobal();
//				controlPane.setTicTacToeGlobal(ticTacToeGlobal1);
//				GameLogic.getInstance().setControlPane(controlPane);
//				centerPane.setCenter(ticTacToeGlobal1);
//
//				root.setCenter(centerPane);

				controlPane.initiateNewGame();

			}
		});

		ArrayList<TicTacToePane> ticTacToePanes = ticTacToeGlobal.getAllPanes();
		for(TicTacToePane tttP : ticTacToePanes){
			ArrayList<TicTacToeCell> ticTacToeCells = tttP.getAllCells();
			for(TicTacToeCell tttC : ticTacToeCells){
				tttC.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent mouseEvent) {
						if(GameLogic.getInstance().getFinalGameState() == 1){
							primaryStage.setScene(winScene);
							winPane.getWinText().setText(menuPane.getxInput().getText()+" WON!!!");
							winPane.toggleXWin(true);
						}else if(GameLogic.getInstance().getFinalGameState() == 2){
							primaryStage.setScene(winScene);
							winPane.getWinText().setText(menuPane.getoInput().getText()+" WON!!!");
							winPane.toggleOWin(true);
						}else if(GameLogic.getInstance().getFinalGameState() == -1){
							primaryStage.setScene(winScene);
							winPane.getWinText().setText("TIED!!!");
							winPane.toggleTieWin(true);
						}
					}
				});
			}
		}


		//set Scenes
		primaryStage.setScene(menuScene);
		primaryStage.setTitle("Super Tic-Tac-Toe Ultimate");
//		primaryStage.setFullScreen(true);
		primaryStage.setResizable(false);
		primaryStage.show();


	}

	private MediaPlayer mediaPlayer;
	private String mediaPath;


	public static void main(String[] args) {
		launch(args);
	}



}
