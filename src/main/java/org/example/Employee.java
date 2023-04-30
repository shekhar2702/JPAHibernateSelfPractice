package org.example;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue
    private Integer id;

    public void setId(Integer id) {
        this.id = id;
    }
//    private EmployeeType type;

    @Enumerated(EnumType.STRING)
    private EmployeeType type;

    @Transient
    private String dontPersistThis;

    public String getDontPersistThis() {
        return dontPersistThis;
    }

    public void setDontPersistThis(String dontPersistThis) {
        this.dontPersistThis = dontPersistThis;
    }

    public Date getDob() {
        return dob;
    }

    public EmployeeType getType() {
        return type;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Column(name = "empName")
    private String name;

    @Temporal(TemporalType.TIME)
    private Date dob;

    public BigDecimal getAge() {
        return age;
    }

    public void setAge(BigDecimal age) {
        this.age = age;
    }

    private BigDecimal age;

    @Column(nullable = false,unique = true)
    private String ssn;

    public String getSsn() {
        return ssn;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                ", ssn='" + ssn + '\'' +
                '}';
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
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
}
