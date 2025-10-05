package logic;

import Interface.Upgradeable;
import gui.CraftingPane;
import gui.InventoryPane;

import java.util.ArrayList;
import java.util.HashMap;

import base.BaseItem;
import gui.TicTacToeCell;
import gui.TicTacToePane;
import item.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.Objects;
import java.util.Random;

public class GameUtils extends Thread {
    public static int paneIndexConverter(int boardX, int boardY) {
        int paneIndex = 0;
        if (boardX == 0) {
            if (boardY == 0) {
                paneIndex = 0;
            } else if (boardY == 1) {
                paneIndex = 1;
            } else if (boardY == 2) {
                paneIndex = 2;
            }
        } else if (boardX == 1) {
            if (boardY == 0) {
                paneIndex = 3;
            } else if (boardY == 1) {
                paneIndex = 4;
            } else if (boardY == 2) {
                paneIndex = 5;
            }
        } else if (boardX == 2) {
            if (boardY == 0) {
                paneIndex = 6;
            } else if (boardY == 1) {
                paneIndex = 7;
            } else if (boardY == 2) {
                paneIndex = 8;
            }
        }
        return paneIndex;
    }

    public static int[] reversePaneIndexConverter(int i) {
        int[] array = new int[2];
        if (i == 0) {
            array[0] = 0;
            array[1] = 0;
        } else if (i == 1) {
            array[0] = 0;
            array[1] = 1;
        } else if (i == 2) {
            array[0] = 0;
            array[1] = 2;
        } else if (i == 3) {
            array[0] = 1;
            array[1] = 0;
        } else if (i == 4) {
            array[0] = 1;
            array[1] = 1;
        } else if (i == 5) {
            array[0] = 1;
            array[1] = 2;
        } else if (i == 6) {
            array[0] = 2;
            array[1] = 0;
        } else if (i == 7) {
            array[0] = 2;
            array[1] = 1;
        } else if (i == 8) {
            array[0] = 2;
            array[1] = 2;
        }
        return array;
    }

