package my.applivation;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;

import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class HomePages extends Application {
    
    Button dashboardButton, settingButton, homePage;
    private BorderPane top;
    private BorderPane mainCenter;
    private ScrollPane scrollPane;
    private FlowPane centerRootCenter;
    private Label showmenu;
    Scene scene;
    private int i = 0;
    private HBox topCenter;
    private boolean openSetting = false;
    
    private VBox left;
    private BorderPane mainroot;
    private ImageView personIconV, shopping_bagV, notificationsV, locationV, menuBARV;
    private Image personIcon, shopping_bag, notifications, location, menuBAR;
    String styleIcons = "-fx-fit-width: 2px; -fx-fit-height: 2px;",
            styleName = "-fx-text-fill: #3E3B3B; -fx-font-size: 20px;-fx-font-style: italic;-fx-font-weight:bold;",
            White = "-fx-background-color:#FFFFFF;",
            Buttonstyle = "-fx-background-color:#B2B2B2;-fx-border-width: 0; -fx-border-style: null; -fx-text-fill:#FFFFFF;-fx-font-weight:bold;",
            ButtonStyleCheck = "-fx-background-color:#000000;-fx-border-width: 0; -fx-border-style: null;-fx-text-fill:#FFFFFF;-fx-font-weight:bold;",
            mainRootStyle = "-fx-background-color:#E9E9E9;";
    
    ;
 
    @Override
    public void start(Stage primaryStage) {
        PStage(primaryStage);
        
        HomePageStart();
        primaryStage.getIcons().add(personIcon);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
    public void HomePageStart() {
        
        topSection();
        Vbox();
        center();
        mainroot();
        scene = new Scene(mainroot, 300, 250);
    }
    
    void settingButton() {
        settingButton.setOnMouseClicked((event) -> {
            openSetting = true;
        });
    }
    
    void mainroot() {
        mainroot = new BorderPane();
        mainroot.setTop(top);
        mainroot.setCenter(mainCenter);
        
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
    
    int blockSize = 8;
    
    void center() {
        mainCenter = new BorderPane();
        mainCenter.setStyle(mainRootStyle);
        centerRootCenter = new FlowPane();
        CenterTop();
        centerCenter();
    }
    
    void CenterTop() {
        BorderPane topCenter2 = new BorderPane();
        VBox centerTopRight = new VBox();
        VBox centerTopLeft = new VBox();
        
        topCenter2.setPadding(new Insets(15, 50, 15, 50));
        topCenter2.setStyle(mainRootStyle + "-fx-border-color:#E9E9E9; -fx-border-width:1px;");
        
        TextField search = new TextField();
        search.setStyle("-fx-border-color:#E9E9E9; -fx-border-width:1px;");
        search.setPrefSize(151, 38);
        search.setBorder(Border.EMPTY);
        search.setPromptText("Search");
        
        Label namePage = new Label("Noor Qasem");
        Label emptyLabel = new Label();
        Label emptyLabel2 = new Label();
        
        namePage.setStyle(styleName);
        emptyLabel.setStyle(styleName);
        emptyLabel2.setStyle(styleName);
        
        centerTopRight.getChildren().add(emptyLabel2);
        centerTopRight.getChildren().add(search);
        centerTopRight.setAlignment(Pos.CENTER);
        
        centerTopLeft.getChildren().add(namePage);
        centerTopLeft.getChildren().add(emptyLabel);
        centerTopLeft.setAlignment(Pos.CENTER);
        
        topCenter2.setLeft(centerTopLeft);
        topCenter2.setRight(centerTopRight);
        mainCenter.setTop(topCenter2);
    }
    
    void rectangle(StackPane s, Text text) {
        Rectangle r = new Rectangle(280, 200);
        Text a = new Text(text.getText());
//        a.setText(text.getText());
        a.setFill(Color.BLACK);
        r.setStroke(Color.WHITE);
        r.setFill(Color.WHITE);
        r.setStrokeWidth(0);
        r.setArcWidth(20); // Horizontal corner radius
        r.setArcHeight(20);
        //a.setFont(Font.font("Tahoma", FontWeight.LIGHT, 15));
        a.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        
        s.getChildren().addAll(r, a);
        
        text.setOnMouseClicked((event) -> {
            a.setFill(Color.WHITE);
            r.setStroke(Color.WHITE);
            r.setFill(Color.CRIMSON);
        });
        r.setOnMouseMoved((event) -> {
            a.setFill(Color.WHITE);
            r.setStroke(Color.WHITE);
            r.setFill(Color.CRIMSON);
        });
        r.setOnMouseExited((event) -> {
            a.setFill(Color.BLACK);
            r.setStroke(Color.WHITE);
            r.setFill(Color.WHITE);
        });
           text.setOnDragExited((event) -> {
            a.setFill(Color.BLACK);
            r.setStroke(Color.WHITE);
            r.setFill(Color.WHITE);
        });
    }
    
    void centerCenter() {
        centerRootCenter.setPadding(new Insets(20, 20, 20, 20));
        centerRootCenter.setStyle(mainRootStyle + "-fx-margin:10;");
        centerRootCenter.setAlignment(Pos.CENTER);
        // Create a rectangle
        Text text[] = new Text[8];
        text[0] = new Text();
        text[1] = new Text();
        text[2] = new Text();
        text[3] = new Text();
        text[4] = new Text();
        text[5] = new Text();
        text[6] = new Text();
        text[7] = new Text();
        text[0].setText("Hotel");
        text[1].setText("House");
        text[2].setText("Restouran");
        text[3].setText("Garden");
        text[4].setText("Health");
        text[5].setText("Electroneic");
        text[6].setText("Smart House");
        text[7].setText("others");
        
        for (int x2 = 0; x2 < blockSize; x2++) {
            StackPane stack = new StackPane();
            rectangle(stack, text[x2]);
            centerRootCenter.getChildren().addAll(stack);
        }
        
        centerRootCenter.setHgap(80);
        centerRootCenter.setVgap(105);
        
        scrollPane = new ScrollPane(centerRootCenter);//scroll rectangel
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(false);
        
        mainCenter.setCenter(scrollPane);
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
