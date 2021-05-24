package sokoban.Boards;

/**
 *
 * @author tduthil
 */
public enum Direction {
    NORD,
    SUD,
    EST,
    OUEST;

    /**
     * Retourne le mouvement vertical correspondant à la direction appelant la méthode
     * @return le mouvement vertical correspondant à la direction
     */
    public int mvtVertical() {
        int mvt = 0;
        switch (this) {
            case NORD:
                mvt = -1;
                break;
            case SUD:
                mvt = 1;
                break;
        }
        return mvt;
    }
    /**
     * Retourne le mouvement horizontal correspondant à la direction appelant la méthode
     * @return le mouvement vertical correspondant à la direction
     */
    public int mvtHorizontal() {
        int mvt = 0;
        switch (this) {
            case EST:
                mvt = 1;
                break;
            case OUEST:
                mvt = -1;
                break;
        }
        return mvt;
    }
}

