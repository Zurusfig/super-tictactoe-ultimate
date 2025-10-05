package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import static gui.UIConstants.*;

public class HowToPlayPane extends StackPane {

    private javafx.scene.control.Button menuButton;

    private ScrollPane scrollPane;


    private Text infoText;

    private Text magicEraserText;
    private Text magicEraserUpgradedText;
    private Text doubleSpellText;
    private Text tripleSpellText;
    private Text iceBlocksText;
    private Text iceBlocksUpgradedText;
    private Text destroyerRayText;
    private Text tieBreakerText;
    private Text craftingCatalystText;
    private Text stuntGrenadeText;

    private ImageView magicEraserIV;
    private ImageView magicEraserUpgradedIV;
    private ImageView doubleSpellIV;
    private ImageView tripleSpellIV;
    private ImageView iceBlocksIV;
    private ImageView iceBlocksUpgradedIV;
    private ImageView destroyerRayIV;
    private ImageView tieBreakerIV;
    private ImageView craftingCatalystIV;
    private ImageView stuntGrenadeIV;



    public HowToPlayPane() {
        super();

        setPrefSize(UIConstants.SCENE_WIDTH,UIConstants.SCENE_HEIGHT);
        Image bgImg = new Image(BG_URL);
        setBackground(new Background(new BackgroundImage(bgImg,null,null,null, null)));

        Font font1 = Font.loadFont(getClass().getResourceAsStream("/res/fonts/pixel2.ttf"), 23.5);
        Font font2 = Font.loadFont(getClass().getResourceAsStream("/res/fonts/pixel2.ttf"), 60);
        Font font3 = Font.loadFont(getClass().getResourceAsStream("/res/fonts/pixel2.ttf"), 23);

        menuButton = new Button("Home");
        menuButton.setFont(font1);
        menuButton.setTextFill(Color.rgb(75,44,78));
        menuButton.setAlignment(Pos.BASELINE_CENTER);
        menuButton.setBackground(new Background(new BackgroundFill(Color.rgb(255,170,213),new CornerRadii(6),null)));
        menuButton.setMinSize(75,50);
        menuButton.setBorder(new Border(new BorderStroke(Color.rgb(75,44,78),BorderStrokeStyle.SOLID,new CornerRadii(3),new BorderWidths(5))));
        menuButton.setOpacity(0.5);
        setAlignment(menuButton,Pos.TOP_RIGHT);
        setMargin(menuButton, new Insets(40,40,40,40));


        Text titleText = new Text("How To Play");

        titleText.setFont(font2);
        titleText.setFill(Color.rgb(255,170,213));
        titleText.setStroke(Color.rgb(75,44,78));
        titleText.setStrokeWidth(2);

        titleText.setTextAlignment(TextAlignment.CENTER);
        setAlignment(titleText, Pos.TOP_CENTER);
        setMargin(titleText, new Insets(20));


        infoText = new Text();

        infoText.setText("GamePlay\n" + "\n1.Players can choose any cells in the table in\nthe first round.\n" +
                "\n2.In the second round, let’s say player1 chooses\nthe top-left LOCAL cell in the middle of GLOBAL\ncell.Player2 must play in the top-left GLOBAL\ncell of the table, choose any local cells\nin that global cell.\n" +
                "\n3.This repeats until one gets Tic-Tac-Toe in any\nGLOBAL cell and that GLOBAL cell belongs to that\nplayer.\n" +
                "\n4.Repeat until the table is full or the player \nwho got Tic-Tac-Toe in the table wins.\n" +
                "\n5.If the player has to play in the cell that is\nalready full,the player can choose any cell in\nthe table.\n" +
                "\n6.There are special items in some local cells.\n" +
                "\n7.Some items can be upgraded, player can upgrade\nthose items via crafting menu by using 2 of those\nitems or use that item combined with Crafting\nCatalyst." +
                "\n\nItem\n");

        magicEraserText = new Text();
        magicEraserText.setText("\n1.Magic Eraser\n Magic Eraser is upgradeable.When players use this\nitem,they can remove item in any LOCAL cell\n");

        magicEraserUpgradedText = new Text();
        magicEraserUpgradedText.setText("\n2.Upgraded Magic Eraser\n This is the upgrade version of Magic Eraser.\nPlayer can choose any GLOBAL cell to remove item \nin it\n");

        doubleSpellText = new Text();
        doubleSpellText.setText("\n3.Double Spell\n Double spell is upgradeable.When players use this \nitem,they get to play for 2 rounds\n");

        tripleSpellText = new Text();
        tripleSpellText.setText("\n4.Triple Spell\n This is the upgrade version of Double Spell.\nWhen uses,player get to play for 3 rounds\n");

        iceBlocksText = new Text();
        iceBlocksText.setText("\n5.Ice Blocks\n Ice Blocks is upgradeable.When players use this\nitem,they can place 4 ice block anywhere in the\ntable.Both players can not play in those cell for\n3 rounds\n");

        iceBlocksUpgradedText = new Text();
        iceBlocksUpgradedText.setText("\n6.Packed Ice Blocks\n This is the upgrade version of Ice Blocks.\nSkill of the item is the same but it will last for\n5 rounds instead\n");

        destroyerRayText = new Text();
        destroyerRayText.setText("\n7.Destroyer Ray\n Destroyer Ray is NOT upgradeable.When players\nuse this item,all of the opponent's item will be\ndeleted\n");

        tieBreakerText = new Text();
        tieBreakerText.setText("\n8.Tie Breaker\n Tie Breaker is NOT upgradeable.When players use\nthis item,they can choose any tie GLOBAL cell and\nbreak that cell\n");

        craftingCatalystText = new Text();
        craftingCatalystText.setText("\n9.Crafting Catalyst\n Crafting Catalyst is NOT upgradeable.This\nitem can be used to upgrade other upgradeable item\n");

        stuntGrenadeText = new Text();
        stuntGrenadeText.setText("\n10.Stunt Grenade\n Stunt Grenade is NOT upgradeable.When players\nuse this item,the opponent can not use their item\nin the next round");

        infoText.setFont(font1);
        magicEraserText.setFont(font3);
        magicEraserUpgradedText.setFont(font3);
        doubleSpellText.setFont(font3);
        tripleSpellText.setFont(font3);
        iceBlocksText.setFont(font3);
        iceBlocksUpgradedText.setFont(font3);
        destroyerRayText.setFont(font3);
        tieBreakerText.setFont(font3);
        craftingCatalystText.setFont(font3);
        stuntGrenadeText.setFont(font3);

        infoText.setTextAlignment(TextAlignment.LEFT);
        magicEraserText.setTextAlignment(TextAlignment.LEFT);
        magicEraserUpgradedText.setTextAlignment(TextAlignment.LEFT);
        doubleSpellText.setTextAlignment(TextAlignment.LEFT);
        tripleSpellText.setTextAlignment(TextAlignment.LEFT);
        iceBlocksText.setTextAlignment(TextAlignment.LEFT);
        iceBlocksUpgradedText.setTextAlignment(TextAlignment.LEFT);
        destroyerRayText.setTextAlignment(TextAlignment.LEFT);
        tieBreakerText.setTextAlignment(TextAlignment.LEFT);
        craftingCatalystText.setTextAlignment(TextAlignment.LEFT);
        stuntGrenadeText.setTextAlignment(TextAlignment.LEFT);


        Image magicEraserImg = new Image(MAGIC_ERASER_URL);
        magicEraserIV = new ImageView(magicEraserImg);
        magicEraserIV.setPreserveRatio(true);
        magicEraserIV.setFitHeight(GRAPHIC_SIZE);

        Image magicEraserUpgradedImg = new Image(UPGRADED_MAGIC_ERASER_URL);
        magicEraserUpgradedIV = new ImageView(magicEraserUpgradedImg);
        magicEraserUpgradedIV.setPreserveRatio(true);
        magicEraserUpgradedIV.setFitHeight(GRAPHIC_SIZE);

        Image doubleSpellImg = new Image(DOUBLE_SPELL_URL);
        doubleSpellIV = new ImageView(doubleSpellImg);
        doubleSpellIV.setPreserveRatio(true);
        doubleSpellIV.setFitHeight(GRAPHIC_SIZE);

        Image tripleSpellImg = new Image(TRIPLE_SPELL_URL);
        tripleSpellIV = new ImageView(tripleSpellImg);
        tripleSpellIV.setPreserveRatio(true);
        tripleSpellIV.setFitHeight(GRAPHIC_SIZE);

        Image iceBlocksImg =  new Image(ICEBLOCKS_URL);
        iceBlocksIV = new ImageView(iceBlocksImg);
        iceBlocksIV.setPreserveRatio(true);
        iceBlocksIV.setFitHeight(GRAPHIC_SIZE);

        Image iceBlocksUpgradedImg = new Image(PACKED_ICEBLOCKS_URL);
        iceBlocksUpgradedIV = new ImageView(iceBlocksUpgradedImg);
        iceBlocksUpgradedIV.setPreserveRatio(true);
        iceBlocksUpgradedIV.setFitHeight(GRAPHIC_SIZE);

        Image destroyerRayImg = new Image(DESTROYER_RAY_URL);
        destroyerRayIV = new ImageView(destroyerRayImg);
        destroyerRayIV.setPreserveRatio(true);
        destroyerRayIV.setFitHeight(GRAPHIC_SIZE);

        Image tieBreakerImg = new Image(TIE_BREAKER_URL);
        tieBreakerIV = new ImageView(tieBreakerImg);
        tieBreakerIV.setPreserveRatio(true);
        tieBreakerIV.setFitHeight(GRAPHIC_SIZE);

        Image craftingCatalystImg = new Image(CRAFTING_CATALYST_URL);
        craftingCatalystIV = new ImageView(craftingCatalystImg);
        craftingCatalystIV.setPreserveRatio(true);
        craftingCatalystIV.setFitHeight(GRAPHIC_SIZE);

        Image stuntGrenadeImg = new Image(STUNT_GRENADE_URL);
        stuntGrenadeIV = new ImageView(stuntGrenadeImg);
        stuntGrenadeIV.setPreserveRatio(true);
        stuntGrenadeIV.setFitHeight(GRAPHIC_SIZE);

        VBox infoBox = new VBox();
        infoBox.getChildren().addAll(infoText, magicEraserIV, magicEraserText, magicEraserUpgradedIV, magicEraserUpgradedText
                                    , doubleSpellIV, doubleSpellText, tripleSpellIV, tripleSpellText, iceBlocksIV, iceBlocksText
                                    , iceBlocksUpgradedIV, iceBlocksUpgradedText, destroyerRayIV, destroyerRayText
                                    , tieBreakerIV, tieBreakerText, craftingCatalystIV, craftingCatalystText, stuntGrenadeIV
                                    ,stuntGrenadeText);

        scrollPane = new ScrollPane(infoBox);
        scrollPane.setMaxSize(700,600);
        scrollPane.setBackground(new Background(new BackgroundFill(Color.rgb(255,170,213),new CornerRadii(6),null)));
        scrollPane.setPannable(false);

        setAlignment(scrollPane,Pos.BOTTOM_CENTER);
        setMargin(scrollPane, new Insets(5,5,20,5));

        getChildren().add(menuButton);
        getChildren().add(titleText);
        getChildren().add(scrollPane);


    }

    public Button getMenuButton() {
        return menuButton;
    }
}