    public static void fillLootTable(int[][][][] lootTable) {
        //item 1: Magic eraser [5]
        //item 2: Double spell [4]
        //item 3: Ice blocks [4]
        //item 4: Destroyer ray [2]
        //item 5: Tie breaker [3]
        //item 6: Crafting catalyst [4]
        //item 7: Stunt grenade [4]

        Random rand = new Random();

//        int[][][][] lootTable = GameLogic.getInstance().getLootTable();


        //place magic eraser in lootTable
        for (int t = 0; t < 5; t++) {
            boolean placed = false;
            while (!placed) {
                int rand_x = rand.nextInt(3);
                int rand_y = rand.nextInt(3);
                int rand_i = rand.nextInt(3);
                int rand_j = rand.nextInt(3);

                if (lootTable[rand_x][rand_y][rand_i][rand_j] == 0) {
                    lootTable[rand_x][rand_y][rand_i][rand_j] = 1;
                    placed = true;
                }
            }
        }

        //place double spell in loot table
        for (int t = 0; t < 4; t++) {
            boolean placed = false;
            while (!placed) {
                int rand_x = rand.nextInt(3);
                int rand_y = rand.nextInt(3);
                int rand_i = rand.nextInt(3);
                int rand_j = rand.nextInt(3);

                if (lootTable[rand_x][rand_y][rand_i][rand_j] == 0) {
                    lootTable[rand_x][rand_y][rand_i][rand_j] = 2;
                    placed = true;
                }
            }
        }

        //place ice blocks in loot table
        for (int t = 0; t < 4; t++) {
            boolean placed = false;
            while (!placed) {
                int rand_x = rand.nextInt(3);
                int rand_y = rand.nextInt(3);
                int rand_i = rand.nextInt(3);
                int rand_j = rand.nextInt(3);

                if (lootTable[rand_x][rand_y][rand_i][rand_j] == 0) {
                    lootTable[rand_x][rand_y][rand_i][rand_j] = 3;
                    placed = true;
                }
            }
        }

        //place destroyer ray
        for (int t = 0; t < 2; t++) {
            boolean placed = false;
            while (!placed) {
                int rand_x = rand.nextInt(3);
                int rand_y = rand.nextInt(3);
                int rand_i = rand.nextInt(3);
                int rand_j = rand.nextInt(3);

                if (lootTable[rand_x][rand_y][rand_i][rand_j] == 0) {
                    lootTable[rand_x][rand_y][rand_i][rand_j] = 4;
                    placed = true;
                }
            }
        }

        //place tie breaker
        for (int t = 0; t < 3; t++) {
            boolean placed = false;
            while (!placed) {
                int rand_x = rand.nextInt(3);
                int rand_y = rand.nextInt(3);
                int rand_i = rand.nextInt(3);
                int rand_j = rand.nextInt(3);

                if (lootTable[rand_x][rand_y][rand_i][rand_j] == 0) {
                    lootTable[rand_x][rand_y][rand_i][rand_j] = 5;
                    placed = true;
                }
            }
        }

        //place crafting catalyst
        for (int t = 0; t < 4; t++) {
            boolean placed = false;
            while (!placed) {
                int rand_x = rand.nextInt(3);
                int rand_y = rand.nextInt(3);
                int rand_i = rand.nextInt(3);
                int rand_j = rand.nextInt(3);

                if (lootTable[rand_x][rand_y][rand_i][rand_j] == 0) {
                    lootTable[rand_x][rand_y][rand_i][rand_j] = 6;
                    placed = true;
                }
            }
        }

        //stunt granade
        for (int t = 0; t < 4; t++) {
            boolean placed = false;
            while (!placed) {
                int rand_x = rand.nextInt(3);
                int rand_y = rand.nextInt(3);
                int rand_i = rand.nextInt(3);
                int rand_j = rand.nextInt(3);

                if (lootTable[rand_x][rand_y][rand_i][rand_j] == 0) {
                    lootTable[rand_x][rand_y][rand_i][rand_j] = 7;
                    placed = true;
                }
            }
        }

    }

    public static void removeInventoryUI(char victim) {
        if (victim == 'X') {
            GameLogic.getInstance().getXPlayerPane().getxInventoryUI().getMagicEraserText().setText(String.valueOf(0));
            GameLogic.getInstance().getXPlayerPane().getxInventoryUI().getDoubleSpellText().setText(String.valueOf(0));
            GameLogic.getInstance().getXPlayerPane().getxInventoryUI().getIceBlocksText().setText(String.valueOf(0));
            GameLogic.getInstance().getXPlayerPane().getxInventoryUI().getDestroyerRayText().setText(String.valueOf(0));
            GameLogic.getInstance().getXPlayerPane().getxInventoryUI().getTieBreakerText().setText(String.valueOf(0));
            GameLogic.getInstance().getXPlayerPane().getxInventoryUI().getCraftingCatalystText().setText(String.valueOf(0));
            GameLogic.getInstance().getXPlayerPane().getxInventoryUI().getStuntGrenadeText().setText(String.valueOf(0));
            GameLogic.getInstance().getXPlayerPane().getxInventoryUI().getMagicEraserUpgradedText().setText(String.valueOf(0));
            GameLogic.getInstance().getXPlayerPane().getxInventoryUI().getTripleSpellText().setText(String.valueOf(0));
            GameLogic.getInstance().getXPlayerPane().getxInventoryUI().getIceBlocksUpgradedText().setText(String.valueOf(0));
        } else {
            GameLogic.getInstance().getOPlayerPane().getoInvetoryUI().getMagicEraserText().setText(String.valueOf(0));
            GameLogic.getInstance().getOPlayerPane().getoInvetoryUI().getDoubleSpellText().setText(String.valueOf(0));
            GameLogic.getInstance().getOPlayerPane().getoInvetoryUI().getIceBlocksText().setText(String.valueOf(0));
            GameLogic.getInstance().getOPlayerPane().getoInvetoryUI().getDestroyerRayText().setText(String.valueOf(0));
            GameLogic.getInstance().getOPlayerPane().getoInvetoryUI().getTieBreakerText().setText(String.valueOf(0));
            GameLogic.getInstance().getOPlayerPane().getoInvetoryUI().getCraftingCatalystText().setText(String.valueOf(0));
            GameLogic.getInstance().getOPlayerPane().getoInvetoryUI().getStuntGrenadeText().setText(String.valueOf(0));
            GameLogic.getInstance().getOPlayerPane().getoInvetoryUI().getMagicEraserUpgradedText().setText(String.valueOf(0));
            GameLogic.getInstance().getOPlayerPane().getoInvetoryUI().getTripleSpellText().setText(String.valueOf(0));
            GameLogic.getInstance().getOPlayerPane().getoInvetoryUI().getIceBlocksUpgradedText().setText(String.valueOf(0));

        }
    }

