/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr3_ch5_hw;

import entities.Registration;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author yahya
 */
public class RegestController implements Initializable {

    @FXML
    private TextField tStuID;
    @FXML
    private TextField tCouId;
    @FXML
    private TextField tSeme;
    @FXML
    private Button buttonAddCourse;
    private EntityManagerFactory emf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.emf = Persistence.createEntityManagerFactory("PR3_CH5_HWPU");
    }    

    @FXML
    private void buttonAddCourseHandle(ActionEvent event) {
        Registration registration = new Registration();
        registration.setStudentid(Integer.parseInt(tStuID.getText()));
        registration.setCousreid(Integer.parseInt(tCouId.getText()));
        registration.setSemester(Integer.parseInt(tSeme.getText()));
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(registration);
        em.getTransaction().commit();
        em.close();
        JOptionPane.showMessageDialog(null, "Successful Opertion");

        
    }
    
}
