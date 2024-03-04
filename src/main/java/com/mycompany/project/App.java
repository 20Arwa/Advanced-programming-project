package com.mycompany.project;

import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.shape.*;
import javafx.event.*;
import javafx.scene.input.*;

import java.util.List;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.query.Query;



/**
 * JavaFX App
 */
public class App extends Application {
    Scene Singscene;
   Scene scenemain;
   Scene sceneHome;
   BorderPane main;
   ScrollPane scrollPane;//small car interface
   ScrollPane bigscrollPane;//big car interface
   ScrollPane sportscrollPane;//sport car interfaec
   ScrollPane electricscrollPane;//electric car interface
   VBox SignPane;//singup interface
    HBox gotoLogPane;
    Text SignUpText;
    Text WelcomeText;
    VBox Date;
   
   Label L1;
   

   
   ScrollPane order;
   
   
    HBox gotoSingPane;
    VBox LoginPane;
    Scene Loginscene;
   
    // 
    User currentUser;
    Car bookedCar;
     Rental rent;
     int rentalID= 30;
    
    // Data Base
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();
    
    
    public void start(Stage stage) {
        order=new ScrollPane();
        
        
        //-------------------------------------------------------------------------------------------------//        
/////////////////////////////// start Details interface//////////////////////////////////////////////
//-------------------------------------------------------------------------------------------------//
        //set Date
         HBox HreceiptDate= new HBox(6);
        Label receiptDate=new Label("Date receipt:");
        receiptDate.setStyle("-fx-text-fill:black;-fx-font-size: 11px; -fx-font-weight: bold; -fx-alignment: left;");
        receiptDate.setAlignment(Pos.CENTER);
        DatePicker receiptDatePicker = new DatePicker();
        receiptDatePicker.setPrefSize(120,17);
         receiptDatePicker.setStyle(" -fx-background-color:#FFC503;");
        HreceiptDate.getChildren().addAll(receiptDate,receiptDatePicker);
        
         HBox HdeliveryDate= new HBox(6);
        Label deliveryDate=new Label("Date delivery:");
         deliveryDate.setAlignment(Pos.CENTER);
         deliveryDate.setStyle("-fx-text-fill:black;-fx-font-size: 11px; -fx-font-weight: bold; -fx-alignment: left;");
        DatePicker deliveryDatePicker = new DatePicker();
        deliveryDatePicker.setPrefSize(120,17);
        deliveryDatePicker.setStyle(" -fx-background-color:#FFC503;");
        HdeliveryDate.getChildren().addAll(deliveryDate,deliveryDatePicker);
        
        //Name car(in every change set text of specifice car)
        Label detailName = new Label("Toyota Yaris 2023 ");
        detailName.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-alignment: center; -fx-font-family: Arial;-fx-text-fill:#FFC503; ");
        detailName.setAlignment(Pos.CENTER);
        
        
        //set image (in every change set image of specifice car)
        VBox Vdetailsimag=new VBox();
        Image detailsimag = new Image("file:C:\\Users\\lap12\\OneDrive\\المستندات\\برمجة متقدمة\\project\\src\\main\\java\\com\\mycompany\\project\\cars\\white1.png"); 
        ImageView detailscar1View = new ImageView(detailsimag);
        detailscar1View.setFitWidth(200);
        detailscar1View.setFitHeight(150);
        detailscar1View.setStyle("-fx-border-color: black;");
        Vdetailsimag.getChildren().addAll(detailName,detailscar1View);
        Vdetailsimag.setPadding(new Insets(20));
        Vdetailsimag.setAlignment(Pos.CENTER);
        Vdetailsimag.setPrefSize(60, 60);
        
        
        
        
        //label price
        Line separator = new Line();
        separator.setStartX(0);
        separator.setEndX(0);
        separator.setStartY(10);
        separator.setEndY(40);
        separator.setStroke(Color.GRAY);
        
        HBox Price=new HBox(5);
        Label fulldayprice=new Label("Full Day\n500.95 SR");
        Label houryprice=new Label("Weak\n3500.8 SR");
        Price.getChildren().addAll(fulldayprice,separator,houryprice);
        Price.setStyle("-fx-alignment: center;");
        fulldayprice.setStyle("-fx-text-fill: grey; -fx-background-color: transparent;");
         houryprice.setStyle("-fx-text-fill: grey; -fx-background-color: transparent;");
         
         Button btsSubmit = new Button("Submit Order");
        btsSubmit.setStyle("-fx-background-color: #F7BF50; -fx-background-radius: 50; ");
          
          
        
        
        
        //set image & date (setCenter if user Book Now)
         Date=new VBox(15);
        Date.getChildren().addAll(HreceiptDate,HdeliveryDate,Vdetailsimag,Price,btsSubmit);
        Date.setPadding(new Insets(20));
        Date.setStyle(" -fx-background-color:white; ");
        
//-------------------------------------------------------------------------------------------------//        
/////////////////////////////// start Details interface//////////////////////////////////////////////
//-------------------------------------------------------------------------------------------------//

        
        
        
        
        ///-----------------------------------------------------------------------------///
///-----------------------------  Singup  page-----------------------------///
///-----------------------------------------------------------------------------///
   // SignUp Icon
        Circle SignUpIconCir = new Circle(25);
        SignUpIconCir.setFill(Color.rgb(247, 191, 80));
        Image userIcon = new Image("file:C:\\Users\\lap12\\OneDrive\\المستندات\\برمجة متقدمة\\project\\src\\main\\java\\com\\mycompany\\project\\cars\\user-icon.png"); 
        ImageView userIconImageView = new ImageView(userIcon);
        userIconImageView.setFitWidth(30);
        userIconImageView.setFitHeight(30);
        StackPane SignUpIconPane = new StackPane(SignUpIconCir,userIconImageView);
        
        
        // Welcom Message
        SignUpText = new Text("Sign Up");
        SignUpText.setFont(Font.font("",FontWeight.BOLD,14));
        WelcomeText = new Text("Find your dream car!");
        
        Label helloMssg = new Label("Hello ");
        Label helloName = new Label();
        helloName.setTextFill(Color.rgb(247, 191, 80));
        helloName.setFont(Font.font("", FontWeight.BOLD,12));
        
        HBox helloMssgPane = new HBox(helloMssg,helloName);
        helloMssgPane.setAlignment(Pos.CENTER);
        
        VBox welcomePane = new VBox(2);
        welcomePane.setAlignment(Pos.CENTER);
        welcomePane.getChildren().addAll(SignUpText,helloMssgPane,WelcomeText);
        
       
       
        // Icon(Full name) 
        Image nameIcon = new Image("file:C:\\Users\\lap12\\OneDrive\\المستندات\\برمجة متقدمة\\project\\src\\main\\java\\com\\mycompany\\project\\cars\\name-icon.png"); 
        ImageView nameIconImageView = new ImageView(nameIcon);
        nameIconImageView.setFitWidth(20);
        nameIconImageView.setFitHeight(20);
        
        // (Full name) Field
        TextField nameField = new TextField();
        nameField.setPrefWidth(200);
        nameField.setPromptText("Full name");
        nameField.setStyle("-fx-focus-color: transparent; -fx-faint-focus-color: transparent; -fx-border-color:#FFC503;");
        HBox.setHgrow(nameField, javafx.scene.layout.Priority.ALWAYS); // Let Text Field Take The Whole Remainaing Space     
        HBox namePane = new HBox(5);
        namePane.setPadding(new Insets(0,0,0,5));
        namePane.setStyle("-fx-background-color: white; -fx-background-radius: 1;");
        namePane.getChildren().addAll(nameIconImageView,nameField);
        namePane.setAlignment(Pos.CENTER_LEFT);
        
        // Binding 
        helloName.textProperty().bind(nameField.textProperty());
        
        // Icon(Email) 
        Image emailIcon = new Image("file:C:\\Users\\lap12\\OneDrive\\المستندات\\برمجة متقدمة\\project\\src\\main\\java\\com\\mycompany\\project\\cars\\email-icon.png"); 
        ImageView emailIconImageView = new ImageView(emailIcon);
        emailIconImageView.setFitWidth(23);
        emailIconImageView.setFitHeight(23);
        
        // Field(Email)
        TextField emailField = new TextField();
        emailField.setPrefWidth(200);
        emailField.setPromptText("Email");
        emailField.setStyle("-fx-focus-color: transparent; -fx-faint-focus-color: transparent; -fx-border-color:#FFC503");
        HBox.setHgrow(emailField, javafx.scene.layout.Priority.ALWAYS); // Let Text Field Take The Whole Remainaing Space   
        HBox emailPane = new HBox(5);
        emailPane.setPadding(new Insets(0,0,0,5));
        emailPane.setStyle("-fx-background-color: white; -fx-background-radius: 1;");
        emailPane.getChildren().addAll(emailIconImageView,emailField);
        emailPane.setAlignment(Pos.CENTER_LEFT);
        
        
        //Icon(Phone number)
        Image PhoneIcon = new Image("file:C:\\Users\\lap12\\OneDrive\\المستندات\\برمجة متقدمة\\project\\src\\main\\java\\com\\mycompany\\project\\cars\\phone-icon.png"); 
        ImageView PhoneIconImageView = new ImageView(PhoneIcon);
        PhoneIconImageView.setFitWidth(20);
        PhoneIconImageView.setFitHeight(20);
        
        //Field(Phone number)
        TextField PhoneField = new TextField();
        PhoneField.setPrefWidth(190);
        PhoneField.setPromptText("Phone number");
        PhoneField.setStyle("-fx-focus-color: transparent; -fx-faint-focus-color: transparent; -fx-border-color:#FFC503");
        HBox.setHgrow(PhoneField, javafx.scene.layout.Priority.ALWAYS); // Let Text Field Take The Whole Remainaing Space
        HBox PhonePane = new HBox(5);
        PhonePane.setPadding(new Insets(0,0,0,5));
        PhonePane.setStyle("-fx-background-color: white; -fx-background-radius: 1;");
        PhonePane.getChildren().addAll(PhoneIconImageView,PhoneField);
        PhonePane.setAlignment(Pos.CENTER_LEFT);
        
       
        // Icon(Password)
        Image passIcon = new Image("file:C:\\Users\\lap12\\OneDrive\\المستندات\\برمجة متقدمة\\project\\src\\main\\java\\com\\mycompany\\project\\cars\\password-icon.png");
        ImageView passIconImageView = new ImageView(passIcon);
        passIconImageView.setFitWidth(18);
        passIconImageView.setFitHeight(18);
        
        // Field(Password)
        PasswordField passField = new PasswordField();
        passField.setPromptText("Password");
        passField.setStyle("-fx-focus-color: transparent; -fx-faint-focus-color: transparent; -fx-border-color:#FFC503");
        HBox.setHgrow(passField, javafx.scene.layout.Priority.ALWAYS); // Let Text Field Take The Whole Remainaing Space
        HBox passPane = new HBox(5);
        passPane.setPadding(new Insets(0,0,0,5));
        passPane.setStyle("-fx-background-color: white; -fx-background-radius: 1;");
        passPane.getChildren().addAll(passIconImageView,passField);
        passPane.setAlignment(Pos.CENTER_LEFT);
        
        
        
        // Icon Confirm
        Image ConIcon = new Image("file:C:\\Users\\lap12\\OneDrive\\المستندات\\برمجة متقدمة\\project\\src\\main\\java\\com\\mycompany\\project\\cars\\password-icon.png");
        ImageView ConIconImageView = new ImageView(ConIcon);
        ConIconImageView.setFitWidth(18);
        ConIconImageView.setFitHeight(18);
        
        // Field Confirm
        PasswordField ConField = new PasswordField();
        ConField.setPromptText("Confirm");
        ConField.setStyle("-fx-focus-color: transparent; -fx-faint-focus-color: transparent; -fx-border-color:#FFC503");
        HBox.setHgrow(ConField, javafx.scene.layout.Priority.ALWAYS); // Let Text Field Take The Whole Remainaing Space
        HBox ConPane = new HBox(5);
        ConPane.setPadding(new Insets(0,0,0,5));
        ConPane.setStyle("-fx-background-color: white; -fx-background-radius: 1;");
        ConPane.getChildren().addAll(ConIconImageView,ConField);
        ConPane.setAlignment(Pos.CENTER_LEFT);
        
        
        Label errorMsg=new Label();
        errorMsg.setTextFill(Color.RED);
        errorMsg.setFont(Font.font("",11));
        
        // Sign Up Button
        Button singnUpButt = new Button("Sign Up");
        singnUpButt.setStyle("-fx-background-color: #F7BF50; -fx-text-fill: white; -fx-font-weight: bold;");
        singnUpButt.setPrefWidth(250);
        singnUpButt.setPadding(new Insets(5));
        
        // Error Message And Sign Up Pane
        VBox signAndError = new VBox(1,errorMsg,singnUpButt);
        
        // Login
        Text havaAccountText = new Text("Already have an account? ");
        havaAccountText.setFill(Color.GREY);
        
        //label login to loging interface from sinup interface
        Label toLog = new Label("Login");
        toLog.setStyle("-fx-text-fill:#EBBF50;");
        
        
           //action to Home interface
        singnUpButt.setOnAction(event -> {
        if (singnUpButt.getText().equals("Sign Up")) {
            // Remove Error Message If Exist
           errorMsg.setText("");
           
        // Form Validation
            // Empty Field Validation
            if (nameField.getText().isEmpty()||emailField.getText().isEmpty()||PhoneField.getText().isEmpty()||passField.getText().isEmpty()||ConField.getText().isEmpty()) {
                errorMsg.setText("Fields can't be empty!");
            }
             // Name Validation
            else if (nameField.getText().matches(".*\\d.*")) {
                errorMsg.setText("Name can't contain numbers!");
            }
            
            // Email Validation
            else if (!emailField.getText().matches("^(.+)@(gmail.com)$")) {
                errorMsg.setText("Invalid email! (email@gmail.com)");
            }
            
            // Phone Numbet Validation
            else if (PhoneField.getText().length()!= 10||!PhoneField.getText().matches(".*\\d.*")||!PhoneField.getText().startsWith("05")) {
                errorMsg.setText("Invalid phone number! (05XXXXXXXX)");
            }
            // Password Matching 
            else if (!passField.getText().equals(ConField.getText())) {
                errorMsg.setText("Password don't match!");
            }
            
            else if (!checkPhoneExist(PhoneField.getText()).equals("")) {
                errorMsg.setText("Phone number already exist!");
            }
            else {
                addNewUser(nameField.getText(),emailField.getText(),PhoneField.getText(),passField.getText());
                stage.setScene(sceneHome);
                stage.show();
            }
        }
       
        });
        
        
        // Key Event (Move Between Fields By Enter Key)
        nameField.setOnKeyPressed(event -> {
        if (event.getCode() == KeyCode.ENTER) {
            emailField.requestFocus();
           }
        });

        emailField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                PhoneField.requestFocus();
            }
        });

        PhoneField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                passField.requestFocus();
            }
        });

        passField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                ConField.requestFocus();
            }
        });
        
        
        
        //action to swich between login &sinup interface
        toLog.setOnMouseClicked(event -> {
            stage.setScene(Loginscene);
            stage.show();
        });
        
        gotoLogPane = new HBox();
        gotoLogPane.setAlignment(Pos.CENTER);
        gotoLogPane.getChildren().addAll(havaAccountText,toLog);
        
        // All Content
        SignPane = new VBox(17);
        SignPane.setStyle("-fx-background-color:white;");
        SignPane.setAlignment(Pos.CENTER);
        SignPane.setPadding(new Insets (50, 30, 50, 30));
        SignPane.getChildren().addAll(SignUpIconPane,welcomePane,namePane,emailPane,PhonePane,passPane,ConPane,signAndError,gotoLogPane);    
       // End Login
         Singscene = new Scene(SignPane, 300, 480);
         


