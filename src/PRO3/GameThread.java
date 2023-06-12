package PRO3;

public class GameThread extends Thread {
    private GameBoard gameBoard;
    private boolean running;

    public GameThread(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
        this.running = true;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(200); // ustalamy szybkość gry na 5 klatek na sekundę
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            gameBoard.updateBoard(); // aktualizujemy stan planszy

            // if (gameBoard.checkCollision()) {
            //     running = false; // jeśli wąż uderzył w ścianę lub w siebie, kończymy grę
            // }
        }
    }

    public void stopRunning() {
        this.running = false;
    }
}

