package items.potions;

import heros.Hero;
import main.InteractionInterface;
import system.board.Tile;

public abstract class Potion extends Tile implements InteractionInterface {
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

    @Override
    public boolean interactWithPlayer(Hero player) {
        if(player.getHealthPoints() + this.healthUpgrade <= player.getMaxHealth()) {
            System.out.println(this.name + " : Vos points de vie ont augmenté de " + this.healthUpgrade + " !");
            player.upgradeHealth(this.getHealthUpgrade());
        } else if(player.getHealthPoints() == player.getMaxHealth()) {
            System.out.println("Vous avez trouvé une " + this.name +" ! Mais vos points de vie sont déja trop élevés, dommage :(");
        } else {
            System.out.println(this.name + " : Vos points de vie ont augmenté de " + (player.getMaxHealth() - player.getHealthPoints()) + " !");
            player.setHealthPoints(player.getMaxHealth());
        }
        return false;
    }


    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public void typeOfInteract() {
        System.out.println("Ouiiiiiiiii" + this.name);
    }
}
