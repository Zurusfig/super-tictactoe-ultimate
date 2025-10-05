package item;

import base.BaseItem;
import Interface.Upgradeable;
import gui.InventoryPane;
import logic.ItemMethods;

public class IceBlocks extends BaseItem implements Upgradeable {

    private boolean upgraded;


    public IceBlocks() {
        super("Ice Blocks");
        setUpgraded(false);
    }


    @Override
    public void upgrade() {
        setName("Packed Ice Blocks");
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
        return "Ice Blocks";
    }

    @Override
    public void use() {
        if (upgraded) {
            ItemMethods.getInstance().blockCell(7);
        } else {
            ItemMethods.getInstance().blockCell(3);
        }
    }

    @Override
    public void updateInvetoryPaneUI(InventoryPane inventoryPane, int count) {
        if(isUpgraded()) {
            inventoryPane.getIceBlocksUpgradedText().setText(String.valueOf(count));
        }else{
            inventoryPane.getIceBlocksText().setText(String.valueOf(count));
        }
    }

}
