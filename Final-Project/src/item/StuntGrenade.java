package item;

import base.BaseItem;
import gui.InventoryPane;
import logic.ItemMethods;

public class StuntGrenade extends BaseItem{

    public StuntGrenade() {
        super("Stunt Grenade");
    }

    @Override
    public String toString() {
        return "Stunt Grenade";
    }

    @Override
    public void use() {
        ItemMethods.getInstance().stuntPlayer();
    }

    @Override
    public void updateInvetoryPaneUI(InventoryPane inventoryPane, int count) {
        inventoryPane.getStuntGrenadeText().setText(String.valueOf(count));
    }


}
