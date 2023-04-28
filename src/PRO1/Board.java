package PRO1;


import java.io.*;

public class Board {
    private Figure[][] board;

    public Board() {
        board = new Figure[8][8];
    }

    public Figure getFigure(int row, int col) {
        if (isValidCoordinate(row) && isValidCoordinate(col)) {
            return board[row][col];
        }
        return null;
    }

    public void setFigure(Figure figure, int row, int col) {
        if (isValidCoordinate(row) && isValidCoordinate(col)) {
            board[row][col] = figure;
            if (figure != null) {
                figure.setPosition(row, col);
            }
        }
    }

    private boolean isValidCoordinate(int coord) {
        return coord >= 0 && coord < 8;
    }

    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
        if (!isValidCoordinate(fromRow) || !isValidCoordinate(fromCol) || !isValidCoordinate(toRow) || !isValidCoordinate(toCol)) {
            return false;
        }

        Figure figure = getFigure(fromRow, fromCol);
        if (figure == null) return false;

        Figure targetFigure = getFigure(toRow, toCol);
        if (!(targetFigure == null || figure.isWhite() != targetFigure.isWhite()))
            return false;

        return !isObscured(fromRow, fromCol, toRow, toCol);
    }

    private boolean isObscured(int fromRow, int fromCol, int toRow, int toCol) {
        int rowDirection = Integer.compare(toRow, fromRow);
        int colDirection = Integer.compare(toCol, fromCol);

        int currentRow = fromRow + rowDirection;
        int currentCol = fromCol + colDirection;

        while (currentRow != toRow || currentCol != toCol) {
            try {
                if (board[currentRow][currentCol] != null) {
                    return true;
                }
            } catch (ArrayIndexOutOfBoundsException ignored) {}

            currentRow += rowDirection;
            currentCol += colDirection;
        }

        return false;
    }

    public boolean save(String filePath) {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(filePath))) {
            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    Figure figure = board[row][col];
                    if (figure != null) {
                        int type = figure.getFigureType().getNumeric();
                        int color = figure.getColor().bitColor;
                        int data = type | (col << 3) | (row << 7) | (color << 11);
                        out.writeShort(data);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Błąd zapisu gry! (" + e.getMessage() + ")");
            return false;
        }
        return true;
    }

    public boolean load(String filePath) {
        Figure[][] tempBoard = new Figure[8][8];

        try (DataInputStream in = new DataInputStream(new FileInputStream(filePath))) {
            while (in.available() > 0) {
                int data = in.readShort();
                int type = data & 0b111;
                int col = (data >> 3) & 0b1111;
                int row = (data >> 7) & 0b1111;
                int color = (data >> 11) & 0b1;

                FigureType figureType = FigureType.values()[type];
                Figure figure = Figure.createFigure(figureType, color == 0);

                tempBoard[row][col] = figure;
            }
            board = tempBoard;
            return true;
        } catch (IOException e) {
            System.out.println("Błąd wczytywania gry (" + e.getMessage() + ")");
            return false;
        }
    }

    public void initializeBoard() {
        // Piony
        for (int col = 0; col < 8; col++) {
            setFigure(new Pawn(false), 1, col);
            setFigure(new Pawn(true), 6, col);
        }

        // Wieże
        setFigure(new Rook(false), 0, 0);
        setFigure(new Rook(false), 0, 7);
        setFigure(new Rook(true), 7, 0);
        setFigure(new Rook(true), 7, 7);

        // Skoczki
        setFigure(new Knight(false), 0, 1);
        setFigure(new Knight(false), 0, 6);
        setFigure(new Knight(true), 7, 1);
        setFigure(new Knight(true), 7, 6);

        // Gońce
        setFigure(new Bishop(false), 0, 2);
        setFigure(new Bishop(false), 0, 5);
        setFigure(new Bishop(true), 7, 2);
        setFigure(new Bishop(true), 7, 5);

        // Hetmany
        setFigure(new Queen(false), 0, 3);
        setFigure(new Queen(true), 7, 3);

        // Królowie
        setFigure(new King(false), 0, 4);
        setFigure(new King(true), 7, 4);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("  A B C D E F G H\n");
        for (int row = 0; row < 8; row++) {
            sb.append(8 - row).append(" ");
            for (int col = 0; col < 8; col++) {
                Figure figure = getFigure(row, col);
                if (figure == null) {
                    sb.append(".");
                } else {
                    sb.append(figure.getSymbol());
                }
                sb.append(" ");
            }
            sb.append(8 - row).append("\n");
        }
        sb.append("  A B C D E F G H\n");
        return sb.toString();
    }
}
