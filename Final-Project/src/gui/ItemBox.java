package gui;

import base.BaseItem;
import item.*;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import static gui.UIConstants.*;

public class ItemBox extends StackPane {

    private final int GRAPHIC_SIZE = 50;


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


    public ItemBox() {
        super();
        setBackground(new Background(new BackgroundFill(Color.rgb(188,152,191), new CornerRadii(2),null)));
        setPrefSize(50,50);
        setAlignment(Pos.CENTER);


        Image magicEraserImg = new Image(MAGIC_ERASER_URL);
        magicEraserIV = new ImageView(magicEraserImg);
        setUpIcon(magicEraserIV);


        Image magicEraserUpgradedImg = new Image(UPGRADED_MAGIC_ERASER_URL);
        magicEraserUpgradedIV = new ImageView(magicEraserUpgradedImg);
        setUpIcon(magicEraserUpgradedIV);


        Image doubleSpellImg = new Image(DOUBLE_SPELL_URL);
        doubleSpellIV = new ImageView(doubleSpellImg);
        setUpIcon(doubleSpellIV);


        Image tripleSpellImg = new Image(TRIPLE_SPELL_URL);
        tripleSpellIV = new ImageView(tripleSpellImg);
        setUpIcon(tripleSpellIV);


        Image iceBlocksImg =  new Image(ICEBLOCKS_URL);
        iceBlocksIV = new ImageView(iceBlocksImg);
        setUpIcon(iceBlocksIV);


        Image iceBlocksUpgradedImg = new Image(PACKED_ICEBLOCKS_URL);
        iceBlocksUpgradedIV = new ImageView(iceBlocksUpgradedImg);
        setUpIcon(iceBlocksUpgradedIV);


        Image destroyerRayImg = new Image(DESTROYER_RAY_URL);
        destroyerRayIV = new ImageView(destroyerRayImg);
        setUpIcon(destroyerRayIV);


        Image tieBreakerImg = new Image(TIE_BREAKER_URL);
        tieBreakerIV = new ImageView(tieBreakerImg);
        setUpIcon(tieBreakerIV);


        Image craftingCatalystImg = new Image(CRAFTING_CATALYST_URL);
        craftingCatalystIV = new ImageView(craftingCatalystImg);
        setUpIcon(craftingCatalystIV);

        Image stuntGrenadeImg = new Image(STUNT_GRENADE_URL);
        stuntGrenadeIV = new ImageView(stuntGrenadeImg);
        setUpIcon(stuntGrenadeIV);


        getChildren().addAll(magicEraserIV,magicEraserUpgradedIV,doubleSpellIV,tripleSpellIV,
                iceBlocksIV,iceBlocksUpgradedIV,destroyerRayIV,tieBreakerIV,craftingCatalystIV,stuntGrenadeIV);


    }

    public void setUpIcon(ImageView imgView){
        imgView.setPreserveRatio(true);
        imgView.setFitHeight(GRAPHIC_SIZE);
        imgView.setOpacity(0);
    }


    public void appear(BaseItem item){
        if(item instanceof MagicEraser){
            if(((MagicEraser) item).isUpgraded() == true){
                getMagicEraserUpgradedIV().setOpacity(1);
            }else{
                getMagicEraserIV().setOpacity(1);
            }
//        }else if(item instanceof UpgradedMagicEraser){
//            getMagicEraserUpgradedIV().setOpacity(1);
        }else if(item instanceof DoubleSpell){
            if(((DoubleSpell) item).isUpgraded() == true){
                getTripleSpellIV().setOpacity(1);
            }else {
                getDoubleSpellIV().setOpacity(1);
            }
//        }else if(item instanceof TripleSpell){
//            getTripleSpellIV().setOpacity(1);
        }else if(item instanceof IceBlocks){
            if(((IceBlocks) item).isUpgraded() == true){
                getIceBlocksUpgradedIV().setOpacity(1);
            }else {
                getIceBlocksIV().setOpacity(1);
            }
//        }else if(item instanceof PackedIceBlocks){
//            getIceBlocksUpgradedIV().setOpacity(1);
        }else if(item instanceof DestroyerRay){
            getDestroyerRayIV().setOpacity(1);
        }else if(item instanceof TieBreaker){
            getTieBreakerIV().setOpacity(1);
        }else if(item instanceof CraftingCatalyst){
            getCraftingCatalystIV().setOpacity(1);
        }else if(item instanceof StuntGrenade){
            getStuntGrenadeIV().setOpacity(1);
        }
    }

    public void disappear(){
        getMagicEraserIV().setOpacity(0);
        getMagicEraserUpgradedIV().setOpacity(0);
        getDoubleSpellIV().setOpacity(0);
        getTripleSpellIV().setOpacity(0);
        getIceBlocksIV().setOpacity(0);
        getIceBlocksUpgradedIV().setOpacity(0);
        getDestroyerRayIV().setOpacity(0);
        getTieBreakerIV().setOpacity(0);
        getCraftingCatalystIV().setOpacity(0);
        getStuntGrenadeIV().setOpacity(0);
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
