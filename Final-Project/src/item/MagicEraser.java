package item;

import base.BaseItem;
import Interface.Upgradeable;
import gui.InventoryPane;
import logic.ItemMethods;

public class MagicEraser extends BaseItem implements Upgradeable {


    private boolean upgraded;


    public MagicEraser() {
        super("Magic Eraser");
        setUpgraded(false);

    }


    @Override
    public void upgrade() {
        setName("Upgraded Magic Eraser");
        setUpgraded(true);
    }

    @Override
    public void setUpgraded(boolean upgradedState) {
        upgraded = upgradedState;
    }

    @Override
    public boolean isUpgraded() {
        return upgraded;
    }


    @Override
    public String toString() {
        return "Magic Eraser";
    }

    @Override
    public void use() {
        if (upgraded) {
            ItemMethods.getInstance().eraseGlobalPane();
        } else {
            ItemMethods.getInstance().eraseLocalPane();
        }
    }

    @Override
    public void updateInvetoryPaneUI(InventoryPane inventoryPane, int count) {
        if(isUpgraded()){
            inventoryPane.getMagicEraserUpgradedText().setText(String.valueOf(count));
        }else {
            inventoryPane.getMagicEraserText().setText(String.valueOf(count));
        }
    }
}
