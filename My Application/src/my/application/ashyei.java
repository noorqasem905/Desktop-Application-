package my.applivation;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Hp
 */
public class ashyei extends Application {

    String userEmail;
    boolean slogin;
    Scene s;
    ImageView personIconV;
    Image personIcon;
    MyApplivation Login = new MyApplivation();
    HomePages HomePage = new HomePages();
    Settings settings = new Settings();
    dashboard dashboardPage = new dashboard();
    Signin signin = new Signin();

    @Override
    public void start(Stage primaryStage) {

        Login.LoginStart();

        //s =HomePage.scene;
        s = Login.s;

        prStage(primaryStage);
        primaryStage.setScene(s);
        primaryStage.setTitle("Login");
        if (!Login.getState()) {
            primaryStage.show();
        }
        Login.b1.setOnMouseClicked(e -> HomePage(primaryStage));
        Login.l4.setOnMouseClicked(e -> signIN(primaryStage));
    }

    void test() {
        System.out.println("132546");
    }

    void prStage(Stage primaryStage) {
        personIcon = new Image("file:///C:/Users/Hp/OneDrive/Documents/NetBeansProjects/My%20Applivation/src/my/applivation/personicon.png");
        personIconV = new ImageView(personIcon);

        primaryStage.getIcons().add(personIcon);

        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setMinHeight(300);
        primaryStage.setMinWidth(300);

    }

    void HomePage(Stage primaryStage) {

        System.out.println("  PASSWORD");
        if (Login.getState()) {
            System.out.println("TRUE PASSWORD");
            HomePage.HomePageStart();
            s = HomePage.scene;
            primaryStage.setScene(s);
            primaryStage.show();
            HomePage.settingButton.setOnMouseClicked((event) -> {
                u = new userInformation();
                u.getDataBaseINFO(Login.userEmail);
                settings.getinfo(u.getEmail(), u.getUsername());
                System.out.println(u.getUsername());

                settings.startSettings();
                s = settings.scene;

                primaryStage.setScene(s);
                primaryStage.show();
                Setting(primaryStage);
                

            });
            HomePage.dashboardButton.setOnMouseClicked((event) -> {
                dashboardPage.startDashbord();
                s = dashboardPage.scene;
                primaryStage.setScene(s);
                primaryStage.show();
                Dashborad(primaryStage);

            });

        }
    }
    userInformation u;

    void signIN(Stage primaryStage) {
        signin.siginStart();
        s=signin.s;
        primaryStage.setScene(s);
        primaryStage.show();
         signin.b1.setOnMouseClicked((event) -> {
               if(signin.Slog){
                   start(primaryStage);
               }
        });
          
    }
    void signin(){
        
//    if(signin.Slog){
        System.out.println("ddddddddddddddddddddddddddddddddddddddddddd");
//    }
    }

    void Setting(Stage pr) {

        settings.homePage.setOnMouseClicked((event) -> {
            HomePage(pr);
        });
        settings.dashboardButton.setOnMouseClicked((event) -> {
            dashboardPage.startDashbord();
            s = dashboardPage.scene;
            pr.setScene(s);
            pr.show();

            Dashborad(pr);

        });
        settings.deleteAccount.setOnMouseClicked((event) -> {
            System.out.println("ddfasdf");
             if(!settings.close){
                System.out.println("qwe");
             start(pr);
                
            }
        });
    }

    void Dashborad(Stage pr) {
        dashboardPage.homePage.setOnMouseClicked((event) -> {
            HomePage(pr);
        });
        dashboardPage.settingButton.setOnMouseClicked((event) -> {
            settings.startSettings();
            s = settings.scene;
            pr.setScene(s);
            pr.show();

            Setting(pr);

        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
