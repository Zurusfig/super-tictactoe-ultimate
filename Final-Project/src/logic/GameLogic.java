package logic;

import Player.Player;
import base.BaseItem;
import gui.*;
import item.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;

public class GameLogic {

    private static GameLogic instance = null;

    private ControlPane controlPane;

    private InfoPane infoPane;

    private XPlayerPane XPlayerPane;

    private OPlayerPane OPlayerPane;

    private boolean canDraw = false;

    private int[][][][] board = new int[3][3][3][3]; //store data of whole board as 4D array

    private int[][][][] lootTable = new int[3][3][3][3]; //store loot data of whole board as 4D array

    private int[][] globalBoard = new int[3][3]; //store data of local cell ( 0-> empty, -1 -> tie, 1 -> X, 2-> O)
    private char currentPlayer = 'X';

    private int LastRoundR; //store location row of last round (3 -> can be placed anywhere)
    private int LastRoundC; //store location cols of last round (3 -> can be placed anywhere)

    private boolean gameEnd;
    private boolean isFilled;
    private boolean isFound = false;


    private int finalGameState = 0;

    private HashMap<String, Integer> OplayerItem = new HashMap<>();
    private HashMap<String, Integer> XplayerItem = new HashMap<>();

    private ArrayList<BaseItem> xInventory = new ArrayList<>();
    private ArrayList<BaseItem> oInventory = new ArrayList<>();

    private Player playerO;
    private Player playerX;

    private BaseItem selectedXItem = null;

    private BaseItem selectedOItem = null;

    private boolean roundItemUsed = false;


    private int stuntMove = -1;

    private int moveNumber = 0;

    private int multipleTurns = 0;

    private boolean tieBreaker = false;

    private boolean erasePhase = false;

    private boolean upgradedErasePhase = false;

    private int frozenRoundLeft = 0;
    private int iceBlocksLeft = 0;


    GameLogic() {
        this.newGame();
    }

    public void newGame() {
        setGameEnd(false);
        setFinalGameState(0);
        setCurrentPlayer('X');
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                globalBoard[x][y] = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        board[x][y][i][j] = 0;
                        lootTable[x][y][i][j] = 0;
                    }
                }
            }
        }
        GameUtils.fillLootTable(lootTable);
        setLastRoundR(3);
        setLastRoundC(3);
        playerX = new Player("X");
        playerO = new Player("O");

        setFinalGameState(0);

        setXplayerItem(new HashMap<>());
        setOplayerItem(new HashMap<>());

        setoInventory(new ArrayList<BaseItem>());
        setxInventory(new ArrayList<BaseItem>());

        setXSelectedItem(null);
        setOSelectedItem(null);

        setRoundItemUsed(false);

        setStuntMove(-1);

        setMoveNumber(0);
        setMultipleTurns(0);
        setTieBreaker(false);
        setErasePhase(false);
        setUpgradedErasePhase(false);
        setFrozenRoundLeft(0);
        setIceBlocksLeft(0);





