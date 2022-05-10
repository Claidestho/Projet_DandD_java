package menu;

import heros.Hero;
import heros.Magician;
import heros.Warrior;

import java.util.InputMismatchException;
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
        System.out.println("$$$$$$$\\         $$$$$$\\                  $$\\       $$$$$$$\\  \n" +
                "$$  __$$\\       $$  __$$\\                 $$ |      $$  __$$\\ \n" +
                "$$ |  $$ |      $$ /  $$ |$$$$$$$\\   $$$$$$$ |      $$ |  $$ |\n" +
                "$$ |  $$ |      $$$$$$$$ |$$  __$$\\ $$  __$$ |      $$ |  $$ |\n" +
                "$$ |  $$ |      $$  __$$ |$$ |  $$ |$$ /  $$ |      $$ |  $$ |\n" +
                "$$ |  $$ |      $$ |  $$ |$$ |  $$ |$$ |  $$ |      $$ |  $$ |\n" +
                "$$$$$$$  |      $$ |  $$ |$$ |  $$ |\\$$$$$$$ |      $$$$$$$  |\n" +
                "\\_______/       \\__|  \\__|\\__|  \\__| \\_______|      \\_______/ \n");
        System.out.print("Bienvenue dans Donjons et Dragons ! Voulez vous créer un personnage (1) ou quitter le jeu (2) ?");
        return getAnswerInt(this.userInput, 2);

    }

    /**
     * This method handle the whole character creation process, the display and the logic. The logic part should be integrated in the GameCore classe, to divide in a better way the display and the logic between these 2 classes.
     * @return
     */
    public Hero createNewCharacter() {
        System.out.print("Hello l'aventurier, choisis donc la super classe de ouf que tu souhaites jouer : " +
                "\n - 1 Guerrier (gneu taper) " +
                "\n - 2 Magicien (olala la magie)");
        Hero playerClass;
        int result = getAnswerInt(userInput, 2);
        if (result == 1) {

            System.out.println("Veuillez choisir le nom de votre Guerrier(re) :");
            playerClass = new Warrior(userInput.nextLine());
            System.out.println("Longue vie à " + playerClass.getName() + " ! Jeune guerrier aux caracteristiques suivantes : \n" + playerClass);

        } else {
            System.out.println("Veuillez choisir le nom de votre Magicien(ne) :");
            playerClass = new Magician(userInput.nextLine());
            System.out.println("Longue vie à " + playerClass.getName() + " ! Puissant magicien aux caracteristiques suivantes : \n" + playerClass);
        }
        playerClass.toString();
        return playerClass;
    }

    public void defineNewName(Hero hero) {
        System.out.println("Veuillez choisir le nouveau nom de votre personnage :");
        hero.setName(userInput.nextLine());
    }

    /**
     * This method is used every time the user is asked to make a choice between multiple answers. It manage the number of answers possible for each questiosn, and return an error if the int given by the user isn't possible.
     * @param userAnswer This parameter correspond to the int inputed by the user
     * @param choicesNumber The number of choices available for the question
     * @return Return the choice made by the user (integer)
     */
    public int getAnswerInt(Scanner userAnswer, int choicesNumber) {
        int answer;

        do {
            System.out.println("\nFaites votre choix :");
            try {
                answer = userAnswer.nextInt();
                if(answer > 0 && answer <= choicesNumber) {
                    userAnswer.nextLine();
                    return answer;
                }
                System.out.println("Entrée incorrecte, veuillez faire votre choix parmi les " + choicesNumber + " propositions disponibles.");
            } catch (InputMismatchException e) {
                System.out.println("ERREUR : ENTREE INCORRECTE, RECOMMENCEZ");

            }
            userAnswer.nextLine();
        } while (true);
    }

    public void displaySeparator() {
        System.out.println("===================================================================");
    }

    /**
     * This method manage the content displayed every turn to the user.
     * @param counter
     * @param currentPosition
     * @param hero
     */
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

    public void displayDefeatMessage() {
        System.out.println("Souhaitez vous rejouer ? [1] Oui - [2] Non");
    }
}