///-----------------------------------------------------------------------------///
///----------------------------- END Singup page-----------------------------///
///-----------------------------------------------------------------------------///


///-----------------------------------------------------------------------------///
///-----------------------------  login  page-----------------------------///
///-----------------------------------------------------------------------------///

           // SignUp Icon
        Circle LoginIconCir = new Circle(25);
        LoginIconCir.setFill(Color.rgb(247, 191, 80));
        Image userIconlogin = new Image("file:C:\\Users\\lap12\\OneDrive\\المستندات\\برمجة متقدمة\\project\\src\\main\\java\\com\\mycompany\\project\\cars\\user-icon.png"); 
        ImageView userIconImageViewLogin = new ImageView(userIconlogin);
        userIconImageViewLogin.setFitWidth(30);
        userIconImageViewLogin.setFitHeight(30);
        StackPane LoginIconPane = new StackPane(LoginIconCir,userIconImageViewLogin);
        
        
        // Welcom Message
        Text LoginText = new Text("Log In");
        LoginText.setFont(Font.font("",FontWeight.BOLD,14));
        Label WelcomeLogin = new Label("Welcome to RC");
        VBox welcomePaneLogin = new VBox(2);
        welcomePaneLogin.setAlignment(Pos.CENTER);
        welcomePaneLogin.getChildren().addAll(LoginText,WelcomeLogin);
        
       
        // Icon(Full name) 
        Image LognameIcon = new Image("file:C:\\Users\\lap12\\OneDrive\\المستندات\\برمجة متقدمة\\project\\src\\main\\java\\com\\mycompany\\project\\cars\\name-icon.png"); 
        ImageView LognameIconImageView = new ImageView(LognameIcon);
        LognameIconImageView.setFitWidth(20);
        LognameIconImageView.setFitHeight(20);
        
        // (Full name) Field
        TextField LognameField = new TextField();
        LognameField.setPrefWidth(200);
        LognameField.setPromptText("Phone number");
        LognameField.setStyle("-fx-focus-color: transparent; -fx-faint-focus-color: transparent; -fx-border-color:#FFC503;");
        HBox.setHgrow(nameField, javafx.scene.layout.Priority.ALWAYS); // Let Text Field Take The Whole Remainaing Space     
        HBox LognamePane = new HBox(5);
        LognamePane.setPadding(new Insets(0,0,0,5));
        LognamePane.setStyle("-fx-background-color: white; -fx-background-radius: 1;");
        LognamePane.getChildren().addAll(LognameIconImageView,LognameField);
        LognamePane.setAlignment(Pos.CENTER_LEFT);
        
        
       
        // Icon(Password)
        Image LogpassIcon = new Image("file:C:\\Users\\lap12\\OneDrive\\المستندات\\برمجة متقدمة\\project\\src\\main\\java\\com\\mycompany\\project\\cars\\password-icon.png");
        ImageView LogpassIconImageView = new ImageView(LogpassIcon);
        LogpassIconImageView.setFitWidth(18);
        LogpassIconImageView.setFitHeight(18);
        
        // Field(Password)
        PasswordField LogpassField = new PasswordField();
        LogpassField.setPromptText("Password");
        LogpassField.setStyle("-fx-focus-color: transparent; -fx-faint-focus-color: transparent; -fx-border-color:#FFC503");
        HBox.setHgrow(LogpassField, javafx.scene.layout.Priority.ALWAYS); // Let Text Field Take The Whole Remainaing Space
        HBox LogpassPane = new HBox(5);
        LogpassPane.setPadding(new Insets(0,0,0,5));
        LogpassPane.setStyle("-fx-background-color: white; -fx-background-radius: 1;");
        LogpassPane.getChildren().addAll(LogpassIconImageView,LogpassField);
        LogpassPane.setAlignment(Pos.CENTER_LEFT);





       // Login
        Text DonothavaAccount = new Text("Already have an account? ");
        DonothavaAccount.setFill(Color.GREY);
        
        //label login to loging interface from sinup interface
        Label gotosingtext = new Label("Sing up");
        gotosingtext.setStyle("-fx-text-fill:#EBBF50;");
        gotosingtext.setOnMouseClicked(event -> {
            stage.setScene(Singscene);
            stage.show();
        });
      
        gotoSingPane = new HBox();
        gotoSingPane.setAlignment(Pos.CENTER);
        gotoSingPane.getChildren().addAll(DonothavaAccount,gotosingtext);
        
        
        Label logErrorMsg=new Label();
        logErrorMsg.setTextFill(Color.RED);
        logErrorMsg.setFont(Font.font("",11));
        
        Button LogInButt = new Button("Log In");
        LogInButt.setStyle("-fx-background-color: #F7BF50; -fx-text-fill: white; -fx-font-weight: bold;");
        LogInButt.setPrefWidth(250);
        LogInButt.setPadding(new Insets(5));
         LogInButt.setOnAction(event -> {
            stage.setScene(sceneHome);
                stage.show();
        });
         
         
        VBox LogAndError = new VBox(1,logErrorMsg,LogInButt);
        
        
        //action to Home interface
        LogInButt.setOnAction(event -> {
           // Remove Error Message If Exist
           logErrorMsg.setText("");
           
        // Form Validation
            // Empty Field Validation
            if (LognameField.getText().isEmpty()|| LogpassField.getText().isEmpty()) {
                logErrorMsg.setText("Fields can't be empty!");
            }
            
            // Phone Numbet Validation
            else if (LognameField.getText().length()!= 10||!LognameField.getText().matches(".*\\d.*")||!LognameField.getText().startsWith("05")) {
                logErrorMsg.setText("Invalid phone number! (05XXXXXXXX)");
            }
            else if (!checkUserPassword(LognameField.getText(),LogpassField.getText())) {
                logErrorMsg.setText("Wrong phone number or password! try again");
                
            }
            else {
                //retrive User list
                session = HibernateUtil.getSessionFactory().openSession();
                List<User> uList = null;
                String queryStr = "from User";
                Query query = session.createQuery(queryStr); 
                uList = query.list();
                session.close();  
                for(User u: uList){
                    if (u.getPhoneNumber().equals(LognameField.getText())) {
                        currentUser = u;
                    }
                }
                stage.setScene(sceneHome);
                stage.show();
            }
       
        });

        LognameField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                LogpassField.requestFocus();
            }
        });
        
        LoginPane = new VBox(23);
        LoginPane.setStyle("-fx-background-color:white;");
        LoginPane.setAlignment(Pos.CENTER);
        LoginPane.setPadding(new Insets (50, 30, 50, 30));
        LoginPane.getChildren().addAll(LoginIconPane,welcomePaneLogin,LognamePane,LogpassPane,LogAndError,gotoSingPane);    
       // End Login
        Loginscene = new Scene(LoginPane, 300, 480); 


         