    public static void updateCertainInventoryUI(char playerTurn, BaseItem item){
            if(playerTurn == 'X'){
                int count = GameLogic.getInstance().getXplayerItem().get(item.getName());
                InventoryPane inventoryPane = GameLogic.getInstance().getXPlayerPane().getxInventoryUI();
                item.updateInvetoryPaneUI(inventoryPane,count);
            }else{
                int count = GameLogic.getInstance().getOplayerItem().get(item.getName());
                InventoryPane inventoryPane = GameLogic.getInstance().getOPlayerPane().getoInvetoryUI();
                item.updateInvetoryPaneUI(inventoryPane,count);
            }

    }


    public static void updateInvetoryUI() {
        for(BaseItem item : GameLogic.getInstance().getxInventory()){
            int count = GameLogic.getInstance().getXplayerItem().get(item.getName());
            item.updateInvetoryPaneUI(GameLogic.getInstance().getXPlayerPane().getxInventoryUI(),count);
        }
        for(BaseItem item : GameLogic.getInstance().getoInventroy()){
            int count = GameLogic.getInstance().getOplayerItem().get(item.getName());
            item.updateInvetoryPaneUI(GameLogic.getInstance().getOPlayerPane().getoInvetoryUI(),count);
        }

    }


    public static void removeItemFromInventory(BaseItem item) {
        String itemName = item.getName();
        if (GameLogic.getInstance().getCurrentPlayer() == 'X') {
            if (GameLogic.getInstance().getXplayerItem().get(itemName) > 0) {
                int count = GameLogic.getInstance().getXplayerItem().get(itemName);
                int newValue = count - 1;
                GameLogic.getInstance().getXplayerItem().put(itemName, newValue);
                for (int i = 0; i < GameLogic.getInstance().getxInventory().size(); i++) {
                    if (GameLogic.getInstance().getxInventory().get(i).getName() == itemName) {
                        GameLogic.getInstance().getxInventory().remove(i);
                        break;
                    }
                }
            }

        }
        if (GameLogic.getInstance().getCurrentPlayer() == 'O') {
            if (GameLogic.getInstance().getOplayerItem().get(itemName) > 0) {
                int count = GameLogic.getInstance().getOplayerItem().get(itemName);
                int newValue = count - 1;
                GameLogic.getInstance().getOplayerItem().put(itemName, newValue);
                for (int i = 0; i < GameLogic.getInstance().getoInventroy().size(); i++) {
                    if (GameLogic.getInstance().getoInventroy().get(i).getName() == itemName) {
                        GameLogic.getInstance().getoInventroy().remove(i);
                        break;
                    }
                }

            }
        }
    }

    public static boolean canRemove(BaseItem item) {
        String itemName = item.getName();
        boolean res = false;
        if (GameLogic.getInstance().getCurrentPlayer() == 'X') {
            if (GameLogic.getInstance().getXplayerItem().get(itemName) > 0) {
                res = true;
            }
        }
        if (GameLogic.getInstance().getCurrentPlayer() == 'O') {
            if (GameLogic.getInstance().getOplayerItem().get(itemName) > 0) {
                res = true;
            }
        }
        return res;
    }

