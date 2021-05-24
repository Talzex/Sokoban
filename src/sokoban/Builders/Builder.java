package sokoban.Builders;
import sokoban.Boards.Board;
/**
 *
 * @author tduthil
 */
public interface Builder {
    Board build() throws BuilderException ;
}
