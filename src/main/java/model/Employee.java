package model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="employee")
public class Employee {

    @Id
    private int id;
    @NotNull
    private String name;
    private String wage;
    private char sex;
    @Column(name="birth")
    private Date dob;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getWage() {
        return wage;
    }
    public void setWage(String wage) {
        this.wage = wage;
    }
    public char getSex() {
        return sex;
    }
    public void setSex(char sex) {
        this.sex = sex;
    }
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", wage=" + wage
                + ", sex=" + sex + ", dob=" + dob + "]";
    }



}