///-----------------------------------------------------------------------------///
///----------------------------- END login page-----------------------------///
///-----------------------------------------------------------------------------///
        
        
        
        
///_______________________________HOME__________________________________________///
      Image m1H= new Image("file:C:\\Users\\lap12\\OneDrive\\المستندات\\برمجة متقدمة\\project\\src\\main\\java\\com\\mycompany\\project\\cars\\baketorder.png");
        ImageView arrowH = new ImageView(m1H);
        arrowH.setFitHeight(25); 
        arrowH.setFitWidth(25);
        arrowH.setPreserveRatio(true);
        
        Label LarrowH=new Label();
        LarrowH.setGraphic(arrowH);
        LarrowH.setPadding(new Insets(0,0,5,0));
        
        LarrowH.setOnMouseClicked(event -> {
        L1.setText("Previous order");
         main.setCenter(order);
         stage.setScene(scenemain);
         stage.show();
        });
       
       

        Label L1H = new Label("RC");
        L1H.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-alignment: center; -fx-font-family: Arial; ");
        
        VBox menuIconH = new VBox(3); // 5 is the spacing between lines
        menuIconH.setAlignment(Pos.TOP_RIGHT);

        
        Label logoutH=new Label();
        ImageView logout = new ImageView(new Image("file:C:\\Users\\lap12\\OneDrive\\المستندات\\برمجة متقدمة\\project\\src\\main\\java\\com\\mycompany\\project\\cars\\logoutpng.png"));
        logout.setFitHeight(25); 
        logout.setFitWidth(24);
        logout.setPreserveRatio(true);
        logoutH.setGraphic(logout);
        logoutH.setAlignment(Pos.TOP_CENTER);
        menuIconH.getChildren().addAll(logoutH);

        
        menuIconH.setOnMouseClicked (new EventHandler<MouseEvent> () {
            
        public void handle (MouseEvent mouseEvent) {
            currentUser = null;
           Platform.exit();
            Application.launch(App.class);
    
         }
        });

      
        HBox h1H=new HBox(90);
        
        h1H.setAlignment(Pos.TOP_CENTER);
        h1H.setPadding(new Insets(10,0,0,0));
        h1H.setStyle("-fx-background-color:#FFC503;");
        h1H.getChildren().addAll(LarrowH,L1H,menuIconH);
                 
//////////////////////////////////////////////////////////////////////////////////////////////////     
      Image m2H= new Image("file:C:\\Users\\lap12\\OneDrive\\المستندات\\برمجة متقدمة\\project\\src\\main\\java\\com\\mycompany\\project\\cars\\Lgo.jpg");
        ImageView logo= new ImageView(m2H);
        logo.setFitHeight(170); 
        logo.setFitWidth(180);
        logo.setPreserveRatio(true);
        
        Button Smallcategory=new Button();
        Smallcategory.setStyle("-fx-background-color: white; -fx-border-color: #F7BF50; ");
        Image smallHome1 = new Image("file:C:\\Users\\lap12\\OneDrive\\المستندات\\برمجة متقدمة\\project\\src\\main\\java\\com\\mycompany\\project\\cars\\small.png"); 
        ImageView samllHomeView = new ImageView(smallHome1);
        samllHomeView.setFitWidth(75);
        samllHomeView.setFitHeight(75);
       Smallcategory.setGraphic(samllHomeView);
       Smallcategory.setPrefSize(80, 80);
       
       
        //replace scene to big car scene
        Smallcategory.setOnAction(event -> {
            L1.setText("Small Car");
         main.setCenter(scrollPane);
         stage.setScene(scenemain);
         stage.show();
        });
        
        
       
        Button Bigcategory=new Button();
        Bigcategory.setStyle("-fx-background-color: white; -fx-border-color: #F7BF50;  ");
         Smallcategory.setStyle("-fx-background-color: white; -fx-border-color: #F7BF50; ");
        Image bigHome = new Image("file:C:\\Users\\lap12\\OneDrive\\المستندات\\برمجة متقدمة\\project\\src\\main\\java\\com\\mycompany\\project\\cars\\big.png"); 
        ImageView bigHomeView = new ImageView(bigHome);
        bigHomeView.setFitWidth(75);
        bigHomeView.setFitHeight(75);
        Bigcategory.setPrefSize(80, 80);
        Bigcategory.setGraphic(bigHomeView);
        //replace scene to big car scene
        Bigcategory.setOnAction(event -> {
         L1.setText("Big Car");
         main.setCenter(bigscrollPane);
         stage.setScene(scenemain);
         stage.show();
        });
       
        



        Button Sportcategory=new Button();
         Smallcategory.setStyle("-fx-background-color: white; -fx-border-color: #F7BF50; ");
        Image sportHome = new Image("file:C:\\Users\\lap12\\OneDrive\\المستندات\\برمجة متقدمة\\project\\src\\main\\java\\com\\mycompany\\project\\cars\\sport.png"); 
        ImageView sportHomeView = new ImageView(sportHome);
        sportHomeView.setFitWidth(75);
        sportHomeView.setFitHeight(75);
        Sportcategory.setStyle("-fx-background-color: white; -fx-border-color: #F7BF50;  ");
        Sportcategory.setPrefSize(80, 80);
        Sportcategory.setGraphic(sportHomeView);
        //replace scene to sport car scene
        Sportcategory.setOnAction(event -> {
          L1.setText("Sport Car");
         main.setCenter(sportscrollPane);
         stage.setScene(scenemain);
         stage.show();
        });


        Button Electriccategory=new Button();
        Electriccategory.setStyle("-fx-background-color: white; -fx-border-color: #F7BF50;  ");
         Electriccategory.setPrefSize(80, 80);
        Image ElectricHome1 = new Image("file:C:\\Users\\lap12\\OneDrive\\المستندات\\برمجة متقدمة\\project\\src\\main\\java\\com\\mycompany\\project\\cars\\eleicon.png"); 
        ImageView ElectricHomeView = new ImageView(ElectricHome1);
        ElectricHomeView.setFitWidth(75);
        ElectricHomeView.setFitHeight(75);
        Electriccategory.setGraphic(ElectricHomeView);
        //replace scene to sport car scene
        Electriccategory.setOnAction(event -> {
         L1.setText("Electric Car");
         main.setCenter(electricscrollPane);
         stage.setScene(scenemain);
         stage.show();
        });
        
        
        HBox R1=new HBox(0);
        R1.setAlignment(Pos.CENTER);
        R1.getChildren().addAll(Smallcategory,Bigcategory);
        HBox R2=new HBox(0);
        R2.setAlignment(Pos.CENTER);
        R2.getChildren().addAll(Sportcategory,Electriccategory);
        VBox col= new VBox(0);
         col.getChildren().addAll(R1,R2);
         col.setAlignment(Pos.CENTER);
         VBox home=new VBox(10);
         home.setAlignment(Pos.CENTER);
         home.getChildren().addAll(logo,col);
        
     
       
        BorderPane HomePane=new BorderPane(); 
        HomePane.setTop(h1H);
        HomePane.setCenter(home);
        
        HomePane.setStyle("-fx-background-color: white;");
        sceneHome = new Scene(HomePane, 300, 480);
        
        




///-----------------------End Home-------------------------------------------///





///-----------------------------------------------------------------------------///
///-----------------------------Small car page------------------------------------///
///-----------------------------------------------------------------------------///

       
//////////////////////////Header:arrow/////////////////////////////////////////////
        HBox h1=new HBox(60);
        Image m1= new Image("file:C:\\Users\\lap12\\OneDrive\\المستندات\\برمجة متقدمة\\project\\src\\main\\java\\com\\mycompany\\project\\cars\\arror.png");
        ImageView arrow = new ImageView(m1);
        arrow.setFitHeight(35); 
        arrow.setFitWidth(25);
        arrow.setPreserveRatio(true);
        
        
        Label Larrow=new Label();
        Larrow.setGraphic(arrow);
         Larrow.setPadding(new Insets(0,0,5,0));
        
        
       
       

         L1 = new Label("Small Car");
        L1.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-alignment: center; -fx-font-family: Arial; ");
        
        VBox menuIcon = new VBox(3); // 5 is the spacing between lines
        menuIcon.setAlignment(Pos.TOP_RIGHT);

   
        
        h1.setAlignment(Pos.TOP_CENTER);
        h1.setPadding(new Insets(10,0,0,0));
        h1.setStyle("-fx-background-color:#FFC503;");
        h1.getChildren().addAll(Larrow,L1,menuIcon);
                 
//////////////////////////////////////////////////////////////////////////////////////////////////     
        HBox h2=new HBox(10);
        
      
        
        RadioButton colorcar1 = new RadioButton("Black");
         colorcar1.setStyle("-fx-font-size: 10px;");
        RadioButton colorcar2 = new RadioButton("Blue");
         colorcar2.setStyle("-fx-font-size: 10px;");
        RadioButton colorcar3 = new RadioButton("White");
         colorcar3.setStyle("-fx-font-size: 10px; ");
         RadioButton allcolorcarsmall= new RadioButton("All");
         allcolorcarsmall.setStyle("-fx-font-size: 10px; ");
          
        
        ToggleGroup color = new ToggleGroup();
        colorcar1.setToggleGroup(color);
        colorcar2.setToggleGroup(color);
        colorcar3.setToggleGroup(color);
        allcolorcarsmall.setToggleGroup(color);
        
        
        h2.setPadding(new Insets(15,6,5,35));
       
        
        h2.getChildren().addAll(colorcar1,colorcar2,colorcar3,allcolorcarsmall);
        
/////////////////////////////////////////////////////////////////////////////////////////////////////////       
//------------------------------- Start small Car Info--------------------------------------------------//
//////////////////////////////////////////////////////////////////////////////////////////////////////////


//-----------------     Start First car    -------------//
         
      
        //-----small white var----//
        VBox smallCarPane1=new VBox(3);
        smallCarPane1.setPrefSize(200, 60);
        smallCarPane1.setPadding(new Insets(5,0,5,5));
        smallCarPane1.setStyle("-fx-background-color:white; -fx-border-color:  #FFC503; ");
        smallCarPane1.setPrefWidth(130);
        smallCarPane1.setPadding(new Insets(5));
        
        VBox VsmallCar1=new VBox(5);
        VsmallCar1.setAlignment(Pos.CENTER);
       
        
        // Car image
        Image smallcar1 = new Image("file:C:\\Users\\lap12\\OneDrive\\المستندات\\برمجة متقدمة\\project\\src\\main\\java\\com\\mycompany\\project\\cars\\white1.png"); 
        ImageView smallcar1View = new ImageView(smallcar1);
        smallcar1View.setFitWidth(90);
        smallcar1View.setFitHeight(60);
        
        Car Scar1 = new Car(); 
        Scar1.setCar_id(1); 
        Scar1.setCategory("small"); 
        Scar1.setColor("white"); 
        Scar1.setName_car("Toyota Yaris 2023");
        
        
       
        // Car Name
        Label smallCarName1 = new Label(Scar1.getName_car());
        smallCarName1.setFont(Font.font("",FontWeight.BOLD,10));
        smallCarName1.setAlignment(Pos.CENTER);
        
        
        // Location 
        Label smallLocationName1 = new Label("10000 SAR");
        smallLocationName1.setFont(Font.font("",FontWeight.BOLD,10));
        
      
        //Button Book Now
        Button btsmallBookPane1 = new Button("Book Now");
        btsmallBookPane1.setStyle("-fx-background-color: #F7BF50; -fx-background-radius: 50; ");
         
     
        
         VsmallCar1.getChildren().addAll(smallCarName1,smallcar1View,smallLocationName1,btsmallBookPane1);
         smallCarPane1.getChildren().addAll(VsmallCar1);
          smallCarPane1.setAlignment(Pos.CENTER);
        
      
            
        
//////////////////////////// End First car//////////////////////////////////////////////////////////
    
