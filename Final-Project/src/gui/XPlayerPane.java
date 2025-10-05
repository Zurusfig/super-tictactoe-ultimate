package gui;

import base.BaseItem;
import item.*;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import logic.GameLogic;

import java.sql.SQLOutput;

public class XPlayerPane extends VBox {
    private Text titleText;

    private InventoryPane xInventoryUI;

    private CraftingPane craftingPane;

    private String xName = "X";


    public XPlayerPane(){
        super();
        titleText = new Text("X's\nInvetory");
        titleText.setTextAlignment(TextAlignment.CENTER);
        Font font = Font.loadFont(getClass().getResourceAsStream("/res/fonts/pixel2.ttf"), 30);
        titleText.setFont(font);
        setAlignment(Pos.TOP_CENTER);
        titleText.setFill(Color.MISTYROSE);

        setPadding(new Insets(30));
        setPrefSize(250,720);
        setBackground(new Background(new BackgroundFill(Color.rgb(49, 11, 51),null,null)));

        xInventoryUI = new InventoryPane();

        getChildren().add(titleText);
        getChildren().add(xInventoryUI);

        craftingPane = new CraftingPane();

        getChildren().add(craftingPane);
        setMargin(craftingPane,new Insets(10));


        char currentPlayer = GameLogic.getInstance().getCurrentPlayer();
        //            String xName = GameLogic.getInstance().getPlayerX().getName();
        xInventoryUI.getMagicEraserIV().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(GameLogic.getInstance().getXplayerItem().getOrDefault("Magic Eraser",0) > 0) {
                    GameLogic.getInstance().setXSelectedItem(new MagicEraser());
                    System.out.println("X selected: "+ GameLogic.getInstance().getXSelectedItem());
                    if(GameLogic.getInstance().getCurrentPlayer() == 'X') {
                        GameLogic.getInstance().getInfoPane().setInfoText(xName + " selected: " + GameLogic.getInstance().getXSelectedItem().getName());
                    }
                }
            }
        });

        xInventoryUI.getMagicEraserUpgradedIV().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(GameLogic.getInstance().getXplayerItem().getOrDefault("Upgraded Magic Eraser",0) > 0) {
                    MagicEraser magicEraserUp = new MagicEraser();
                    magicEraserUp.upgrade();
                    GameLogic.getInstance().setXSelectedItem(magicEraserUp);
                    System.out.println("X selected: "+ GameLogic.getInstance().getXSelectedItem());
                    if(GameLogic.getInstance().getCurrentPlayer() == 'X') {
                        GameLogic.getInstance().getInfoPane().setInfoText(xName + " selected: " + GameLogic.getInstance().getXSelectedItem().getName());
                    }
                }
            }
        });

        xInventoryUI.getDoubleSpellIV().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(GameLogic.getInstance().getXplayerItem().getOrDefault("Double Spell",0) > 0) {
                    GameLogic.getInstance().setXSelectedItem(new DoubleSpell());
                    System.out.println("Selected upgraded?: "+  GameLogic.getInstance().getXSelectedItem().getName());
                    System.out.println("X selected: "+ GameLogic.getInstance().getXSelectedItem());
                    if(GameLogic.getInstance().getCurrentPlayer() == 'X') {
                        GameLogic.getInstance().getInfoPane().setInfoText(xName + " selected: " + GameLogic.getInstance().getXSelectedItem().getName());
                    }
                }
            }
        });

        xInventoryUI.getTripleSpellIV().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameLogic.getInstance().getXplayerItem().getOrDefault("Triple Spell", 0) > 0) {
                    DoubleSpell tripleSpell = new DoubleSpell();
                    tripleSpell.upgrade();
                    GameLogic.getInstance().setXSelectedItem(tripleSpell);
                    System.out.println("X selected: " + GameLogic.getInstance().getXSelectedItem());
                    if (GameLogic.getInstance().getCurrentPlayer() == 'X') {
                        GameLogic.getInstance().getInfoPane().setInfoText(xName + " selected: " + GameLogic.getInstance().getXSelectedItem().getName());
                    }
                }
            }
        });

        xInventoryUI.getIceBlocksIV().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(GameLogic.getInstance().getXplayerItem().getOrDefault("Ice Blocks",0) > 0) {
                    GameLogic.getInstance().setXSelectedItem(new IceBlocks());
                    System.out.println("X selected: "+ GameLogic.getInstance().getXSelectedItem());
                    if(GameLogic.getInstance().getCurrentPlayer() == 'X') {
                        GameLogic.getInstance().getInfoPane().setInfoText(xName + " selected: " + GameLogic.getInstance().getXSelectedItem().getName());
                    }
                }
            }
        });

        xInventoryUI.getIceBlocksUpgradedIV().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(GameLogic.getInstance().getXplayerItem().getOrDefault("Packed Ice Blocks",0) > 0) {
                    IceBlocks packedIceBlocks = new IceBlocks();
                    packedIceBlocks.upgrade();
                    GameLogic.getInstance().setXSelectedItem(packedIceBlocks);
                    System.out.println("X selected: "+ GameLogic.getInstance().getXSelectedItem());
                    if(GameLogic.getInstance().getCurrentPlayer() == 'X') {
                        GameLogic.getInstance().getInfoPane().setInfoText(xName + " selected: " + GameLogic.getInstance().getXSelectedItem().getName());
                    }
                }
            }
        });

        xInventoryUI.getDestroyerRayIV().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(GameLogic.getInstance().getXplayerItem().getOrDefault("Destroyer Ray",0) > 0) {
                    GameLogic.getInstance().setXSelectedItem(new DestroyerRay());
                    System.out.println("X selected: "+ GameLogic.getInstance().getXSelectedItem());
                    if(GameLogic.getInstance().getCurrentPlayer() == 'X') {
                        GameLogic.getInstance().getInfoPane().setInfoText(xName + " selected: " + GameLogic.getInstance().getXSelectedItem().getName());
                    }
                }
            }
        });

        xInventoryUI.getTieBreakerIV().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(GameLogic.getInstance().getXplayerItem().getOrDefault("Tie Breaker",0) > 0) {
                    GameLogic.getInstance().setXSelectedItem(new TieBreaker());
                    System.out.println("X selected: "+ GameLogic.getInstance().getXSelectedItem());
                    if(GameLogic.getInstance().getCurrentPlayer() == 'X') {
                        GameLogic.getInstance().getInfoPane().setInfoText(xName + " selected: " + GameLogic.getInstance().getXSelectedItem().getName());
                    }
                }
            }
        });

        xInventoryUI.getCraftingCatalystIV().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(GameLogic.getInstance().getXplayerItem().getOrDefault("Crafting Catalyst",0) > 0) {
                    GameLogic.getInstance().setXSelectedItem(new CraftingCatalyst());
                    System.out.println("X selected: "+ GameLogic.getInstance().getXSelectedItem());
                    if(GameLogic.getInstance().getCurrentPlayer() == 'X') {
                        GameLogic.getInstance().getInfoPane().setInfoText(xName + " selected: " + GameLogic.getInstance().getXSelectedItem().getName());
                    }
                }
            }
        });

        xInventoryUI.getStuntGrenadeIV().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(GameLogic.getInstance().getXplayerItem().getOrDefault("Stunt Grenade",0) > 0) {
                    GameLogic.getInstance().setXSelectedItem(new StuntGrenade());
                    System.out.println("X selected: "+ GameLogic.getInstance().getXSelectedItem());
                    if(GameLogic.getInstance().getCurrentPlayer() == 'X') {
                        GameLogic.getInstance().getInfoPane().setInfoText(xName + " selected: " + GameLogic.getInstance().getXSelectedItem().getName());
                    }
                }
            }
        });


    }


    public Text getTitleText() {
        return titleText;
    }

    public InventoryPane getxInventoryUI() {
        return xInventoryUI;
    }

    public CraftingPane getCraftingPane() {
        return craftingPane;
    }

    public String getxName() {
        return xName;
    }

    public void setxName(String xName) {
        this.xName = xName;
    }
}
