package Utility;

import Model.Files;
import Model.LawCases;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class PersistenceUtils {

    private EntityManagerFactory emf;
    private EntityManager entityManager;
    private EntityTransaction transaction;

    public PersistenceUtils(String persistanceUnit){
        emf = Persistence.createEntityManagerFactory(persistanceUnit);
        entityManager = emf.createEntityManager();
        transaction = entityManager.getTransaction();
    }

    public EntityManager getEntityManager(){
        return entityManager;
    }

    public void save(LawCases lawCase){
        transaction.begin();
        entityManager.persist(lawCase);
        transaction.commit();
    }

    public void save(Files file){
        transaction.begin();
        entityManager.persist(file);
        transaction.commit();
    }
    public List<LawCases> findByRegNumber(String regNumber) {


        return entityManager.createQuery(
                "SELECT u from LawCases u WHERE u.regNumber =:regNumber",LawCases.class)
                .setParameter("regNumber",regNumber).getResultList();

    }
    public List<LawCases> findByDate(Date date){

         return entityManager.createQuery(
                 "SELECT u from LawCases u WHERE u.date =:date",LawCases.class)
                 .setParameter("date",date).getResultList();

    }

    public void deleteById(int id){
        transaction.begin();
        entityManager.createQuery("delete from LawCases e where e.id = :id")
                .setParameter("id", id).executeUpdate();
        transaction.commit();

    }
    public LawCases findById(int id){
        return entityManager.find(LawCases.class,id);
    }

    public Files findFilesById(int id){
        return entityManager.find(Files.class,id);
    }


    public List<Files> searchFilesByName(String fileName){
        return entityManager.createQuery(
                "select at from Files at where at.name LIKE :fileName",Files.class)
               .setParameter("fileName", "%"+fileName+"%").getResultList();
    }





}
