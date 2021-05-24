package sokoban.Builder;
import sokoban.Board.Board;
/**
 *
 * @author tduthil
 */
public interface Builder {
    Board build() throws BuilderException ;
}
