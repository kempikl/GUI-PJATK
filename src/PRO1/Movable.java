package PRO1;

import java.util.List;

public interface Movable {
    /**
     * Zwraca listę dozwolonych ruchów dla danej figury.
     *
     * @param board Aktualna plansza do gry.
     * @return Lista dozwolonych ruchów, gdzie każdy ruch jest reprezentowany przez parę współrzędnych (row, col).
     */
    List<int[]> getPossibleMoves(Board board);
}

