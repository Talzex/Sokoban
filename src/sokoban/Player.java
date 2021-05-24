package sokoban;

import sokoban.Database.Database;
import sokoban.Board.Position;
import sokoban.Board.Direction;
import sokoban.Board.Board;
import sokoban.Builder.BuilderException;
import java.util.Scanner;

/**
 *
 * @author tduthil
 */
public class Player {

    static Scanner in = new Scanner(System.in);
    static Database db = new Database();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        play();
    }

    /**
     * Méthode permettant de lancer une partie
     */
    public static void play() {
        try {
            db.listerBoards();
            System.out.println("Avec quel board souhaitez-vous jouer ?");
            int afficherid = Integer.parseInt(in.nextLine());
            System.out.println();
            Board b = db.get(afficherid);
            boolean win;
            dessinerPlateau(b);
            do {
                EffectuerMouvement(b);
                b.dessinerLigne();
                b.dessinerContenu();
                win = VerifVictoire(b);
                System.out.println("Position Joueur : (" + b.joueur.row + "," + b.joueur.col + ")");
            } while (!win);
            System.out.println("Partie Terminé");
        } catch (BuilderException | NullPointerException e) {}
        
    }
    /**
     * Dessine le plateau 
     * @param b, le Board
     */
     static void dessinerPlateau(Board b) {

        b.dessinerLigne();
        b.dessinerContenu();
    }


    /**
     * Méthode permettant d'effectuer un mouvement selon une Direction donnée
     * @param b, le Board
     */
     static void EffectuerMouvement(Board b) {
        System.out.println("> Quelle série de mouvements voulez-vous effectuer ? U,D,L,R ");
        String coupSaisi = LireSaisieMouvement(b).toUpperCase().trim();
        for (int i = 0; i < coupSaisi.length(); i++) {
            switch (coupSaisi.charAt(i)) {
                case 'U':Deplacement(b, Direction.NORD);break;
                case 'D':Deplacement(b, Direction.SUD);break;
                case 'L':Deplacement(b, Direction.OUEST);break;
                case 'R':Deplacement(b, Direction.EST);break;
                case 'Q':System.out.println("> Vous avez quitté la partie");System.exit(0);break;
                default:System.out.println("Saisie Incorrecte");
            }
        }
    }
     
     /**
     * Méthode permettant de lire le choix du joueur.
     *
     * @param b, Board sur lequelle on joue
     * @return la Position choisit
     */
     private static String LireSaisieMouvement(Board b) {
        String coupSaisi = in .nextLine();
        return coupSaisi;
    }

    /**
     * Méthode effectuant le déplacement selon des conditions
     * @param b, le Board
     * @param d, la Direction souhaitée
     */
     static void Deplacement(Board b, Direction d) {
        Position nextP = new Position(b.joueur.row + d.mvtVertical(), b.joueur.col + d.mvtHorizontal());
        Position nextP2 = nextP;
        if (!CollisionMur(b, nextP) && b.DansBoard(nextP)) {
            if (CollisionCaisse(b, nextP)) {
                BougerCaisse(b, nextP, nextP2, d);
            } else {
                b.joueur.row += d.mvtVertical();
                b.joueur.col += d.mvtHorizontal();
            }
        }
    }
    /**
     * Méthode effectuant le déplacement des caisses
     * @param b, le Board
     * @param p, la future position du joueur, celle avant d'appliqué le mouvement souhaité
     * @param p2, la position venant après p
     * @param d, la Direction souhaitée
     */
     static void BougerCaisse(Board b, Position p, Position p2, Direction d) {
        do {
            p2 = new Position(p2.row + d.mvtVertical(), p2.col + d.mvtHorizontal());
        } while (CollisionCaisse(b, p2));
        if (!CollisionMur(b, p2) && b.DansBoard(p2)) {
            b.caisse.remove(p);
            b.caisse.add(p2);
            b.joueur.row += d.mvtVertical();
            b.joueur.col += d.mvtHorizontal();
        }
    }

    /**
     * Méthode permettant de savoir s'il y a un mur à la position p
     * @param b, le Board
     * @param p, la Position
     * @return true ssi il y un mur, faux sinon
     */
     static boolean CollisionMur(Board b, Position p) {
        boolean mur = false;
        if (b.mur.contains(p)) {
            mur = true;
        }
        return mur;
    }

    /**
     * Méthode permettant de savoir s'il y a une caisse à la position p
     * @param b, le Board
     * @param p, la Position
     * @return true ssi il y une caisse, faux sinon
     */
     static boolean CollisionCaisse(Board b, Position p) {
        boolean caisse = false;
        if (b.caisse.contains(p)) {
            caisse = true;
        }
        return caisse;
    }

    /**
     * Méthode permettant de savoir si la partie est gagnée
     * 
     * @param b, Board sur lequelle on joue
     * @return true si les caisses sur les cibles, faux sinon
     */
     static boolean VerifVictoire(Board b) {
        return b.cibles.equals(b.caisse);
    }
}
