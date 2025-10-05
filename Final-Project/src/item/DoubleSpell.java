package item;

import base.BaseItem;
import Interface.Upgradeable;
import gui.InventoryPane;
import logic.ItemMethods;

public class DoubleSpell extends BaseItem implements Upgradeable {


    private boolean upgraded;

    public DoubleSpell() {
        super("Double Spell");
        setUpgraded(false);
    }


    @Override
    public void upgrade() {
        this.setName("Triple Spell");
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
        return "Double Spell";
    }

    @Override
    public void use() {
        if (upgraded) {
            ItemMethods.getInstance().tripleRound();
        } else {
            ItemMethods.getInstance().doubleRound();
        }
    }

    @Override
    public void updateInvetoryPaneUI(InventoryPane inventoryPane, int count) {
        if(isUpgraded()){
            inventoryPane.getTripleSpellText().setText(String.valueOf(count));
        }else {
            inventoryPane.getDoubleSpellText().setText(String.valueOf(count));
        }
    }
}
