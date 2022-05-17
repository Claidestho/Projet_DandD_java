package items.weapons;

import heros.Hero;
import heros.Magician;
import heros.Warrior;
import system.board.Tile;

public abstract class Weapon extends Tile {
    private int strength;
    private String authorizedClass = "Guerrier";

    public Weapon(String name, int strength) {
        this.name = name;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public boolean interactWithPlayer(Hero player) {
        if(player instanceof Warrior) {
            if(player.getAttackPoints() + this.strength <= player.getMaxAttack()) {
                System.out.println(this.name + " : Votre attaque a augmenté de " + this.strength + " !");
                player.upgradeAttack(this.strength);
            } else if(player.getAttackPoints() == player.getMaxAttack()) {
                System.out.println("Vous avez trouvé l'arme' : " + this.name +" ! Mais votre attaque est déja trop élevée, dommage :(");
            } else {
                System.out.println(this.name + " : Votre attaque a augmenté de " + (player.getMaxAttack() - player.getAttackPoints()) + " !");
                player.setAttackPoints(player.getMaxAttack());
            }
        } else if(player instanceof Magician){
            System.out.println(name + " trouvé(s) ! Votre classe n'est pas compatible : (Classe authorisée : " + authorizedClass + ")");
        }
        return false;
    }
}
