package PRO1;

public interface IBoardObserver {
    /**
     * Metoda wywoływana, gdy następuje ruch figury na planszy.
     *
     * @param sourceRow Współrzędna wiersza figury przed ruchem.
     * @param sourceCol Współrzędna kolumny figury przed ruchem.
     * @param targetRow Współrzędna wiersza figury po ruchu.
     * @param targetCol Współrzędna kolumny figury po ruchu.
     */
    void onMove(int sourceRow, int sourceCol, int targetRow, int targetCol);

    /**
     * Metoda wywoływana, gdy król zostaje postawiony w szachu.
     *
     * @param kingRow Współrzędna wiersza króla będącego pod szachem.
     * @param kingCol Współrzędna kolumny króla będącego pod szachem.
     */
    void onCheck(int kingRow, int kingCol);

    /**
     * Metoda wywoływana, gdy następuje szach-mat.
     *
     * @param kingRow Współrzędna wiersza króla będącego pod szach-matem.
     * @param kingCol Współrzędna kolumny króla będącego pod szach-matem.
     */
    void onCheckmate(int kingRow, int kingCol);

    /**
     * Metoda wywoływana, gdy następuje zmiana na planszy (np. ruch figury, bicie).
     *
     * @param board Obiekt planszy szachowej, na której nastąpiła zmiana.
     */
    void onBoardChanged(Board board);
}

