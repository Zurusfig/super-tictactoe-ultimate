package logic;

import base.BaseItem;
import item.*;

public class UseItemHandler {

    public static void useItem() {
        char turn = GameLogic.getInstance().getCurrentPlayer();
        BaseItem selectedItem;
        String playerName;
        if (turn == 'X') {
            selectedItem = GameLogic.getInstance().getXSelectedItem();
            playerName = GameLogic.getInstance().getPlayerX().getName();

        } else {
            selectedItem = GameLogic.getInstance().getOSelectedItem();
            playerName = GameLogic.getInstance().getPlayerO().getName();
        }
        if (selectedItem != null) {
            if (selectedItem instanceof CraftingCatalyst) {
                GameLogic.getInstance().getXPlayerPane().getCraftingPane().addIngredients(selectedItem);
            } else {
                selectedItem.use();
                GameUtils.removeItemFromInventory(selectedItem);
                GameUtils.updateCertainInventoryUI(turn, selectedItem);
                GameLogic.getInstance().getInfoPane().setInfoText(playerName + " used " + selectedItem.getName());
                GameLogic.getInstance().setRoundItemUsed(true);
            }
        }

    }

}


//        if(turn == 'X'){
//            BaseItem selectedItem = GameLogic.getInstance().getXSelectedItem();
//            if(selectedItem != null){
//                selectedItem.use();
//                GameUtils.removeItemFromInventory(selectedItem);
//                GameUtils.updateCertainInventoryUI('X',selectedItem);
//                GameLogic.getInstance().getInfoPane().setInfoText(GameLogic.getInstance().getPlayerX().getName() + " used "+ selectedItem.getName());
//                GameLogic.getInstance().setRoundItemUsed(true);
//            }
//        }else{
//            BaseItem selectedItem = GameLogic.getInstance().getOSelectedItem();
//            if(selectedItem != null){
//                selectedItem.use();
//                GameUtils.removeItemFromInventory(selectedItem);
//                GameUtils.updateCertainInventoryUI('O',selectedItem);
//                GameLogic.getInstance().getInfoPane().setInfoText(GameLogic.getInstance().getPlayerO().getName() + " used "+ selectedItem.getName());
//                GameLogic.getInstance().setRoundItemUsed(true);
//            }
//        }
//


