import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PrimaryController extends Application {

    ConnDbOps dbOps = new ConnDbOps();

    @Override
    public void start(Stage primaryStage) {

        TextField nameField = new TextField();
        nameField.setPromptText("Name");

        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        TextField phoneField = new TextField();
        phoneField.setPromptText("Phone");

        TextField addressField = new TextField();
        addressField.setPromptText("Address");

        TextField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button addButton = new Button("Add User");


        addButton.setOnAction(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            String address = addressField.getText();
            String password = passwordField.getText();

            if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
                dbOps.insertUser(name, email, phone, address, password);
                System.out.println("User added to the database.");
            } else {
                System.out.println("Please fill in all the required fields.");
            }
        });


        VBox layout = new VBox(10);
        layout.getChildren().addAll(nameField, emailField, phoneField, addressField, passwordField, addButton);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setTitle("User Management");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
