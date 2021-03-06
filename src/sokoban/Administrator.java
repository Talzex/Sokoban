package sokoban;

import sokoban.Databases.Database;
import sokoban.Boards.Board;
import sokoban.Builders.FileBoardBuilder;
import sokoban.Builders.BuilderException;
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author tduthil
 */
public class Administrator {

    static Scanner entree = new Scanner(System.in);
    static Database db = new Database();

    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args){
        boolean encore = true;
        while (encore) {
            System.out.println("ADMINISTRATION INTERFACE - USE WITH CAUTION");
            System.out.println();
            System.out.println("1. Create new database");
            System.out.println("2. List boards");
            System.out.println("3. Show board");
            System.out.println("4. Add board from file");
            System.out.println("5. Remove board from database [DANGEROUS]");
            System.out.println("6. Remove database [DANGEROUS]");
            System.out.println("7. Quit.");
            System.out.println("Votre choix ?");

            String commande = entree.nextLine();
            System.out.println();

            switch (commande) {
                case "1":db.creerDB(); break;
                case "2":db.listerBoards();break;
                case "3":show();break;
                case "4":add();break;
                case "5":remove();break;
                case "6":db.supprimerDB();break;
                case "7":encore = false;break;
                case "":break;
                default:System.out.println("commande inconnue : " + commande);
            }
        }
    }

    /**
     * Ajoute un fichier à la base
     */
    private static void add() {
        try {
            File file = listerFichier();
            Board b = FiletoBoard(file);
            db.ajouterBoard(b);
        } catch (BuilderException ex) {}
    }
    /**
     * Affiche le Board
     */
    public static void show(){
        try { 
        db.listerBoards();
        System.out.println("Quel Boards souhaitez-vous afficher ?");
        int afficherid = Integer.parseInt(entree.nextLine());
        System.out.println();
        Board b = db.get(afficherid);
        b.dessinerLigne();
        b.dessinerContenu(); 
        } catch (BuilderException | NullPointerException ex){}
    }
    
    /**
     * Enleve un fichier de la base
     */
    private static void remove(){
        db.listerBoards();
        System.out.println("Quel Boards souhaitez-vous supprimer ?");
        int suppid = Integer.parseInt(entree.nextLine());
        System.out.println();
        db.enleverBoard(suppid);
    }
    /**
     * Méthode permettant de faire appel aux différentes méthodes
     * pour convertir un fichier texte en Board.
     * @param file, le Fichier
     * @return b, le Board
     * @throws BuilderException
     */
    private static Board FiletoBoard(File file) throws BuilderException{
        var filebuilder = new FileBoardBuilder(file.getPath(),file.getName());
        Board b = filebuilder.build();
        b.RemplirTableau();
        return b;
    }
    /**
     * Méthode permettant de lister les différents fichiers texte
     * @return liste[fichier], le fichier choisi par le joueur 
     */
    private static File listerFichier() {
        File dir = new File(".\\data");
        File[] liste = dir.listFiles();
        for (int i = 0; i < liste.length; i++) {
            if (liste[i].isFile()) {
                System.out.format(i + " - %s%n", liste[i].getName());
            } 
        }
        System.out.println("Quel fichier souhaitez-vous ajouter ?");
        int fichier = Integer.parseInt(entree.nextLine());
        return liste[fichier];
    }
}
