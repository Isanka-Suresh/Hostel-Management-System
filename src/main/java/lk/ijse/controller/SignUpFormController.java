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
import lk.ijse.dto.UserDTO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpFormController implements Initializable {

    @FXML
    private TextField txtName;

    @FXML
    private PasswordField txtPasword;

    @FXML
    private TextField txtShowPass;

    @FXML
    private PasswordField txtReEnter;

    @FXML
    private TextField txtShowReCorrect;

    @FXML
    private Label lblIncorrect1;

    @FXML
    private JFXCheckBox chkbox;

    @FXML
    private JFXButton btnSignUp;
    static Stage stage3;

    UserBO userBO= (UserBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.USER);
    @FXML
    void btnSignUpOnAction(ActionEvent event) throws IOException {
        if(txtPasword.getText().equals(txtReEnter.getText())){

            UserDTO userDTO = new UserDTO(txtName.getText(), txtPasword.getText());

            try {
                boolean isUserSaved = userBO.addUser(userDTO);
                if (isUserSaved){
                    Stage stage = (Stage) btnSignUp.getScene().getWindow();
                    stage.hide();

                    FXMLLoader fxmlLoader = new FXMLLoader(DashboardFormController.class.getResource("/view/login_form.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    stage3 = new Stage();
                    stage3.initStyle(StageStyle.UNDECORATED);
                    stage3.setScene(scene);
                    stage3.show();
                    new Alert(Alert.AlertType.CONFIRMATION, "Saved").show();

                }
            } catch (Exception e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, "Opss.. Something went wrong!!!").show();
            }
        }else{
            lblIncorrect1.setVisible(true);
            txtPasword.clear();
            txtReEnter.clear();
            new Alert(Alert.AlertType.WARNING, "Re-Enter the correct password").show();
        }


    }

    @FXML
    void chkboxOnAction(ActionEvent event) {
        if (chkbox.isSelected()){
            txtShowPass.setText(txtPasword.getText());
            txtShowReCorrect.setText(txtReEnter.getText());
            txtPasword.setVisible(false);
            txtReEnter.setVisible(false);
        }else{
            txtPasword.setText(txtShowPass.getText());
            txtReEnter.setText(txtReEnter.getText());
            txtPasword.setVisible(true);
            txtReEnter.setVisible(true);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            lblIncorrect1.setVisible(false);
    }
}
