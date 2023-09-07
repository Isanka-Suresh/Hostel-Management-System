package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.ReservationBO;
import lk.ijse.bo.custom.RoomBO;
import lk.ijse.bo.custom.StudentBO;
import lk.ijse.dto.ReservationDTO;
import lk.ijse.tm.ReservationTM;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ReservationFormController implements Initializable {

    @FXML
    private TextField txtReserveId;

    @FXML
    private ComboBox<?> cmbStudent;

    @FXML
    private ComboBox<?> cmbRoom;

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
    private JFXButton btnDelete;

    @FXML
    private TableView<ReservationTM> tblReservation;

    private ObservableList<ReservationTM>reservationTMS= FXCollections.observableArrayList();
    ReservationBO reservationBO = (ReservationBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.RESERVATION);
    RoomBO roomBO = (RoomBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.ROOM);
    StudentBO studentBO = (StudentBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.STUDENT);
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {

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
    void cbPaidOnAction(ActionEvent event) {

    }

    @FXML
    void cbUnpaidOnAction(ActionEvent event) {

    }

    @FXML
    void cmbRoomOnAction(ActionEvent event) {

    }

    @FXML
    void cmbStudentOnAction(ActionEvent event) {

    }

    void setCellValueFactory(){
        tblReservation.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("reservationId"));
        tblReservation.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("studentId"));
        tblReservation.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("roomId"));
        tblReservation.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("date"));
        tblReservation.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("status"));
    }
    void loadTable(){
        tblReservation.getItems().clear();
        reservationTMS = FXCollections.observableArrayList();
        try {
            List<ReservationDTO> reservationDTOS= reservationBO.getAllReservation();
            for (ReservationDTO r:reservationDTOS){
                reservationTMS.add(new ReservationTM(r.getReservationId(),r.getStudentId(),r.getRoomId(),r.getDate(),r.isStatus()));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        tblReservation.setItems(reservationTMS);
    }
}
