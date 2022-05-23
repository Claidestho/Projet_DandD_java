package menu;

import heros.Hero;
import heros.Magician;
import heros.Warrior;
import system.database.DatabaseConnection;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class will hold all the display of the game. All the interactions with the user will be put here and not in the GameCore.
 */
public class MainMenu {
    private Scanner userInput;
    private DatabaseConnection db = new DatabaseConnection();

    /**
     * This constructor will define the Scanner attribute used to receive users inputs.
     */
    public MainMenu() {
        this.userInput = new Scanner(System.in);
    }

    /**
     * The method that launch the first menu
     *
     * @return false return to make if/else works
     */
    public Hero startMenu() {
        int wantsToPlay = displayWelcomeMessage();
        if (wantsToPlay == 1) {
            return createNewCharacter();

        } else {
            System.exit(0);
            return new Warrior();
        }

    }

    /**
     * This method display the logo of the game and receive user input
     *
     * @return
     */
    public int displayWelcomeMessage() {
        System.out.println(" /$$$$$$$                                                                               /$$$$$$                  /$$       /$$$$$$$                                                            \n" +
                "| $$__  $$                                                                             /$$__  $$                | $$      | $$__  $$                                                           \n" +
                "| $$  \\ $$ /$$   /$$ /$$$$$$$   /$$$$$$   /$$$$$$   /$$$$$$  /$$$$$$$   /$$$$$$$      | $$  \\ $$ /$$$$$$$   /$$$$$$$      | $$  \\ $$  /$$$$$$  /$$$$$$   /$$$$$$   /$$$$$$  /$$$$$$$   /$$$$$$$\n" +
                "| $$  | $$| $$  | $$| $$__  $$ /$$__  $$ /$$__  $$ /$$__  $$| $$__  $$ /$$_____/      | $$$$$$$$| $$__  $$ /$$__  $$      | $$  | $$ /$$__  $$|____  $$ /$$__  $$ /$$__  $$| $$__  $$ /$$_____/\n" +
                "| $$  | $$| $$  | $$| $$  \\ $$| $$  \\ $$| $$$$$$$$| $$  \\ $$| $$  \\ $$|  $$$$$$       | $$__  $$| $$  \\ $$| $$  | $$      | $$  | $$| $$  \\__/ /$$$$$$$| $$  \\ $$| $$  \\ $$| $$  \\ $$|  $$$$$$ \n" +
                "| $$  | $$| $$  | $$| $$  | $$| $$  | $$| $$_____/| $$  | $$| $$  | $$ \\____  $$      | $$  | $$| $$  | $$| $$  | $$      | $$  | $$| $$      /$$__  $$| $$  | $$| $$  | $$| $$  | $$ \\____  $$\n" +
                "| $$$$$$$/|  $$$$$$/| $$  | $$|  $$$$$$$|  $$$$$$$|  $$$$$$/| $$  | $$ /$$$$$$$/      | $$  | $$| $$  | $$|  $$$$$$$      | $$$$$$$/| $$     |  $$$$$$$|  $$$$$$$|  $$$$$$/| $$  | $$ /$$$$$$$/\n" +
                "|_______/  \\______/ |__/  |__/ \\____  $$ \\_______/ \\______/ |__/  |__/|_______/       |__/  |__/|__/  |__/ \\_______/      |_______/ |__/      \\_______/ \\____  $$ \\______/ |__/  |__/|_______/ \n" +
                "                               /$$  \\ $$                                                                                                                /$$  \\ $$                              \n" +
                "                              |  $$$$$$/                                                                                                               |  $$$$$$/                              \n" +
                "                               \\______/                                                                                                                 \\______/                               \n" +
                "\n ");
        System.out.print("Bienvenue dans Donjons et Dragons ! Voulez vous créer un personnage (1) , voir la liste des personnages (2) ou quitter le jeu (3) ?");
        return getAnswerInt(this.userInput, 2);

    }

