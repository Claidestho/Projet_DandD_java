package items.potions;

import system.board.Tile;

public abstract class Potion extends Tile {
    private String name;
    private int healthUpgrade;

    public Potion(String name, int healthUpgrade) {
        this.name = name;
        this.healthUpgrade = healthUpgrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthUpgrade() {
        return healthUpgrade;
    }

    public void setHealthUpgrade(int healthUpgrade) {
        this.healthUpgrade = healthUpgrade;
    }
}
