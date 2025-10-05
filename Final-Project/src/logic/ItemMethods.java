package logic;

import base.BaseItem;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemMethods {

    private static ItemMethods instance = null;

    //MagicEraser (erase local/global cell)
    public void eraseLocalPane() {
        GameLogic.getInstance().setErasePhase(true);
    }

    //UpgradedMagicEraser
    public void eraseGlobalPane() {
        GameLogic.getInstance().setUpgradedErasePhase(true);
    }

    //DoubleSpells(play 2 round)
    public void doubleRound() {
        GameLogic.getInstance().setMultipleTurns(1);
    }

    //TripleSpells
    public void tripleRound() {
        GameLogic.getInstance().setMultipleTurns(2);
    }

    //IceBlocks (block cell)
    public void blockCell(int rounds) {
        GameLogic.getInstance().setFrozenRoundLeft(rounds);
        GameLogic.getInstance().setIceBlocksLeft(4);
    }

    //DestroyerRay(remove item)
    public void destroyItem() {
        if (GameLogic.getInstance().getCurrentPlayer() == 'O') {
            GameLogic.getInstance().setXplayerItem(new HashMap<String, Integer>());
            GameLogic.getInstance().setxInventory(new ArrayList<BaseItem>());
            GameUtils.removeInventoryUI('X');
        } else if (GameLogic.getInstance().getCurrentPlayer() == 'X') {
            GameLogic.getInstance().setOplayerItem(new HashMap<String, Integer>());
            GameLogic.getInstance().setoInventory(new ArrayList<BaseItem>());
            GameUtils.removeInventoryUI('O');
        }
    }

    //tieBreaker(break tie cell)
    public void tieBreaking() {
        GameLogic.getInstance().setTieBreaker(true);

    }


    //stuntGrenede(player cant use item)
    public void stuntPlayer() {
        int currentMoveNum = GameLogic.getInstance().getMoveNumber();
        int nextMoveNum = currentMoveNum + 2;
        GameLogic.getInstance().setStuntMove(nextMoveNum);

    }

    public static ItemMethods getInstance() {
        if (instance == null) {
            instance = new ItemMethods();
        }
        return instance;
    }
}


