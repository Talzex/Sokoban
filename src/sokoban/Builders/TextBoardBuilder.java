package sokoban.Builders;
import sokoban.Boards.Board;
import sokoban.Boards.Position;

/**
 *
 * @author tduthil
 */
public class TextBoardBuilder implements Builder {

    String nom;
    String niveau = "";
    int colonne = 0 ;
    int ligne = 0;

    public TextBoardBuilder(String name) {
        this.nom = name;
    }
    
    /**
     * Méthode determinant le nombre de ligne et de colonne de notre future Board
     * en concatenant toutes les lignes en une seule.
     * @param row
     */
    public void addRow(String row) {
        ligne++;
        colonne = row.length();
        niveau = niveau.concat(row);
    }

    /**
     * Méthode permettant de produire un Board à partir d'une chaîne de caractère
     * @return un Board
     * @throws BuilderException
     */
    @Override
    public Board build() throws BuilderException {
        int o = 0;
        Board b = new Board(nom, ligne, colonne);
        try {
            for (int u = 0; u < ligne; u++) {
                for (int i = 0; i < colonne; i++) {
                    char item = niveau.charAt(o);
                    switch (item) {
                        case '#':b.mur.add(new Position(u, i));break;
                        case 'C':b.caisse.add(new Position(u, i));break;
                        case 'P':b.joueur = new Position(u, i);break;
                        case 'x':b.cibles.add(new Position(u, i));break;
                    }
                    o++;
                }
            }
            if(b.caisse.size() != b.cibles.size()){
                throw new BuilderException("Il n'y a pas le même nombre de caisses et de cibles");
            }
            
            if(b.joueur == null){
                throw new BuilderException("Il n'y a pas de joueur");
            }
            
            if(b.caisse.isEmpty() || b.cibles.isEmpty()){
                throw new BuilderException("Element de jeu manquant");
            }
        } catch (StringIndexOutOfBoundsException e) {
            throw new BuilderException("Toute les lignes n'ont pas la même longueur");
        }
        return b;
    }
}
