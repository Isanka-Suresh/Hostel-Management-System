package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.StudentBO;
import lk.ijse.dto.ReservationDTO;
import lk.ijse.dto.StudentDTO;
import lk.ijse.tm.StudentTM;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class StudentFormController implements Initializable {

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
    private JFXButton btnSave;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private TableView<StudentTM> tblStudent;

    @FXML
    private TableColumn<?, ?> tblstdId;

    @FXML
    private TableColumn<?, ?> tblStdName;

    @FXML
    private TableColumn<?, ?> tblStdAddress;

    @FXML
    private TableColumn<?, ?> tblStdContact;

    @FXML
    private TableColumn<?, ?> tblStdDob;

    @FXML
    private TableColumn<?, ?> tblStdGender;

    private ObservableList<StudentTM>studentTMS;
    private StudentBO studentBO = (StudentBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.STUDENT);
    private StudentTM studentTM;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cleanAll();
        loadCellValueFactory();
        try {
            loadStdTable();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnAdNewOnAction(ActionEvent event) {
        cleanAll();
        btnSave.setDisable(false);
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);

        try {
            txtStudentId.setText(studentBO.newId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
        Optional<ButtonType> result = new Alert(Alert.AlertType.CONFIRMATION, "Are sure want to remove this student", yes, no).showAndWait();

        if (result.orElse(no) == yes){
            try {
                boolean isRemoved = studentBO.deleteStudent(txtStudentId.getText());
                if (isRemoved){
                    new Alert(Alert.AlertType.CONFIRMATION, "Student Removed!").show();
                    cleanAll();
                }else {
                    new Alert(Alert.AlertType.WARNING, "Student hasn't removed!").show();
                }
            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, "Oops..Something wend wrong!!!").show();
                e.printStackTrace();
            }
        }

        try {
            loadStdTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }
    @FXML
    void btnSaveOnAction(ActionEvent event) {
        boolean isMale=false;
        if(cpMale.isSelected()){
            isMale=true;
        }
        try {
            boolean isSaved = studentBO.addStudent(
                    new StudentDTO(
                        txtStudentId.getText(),
                        txtStudentName.getText(),
                        txtAddress.getText(),
                        txtContact.getText(),
                        dpBirthday.getValue(),
                        isMale
                    ));

            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION, "Student saved!").show();

                btnSave.setDisable(true);
                btnUpdate.setDisable(false);
                btnDelete.setDisable(false);
                cleanAll();
            }else {
                new Alert(Alert.AlertType.WARNING, "Student hasn't saved!").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Oops..Something wend wrong!!!").show();
            e.printStackTrace();
        }

        try {
            loadStdTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        boolean isMale=false;
        if(cpMale.isSelected()){
            isMale=true;
        }
        StudentDTO student = new StudentDTO(
                txtStudentId.getText(),
                txtStudentName.getText(),
                txtAddress.getText(),
                txtContact.getText(),
                dpBirthday.getValue(),
                isMale
        );

        try {
            boolean isStudentUpdated = studentBO.updateStudent(student);
            if (isStudentUpdated){
                new Alert(Alert.AlertType.CONFIRMATION, "Student Updated!").show();
                cleanAll();
            }else {
                new Alert(Alert.AlertType.WARNING, "Student hasn't Updated!").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Oops..Something wend wrong!!!").show();
            e.printStackTrace();
        }

        try {
            loadStdTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void cpFemaleOnAction(ActionEvent event) {
        cpMale.setSelected(false);
        cpFemale.setSelected(true);
    }

    @FXML
    void cpMaleOnAction(ActionEvent event) {
        cpMale.setSelected(true);
        cpFemale.setSelected(false);

    }

    @FXML
    void dpBirthday(ActionEvent event) {

    }

    @FXML
    void tblStudentOnAction(MouseEvent event) {
        studentTM = tblStudent.getSelectionModel().getSelectedItem();
        boolean isMale=true;
        if (studentTM.getGender().equals("Female")){
            isMale=false;
        }

        txtStudentId.setText(studentTM.getStudentId());
        txtStudentName.setText(studentTM.getName());
        txtAddress.setText(studentTM.getAddress());
        txtContact.setText(studentTM.getContact());
        dpBirthday.setValue(studentTM.getDob());
        if (isMale) {
            cpMale.setSelected(true);
            cpFemale.setSelected(false);
        }else{
            cpFemale.setSelected(true);
            cpMale.setSelected(false);
        }
    }

    void loadCellValueFactory(){
        tblstdId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        tblStdName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblStdAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        tblStdContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        tblStdDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        tblStdGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
    }

    private void loadStdTable() throws Exception {
        studentTMS = FXCollections.observableArrayList();
        List<StudentDTO>students=studentBO.getAllStudent();
        String gender="Male";
        for (StudentDTO std:students){
            if(!std.isMale()){
                gender="Female";
            }
            studentTMS.add(
                    new StudentTM(
                            std.getStudentId(),
                            std.getName(),
                            std.getAddress(),
                            std.getContact(),
                            std.getDob(),
                            gender
                    ));
            tblStudent.setItems(studentTMS);
        }
    }

    private void cleanAll() {
        txtStudentId.clear();
        txtStudentName.clear();
        txtAddress.clear();
        txtContact.clear();
        dpBirthday.setValue(LocalDate.now());
        cpMale.setSelected(true);
        cpFemale.setSelected(false);
    }
}
