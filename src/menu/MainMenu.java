package menu;

import heros.Hero;
import heros.Magician;
import heros.Warrior;

import java.util.Scanner;

public class MainMenu {
    private Scanner userInput;

    public MainMenu() {
        this.userInput = new Scanner(System.in);
    }

    public Hero startMenu() {
        int wantsToPlay = displayWelcomeMessage();
        if (wantsToPlay == 1) {
            Hero playerCharacter = createNewCharacter();
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

    public Hero createNewCharacter() {
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

    public void defineNewName(Hero hero){
        System.out.println("Veuillez choisir le nouveau nom de votre personnage :");
        hero.name = userInput.nextLine();
    }

    public int getAnswerInt(Scanner userAnswer, int choicesNumber) {
        System.out.println("\nFaites votre choix :");
        int answer = userAnswer.nextInt();
        userAnswer.nextLine();
        while (answer <= 0 || answer > choicesNumber) {
            System.out.println("Entrée incorrecte, veuillez faire votre choix parmi les " + choicesNumber + " propositions disponibles.");
            answer = userAnswer.nextInt();
            userAnswer.nextLine();
        }
        return answer;
    }

    public void displaySeparator() {
        System.out.println("===================================================================");
    }

    public void turnStart(int counter, int currentPosition, Hero hero) {
        this.displaySeparator();
        System.out.println("TOUR " + counter);
        System.out.println("Votre position : Case " + currentPosition);
        System.out.println("[1] Lancer les dés - [2] Afficher les statistiques de " + hero.getName() + " - [3] Renommer le héros (" + hero.getName() + ") - [4] Quitter la partie ");
        this.displaySeparator();
    }

    public void displayWinMessage() {
        this.displaySeparator();
        System.out.println("👌👌👌👌 BRAVO CEST TRES LA VICTOIRE HIHI 👌👌👌👌");
        this.displaySeparator();
    }
    public void displayEndMessage(){
        System.out.println("Souhaitez vous rejouer ? [1] Oui - [2] Non");
    }
}
