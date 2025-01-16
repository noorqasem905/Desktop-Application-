package my.applivation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Optional;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.stage.*;

public class Settings<T> extends Application {

    Button dashboardButton, settingButton, homePage, deleteAccount;
    private static final String ADD_USER = "INSERT INTO USERS VALUES(?,?,?,?)";
    private static final String UPDATE_USER = "UPDATE USERS SET  name=? WHERE email=?";
    private static final String DELETE_USER = "DELETE FROM USERS WHERE email=?";

    T array[];
    boolean close = true;
    TextField newEmail;
    Button update;
    BorderPane top;
    BorderPane mainCenter;
    ScrollPane scrollPane;
    Rectangle[] rectangle = new Rectangle[100];
    FlowPane centerRootCenter;
    Label showmenu, AcountL1, AcountL2, updateEmail;
    Scene scene;
    ComboBox<String> comboCy;
    ComboBox<String> comboCIY;
    ComboBox<String> currencyC;
    int i = 0;

    HBox topCenter;
    VBox left;
    BorderPane mainroot;
    ImageView personIconV, shopping_bagV, notificationsV, locationV, menuBARV;
    Image personIcon, shopping_bag, notifications, location, menuBAR;
    String styleIcons = "-fx-fit-width: 2px; -fx-fit-height: 2px;",
            styleName = "-fx-text-fill: #3E3B3B; -fx-font-size: 20px;-fx-font-style: italic;-fx-font-weight:bold;",
            White = "-fx-background-color:#FFFFFF;",
            Buttonstyle = "-fx-background-color:#B2B2B2;-fx-border-width: 0; -fx-border-style: null; -fx-text-fill:#FFFFFF;-fx-font-weight:bold;",
            ButtonStyleCheck = "-fx-background-color:#000000;-fx-border-width: 0; -fx-border-style: null;-fx-text-fill:#FFFFFF;-fx-font-weight:bold;",
            mainRootStyle = "-fx-background-color:#E9E9E9;",
            TitleStyle = "-fx-text-fill: #3E3B3B; -fx-font-size: 20px;-fx-font-style: italic;-fx-font-weight:bold",
            normaltitle = "-fx-text-fill: #3E3B3B; -fx-font-size: 15px; ";

    ;
 