/////////////////////////////Start Second car///////////////////////////////////////////////////////
         VBox smallCarPane2=new VBox(3);
        smallCarPane2.setPrefSize(200, 60);
        smallCarPane2.setPadding(new Insets(5,0,5,0));
        smallCarPane2.setStyle("-fx-background-color:white; -fx-border-color: #F7BF50; ");
        smallCarPane2.setPrefWidth(130);
        smallCarPane2.setPadding(new Insets(5));
        
        VBox VsmallCar2=new VBox(10);
        VsmallCar2.setAlignment(Pos.CENTER);
        
        // Car Image
        Image smallImage2 = new Image("file:C:\\Users\\lap12\\OneDrive\\المستندات\\برمجة متقدمة\\project\\src\\main\\java\\com\\mycompany\\project\\cars\\car_yellow.jpg"); 
        ImageView smallImage2View = new ImageView(smallImage2);
        smallImage2View.setFitWidth(90);
        smallImage2View.setFitHeight(58);
        
        Car Scar2 = new Car(); 
        Scar2.setCar_id(2); 
        Scar2.setCategory("small"); 
        Scar2.setColor("yellow"); 
        Scar2.setName_car("Mahindra Thar");
        
        
        
        // Car Name
        Label smallCarName2 = new Label(Scar2.getName_car());
        smallCarName2.setFont(Font.font("",FontWeight.BOLD,10));
        
        // Location 
        Text smallLocationName2 = new Text("12000 SAR");
        smallLocationName2.setFont(Font.font("",FontWeight.BOLD,10));
        
      
        
        // Button Book Now
        Button btsmallBookPane2 = new Button("Book Now");
        btsmallBookPane2.setStyle("-fx-background-color: #F7BF50; -fx-background-radius: 50; ");
      
        
        
        VsmallCar2.getChildren().addAll(smallCarName2,smallImage2View,smallLocationName2,btsmallBookPane2);
         smallCarPane2.getChildren().addAll(VsmallCar2);
         smallCarPane2.setAlignment(Pos.CENTER);
        
        //set action to display details smallcar1 
        btsmallBookPane2.setOnAction(event -> {
          btsmallBookPane2.setStyle("-fx-background-color: white; ");
        });
        
////////////////////////////End Second car///////////////////////////////////////////////////////// 
 

////////////////////////Start Third car/////////////////////////////////////////////////////////////
       VBox smallCarPane3=new VBox(3);
        smallCarPane3.setPrefSize(200, 60);
        smallCarPane3.setPadding(new Insets(5,0,5,0));
        smallCarPane3.setStyle("-fx-background-color:white; -fx-border-color: #F7BF50; ");
        smallCarPane3.setPrefWidth(130);
        smallCarPane3.setPadding(new Insets(5));
        
        VBox VsmallCar3=new VBox(10);
        VsmallCar3.setAlignment(Pos.CENTER);
        
        //Car image
        Image smallImage3 = new Image("file:C:\\Users\\lap12\\OneDrive\\المستندات\\برمجة متقدمة\\project\\src\\main\\java\\com\\mycompany\\project\\cars\\white2.png"); 
        ImageView smallImage3View = new ImageView(smallImage3);
        smallImage3View.setFitWidth(90);
        smallImage3View.setFitHeight(60);
        
        
        Car Scar3 = new Car(); 
        Scar3.setCar_id(3); 
        Scar3.setCategory("small"); 
        Scar3.setColor("white"); 
        Scar3.setName_car("Kia Pegas 2024");
        
        
        // Car Name
        Label smallCarName3 = new Label(Scar3.getName_car());
        smallCarName3.setFont(Font.font("",FontWeight.BOLD,10));
        
        // Location 
        Text smallLocationName3 = new Text("20000 SAR");
        smallLocationName3.setFont(Font.font("",FontWeight.BOLD,10));

        // Car Button Book Now
        Button btsmallBookPane3 = new Button("Book Now");
        btsmallBookPane3.setStyle("-fx-background-color: #F7BF50; -fx-background-radius: 50; ");
       
        
        
        VsmallCar3.getChildren().addAll(smallCarName3,smallImage3View,smallLocationName3,btsmallBookPane3);
        smallCarPane3.getChildren().add(VsmallCar3);
        
        //set action to display details smallcar1 
        btsmallBookPane3.setOnAction(event -> {
          btsmallBookPane3.setStyle("-fx-background-color: white; ");
        });
        
/////////////////////////////////End Third car/////////////////////////////////////////////////////////////////

////////////////////////Start Fourth car/////////////////////////////////////////////////////////////
       VBox smallCarPane4=new VBox(5);
        smallCarPane4.setPrefSize(200, 60);
        smallCarPane4.setPadding(new Insets(5,0,5,0));
        smallCarPane4.setStyle("-fx-background-color:white; -fx-border-color: #F7BF50; ");
        smallCarPane4.setPrefWidth(130);
        smallCarPane4.setPadding(new Insets(5));
        
        VBox VsmallCar4=new VBox(10);
        VsmallCar4.setAlignment(Pos.CENTER);
        
        //Car image
        Image smallImage4 = new Image("file:C:\\Users\\lap12\\OneDrive\\المستندات\\برمجة متقدمة\\project\\src\\main\\java\\com\\mycompany\\project\\cars\\Suzukiblue1.png"); 
        ImageView smallImage4View = new ImageView(smallImage4);
        smallImage4View.setFitWidth(90);
        smallImage4View.setFitHeight(60);
        
       
        Car Scar4 = new Car(); 
        Scar4.setCar_id(4); 
        Scar4.setCategory("small"); 
        Scar4.setColor("blue"); 
        Scar4.setName_car("Suzuki Baleno 2023");
        
        
        
        // Car Name
        Label smallCarName4 = new Label(Scar4.getName_car());
        smallCarName4.setFont(Font.font("",FontWeight.BOLD,10));
        
        // Location 
        Label smallLocationName4 = new Label("10000 SAR");
        smallLocationName4.setFont(Font.font("",FontWeight.BOLD,10));
        
 
        
        // Car Button Book Now
        Button btsmallBookPane4 = new Button("Book Now");
        btsmallBookPane4.setStyle("-fx-background-color: #F7BF50; -fx-background-radius: 50; ");
        
        
        
        VsmallCar4.getChildren().addAll(smallCarName4,smallImage4View,smallLocationName4,btsmallBookPane4);
        smallCarPane4.getChildren().add(VsmallCar4);
        
        //set action to display details smallcar1 
        btsmallBookPane4.setOnAction(event -> {
          btsmallBookPane4.setStyle("-fx-background-color: white; ");
        });
        
////////////////////////////End Fourth car/////////////////////////////////////////////////////////////////


////////////////////////Start Fifth car/////////////////////////////////////////////////////////////
       VBox smallCarPane5=new VBox(5);
        smallCarPane5.setPrefSize(200, 60);
        smallCarPane5.setPadding(new Insets(5,0,5,0));
        smallCarPane5.setStyle("-fx-background-color:white; -fx-border-color: #F7BF50; ");
        smallCarPane5.setPrefWidth(130);
        smallCarPane5.setPadding(new Insets(5));
        VBox VsmallCar5=new VBox(10);
        VsmallCar5.setAlignment(Pos.CENTER);
        
        //Car image
        Image smallImage5 = new Image("file:C:\\Users\\lap12\\OneDrive\\المستندات\\برمجة متقدمة\\project\\src\\main\\java\\com\\mycompany\\project\\cars\\yarisblack1.png"); 
        ImageView smallImage5View = new ImageView(smallImage5);
        smallImage5View.setFitWidth(90);
        smallImage5View.setFitHeight(60);
        
        
        Car Scar5 = new Car(); 
        Scar5.setCar_id(5); 
        Scar5.setCategory("small"); 
        Scar5.setColor("black"); 
        Scar5.setName_car("Toyota Yaris 2024");
        
        
        
        // Car Name
        Label smallCarName5 = new Label(Scar5.getName_car());
        smallCarName5.setFont(Font.font("",FontWeight.BOLD,10));
        
        // Location 
        Label smallLocationName5 = new Label("70000 SAR");
        smallLocationName5.setFont(Font.font("",FontWeight.BOLD,10));
        
        
        // Car Button Book Now
        Button btsmallBookPane5= new Button("Book Now");
        btsmallBookPane5.setStyle("-fx-background-color: #F7BF50; -fx-background-radius: 50; ");
        
        VsmallCar5.getChildren().addAll(smallCarName5,smallImage5View,smallLocationName5,btsmallBookPane5);
        smallCarPane5.getChildren().add(VsmallCar5);
        
        //set action to display details smallcar1 
        btsmallBookPane5.setOnAction(event -> {
          btsmallBookPane5.setStyle("-fx-background-color: white; ");
        });
        
////////////////////////////End Fifth car/////////////////////////////////////////////////////////////////



////////////////////////Start Sixth car/////////////////////////////////////////////////////////////
       VBox smallCarPane6=new VBox(5);
        smallCarPane6.setPrefSize(200, 60);
        smallCarPane6.setPadding(new Insets(5,0,5,0));
        smallCarPane6.setStyle("-fx-background-color:white; -fx-border-color: #F7BF50; ");
        smallCarPane6.setPrefWidth(130);
        smallCarPane6.setPadding(new Insets(5));
        
        VBox VsmallCar6=new VBox(10);
        VsmallCar6.setAlignment(Pos.CENTER);
        
        //Car image
        Image smallImage6 = new Image("file:C:\\Users\\lap12\\OneDrive\\المستندات\\برمجة متقدمة\\project\\src\\main\\java\\com\\mycompany\\project\\cars\\Sunnybrowen.png"); 
        ImageView smallImage6View = new ImageView(smallImage6);
        smallImage6View.setFitWidth(90);
        smallImage6View.setFitHeight(60);
        
        // Data Base
        Car Scar6 = new Car(); 
        Scar6.setCar_id(6); 
        Scar6.setCategory("small"); 
        Scar6.setColor("browen"); 
        Scar6.setName_car("Nissan Sunny 2023");

        
        // Car Name
        Label smallCarName6 = new Label(Scar6.getName_car());
        smallCarName6.setFont(Font.font("",FontWeight.BOLD,10));
        
        // Location 
        Label smallLocationName6 = new Label("90000 SAR");
        smallLocationName6.setFont(Font.font("",FontWeight.BOLD,10));
        
        
        // Car Button Book Now
        Button btsmallBookPane6= new Button("Book Now");
        btsmallBookPane6.setStyle("-fx-background-color: #F7BF50; -fx-background-radius: 50; ");
        
        VsmallCar6.getChildren().addAll(smallCarName6,smallImage6View,smallLocationName6,btsmallBookPane6);
        smallCarPane6.getChildren().add(VsmallCar6);
        
        //set action to display details smallcar1 
        btsmallBookPane5.setOnAction(event -> {
          btsmallBookPane5.setStyle("-fx-background-color: white; ");
        });
        
////////////////////////////End Sixth car/////////////////////////////////////////////////////////////////


    
 /////////////////////////////////////////////////////////////////////////////   
