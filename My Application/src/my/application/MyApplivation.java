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

/* demo.css */
/**
 *
 * @author Hp
 */
public class MyApplivation extends Application {

    private static final String ADD_USER = "INSERT INTO USERS VALUES(?,?,?,?)";
    private static final String UPDATE_USER = "UPDATE USERS SET NAME=?,EMAIL=?,PASSWORD=? WHERE ID=?";
    private static final String DELETE_USER = "DELETE FROM USERS WHERE ID=?";
    private static final String search = "SELECT * FROM USERS WHERE ID=? AND email=?";

    Scene s;
    private Label l1, l2, l3;
    Button b1;
    public Label l4;
    private TextField t2;
    private PasswordField t1;
    public String userEmail;
    public void setState(Boolean State) {
        this.State = State;
    }
    private Boolean State = false;

    @Override
    public void start(Stage primaryStage) {
        LoginStart();
        primaryStage.setScene(s);
        prStage(primaryStage);
        primaryStage.setTitle("Login");
        primaryStage.show();
    }

    public void LoginStart() {

        Login();
        GridPane r1 = LyoutLogin();
        s = new Scene(r1);
        Alert a = new Alert(Alert.AlertType.ERROR);

        b1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                if (!t1.getText().isEmpty() && !t2.getText().isEmpty()) {
                    CheckUserInfo c = new CheckUserInfo(t1.getText(), t2.getText());
                    System.out.println(c.enter);

                    if (c.enter) {
                        State = true;
                        userEmail=c.getuserEmail();
                        
                        System.out.println("The is the userEmail: "+userEmail);
                        System.out.println("ENTER");

                    } else {
                        a.setAlertType(Alert.AlertType.INFORMATION);
                        a.setHeaderText("Your Email or password is uncorrect");
                        a.show();
                    }

                    //             st.setInt(1, Integer.parseInt(""));
//                    String pass = (String) t2.getText(), name = (String) t1.getText();
//                    System.out.println(pass + name);
//                    System.out.println(c.enter);
//                    if (c.enter) {
//                        State = true;
//                        System.out.println("ENTER");
//
//                    } else {
//                        a.setAlertType(Alert.AlertType.INFORMATION);
//                        a.setHeaderText("Your Email or password is uncorrect");
//                        a.show();
//                    }
                } else {
                    a.setTitle("Message");
                    a.setHeaderText("You Enter Empty Feild");
                    a.show();
                }

            }
        });
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
    }

    public Boolean getState() {
        return State;
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

    void Login() {
        l1 = new Label("Login");
        l1.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        l1.setPadding(new Insets(20, 20, 20, 20));
        l2 = new Label("EMAIL");
        t1 = new PasswordField();
        t1.setPromptText("hello@karaz.nq");
        l3 = new Label("PASSWORD");
        t2 = new TextField();
        t2.setPromptText("********");
        l4 = new Label("Or Create a new Account");
        b1 = new Button("sign in");
        b1.setPadding(new Insets(10, 20, 10, 20));
        b1.setPrefWidth(135);
        t1.setPrefSize(250, 35);
        t2.setPrefSize(250, 35);
        l4.setStyle("-fx-underline:false;");

        /*  l2.setStyle("-fx-text-fill:back;");
        l3.setStyle("-fx-text-fill:back;");*/
        l4.setOnMouseClicked((event) -> {
            System.out.println("okayy");

        });
        l4.setOnMouseMoved((event) -> {
            l4.setStyle("-fx-underline:true;");

        });
        l4.setOnMouseExited((event) -> {
            l4.setStyle("-fx-underline:false;");

        });

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
        root.add(l4, 1, 3);
        root.add(b1, 0, 4, 2, 1);
        root.setHgap(10);
        root.setVgap(10);

        GridPane.setHalignment(l1, HPos.CENTER);
        GridPane.setHalignment(b1, HPos.CENTER);
        root.setAlignment(Pos.CENTER);
        return root;
    }

}
