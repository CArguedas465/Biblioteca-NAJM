
package sistemabiblioteca;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/*Gestiona los elementos gráficos del Login, y la revisión de credenciales. */
public class Login extends Application {
    @Override
    public void start(Stage mainStage){
        mainStage.setTitle("Inicio de Sesión");
        GridPane gridPane1 = new GridPane();
        
        VBox vbx = new VBox(); 
        
        gridPane1.setAlignment(Pos.CENTER); 
        gridPane1.setHgap(5.5);
        gridPane1.setVgap(5.5);
        gridPane1.setPadding(new Insets(20));
        
        StackPane sp = new StackPane(); 
        sp.setPadding(new Insets(50,0,20,0));
        
        Image image = new Image("file:LogoR.png");
        ImageView imageView = new ImageView(image); 
        sp.getChildren().add(imageView);
        
        Label usuarioLabel = new Label("Usuario: ");
        usuarioLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold");
        Label passwordLabel = new Label("Password: ");
        passwordLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold");
        
        TextField userName = new TextField();
        userName.setMinWidth(250);
        PasswordField password = new PasswordField();
        password.setMinWidth(250);
        
        
        gridPane1.add(usuarioLabel, 0, 0);
        gridPane1.add(userName, 1, 0);
        gridPane1.add(passwordLabel, 0, 1);
        gridPane1.add(password, 1, 1);
        Button button = new Button("Submit"); 
        gridPane1.add(button, 1, 3);
        GridPane.setHalignment(button, HPos.RIGHT);
        
        vbx.getChildren().add(sp);
        vbx.getChildren().add(gridPane1);
        vbx.setStyle("-fx-background-color: #390345");
        
        button.setOnAction(e -> {
            if (userName.getText().equals("carguedasd465") && password.getText().equals("ulacit123...")){
                Stage confirmation = new Stage(); 
                confirmation.setTitle("Inicio de sesión exitoso");
                confirmation.setResizable(false);
                confirmation.initModality(Modality.APPLICATION_MODAL);
                
                StackPane confirmationSP = new StackPane(); 
                confirmationSP.setPadding(new Insets(50));
                
                Label label = new Label("Credenciales correctas. Bienvenido al sistema.");
                confirmationSP.getChildren().add(label);
                
                confirmation.setScene(new Scene(confirmationSP, 400,100));
                confirmation.showAndWait();
                
                mainStage.close();
                SistemaBiblioteca sisBib = new SistemaBiblioteca();
                sisBib.start(sisBib.mainStage);

            } else {
                Stage confirmation = new Stage();
                confirmation.setTitle("Error de inicio de sesión");
                confirmation.setResizable(false);
                confirmation.initModality(Modality.APPLICATION_MODAL);
                
                StackPane confirmationSP = new StackPane(); 
                confirmationSP.setPadding(new Insets(50));
                
                Label label = new Label("Credenciales incorrectas.");
                confirmationSP.getChildren().add(label);
                
                confirmation.setScene(new Scene(confirmationSP, 300,100));
                confirmation.show();
            }
        });
        
        
        mainStage.setScene(new Scene(vbx, 500,300));
        mainStage.setResizable(false);
        mainStage.show();
        
    }
    public static void main(String[]args){
        launch(args);
    }
}
