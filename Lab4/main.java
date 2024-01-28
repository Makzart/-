import java.util.Scanner;
import java.sql.*;

public class main {

    Connection con;
    public void Db() {
        String dbUrl = "jdbc:mysql://localhost:3306/mygame?allowPublicKeyRetrieval=true&useSSL=false";
        String user = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbUrl, user, password);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void close() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean reg() {
        
        String username, password;
        System.out.print("Будь ласка зареєструйтеся\n");
        System.out.print("Логiн: ");
        username = System.console().readLine();
        System.out.print("Пароль: ");
        password = System.console().readLine();
        try {
              Statement stmt = con.createStatement();
                //ResultSet rs = stmt.executeQuery(
                    //"SELECT count(*) FROM users WHERE username='" + username + "' and password='" + password + "';");
                ResultSet rs1 = stmt.executeQuery(
                    "SELECT count(*) FROM users WHERE username='" + username + "';");   
            while (rs1.next())
                if (rs1.getInt(1) == 1) {
                    return false;
                } 
                else
                {
                    String sql = " insert into users (username, password)" + " values (?, ?)";
                    PreparedStatement preparedStmt = con.prepareStatement(sql);
                    preparedStmt.setString(1, username);
                    preparedStmt.setString(2, password);
                    preparedStmt.execute();
                    System.out.print("Реєстрацiя успiшна!\n");
                }
            }
        catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public boolean login() {
        String username, password;
        System.out.print("Будь ласка авторизуйтеся\n");
        System.out.print("Логiн: ");
        username = System.console().readLine();
        System.out.print("Пароль: ");
        password = System.console().readLine();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT count(*) FROM users WHERE username='" + username + "' and password='" + password + "';");
            while (rs.next())
                if (rs.getInt(1) == 1) {
                    return true;
                } else
                    return false;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public void auto() {
        System.out.print("Зареєструйтеся або авторизуйтеся(1 або 2): ");
        String auto_ = System.console().readLine();
        if (auto_.equals("1")) {
            if (reg()) {
                System.out.print("Користувач уже iснує, i ви ввiйшли!\n");
            } else {
                System.out.print("Помилка реєстрацii. Повторiть кроки!\n");
                reg();
            }
        } else if (auto_.equals("2")) {
                if(!login()){
                    System.out.print("Недiйснi данi, спробуйте ще раз: ");
                    login();
                }
        }

    }

    public void game(gameboard board, player playerx, player playero) {
        board.display();
        while (!board.win(playerx.get_s()) && !board.win(playero.get_s())) {

            System.out.println("Ходить гравець Х:");
            playerx.move(board);
            board.display();
            if (board.win(playerx.get_s())) {
                break;
            }
            System.out.println("Ходить гравець O:");
            playero.move(board);
            board.display();
        }

        if (board.win(playerx.get_s())) {
            System.out.println("Перемiг гравець Х!");
        } else {
            System.out.println("Перемiг гравець О!");
        }
    }
    public static void main(String[] args) {
        gameboard board = new gameboard();
        player playerx = new player("Хрестик", 'X');
        player playero = new player("Нулик", 'O');
        main GameObj = new main();
        GameObj.Db();
        GameObj.auto();
        GameObj.game(board, playerx, playero);
        GameObj.close();
    }

}