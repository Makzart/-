import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        main objMain = new main();
        objMain.game();
    }

    public static boolean full(gameboard game_board) {
        char[][] board = game_board.get_b();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false; 
                }
            }
        }
        return true; 
    }

    public void game() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Iм'я гравця 1 (Х): ");
        String nameX = scanner.nextLine();
        player playerX = new player(nameX, 'X');

        System.out.print("Iм'я гравця 2 (O): ");
        String nameO = scanner.nextLine();
        player playerO = new player(nameO, 'O');

        gameboard game_board = new gameboard();
        boolean gameOver = false;
        player currentPlayer = playerX;

        System.out.println("Починаємо гру!");

         while (!gameOver) {
            currentPlayer.info();
            game_board.display();

            int[] move = currentPlayer.move();
            if (game_board.move(move[0], move[1], currentPlayer.symbol)) {
                if (game_board.win(currentPlayer.symbol)) {
                    game_board.display();
                    System.out.println("Перемога " + currentPlayer.name + " !");
                    gameOver = true;
                } else if (full(game_board)) {
                    game_board.display();
                    System.out.println("Гра закiнчилася в нiчию!");
                    gameOver = true;
                } else {
                    currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
                }
            } else {
                System.out.println("Невiрний хiд. Спробуйте ще раз.");
            }
        }
    }
}