    @Override
    public void start(Stage primaryStage) {

        topSection();
        Vbox();
        center();
        mainroot();

        //primaryStage.getIcons().add(personIcon);     
        scene = new Scene(mainroot, 300, 250);
        PStage(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    void startSettings() {

        topSection();
        Vbox();
        center();
        mainroot();
        scene = new Scene(mainroot, 300, 250);

        deleteAccount.setOnAction((event) -> {
            //Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            //a.setContentText("Are you sure you want to delete your account");
            //a.show();
            //Optional<ButtonType> result = a.showAndWait();
            //  if (result.isPresent() && result.get() == ButtonType.OK) {
            try {
                //1-Conection
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userform", "root", "");

                //2-Preppared Statement
                PreparedStatement st = con.prepareStatement(DELETE_USER);
                //3- parameters

                st.setString(1, name);

                //4-execute
                st.execute();

                close = false;
            } catch (Exception e) {
                Alert msg = new Alert(Alert.AlertType.ERROR, "Error " + e);
                msg.show();

            }
            // }

        });

        update.setOnMouseClicked((event) -> {
            try {
                //1-Conection
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userform", "root", "");

                //2-Preppared Statement
                PreparedStatement st = con.prepareStatement(UPDATE_USER);
                //3- parameters
                
                st.setString(1, newEmail.getText());
                st.setString(2, name);
                //4-execute
                st.execute();
                Alert msg = new Alert(Alert.AlertType.INFORMATION, "one user updated");
                msg.show();
            } catch (Exception e) {
                Alert msg = new Alert(Alert.AlertType.ERROR, "Error " + e);
                msg.show();

            }
        });
    }

    void mainroot() {
        mainroot = new BorderPane();
        mainroot.setTop(top);
        mainroot.setCenter(settingsRoot);

        mainroot.setStyle(mainRootStyle);

        menuBARV.setOnMouseClicked(event -> {
            i++;
            if (i > 1) {
                i = 0;
                mainroot.setLeft(null);
            } else {
                mainroot.setLeft(left);
            }

            System.out.println("Label clicked!");
            // Add your action here
            // For example, you can change the label text
        });
    }

    void Vbox() {
        left = new VBox();
        left.setStyle(White);
        left.setPadding(new Insets(10, 10, 10, 10));
        left.setSpacing(10);
        homePage = new Button("Home");
        ButtonStyle(homePage);

        dashboardButton = new Button("Dashboard");
        ButtonStyle(dashboardButton);
        settingButton = new Button("setting");
        ButtonStyle(settingButton);

        left.getChildren().addAll(homePage, dashboardButton, settingButton);
    }

    void PStage(Stage primaryStage) {

        primaryStage.setWidth(1000);
        primaryStage.setHeight(800);
        primaryStage.setTitle("Hello World!");

    }

    GridPane settingsRoot;
    Label userNameL, emailL, locationL1, CurrencyOPS, GeneralOPS, locationL2, currencyL;
    TextField usernameT, emailT;

    void center() {
        settingsRoot = new GridPane();
        settingsRoot.setPadding(new Insets(20, 20, 20, 20));
        settingsRoot.setHgap(20);
        settingsRoot.setVgap(20);

        centerControl();
        centerStyleControl();

        comboCy.setOnAction((event) -> {
            String value = (String) comboCy.getValue();

            comboCIY.getItems().clear();
            if (value.equals("Jordan")) {
                comboCIY.getItems().addAll("Amman", "Aqaba", "Irbid");
            } else if (value.equalsIgnoreCase("Palestine")) {
                comboCIY.getItems().addAll("jerusalem", "Gaza", "Jenin");
            } else {
                comboCIY.getItems().addAll("There is no data yet", "", "");
            }
        });

        settingsRoot.add(GeneralOPS, 0, 0);
        settingsRoot.add(userNameL, 0, 1);
        settingsRoot.add(usernameT, 1, 1);
        settingsRoot.add(emailL, 0, 2);
        settingsRoot.add(emailT, 1, 2);
        settingsRoot.add(locationL1, 0, 3);
        settingsRoot.add(comboCy, 1, 3);
        settingsRoot.add(locationL2, 0, 4);
        settingsRoot.add(comboCIY, 1, 4);
        settingsRoot.add(CurrencyOPS, 0, 5);
        settingsRoot.add(currencyL, 0, 6);
        settingsRoot.add(currencyC, 1, 6);
        settingsRoot.add(AcountL1, 0, 7);
        settingsRoot.add(AcountL2, 0, 8);
        settingsRoot.add(updateEmail, 0, 9);
        settingsRoot.add(newEmail, 1, 9);
        settingsRoot.add(update, 0, 10);

        settingsRoot.add(deleteAccount, 1, 8);

    }

    void centerControl() {
        comboCy = new ComboBox<>();
        comboCIY = new ComboBox<>();
        currencyC = new ComboBox<>();
        GeneralOPS = new Label("General Options");
        userNameL = new Label("username");
        emailL = new Label("email");
        usernameT = new TextField();
        emailT = new TextField();
        locationL1 = new Label("Base Your country");
        locationL2 = new Label("Base Location");
        CurrencyOPS = new Label("Currency Options");
        currencyL = new Label("Currency");
        AcountL1 = new Label("Account Setting");
        AcountL2 = new Label("Delete Account");
        deleteAccount = new Button("Delete Acount");
        updateEmail = new Label("Update username");
        newEmail = new TextField();
        newEmail.setPromptText("new username");
        update = new Button("Update");
        update.setStyle(Buttonstyle);
        TextFieldStyle(usernameT, emailT);
        ComboBoxStyle(comboCy, comboCIY, currencyC);

    }

    void ComboBoxStyle(ComboBox<String>... t) {
        for (ComboBox combo : t) {
            combo.setStyle("-fx-background-color:#FFFFFF;");
            combo.setPrefWidth(150);
        }
    }

    void TextFieldStyle(TextField... t) {
        for (TextField t1 : t) {
            t1.setStyle("-fx-border-color:#E9E9E9; -fx-border-width:1px;");
            t1.setPrefSize(170, 30);
            t1.setBorder(Border.EMPTY);
            t1.setPromptText("");
        }
    }
    String email = null, name = null;

    void getinfo(String username, String email) {
        this.email = email;
        name = username;
    }

    void centerStyleControl() {
        GeneralOPS.setStyle(TitleStyle);
        userNameL.setStyle(normaltitle);
        usernameT.setEditable(false);
        usernameT.setText(email);
        emailT.setEditable(false);
        emailL.setStyle(normaltitle);
        emailT.setText(name);
        locationL1.setStyle(normaltitle);
        locationL2.setStyle(normaltitle);
        CurrencyOPS.setStyle(TitleStyle);
        currencyC.getItems().addAll("JOD-JD($)", "US-Dallor($)");
        currencyC.setValue("JOD-JD($)");
        comboCIY.setPromptText("City");
        comboCy.getItems().addAll("Jordan", "Palestine", "other country");
        comboCy.setPromptText("country");
        AcountL2.setStyle(normaltitle);
        AcountL1.setStyle(TitleStyle);
        deleteAccount.setStyle(Buttonstyle);
        deleteAccount.setOnMouseEntered((event) -> {
            deleteAccount.setStyle(ButtonStyleCheck);

        });
        deleteAccount.setOnMouseExited((event) -> {
            deleteAccount.setStyle(Buttonstyle);

        });
        update.setOnMouseEntered((event) -> {
            update.setStyle(ButtonStyleCheck);

        });
        update.setOnMouseExited((event) -> {
            update.setStyle(Buttonstyle);

        });

    }

    void topSection() {
        top = new BorderPane();
        topCenter = new HBox();
        HBox topLeft = new HBox(),
                topRight = new HBox();

        top.setPadding(new Insets(10, 10, 10, 10));
        top.setStyle(White);
        Addimage();
        Label locTitle = new Label("Amman");
        Label nameUser = new Label("NoorQasem");

        locTitle.setStyle("-fx-text-fill: #3E3B3B; -fx-font-size: 15px;-fx-font-family: 'Times New Roman';");
        nameUser.setStyle(styleName);
        topRight.setSpacing(5);
        topLeft.setAlignment(Pos.CENTER);
        topRight.setAlignment(Pos.CENTER);

        locationV.setFitWidth(20.4);
        locationV.setFitHeight(20.4);

        topLeft.getChildren().add(menuBARV);
        topLeft.getChildren().add(locationV);
        topLeft.getChildren().add(locTitle);

        topRight.getChildren().add(shopping_bagV);
        topRight.getChildren().add(notificationsV);
        topRight.getChildren().add(personIconV);
        topRight.getChildren().add(nameUser);
        top.setLeft(topLeft);
        top.setRight(topRight);

    }

    void imageViewStyle(ImageView imageV) {

        imageV.setStyle(styleIcons);
        imageV.setFitWidth(30.4);
        imageV.setFitHeight(30.4);
    }

    void Addimage() {
        shopping_bag = new Image("file:///C:/Users/Hp/OneDrive/Documents/NetBeansProjects/My%20Applivation/src/my/applivation/shopping_bag.png");
        personIcon = new Image("file:///C:/Users/Hp/OneDrive/Documents/NetBeansProjects/My%20Applivation/src/my/applivation/personicon.png");
        notifications = new Image("file:///C:/Users/Hp/OneDrive/Documents/NetBeansProjects/My%20Applivation/src/my/applivation/notifications.png");
        location = new Image("file:///C:/Users/Hp/OneDrive/Documents/NetBeansProjects/My%20Applivation/src/my/applivation/location.png");
        menuBAR = new Image("file:///C:/Users/Hp/OneDrive/Documents/NetBeansProjects/My%20Applivation/src/my/applivation/back.png");

        menuBARV = new ImageView(menuBAR);
        locationV = new ImageView(location);
        shopping_bagV = new ImageView(shopping_bag);
        personIconV = new ImageView(personIcon);
        notificationsV = new ImageView(notifications);

        imageViewStyle(menuBARV);
        imageViewStyle(locationV);
        imageViewStyle(notificationsV);
        imageViewStyle(personIconV);
        imageViewStyle(shopping_bagV);

    }

    void ButtonStyle(Button b) {
        b.setPrefSize(100, 30);
        b.setStyle(Buttonstyle);
        b.setOnMouseEntered((event) -> {
            b.setStyle(ButtonStyleCheck);
        });
        b.setOnMouseExited((event) -> {
            b.setStyle(Buttonstyle);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
