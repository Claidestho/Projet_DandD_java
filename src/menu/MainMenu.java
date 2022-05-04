package menu;
import system.GameCore;
import heros.Hero;
import heros.Magician;
import heros.Warrior;

import java.util.Scanner;

public class MainMenu {
    Scanner userInput;

    public MainMenu() {
        this.userInput = new Scanner(System.in);
    }

    public Hero startMenu() {
        int wantsToPlay = displayWelcomeMessage();

        if (wantsToPlay == 1) {
            Hero playerCharacter = editNewCharacter();
            return playerCharacter;

        } else {
            System.exit(0);
            return new Warrior();
        }

    }

    public int displayWelcomeMessage() {
        System.out.println("██████╗ ██╗   ██╗███╗   ██╗ ██████╗ ███████╗ ██████╗ ███╗   ██╗███████╗       ██╗       ██████╗ ██████╗  █████╗  ██████╗  ██████╗ ███╗   ██╗███████╗\n" +
                "██╔══██╗██║   ██║████╗  ██║██╔════╝ ██╔════╝██╔═══██╗████╗  ██║██╔════╝       ██║       ██╔══██╗██╔══██╗██╔══██╗██╔════╝ ██╔═══██╗████╗  ██║██╔════╝\n" +
                "██║  ██║██║   ██║██╔██╗ ██║██║  ███╗█████╗  ██║   ██║██╔██╗ ██║███████╗    ████████╗    ██║  ██║██████╔╝███████║██║  ███╗██║   ██║██╔██╗ ██║███████╗\n" +
                "██║  ██║██║   ██║██║╚██╗██║██║   ██║██╔══╝  ██║   ██║██║╚██╗██║╚════██║    ██╔═██╔═╝    ██║  ██║██╔══██╗██╔══██║██║   ██║██║   ██║██║╚██╗██║╚════██║\n" +
                "██████╔╝╚██████╔╝██║ ╚████║╚██████╔╝███████╗╚██████╔╝██║ ╚████║███████║    ██████║      ██████╔╝██║  ██║██║  ██║╚██████╔╝╚██████╔╝██║ ╚████║███████║\n" +
                "╚═════╝  ╚═════╝ ╚═╝  ╚═══╝ ╚═════╝ ╚══════╝ ╚═════╝ ╚═╝  ╚═══╝╚══════╝    ╚═════╝      ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝  ╚═════╝ ╚═╝  ╚═══╝╚══════╝");
        System.out.print("Bienvenue dans Donjons et Dragons ! Voulez vous créer un personnage (1) ou quitter le jeu (2) ?");
        return getAnswerInt(this.userInput, 2);

    }

    public Hero editNewCharacter() {
        System.out.print("Hello l'aventurier, choisis donc la super classe de ouf que tu souhaites jouer : " +
                "\n - 1 Guerrier (gneu taper) " +
                "\n - 2 Magicien (olala la magie)");
        Hero playerClass;
        int result = getAnswerInt(userInput, 2);
        if (result == 1) {

            System.out.println("Veuillez choisir le nom de votre Guerrier(re) :");
            playerClass = new Warrior(userInput.nextLine());
            System.out.println("Longue vie à " + playerClass.getName() + " ! Jeune guerrier aux caracteristiques suivantes : \n" + playerClass.showCharacterStats());

        } else {
            System.out.println("Veuillez choisir le nom de votre Magicien(ne) :");
            playerClass = new Magician(userInput.nextLine());
            System.out.println("Longue vie à " + playerClass.getName() + " ! Puissant magicien aux caracteristiques suivantes : \n" + playerClass.showCharacterStats());
        }
        playerClass.toString();
        return playerClass;

    }

    public int getAnswerInt(Scanner userAnswer, int choicesNumber) {
        System.out.println("\nFaites votre choix :");
        int answer = userAnswer.nextInt();
        userAnswer.nextLine();
        while (answer <= 0 || answer > choicesNumber) {
            System.out.println("Entrée incorrecte, veuillez faire votre choix parmie les " + choicesNumber + " propositions disponibles.");
            answer = userAnswer.nextInt();
            userAnswer.nextLine();
        }
        return answer;
    }

    public void displaySeparator() {
        System.out.println("===================================================================");
    }

    public void displayGameStart(Hero hero, GameCore game) {

        System.out.println("Bienvenue dans le Donjon " + hero.getName() + " ! Tu es actuellement sur la case " + game.getCurrentPosition() + " Pour lancer le dé appuyez sur [1] - Pour quitter la partie appuyez sur [2]");


    }

    public void turnStart(GameCore game){
        System.out.println("TOUR " + game.getTurnCounter());
        System.out.println("Votre position : Case " + game.getCurrentPosition());
        System.out.println("Appuyer sur [1] pour lancer les dés - [2] pour quitter la partie");
    }
}
