/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr3_ch5_hw;

import entities.Student;
import entities.StudentJpaController;
import entities.exceptions.NonexistentEntityException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author yahya
 */
public class UserPaneController implements Initializable {

    @FXML
    private TableView<Student> tableview;
    @FXML
    private TableColumn<Student, Integer> tcID;
    @FXML
    private TableColumn<Student, String> tcName;
    @FXML
    private TableColumn<Student, String> tcMajor;
    @FXML
    private TableColumn<Student, Double> tcGrade;
    @FXML
    private TextField tName;
    @FXML
    private TextField tMajor;
    @FXML
    private TextField tGrade;
    @FXML
    private Button buttonResetCourse1;
    @FXML
    private Button buttonShowStudent;
    @FXML
    private Button buttonAddStudent;
    @FXML
    private Button buttonEditStudent;
    @FXML
    private Button buttonDeleteStudent;
    @FXML
    private Button buttonCourseReg;
    @FXML
    private Button buttonSelectQuery;
    private EntityManagerFactory emf;
    private int id;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tcID.setCellValueFactory(new PropertyValueFactory("id"));
        tcName.setCellValueFactory(new PropertyValueFactory("name"));
        tcMajor.setCellValueFactory(new PropertyValueFactory("major"));
        tcGrade.setCellValueFactory(new PropertyValueFactory("grade"));
        tableview.getSelectionModel().selectedItemProperty().addListener(
                event-> showSelected() );
        this.emf = Persistence.createEntityManagerFactory("PR3_CH5_HWPU");
    }    

    @FXML
    private void buttonResetCourseHandle(ActionEvent event) {
     resetControls();   
    }

    @FXML
    private void buttonShowStudentHandle(ActionEvent event) {
      EntityManager em = emf.createEntityManager();
        List<Student> students = em.createNamedQuery("Students.findAll").getResultList();
        tableview.getItems().setAll(students);
        em.close();  
    }

    @FXML
    private void buttonAddStudentHandle(ActionEvent event) {
        Student students = new Student();
        students.setName(tName.getText());
        students.setMajor(tMajor.getText());
        students.setGrade(Double.parseDouble(tGrade.getText()));
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(students);
        em.getTransaction().commit();
        em.close();
        RefreshTable();
        JOptionPane.showMessageDialog(null, "Successful Opertion");
        RefreshTextFields();
    }

    @FXML
    private void buttonEditStudentHandle(ActionEvent event) throws Exception {
        Student students = new Student();
        students.setId(this.id);
        students.setName(tName.getText());
        students.setMajor(tMajor.getText());
        students.setGrade(Double.parseDouble(tGrade.getText()));
        StudentJpaController bookcontrol = new StudentJpaController(this.emf); 
        bookcontrol.edit(students);
        RefreshTable();
        JOptionPane.showMessageDialog(null, "Successful Opertion");
        RefreshTextFields();
    }

    @FXML
    private void buttonDeleteStudentHandle(ActionEvent event) throws NonexistentEntityException {
     StudentJpaController bookcontrol = new StudentJpaController(this.emf); 
        bookcontrol.destroy(this.id);  
        RefreshTable();
        JOptionPane.showMessageDialog(null, "Successful Opertion");
        RefreshTextFields();
    }

    @FXML
    private void buttonCourseRegHandle(ActionEvent event) throws Exception {
         Stage stage = new Stage();
        start2(stage);
        
    }

    @FXML
    private void buttonSelectQueryHandle(ActionEvent event) throws Exception {
        Stage stage3 = new Stage();
         start3(stage3);
    }
    
    private void showSelected(){
        Student student = tableview.getSelectionModel().getSelectedItem();
        if(student != null){
        this.id=student.getId();
        tName.setText(student.getName());
        tMajor.setText(student.getMajor());
        tGrade.setText(String.valueOf(student.getGrade()));
        }
       
    }
     private void resetControls(){
        tName.setText("");
        tMajor.setText("");
        tGrade.setText("");
        tableview.getItems().clear();
    
    }
    public void start2(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Regest.fxml"));
        
        stage.setTitle("Add Course");
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void start3(Stage stage) throws Exception {
        Parent root2 = FXMLLoader.load(getClass().getResource("Query.fxml"));
        
        stage.setTitle("Select Query");
        stage.setScene(new Scene(root2));
        stage.show();
    }
    private void RefreshTable(){
        EntityManager em = emf.createEntityManager();
        List<Student> students = em.createNamedQuery("Students.findAll").getResultList();
        tableview.getItems().setAll(students);
        em.close(); 
        
    
    }
     private void RefreshTextFields(){
        
        tName.setText("");
        tMajor.setText("");
        tGrade.setText("");
        
        
    }
    
}
