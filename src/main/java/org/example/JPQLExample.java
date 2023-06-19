package org.example;

import javax.persistence.*;
import java.util.List;

public class JPQLExample {

    public static void main(String args[]) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        Query query = entityManager.createQuery("select e from Employee e order by e.name desc");
//        List<Object> results = query.getResultList();

        //Another way of fetching the object using typequery,with this we are getting particular entity object(in this case Employee) instead of a generic object.
//        TypedQuery<Object[]> query = entityManager.createQuery("select e.name,e.age,e.accessCard from Employee e",Object[].class);
        TypedQuery<Employee> query = entityManager.createNamedQuery("kuchBhi",Employee.class);
//        List<Object[]> results = query.getResultList();
//        results.forEach(result -> System.out.println(result[0] + " " + result[1] + " " + result[2]));
        List<Employee> results = query.getResultList();
        results.forEach(System.out :: println);
        entityManager.close();
        entityManagerFactory.close();



    }

}