//        System.out.println(turn);
//        if(turn == 'X'){
//            BaseItem selectedItem = GameLogic.getInstance().getXSelectedItem();
//            System.out.println("Item used: "+selectedItem.getName());
//            System.out.println(selectedItem);
//            if(selectedItem instanceof MagicEraser){
//                MagicEraser item = (MagicEraser) selectedItem;
//                item.use();
//                System.out.println("UpEraPhase:"+ GameLogic.getInstance().isUpgradedErasePhase());
//                GameUtils.removeItemFromInventory(item);
//                GameUtils.updateCertainInventoryUI('X', item);
//
//            } else if (selectedItem instanceof DoubleSpell) {
//                DoubleSpell item = (DoubleSpell) selectedItem;
//                //if(item.getName() == "Triple Spell") item.setUpgraded(true);
//                System.out.println("Item upgraded?: "+item.isUpgraded());
//                item.use();
//                System.out.println("Multiple Turns:" + GameLogic.getInstance().getMultipleTurns());
//                GameUtils.removeItemFromInventory(item);
//                GameUtils.updateCertainInventoryUI('X', item);
//
//
//            } else if (selectedItem instanceof IceBlocks){
//                IceBlocks item = (IceBlocks) selectedItem;
//                item.use();
//                GameUtils.removeItemFromInventory(item);
//                GameUtils.updateCertainInventoryUI('X', item);
//
//
//            } else if (selectedItem instanceof DestroyerRay){
//                DestroyerRay item = (DestroyerRay) selectedItem;
//                item.use();
//                GameUtils.removeItemFromInventory(item);
//                GameUtils.removeInventoryUI('O');
//                GameUtils.updateCertainInventoryUI('X', item);
//                System.out.println("O"+GameLogic.getInstance().getOplayerItem());
//
//
//
//            } else if (selectedItem instanceof TieBreaker){
//                TieBreaker item = (TieBreaker) selectedItem;
//                item.use();
//                GameUtils.removeItemFromInventory(item);
//                GameUtils.updateCertainInventoryUI('X', item);
//
//            } else if (selectedItem instanceof CraftingCatalyst){
//                CraftingCatalyst item = (CraftingCatalyst) selectedItem;
//                GameLogic.getInstance().getXPlayerPane().getCraftingPane().addIngredients(item);
//
//
//
//            } else if (selectedItem instanceof StuntGrenade){
//                StuntGrenade item = (StuntGrenade) selectedItem;
//                item.use();
//                GameUtils.removeItemFromInventory(item);
//                GameUtils.updateCertainInventoryUI('X', item);
//                System.out.println("O cannot use round: " + GameLogic.getInstance().getStuntMove());
//
//
//            }
//            if(selectedItem!= null) {
//                GameLogic.getInstance().getInfoPane().setInfoText(GameLogic.getInstance().getPlayerX().getName() + " used "+ selectedItem.getName());
//                GameLogic.getInstance().setRoundItemUsed(true);
//            }
//        }else if(turn == 'O'){
//            BaseItem selectedItem = GameLogic.getInstance().getOSelectedItem();
//            System.out.println("Item used: "+selectedItem.getName());
//            System.out.println(selectedItem);
//            if(selectedItem instanceof MagicEraser){
//                MagicEraser item = (MagicEraser) selectedItem;
//                item.use();
//                System.out.println("UpEraPhase:"+ GameLogic.getInstance().isUpgradedErasePhase());
//                GameUtils.removeItemFromInventory(item);
//                GameUtils.updateCertainInventoryUI('O', item);
//
//            } else if (selectedItem instanceof DoubleSpell) {
//                DoubleSpell item = (DoubleSpell) selectedItem;
//                //if(item.getName() == "Triple Spell") item.setState(ItemState.UPGRADED);
//                System.out.println("Item upgraded?: "+item.isUpgraded());
//                item.use();
//                System.out.println("Multiple Turns:" + GameLogic.getInstance().getMultipleTurns());
//                GameUtils.removeItemFromInventory(item);
//                GameUtils.updateCertainInventoryUI('O', item);
//
//
//            } else if (selectedItem instanceof IceBlocks){
//                IceBlocks item = (IceBlocks) selectedItem;
//                item.use();
//                GameUtils.removeItemFromInventory(item);
//                GameUtils.updateCertainInventoryUI('O', item);
//
//            } else if (selectedItem instanceof DestroyerRay){
//                System.out.println("Destroyer ray used");
//                DestroyerRay item = (DestroyerRay) selectedItem;
//                item.use();
//                GameUtils.removeItemFromInventory(item);
//                GameUtils.removeInventoryUI('X');
//                GameUtils.updateCertainInventoryUI('O', item);
//                System.out.println("X"+GameLogic.getInstance().getXplayerItem());
//
//
//            } else if (selectedItem instanceof TieBreaker){
//                TieBreaker item = (TieBreaker) selectedItem;
//                item.use();
//                GameUtils.removeItemFromInventory(item);
//                GameUtils.updateCertainInventoryUI('O', item);
//
//
//            } else if (selectedItem instanceof CraftingCatalyst){
//                CraftingCatalyst item = (CraftingCatalyst) selectedItem;
//                GameLogic.getInstance().getXPlayerPane().getCraftingPane().addIngredients(item);
//
//            } else if (selectedItem instanceof StuntGrenade){
//                StuntGrenade item = (StuntGrenade) selectedItem;
//                item.use();
//                GameUtils.removeItemFromInventory(item);
//                GameUtils.updateCertainInventoryUI('O', item);
//                System.out.println("X cannot use round: " + GameLogic.getInstance().getStuntMove());
//
//
//            }
//            if(selectedItem!= null) {
//                GameLogic.getInstance().getInfoPane().setInfoText(GameLogic.getInstance().getPlayerO().getName() + " used "+ selectedItem.getName());
//                GameLogic.getInstance().setRoundItemUsed(true);
//            }
//        }