package item;

import base.BaseItem;
import gui.InventoryPane;
import logic.GameLogic;

public class CraftingCatalyst extends BaseItem {


    public CraftingCatalyst() {
        super("Crafting Catalyst");
    }

    @Override
    public String toString() {
        return "Crafting Catalyst";
    }

    @Override
    public void use() {
        //will handle in UseItemHandler
    }

    @Override
    public void updateInvetoryPaneUI(InventoryPane inventoryPane, int count) {
        inventoryPane.getCraftingCatalystText().setText(String.valueOf(count));
    }


}
