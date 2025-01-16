/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.applivation;

import java.sql.*;

import java.util.logging.*;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/* demo.css */
/**
 *
 * @author Hp
 */
public class Signin extends Application {

    private static final String ADD_USER = "INSERT INTO USERS VALUES(?,?,?,?)";
    private static final String UPDATE_USER = "UPDATE USERS SET NAME=?,EMAIL=?,PASSWORD=? WHERE ID=?";
    private static final String DELETE_USER = "DELETE FROM USERS WHERE ID=?";
    private static final String search = "SELECT * FROM USERS WHERE ID=? AND email=?";
    private int i = 1;
    boolean Slog=false;
    Scene s;
    private Label l1, l2, l3, l5;
    Button b1;
    public Label l4;
    private TextField t2;
    private TextField t1;
    private PasswordField t3, t4;
     @Override
    public void start(Stage primaryStage) {
        siginStart();
        primaryStage.setScene(s);
        prStage(primaryStage);
        primaryStage.setTitle("sign in");
        primaryStage.show();
    }
    

    public void siginStart() {

        sigin();
        GridPane r1 = LyoutLogin();
        s = new Scene(r1);
        Alert a = new Alert(Alert.AlertType.ERROR);

        b1.setOnMouseEntered((event) -> {
            b1.setStyle("-fx-text-fill: #ffffff;"
                    + "-fx-background-color:#BFBFBD;"
                    + "-fx-background-radius:8px;"
                    + "-fx-font-size: 14px;"
                    + " -fx-font-weight: bold;");
        });
        b1.setOnMouseExited((event) -> {
            b1.setStyle("-fx-text-fill: #FFFFFF;"
                    + "-fx-background-color:#1C2120;"
                    + "-fx-background-radius:8px;"
                    + "-fx-font-size: 14px;"
                    + " -fx-font-weight: bold;");
        });
        b1.setOnAction((event) -> {
            if (!t1.getText().isEmpty() && !t2.getText().isEmpty() && !t3.getText().isEmpty() && !t4.getText().isEmpty()) {
                if (t3.getText().equals(t4.getText())) {
                    if (t3.getText().length() > 8) {
                        try {int userid=0;
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userform", "root", "");
                            Statement sta = con.createStatement();
                            ResultSet result = sta.executeQuery("SELECT id FROM USERS ORDER BY id DESC LIMIT 1");
                            if(result.next()){
                              userid=result.getInt("id");System.out.println(userid);
                            }int h=1;
                            PreparedStatement st = con.prepareStatement(ADD_USER);
                            st.setInt(1, userid+i);
                            st.setString(2, t1.getText());
                            st.setString(3, t2.getText());
                            st.setString(4, t3.getText());
                            st.execute();Slog=true;
//                            a.setContentText("Added A new ACCOUNT");
//                            a.setAlertType(Alert.AlertType.INFORMATION);
                            System.out.println("gsdsdg");
                             
                          

                        } catch (Exception ex) {
                            System.err.println("Error\n" + ex);
                        }
                    } else {
                        a.setContentText("The password should have more than 8 charector");
                    }
                } else {
                    a.setContentText("The password should be simailar");
                }
            } else {
                a.setContentText("Please fill all field");
                a.show();
            }
                    System.out.println("0000000000000000");

        });
     }

    public static void main(String[] args) {
        launch(args);
    }

    void prStage(Stage primaryStage) {

        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setMinHeight(300);
        primaryStage.setMinWidth(300);

    }

    void sigin() {
        l1 = new Label("sign in");
        l1.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        l1.setPadding(new Insets(20, 20, 20, 20));
        l2 = new Label("Name");
        t1 = new TextField();
        t1.setPromptText("Noor qasem");
        l3 = new Label("Email");
        t2 = new TextField();
        t2.setPromptText("hello@karaz.nq");
        l4 = new Label("Password");
        t3 = new PasswordField();
        l5 = new Label("password");
        t4 = new PasswordField();

        b1 = new Button("sign in");
        b1.setPadding(new Insets(10, 20, 10, 20));
        b1.setPrefWidth(135);
        t1.setPrefSize(250, 35);
        t2.setPrefSize(250, 35);
        t3.setPrefSize(250, 35);
        t4.setPrefSize(250, 35);
        t3.setPromptText("********");
        t4.setPromptText("********");

        
        l5.setFont(Font.font("Arial", FontWeight.EXTRA_LIGHT, 10));

        l4.setFont(Font.font("Arial", FontWeight.EXTRA_LIGHT, 10));
        /* t1.setFont(Font.font("Arial", FontWeight.LIGHT, 15));*/
        b1.setStyle("-fx-text-fill: #FFFFFF;"
                + "-fx-background-color:#1C2120;"
                + "-fx-background-radius:8px;"
                + "-fx-font-size: 14px;"
                + " -fx-font-weight: bold;");
        /* t1.setStyle("-fx-background-color: #ECECEC; "
                + " -fx-background-radius:5px; "
                + "-fx-font-size: 14px;"
                + " -fx-font-weight: bold;");
        t2.setStyle("-fx-background-color: #ECECEC;"
                + "-fx-background-radius: 5px;"
                + "-fx-font-size: 14px; "
                + "-fx-font-weight: bold;");*/

    }

    GridPane LyoutLogin() {
        GridPane root = new GridPane();
        root.add(l1, 0, 0, 2, 1);
        root.add(l2, 0, 1);
        root.add(t1, 1, 1);
        root.add(l3, 0, 2);
        root.add(t2, 1, 2);

        root.add(l4, 0, 3);
        root.add(t3, 1, 3);
        root.add(l5, 0, 4);
        root.add(t4, 1, 4);

        root.add(b1, 0, 5, 2, 1);
        root.setHgap(10);
        root.setVgap(10);

        GridPane.setHalignment(l1, HPos.CENTER);
        GridPane.setHalignment(b1, HPos.CENTER);
        root.setAlignment(Pos.CENTER);
        return root;
    }

}
