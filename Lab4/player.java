import java.util.Scanner;


public class player {
    public String name;
    public char symbol;

    public player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String get_n() {
        return name;
    }

    public char get_s() {
        return symbol;
    }

    public void move(gameboard board) {
        int row = 0;
        int col = 0;  
        System.out.println("Введiть рядок:");
        row = Integer.parseInt(System.console().readLine());
    
        System.out.println("Введiть стовпець:");
        col = Integer.parseInt(System.console().readLine());
    
        if (board.board[row][col] != ' ') {
            System.out.println("Помилка");
            return;
        }
        board.set(row, col, symbol);
    }
}