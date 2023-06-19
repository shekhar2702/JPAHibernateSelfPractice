package org.example;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
public class AccessCard {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne(mappedBy = "accessCard",fetch = FetchType.LAZY)
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Type(type= "org.hibernate.type.NumericBooleanType")
    private boolean isActive;
    private Date issuedDate;
    private String firmwareVersion;

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    @Override
    public String toString() {
        return "AccessCard{" +
                "id=" + id +
//                ", employee=" + employee +
                ", isActive=" + isActive +
                ", issuedDate=" + issuedDate +
                ", firmwareVersion='" + firmwareVersion + '\'' +
                '}';
    }

    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
