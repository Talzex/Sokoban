/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author tduthil
 */
public class FileBoardBuilder implements Builder {

    final String chemin;
    String ligne;

    public FileBoardBuilder(String chemin) {
        this.chemin = chemin;
    }

    @Override
    public Board build() throws BuilderException {
        Board b = null;
        try ( Scanner scanner = new Scanner(new File(chemin))) {

            TextBoardBuilder board = new TextBoardBuilder("File Builder");
            while (scanner.hasNextLine()) {
                board.addRow(scanner.nextLine());
            }
            b = board.build();
        } catch (FileNotFoundException ex) {
            throw new BuilderException("Fichier non trouvé");
        }
        return b;
    }
}
