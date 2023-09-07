package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class StudentFormController {

    @FXML
    private TextField txtStudentId;

    @FXML
    private TextField txtStudentName;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtContact;

    @FXML
    private DatePicker dpBirthday;

    @FXML
    private CheckBox cpMale;

    @FXML
    private CheckBox cpFemale;

    @FXML
    private JFXButton btnAdNew;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private TableView<?> tblStudent;

    @FXML
    void btnAdNewOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void cpFemaleOnAction(ActionEvent event) {

    }

    @FXML
    void cpMaleOnAction(ActionEvent event) {

    }

    @FXML
    void dpBirthday(ActionEvent event) {

    }

}
