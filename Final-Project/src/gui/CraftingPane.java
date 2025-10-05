package gui;

import Interface.Upgradeable;
import base.BaseItem;
import item.CraftingCatalyst;
import item.DoubleSpell;
import item.IceBlocks;
import item.MagicEraser;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.GameLogic;
import logic.GameUtils;

import java.util.ArrayList;


public class CraftingPane extends VBox {

    private ItemBox item1Box;
    private ItemBox item2Box;
    private ItemBox resultBox;

    private Button craftBtn;

    private Button clearBtn;

    private ArrayList<BaseItem> ingredients = new ArrayList<>();

    public CraftingPane() {
        super();

        Insets insets = new Insets(5);
        Insets insets2 = new Insets(3);

        setPrefSize(250, 100);
        setBackground(new Background(new BackgroundFill(Color.rgb(239, 203, 227), new CornerRadii(4), null)));
        setSpacing(5);


        Text title = new Text("Craft");
        Font font1 = Font.loadFont(getClass().getResourceAsStream("/res/fonts/pixel2.ttf"), 18);
        title.setFill(Color.rgb(75, 44, 78));
        title.setFont(font1);
        setAlignment(Pos.CENTER);


        HBox centerBox = new HBox();
        centerBox.setAlignment(Pos.CENTER);
        centerBox.setSpacing(3);

        item1Box = new ItemBox();


        item2Box = new ItemBox();
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(new Double[]{
                30.0, 0.0,
                30.0, 20.0,
                40.0, 10.0});
        polygon.setFill(Color.rgb(188, 152, 191));

        resultBox = new ItemBox();

        centerBox.getChildren().add(item1Box);
        centerBox.getChildren().add(item2Box);
        centerBox.getChildren().add(polygon);
        centerBox.getChildren().add(resultBox);

        craftBtn = new Button("Craft");
        craftBtn.setTextFill(Color.rgb(75, 44, 78));
        craftBtn.setFont(font1);
        craftBtn.setAlignment(Pos.BASELINE_CENTER);
        craftBtn.setBackground(new Background(new BackgroundFill(Color.rgb(255, 170, 213), new CornerRadii(3), null)));
        //craftBtn.setMinSize(100,50);
        craftBtn.setBorder(new Border(new BorderStroke(Color.rgb(75, 44, 78), BorderStrokeStyle.SOLID, new CornerRadii(1), new BorderWidths(2))));
        craftBtn.setOpacity(0.7);
        craftBtn.setOnMouseEntered(e -> craftBtn.setOpacity(1));
        craftBtn.setOnMouseExited(e -> craftBtn.setOpacity(0.7));
        craftBtn.setOnMouseClicked(e -> onCraftHandler());

        clearBtn = new Button("Clear");
        clearBtn.setTextFill(Color.rgb(75, 44, 78));
        clearBtn.setFont(font1);
        clearBtn.setAlignment(Pos.BASELINE_CENTER);
        clearBtn.setBackground(new Background(new BackgroundFill(Color.rgb(255, 170, 213), new CornerRadii(3), null)));
        //craftBtn.setMinSize(100,50);
        clearBtn.setBorder(new Border(new BorderStroke(Color.rgb(75, 44, 78), BorderStrokeStyle.SOLID, new CornerRadii(1), new BorderWidths(2))));
        clearBtn.setOpacity(0.7);
        clearBtn.setOnMouseEntered(e -> clearBtn.setOpacity(1));
        clearBtn.setOnMouseExited(e -> clearBtn.setOpacity(0.7));
        clearBtn.setOnMouseClicked(e -> onClearClicked());

        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(5);
        buttonBox.getChildren().add(clearBtn);
        buttonBox.getChildren().add(craftBtn);


        getChildren().add(title);
        getChildren().add(centerBox);
        getChildren().add(buttonBox);


        setMargin(title, insets);
        setMargin(buttonBox, insets);


    }

