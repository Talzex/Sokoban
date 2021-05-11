/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

/**
 *
 * @author tduthil
 */
public class TextBoardBuilder implements Builder {

    String nom;
    String niveau = "";
    int colonne = 0;
    int ligne = 0;

    TextBoardBuilder(String name) {
        this.nom = name;
    }

    void addRow(String row) {
        ligne++;
        colonne = row.length();
        niveau = niveau.concat(row);
    }

    @Override
    public Board build() throws BuilderException {
        int o = 0;
        Board b = new Board(nom, ligne, colonne);
        for (int u = 0; u < ligne; u++) {
            for (int i = 0; i < colonne; i++) {
                char item = niveau.charAt(o);
                switch (item) {
                    case '#':
                        b.mur.add(new Position(u, i));
                        break;
                    case 'C':
                        b.caisse.add(new Position(u, i));
                        break;
                    case 'P':
                        b.joueur = new Position(u, i);
                        break;
                    case 'x':
                        b.cibles.add(new Position(u, i));
                        break;
                }
                o++;
            }
        }
        return b;
    }

}