//___________________________All Small Cars________________________________________// 
        FlowPane smallAllCars = new FlowPane(Orientation.HORIZONTAL,5,5);
        smallAllCars.setAlignment(Pos.CENTER);
        smallAllCars.setStyle("-fx-background-color: white;");
        smallAllCars.getChildren().addAll(smallCarPane1,smallCarPane2,smallCarPane3,smallCarPane4,smallCarPane5,smallCarPane6);
          
          
        VBox allSmallCar = new VBox(5);
        allSmallCar.setPadding(new Insets(5));
        allSmallCar.setAlignment(Pos.CENTER);
        allSmallCar.getChildren().addAll(h2,smallAllCars);
        allSmallCar.setStyle("-fx-background-color: white;");
        
    
        
        // Color Radio Event (Filter)
        colorcar1.setOnAction(e -> {handleColorSelection(smallAllCars,smallCarPane5);});
        colorcar2.setOnAction(e -> {handleColorSelection(smallAllCars,smallCarPane4);});
        colorcar3.setOnAction(e -> {handleColorSelection(smallAllCars,smallCarPane1,smallCarPane3);});
        allcolorcarsmall.setOnAction(e -> {handleColorSelection(smallAllCars,smallCarPane1,smallCarPane2,smallCarPane3,smallCarPane4,smallCarPane5,smallCarPane6);});
        
        
        
        Larrow.setOnMouseClicked(event -> {
        
        stage.setScene(sceneHome);
        stage.show();
        });
        
        
    // End Car Info
       
         scrollPane = new ScrollPane(allSmallCar);
        scrollPane.setFitToWidth(true);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setStyle("-fx-background-color: white;");
        
        main=new BorderPane(); 
        main.setTop(h1);
        main.setCenter(scrollPane);
       
        main.setStyle("-fx-background-color: white;");
         scenemain = new Scene(main, 300, 480);
///-----------------------------------------------------------------------------///
///----------------------------- END Small car page-----------------------------///
///-----------------------------------------------------------------------------///
      

                 
///-----------------------------------------------------------------------------///
///----------------------------- Big car page-----------------------------///
///-----------------------------------------------------------------------------///       
//////////////////////////Header:arrow/////////////////////////////////////////////

 
        HBox bigh2=new HBox(10);
        
        
        RadioButton bigcolorcar1 = new RadioButton("Black");
         bigcolorcar1.setStyle("-fx-font-size: 10px;");
        RadioButton bigcolorcar2 = new RadioButton("Blue");
         bigcolorcar2.setStyle("-fx-font-size: 10px;");
        RadioButton bigcolorcar3 = new RadioButton("White");
   
         bigcolorcar3.setStyle("-fx-font-size: 10px; -fx-selected-color: yellow;");
          
        
        ToggleGroup bigcolor = new ToggleGroup();
        bigcolorcar1.setToggleGroup(bigcolor);
        bigcolorcar2.setToggleGroup(bigcolor);
        bigcolorcar3.setToggleGroup(bigcolor);
        RadioButton allcolorcarbig= new RadioButton("All");
         allcolorcarbig.setStyle("-fx-font-size: 10px; ");
        allcolorcarbig.setToggleGroup(bigcolor);
        
        
        bigh2.setPadding(new Insets(15,6,5,35));
         
       
        
        bigh2.getChildren().addAll(bigcolorcar1,bigcolorcar2,bigcolorcar3,allcolorcarbig);
        
/////////////////////////////////////////////////////////////////////////////////////////////////////////       
//------------------------------- Start big Car Info--------------------------------------------------//
//////////////////////////////////////////////////////////////////////////////////////////////////////////


//-----------------     Start First car    -------------//
      
        //-----big white var----//
        VBox bigCarPane1=new VBox(3);
        bigCarPane1.setPrefSize(200, 60);
        bigCarPane1.setPadding(new Insets(5,0,5,5));
        bigCarPane1.setStyle("-fx-background-color:white; -fx-border-color:  #FFC503; ");
        bigCarPane1.setPrefWidth(130);
        bigCarPane1.setPadding(new Insets(5));
        
        VBox VbigCar1=new VBox(5);
        VbigCar1.setAlignment(Pos.CENTER);
       
        
        // Car image
        Image bigcar1 = new Image("file:C:\\Users\\lap12\\OneDrive\\المستندات\\برمجة متقدمة\\project\\src\\main\\java\\com\\mycompany\\project\\cars\\car1.jpg"); 
        ImageView bigcar1View = new ImageView(bigcar1);
        bigcar1View.setFitWidth(90);
        bigcar1View.setFitHeight(60);
        
        Car Bcar1 = new Car(); 
        Bcar1.setCar_id(7); 
        Bcar1.setCategory("big"); 
        Bcar1.setColor("white"); 
        Bcar1.setName_car("Chausson 2021");
        
        
       
        // Car Name
        Label bigCarName1 = new Label(Bcar1.getName_car());
        bigCarName1.setFont(Font.font("",FontWeight.BOLD,10));
        bigCarName1.setAlignment(Pos.CENTER);
        
        
        // Location 
        Label bigLocationName1 = new Label("10000 SAR");
        bigLocationName1.setFont(Font.font("",FontWeight.BOLD,10));
    
        
      
        //Button Book Now
        Button btbigBookPane1 = new Button("Book Now");
        btbigBookPane1.setStyle("-fx-background-color: #F7BF50; -fx-background-radius: 50; ");
         
     
        
         VbigCar1.getChildren().addAll(bigCarName1,bigcar1View,bigLocationName1,btbigBookPane1);
         bigCarPane1.getChildren().addAll(VbigCar1);
          bigCarPane1.setAlignment(Pos.CENTER);
        
        
        //set action to display details bigcar1 
        btbigBookPane1.setOnAction(event -> {
          btbigBookPane1.setStyle("-fx-background-color: white; ");
        });
//////////////////////////// End First car//////////////////////////////////////////////////////////
    
/////////////////////////////Start Second car///////////////////////////////////////////////////////
         VBox bigCarPane2=new VBox(3);
        bigCarPane2.setPrefSize(200, 60);
        bigCarPane2.setPadding(new Insets(5,0,5,0));
        bigCarPane2.setStyle("-fx-background-color:white; -fx-border-color: #F7BF50; ");
        bigCarPane2.setPrefWidth(130);
        bigCarPane2.setPadding(new Insets(5));
        
        VBox VbigCar2=new VBox(10);
        VbigCar2.setAlignment(Pos.CENTER);
        
        // Car Image
        Image bigImage2 = new Image("file:C:\\Users\\lap12\\OneDrive\\المستندات\\برمجة متقدمة\\project\\src\\main\\java\\com\\mycompany\\project\\cars\\car2.jpg"); 
        ImageView bigImage2View = new ImageView(bigImage2);
        bigImage2View.setFitWidth(90);
        bigImage2View.setFitHeight(58);
        
       
        
        // Car Name  
        Car Bcar2 = new Car(); 
        Bcar2.setCar_id(8); 
        Bcar2.setCategory("big"); 
        Bcar2.setColor("black"); 
        Bcar2.setName_car("Nissan Primastar");
        
        
        
        
        Label bigCarName2 = new Label(Bcar2.getName_car());
        bigCarName2.setFont(Font.font("",FontWeight.BOLD,10));
        
        // Location 
        Text bigLocationName2 = new Text("12000 SAR");
        bigLocationName2.setFont(Font.font("",FontWeight.BOLD,10));
       
        
        // Button Book Now
        Button btbigBookPane2 = new Button("Book Now");
        btbigBookPane2.setStyle("-fx-background-color: #F7BF50; -fx-background-radius: 50; ");
      
        
        
        VbigCar2.getChildren().addAll(bigCarName2,bigImage2View,bigLocationName2,btbigBookPane2);
         bigCarPane2.getChildren().addAll(VbigCar2);
         bigCarPane2.setAlignment(Pos.CENTER);
        
        //set action to display details bigcar1 
        btbigBookPane2.setOnAction(event -> {
          btbigBookPane2.setStyle("-fx-background-color: white; ");
        });
        
////////////////////////////End Second car///////////////////////////////////////////////////////// 
 

////////////////////////Start Third car/////////////////////////////////////////////////////////////
       VBox bigCarPane3=new VBox(3);
        bigCarPane3.setPrefSize(200, 60);
        bigCarPane3.setPadding(new Insets(5,0,5,0));
        bigCarPane3.setStyle("-fx-background-color:white; -fx-border-color: #F7BF50; ");
        bigCarPane3.setPrefWidth(130);
        bigCarPane3.setPadding(new Insets(5));
        
        VBox VbigCar3=new VBox(10);
        VbigCar3.setAlignment(Pos.CENTER);
        
        //Car image
        Image bigImage3 = new Image("file:C:\\Users\\lap12\\OneDrive\\المستندات\\برمجة متقدمة\\project\\src\\main\\java\\com\\mycompany\\project\\cars\\car3.jpg"); 
        ImageView bigImage3View = new ImageView(bigImage3);
        bigImage3View.setFitWidth(90);
        bigImage3View.setFitHeight(60);
        
       
        
        // Car Name
        Car Bcar3 = new Car(); 
        Bcar3.setCar_id(9); 
        Bcar3.setCategory("big"); 
        Bcar3.setColor("black"); 
        Bcar3.setName_car("renault kangoo 33");
        
       
        
        
        
        
        Label bigCarName3 = new Label(Bcar3.getName_car());
        bigCarName3.setFont(Font.font("",FontWeight.BOLD,10));
        
        // Location 
        Text bigLocationName3 = new Text("20000 SAR");
        bigLocationName3.setFont(Font.font("",FontWeight.BOLD,10));
        
        
        // Car Button Book Now
        Button btbigBookPane3 = new Button("Book Now");
        btbigBookPane3.setStyle("-fx-background-color: #F7BF50; -fx-background-radius: 50; ");
       
        
        
        VbigCar3.getChildren().addAll(bigCarName3,bigImage3View,bigLocationName3,btbigBookPane3);
        bigCarPane3.getChildren().add(VbigCar3);
        
        //set action to display details bigcar1 
        btbigBookPane3.setOnAction(event -> {
          btbigBookPane3.setStyle("-fx-background-color: white; ");
        });
        
/////////////////////////////////End Third car/////////////////////////////////////////////////////////////////

////////////////////////Start Fourth car/////////////////////////////////////////////////////////////
       VBox bigCarPane4=new VBox(5);
        bigCarPane4.setPrefSize(200, 60);
        bigCarPane4.setPadding(new Insets(5,0,5,0));
        bigCarPane4.setStyle("-fx-background-color:white; -fx-border-color: #F7BF50; ");
        bigCarPane4.setPrefWidth(130);
        bigCarPane4.setPadding(new Insets(5));
        
        VBox VbigCar4=new VBox(10);
        VbigCar4.setAlignment(Pos.CENTER);
        
        //Car image
        Image bigImage4 = new Image("file:C:\\Users\\lap12\\OneDrive\\المستندات\\برمجة متقدمة\\project\\src\\main\\java\\com\\mycompany\\project\\cars\\car4.jpg"); 
        ImageView bigImage4View = new ImageView(bigImage4);
        bigImage4View.setFitWidth(90);
        bigImage4View.setFitHeight(60);
        
        Car Bcar4 = new Car(); 
        Bcar4.setCar_id(10); 
        Bcar4.setCategory("big"); 
        Bcar4.setColor("blue"); 
        Bcar4.setName_car("Ord Transi");
        
        
        // Car Name
        Label bigCarName4 = new Label(Bcar4.getName_car());
        bigCarName4.setFont(Font.font("",FontWeight.BOLD,10));
        
        // Location 
        Label bigLocationName4 = new Label("10000 SAR");
        bigLocationName4.setFont(Font.font("",FontWeight.BOLD,10));
        
        
        // Car Button Book Now
        Button btbigBookPane4 = new Button("Book Now");
        btbigBookPane4.setStyle("-fx-background-color: #F7BF50; -fx-background-radius: 50; ");
        
        
        
        VbigCar4.getChildren().addAll(bigCarName4,bigImage4View,bigLocationName4,btbigBookPane4);
        bigCarPane4.getChildren().add(VbigCar4);
        
        //set action to display details bigcar1 
        btbigBookPane4.setOnAction(event -> {
          btbigBookPane4.setStyle("-fx-background-color: white; ");
        });
        
