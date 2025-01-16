package my.applivation;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class dashboard extends Application {

    Button homePage, dashboardButton, settingButton;
    BorderPane top;
    BorderPane mainCenter;
    ScrollPane scrollPane;
    Rectangle[] rectangle = new Rectangle[100];
    FlowPane centerRootCenter;
    Label showmenu;
    Scene scene;
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
            mainRootStyle = "-fx-background-color:#E9E9E9;";

    ;
 
    @Override
    public void start(Stage primaryStage) {
        PStage(primaryStage);
        topSection();
        Vbox();
        buttonRectangle();
        center();
        mainroot();

        scene = new Scene(mainroot, 300, 250);

        primaryStage.getIcons().add(personIcon);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    void startDashbord() {

        topSection();
        Vbox();
        buttonRectangle();
        center();
        mainroot();
        scene = new Scene(mainroot, 300, 250);

    }

    void mainroot() {
        mainroot = new BorderPane();
        mainroot.setTop(top);
        ScrollPane scrollPane = new ScrollPane(mainCenter);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(false);

        mainroot.setCenter(scrollPane);
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
    Text text;
    Pane pane = new Pane();

    void rectangle(StackPane stackpane, String textin, String textstate, int sized, int sized1) {

        BorderPane box = new BorderPane();
        HBox top = new HBox();
        VBox left = new VBox();

        Rectangle r = new Rectangle(sized, sized1);
        r.setFill(Color.WHITE);
        r.setStroke(Color.BLACK);
        r.setStrokeWidth(0);
        Color rectangleColor = Color.web("#ff4040");         // Create Text
        Text txt = new Text(textstate);
        text = new Text(textin);

        r.setFill(rectangleColor);

        txt.setFont(Font.font("Tahoma", FontWeight.LIGHT, 15));
        text.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        text.setFill(Color.WHITE);
        txt.setFill(Color.LIGHTGRAY);

        top.getChildren().add(txt);
        left.getChildren().add(text);

        left.setPadding(new Insets(10, 10, 10, 10));
        top.setPadding(new Insets(15, 10, 10, 10));
        box.setTop(top);
        box.setLeft(left);

        stackpane.getChildren().addAll(r, box);
        r.setArcWidth(20);
        r.setArcHeight(20);

//               Rectangle r = new Rectangle(220, 110);
//        
//        r.setFill(Color.WHITE);
//        r.setStroke(Color.BLACK);
//        r.setStrokeWidth(0);
//        Color rectangleColor = Color.web("#ff4040");
//        r.setFill(rectangleColor);
//        text = new Text("360");
//        text.setFont(Font.font("Arial", FontWeight.BOLD, 30));
//        text.setFill(Color.WHITE);
//
//        stackPane.getChildren().addAll(r, text);
//
//        r.setArcWidth(20); // Horizontal corner radius
//        r.setArcHeight(20);
    }
    int blockSize = 4;
    GridPane mainCenter2;

    void center() {
        mainCenter2 = new GridPane();
        mainCenter = new BorderPane();
        mainCenter.setStyle(mainRootStyle);
        centerRootCenter = new FlowPane();
        centerCenter();

        button.setAlignment(Pos.CENTER);
        mainCenter.setCenter(centerRootCenter);
        mainCenter.setBottom(button);

    }
//  TextField search = new TextField();
//        search.setStyle("-fx-border-color:#E9E9E9; -fx-border-width:1px;");
//        search.setPrefSize(151, 38);
//        search.setBorder(Border.EMPTY);
//        search.setPromptText("Search");

    void centerCenter() {
        centerRootCenter.setPadding(new Insets(20, 20, 20, 20));
        centerRootCenter.setStyle(mainRootStyle + "-fx-margin:10;");
        String textin[] = new String[4];
        textin[0] = "12k";
        textin[1] = "10";
        textin[2] = "13k";
        textin[3] = "123k";
        String textstate[] = new String[4];
        textstate[0] = "Wallet";
        textstate[1] = "order on shipping";
        textstate[2] = "orders have deliveried";
        textstate[3] = "Totel order";
        // Create a rectangle
        for (int x2 = 0; x2 < blockSize; x2++) {
            StackPane stackpane = new StackPane();
            rectangle(stackpane, textin[x2], textstate[x2], 220, 110);
            centerRootCenter.getChildren().addAll(stackpane);
        }

        centerRootCenter.setHgap(80);
        centerRootCenter.setVgap(105);
        centerRootCenter.setAlignment(Pos.CENTER);

        mainCenter2.add(centerRootCenter, 0, 0, 2, 1);
        GridPane.setHalignment(centerRootCenter, HPos.CENTER);

    }
    FlowPane button;

    void buttonRectangle() {
        button = new FlowPane();
        for (int i = 0; i < 2; i++) {
            StackPane stack = new StackPane();
            rectangleButton(stack, i);
            System.out.println("fdfd");
            button.getChildren().addAll(stack);
        }
        button.setHgap(80);
        button.setVgap(105);
        button.setPadding(new Insets(200, 0, 0, 0));

    }

    void rectangleButton(StackPane stack, int s) {
        BorderPane c = new BorderPane();
        Text t1[] = new Text[8];
        Rectangle r = new Rectangle(440, 220);
        GridPane g = new GridPane();
        VBox left = new VBox();
        VBox right = new VBox();

        r.setFill(Color.WHITE);
        r.setStroke(Color.BLACK);
        r.setStrokeWidth(0);
         r.setArcWidth(20);
        r.setArcHeight(20);
        Color rectangleColor = Color.web("#ff4040");         // Create Text

        r.setFill(rectangleColor);

        t1[0] = new Text("Action Wallet");
        t1[1] = new Text("Paid");
        t1[2] = new Text("Ordered");
        t1[3] = new Text("in shipping");
        t1[4] = new Text();
        t1[5] = new Text("200.320JD");
        t1[6] = new Text("5");
        t1[7] = new Text("1");

        if (s == 1) {
            t1[0] = new Text("Shipping");
            t1[1] = new Text("Shipments ID");
            t1[2] = new Text("Shipping Status");
            t1[3] = new Text("Date shipped");
            t1[4] = new Text();
            t1[5] = new Text("145640");
            t1[6] = new Text("shipped");
            t1[7] = new Text("22-6-2024");

        }

        for (int b = 0; b < (t1.length) / 2; b++) {
            left.getChildren().addAll(t1[b]);
        }
        for (int b1 = 4; b1 < t1.length; b1++) {
            right.getChildren().addAll(t1[b1]);
        }
        
        left.setSpacing(20);
        right.setSpacing(20);
        left.setPadding(new Insets(10,10,10,10));
                right.setPadding(new Insets(10,10,10,10));


        c.setLeft(left);
        c.setRight(right);
        for (Text t : t1) {
            t.setFont(Font.font("Tahoma", FontWeight.LIGHT, 15));
            t.setStyle("-fx-text-fill: #FFFFFF; ");
            t.setFill(Color.WHITE);
//        t.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        }

        g.setHgap(20);
        g.setAlignment(Pos.CENTER);
        stack.getChildren().addAll(r, c);

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
