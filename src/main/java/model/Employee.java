package model;

import java.sql.Date;

import javax.persistence.*;
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
    private Date created;
    private Date updated;

    @PrePersist
    protected void onCreate() {
        created = new Date(System.currentTimeMillis());
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Date(System.currentTimeMillis());
    }
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
