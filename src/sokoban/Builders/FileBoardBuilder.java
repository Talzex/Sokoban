package sokoban.Builders;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import sokoban.Boards.Board;

/**
 *
 * @author tduthil
 */
public class FileBoardBuilder implements Builder {

    final String chemin;
    final String name;

    public FileBoardBuilder(String chemin, String name) {
        this.chemin = chemin;
        this.name = name;
    }

    /**
     * Méthode permettant de produire un Board à partir d'un fichier texte
     * @return un Board
     * @throws BuilderException
     */
    @Override
    public Board build() throws BuilderException {
        Board b = null;
        try ( Scanner scanner = new Scanner(new File(chemin))) {

            TextBoardBuilder board = new TextBoardBuilder(name);
            while (scanner.hasNextLine()) {
                board.addRow(scanner.nextLine().trim());
            }
            b = board.build();
        } catch (FileNotFoundException ex) {
            throw new BuilderException("Fichier non trouvé");
        }
        return b;
    }
}
