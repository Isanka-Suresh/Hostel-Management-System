package lk.ijse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.util.FactoryConfiguration;
import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main extends Application {
    @SneakyThrows
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.initStyle(StageStyle.UNDECORATED);
        Parent root = FXMLLoader.load(getClass().getResource("/view/login_form.fxml"));
        stage.setTitle("Login");
        stage.centerOnScreen();
        stage.setScene(new Scene(root));
        //stage.setFullScreen(true);
        loadHibernate();
        stage.show();
        new Thread(() -> {
            loadHibernate();
        }).start();
    }

    private void loadHibernate() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        transaction.commit();
        session.close();
    }
}
