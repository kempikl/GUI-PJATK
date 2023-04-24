package PRO1;

public interface GameObserver {
    /**
     * Metoda wywoływana, gdy król zostaje postawiony w szachu.
     */
    void onCheck();

    /**
     * Metoda wywoływana, gdy następuje szach-mat.
     *
     * @param winnerName Nazwa gracza - zwycięzcy
     */
    void onCheckmate(String winnerName);

    /**
     * Metoda wywoływana, gdy następuje zmiana na planszy (np. ruch figury, bicie).
     *
     * @param currentPlayerName Nazwa bieżącego gracza
     */
    void gameChanged(String currentPlayerName);
}

