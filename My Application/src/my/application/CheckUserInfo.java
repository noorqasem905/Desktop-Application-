package my.applivation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.Alert;

/**
 *
 * @author Hp
 */
public class CheckUserInfo {

    private String userEmail  = null;
    MyApplivation login;
    private String name, pass;
    private boolean pa = false;
    boolean enter = false;

    public CheckUserInfo(String name, String pass) {
        checkUSername(name, pass);

    }

    boolean getStatus() {
        return enter;
    }

    String getuserEmail() {
        return userEmail;
    }

    private boolean checkUSername(String usernamet1, String passwordt2) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userform", "root", "");
            Statement st = con.createStatement();
            
            
            ResultSet result = st.executeQuery("SELECT * FROM USERS");
            String userName = null;
            userEmail = null;
            String userPassword = null;
            boolean b = false;
            while (result.next()) {
                userEmail = result.getString("email");
                userPassword = result.getString("password");
                if (userEmail.equalsIgnoreCase(usernamet1) && passwordt2.equals(userPassword)) {
                    b = true;break;
                }

            }

            if (b) {
                System.out.println("ENTER");

                enter = true;
                return true;

            } else {
                return false;
            }

            //             st.setInt(1, Integer.parseInt(""));
        } catch (SQLException ex) {
            System.err.println("ERRRRRRRRRRRrrrre");

        }

        return false;
    }

    @Override
    public String toString() {
        return "enter:" + enter;
    }

    public static void main(String[] args) {
        CheckUserInfo test = new CheckUserInfo("noorqasem41", "123NQ");
        System.out.println(test.enter + "the answer is %^%");
    }
}
