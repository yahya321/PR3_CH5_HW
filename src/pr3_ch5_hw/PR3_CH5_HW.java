/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr3_ch5_hw;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author yahya
 */
public class PR3_CH5_HW extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Pane paneUser = FXMLLoader.load(getClass().getResource("UserPane.fxml"));
        Map<String, Pane> mapPanes = new TreeMap<>();
        mapPanes.put("UserPane", paneUser);
        Scene scene = new Scene(mapPanes.get("UserPane"));
        
        primaryStage.setTitle("User");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
