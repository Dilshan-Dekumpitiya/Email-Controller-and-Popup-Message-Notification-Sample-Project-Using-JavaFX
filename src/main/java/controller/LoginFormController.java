package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

import java.io.IOException;

public class LoginFormController {

    @FXML
    private AnchorPane loginContext;

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {

        //stage load code
        Stage stage = (Stage) loginContext.getScene().getWindow();
        stage.close();

        Stage stage2 = new Stage();
        stage2.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dashboard-form.fxml"))));
        stage2.setTitle("Dashboard");
        stage2.show();

        //send mail code
        Thread mailThread=new Thread(()->{
            try {
                EmailController.sendMail("aenpalmoilprocessingpvtltd@gmail.com"); //Recepient mail
            } catch (Exception e) {
                System.out.println("Failed to send e-mail.Network err!");
                System.out.println(e);
            }
        });

        mailThread.start();

        //notification message code here
        Notifications notification = NotificationController.notification("Login Successful", "Login Alert");
        notification.show();

    }
}
