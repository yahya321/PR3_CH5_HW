/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author yahya
 */
@Entity
public class Registration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentid;
    private Integer cousreid;
    private Integer semester;

    public Registration() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public Integer getCousreid() {
        return cousreid;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public void setCousreid(Integer cousreid) {
        this.cousreid = cousreid;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }
    
    

    
    
}
