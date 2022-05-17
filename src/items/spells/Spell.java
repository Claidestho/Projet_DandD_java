package items.spells;

import heros.Hero;
import heros.Magician;
import system.board.Tile;

public abstract class Spell extends Tile {
    private int power;
    private String authorizedClass = "Magicien";

    public Spell(String name, int power) {

        this.name = name;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public boolean interactWithPlayer(Hero player) {
        if(player instanceof Magician) {
            if (player.getAttackPoints() + this.power <= player.getMaxAttack()) {
                System.out.println(this.name + " : Votre attaque a augmenté de " + this.power + " !");
                player.upgradeAttack(this.power);
            } else if (player.getAttackPoints() == player.getMaxAttack()) {
                System.out.println("Vous avez trouvé le sort : " + this.name + " ! Mais votre attaque est déja trop élevée, dommage :(");
            } else {
                System.out.println(this.name + " : Votre attaque a augmenté de " + (player.getMaxAttack() - player.getAttackPoints()) + " !");
                player.setAttackPoints(player.getMaxAttack());
            }
        } else {
            System.out.println(name + " trouvé(s) ! Votre classe n'est pas compatible : (Classe authorisée : " + authorizedClass + ")");
        }
        return false;
    }
}
