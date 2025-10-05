package item;

import base.BaseItem;
import gui.InventoryPane;
import logic.GameLogic;
import logic.ItemMethods;

public class DestroyerRay extends BaseItem {

    public DestroyerRay() {
        super("Destroyer Ray");
    }

    @Override
    public String toString() {
        return "Destroyer Ray";
    }

    @Override
    public void use() {
        ItemMethods.getInstance().destroyItem();
    }

    @Override
    public void updateInvetoryPaneUI(InventoryPane inventoryPane, int count) {
        inventoryPane.getDestroyerRayText().setText(String.valueOf(count));
    }


}
