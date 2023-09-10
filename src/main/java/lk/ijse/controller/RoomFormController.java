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
import lk.ijse.bo.custom.RoomBO;
import lk.ijse.dto.ReservationDTO;
import lk.ijse.dto.RoomDTO;
import lk.ijse.entity.Reservation;
import lk.ijse.entity.Room;
import lk.ijse.tm.ReservationTM;
import lk.ijse.tm.RoomTM;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class RoomFormController implements Initializable {

    @FXML
    private TextField txtRoomId;

    @FXML
    private ComboBox<String> cmbType;

    @FXML
    private TextField txtKeyMoney;

    @FXML
    private TextField txtQuantity;

    @FXML
    private JFXButton btnAddNew;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private TableView<RoomTM> tblRoom;

    @FXML
    private TableColumn<?, ?> tblRoomId;

    @FXML
    private TableColumn<?, ?> tblRoomType;

    @FXML
    private TableColumn<?, ?> tblKeyMoney;

    @FXML
    private TableColumn<?, ?> tblQuantity;
    private RoomTM roomTM;
    private String[] types={"AC","NONAC","AC,FOOD","NONAC,FOOD"};
    RoomBO roomBO = (RoomBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.ROOM);
    private ObservableList<RoomTM> roomTMS = FXCollections.observableArrayList();
    private ObservableList<String>roomType=FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cleanAll();
        loadCellValueFactory();
        loadComboBox();
        try {loadTable();}
        catch (Exception e) {e.printStackTrace();}
    }

    @FXML
    void btnAddNewOnAction(ActionEvent event) throws Exception {
        try {
            txtRoomId.setText(roomBO.newId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        btnSave.setDisable(false);
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);
        loadTable();
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws Exception {
        roomBO.addRoom(
                new RoomDTO(
                        txtRoomId.getText(),
                        cmbType.getValue(),
                        Double.parseDouble(txtKeyMoney.getText()),
                        Integer.parseInt(txtQuantity.getText())
                ));
        loadTable();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        if (roomTM.getReservedRooms()!=0) {
            new Alert(Alert.AlertType.WARNING, "Room can't be remove because there are reserved rooms in this type!!!").show();
            return;
        }

        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
        Optional<ButtonType> result = new Alert(Alert.AlertType.CONFIRMATION, "Are sure want to remove this student", yes, no).showAndWait();

        if (result.orElse(no) == yes){
            try {
                boolean isRemoved = roomBO.deleteRoom(txtRoomId.getText());

                if (isRemoved){
                    new Alert(Alert.AlertType.CONFIRMATION, "Room Removed!").show();

                    btnSave.setDisable(true);
                    btnUpdate.setDisable(false);
                    btnDelete.setDisable(false);
                    cleanAll();
                }else {
                    new Alert(Alert.AlertType.WARNING, "Room hasn't removed!").show();
                }
            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, "Oops..Something wend wrong!!!").show();
                e.printStackTrace();
            }

        }

        try {
            loadTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws Exception {
        roomBO.updateRoom(
                new RoomDTO(
                        txtRoomId.getText(),
                        cmbType.getValue(),
                        Double.parseDouble(txtKeyMoney.getText()),
                        Integer.parseInt(txtQuantity.getText())
                ));
        loadTable();
    }

    @FXML
    void cmbTypeOAction(ActionEvent event) {

    }
    @FXML
    void tblRoomOnAction(MouseEvent event) {
        btnSave.setDisable(true);
        btnUpdate.setDisable(false);
        btnDelete.setDisable(false);

        roomTM = tblRoom.getSelectionModel().getSelectedItem();

        txtRoomId.setText(roomTM.getRoomId());
        cmbType.setValue(roomTM.getRoomType());
        txtQuantity.setText(String.valueOf(roomTM.getQuantity()));
        txtKeyMoney.setText(String.valueOf(roomTM.getKeyMoney()));
    }

    void loadCellValueFactory(){
        tblRoomId.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        tblRoomType.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        tblKeyMoney.setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        tblQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
    }
    void loadComboBox(){
        cmbType.setItems(FXCollections.observableArrayList(types));
    }
    void loadTable() throws Exception {
        roomTMS = FXCollections.observableArrayList();
        List<RoomDTO> rooms = roomBO.getAllRoom();
        for (RoomDTO roomDTO: rooms){
            int totQty = roomBO.getTotalRoomQty(roomDTO.getRoomTypeId()) + roomDTO.getQuantity();
            int reservedRooms = totQty - roomDTO.getQuantity();
            roomTMS.add(
                    new RoomTM(
                         roomDTO.getRoomTypeId(),
                         roomDTO.getRoomType(),
                         roomDTO.getKeyMoney(),
                         roomDTO.getQuantity(),
                         totQty,
                         reservedRooms
                    ));
        }
        tblRoom.setItems(roomTMS);
    }
    void cleanAll(){
        txtRoomId.setText("RM-");
        txtQuantity.setText("00");
        txtKeyMoney.setText(null);
    }
}