    public static void undoTake(BaseItem item) {
        String itemName = item.getName();
        if (GameLogic.getInstance().getCurrentPlayer() == 'X') {
            int count = GameLogic.getInstance().getXplayerItem().getOrDefault(itemName, 0);
            int newValue = count + 1;
            GameLogic.getInstance().getXplayerItem().put(itemName, newValue);

            GameLogic.getInstance().getxInventory().add(item);


        }
        if (GameLogic.getInstance().getCurrentPlayer() == 'O') {
            int count = GameLogic.getInstance().getOplayerItem().getOrDefault(itemName, 0);
            int newValue = count + 1;
            GameLogic.getInstance().getOplayerItem().put(itemName, newValue);

            GameLogic.getInstance().getoInventroy().add(item);
        }
    }

    public static boolean isCraftable(BaseItem item1, BaseItem item2) {
        if( item1 !=null && item2!=null){
        if ((item1 instanceof Upgradeable || item1 instanceof CraftingCatalyst) && (item2 instanceof Upgradeable || item2 instanceof CraftingCatalyst)) {
            if (!(item1 instanceof CraftingCatalyst) || !(item2 instanceof CraftingCatalyst)) {
                if (item1.getClass() == item2.getClass()) {
                    return true;
                } else return item1 instanceof CraftingCatalyst || item2 instanceof CraftingCatalyst;
            } else {
                return false;
            }
        } else {
            return false;
        }
        }else{
            return false;
        }
    }

    public static void addCraftedItem(BaseItem item) {
        if (GameLogic.getInstance().getCurrentPlayer() == 'X') {
            String itemName = " ";
            if(item instanceof MagicEraser || item instanceof DoubleSpell || item instanceof IceBlocks){
                itemName = item.getName();
                GameLogic.getInstance().getxInventory().add(item);
            }

//            if (item instanceof MagicEraser) {
//                MagicEraser item1 = (MagicEraser) item;
//                itemName = item1.getName();
//                GameLogic.getInstance().getxInventory().add(item1);
//            } else if (item instanceof DoubleSpell) {
//                DoubleSpell item1 = (DoubleSpell) item;
//                itemName = item1.getName();
//                GameLogic.getInstance().getxInventory().add(item1);
//            } else if (item instanceof IceBlocks) {
//                IceBlocks item1 = (IceBlocks) item;
//                itemName = item1.getName();
//                GameLogic.getInstance().getxInventory().add(item1);
//            }
//
            int count = GameLogic.getInstance().getXplayerItem().getOrDefault(itemName, 0);
            int newValue = count + 1;
            GameLogic.getInstance().getXplayerItem().put(itemName, newValue);


        }
        if (GameLogic.getInstance().getCurrentPlayer() == 'O') {
            String itemName = " ";
            if(item instanceof MagicEraser || item instanceof DoubleSpell || item instanceof IceBlocks){
                itemName = item.getName();
                GameLogic.getInstance().getoInventroy().add(item);
            }
//            if (item instanceof MagicEraser) {
//                MagicEraser item1 = (MagicEraser) item;
//                itemName = item1.getName();
//                GameLogic.getInstance().getoInventroy().add(item1);
//            } else if (item instanceof DoubleSpell) {
//                DoubleSpell item1 = (DoubleSpell) item;
//                itemName = item1.getName();
//                GameLogic.getInstance().getoInventroy().add(item1);
//            } else if (item instanceof IceBlocks) {
//                IceBlocks item1 = (IceBlocks) item;
//                itemName = item1.getName();
//                GameLogic.getInstance().getoInventroy().add(item1);
//            }

            int count = GameLogic.getInstance().getOplayerItem().getOrDefault(itemName, 0);
            int newValue = count + 1;
            GameLogic.getInstance().getOplayerItem().put(itemName, newValue);
        }
    }



}