////////////////////////////End Fourth car/////////////////////////////////////////////////////////////////


////////////////////////Start Fifth car/////////////////////////////////////////////////////////////
       VBox bigCarPane5=new VBox(5);
        bigCarPane5.setPrefSize(200, 60);
        bigCarPane5.setPadding(new Insets(5,0,5,0));
        bigCarPane5.setStyle("-fx-background-color:white; -fx-border-color: #F7BF50; ");
        bigCarPane5.setPrefWidth(130);
        bigCarPane5.setPadding(new Insets(5));
        
        VBox VbigCar5=new VBox(10);
        VbigCar5.setAlignment(Pos.CENTER);
        
        //Car image
        Image bigImage5 = new Image("file:C:\\Users\\lap12\\OneDrive\\المستندات\\برمجة متقدمة\\project\\src\\main\\java\\com\\mycompany\\project\\cars\\car5.jpg"); 
        ImageView bigImage5View = new ImageView(bigImage5);
        bigImage5View.setFitWidth(90);
        bigImage5View.setFitHeight(60);
        
        Car Bcar5 = new Car(); 
        Bcar5.setCar_id(11); 
        Bcar5.setCategory("big"); 
        Bcar5.setColor("white"); 
        Bcar5.setName_car("Opel Zefira");
        
     
        
        // Car Name
        Label bigCarName5 = new Label(Bcar5.getName_car());
        bigCarName5.setFont(Font.font("",FontWeight.BOLD,10));
        
        // Location 
        Label bigLocationName5 = new Label("90000 SAR");
        bigLocationName5.setFont(Font.font("",FontWeight.BOLD,10));
        
        
        // Car Button Book Now
        Button btbigBookPane5= new Button("Book Now");
        btbigBookPane5.setStyle("-fx-background-color: #F7BF50; -fx-background-radius: 50; ");
        
        VbigCar5.getChildren().addAll(bigCarName5,bigImage5View,bigLocationName5,btbigBookPane5);
        bigCarPane5.getChildren().add(VbigCar5);
        
        //set action to display details bigcar1 
        btbigBookPane5.setOnAction(event -> {
          btbigBookPane5.setStyle("-fx-background-color: white; ");
        });
        
//////////////////////////End Fifth car/////////////////////////////////////////////////////////////////


 /////////////////////////////////////////////////////////////////////////////   
//___________________________All Cars________________________________________// 
        
        
        FlowPane allCars = new FlowPane(Orientation.HORIZONTAL,5,5);
        allCars.setAlignment(Pos.CENTER);
        allCars.setStyle("-fx-background-color: white;");
        allCars.getChildren().addAll(bigCarPane1,bigCarPane2,bigCarPane3 , bigCarPane4);
      
        VBox allbigCar = new VBox(5);
        allbigCar.setPadding(new Insets(5));
        allbigCar.setAlignment(Pos.CENTER);
        allbigCar.getChildren().addAll(bigh2,allCars);
        allbigCar.setStyle("-fx-background-color: white;");
        
        
    // End Car Info
       
         bigscrollPane = new ScrollPane(allbigCar);
        bigscrollPane.setFitToWidth(true);
        bigscrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        bigscrollPane.setStyle("-fx-background-color: white;");
        
        // Color Radio Event (Filter)
        bigcolorcar1.setOnAction(e -> {handleColorSelection(allCars,bigCarPane2,bigCarPane3);});
        bigcolorcar2.setOnAction(e -> {handleColorSelection(allCars,bigCarPane4);});
        bigcolorcar3.setOnAction(e -> {handleColorSelection(allCars,bigCarPane1);});
        allcolorcarbig.setOnAction(e -> {handleColorSelection(allCars,bigCarPane1,bigCarPane2,bigCarPane3,bigCarPane4);});
        
       
        main.setCenter(bigscrollPane);
        
///-----------------------------------------------------------------------------///
///----------------------------- END Big car page  -----------------------------///
///-----------------------------------------------------------------------------///





///-----------------------------------------------------------------------------///
///-----------------------------  Sport car page-----------------------------///
///-----------------------------------------------------------------------------///
        
       HBox sporth2 = new HBox(10);

        

        RadioButton sportcolorcar1 = new RadioButton("Yellow");
        sportcolorcar1.setStyle("-fx-font-size: 10px;");
        RadioButton sportcolorcar2 = new RadioButton("Blue");
        sportcolorcar2.setStyle("-fx-font-size: 10px;");
        RadioButton sportcolorcar3 = new RadioButton("Orange");
        sportcolorcar3.setStyle("-fx-font-size: 10px; -fx-selected-color: yellow;");

        ToggleGroup sportcolor = new ToggleGroup();
        sportcolorcar1.setToggleGroup(sportcolor);
        sportcolorcar2.setToggleGroup(sportcolor);
        sportcolorcar3.setToggleGroup(sportcolor);
         RadioButton allcolorcarsport= new RadioButton("All");
         allcolorcarsport.setStyle("-fx-font-size: 10px; ");
         allcolorcarsport.setToggleGroup(sportcolor);
        
        
        sporth2.setPadding(new Insets(15,6,5,35));
        

        sporth2.getChildren().addAll(sportcolorcar1, sportcolorcar2, sportcolorcar3,allcolorcarsport );

        //---------------- Start Sport Car Info ---------------------------------------------------------------------------
        
        Car Sportcar1 = new Car(); 
        Sportcar1.setCar_id(12); 
        Sportcar1.setCategory("sport"); 
        Sportcar1.setColor("yellow"); 
        Sportcar1.setName_car("OLamborghini Revuelto");        
    
        Car Sportcar2 = new Car(); 
        Sportcar2.setCar_id(13); 
        Sportcar2.setCategory("sport"); 
        Sportcar2.setColor("blue"); 
        Sportcar2.setName_car("Chevrolet Corvette");

        
        Car Sportcar3 = new Car(); 
        Sportcar3.setCar_id(14); 
        Sportcar3.setCategory("sport"); 
        Sportcar3.setColor("orange"); 
        Sportcar3.setName_car("Chevrolet Corvette");
        
        
        VBox sportCarPane1 = createCarPane(Sportcar1.getName_car(), "20000 SAR", "yellowcar.jpg");
        sportCarPane1.setPrefWidth(130);
        sportCarPane1.setPadding(new Insets(5));
        
        VBox sportCarPane2 = createCarPane(Sportcar2.getName_car(), "10000 SAR", "bluecarsport.jpg");
        sportCarPane2.setPrefWidth(130);
        sportCarPane2.setPadding(new Insets(5));
        
        VBox sportCarPane3 = createCarPane(Sportcar3.getName_car(), "90000 SAR", "orangcar.jpg");
        sportCarPane3.setPrefWidth(130);
        sportCarPane3.setPadding(new Insets(5));

        // All Cars
        FlowPane sportallCars = new FlowPane(Orientation.HORIZONTAL, 5, 5);
        sportallCars.setAlignment(Pos.CENTER);
        sportallCars.setStyle("-fx-background-color: white;");
        sportallCars.getChildren().addAll(sportCarPane1, sportCarPane2, sportCarPane3);

        VBox allSportCar = new VBox(5);
        allSportCar.setPadding(new Insets(5));
        allSportCar.setAlignment(Pos.CENTER);
        allSportCar.getChildren().addAll(sporth2, sportallCars);
        allSportCar.setStyle("-fx-background-color: white;");

        // End Car Info
         sportscrollPane = new ScrollPane(allSportCar);
        sportscrollPane.setFitToWidth(true);
        sportscrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        sportscrollPane.setStyle("-fx-background-color: white;");

        // Color Radio Event (Filter)
        sportcolorcar1.setOnAction(e -> handleColorSelection(sportallCars, sportCarPane1));
        sportcolorcar2.setOnAction(e -> handleColorSelection(sportallCars, sportCarPane2));
        sportcolorcar3.setOnAction(e -> handleColorSelection(sportallCars, sportCarPane3));
        allcolorcarsport.setOnAction(e -> handleColorSelection(sportallCars, sportCarPane1,sportCarPane2,sportCarPane3));



        
      HBox electrich2=new HBox(10);
        
        
        RadioButton electriccolorcar1 = new RadioButton("Red");
        electriccolorcar1.setStyle("-fx-font-size: 10px;");
        RadioButton electriccolorcar2 = new RadioButton("Black");
        electriccolorcar2.setStyle("-fx-font-size: 10px;");
        RadioButton electriccolorcar3 = new RadioButton("White");
   
        electriccolorcar3.setStyle("-fx-font-size: 10px; -fx-selected-color: yellow;");
          
        
        ToggleGroup electriccolor = new ToggleGroup();
        electriccolorcar1.setToggleGroup(electriccolor);
        electriccolorcar2.setToggleGroup(electriccolor);
        electriccolorcar3.setToggleGroup(electriccolor);
        RadioButton allcolorcarelectric= new RadioButton("All");
         allcolorcarelectric.setStyle("-fx-font-size: 10px; ");
        allcolorcarelectric.setToggleGroup(electriccolor);
        
        
        electrich2.setPadding(new Insets(15,6,5,35));
         
       
        
        electrich2.getChildren().addAll(electriccolorcar1,electriccolorcar2,electriccolorcar3,allcolorcarelectric);
        
/////////////////////////////////////////////////////////////////////////////////////////////////////////       
//------------------------------- Start electric Car Info--------------------------------------------------//
//////////////////////////////////////////////////////////////////////////////////////////////////////////


//-----------------     Start First car    -------------//
      
        //-----electric white var----//
        VBox electricCarPane1=new VBox(3);
        electricCarPane1.setPrefSize(200, 60);
        electricCarPane1.setPadding(new Insets(5,0,5,5));
        electricCarPane1.setStyle("-fx-background-color:white; -fx-border-color:  #FFC503; ");
        
        VBox VelectricCar1=new VBox(5);
        VelectricCar1.setAlignment(Pos.CENTER);
       
        
        // Car image
        Image electricImage1 = new Image("file:C:\\Users\\lap12\\OneDrive\\المستندات\\برمجة متقدمة\\project\\src\\main\\java\\com\\mycompany\\project\\cars\\electric1.png"); 

        ImageView electriccar1View = new ImageView(electricImage1);
        electriccar1View.setFitWidth(90);
        electriccar1View.setFitHeight(60);
       
        
        // Add To Data Base
        Car Ecar1 = new Car(); 
        Ecar1.setCar_id(15); 
        Ecar1.setCategory("electric"); 
        Ecar1.setColor("white"); 
        Ecar1.setName_car("Hyundai Kona Electric");
        
        
        // Car Name
        Label electricCarName1 = new Label("Hyundai Kona Electric");
        electricCarName1.setFont(Font.font("",FontWeight.BOLD,10));
        electricCarName1.setAlignment(Pos.CENTER);
        
        
        // Location 
        Label electricLocationName1 = new Label("20000 SAR");
        electricLocationName1.setFont(Font.font("",FontWeight.BOLD,10));
        
      
        //Button Book Now
        Button btelectricBookPane1 = new Button("Book Now");
        btelectricBookPane1.setStyle("-fx-background-color: #F7BF50; -fx-background-radius: 50; ");
         
    
         VelectricCar1.getChildren().addAll(electricCarName1,electriccar1View,electricLocationName1,btelectricBookPane1);
         electricCarPane1.getChildren().addAll(VelectricCar1);
          electricCarPane1.setAlignment(Pos.CENTER);
          electricCarPane1.setPrefWidth(130);
        electricCarPane1.setPadding(new Insets(5));
        
        
        //set action to display details electriccar1 
        btelectricBookPane1.setOnAction(event -> {
          btelectricBookPane1.setStyle("-fx-background-color: white; ");
        });
