package item;

import base.BaseItem;
import gui.InventoryPane;
import logic.ItemMethods;

public class TieBreaker extends BaseItem {


    public TieBreaker() {
        super("Tie Breaker");

    }

    @Override
    public String toString() {
        return "Tie Breaker";
    }

    @Override
    public void use() {
        ItemMethods.getInstance().tieBreaking();
    }

    @Override
    public void updateInvetoryPaneUI(InventoryPane inventoryPane, int count) {
        inventoryPane.getTieBreakerText().setText(String.valueOf(count));
    }

}
