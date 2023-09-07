package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class DashboardFormController {

    @FXML
    private JFXButton btnStudent;

    @FXML
    private JFXButton btnRooms;

    @FXML
    private JFXButton btnReserve;

    @FXML
    private JFXButton btnUser;

    @FXML
    private JFXButton btnLogout;

    @FXML
    private AnchorPane anchorWindow;

    static Stage stage2;
    @FXML
    void btnLogoutOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnLogout.getScene().getWindow();
        stage.hide();

        FXMLLoader fxmlLoader = new FXMLLoader(DashboardFormController.class.getResource("/view/login_form.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage2 = new Stage();
        stage2.initStyle(StageStyle.UNDECORATED);
        stage2.setScene(scene);
        //stage2.setFullScreen(true);
        stage2.show();


    }

    @FXML
    void btnReserveOnAction(ActionEvent event) throws IOException {
        Node node = (Node) FXMLLoader.load(getClass().getResource("/view/reservation_form.fxml"));
        anchorWindow.getChildren().setAll(node);
    }

    @FXML
    void btnRoomsOnAction(ActionEvent event) throws IOException {
        Node node = (Node) FXMLLoader.load(getClass().getResource("/view/room_form.fxml"));
        anchorWindow.getChildren().setAll(node);
    }

    @FXML
    void btnStudentOnAction(ActionEvent event) throws IOException {
        Node node = (Node) FXMLLoader.load(getClass().getResource("/view/student_form.fxml"));
        anchorWindow.getChildren().setAll(node);
    }

    @FXML
    void btnUserOnAction(ActionEvent event) {

    }

}