//////////////////////////// End First car//////////////////////////////////////////////////////////
    
/////////////////////////////Start Second car///////////////////////////////////////////////////////
         VBox electricCarPane2=new VBox(3);
        electricCarPane2.setPrefSize(200, 60);
        electricCarPane2.setPadding(new Insets(5,0,5,0));
        electricCarPane2.setStyle("-fx-background-color:white; -fx-border-color: #F7BF50; ");
         electricCarPane2.setPrefWidth(130);
        electricCarPane2.setPadding(new Insets(5));
        
        VBox VelectricCar2=new VBox(10);
        VelectricCar2.setAlignment(Pos.CENTER);
        
        // Car Image
        Image electricImage2 = new Image("file:C:\\Users\\lap12\\OneDrive\\المستندات\\برمجة متقدمة\\project\\src\\main\\java\\com\\mycompany\\project\\cars\\electric2.png"); 
        ImageView electricImage2View = new ImageView(electricImage2);
        electricImage2View.setFitWidth(90);
        electricImage2View.setFitHeight(58);
        
       
        // Add To Data Base
        Car Ecar2 = new Car(); 
        Ecar2.setCar_id(16); 
        Ecar2.setCategory("electric"); 
        Ecar2.setColor("red"); 
        Ecar2.setName_car("Mahindra Thar");
        
        // Car Name   
        Label electricCarName2 = new Label("Mahindra Thar");
        electricCarName2.setFont(Font.font("",FontWeight.BOLD,10));
        
        // Location 
        Text electricLocationName2 = new Text("10000 SAR");
        electricLocationName2.setFont(Font.font("",FontWeight.BOLD,10));
        
        
        // Button Book Now
        Button btelectricBookPane2 = new Button("Book Now");
        btelectricBookPane2.setStyle("-fx-background-color: #F7BF50; -fx-background-radius: 50; ");
      
        
        
        VelectricCar2.getChildren().addAll(electricCarName2,electricImage2View,electricLocationName2,btelectricBookPane2);
         electricCarPane2.getChildren().addAll(VelectricCar2);
         electricCarPane2.setAlignment(Pos.CENTER);
        
        //set action to display details electriccar1 
        btelectricBookPane2.setOnAction(event -> {
          btelectricBookPane2.setStyle("-fx-background-color: white; ");
        });
        
////////////////////////////End Second car///////////////////////////////////////////////////////// 
 

////////////////////////Start Third car/////////////////////////////////////////////////////////////
       VBox electricCarPane3=new VBox(3);
        electricCarPane3.setPrefSize(200, 60);
        electricCarPane3.setPadding(new Insets(5,0,5,0));
        electricCarPane3.setStyle("-fx-background-color:white; -fx-border-color: #F7BF50; ");
         electricCarPane3.setPrefWidth(130);
        electricCarPane3.setPadding(new Insets(5));
        
        VBox VelectricCar3=new VBox(10);
        VelectricCar3.setAlignment(Pos.CENTER);
        
        //Car image
        Image electricImage3 = new Image("file:C:\\Users\\lap12\\OneDrive\\المستندات\\برمجة متقدمة\\project\\src\\main\\java\\com\\mycompany\\project\\cars\\electric3.png"); 
        ImageView electricImage3View = new ImageView(electricImage3);
        electricImage3View.setFitWidth(90);
        electricImage3View.setFitHeight(60);
        
        
        // Add To Data Base
        Car Ecar3 = new Car(); 
        Ecar3.setCar_id(17); 
        Ecar3.setCategory("electric"); 
        Ecar3.setColor("black"); 
        Ecar3.setName_car("Tata Harrier");
       
        
        // Car Name
        Label electricCarName3 = new Label("Tata Harrier");
        electricCarName3.setFont(Font.font("",FontWeight.BOLD,10));
        
        // Location 
        Text electricLocationName3 = new Text("20000 SAR");
        electricLocationName3.setFont(Font.font("",FontWeight.BOLD,10));
        
        
        // Car Button Book Now
        Button btelectricBookPane3 = new Button("Book Now");
        btelectricBookPane3.setStyle("-fx-background-color: #F7BF50; -fx-background-radius: 50; ");
       
        VelectricCar3.getChildren().addAll(electricCarName3,electricImage3View,electricLocationName3,btelectricBookPane3);
        electricCarPane3.getChildren().add(VelectricCar3);
        
        //set action to display details electriccar1 
        btelectricBookPane3.setOnAction(event -> {
          btelectricBookPane3.setStyle("-fx-background-color: white; ");
        });
        
/////////////////////////////////End Third car/////////////////////////////////////////////////////////////////

////////////////////////Start Fourth car/////////////////////////////////////////////////////////////
       VBox electricCarPane4=new VBox(5);
        electricCarPane4.setPrefSize(200, 60);
        electricCarPane4.setPadding(new Insets(5,0,5,0));
        electricCarPane4.setStyle("-fx-background-color:white; -fx-border-color: #F7BF50; ");
         electricCarPane4.setPrefWidth(130);
        electricCarPane4.setPadding(new Insets(5));
        
        
        VBox VelectricCar4=new VBox(10);
        VelectricCar4.setAlignment(Pos.CENTER);
        
        //Car image
        Image electricImage4 = new Image("file:C:\\Users\\lap12\\OneDrive\\المستندات\\برمجة متقدمة\\project\\src\\main\\java\\com\\mycompany\\project\\cars\\electric4.png"); 
        ImageView electricImage4View = new ImageView(electricImage4);
        electricImage4View.setFitWidth(90);
        electricImage4View.setFitHeight(60);
        
        
        // Add To Data Base
        Car Ecar4 = new Car(); 
        Ecar4.setCar_id(18); 
        Ecar4.setCategory("electric"); 
        Ecar4.setColor("red"); 
        Ecar4.setName_car("Honda City");
       
        
        // Car Name
        Label electricCarName4 = new Label("Honda City");
        electricCarName4.setFont(Font.font("",FontWeight.BOLD,10));
        
        // Location 
        Label electricLocationName4 = new Label("30000 SAR");
        electricLocationName4.setFont(Font.font("",FontWeight.BOLD,10));
        
        // Car Button Book Now
        Button btelectricBookPane4 = new Button("Book Now");
        btelectricBookPane4.setStyle("-fx-background-color: #F7BF50; -fx-background-radius: 50; ");
        
        
        
        VelectricCar4.getChildren().addAll(electricCarName4,electricImage4View,electricLocationName4,btelectricBookPane4);
        electricCarPane4.getChildren().add(VelectricCar4);
        
        //set action to display details electriccar1 
        btelectricBookPane4.setOnAction(event -> {
          btelectricBookPane4.setStyle("-fx-background-color: white; ");
        });
        
////////////////////////////End Fourth car/////////////////////////////////////////////////////////////////


////////////////////////Start Fifth car/////////////////////////////////////////////////////////////
       VBox electricCarPane5=new VBox(5);
        electricCarPane5.setPrefSize(200, 60);
        electricCarPane5.setPadding(new Insets(5,0,5,0));
        electricCarPane5.setStyle("-fx-background-color:white; -fx-border-color: #F7BF50; ");
        electricCarPane5.setPrefWidth(130);
        electricCarPane5.setPadding(new Insets(5));
        
        VBox VelectricCar5=new VBox(10);
        VelectricCar5.setAlignment(Pos.CENTER);
        
        //Car image
        Image electricImage5 = new Image("file:C:\\Users\\lap12\\OneDrive\\المستندات\\برمجة متقدمة\\project\\src\\main\\java\\com\\mycompany\\project\\cars\\electric5.png"); 
        ImageView electricImage5View = new ImageView(electricImage5);
        electricImage5View.setFitWidth(90);
        electricImage5View.setFitHeight(60);
        
        // Add To Data Base
        Car Ecar5 = new Car(); 
        Ecar5.setCar_id(19); 
        Ecar5.setCategory("electric"); 
        Ecar5.setColor("white"); 
        Ecar5.setName_car("Hyundai Verna");
        
        
        // Car Name
        Label electricCarName5 = new Label("Hyundai Verna");
        electricCarName5.setFont(Font.font("",FontWeight.BOLD,10));
        
        // Location 
        Label electricLocationName5 = new Label("70000 SAR");
        electricLocationName5.setFont(Font.font("",FontWeight.BOLD,10));
        
        
        // Car Button Book Now
        Button btelectricBookPane5= new Button("Book Now");
        btelectricBookPane5.setStyle("-fx-background-color: #F7BF50; -fx-background-radius: 50; ");
        
        VelectricCar5.getChildren().addAll(electricCarName5,electricImage5View,electricLocationName4,btelectricBookPane5);
        electricCarPane5.getChildren().add(VelectricCar5);
        
        //set action to display details electriccar1 
        btelectricBookPane5.setOnAction(event -> {
          btelectricBookPane5.setStyle("-fx-background-color: white; ");
        });
        
//////////////////////////End Fifth car/////////////////////////////////////////////////////////////////

////////////////////////Start Sixth car/////////////////////////////////////////////////////////////
       VBox electricCarPane6 =new VBox(5);
        electricCarPane6.setPrefSize(200, 60);
        electricCarPane6.setPadding(new Insets(5,0,5,0));
        electricCarPane6.setStyle("-fx-background-color:white; -fx-border-color: #F7BF50; ");
        electricCarPane6.setPrefWidth(130);
        electricCarPane6.setPadding(new Insets(5));
        
        VBox VelectricCar6 =new VBox(10);
        VelectricCar6.setAlignment(Pos.CENTER);
        
        //Car image
        Image electricImage6 = new Image("file:C:\\Users\\lap12\\OneDrive\\المستندات\\برمجة متقدمة\\project\\src\\main\\java\\com\\mycompany\\project\\cars\\electric6.png"); 
        ImageView electricImage6View = new ImageView(electricImage6);
        electricImage6View.setFitWidth(90);
        electricImage6View.setFitHeight(60);
        
        // Add To Data Base
        Car Ecar6 = new Car(); 
        Ecar6.setCar_id(20); 
        Ecar6.setCategory("electric"); 
        Ecar6.setColor("black"); 
        Ecar6.setName_car("Maruti Suzuki Ciaz");
        
       
        // Car Name
        Label electricCarName6 = new Label("Maruti Suzuki Ciaz");
        electricCarName6.setFont(Font.font("",FontWeight.BOLD,10));
        
        // Location 
        Label electricLocationName6 = new Label("10000 SAR");
        electricLocationName6.setFont(Font.font("",FontWeight.BOLD,10));
        
        // Car Button Book Now
        Button btelectricBookPane6= new Button("Book Now");
        btelectricBookPane6.setStyle("-fx-background-color: #F7BF50; -fx-background-radius: 50; ");
        
        VelectricCar6.getChildren().addAll(electricCarName6,electricImage6View,electricLocationName6,btelectricBookPane6);
        electricCarPane6.getChildren().add(VelectricCar6);
        
        //set action to display details electriccar1 
        btelectricBookPane6.setOnAction(event -> {
          btelectricBookPane6.setStyle("-fx-background-color: white; ");
        });
        
//////////////////////////End Sixth car/////////////////////////////////////////////////////////////////


 /////////////////////////////////////////////////////////////////////////////   