//        for(int x=0; x < 3; x++){
//            for(int y=0; y<3; y++){
//                System.out.println(" ");
//                if(y== 0)System.out.println("-----------------------");
//                for(int i=0; i<3; i++){
//                    for(int j=0;j<3;j++){
//                        System.out.print(lootTable[x][y][i][j]+ " ");
//                        if(j == 2) System.out.print("| ");
//                    }
//                }
//            }
//        }
//        System.out.println(" ");


    }

    //draw number on board array
    public void drawNumber(int boardX, int boardY, int cellX, int cellY) {
        System.out.println("---------------------------------");
        System.out.println("CurrentPlayer: " + getCurrentPlayer());
        int num;
        if (getCurrentPlayer() == 'X') {
            num = 1;
        } else {
            num = 2;
        }
        if (checkLastRound(boardX, boardY) && checkValidMove(boardX, boardY, cellX, cellY)) {
            setCanDraw(true);

            board[boardX][boardY][cellX][cellY] = num;  //change the board to that number
            removeHighLight();
            setLastRoundR(cellX); //set lastRoundR to the placed cell row
            setLastRoundC(cellY); //set lastRoundC to the placed cell C
            setMoveNumber(getMoveNumber() + 1);


            System.out.println("Move Number: " + getMoveNumber());
            System.out.println("Placed at " + getCurrentPlayer() + " -> (" + boardX + ":" + boardY + ' ' + cellX + ':' + cellY + ")");
            System.out.print("Local Board data: ");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(board[boardX][boardY][i][j]);
                    if (j == 2) System.out.print(" |");
                    System.out.print(" ");
                }
            }
            System.out.println();
            if (!(getXPlayerPane().getCraftingPane().getIngredients().isEmpty())) {
                getXPlayerPane().getCraftingPane().onClearClicked();

            }
        }
        if (checkFull(boardX, boardY)) {
            //if localBoard is full
            if (checkLocalWinner(boardX, boardY, num)) {
                globalBoard[boardX][boardY] = num; //if win set local board to that value
                updateLocalUI(boardX, boardY, num);


                System.out.println(getCurrentPlayer() + " won Board " + boardX + ':' + boardY);
                System.out.print("Global Board data: ");
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        System.out.print(globalBoard[i][j]);
                        if (j == 2) System.out.print(" |");
                        System.out.print(" ");
                    }
                }
                System.out.println();
            } else {
                globalBoard[boardX][boardY] = -1; //if local board is tied
                updateLocalUI(boardX, boardY, -1);


                System.out.println("Board " + boardX + ':' + boardY + " is now tied");
                System.out.print("Global Board data: ");
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        System.out.print(globalBoard[i][j]);
                        if (j == 2) System.out.print(" |");
                        System.out.print(" ");
                    }
                }
                System.out.println();


            }
            //TODO: Update UI for local wins


            if (checkGlobalWin(num) || checkGlobalFull()) {
                setGameEnd(true); //end game when winner is done
            }
        } else {
            if (checkLocalWinner(boardX, boardY, num)) {
                globalBoard[boardX][boardY] = num; //if win set local board to that value
                updateLocalUI(boardX, boardY, num);


                System.out.println(getCurrentPlayer() + " won Board " + boardX + ':' + boardY);
                System.out.print("Global Board data: ");
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        System.out.print(globalBoard[i][j]);
                        if (j == 2) System.out.print(" |");
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
            if (checkGlobalWin(num) || checkGlobalFull()) {
                setGameEnd(true); //end game when winner is done
            }
        }


        if (canDraw) {
            System.out.println("Multiple turns: " + getMultipleTurns());
            if (currentPlayer == 'X' && multipleTurns == 0) {
                getItem(boardX, boardY, cellX, cellY);
                setCurrentPlayer('O');
                controlPane.updateGameText(playerO.getName() + "'s Turn");
            } else if (currentPlayer == 'O' && multipleTurns == 0) {
                getItem(boardX, boardY, cellX, cellY);
                setCurrentPlayer('X');
                controlPane.updateGameText(playerX.getName() + "'s Turn");
            } else {
                getItem(boardX, boardY, cellX, cellY);
                setMultipleTurns(getMultipleTurns() - 1);
            }
        }

        initiatingWin();

        updateHighLight();
//        setRoundItemUsed(false);
//        getOPlayerPane().getUseBtn().setDisable(false);
        if (getStuntMove() == getMoveNumber() + 1) {
            setRoundItemUsed(true);
            System.out.println("Stunted!!!");
        } else {
            setRoundItemUsed(false);
            getOPlayerPane().getUseBtn().setDisable(false);

        }

        if (frozenRoundLeft == 0) {
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if(board[x][y][i][j] == 3) board[x][y][i][j] = 0;
                        }
                    }
                }
            }
        }

        GameUtils.updateInvetoryUI();


    }

    public void fillLoot() {
        GameUtils.fillLootTable(lootTable);
        isFilled = true;
    }

    public void clearLootTable() {
        if (isGameEnd()) {
            setLootTable(new int[3][3][3][3]);
            isFilled = false;
        }
    }

    public void getItem(int boardX, int boardY, int cellX, int cellY) {

        int itemNum;
//        String name = null;
        BaseItem item = null;
        String itemName = null;


        if (!isFilled) {
            fillLoot();
        }


        itemNum = lootTable[boardX][boardY][cellX][cellY];
        if (itemNum == 1) {
//            name = "Magic Eraser";
            item = new MagicEraser();
        } else if (itemNum == 2) {
//            name = "Double Spell";
            item = new DoubleSpell();
        } else if (itemNum == 3) {
//            name = "Ice Blocks";
            item = new IceBlocks();
        } else if (itemNum == 4) {
//            name = "Destroyer Ray";
            item = new DestroyerRay();
        } else if (itemNum == 5) {
//            name = "Tie Breaker";
            item = new TieBreaker();
        } else if (itemNum == 6) {
//            name = "Crafting Catalyst";
            item = new CraftingCatalyst();
        } else if (itemNum == 7) {
//            name = "Stunt Grenade";
            item = new StuntGrenade();
        }

        if (item != null) {
            itemName = item.getName();
        }


        if (getCurrentPlayer() == 'X') {
            if (itemNum != 0) {
                int currentAmount = XplayerItem.getOrDefault(itemName, 0);
                int newValue = currentAmount + 1;
                xInventory.add(item);
                XplayerItem.put(itemName, newValue);
                System.out.println("X found item" + itemName);
                infoPane.setInfoText(playerX.getName() + " found " + itemName);
                lootTable[boardX][boardY][cellX][cellY] = 0;
                isFound = true;
            } else {
                System.out.println("X does not found any item");
                infoPane.setInfoText(playerX.getName() + " did not find any item");
            }
        } else if (getCurrentPlayer() == 'O') {
            if (itemNum != 0) {
                int currentAmount = OplayerItem.getOrDefault(itemName, 0);
                int newValue = currentAmount + 1;
                oInventory.add(item);
                OplayerItem.put(itemName, newValue);
                System.out.println("O found item" + itemName);
                infoPane.setInfoText(playerO.getName() + " found " + itemName);
                lootTable[boardX][boardY][cellX][cellY] = 0;
                isFound = true;
            } else {
                System.out.println("O does not found any item");
                infoPane.setInfoText(playerO.getName() + " did not find any item");
            }
        }
        System.out.println("X" + XplayerItem);
        System.out.println("X" + xInventory);
        System.out.println("O" + OplayerItem);
        System.out.println("O" + oInventory);
        clearLootTable();
    }

    public void updateHighLight() {
        if (LastRoundC != 3 && LastRoundR != 3 && globalBoard[LastRoundR][LastRoundC] == 0) {
            int paneIndex = GameUtils.paneIndexConverter(LastRoundR, LastRoundC);
            controlPane.getTicTacToeGlobal().getAllPanes().get(paneIndex).getPane().setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));
        } else {
            for (int i = 0; i < 9; i++) {
                int[] check = GameUtils.reversePaneIndexConverter(i);
                if (globalBoard[check[0]][check[1]] == 0) {
                    controlPane.getTicTacToeGlobal().getAllPanes().get(i).getPane().setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));
                }
            }
        }

    }

    public void removeHighLight() {
        if (LastRoundC != 3 && LastRoundR != 3 && globalBoard[LastRoundR][LastRoundC] == 0) {
            int paneIndex = GameUtils.paneIndexConverter(LastRoundR, LastRoundC);
            controlPane.getTicTacToeGlobal().getAllPanes().get(paneIndex).getPane().setBackground(new Background(new BackgroundFill(Color.MISTYROSE, null, null)));
        } else {
            for (int i = 0; i < 9; i++) {
                int[] check = GameUtils.reversePaneIndexConverter(i);
                if (globalBoard[check[0]][check[1]] == 0) {
                    controlPane.getTicTacToeGlobal().getAllPanes().get(i).getPane().setBackground(new Background(new BackgroundFill(Color.MISTYROSE, null, null)));
                }
            }
        }

    }


    public void updateLocalUI(int boardX, int boardY, int num) {
        int paneIndex = GameUtils.paneIndexConverter(boardX, boardY);

        if (num == -1) {
            controlPane.getTicTacToeGlobal().getAllPanes().get(paneIndex).getTieRect().setVisible(true);
        } else if (num == 1) {
            controlPane.getTicTacToeGlobal().getAllPanes().get(paneIndex).getxRect().setVisible(true);
        } else if (num == 2) {
            controlPane.getTicTacToeGlobal().getAllPanes().get(paneIndex).getoRect().setVisible(true);
        }

    }


    //check if chosen cell is the same as LastRound cell or not
    public boolean checkLastRound(int boardX, int boardY) {
        if (getLastRoundC() == 3 || getLastRoundR() == 3) {
            // true if can be placed anywhere
            return true;
        } else {
            if (globalBoard[getLastRoundR()][getLastRoundC()] != 0) {
                // true if cell is last round is full
                return true;
            } else if (getLastRoundR() == boardX && getLastRoundC() == boardY) {
                // true if cell is same as last round
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean checkValidMove(int boardX, int boardY, int cellX, int cellY) {
        //return true if that cell is empty
        return board[boardX][boardY][cellX][cellY] == 0 && globalBoard[boardX][boardY] == 0;
    }

    public boolean checkFull(int boardX, int boardY) {
        // check if that local cell is full or not
        boolean full = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[boardX][boardY][i][j] == 0) {
                    full = false;
                }
            }
        }
        return full;
    }

    public boolean checkGlobalFull() {
        boolean full = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (globalBoard[i][j] == 0) {
                    full = false;
                }
            }
        }
        return full;
    }


    public boolean checkLocalWinner(int boardX, int boardY, int num) {
        return (board[boardX][boardY][0][0] == num && board[boardX][boardY][0][1] == num && board[boardX][boardY][0][2] == num) ||
                (board[boardX][boardY][1][0] == num && board[boardX][boardY][1][1] == num && board[boardX][boardY][1][2] == num) ||
                (board[boardX][boardY][2][0] == num && board[boardX][boardY][2][1] == num && board[boardX][boardY][2][2] == num) ||
                (board[boardX][boardY][0][0] == num && board[boardX][boardY][1][0] == num && board[boardX][boardY][2][0] == num) ||
                (board[boardX][boardY][0][1] == num && board[boardX][boardY][1][1] == num && board[boardX][boardY][2][1] == num) ||
                (board[boardX][boardY][0][2] == num && board[boardX][boardY][1][2] == num && board[boardX][boardY][2][2] == num) ||
                (board[boardX][boardY][0][0] == num && board[boardX][boardY][1][1] == num && board[boardX][boardY][2][2] == num) ||
                (board[boardX][boardY][2][0] == num && board[boardX][boardY][1][1] == num && board[boardX][boardY][0][2] == num);
    }

    public boolean checkGlobalWin(int num) {
        return (globalBoard[0][0] == num && globalBoard[0][1] == num && globalBoard[0][2] == num) ||
                (globalBoard[1][0] == num && globalBoard[1][1] == num && globalBoard[1][2] == num) ||
                (globalBoard[2][0] == num && globalBoard[2][1] == num && globalBoard[2][2] == num) ||
                (globalBoard[0][0] == num && globalBoard[1][0] == num && globalBoard[2][0] == num) ||
                (globalBoard[0][1] == num && globalBoard[1][1] == num && globalBoard[2][1] == num) ||
                (globalBoard[0][2] == num && globalBoard[1][2] == num && globalBoard[2][2] == num) ||
                (globalBoard[0][0] == num && globalBoard[1][1] == num && globalBoard[2][2] == num) ||
                (globalBoard[2][0] == num && globalBoard[1][1] == num && globalBoard[0][2] == num);
    }

    public void initiatingWin(){
        if (isGameEnd()) {
            if (checkGlobalWin(1)) {
                GameLogic.getInstance().controlPane.updateGameText("X wins!!!!");
                finalGameState = 1;

            } else if (checkGlobalWin(2)) {
                GameLogic.getInstance().controlPane.updateGameText("O wins!!!!");
                finalGameState = 2;
            } else {
                GameLogic.getInstance().controlPane.updateGameText("Tie!!!!");
                finalGameState = -1;
            }
            //TODO: go to win page
        }
    }



    public int[][][][] getBoard() {
        return board;
    }


    public int[][] getGlobalBoard() {
        return globalBoard;
    }


    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(char currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getLastRoundR() {
        return LastRoundR;
    }

    public void setLastRoundR(int lastRoundR) {
        LastRoundR = lastRoundR;
    }

    public int getLastRoundC() {
        return LastRoundC;
    }

    public void setLastRoundC(int lastRoundC) {
        LastRoundC = lastRoundC;
    }

    public boolean isGameEnd() {
        return gameEnd;
    }

    public void setGameEnd(boolean gameEnd) {
        this.gameEnd = gameEnd;
    }

    public static GameLogic getInstance() {
        if (instance == null) {
            instance = new GameLogic();
        }
        return instance;
    }

    public boolean isCanDraw() {
        return canDraw;
    }

    public void setCanDraw(boolean canDraw) {
        this.canDraw = canDraw;
    }

    public ControlPane getControlPane() {
        return controlPane;
    }

    public void setControlPane(ControlPane controlPane) {
        this.controlPane = controlPane;
    }

    public void setLootTable(int[][][][] lootTable) {
        this.lootTable = lootTable;
    }

    public int[][][][] getLootTable() {
        return lootTable;
    }


    public int getFinalGameState() {
        return finalGameState;
    }

    public void setFinalGameState(int finalGameState) {
        this.finalGameState = finalGameState;
    }

    public Player getPlayerO() {
        return playerO;
    }

    public void setPlayerO(Player playerO) {
        this.playerO = playerO;
    }

    public Player getPlayerX() {
        return playerX;
    }

    public void setPlayerX(Player playerX) {
        this.playerX = playerX;
    }

    public XPlayerPane getXPlayerPane() {
        return XPlayerPane;
    }

    public void setXPlayerPane(XPlayerPane xPlayerPane) {
        this.XPlayerPane = xPlayerPane;
    }

    public OPlayerPane getOPlayerPane() {
        return OPlayerPane;
    }

    public void setOPlayerPane(OPlayerPane oPlayerPane) {
        this.OPlayerPane = oPlayerPane;
    }

    public boolean isItemFound() {
        return isFound;
    }

    public HashMap<String, Integer> getOplayerItem() {
        return OplayerItem;
    }

    public void setOplayerItem(HashMap<String, Integer> oplayerItem) {
        OplayerItem = oplayerItem;
    }

    public HashMap<String, Integer> getXplayerItem() {
        return XplayerItem;
    }

    public void setXplayerItem(HashMap<String, Integer> xplayerItem) {
        XplayerItem = xplayerItem;
    }

    public ArrayList<BaseItem> getxInventory() {
        return xInventory;
    }

    public void setxInventory(ArrayList<BaseItem> xInventory) {
        this.xInventory = xInventory;
    }

    public ArrayList<BaseItem> getoInventroy() {
        return oInventory;
    }

    public void setoInventory(ArrayList<BaseItem> oInventory) {
        this.oInventory = oInventory;
    }

    public BaseItem getXSelectedItem() {
        return selectedXItem;
    }

    public void setXSelectedItem(BaseItem selectedItem) {
        this.selectedXItem = selectedItem;
    }

    public BaseItem getOSelectedItem() {
        return selectedOItem;
    }

    public void setOSelectedItem(BaseItem selectedOItem) {
        this.selectedOItem = selectedOItem;
    }

    public InfoPane getInfoPane() {
        return infoPane;
    }

    public void setInfoPane(InfoPane infoPane) {
        this.infoPane = infoPane;
    }

    public boolean isRoundItemUsed() {
        return roundItemUsed;
    }

    public void setRoundItemUsed(boolean roundItemUsed) {
        this.roundItemUsed = roundItemUsed;
    }

    public int getMoveNumber() {
        return moveNumber;
    }

    public void setMoveNumber(int moveNumber) {
        this.moveNumber = moveNumber;
    }

    public int getStuntMove() {
        return stuntMove;
    }

    public void setStuntMove(int stuntMove) {
        this.stuntMove = stuntMove;
    }

    public int getMultipleTurns() {
        return multipleTurns;
    }

    public void setMultipleTurns(int multipleTurns) {
        this.multipleTurns = multipleTurns;
    }

    public boolean isTieBreaker() {
        return tieBreaker;
    }

    public void setTieBreaker(boolean tieBreaker) {
        this.tieBreaker = tieBreaker;
    }

    public boolean isErasePhase() {
        return erasePhase;
    }

    public void setErasePhase(boolean erasePhase) {
        this.erasePhase = erasePhase;
    }

    public boolean isUpgradedErasePhase() {
        return upgradedErasePhase;
    }

    public void setUpgradedErasePhase(boolean upgradedErasePhase) {
        this.upgradedErasePhase = upgradedErasePhase;
    }

    public int getFrozenRoundLeft() {
        return frozenRoundLeft;
    }

    public void setFrozenRoundLeft(int frozenRoundLeft) {
        this.frozenRoundLeft = frozenRoundLeft;
    }

    public int getIceBlocksLeft() {
        return iceBlocksLeft;
    }

    public void setIceBlocksLeft(int iceBlocksLeft) {
        this.iceBlocksLeft = iceBlocksLeft;
    }
}
