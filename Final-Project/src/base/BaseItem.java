package base;

import gui.InventoryPane;

public abstract class BaseItem implements Cloneable{

    private String name;


    public BaseItem(String name) {
        super();
        setName(name);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        if (name.isBlank()) {
            this.name = "Unnamed Item";
        }
    }


    public abstract String toString();

    public abstract void use();

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public abstract void updateInvetoryPaneUI(InventoryPane inventoryPane, int count);



}
