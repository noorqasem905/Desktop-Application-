package my.applivation;

import com.mysql.cj.jdbc.Driver;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class userInformation {

    private MyApplivation b = new MyApplivation();
    private String username;
    private String email;
    private String FName, LName, City, Country;
    private String Birthday;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");
    private LocalDate givenDate;
    private LocalDate currentDate;
    private LocalDate futureDate;

    public userInformation(String username, String email, String FName, String LName, String City, String Country, String Birthday) {
        this.username = username;
        this.email = email;
        this.FName = FName;
        this.LName = LName;
        this.City = City;
        this.Country = Country;
        this.Birthday = Birthday;
    }
    
    public userInformation() {
     }

    void getDataBaseINFO(String useremail) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userform", "root", "");
            Statement st = con.createStatement();
            ResultSet result = st.executeQuery("SELECT * From users");
            String userEmail = null;
            String userName = null;
            String userpassword = null;

            while (result.next()) {

                userEmail = result.getString("email");
                userName = result.getString("name");
                userpassword = result.getString("password");
                if (useremail.equalsIgnoreCase(userEmail)) {
                    setEmail(userEmail);
                    setUsername(userName);
                    break;
                }

            }

        } catch (Exception e) {
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String Birthday) {

        this.Birthday = Birthday;

    }

    public LocalDate getgivenDate() {
        return givenDate;
    }

    public void setgivenDate(String Birthday) {
        givenDate = LocalDate.parse(Birthday, formatter);

    }

    public static void main(String[] args) {
        userInformation u = new userInformation("noorqasem41", "noorqasem41@gmail.com", "Nooraldeen", "Qasem", "Amman", "Jordan", "22-6-2004");

        u.setgivenDate(u.Birthday);
        System.out.println(u.getgivenDate().getDayOfWeek());
        System.out.println(u.getgivenDate());
    }

}
