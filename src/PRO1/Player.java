package PRO1;

import java.util.List;

public class Player {
    private final boolean isWhite;
    private final String name;
    public Color color;

    public Player(boolean isWhite, String name) {
        this.isWhite = isWhite;
        this.color = (isWhite) ? Color.WHITE : Color.BLACK;
        this.name = name;
    }

    public String getName() {
        return name + color.toString();
    }

    public boolean movePiece(Board board, int fromRow, int fromCol, int toRow, int toCol) {
        Figure figure = board.getFigure(fromRow, fromCol);

        if (figure == null || figure.isWhite() != isWhite) {
            return false;
        }

        List<int[]> possibleMoves = figure.getPossibleMoves(board);
        for (int[] move : possibleMoves) {
            if (move[0] == toRow && move[1] == toCol) {
                Figure capturedFigure = board.getFigure(toRow, toCol);

                // Wykonaj tymczasowy ruch
                board.setFigure(figure, toRow, toCol);
                board.setFigure(null, fromRow, fromCol);

                // Sprawdź, czy ruch powoduje szach dla własnego króla
                if (isKingInCheck(board)) {
                    // Jeśli tak, cofnij ruch i zwróć false
                    board.setFigure(figure, fromRow, fromCol);
                    board.setFigure(capturedFigure, toRow, toCol);
                    return false;
                }

                // Sprawdź promocję piona
                if (figure instanceof Pawn && (toRow == 0 || toRow == 7)) {
                    Queen promotedPawn = new Queen(toCol, toRow, figure.isWhite());
                    board.setFigure(promotedPawn, toRow, toCol);
                }

                return true;
            }
        }
        return false;
    }

    public boolean isKingInCheck(Board board) {
        int kingRow = -1;
        int kingCol = -1;

        // Znajdź współrzędne króla
        outerLoop:
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Figure figure = board.getFigure(row, col);
                if (figure instanceof King && figure.isWhite() == isWhite) {
                    kingRow = row;
                    kingCol = col;
                    break outerLoop;
                }
            }
        }

        // Sprawdź, czy którykolwiek z przeciwników może zaatakować króla
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Figure figure = board.getFigure(row, col);
                if (figure != null && figure.isWhite() != isWhite) {
                    List<int[]> possibleMoves = figure.getPossibleMoves(board);
                    for (int[] move : possibleMoves) {
                        if (move[0] == kingRow && move[1] == kingCol) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public boolean isKingInCheckmate(Board board) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Figure figure = board.getFigure(row, col);
                if (figure != null && figure.isWhite() == isWhite) {
                    List<int[]> possibleMoves = figure.getPossibleMoves(board);
                    for (int[] move : possibleMoves) {
                        // Wykonaj tymczasowy ruch
                        Figure capturedFigure = board.getFigure(move[0], move[1]);
                        board.setFigure(figure, move[0], move[1]);
                        board.setFigure(null, row, col);

                        // Sprawdź, czy król jest wciąż w szachu
                        boolean kingInCheck = isKingInCheck(board);

                        // Cofnij tymczasowy ruch
                        board.setFigure(figure, row, col);
                        board.setFigure(capturedFigure, move[0], move[1]);

                        if (!kingInCheck) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}