    /**
     * This method handle the whole character creation process, the display and the logic. The logic part should be integrated in the GameCore classe, to divide in a better way the display and the logic between these 2 classes.
     *
     * @return Return the Hero with the specialized type chosen by the user
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
            System.out.println("                           __.--|~|--.__            Randall            ,,;/;\n" +
                    "                         /~     | |    ;~\\          Nortman         ,;;;/;;'\n" +
                    "                        /|      | |    ;~\\\\                      ,;;;;/;;;'\n" +
                    "                       |/|      \\_/   ;;;|\\                    ,;;;;/;;;;'\n" +
                    "                       |/ \\          ;;;/  )                 ,;;;;/;;;;;'\n" +
                    "                   ___ | ______     ;_____ |___....__      ,;;;;/;;;;;'\n" +
                    "             ___.-~ \\\\(| \\  \\.\\ \\__/ /./ /:|)~   ~   \\   ,;;;;/;;;;;'\n" +
                    "         /~~~    ~\\    |  ~-.     |   .-~: |//  _.-~~--,;;;;/;;;;;'\n" +
                    "        (.-~___     \\.'|    | /-.__.-\\|::::| //~     ,;;;;/;;;;;'\n" +
                    "        /      ~~--._ \\|   /          `\\:: |/      ,;;;;/;;;;;'\n" +
                    "     .-|             ~~|   |  /V\"\"\"\"V\\ |:  |     ,;;;;/;;;;;' \\\n" +
                    "    /                   \\  |  ~`^~~^'~ |  /    ,;;;;/;;;;;'    ;\n" +
                    "   (        \\             \\|`\\._____./'|/    ,;;;;/;;;;;'      '\\\n" +
                    "  / \\        \\                             ,;;;;/;;;;;'     /    |\n" +
                    " |            |                          ,;;;;/;;;;;'      |     |\n" +
                    "|`-._          |                       ,;;;;/;;;;;'              \\\n" +
                    "|             /                      ,;;;;/;;;;;'  \\              \\__________\n" +
                    "(             )                 |  ,;;;;/;;;;;'      |        _.--~\n" +
                    " \\          \\/ \\              ,  ;;;;;/;;;;;'       /(     .-~_..--~~~~~~~~~~\n" +
                    " \\__         '  `       ,     ,;;;;;/;;;;;'    .   /  \\   / /~\n" +
                    " /          \\'  |`._______ ,;;;;;;/;;;;;;'    /   :    \\/'/'       /|_/|   ``|\n" +
                    "| _.-~~~~-._ |   \\ __   .,;;;;;;/;;;;;;' ~~~~'   .'    | |       /~ (/\\/    ||\n" +
                    "/~ _.-~~~-._\\    /~/   ;;;;;;;/;;;;;;;'          |    | |       / ~/_-'|-   /|\n" +
                    "(/~         \\| /' |   ;;;;;;/;;;;;;;;            ;   | |       (.-~;  /-   / |\n" +
                    "|            /___ `-,;;;;;/;;;;;;;;'            |   | |      ,/)  /  /-   /  |\n" +
                    " \\            \\  `-.`---/;;;;;;;;;' |          _'   |T|    /'('  /  /|- _/  //\n" +
                    "   \\           /~~/ `-. |;;;;;''    ______.--~~ ~\\  |u|  ,~)')  /   | \\~-==//\n" +
                    "     \\      /~(   `-\\  `-.`-;   /|    ))   __-####\\ |a|   (,   /|    |  \\\n" +
                    "       \\  /~.  `-.   `-.( `-.`~~ /##############'~~)| |   '   / |    |   ~\\\n" +
                    "        \\(   \\    `-._ /~)_/|  /############'       |X|      /  \\     \\_\\  `\\\n" +
                    "        ,~`\\  `-._  / )#####|/############'   /     |i|  _--~ _/ | .-~~____--'\n" +
                    "       ,'\\  `-._  ~)~~ `################'           |o| ((~>/~   \\ (((' -_\n" +
                    "     ,'   `-.___)~~      `#############             |n|           ~-_     ~\\_\n" +
                    " _.,'        ,'           `###########              |g|            _-~-__    (\n" +
                    "|  `-.     ,'              `#########       \\       | |          ((.-~~~-~_--~\n" +
                    "`\\    `-.;'                  `#####\"                | |           \"     ((.-~~\n" +
                    "  `-._   )               \\     |   |        .       |  \\                 \"\n" +
                    "      `~~  _/                  |    \\               |   `---------------------\n" +
                    "        |/~                `.  |     \\        .     |  O    __.---------------\n" +
                    "         |                   \\ ;      \\             |   _.-~\n" +
                    "         |                    |        |            |  /  |\n" +
                    "          |                   |         |           |/'  |Tua Xiong");

        } else {
            System.out.println("Veuillez choisir le nom de votre Magicien(ne) :");
            playerClass = new Magician(userInput.nextLine());
            System.out.println("Longue vie à " + playerClass.getName() + " ! Puissant magicien aux caracteristiques suivantes : \n" + playerClass);
            System.out.println("                             /\\\n" +
                    "                            /  \\\n" +
                    "                           |    |\n" +
                    "                         --:'''':--\n" +
                    "                           :'_' :\n" +
                    "                           _:\"\":\\___\n" +
                    "            ' '      ____.' :::     '._\n" +
                    "           . *=====<<=)           \\    :\n" +
                    "            .  '      '-'-'\\_      /'._.'\n" +
                    "                             \\====:_ \"\"\n" +
                    "                            .'     \\\\\n" +
                    "                           :       :\n" +
                    "                          /   :    \\\n" +
                    "                         :   .      '.\n" +
                    "         ,. _        snd :  : :      :\n" +
                    "      '-'    ).          :__:-:__.;--'\n" +
                    "    (        '  )        '-'   '-'\n" +
                    " ( -   .00.   - _\n" +
                    "(    .'  _ )     )\n" +
                    "'-  ()_.\\,\\,   -");
        }
        try {
            PreparedStatement query = db.connectDB().prepareStatement("INSERT INTO hero(type, name, health_points, attack_points) VALUE(?,?,?,?)");
        query.setString(1, playerClass.getClass().getSimpleName());
        query.setString(2, playerClass.getName());
        query.setInt(3, playerClass.getHealthPoints());
        query.setInt(4, playerClass.getAttackPoints());
        query.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

//        db.updateDB("INSERT INTO hero(type, name, health_points, attack_points) VALUE ('" + playerClass.getClass().getSimpleName() + "','" + playerClass.getName() + "','" + playerClass.getHealthPoints() + "'," + playerClass.getAttackPoints() + ")");
        return playerClass;
    }

    /**
     * This method permit to rename the hero during the game
     *
     * @param hero -> Player character
     */
    public void defineNewName(Hero hero) {
        System.out.println("Veuillez choisir le nouveau nom de votre personnage :");
        hero.setName(userInput.nextLine());
    }

