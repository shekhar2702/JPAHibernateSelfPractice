package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class EmployeeCreation {

    public static void main(String args[]) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AccessCard card = new AccessCard();
        Employee employee = new Employee();
        employee.setName("Kuch Bhi8");
        employee.setDob(new Date());
        employee.setSsn("dsc");
        employee.setType(EmployeeType.PART_TIME);
        employee.setAge(11);
        card.setActive(true);
        card.setIssuedDate(new Date());
        card.setFirmwareVersion("qqqqq");
        employee.setAccessCard(card);
        card.setEmployee(employee);
//        Employee employee = entityManager.find(Employee.class,2);
//        employee.setAccessCard(entityManager.find(AccessCard.class,35));
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(employee);
        entityManager.persist(card);
        transaction.commit();
    }

}
