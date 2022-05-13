package enemies;

import heros.Hero;
import system.board.Tile;

public abstract class Enemy extends Tile {
    public int healthPoints;
    public int attackPoints;
    public String name;

    public Enemy(int healthPoints, int attackPoints, String name) {
        this.healthPoints = healthPoints;
        this.attackPoints = attackPoints;
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean interactWithPlayer(Hero player) {
        boolean isAttacking = true;
        System.out.println("////////////////////////////\nCOMBAT AVEC UN " + this.name + "\n////////////////////////////");

        while (this.healthPoints >= 0 && player.getHealthPoints() >= 0) {
            if (isAttacking) {
                this.healthPoints -= player.getAttackPoints();
                System.out.println("Tu infliges " + player.getAttackPoints() + "! Il reste  " + this.healthPoints + " PDV au " + this.name);
                isAttacking = false;
            } else {
                player.setHealthPoints(player.getHealthPoints() - this.attackPoints);
                System.out.println(this.name + " t'ingliges " + this.attackPoints + " dégats ! Il te reste " + player.getHealthPoints() + " PDV");
                isAttacking = true;
            }
            if (this.healthPoints <= 0) {
                System.out.println("GG il est mort hihi");
            } else if (player.getHealthPoints() <= 0) {
                System.out.println("Ho non tu es mort nonnn :(((");
            }

        }
        return false;
    }

    public void combatPlayer() {


    }
}
