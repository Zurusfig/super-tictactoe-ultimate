package gui;

import base.BaseItem;
import item.*;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import logic.GameLogic;
import logic.GameUtils;
import logic.UseItemHandler;


public class OPlayerPane extends VBox {
    private Text titleText;

    private InventoryPane oInvetory;

    private Button useBtn;
    private Button addCraftBtn;
    private String oName = "O";


    public OPlayerPane() {
        super();
        titleText = new Text("O's\nInvetory");
        titleText.setTextAlignment(TextAlignment.CENTER);
        Font font = Font.loadFont(getClass().getResourceAsStream("/res/fonts/pixel2.ttf"), 30);
        Font font2 = Font.loadFont(getClass().getResourceAsStream("/res/fonts/pixel2.ttf"), 20);
        titleText.setFont(font);
        setAlignment(Pos.TOP_CENTER);
        titleText.setFill(Color.MISTYROSE);

        setPadding(new Insets(30));
        setPrefSize(250, 720);
        setBackground(new Background(new BackgroundFill(Color.rgb(49, 11, 51), null, null)));

        oInvetory = new InventoryPane();

        useBtn = new Button("Use Item");
        useBtn.setTextFill(Color.rgb(75, 44, 78));
        useBtn.setFont(font2);
        useBtn.setAlignment(Pos.BASELINE_CENTER);
        useBtn.setBackground(new Background(new BackgroundFill(Color.rgb(255, 170, 213), new CornerRadii(3), null)));
        useBtn.setBorder(new Border(new BorderStroke(Color.rgb(75, 44, 78), BorderStrokeStyle.SOLID, new CornerRadii(1), new BorderWidths(2))));
        useBtn.setOpacity(0.7);
        if (!GameLogic.getInstance().isRoundItemUsed()) {
            useBtn.setOnMouseEntered(e -> useBtn.setOpacity(1));
            useBtn.setOnMouseExited(e -> useBtn.setOpacity(0.7));
        } else {
            useBtn.setDisable(true);
            useBtn.setOpacity(0.1);
        }
        useBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                UseItemHandler.useItem();
                GameUtils.updateInvetoryUI();
                if (GameLogic.getInstance().isRoundItemUsed()) {
                    useBtn.setDisable(true);
                }
            }
        });

        addCraftBtn = new Button("Use to Craft");
        addCraftBtn.setTextFill(Color.rgb(75, 44, 78));
        addCraftBtn.setFont(font2);
        addCraftBtn.setAlignment(Pos.CENTER);
        addCraftBtn.setBackground(new Background(new BackgroundFill(Color.rgb(255, 170, 213), new CornerRadii(3), null)));
        addCraftBtn.setBorder(new Border(new BorderStroke(Color.rgb(75, 44, 78), BorderStrokeStyle.SOLID, new CornerRadii(1), new BorderWidths(2))));
        addCraftBtn.setOpacity(0.7);
        addCraftBtn.setOnMouseEntered(e -> addCraftBtn.setOpacity(1));
        addCraftBtn.setOnMouseExited(e -> addCraftBtn.setOpacity(0.7));
        addCraftBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameLogic.getInstance().getCurrentPlayer() == 'X') {
                    System.out.println(GameLogic.getInstance().getXplayerItem());
                    BaseItem item = GameLogic.getInstance().getXSelectedItem();
                    if (item != null) {
                        GameLogic.getInstance().getXPlayerPane().getCraftingPane().addIngredients(item);
                        System.out.println(GameLogic.getInstance().getXPlayerPane().getCraftingPane().getIngredients());
                    }

                    System.out.println(GameLogic.getInstance().getXplayerItem());

                } else {
                    System.out.println(GameLogic.getInstance().getOplayerItem());
                    BaseItem item = GameLogic.getInstance().getOSelectedItem();
                    if (item != null) {
                        GameLogic.getInstance().getXPlayerPane().getCraftingPane().addIngredients(item);
                        System.out.println(GameLogic.getInstance().getXPlayerPane().getCraftingPane().getIngredients());
                    }

                    System.out.println(GameLogic.getInstance().getOplayerItem());

                }

                GameUtils.updateInvetoryUI();
            }
        });


        getChildren().add(titleText);
        getChildren().add(oInvetory);
        getChildren().add(useBtn);
        getChildren().add(addCraftBtn);
//        getChildren().add(skipBtn);


        setMargin(useBtn, new Insets(5));