    public void addIngredients(BaseItem item) {
        if (getIngredients().isEmpty() && GameUtils.canRemove(item)) {
            getIngredients().add(item);
            GameUtils.removeItemFromInventory(item);
            item1Box.appear(item);
        } else if (getIngredients().size() == 1 && GameUtils.canRemove(item)) {
            getIngredients().add(item);
            GameUtils.removeItemFromInventory(item);
            item2Box.appear(item);
            try {
                updateResultUI();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void onClearClicked() {
        for (BaseItem item : getIngredients()) {
            GameUtils.undoTake(item);
        }
        clearItemBox();
        GameUtils.updateInvetoryUI();
    }

    public void updateResultUI() throws CloneNotSupportedException {
        BaseItem item1 = getIngredients().get(0);
        BaseItem item2 = getIngredients().get(1);
        if (GameUtils.isCraftable(item1, item2)) {
            if (item2 instanceof CraftingCatalyst || item1.getClass() == item2.getClass()) {
                if (item1 instanceof MagicEraser) {
                    BaseItem itemClone = (BaseItem) item1.clone();
                    MagicEraser item = (MagicEraser) itemClone;
                    item.upgrade();
                    resultBox.getMagicEraserUpgradedIV().setOpacity(1);
                } else if (item1 instanceof DoubleSpell) {
                    BaseItem itemClone = (BaseItem) item1.clone();
                    DoubleSpell item = (DoubleSpell) itemClone;
                    item.upgrade();
                    resultBox.getTripleSpellIV().setOpacity(1);
                } else if (item1 instanceof IceBlocks) {
                    BaseItem itemClone = (BaseItem) item1.clone();
                    IceBlocks item = (IceBlocks) itemClone;
                    item.upgrade();
                    resultBox.getIceBlocksUpgradedIV().setOpacity(1);
                }
            } else if (item1 instanceof CraftingCatalyst) {
                if (item2 instanceof MagicEraser) {
                    BaseItem itemClone = (BaseItem) item2.clone();
                    MagicEraser item = (MagicEraser) itemClone;
                    item.upgrade();
                    resultBox.getMagicEraserUpgradedIV().setOpacity(1);
                } else if (item2 instanceof DoubleSpell) {
                    BaseItem itemClone = (BaseItem) item2.clone();
                    DoubleSpell item = (DoubleSpell) itemClone;
                    item.upgrade();
                    resultBox.getTripleSpellIV().setOpacity(1);
                } else if (item2 instanceof IceBlocks) {
                    BaseItem itemClone = (BaseItem) item2.clone();
                    IceBlocks item = (IceBlocks) itemClone;
                    item.upgrade();
                    resultBox.getIceBlocksUpgradedIV().setOpacity(1);
                }
            }

        }
    }

    public void onCraftHandler() {
        if (getIngredients().size() == 2) {
            BaseItem item1 = getIngredients().get(0);
            BaseItem item2 = getIngredients().get(1);
            BaseItem useItem;

            String name;

            if (GameLogic.getInstance().getCurrentPlayer() == 'X') {
                name = GameLogic.getInstance().getPlayerX().getName();
            } else {
                name = GameLogic.getInstance().getPlayerO().getName();
            }

            if (GameUtils.isCraftable(item1, item2)) {
                if (item1 instanceof CraftingCatalyst) {
                    useItem = item2;
                } else {
                    useItem = item1;
                }

                initiateCrafting(useItem, name);
                clearItemBox();


            }
            GameUtils.updateInvetoryUI();
        }

    }

    public void clearItemBox() {
        item1Box.disappear();
        item2Box.disappear();
        resultBox.disappear();
        getIngredients().clear();
    }

    public void initiateCrafting(BaseItem item, String playerName) {
        if (item instanceof MagicEraser magicEraser) {
            magicEraser.upgrade();
            GameUtils.addCraftedItem(magicEraser);
        } else if (item instanceof DoubleSpell doubleSpell) {
            doubleSpell.upgrade();
            GameUtils.addCraftedItem(doubleSpell);
        } else if (item instanceof IceBlocks iceBlocks) {
            iceBlocks.upgrade();
            GameUtils.addCraftedItem(iceBlocks);
        }
        GameLogic.getInstance().getInfoPane().setInfoText(playerName + " crafted " + item.getName());
    }


    public ArrayList<BaseItem> getIngredients() {
        return ingredients;
    }


}
