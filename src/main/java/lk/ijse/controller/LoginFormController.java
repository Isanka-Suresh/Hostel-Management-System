package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class LoginFormController {

    @FXML
    private TextField txtName;

    @FXML
    private PasswordField txtPasword;

    @FXML
    private Label lblIncorrect;

    @FXML
    private JFXCheckBox chkbox;

    @FXML
    private JFXButton btnLogin;

    static Stage stage2;

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnLogin.getScene().getWindow();
        stage.hide();

        FXMLLoader fxmlLoader = new FXMLLoader(DashboardFormController.class.getResource("/view/dashboard_form.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage2 = new Stage();
        stage2.initStyle(StageStyle.UNDECORATED);
        stage2.setScene(scene);
        //stage2.setFullScreen(true);
        stage2.show();
    }

    @FXML
    void chkboxOnAction(ActionEvent event) {

    }

}
