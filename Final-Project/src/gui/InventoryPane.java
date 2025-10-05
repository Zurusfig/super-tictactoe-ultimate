package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import static gui.UIConstants.*;


public class InventoryPane extends GridPane {

    private int magicEraserCount = 0;
    private int magicEraserUpgradedCount = 0;
    private int doubleSpellCount = 0;
    private int tripleSpellCount = 0;
    private int iceBlocksCount = 0;
    private int iceBlocksUpgradedCount = 0;
    private int destroyerRayCount = 0;
    private int tieBreakerCount = 0;
    private int craftingCatalystCount = 0;
    private int stuntGrenadeCount = 0;
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


    public InventoryPane() {
        super();

        setPadding(new Insets(5));
        setAlignment(Pos.CENTER);


        Image magicEraserImg = new Image(MAGIC_ERASER_URL);
        magicEraserIV = new ImageView(magicEraserImg);
        magicEraserText = new Text(String.valueOf(magicEraserCount));
        initializeIcon(magicEraserIV, magicEraserText);


        Image magicEraserUpgradedImg = new Image(UPGRADED_MAGIC_ERASER_URL);
        magicEraserUpgradedIV = new ImageView(magicEraserUpgradedImg);
        magicEraserUpgradedText = new Text(String.valueOf(magicEraserUpgradedCount));
        initializeIcon(magicEraserUpgradedIV, magicEraserUpgradedText);


        Image doubleSpellImg = new Image(DOUBLE_SPELL_URL);
        doubleSpellIV = new ImageView(doubleSpellImg);
        doubleSpellText = new Text(String.valueOf(doubleSpellCount));
        initializeIcon(doubleSpellIV, doubleSpellText);


        Image tripleSpellImg = new Image(TRIPLE_SPELL_URL);
        tripleSpellIV = new ImageView(tripleSpellImg);
        tripleSpellText = new Text(String.valueOf(tripleSpellCount));
        initializeIcon(tripleSpellIV, tripleSpellText);


        Image iceBlocksImg = new Image(ICEBLOCKS_URL);
        iceBlocksIV = new ImageView(iceBlocksImg);
        iceBlocksText = new Text(String.valueOf(iceBlocksCount));
        initializeIcon(iceBlocksIV, iceBlocksText);


        Image iceBlocksUpgradedImg = new Image(PACKED_ICEBLOCKS_URL);
        iceBlocksUpgradedIV = new ImageView(iceBlocksUpgradedImg);
        iceBlocksUpgradedText = new Text(String.valueOf(iceBlocksUpgradedCount));
        initializeIcon(iceBlocksUpgradedIV, iceBlocksUpgradedText);


        Image destroyerRayImg = new Image(DESTROYER_RAY_URL);
        destroyerRayIV = new ImageView(destroyerRayImg);
        destroyerRayText = new Text(String.valueOf(destroyerRayCount));
        initializeIcon(destroyerRayIV, destroyerRayText);


        Image tieBreakerImg = new Image(TIE_BREAKER_URL);
        tieBreakerIV = new ImageView(tieBreakerImg);
        tieBreakerText = new Text(String.valueOf(tieBreakerCount));
        initializeIcon(tieBreakerIV, tieBreakerText);


        Image craftingCatalystImg = new Image(CRAFTING_CATALYST_URL);
        craftingCatalystIV = new ImageView(craftingCatalystImg);
        craftingCatalystText = new Text(String.valueOf(craftingCatalystCount));
        initializeIcon(craftingCatalystIV, craftingCatalystText);

        Image stuntGrenadeImg = new Image(STUNT_GRENADE_URL);
        stuntGrenadeIV = new ImageView(stuntGrenadeImg);
        stuntGrenadeText = new Text(String.valueOf(stuntGrenadeCount));
        initializeIcon(stuntGrenadeIV, stuntGrenadeText);


        add(magicEraserIV, 0, 0);
        add(magicEraserText, 1, 0);
        add(magicEraserUpgradedIV, 2, 0);
        add(magicEraserUpgradedText, 3, 0);


        add(doubleSpellIV, 0, 1);
        add(doubleSpellText, 1, 1);
        add(tripleSpellIV, 2, 1);
        add(tripleSpellText, 3, 1);


        add(iceBlocksIV, 0, 2);
        add(iceBlocksText, 1, 2);
        add(iceBlocksUpgradedIV, 2, 2);
        add(iceBlocksUpgradedText, 3, 2);


        add(destroyerRayIV, 0, 3);
        add(destroyerRayText, 1, 3);
        add(tieBreakerIV, 2, 3);
        add(tieBreakerText, 3, 3);


        add(craftingCatalystIV, 0, 4);
        add(craftingCatalystText, 1, 4);
        add(stuntGrenadeIV, 2, 4);
        add(stuntGrenadeText, 3, 4);
        ;


    }

