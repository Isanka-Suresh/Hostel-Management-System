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
import lk.ijse.bo.custom.ReservationBO;
import lk.ijse.bo.custom.RoomBO;
import lk.ijse.bo.custom.StudentBO;
import lk.ijse.dto.ReservationDTO;
import lk.ijse.dto.RoomDTO;
import lk.ijse.dto.StudentDTO;
import lk.ijse.entity.Room;
import lk.ijse.entity.Student;
import lk.ijse.tm.ReservationTM;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ReservationFormController implements Initializable {

    @FXML
    private TextField txtReserveId;

    @FXML
    private ComboBox<String> cmbStudent;

    @FXML
    private ComboBox<String> cmbRoom;

    @FXML
    private DatePicker dpDate;

    @FXML
    private CheckBox cbPaid;

    @FXML
    private CheckBox cbUnpaid;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private TableView<ReservationTM> tblReservation;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colStd;

    @FXML
    private TableColumn<?, ?> colRoom;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colStatus;

    private String[] types={"AC","NONAC","AC,FOOD","NONAC,FOOD"};
    private ObservableList<String>students;
    private ObservableList<ReservationTM>reservationTMS;


    ReservationBO reservationBO = (ReservationBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.RESERVATION);
    RoomBO roomBO = (RoomBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.ROOM);
    StudentBO studentBO = (StudentBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.STUDENT);
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        cbUnpaid.setSelected(true);
        cbPaid.setSelected(false);
        try {
            loadComboBox();
            loadResTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
        cleanAll();
    }

    @FXML
    void btnAddOnAction(ActionEvent event) throws Exception {
        try {
            txtReserveId.setText(reservationBO.newReservationId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        btnSave.setDisable(false);
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);
        loadResTable();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        try {

            StudentDTO studentDTO = studentBO.getStudent(nameBreak(cmbStudent.getValue()));
            Student student = new Student(
                    studentDTO.getStudentId(),
                    studentDTO.getName(),
                    studentDTO.getAddress(),
                    studentDTO.getContact(),
                    studentDTO.getDob(),
                    studentDTO.isMale(),
                    new ArrayList<>()
            );

            RoomDTO roomDTO = roomBO.getRoom(cmbRoom.getValue());
            Room room = new Room(
                    roomDTO.getRoomTypeId(),
                    roomDTO.getRoomType(),
                    roomDTO.getKeyMoney(),
                    roomDTO.getQuantity(),
                    new ArrayList<>()
            );

            reservationBO.addReservation(new ReservationDTO(txtReserveId.getText(), student, room,dpDate.getValue(),paidCheck()));
            new Alert(Alert.AlertType.CONFIRMATION, "reservation added successfully ! ").show();
            cleanAll();
            loadResTable();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "reservation not added ! ").show();
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        try {

            StudentDTO studentDTO = studentBO.getStudent(nameBreak(cmbStudent.getValue()));
            Student student = new Student(
                    studentDTO.getStudentId(),
                    studentDTO.getName(),
                    studentDTO.getAddress(),
                    studentDTO.getContact(),
                    studentDTO.getDob(),
                    studentDTO.isMale(),
                    new ArrayList<>()
            );

            RoomDTO roomDTO = roomBO.getRoom(cmbRoom.getValue());
            Room room = new Room(
                    roomDTO.getRoomTypeId(),
                    roomDTO.getRoomType(),
                    roomDTO.getKeyMoney(),
                    roomDTO.getQuantity(),
                    new ArrayList<>()
            );

            reservationBO.updateReservation(new ReservationDTO(txtReserveId.getText(), student, room,dpDate.getValue(),paidCheck()));
            new Alert(Alert.AlertType.CONFIRMATION, "reservation updated successfully ! ").show();
            cleanAll();
            loadResTable();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "reservation not updated ! ").show();
        }
    }

    @FXML
    void cbPaidOnAction(ActionEvent event) {
        cbPaid.setSelected(true);
        cbUnpaid.setSelected(false);
    }

    @FXML
    void cbUnpaidOnAction(ActionEvent event) {
        cbPaid.setSelected(false);
        cbUnpaid.setSelected(true);
    }

    @FXML
    void cmbRoomOnAction(ActionEvent event) {

    }

    @FXML
    void cmbStudentOnAction(ActionEvent event) {

    }

    @FXML
    void tblReservationOnAction(MouseEvent event) {

    }

    void setCellValueFactory(){
        colId.setCellValueFactory(new PropertyValueFactory<>("reservationId"));
        colStd.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colRoom.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
    }
    private void loadComboBox() throws Exception {
        students=FXCollections.observableArrayList();
        List<StudentDTO>list=studentBO.getAllStudent();
        for (StudentDTO dto:list){
            students.add(
              dto.getStudentId()+"/"+dto.getName()
            );
        }
        cmbStudent.setItems(FXCollections.observableArrayList(students));
        cmbRoom.setItems(FXCollections.observableArrayList(types));
    }
    private void loadResTable() throws Exception {
        reservationTMS=FXCollections.observableArrayList();
        List<ReservationDTO>roomDTOS=reservationBO.getAllReservation();

        for (ReservationDTO r : roomDTOS) {
            reservationTMS.add(
                    new ReservationTM(
                            r.getReservationId(),
                            r.getStudent().getStudentId(),
                            r.getRoom().getRoomTypeId(),
                            r.getDate(),
                            r.getStatus()
                    ));
            tblReservation.setItems(reservationTMS);
        }
    }
    private void cleanAll(){
        dpDate.setValue(LocalDate.now());
        txtReserveId.clear();
    }
    private String nameBreak(String cmb){
        String id="";
        for (int x=0;x<cmb.length();x++){
            if (cmb.charAt(x)!='/'){
                id+=cmb.charAt(x);
            }else{
                return id;
            }
        }
        return id;
    }
    private String paidCheck(){
        if (cbPaid.isSelected()){
            return "Paid";
        }else {
            return "Unpaid";
        }
    }
}