//        setMargin(skipBtn,new Insets(5));
        setMargin(addCraftBtn, new Insets(5));

        //titleText.setOnMouseClicked(e -> System.out.println(GameLogic.getInstance().getCurrentPlayer()));


        char currentPlayer = GameLogic.getInstance().getCurrentPlayer();
        //            String oName = GameLogic.getInstance().getPlayerO().getName();
        oInvetory.getMagicEraserIV().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameLogic.getInstance().getOplayerItem().getOrDefault("Magic Eraser", 0) > 0) {
                    GameLogic.getInstance().setOSelectedItem(new MagicEraser());
                    System.out.println("O selected: " + GameLogic.getInstance().getOSelectedItem());
                    //System.out.println("Current Player: " + GameLogic.getInstance().getCurrentPlayer());
                    if (GameLogic.getInstance().getCurrentPlayer() == 'O') {
                        GameLogic.getInstance().getInfoPane().setInfoText(oName + " selected: " + GameLogic.getInstance().getOSelectedItem().getName());
                    }
                }
            }
        });

        oInvetory.getMagicEraserUpgradedIV().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameLogic.getInstance().getOplayerItem().getOrDefault("Upgraded Magic Eraser", 0) > 0) {
                    MagicEraser magicEraserUp = new MagicEraser();
                    magicEraserUp.upgrade();
                    GameLogic.getInstance().setOSelectedItem(magicEraserUp);
                    System.out.println("O selected: " + GameLogic.getInstance().getOSelectedItem().getName());
                    if (GameLogic.getInstance().getCurrentPlayer() == 'O') {
                        GameLogic.getInstance().getInfoPane().setInfoText(oName + " selected: " + GameLogic.getInstance().getOSelectedItem().getName());
                    }
                }
            }
        });

        oInvetory.getDoubleSpellIV().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameLogic.getInstance().getOplayerItem().getOrDefault("Double Spell", 0) > 0) {
                    GameLogic.getInstance().setOSelectedItem(new DoubleSpell());
                    System.out.println("O selected: " + GameLogic.getInstance().getOSelectedItem());
                    if (GameLogic.getInstance().getCurrentPlayer() == 'O') {
                        GameLogic.getInstance().getInfoPane().setInfoText(oName + " selected: " + GameLogic.getInstance().getOSelectedItem().getName());
                    }
                }
            }
        });

        oInvetory.getTripleSpellIV().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameLogic.getInstance().getOplayerItem().getOrDefault("Triple Spell", 0) > 0) {
                    DoubleSpell tripleSpell = new DoubleSpell();
                    tripleSpell.upgrade();
                    GameLogic.getInstance().setOSelectedItem(tripleSpell);
                    System.out.println("O selected: " + GameLogic.getInstance().getOSelectedItem().getName());
                    if (GameLogic.getInstance().getCurrentPlayer() == 'O') {
                        GameLogic.getInstance().getInfoPane().setInfoText(oName + " selected: " + GameLogic.getInstance().getOSelectedItem().getName());
                    }
                }
            }
        });

        oInvetory.getIceBlocksIV().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameLogic.getInstance().getOplayerItem().getOrDefault("Ice Blocks", 0) > 0) {
                    GameLogic.getInstance().setOSelectedItem(new IceBlocks());
                    System.out.println("O selected: " + GameLogic.getInstance().getOSelectedItem());
                    if (GameLogic.getInstance().getCurrentPlayer() == 'O') {
                        GameLogic.getInstance().getInfoPane().setInfoText(oName + " selected: " + GameLogic.getInstance().getOSelectedItem().getName());
                    }
                }
            }
        });

        oInvetory.getIceBlocksUpgradedIV().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameLogic.getInstance().getOplayerItem().getOrDefault("Packed Ice Blocks", 0) > 0) {
                    IceBlocks packedIceBlocks = new IceBlocks();
                    packedIceBlocks.upgrade();
                    GameLogic.getInstance().setOSelectedItem(packedIceBlocks);
                    System.out.println("O selected: " + GameLogic.getInstance().getOSelectedItem().getName());
                    if (GameLogic.getInstance().getCurrentPlayer() == 'O') {
                        GameLogic.getInstance().getInfoPane().setInfoText(oName + " selected: " + GameLogic.getInstance().getOSelectedItem().getName());
                    }
                }
            }
        });

        oInvetory.getDestroyerRayIV().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameLogic.getInstance().getOplayerItem().getOrDefault("Destroyer Ray", 0) > 0) {
                    GameLogic.getInstance().setOSelectedItem(new DestroyerRay());
                    System.out.println("O selected: " + GameLogic.getInstance().getOSelectedItem());
                    if (GameLogic.getInstance().getCurrentPlayer() == 'O') {
                        GameLogic.getInstance().getInfoPane().setInfoText(oName + " selected: " + GameLogic.getInstance().getOSelectedItem().getName());
                    }
                }
            }
        });

        oInvetory.getTieBreakerIV().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameLogic.getInstance().getOplayerItem().getOrDefault("Tie Breaker", 0) > 0) {
                    GameLogic.getInstance().setOSelectedItem(new TieBreaker());
                    System.out.println(GameLogic.getInstance().getOSelectedItem());
                    if (GameLogic.getInstance().getCurrentPlayer() == 'O') {
                        GameLogic.getInstance().getInfoPane().setInfoText(oName + " selected: " + GameLogic.getInstance().getOSelectedItem().getName());
                    }
                }
            }
        });

        oInvetory.getCraftingCatalystIV().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameLogic.getInstance().getOplayerItem().getOrDefault("Crafting Catalyst", 0) > 0) {
                    GameLogic.getInstance().setOSelectedItem(new CraftingCatalyst());
                    System.out.println(GameLogic.getInstance().getOSelectedItem());
                    if (GameLogic.getInstance().getCurrentPlayer() == 'O') {
                        GameLogic.getInstance().getInfoPane().setInfoText(oName + " selected: " + GameLogic.getInstance().getOSelectedItem().getName());
                    }
                }
            }
        });

        oInvetory.getStuntGrenadeIV().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameLogic.getInstance().getOplayerItem().getOrDefault("Stunt Grenade", 0) > 0) {
                    GameLogic.getInstance().setOSelectedItem(new StuntGrenade());
                    System.out.println(GameLogic.getInstance().getOSelectedItem());
                    if (GameLogic.getInstance().getCurrentPlayer() == 'O') {
                        GameLogic.getInstance().getInfoPane().setInfoText(oName + " selected: " + GameLogic.getInstance().getOSelectedItem().getName());
                    }
                }
            }
        });


    }

    public Text getTitleText() {
        return titleText;
    }

    public InventoryPane getoInvetoryUI() {
        return oInvetory;
    }

    public String getoName() {
        return oName;
    }

    public void setoName(String oName) {
        this.oName = oName;
    }

    public Button getUseBtn() {
        return useBtn;
    }
}
