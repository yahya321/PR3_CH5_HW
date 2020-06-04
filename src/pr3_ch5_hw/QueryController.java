/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr3_ch5_hw;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author yahya
 */
public class QueryController implements Initializable {

    @FXML
    private TableView<?> ttTableView;
    @FXML
    private TableColumn<?, ?> ttcID;
    @FXML
    private TableColumn<?, ?> ttcName;
    @FXML
    private TableColumn<?, ?> ttcMajor;
    @FXML
    private TableColumn<?, ?> ttcGrade;
    @FXML
    private TextField tQueryStat;
    @FXML
    private Button buttonResetCourse1;
    @FXML
    private Button buttonShowResult;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void buttonResetCourseHandle(ActionEvent event) {
    }

    @FXML
    private void buttonShowResultHandle(ActionEvent event) {
    }
    
}
