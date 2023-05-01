package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee employee2 = entityManager.find(Employee.class,2);
//        Employee employee3 = entityManager.find(Employee.class,9);
        System.out.println(employee2);
//        employee2.setAge(17);
//        System.out.println(employee2);
        //update operation is based on primary key id here.If this id doesn't exist for a record then a new row is created else row is just updated.
//        System.out.println(employee2);
//        System.out.println(employee3);
//        Employee employee = new Employee();
//        Employee employee1 = new Employee();
//        employee.setId(3);
//        employee.setName("Kuch Bhi7");
//        employee.setDob(new Date());
//        employee.setSsn("dc");
//        employee.setType(EmployeeType.PART_TIME);
//        employee.setAge(10);
////        employee1.setId(4);
//        employee1.setName("Kuch Bhi8");
//        employee1.setDob(new Date());
//        employee1.setSsn("dsc");
//        employee1.setType(EmployeeType.PART_TIME);
//        employee1.setAge(11);
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
//        entityManager.persist(employee);
        entityManager.remove(employee2);
        transaction.commit();
//        jdbc:h2:~/test
    }
}