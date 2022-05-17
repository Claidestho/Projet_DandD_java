package enemies;

import heros.Hero;
import system.board.Tile;
import system.GameCore;
public abstract class Enemy extends Tile {
    public int healthPoints;
    public int attackPoints;

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
    public String toString() {
        return this.name;
    }

    @Override
    public boolean interactWithPlayer(Hero player) {
        boolean isAttacking = true;
        System.out.println("////////////////////////////\nCOMBAT AVEC UN " + this.name + "\n////////////////////////////");
        System.out.println(this.healthPoints);

        while (this.healthPoints >= 0 && player.getHealthPoints() >= 0) {
            if (isAttacking) {
                this.healthPoints -= player.getAttackPoints();
                System.out.println("Tu infliges " + player.getAttackPoints() + " points de dégats ! Il reste  " +
                        (this.healthPoints > 0 ? this.healthPoints : "0")
                        + " PDV au " + this.name);
                isAttacking = false;
            } else {
                player.setHealthPoints(player.getHealthPoints() - this.attackPoints);

                System.out.println(this.name + " t'infliges " + this.attackPoints + " dégats ! Il te reste " + (player.getHealthPoints() > 0 ? player.getHealthPoints() : "0") + " PDV");
                isAttacking = true;
            }
            if (this.healthPoints <= 0) {
                System.out.println("GG il est mort hihi");
            } else if (player.getHealthPoints() <= 0) {
                System.out.println("😂😂😂😂😂😂😂😂😂😂😂😂😂😂😂😂😂😂😂");
                System.out.println("Ho non tu es mort nonnn :(((");
                System.out.println("            ______              \n" +
                        "       .d$$$******$$$$c.        \n" +
                        "    .d$P\"            \"$$c      \n" +
                        "   $$$$$.           .$$$*$.    \n" +
                        " .$$ 4$L*$$.     .$$Pd$  '$b   \n" +
                        " $F   *$. \"$$e.e$$\" 4$F   ^$b  \n" +
                        "d$     $$   z$$$e   $$     '$. \n" +
                        "$P     `$L$$P` `\"$$d$\"      $$ \n" +
                        "$$     e$$F       4$$b.     $$ \n" +
                        "$b  .$$\" $$      .$$ \"4$b.  $$ \n" +
                        "$$e$P\"    $b     d$`    \"$$c$F \n" +
                        "'$P$$$$$$$$$$$$$$$$$$$$$$$$$$  \n" +
                        " \"$c.      4$.  $$       .$$   \n" +
                        "  ^$$.      $$ d$\"      d$P    \n" +
                        "    \"$$c.   `$b$F    .d$P\"     \n" +
                        "      `4$$$c.$$$..e$$P\"        \n" +
                        "          `^^^^^^^`");
                return true;

            }

        }
        return false;
    }
}
