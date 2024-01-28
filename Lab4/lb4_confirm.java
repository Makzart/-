import java.sql.*;

public class lb4_confirm {
    public static void main(String[] args) {
        lb4_confirm obj = new lb4_confirm();
        obj.Db();
        obj.isUserExists("Maks");
        obj.close();

    }
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

    public boolean isUserExists(String username) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT count(*) FROM users WHERE username='" + username + "';");
            while (rs.next())
                if (rs.getInt(1) == 1) {
                    System.out.println("Yes");
                    return true;
                } else
                    return false;
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }
}