//___________________________All Cars________________________________________// 
        
        
        FlowPane electricAllCars = new FlowPane(Orientation.HORIZONTAL,5,5);
        electricAllCars.setAlignment(Pos.CENTER);
        electricAllCars.setStyle("-fx-background-color: white;");
        electricAllCars.getChildren().addAll(electricCarPane1,electricCarPane2,electricCarPane3 , electricCarPane4,electricCarPane5 , electricCarPane6);
      
        VBox allelectricCar = new VBox(5);
        allelectricCar.setPadding(new Insets(5));
        allelectricCar.setAlignment(Pos.CENTER);
        allelectricCar.getChildren().addAll(electrich2,electricAllCars);
        allelectricCar.setStyle("-fx-background-color: white;");
        
        
    // End Car Info
       
        electricscrollPane = new ScrollPane(allelectricCar);
        electricscrollPane.setFitToWidth(true);
        electricscrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        electricscrollPane.setStyle("-fx-background-color: white;");
        
       
        // Color Radio Event (Filter)
        electriccolorcar1.setOnAction(e -> {handleColorSelection(electricAllCars,electricCarPane2,electricCarPane4);});
        electriccolorcar2.setOnAction(e -> {handleColorSelection(electricAllCars,electricCarPane3,electricCarPane6);});
        electriccolorcar3.setOnAction(e -> {handleColorSelection(electricAllCars,electricCarPane1,electricCarPane5);});
        allcolorcarelectric.setOnAction(e -> {handleColorSelection(electricAllCars,electricCarPane1,electricCarPane2,electricCarPane3,electricCarPane4,electricCarPane5,electricCarPane6);});
      
        main.setCenter(electricscrollPane);



///-----------------------------------------------------------------------------///
///----------------------------- END Electric car page-----------------------------///
///-----------------------------------------------------------------------------///
        
        

           // Start Add All Cars To Data Base
        
          session = HibernateUtil.getSessionFactory().openSession(); 
       tx = session.beginTransaction(); 
//      int scarId1 = (Integer) session.save(Scar1);
//      int scarId2 = (Integer) session.save(Scar2);       
//      int scarId3 = (Integer) session.save(Scar3); 
//      int scarId4 = (Integer) session.save(Scar4); 
//      int scarId5 = (Integer) session.save(Scar5);
//      int scarId6 = (Integer) session.save(Scar6);
//      int BcarId1 = (Integer) session.save(Bcar1);
//      int BcarId2 = (Integer) session.save(Bcar2); 
//      int BcarId3 = (Integer) session.save(Bcar3); 
//      int BcarId4 = (Integer) session.save(Bcar4); 
//      int BcarId5 = (Integer) session.save(Bcar5); 
//      int SportcarId1 = (Integer) session.save(Sportcar1);
//      int SportcarId2 = (Integer) session.save(Sportcar2);
//      int SportcarId3 = (Integer) session.save(Sportcar3); 
//        int ElectriccarId1 = (Integer) session.save(Ecar1);
//        int ElectriccarId2 = (Integer) session.save(Ecar2);
//        int ElectriccarId3 = (Integer) session.save(Ecar3); 
//        int ElectriccarId4 = (Integer) session.save(Ecar4);
//        int ElectriccarId5 = (Integer) session.save(Ecar5);
//        int ElectriccarId6 = (Integer) session.save(Ecar6);
      tx.commit(); 
      session.close();
      // End Add All Cars To Data Base


///-----------------------------------------------------------------------------///
///----------------------------- Start Previous page-----------------------------///
///-----------------------------------------------------------------------------///      
      // Cart Page
        // Create labels
        Label carNameLabel = new Label("Car Name");
        carNameLabel.setTextFill(Color.rgb(247, 191, 80));
        carNameLabel.setFont(Font.font("", FontWeight.BOLD,12));
        
        Label durationLabel = new Label("Duration");
        durationLabel.setTextFill(Color.rgb(247, 191, 80));
        durationLabel.setFont(Font.font("", FontWeight.BOLD,12));
        
        Label typeLabel = new Label("Color");
        typeLabel.setTextFill(Color.rgb(247, 191, 80));
        typeLabel.setFont(Font.font("", FontWeight.BOLD,12));
        
        Label colorLabel = new Label("Cost");
        colorLabel.setTextFill(Color.rgb(247, 191, 80));
        colorLabel.setFont(Font.font("", FontWeight.BOLD,12));
        
        
        // Create text areas and text field
        TextArea carNameTextArea = new TextArea();
        carNameTextArea.setEditable(false);
        
        TextArea durationTextArea = new TextArea();
        durationTextArea.setEditable(false);
        
        TextArea typeTextArea = new TextArea();
        typeTextArea.setEditable(false);
        
        TextArea colorTextArea = new TextArea();
        colorTextArea.setEditable(false);
        
        carNameTextArea.setPrefWidth(120);
        durationTextArea.setPrefWidth(120);
        colorTextArea.setPrefWidth(120);
        typeTextArea.setPrefWidth(120);
        
        // Create VBoxes for text areas
        VBox carNameVBox = new VBox(carNameLabel, carNameTextArea);
        VBox durationVBox = new VBox(durationLabel, durationTextArea);
        VBox typeVBox = new VBox(typeLabel, typeTextArea);
        VBox colorVBox = new VBox(colorLabel, colorTextArea);
    
       
        // Create HBox for text areas
        HBox textAreasHBox = new HBox(5,carNameVBox, durationVBox, typeVBox, colorVBox);

        // Create VBox for the entire layout
        VBox mainVBox = new VBox(5, textAreasHBox); 
        mainVBox.setAlignment(Pos.CENTER);
           
        
        order = new ScrollPane(mainVBox);
        order.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        order.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
///-----------------------------------------------------------------------------///
///----------------------------- End Previous page-----------------------------///
///-----------------------------------------------------------------------------///        
        
        
///-----------------------------------------------------------------------------///
///----------------------------- Start -----------------------------///
///-----------------------------------------------------------------------------/// 
        List<Button> allBookButton = Arrays.asList(
            btsmallBookPane1,btsmallBookPane2,btsmallBookPane3,btsmallBookPane4,btsmallBookPane5,btsmallBookPane6,
            btbigBookPane1,btbigBookPane2,btbigBookPane3,btbigBookPane4,btbigBookPane5,
            btelectricBookPane1,btelectricBookPane2,btelectricBookPane3,btelectricBookPane4,btelectricBookPane5,btelectricBookPane6
        );
        
        // On Book Button > Rent Car
        for (Button b : allBookButton) {
            b.setOnAction(e -> {
            Label bookedCarName = (Label) b.getParent().getChildrenUnmodifiable().get(0);
            // Get Price 
            Label bookedCarPrice = (Label) b.getParent().getChildrenUnmodifiable().get(2);
            
            
            // Searsh In Data Base
            session = HibernateUtil.getSessionFactory().openSession();
            List<Car> carList = null;
            String queryStr2 = "from Car";
            Query query2 = session.createQuery(queryStr2); 
            carList = query2.list();
            session.close();  
            // Store Car Name In Combo Box
            for(Car c: carList){
                if (c.getName_car().equals(bookedCarName.getText())) {
                    bookedCar = c;
                }
            }
            // Add Rental Data Base Tabel
            rent = new Rental(rentalID,"2 years", Double.parseDouble(bookedCarPrice.getText().substring(0, 5)),currentUser.getPhoneNumber(),bookedCar.getCar_id()); 
             session = HibernateUtil.getSessionFactory().openSession(); 
                tx = session.beginTransaction(); 
                int rentID = (Integer) session.save(rent);
                tx.commit(); 
                session.close();
                
                rentalID++;
                
                
                
                // Add Rental Car Data To Prevoius Page
                carNameTextArea.setText(carNameTextArea.getText() +bookedCar.getName_car() + "\n");
                durationTextArea.setText(durationTextArea.getText() +rent.getDuration() + "\n");
               typeTextArea.setText(typeTextArea.getText() + bookedCar.getColor() + "\n");
               colorTextArea.setText(colorTextArea.getText() +rent.getTotal_cost() + "\n");
            });
        
        }
        
        
        
        
       
        
         //retrive User list
       session = HibernateUtil.getSessionFactory().openSession();
       List<Rental> uList = null;
       String queryStr = "from Rental";
       Query query = session.createQuery(queryStr); 
       uList = query.list();
       session.close();  
       
       for(Rental u: uList){
           
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx3 = null;         
        tx3 = session.beginTransaction();  
        session.delete(u);     
        tx3.commit();      
        session.close();

       }
        
        

      stage.setScene(Singscene);
        
        stage.show();
    }




    // Methods    
    private VBox createCarPane(String carName, String location, String imagePath) {
        VBox sportCarPane = new VBox(3);
        sportCarPane.setPrefSize(200, 60);
        sportCarPane.setPadding(new Insets(5, 0, 5, 0));
        sportCarPane.setStyle("-fx-background-color:white; -fx-border-color: #FFC503;");

        VBox VsportCar = new VBox(5);
        VsportCar.setAlignment(Pos.CENTER);

        Image sportCarImage = new Image("file:C:\\Users\\lap12\\OneDrive\\المستندات\\برمجة متقدمة\\project\\src\\main\\java\\com\\mycompany\\project\\cars\\" + imagePath);
        ImageView sportCarImageView = new ImageView(sportCarImage);
        sportCarImageView.setFitWidth(90);
        sportCarImageView.setFitHeight(60);

        Label sportCarName = new Label(carName);
        sportCarName.setFont(Font.font("", FontWeight.BOLD, 10));
        sportCarName.setAlignment(Pos.CENTER);

        Label sportLocationName = new Label(location);
        sportLocationName.setFont(Font.font("", FontWeight.BOLD, 10));

    

        Button btsportBookPane = new Button("Book Now");
        btsportBookPane.setStyle("-fx-background-color: #F7BF50; -fx-background-radius: 50;");

        VsportCar.getChildren().addAll(sportCarName, sportCarImageView, sportLocationName, btsportBookPane);
        sportCarPane.getChildren().addAll(VsportCar);

        btsportBookPane.setOnAction(event -> {
            btsportBookPane.setStyle("-fx-background-color: white; ");
            // Add the logic for what you want to happen when the "Book Now" button is clicked.
        });

        return sportCarPane;
    }
    private void handleColorSelection(FlowPane allCars, VBox... carPanes) {
        allCars.getChildren().clear();
        allCars.getChildren().addAll(carPanes);
    }
    
    // Data Base Methods
    public String checkPhoneExist(String phone) {
        //retrive User list
       session = HibernateUtil.getSessionFactory().openSession();
       List<User> uList = null;
       String queryStr = "from User";
       Query query = session.createQuery(queryStr); 
       uList = query.list();
       session.close();  
       for(User u: uList){
           if (u.getPhoneNumber().equals(phone)) {
               return u.getPhoneNumber();
           }
       }
       return "";
    }
    public void addNewUser(String name, String email,String phone, String pass) {  
        User newUser = new User(name,email,phone,pass);
        currentUser = newUser;
        
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction(); 
        String userID1 = (String) session.save(newUser);

        tx.commit(); 
        session.close(); 
    }
    public boolean checkUserPassword(String phone, String pass) {
        //retrive User list
       session = HibernateUtil.getSessionFactory().openSession();
       List<User> uList = null;
       String queryStr = "from User";
       Query query = session.createQuery(queryStr); 
       uList = query.list();
       session.close();  
       for(User u: uList){
           if (u.getPhoneNumber().equals(phone))
               if(u.getPassword().equals(pass)){
                   return true;
               }
       }
       return false;
    }
    
    
    
    public static void main(String[] args) {
        launch();
    }

}