    private void initializeIcon(ImageView imgView, Text imgText) {
        Insets insets = new Insets(5);
        Insets insets2 = new Insets(5, 10, 5, 5);
        Font font = Font.loadFont(getClass().getResourceAsStream("/res/fonts/pixel2.ttf"), 25);

        imgView.setPreserveRatio(true);
        imgView.setFitHeight(GRAPHIC_SIZE);

        imgText.setFont(font);
        imgText.setFill(Color.rgb(239, 203, 227));
        imgView.setOnMouseEntered(e -> imgView.setOpacity(0.8));
        imgView.setOnMouseExited(e -> imgView.setOpacity(1));
        setMargin(imgView, insets);
        setMargin(imgText, insets2);
    }


    public Text getMagicEraserText() {
        return magicEraserText;
    }

    public void setMagicEraserText(Text magicEraserText) {
        this.magicEraserText = magicEraserText;
    }

    public Text getMagicEraserUpgradedText() {
        return magicEraserUpgradedText;
    }

    public void setMagicEraserUpgradedText(Text magicEraserUpgradedText) {
        this.magicEraserUpgradedText = magicEraserUpgradedText;
    }

    public Text getDoubleSpellText() {
        return doubleSpellText;
    }

    public void setDoubleSpellText(Text doubleSpellText) {
        this.doubleSpellText = doubleSpellText;
    }

    public Text getTripleSpellText() {
        return tripleSpellText;
    }

    public void setTripleSpellText(Text tripleSpellText) {
        this.tripleSpellText = tripleSpellText;
    }

    public Text getIceBlocksText() {
        return iceBlocksText;
    }

    public void setIceBlocksText(Text iceBlocksText) {
        this.iceBlocksText = iceBlocksText;
    }

    public Text getIceBlocksUpgradedText() {
        return iceBlocksUpgradedText;
    }

    public void setIceBlocksUpgradedText(Text iceBlocksUpgradedText) {
        this.iceBlocksUpgradedText = iceBlocksUpgradedText;
    }

    public Text getDestroyerRayText() {
        return destroyerRayText;
    }

    public void setDestroyerRayText(Text destroyerRayText) {
        this.destroyerRayText = destroyerRayText;
    }

    public Text getTieBreakerText() {
        return tieBreakerText;
    }

    public void setTieBreakerText(Text tieBreakerText) {
        this.tieBreakerText = tieBreakerText;
    }

    public Text getCraftingCatalystText() {
        return craftingCatalystText;
    }

    public void setCraftingCatalystText(Text craftingCatalystText) {
        this.craftingCatalystText = craftingCatalystText;
    }

    public Text getStuntGrenadeText() {
        return stuntGrenadeText;
    }

    public void setStuntGrenadeText(Text stuntGrenadeText) {
        this.stuntGrenadeText = stuntGrenadeText;
    }

    public ImageView getMagicEraserIV() {
        return magicEraserIV;
    }

    public ImageView getMagicEraserUpgradedIV() {
        return magicEraserUpgradedIV;
    }

    public ImageView getDoubleSpellIV() {
        return doubleSpellIV;
    }

    public ImageView getTripleSpellIV() {
        return tripleSpellIV;
    }

    public ImageView getIceBlocksIV() {
        return iceBlocksIV;
    }

    public ImageView getIceBlocksUpgradedIV() {
        return iceBlocksUpgradedIV;
    }

    public ImageView getDestroyerRayIV() {
        return destroyerRayIV;
    }

    public ImageView getTieBreakerIV() {
        return tieBreakerIV;
    }

    public ImageView getCraftingCatalystIV() {
        return craftingCatalystIV;
    }

    public ImageView getStuntGrenadeIV() {
        return stuntGrenadeIV;
    }
}


