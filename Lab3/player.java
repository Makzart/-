import java.util.Scanner;


public class player {
    public String name;
    public char symbol;

    public player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public int[] move() {
        int[] move = new int[2];
        Scanner scan = new Scanner(System.in);

        System.out.println(name + ", введiть номер рядка (0, 1, 2): ");
        move[0] = scan.nextInt();

        System.out.println(name + ", введiть номер стовпця (0, 1, 2): ");
        move[1] = scan.nextInt();

        return move;
    }

    public void info() {
        System.out.println("Гравець: " + name);
        System.out.println("Символ: " + symbol);
    } 
}