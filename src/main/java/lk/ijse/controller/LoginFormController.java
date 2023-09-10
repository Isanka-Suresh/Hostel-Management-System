/*
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


    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {

    }

    @FXML
    void chkboxOnAction(ActionEvent event) {

    }

}
*/
        package lk.ijse.controller;

        import com.jfoenix.controls.JFXButton;
        import com.jfoenix.controls.JFXCheckBox;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.fxml.Initializable;
        import javafx.scene.Scene;
        import javafx.scene.control.Alert;
        import javafx.scene.control.Label;
        import javafx.scene.control.PasswordField;
        import javafx.scene.control.TextField;
        import javafx.stage.Stage;
        import javafx.stage.StageStyle;
        import lk.ijse.bo.BOFactory;
        import lk.ijse.bo.custom.UserBO;
        import lk.ijse.util.FactoryConfiguration;
        import org.hibernate.Session;
        import org.hibernate.Transaction;

        import java.io.IOException;
        import java.net.URL;
        import java.util.ResourceBundle;

public class LoginFormController implements Initializable {

    @FXML
    private TextField txtName;

    @FXML
    private PasswordField txtPasword;

    @FXML
    private TextField txtShowPass;

    @FXML
    private Label lblIncorrect;

    @FXML
    private JFXCheckBox chkbox;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXButton btnHere;
    static Stage stage2;
    UserBO userBO= (UserBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.USER);
    @FXML
    void btnHereOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnLogin.getScene().getWindow();
        stage.hide();

        FXMLLoader fxmlLoader = new FXMLLoader(DashboardFormController.class.getResource("/view/sign_up_form.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage2 = new Stage();
        stage2.initStyle(StageStyle.UNDECORATED);
        stage2.setScene(scene);
        stage2.show();
    }

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {

        try {
            boolean isVerifiedUser = userBO.checkUser(txtName.getText(), txtPasword.getText());
            if (isVerifiedUser){
                Stage stage = (Stage) btnLogin.getScene().getWindow();
                stage.hide();

                FXMLLoader fxmlLoader = new FXMLLoader(DashboardFormController.class.getResource("/view/dashboard_form.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                stage2 = new Stage();
                stage2.initStyle(StageStyle.UNDECORATED);
                stage2.setScene(scene);
                stage2.show();
            }else {
                new Alert(Alert.AlertType.WARNING, "Login informations are wrong...!").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Opss.. Something went wrong!!!").show();
        }
    }

    @FXML
    void chkboxOnAction(ActionEvent event) {
        if (chkbox.isSelected()){
            txtShowPass.setText(txtPasword.getText());
            txtPasword.setVisible(false);
        }else{
            txtPasword.setText(txtShowPass.getText());
            txtPasword.setVisible(true);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblIncorrect.setVisible(false);
    }
}