    /**
     * This method is used every time the user is asked to make a choice between multiple answers. It manage the number of answers possible for each questiosn, and return an error if the int given by the user isn't possible.
     *
     * @param userAnswer    This parameter correspond to the int inputed by the user
     * @param choicesNumber The number of choices available for the question
     * @return Return the choice made by the user (integer)
     */
    public int getAnswerInt(Scanner userAnswer, int choicesNumber) {
        int answer;

        do {
            System.out.println("\nFaites votre choix :");
            try {
                answer = userAnswer.nextInt();
                if (answer > 0 && answer <= choicesNumber) {
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

    /**
     * Display a simple separator
     */

    public void displaySeparator() {
        System.out.println("===================================================================");
    }

    /**
     * This method manage the content displayed every turn to the user.
     *
     * @param counter
     * @param currentPosition
     * @param hero
     */
    public void turnStart(int counter, int currentPosition, Hero hero) {
        this.displaySeparator();
        System.out.println("TOUR " + counter);
        System.out.println("Votre position : Case " + (currentPosition + 1));
        System.out.println("[1] Lancer les dés - [2] Afficher les statistiques de " + hero.getName() + " - [3] Renommer le héros (" + hero.getName() + ") - [4] Quitter la partie ");
        this.displaySeparator();
    }

    /**
     * Message to be displayed in case of a win
     */
    public void displayWinMessage() {
        this.displaySeparator();
        System.out.println("👌👌👌👌 BRAVO CEST TRES LA VICTOIRE HIHI 👌👌👌👌");
        this.displaySeparator();
    }

    /**
     * Message to be displayed in case of a loss
     */
    public void displayDefeatMessage() {
        System.out.println("Souhaitez vous rejouer ? [1] Oui - [2] Non");
    }
}
