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
//            AccessCard card1 = new AccessCard();
//            card1.setActive(true);
//            card1.setIssuedDate(new Date());
//            card1.setFirmwareVersion("qqqqq");
//        Employee employee = entityManager.find(Employee.class,1);
//        System.out.println("got employee");
//        System.out.println(employee.getEmailGroups());
//        PaySlip paySlip = entityManager.find(PaySlip.class,2);
//        System.out.println("(((((((((((((((((((((((((");
//        System.out.println(paySlip);
//        System.out.println(paySlip);

//        System.out.println(")))))))))))))))))))))))))");
//        System.out.println(card.getEmployees());
//        AccessCard card2 = entityManager.find(AccessCard.class,68);

//       System.out.println(card2);
//        card2.setActive(false);
//        card2.setIssuedDate(new Date());
//        card2.setFirmwareVersion("kuch bhi 112");
////        AccessCard card = entityManager.find(AccessCard.class,5);
////        Employee employee = entityManager.find(Employee.class,34);
//
//        EmailGroup emailGroup = new EmailGroup();
//        emailGroup.setGroupName("first group");
//        EmailGroup emailGroup1 = new EmailGroup();
//        emailGroup1.setGroupName("Second email group");
        Employee employee = new Employee();
        employee.setName("annnnn");
        employee.setDob(new Date());
        employee.setSsn("dcwzzdwc");
        employee.setType(EmployeeType.FULL_TIME);
        employee.setAge(20);
//        Employee employee1 = new Employee();
//        employee1.setName("qwerty");
//        employee1.setDob(new Date());
//        employee1.setSsn("dcwdswc");
//        employee1.setType(EmployeeType.PART_TIME);
//        employee1.setAge(10);
//        employee1.addEmployeeToEmailGroup(emailGroup);
//        employee1.addEmployeeToEmailGroup(emailGroup1);
//        emailGroup.addEmployeeToEmailGroup(employee1);
//        emailGroup1.addEmployeeToEmailGroup(employee1);
//        employee.addEmployeeToEmailGroup(emailGroup1);
//        emailGroup1.addEmployeeToEmailGroup(employee);
//        employee.setAccessCard(card1);
////        card1.setEmployees(employee);//this is a good practice to have although its not necessary because we never know when will a data be persisted in db and until that time the access card here will have no employee associated to it and will give null.
//        // Although once data gets persisted in employee table then in the future transaction it will never be null.
//        PaySlip paySlip = new PaySlip();
//        paySlip.setEmployees(employee);
//        System.out.println("Data test------------------------");
//        System.out.println(employee.getAccessCard());
//        System.out.println(card1.getEmployees());

//        Employee employee2 = entityManager.find(Employee.class,2);
////        Employee employee3 = entityManager.find(Employee.class,9);
//        System.out.println(employee2);
//        employee2.setAge(17);
//        System.out.println(employee2);
        //update operation is based on primary key id here.If this id doesn't exist for a record then a new row is created else row is just updated.
//        System.out.println(employee2);
//        System.out.println(employee3);
//        Employee employee = new Employee();
//        Employee employee = new Employee();
////        employee.setId(3);
//        employee.setName("Kuch Bhi90");
//        employee.setDob(new Date());
//        employee.setSsn("dcc");
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


//        Employee employee = entityManager.find(Employee.class,1);
//        PaySlip paySlip = new PaySlip();
          EmailGroup emailGroup = entityManager.find(EmailGroup.class,3);
//        paySlip.setEmployee(employee);

//        EmailGroup emailGroup = entityManager.find(EmailGroup.class,3);
//        employee.addEmployeeToEmailGroup(emailGroup);
//        emailGroup.addEmployeeToEmailGroup(employee);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
//        entityManager.remove(emailGroup);
//        entityManager.persist(paySlip);
        entityManager.persist(employee);
//        entityManager.persist(emailGroup);
//        entityManager.persist(emailGroup1);
//        entityManager.persist(card1);
//        entityManager.persist(paySlip);

        /*persistence context as 1st level cache
        *JPA maintains a cache wherein all the inserts/updates are saved before it actually saves to db.
        * Although these updated/newly created rows aren't effected in the db we can still retrieve them using java objects.
        * So in above case lets say we create a nw employee and persist it ,even if we try to retrieve the persisted employee
        * before it actually got persisted in db we will get the employee object without any problems
        * because of the persistence context which works as a cache.
        */

        /*
        * Entity lifecycle
        * 1. Transient(Entity has not been yet picked by JPA to manage) -> 2. Manged(Entity is picked up by JPA and JPA now managing it in persistence context).
        * The above lifecycle transition from 1 -> 2 happens while persisting an entity in the db
        * However,while fetching an entity from the db,the entity is 1st in the managed state and then it goes into transient state.
         */

        /*
        * Detached and Removed are also entity transition states while dealing with removal of an entity from the anaged state.
        * remove(entity) moves entity from managed to removed state by removing the entity from the persistence context.
        * it can be brought back by calling persist(entity) again
        * Remember,any entity which aren't in managed state is going to get saved in db.
        * In order to force save an entity right when we want it to get saved in db we can use the flush(entity),which updates the entity in the db whenever its called.
        * Detach state is another state wherein an entity is removed fro the managed state,however here in order to bring it back to manged state we use the method merge(entity)
         */
        /*
        * clear() method is similar to detach(entity) method but clear() clears out all the entities in the managed state whereas detach only clears the passed entity in the argument.
        * refresh(entity) makes sure to update the managed entity with whatever is there i the db,thereby fetching the latest state from the db and removing the stale/dirty/changed state of managed entity.
        *
        */



        transaction.commit();
//        jdbc:h2:~/test
    }
}